package com.nju.groupPurchaseManagementSystem.core;

import com.nju.groupPurchaseManagementSystem.ConfigInfos;
import com.nju.groupPurchaseManagementSystem.bankSystemMQ.TransferMessageSender;
import com.nju.groupPurchaseManagementSystem.core.vo.*;
import com.nju.groupPurchaseManagementSystem.smsService.ShortMessageSender;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Srf on 2017/6/24
 */

@Component
public class GroupPurchaseCoreImpl implements GroupPurchaseCore {

    @Resource
    private TransferMessageSender bankSystem;
    private ShortMessageSender shortMessageSender;

    private List<GroupPurchaseItem> groupPurchaseItems;
    private Map<String, GroupPurchaseItem> groupPurchaseItemLookup;
    private Map<String, GroupPurchaseOrder> groupPurchaseOrders;
    private static Map<String, String> secretKeyLookup;
    private static Map<String, String> sellerLookup;
    private static Map<String, String> sellerBankAccount;
    private static final String SYSTEM_BANK_ACCOUNT = "system";
    private static final String SYSTEM_BANK_PASS = "123";

    public GroupPurchaseCoreImpl() {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(ShortMessageSender.class);
        factoryBean.setAddress(ConfigInfos.SMSAddress);
        this.shortMessageSender = (ShortMessageSender)factoryBean.create();
        System.out.println("SMS start");
        this.groupPurchaseItems = new ArrayList<>();
        this.groupPurchaseOrders = new HashMap<>();
        this.groupPurchaseItemLookup = new HashMap<>();
        if (secretKeyLookup == null)
        {
            secretKeyLookup = new HashMap<>();
            sellerLookup = new HashMap<>();
            sellerBankAccount = new HashMap<>();
            secretKeyLookup.put("Seller A", "_seller_a_s3cret_k3y");
            sellerLookup.put("_seller_a_s3cret_k3y", "Seller A");
            sellerBankAccount.put("_seller_a_s3cret_k3y", "seller");
        }
    }

    public List<GroupPurchaseItem> listGroupPurchase()
    {
        return this.groupPurchaseItems;
    }

    public boolean submitPurchase(String itemId, String bankAccount, String password, String phone)
    {
        if ((itemId == null) || (itemId.isEmpty()))
        {
            System.out.println("submitPurchase: Empty item id!");
            return false;
        }
        if ((bankAccount == null) || (bankAccount.isEmpty()))
        {
            System.out.println("submitPurchase: Empty bank account!");
            return false;
        }
        if ((password == null) || (password.isEmpty()))
        {
            System.out.println("submitPurchase: Empty password!");
            return false;
        }
        if ((phone == null) || (phone.isEmpty()))
        {
            System.out.println("submitPurchase: Empty phone number!");
            return false;
        }
        GroupPurchaseItem item = null;
        for (GroupPurchaseItem i : this.groupPurchaseItems) {
            if (itemId.equalsIgnoreCase(i.getId()))
            {
                item = i;
                break;
            }
        }
        if (item == null) {
            return false;
        }
        if (!this.bankSystem.transfer(bankAccount, password, "system", item.getPrice())) {
            return false;
        }
        String confirm;
        do
        {
            confirm = String.format("%d", System.currentTimeMillis() % 1000000L);
        } while (this.groupPurchaseOrders.containsKey(confirm));
        GroupPurchaseOrder order = new GroupPurchaseOrder();
        order.setConfirm(confirm);
        order.setItem(item);
        this.groupPurchaseOrders.put(confirm, order);

        return this.shortMessageSender.sendMessage(phone, "Your confirm code is: " + confirm);
    }

    public boolean publishGroupPurchaseItem(String sellerSecretKey, String productName, String introduction, double price, int limit)
    {
        if ((sellerSecretKey == null) || (!sellerLookup.containsKey(sellerSecretKey)))
        {
            System.out.println("publishGroupPurchaseItem: Invalid seller secret key, permission denied.");
            return false;
        }
        if ((productName == null) || (productName.isEmpty()))
        {
            System.out.println("publishGroupPurchaseItem: Product name should not be empty!");
            return false;
        }
        if (price < 0.0D)
        {
            System.out.println("publishGroupPurchaseItem: price should never be below 0!");
            return false;
        }
        if (limit < 0) {
            limit = 0;
        }
        String id;
        do
        {
            id = String.format("%d", System.currentTimeMillis() % 1000000L);
        } while (this.groupPurchaseItemLookup.containsKey(id));
        GroupPurchaseItem item = new GroupPurchaseItem();
        item.setId(id);
        item.setIntroduction(introduction);
        item.setLimit(limit);
        item.setPrice(price);
        item.setProductName(productName);
        item.setSeller(sellerLookup.get(sellerSecretKey));
        this.groupPurchaseItems.add(item);
        this.groupPurchaseItemLookup.put(id, item);
        return true;
    }

    public boolean confirmPurchase(String sellerSecretKey, String confirm)
    {
        if ((sellerSecretKey == null) || (!sellerLookup.containsKey(sellerSecretKey)))
        {
            System.out.println("confirmPurchase: Invalid seller secret key, permission denied.");
            return false;
        }
        if ((confirm == null) || (!this.groupPurchaseOrders.containsKey(confirm)))
        {
            System.out.println("confirmPurchase: Invalid confirm code.");
            return false;
        }
        GroupPurchaseOrder order = this.groupPurchaseOrders.get(confirm);
        if (!confirm.equals(order.getConfirm()))
        {
            System.out.println("confirmPurchase: Invalid confirm code.");
            return false;
        }
        if (!sellerSecretKey.equals(secretKeyLookup.get(order.getItem().getSeller())))
        {
            System.out.println("confirmPurchase: Seller not matched!");
            return false;
        }
        if (!this.bankSystem.transfer(SYSTEM_BANK_ACCOUNT, SYSTEM_BANK_PASS, sellerBankAccount.get(sellerSecretKey), order.getItem().getPrice()))
        {
            System.out.println("confirmPurchase: Fail to pay to the seller.");
            return false;
        }
        this.groupPurchaseOrders.remove(confirm);
        return true;
    }

}

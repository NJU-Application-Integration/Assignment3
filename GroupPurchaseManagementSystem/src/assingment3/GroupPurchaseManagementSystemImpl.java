/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import assingment3.BankSystem;

class GroupPurchaseManagementSystemImpl extends UnicastRemoteObject
		implements
			GroupPurchaseManagementSystem {
	private static final long serialVersionUID = -645960813211232810L;
	private ShortMessageSender shortMessageSender;
	private BankSystem bankSystem;
	private List<GroupPurchaseItem> groupPurchaseItems;
	private Map<String, GroupPurchaseItem> groupPurchaseItemLookup;
	private Map<String, GroupPurchaseOrder> groupPurchaseOrders;
	private static Map<String, String> secretKeyLookup;
	private static Map<String, String> sellerLookup;
	private static Map<String, String> sellerBankAccount;
	private static final String SYSTEM_BANK_ACCOUNT = "system";
	private static final String SYSTEM_BANK_PASS = "123";

	public GroupPurchaseManagementSystemImpl(
			ShortMessageSender shortMessageSender, BankSystem bankSystem) throws java.rmi.RemoteException  {
		this.shortMessageSender = shortMessageSender;
		this.bankSystem = bankSystem;
		this.groupPurchaseItems = new ArrayList();
		this.groupPurchaseOrders = new HashMap();
		this.groupPurchaseItemLookup = new HashMap();
		if (secretKeyLookup == null) {
			secretKeyLookup = new HashMap();
			sellerLookup = new HashMap();
			sellerBankAccount = new HashMap();
			secretKeyLookup.put("Seller A", "_seller_a_s3cret_k3y");
			sellerLookup.put("_seller_a_s3cret_k3y", "Seller A");
			sellerBankAccount.put("_seller_a_s3cret_k3y", "seller");
		}
	}

	public List<GroupPurchaseItem> listGroupPurchase() throws java.rmi.RemoteException {
		return this.groupPurchaseItems;
	}

	public boolean submitPurchase(String itemId, String bankAccount,
			String password, String phone) throws java.rmi.RemoteException {
		if ((itemId == null) || (itemId.isEmpty())) {
			System.out.println("submitPurchase: Empty item id!");
			return false;
		}
		if ((bankAccount == null) || (bankAccount.isEmpty())) {
			System.out.println("submitPurchase: Empty bank account!");
			return false;
		}
		if ((password == null) || (password.isEmpty())) {
			System.out.println("submitPurchase: Empty password!");
			return false;
		}
		if ((phone == null) || (phone.isEmpty())) {
			System.out.println("submitPurchase: Empty phone number!");
			return false;
		}

		GroupPurchaseItem item = null;
		for (GroupPurchaseItem i : this.groupPurchaseItems) {
			if (itemId.equalsIgnoreCase(i.getId())) {
				item = i;
				break;
			}
		}
		if (item == null) {
			return false;
		}

		if (!(this.bankSystem.transfer(bankAccount, password, "system",
				item.getPrice()))) {
			return false;
		}

		String confirm = null;
		do
			confirm = String.format("%d", new Object[]{Long.valueOf(System
					.currentTimeMillis() % 1000000L)});
		while (this.groupPurchaseOrders.containsKey(confirm));

		GroupPurchaseOrder order = new GroupPurchaseOrder();
		order.setComfirm(confirm);
		order.setItem(item);
		this.groupPurchaseOrders.put(confirm, order);

		JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();  
        factoryBean.setServiceClass(ShortMessageSender.class);  
        factoryBean.setAddress("http://localhost:8080/SMSender");  
        this.shortMessageSender = (ShortMessageSender)factoryBean.create(); 
        
		return this.shortMessageSender.sendMessage(phone,
				"Your confirm code is: " + confirm);
	}

	public boolean publishGroupPurchaseItem(String sellerSecretKey,
			String productName, String introduction, double price, int limit) throws java.rmi.RemoteException  {
		if ((sellerSecretKey == null)
				|| (!(sellerLookup.containsKey(sellerSecretKey)))) {
			System.out
					.println("publishGroupPurchaseItem: Invalid seller secret key, permission denied.");
			return false;
		}
		if ((productName == null) || (productName.isEmpty())) {
			System.out
					.println("publishGroupPurchaseItem: Product name should not be empty!");
			return false;
		}
		if (price < 0.0D) {
			System.out
					.println("publishGroupPurchaseItem: price should never be below 0!");
			return false;
		}
		if (limit < 0) {
			limit = 0;
		}

		String id = null;
		do
			id = String.format("%d", new Object[]{Long.valueOf(System
					.currentTimeMillis() % 1000000L)});
		while (this.groupPurchaseItemLookup.containsKey(id));

		GroupPurchaseItem item = new GroupPurchaseItem();
		item.setId(id);
		item.setProductName(productName);
		item.setLimit(limit);
		item.setPrice(price);
		item.setProductName(productName);
		item.setSeller((String) sellerLookup.get(sellerSecretKey));
		this.groupPurchaseItems.add(item);
		this.groupPurchaseItemLookup.put(id, item);
		return true;
	}

	public boolean confirmPurchase(String sellerSecretKey, String confirm) throws java.rmi.RemoteException  {
		if ((sellerSecretKey == null)
				|| (!(sellerLookup.containsKey(sellerSecretKey)))) {
			System.out
					.println("confirmPurchase: Invalid seller secret key, permission denied.");
			return false;
		}
		if ((confirm == null)
				|| (!(this.groupPurchaseOrders.containsKey(confirm)))) {
			System.out.println("confirmPurchase: Invalid confirm code.");
			return false;
		}
		GroupPurchaseOrder order = (GroupPurchaseOrder) this.groupPurchaseOrders
				.get(confirm);
		if (!(confirm.equals(order.getComfirm()))) {
			System.out.println("confirmPurchase: Invalid confirm code.");
			return false;
		}
		if (!(sellerSecretKey.equals(secretKeyLookup.get(order.getItem()
				.getSeller())))) {
			System.out.println("confirmPurchase: Seller not matched!");
			return false;
		}

		if (!(this.bankSystem.transfer("system", "123",
				(String) sellerBankAccount.get(sellerSecretKey), order
						.getItem().getPrice()))) {
			System.out.println("confirmPurchase: Fail to pay to the seller.");
			return false;
		}

		this.groupPurchaseOrders.remove(confirm);
		return true;
	}
}

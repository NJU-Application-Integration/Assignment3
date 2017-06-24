package com.nju.groupPurchaseManagementSystem.retailCorba;

import com.nju.groupPurchaseManagementSystem.core.GroupPurchaseCore;
import com.nju.groupPurchaseManagementSystem.retailCorba.rsInterface.RetailSystemServicePOA;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Srf on 2017/6/24
 */

public class RetailSystemServiceImpl extends RetailSystemServicePOA{

    @Resource
    private GroupPurchaseCore core;

    @Override
    public boolean confirmPurchase(String sk, String confirmCode) {
        return core.confirmPurchase(sk, confirmCode);
    }

    @Override
    public boolean publishGroupPurchaseItem(String sk, String productName, String introduction, double price, int limit) {
        return core.publishGroupPurchaseItem(sk, productName, introduction, price, limit);
    }

}

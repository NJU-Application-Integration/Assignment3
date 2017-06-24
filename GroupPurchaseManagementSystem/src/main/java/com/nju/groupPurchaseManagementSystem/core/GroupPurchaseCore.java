package com.nju.groupPurchaseManagementSystem.core;

import assignment3.GroupPurchaseItem;

import java.util.List;

/**
 * Created by Srf on 2017/6/23
 */

public interface GroupPurchaseCore {

    boolean confirmPurchase(String paramString1, String paramString2);

    List<GroupPurchaseItem> listGroupPurchase();

    boolean publishGroupPurchaseItem(String paramString1, String paramString2, String paramString3, double paramDouble, int paramInt);

    boolean submitPurchase(String paramString1, String paramString2, String paramString3, String paramString4);

}

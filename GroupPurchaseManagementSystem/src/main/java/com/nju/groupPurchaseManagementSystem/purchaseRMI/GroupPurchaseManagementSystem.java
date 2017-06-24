package com.nju.groupPurchaseManagementSystem.purchaseRMI;

import com.nju.groupPurchaseManagementSystem.core.vo.GroupPurchaseItem;

import java.util.List;

/**
 * Created by Srf on 2017/6/24
 */
public interface GroupPurchaseManagementSystem {

    List<GroupPurchaseItem> listGroupPurchase ();

    boolean submitPurchase(String paramString1, String paramString2, String paramString3, String paramString4);

}

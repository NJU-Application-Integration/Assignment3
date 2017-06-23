package com.nju.groupPurchaseManagementSystem.core;

import com.nju.groupPurchaseManagementSystem.core.vo.GroupPurchaseItem;

import java.util.List;

/**
 * Created by Srf on 2017/6/23
 */

public interface GroupPurchaseCore {

    public boolean confirmPurchase(String paramString1, String paramString2);

    public List<GroupPurchaseItem> listGroupPurchase();

    public boolean publishGroupPurchaseItem(String paramString1, String paramString2, String paramString3, double paramDouble, int paramInt);

    public boolean submitPurchase(String paramString1, String paramString2, String paramString3, String paramString4);

}

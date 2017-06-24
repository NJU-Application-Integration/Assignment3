package com.nju.groupPurchaseManagementSystem.purchaseRMI;

import com.nju.groupPurchaseManagementSystem.core.GroupPurchaseCore;
import com.nju.groupPurchaseManagementSystem.core.vo.GroupPurchaseItem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Srf on 2017/6/24
 */

@Component
public class GroupPurchaseManagementSystemImpl implements GroupPurchaseManagementSystem {

    @Resource
    private GroupPurchaseCore core;

    @Override
    public List<GroupPurchaseItem> listGroupPurchase() {
        return core.listGroupPurchase();
    }

    @Override
    public boolean submitPurchase(String paramString1, String paramString2, String paramString3, String paramString4) {
        return core.submitPurchase(paramString1, paramString2, paramString3, paramString4);
    }

}

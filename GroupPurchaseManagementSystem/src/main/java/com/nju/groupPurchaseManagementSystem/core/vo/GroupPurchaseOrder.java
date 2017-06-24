package com.nju.groupPurchaseManagementSystem.core.vo;

import assignment3.GroupPurchaseItem;

/**
 * Created by Srf on 2017/6/23
 */

public class GroupPurchaseOrder {
    private String confirm;
    private GroupPurchaseItem item;

    public String getConfirm() {
        return this.confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public GroupPurchaseItem getItem() {
        return this.item;
    }

    public void setItem(GroupPurchaseItem item) {
        this.item = item;
    }
}

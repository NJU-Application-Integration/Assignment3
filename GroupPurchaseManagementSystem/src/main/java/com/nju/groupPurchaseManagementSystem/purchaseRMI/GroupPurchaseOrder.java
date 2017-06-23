/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.nju.groupPurchaseManagementSystem.purchaseRMI;

class GroupPurchaseOrder {
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
/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.nju.groupPurchaseManagementSystem.purchaseRMI;

import com.nju.groupPurchaseManagementSystem.smsService.ShortMessageSender;

import java.rmi.RemoteException;



public class GroupPurchaseManagementSystemFactory {
	public static GroupPurchaseManagementSystem createGroupPurchaseManagementSystem(
			) throws RemoteException {
		return new GroupPurchaseManagementSystemImpl();
	}
}

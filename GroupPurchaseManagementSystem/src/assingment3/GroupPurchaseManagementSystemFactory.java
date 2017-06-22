/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assignment3;

import java.rmi.RemoteException;

import assignment3.ShortMessageSender;
import assingment3.BankSystem;

public class GroupPurchaseManagementSystemFactory {
	public static GroupPurchaseManagementSystem createGroupPurchaseManagementSystem(
			ShortMessageSender sms, BankSystem bank) throws RemoteException {
		return new GroupPurchaseManagementSystemImpl(sms, bank);
	}
}

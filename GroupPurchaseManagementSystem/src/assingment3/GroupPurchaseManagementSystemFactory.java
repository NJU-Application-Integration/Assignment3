/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assingment3;

import assignment3.ShortMessageSender;


public class GroupPurchaseManagementSystemFactory {
	public static GroupPurchaseManagementSystem createGroupPurchaseManagementSystem(
			ShortMessageSender sms, BankSystem bank) {
		return new GroupPurchaseManagementSystemImpl(sms, bank);
	}
}
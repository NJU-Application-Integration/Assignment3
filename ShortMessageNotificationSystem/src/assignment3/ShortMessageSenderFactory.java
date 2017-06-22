/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assignment3;

public class ShortMessageSenderFactory {
	private static ShortMessageSender smsender;

	public static ShortMessageSender createShortMessageSender() {
		if (smsender == null) {
			smsender = new SMSenderImpl();
		}
		return smsender;
	}
}
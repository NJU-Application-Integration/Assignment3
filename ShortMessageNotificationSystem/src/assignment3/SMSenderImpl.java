/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assignment3;

import javax.jws.WebService;

@WebService(endpointInterface="assignment3.ShortMessageSender",serviceName="SMSender")
class SMSenderImpl implements ShortMessageSender {
	public boolean sendMessage(String receiver, String msg) {
		System.out.printf(
				"################\nMessage Sent to %s\nContent\n%s\n",
				new Object[]{receiver, msg});
		return true;
	}
}
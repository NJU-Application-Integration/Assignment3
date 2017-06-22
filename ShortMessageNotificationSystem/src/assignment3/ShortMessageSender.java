/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assignment3;

import javax.jws.WebService;

@WebService  
public abstract interface ShortMessageSender {
	public abstract boolean sendMessage(String paramString1, String paramString2);
}
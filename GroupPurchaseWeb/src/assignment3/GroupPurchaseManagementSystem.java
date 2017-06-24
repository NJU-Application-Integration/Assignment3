/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assignment3;

import java.util.List;
import java.rmi.Remote;

public interface GroupPurchaseManagementSystem extends Remote {

	List<GroupPurchaseItem> listGroupPurchase() throws java.rmi.RemoteException;

	boolean submitPurchase(String paramString1, String paramString2, String paramString3,
			String paramString4) throws java.rmi.RemoteException;

}
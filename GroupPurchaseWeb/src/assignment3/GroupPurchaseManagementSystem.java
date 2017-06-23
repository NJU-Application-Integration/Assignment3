/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assignment3;

import java.util.List;
import java.rmi.Remote;

public abstract interface GroupPurchaseManagementSystem extends Remote {
	public abstract boolean confirmPurchase(String paramString1, String paramString2) throws java.rmi.RemoteException;

	public abstract List<GroupPurchaseItem> listGroupPurchase() throws java.rmi.RemoteException;

	public abstract boolean publishGroupPurchaseItem(String paramString1, String paramString2, String paramString3,
			double paramDouble, int paramInt) throws java.rmi.RemoteException;

	public abstract boolean submitPurchase(String paramString1, String paramString2, String paramString3,
			String paramString4) throws java.rmi.RemoteException;
}
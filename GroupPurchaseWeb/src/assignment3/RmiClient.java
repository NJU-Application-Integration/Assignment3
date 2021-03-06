package assignment3;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class RmiClient {
	/**
	 * For GroupPurchaseWeb side to invoke the service
	 * @return
	 */
	public GroupPurchaseManagementSystem getGroupPurchaseManagementSystem() {
		try {
			GroupPurchaseManagementSystem gpms = (GroupPurchaseManagementSystem) Naming
					.lookup("rmi://192.168.1.112:1099/rmiService");
			System.out.println(gpms.listGroupPurchase().get(0).getProductName());
			return gpms;
		} catch (MalformedURLException murle) {
			System.out.println();
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println();
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println();
			System.out.println("NotBoundException");
			System.out.println(nbe);
		} catch (java.lang.ArithmeticException ae) {
			System.out.println();
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		}
		return null;
	}
}

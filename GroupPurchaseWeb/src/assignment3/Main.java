package assignment3;
import java.rmi.RemoteException;

import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseManagementSystemImpl;

public class Main {

	public static void main(String [] args){
			RmiClient rmiClient=new RmiClient();
			GroupPurchaseWeb.launch(rmiClient.getGroupPurchaseManagementSystem());
	}
}

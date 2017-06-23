package assignment3;
import java.rmi.RemoteException;

import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseManagementSystemImpl;

public class Main {

	public static void main(String [] args){
		ShortMessageSender sms = ShortMessageSenderFactory.createShortMessageSender();
		
		
		GroupPurchaseManagementSystem gpms;
		
		try {
			gpms = new GroupPurchaseManagementSystemImpl(sms,null);
			RmiStarter rmiStarter=new RmiStarter(gpms);
			RmiClient rmiClient=new RmiClient();
			GroupPurchaseWeb.launch(rmiClient.getGroupPurchaseManagementSystem());
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

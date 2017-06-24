package assignment3;

public class Main {

	public static void main(String [] args){
			RmiClient rmiClient=new RmiClient();
			GroupPurchaseWeb.launch(rmiClient.getGroupPurchaseManagementSystem());
	}
}

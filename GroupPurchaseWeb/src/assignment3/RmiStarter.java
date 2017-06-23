package assignment3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiStarter {
	
	public RmiStarter(GroupPurchaseManagementSystem gpms) {
		
		try {
			//注册通讯端口
			LocateRegistry.createRegistry(6600);
			//注册通讯路径
			Naming.rebind("rmi://127.0.0.1:6600/GroupPurchaseManagementSystemService", gpms);
			System.out.println("rmi bind successfully on 127.0.0.1:6600!");
			
		} catch (Exception e) {
			System.out.println("Trouble with rmiserver binding: " + e);
		}
	}
}

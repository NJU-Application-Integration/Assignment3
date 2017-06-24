package assignment3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Srf on 2017/6/24
 */

public interface GroupPurchaseManagementSystem extends Remote {

    List<GroupPurchaseItem> listGroupPurchase () throws RemoteException;

    boolean submitPurchase(String paramString1, String paramString2, String paramString3, String paramString4) throws RemoteException;

}

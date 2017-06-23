/*    */ package assignment3;

/*    */
/*    */ import java.awt.Window;
import java.rmi.RemoteException;

/*    */ import org.jdesktop.application.Application;
/*    */ import org.jdesktop.application.SingleFrameApplication;

/*    */
/*    */ class GroupPurchaseWebApp extends SingleFrameApplication
/*    */ {
	/*    */ private static GroupPurchaseManagementSystem groupPurchaseManagementSystem;

	/*    */
	/*    */ public static void setGroupPurchaseManagementSystem(GroupPurchaseManagementSystem gpms)
	/*    */ {
		/* 17 */ groupPurchaseManagementSystem = gpms;
		/*    */ }

	/*    */
	/*    */ protected void startup()
	/*    */ {
		/* 25 */ try {
			show(new GroupPurchaseWebView(this, groupPurchaseManagementSystem));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*    */ }

	/*    */
	/*    */ protected void configureWindow(Window root)
	/*    */ {
		/*    */ }

	/*    */
	/*    */ public static GroupPurchaseWebApp getApplication()
	/*    */ {
		/* 42 */ return (GroupPurchaseWebApp) Application.getInstance(GroupPurchaseWebApp.class);
		/*    */ }

	/*    */
	/*    */ public static void start()
	/*    */ {
		/* 49 */ String[] args = new String[0];
		/* 50 */ launch(GroupPurchaseWebApp.class, args);
		/*    */ }
	/*    */ }

/*
 * Location: /Users/GraceHan/Desktop/应用集成第三次作业/Systems/GroupPurchaseWeb.jar
 * Qualified Name: assignment3.GroupPurchaseWebApp JD-Core Version: 0.6.2
 */
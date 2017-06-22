/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package assingment3;

import java.util.List;

public abstract interface GroupPurchaseManagementSystem {
	public abstract boolean confirmPurchase(String paramString1,
			String paramString2);

	public abstract List<GroupPurchaseItem> listGroupPurchase();

	public abstract boolean publishGroupPurchaseItem(String paramString1,
			String paramString2, String paramString3, double paramDouble,
			int paramInt);

	public abstract boolean submitPurchase(String paramString1,
			String paramString2, String paramString3, String paramString4);
}
package assignment3;

import java.awt.Container;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.ResourceMap;

public class PurchaseConfirm extends JDialog {
	private GroupPurchaseItem item;
	private GroupPurchaseManagementSystem groupPurchaseManagementSystem;
	private JButton closeButton;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel lbIntro;
	private JLabel lbName;
	private JLabel lbPrice;
	private JButton purchaseBtn;
	private JTextField tbAccount;
	private JPasswordField tbPassword;
	private JTextField tbPhone;

	public PurchaseConfirm(Frame parent, GroupPurchaseManagementSystem gpms, GroupPurchaseItem item) {
		/* 14 */ super(parent);
		/* 15 */ initComponents();
		/* 16 */ this.item = item;
		/* 17 */ this.groupPurchaseManagementSystem = gpms;
		/* 18 */ this.lbIntro.setText(item.getIntroduction());
		/* 19 */ this.lbName.setText(item.getProductName());
		/* 20 */ this.lbPrice.setText(String.format("%.2f", new Object[] { Double.valueOf(item.getPrice()) }));
		/* 21 */ getRootPane().setDefaultButton(this.closeButton);
	}

	@Action
	public void closeAboutBox() {
		/* 26 */ dispose();
	}

	private void initComponents() {
		/* 37 */ this.closeButton = new JButton();
		/* 38 */ this.purchaseBtn = new JButton();
		/* 39 */ this.jLabel1 = new JLabel();
		/* 40 */ this.jLabel2 = new JLabel();
		/* 41 */ this.jLabel3 = new JLabel();
		/* 42 */ this.lbName = new JLabel();
		/* 43 */ this.lbPrice = new JLabel();
		/* 44 */ this.lbIntro = new JLabel();
		/* 45 */ this.jLabel4 = new JLabel();
		/* 46 */ this.jLabel5 = new JLabel();
		/* 47 */ this.tbAccount = new JTextField();
		/* 48 */ this.tbPassword = new JPasswordField();
		/* 49 */ this.jLabel6 = new JLabel();
		/* 50 */ this.tbPhone = new JTextField();

		/* 52 */ setDefaultCloseOperation(2);
		/* 53 */ setTitle("Purchase Item");
		/* 54 */ setModal(true);
		/* 55 */ setName("aboutBox");
		/* 56 */ setResizable(false);

		/* 58 */ ActionMap actionMap = ((GroupPurchaseWebApp) Application.getInstance(GroupPurchaseWebApp.class))
				.getContext().getActionMap(PurchaseConfirm.class, this);
		/* 59 */ this.closeButton.setAction(actionMap.get("closeAboutBox"));
		/* 60 */ ResourceMap resourceMap = ((GroupPurchaseWebApp) Application.getInstance(GroupPurchaseWebApp.class))
				.getContext().getResourceMap(PurchaseConfirm.class);
		/* 61 */ this.closeButton.setText(resourceMap.getString("closeButton.text", new Object[0]));
		/* 62 */ this.closeButton.setName("closeButton");

		/* 64 */ this.purchaseBtn.setText(resourceMap.getString("purchaseBtn.text", new Object[0]));
		/* 65 */ this.purchaseBtn.setName("purchaseBtn");
		/* 66 */ this.purchaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/* 68 */ try {
					PurchaseConfirm.this.purchaseBtnActionPerformed(evt);
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		/* 72 */ this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
		/* 73 */ this.jLabel1.setName("jLabel1");

		/* 75 */ this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
		/* 76 */ this.jLabel2.setName("jLabel2");

		/* 78 */ this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
		/* 79 */ this.jLabel3.setName("jLabel3");

		/* 81 */ this.lbName.setText(resourceMap.getString("lbName.text", new Object[0]));
		/* 82 */ this.lbName.setName("lbName");

		/* 84 */ this.lbPrice.setText(resourceMap.getString("lbPrice.text", new Object[0]));
		/* 85 */ this.lbPrice.setName("lbPrice");

		/* 87 */ this.lbIntro.setText(resourceMap.getString("lbIntro.text", new Object[0]));
		/* 88 */ this.lbIntro.setName("lbIntro");

		/* 90 */ this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
		/* 91 */ this.jLabel4.setName("jLabel4");

		/* 93 */ this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
		/* 94 */ this.jLabel5.setName("jLabel5");

		/* 96 */ this.tbAccount.setText(resourceMap.getString("tbAccount.text", new Object[0]));
		/* 97 */ this.tbAccount.setName("tbAccount");

		/* 99 */ this.tbPassword.setText(resourceMap.getString("tbPassword.text", new Object[0]));
		/* 100 */ this.tbPassword.setName("tbPassword");

		/* 102 */ this.jLabel6.setText(resourceMap.getString("jLabel6.text", new Object[0]));
		/* 103 */ this.jLabel6.setName("jLabel6");

		/* 105 */ this.tbPhone.setText(resourceMap.getString("tbPhone.text", new Object[0]));
		/* 106 */ this.tbPhone.setName("tbPhone");

		/* 108 */ GroupLayout layout = new GroupLayout(getContentPane());
		/* 109 */ getContentPane().setLayout(layout);
		/* 110 */ layout
				.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
										GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup().addGroup(
														layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																.addGroup(GroupLayout.Alignment.LEADING, layout
																		.createSequentialGroup().addGroup(layout
																				.createParallelGroup(
																						GroupLayout.Alignment.LEADING)
																				.addComponent(this.jLabel4)
																				.addComponent(this.jLabel3)
																				.addComponent(this.jLabel1)
																				.addComponent(
																						this.jLabel2)
																				.addComponent(this.jLabel5))
																		.addGap(18, 18, 18)
																		.addGroup(layout
																				.createParallelGroup(
																						GroupLayout.Alignment.LEADING)
																				.addComponent(this.lbIntro)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(1, 1, 1)
																								.addGroup(layout
																										.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																										.addComponent(
																												this.lbPrice)
																										.addComponent(
																												this.lbName)))
																				.addComponent(this.tbAccount, -1, 236,
																						32767)
																				.addComponent(this.tbPassword, -1, 236,
																						32767)
																				.addComponent(this.tbPhone, -1, 236,
																						32767)))
																.addComponent(this.purchaseBtn))
												.addGap(18, 18, 18).addComponent(this.closeButton))
										.addComponent(this.jLabel6))
								.addContainerGap()));

		/* 141 */ layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addComponent(this.jLabel1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel3))
						.addGroup(layout.createSequentialGroup().addComponent(this.lbName)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lbPrice)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lbIntro)))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4)
								.addComponent(this.tbAccount, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5)
								.addComponent(this.tbPassword, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6)
								.addComponent(this.tbPhone, -2, -1, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, 32767)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.closeButton).addComponent(this.purchaseBtn))
						.addContainerGap()));

		/* 177 */ pack();
	}

	private void purchaseBtnActionPerformed(ActionEvent evt) throws HeadlessException, RemoteException {
		if (this.groupPurchaseManagementSystem.submitPurchase(this.item.getId(), this.tbAccount.getText(),
				new String(this.tbPassword.getPassword()), this.tbPhone.getText())) {
			JOptionPane.showMessageDialog(this, "Successfully purchased!");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Purchase failed!");
		}
	}
}

/*
 * Location: /Users/GraceHan/Desktop/应用集成第三次作业/Systems/GroupPurchaseWeb.jar
 * Qualified Name: assignment3.PurchaseConfirm JD-Core Version: 0.6.2
 */
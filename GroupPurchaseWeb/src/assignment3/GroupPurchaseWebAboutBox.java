/*     */ package assignment3;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JRootPane;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import org.jdesktop.application.Action;
/*     */ import org.jdesktop.application.Application;
/*     */ import org.jdesktop.application.ApplicationContext;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ 
/*     */ public class GroupPurchaseWebAboutBox extends JDialog
/*     */ {
/*     */   private JButton closeButton;
/*     */ 
/*     */   public GroupPurchaseWebAboutBox(Frame parent)
/*     */   {
/*  12 */     super(parent);
/*  13 */     initComponents();
/*  14 */     getRootPane().setDefaultButton(this.closeButton);
/*     */   }
/*     */   @Action
/*     */   public void closeAboutBox() {
/*  18 */     dispose();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  29 */     this.closeButton = new JButton();
/*  30 */     JLabel appTitleLabel = new JLabel();
/*  31 */     JLabel versionLabel = new JLabel();
/*  32 */     JLabel appVersionLabel = new JLabel();
/*  33 */     JLabel vendorLabel = new JLabel();
/*  34 */     JLabel appVendorLabel = new JLabel();
/*  35 */     JLabel appDescLabel = new JLabel();
/*  36 */     JLabel imageLabel = new JLabel();
/*     */ 
/*  38 */     setDefaultCloseOperation(2);
/*  39 */     ResourceMap resourceMap = ((GroupPurchaseWebApp)Application.getInstance(GroupPurchaseWebApp.class)).getContext().getResourceMap(GroupPurchaseWebAboutBox.class);
/*  40 */     setTitle(resourceMap.getString("title", new Object[0]));
/*  41 */     setModal(true);
/*  42 */     setName("aboutBox");
/*  43 */     setResizable(false);
/*     */ 
/*  45 */     ActionMap actionMap = ((GroupPurchaseWebApp)Application.getInstance(GroupPurchaseWebApp.class)).getContext().getActionMap(GroupPurchaseWebAboutBox.class, this);
/*  46 */     this.closeButton.setAction(actionMap.get("closeAboutBox"));
/*  47 */     this.closeButton.setName("closeButton");
/*     */ 
/*  49 */     appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | 0x1, appTitleLabel.getFont().getSize() + 4));
/*  50 */     appTitleLabel.setText(resourceMap.getString("Application.title", new Object[0]));
/*  51 */     appTitleLabel.setName("appTitleLabel");
/*     */ 
/*  53 */     versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | 0x1));
/*  54 */     versionLabel.setText(resourceMap.getString("versionLabel.text", new Object[0]));
/*  55 */     versionLabel.setName("versionLabel");
/*     */ 
/*  57 */     appVersionLabel.setText(resourceMap.getString("Application.version", new Object[0]));
/*  58 */     appVersionLabel.setName("appVersionLabel");
/*     */ 
/*  60 */     vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | 0x1));
/*  61 */     vendorLabel.setText(resourceMap.getString("vendorLabel.text", new Object[0]));
/*  62 */     vendorLabel.setName("vendorLabel");
/*     */ 
/*  64 */     appVendorLabel.setText(resourceMap.getString("Application.vendor", new Object[0]));
/*  65 */     appVendorLabel.setName("appVendorLabel");
/*     */ 
/*  67 */     appDescLabel.setText(resourceMap.getString("appDescLabel.text", new Object[0]));
/*  68 */     appDescLabel.setName("appDescLabel");
/*     */ 
/*  70 */     imageLabel.setIcon(resourceMap.getIcon("imageLabel.icon"));
/*  71 */     imageLabel.setName("imageLabel");
/*     */ 
/*  73 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  74 */     getContentPane().setLayout(layout);
/*  75 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(imageLabel).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(versionLabel).addComponent(vendorLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(appVersionLabel).addComponent(appVendorLabel)).addGap(65, 65, 65)).addComponent(appTitleLabel, GroupLayout.Alignment.LEADING).addComponent(appDescLabel, GroupLayout.Alignment.LEADING, -1, 270, 32767).addComponent(this.closeButton)).addContainerGap()));
/*     */ 
/*  95 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(imageLabel, -2, -1, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(appTitleLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(appDescLabel, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(versionLabel).addComponent(appVersionLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(vendorLabel).addComponent(appVendorLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, 32767).addComponent(this.closeButton).addContainerGap()));
/*     */ 
/* 116 */     pack();
/*     */   }
/*     */ }

/* Location:           /Users/GraceHan/Desktop/应用集成第三次作业/Systems/GroupPurchaseWeb.jar
 * Qualified Name:     assignment3.GroupPurchaseWebAboutBox
 * JD-Core Version:    0.6.2
 */
/*     */ package assignment3;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
/*     */ import java.util.List;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.Timer;
/*     */ import org.jdesktop.application.Action;
/*     */ import org.jdesktop.application.Application;
/*     */ import org.jdesktop.application.ApplicationContext;
/*     */ import org.jdesktop.application.FrameView;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.jdesktop.application.SingleFrameApplication;
/*     */ import org.jdesktop.application.TaskMonitor;
/*     */ 
/*     */ public class GroupPurchaseWebView extends FrameView
/*     */ {
/*     */   private GroupPurchaseManagementSystem groupPurchaseManagementSystem;
/*     */   private List<GroupPurchaseItem> items;
/*     */   private JList itemList;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JPanel mainPanel;
/*     */   private JMenuBar menuBar;
/*     */   private JProgressBar progressBar;
/*     */   private JButton purchaseBtn;
/*     */   private JButton refreshBtn;
/*     */   private JLabel statusAnimationLabel;
/*     */   private JLabel statusMessageLabel;
/*     */   private JPanel statusPanel;
/*     */   private JSeparator statusPanelSeparator;
/*     */   private final Timer messageTimer;
/*     */   private final Timer busyIconTimer;
/*     */   private final Icon idleIcon;
/* 286 */   private final Icon[] busyIcons = new Icon[15];
/* 287 */   private int busyIconIndex = 0;
/*     */   private JDialog aboutBox;
/*     */ 
/*     */   private void updateList() throws RemoteException
/*     */   {
/*  28 */     this.items = this.groupPurchaseManagementSystem.listGroupPurchase();
/*  29 */     this.itemList.setModel(new AbstractListModel()
/*     */     {
/*     */       public int getSize() {
/*  32 */         return GroupPurchaseWebView.this.items.size();
/*     */       }
/*     */ 
/*     */       public Object getElementAt(int i) {
/*  36 */         return new GroupPurchaseWebView.ListItem(GroupPurchaseWebView.this, (GroupPurchaseItem)GroupPurchaseWebView.this.items.get(i));
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public GroupPurchaseWebView(SingleFrameApplication app, GroupPurchaseManagementSystem gpms) throws RemoteException {
/*  42 */     super(app);
/*  43 */     this.groupPurchaseManagementSystem = gpms;
/*  44 */     initComponents();
/*  45 */     updateList();
/*     */ 
/*  48 */     ResourceMap resourceMap = getResourceMap();
/*  49 */     int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
/*  50 */     this.messageTimer = new Timer(messageTimeout, new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  53 */         GroupPurchaseWebView.this.statusMessageLabel.setText("");
/*     */       }
/*     */     });
/*  56 */     this.messageTimer.setRepeats(false);
/*  57 */     int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
/*  58 */     for (int i = 0; i < this.busyIcons.length; i++) {
/*  59 */       this.busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
/*     */     }
/*  61 */     this.busyIconTimer = new Timer(busyAnimationRate, new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  64 */         GroupPurchaseWebView.this.busyIconIndex = ((GroupPurchaseWebView.this.busyIconIndex + 1) % GroupPurchaseWebView.this.busyIcons.length);
/*  65 */         GroupPurchaseWebView.this.statusAnimationLabel.setIcon(GroupPurchaseWebView.this.busyIcons[GroupPurchaseWebView.this.busyIconIndex]);
/*     */       }
/*     */     });
/*  68 */     this.idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
/*  69 */     this.statusAnimationLabel.setIcon(this.idleIcon);
/*  70 */     this.progressBar.setVisible(false);
/*     */ 
/*  73 */     TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
/*  74 */     taskMonitor.addPropertyChangeListener(new PropertyChangeListener()
/*     */     {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/*  77 */         String propertyName = evt.getPropertyName();
/*  78 */         if ("started".equals(propertyName)) {
/*  79 */           if (!GroupPurchaseWebView.this.busyIconTimer.isRunning()) {
/*  80 */             GroupPurchaseWebView.this.statusAnimationLabel.setIcon(GroupPurchaseWebView.this.busyIcons[0]);
/*  81 */             GroupPurchaseWebView.this.busyIconIndex = 0;
/*  82 */             GroupPurchaseWebView.this.busyIconTimer.start();
/*     */           }
/*  84 */           GroupPurchaseWebView.this.progressBar.setVisible(true);
/*  85 */           GroupPurchaseWebView.this.progressBar.setIndeterminate(true);
/*  86 */         } else if ("done".equals(propertyName)) {
/*  87 */           GroupPurchaseWebView.this.busyIconTimer.stop();
/*  88 */           GroupPurchaseWebView.this.statusAnimationLabel.setIcon(GroupPurchaseWebView.this.idleIcon);
/*  89 */           GroupPurchaseWebView.this.progressBar.setVisible(false);
/*  90 */           GroupPurchaseWebView.this.progressBar.setValue(0);
/*  91 */         } else if ("message".equals(propertyName)) {
/*  92 */           String text = (String)evt.getNewValue();
/*  93 */           GroupPurchaseWebView.this.statusMessageLabel.setText(text == null ? "" : text);
/*  94 */           GroupPurchaseWebView.this.messageTimer.restart();
/*  95 */         } else if ("progress".equals(propertyName)) {
/*  96 */           int value = ((Integer)evt.getNewValue()).intValue();
/*  97 */           GroupPurchaseWebView.this.progressBar.setVisible(true);
/*  98 */           GroupPurchaseWebView.this.progressBar.setIndeterminate(false);
/*  99 */           GroupPurchaseWebView.this.progressBar.setValue(value);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   @Action
/*     */   public void showAboutBox() {
/* 107 */     if (this.aboutBox == null) {
/* 108 */       JFrame mainFrame = GroupPurchaseWebApp.getApplication().getMainFrame();
/* 109 */       this.aboutBox = new GroupPurchaseWebAboutBox(mainFrame);
/* 110 */       this.aboutBox.setLocationRelativeTo(mainFrame);
/*     */     }
/* 112 */     GroupPurchaseWebApp.getApplication().show(this.aboutBox);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 124 */     this.mainPanel = new JPanel();
/* 125 */     this.jScrollPane1 = new JScrollPane();
/* 126 */     this.itemList = new JList();
/* 127 */     this.purchaseBtn = new JButton();
/* 128 */     this.refreshBtn = new JButton();
/* 129 */     this.menuBar = new JMenuBar();
/* 130 */     JMenu fileMenu = new JMenu();
/* 131 */     JMenuItem exitMenuItem = new JMenuItem();
/* 132 */     JMenu helpMenu = new JMenu();
/* 133 */     JMenuItem aboutMenuItem = new JMenuItem();
/* 134 */     this.statusPanel = new JPanel();
/* 135 */     this.statusPanelSeparator = new JSeparator();
/* 136 */     this.statusMessageLabel = new JLabel();
/* 137 */     this.statusAnimationLabel = new JLabel();
/* 138 */     this.progressBar = new JProgressBar();
/*     */ 
/* 140 */     this.mainPanel.setName("mainPanel");
/*     */ 
/* 142 */     this.jScrollPane1.setName("jScrollPane1");
/*     */ 
/* 144 */     this.itemList.setSelectionMode(0);
/* 145 */     this.itemList.setName("itemList");
/* 146 */     this.jScrollPane1.setViewportView(this.itemList);
/*     */ 
/* 148 */     ResourceMap resourceMap = ((GroupPurchaseWebApp)Application.getInstance(GroupPurchaseWebApp.class)).getContext().getResourceMap(GroupPurchaseWebView.class);
/* 149 */     this.purchaseBtn.setText(resourceMap.getString("purchaseBtn.text", new Object[0]));
/* 150 */     this.purchaseBtn.setName("purchaseBtn");
/* 151 */     this.purchaseBtn.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 153 */         GroupPurchaseWebView.this.purchaseBtnActionPerformed(evt);
/*     */       }
/*     */     });
/* 157 */     this.refreshBtn.setText(resourceMap.getString("refreshBtn.text", new Object[0]));
/* 158 */     this.refreshBtn.setName("refreshBtn");
/* 159 */     this.refreshBtn.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 161 */         try {
	GroupPurchaseWebView.this.refreshBtnActionPerformed(evt);
} catch (RemoteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
/*     */       }
/*     */     });
/* 165 */     GroupLayout mainPanelLayout = new GroupLayout(this.mainPanel);
/* 166 */     this.mainPanel.setLayout(mainPanelLayout);
/* 167 */     mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(mainPanelLayout.createSequentialGroup().addContainerGap().addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 380, 32767).addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup().addComponent(this.refreshBtn).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.purchaseBtn))).addContainerGap()));
/*     */ 
/* 179 */     mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 201, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.purchaseBtn).addComponent(this.refreshBtn)).addContainerGap()));
/*     */ 
/* 191 */     this.menuBar.setName("menuBar");
/*     */ 
/* 193 */     fileMenu.setText(resourceMap.getString("fileMenu.text", new Object[0]));
/* 194 */     fileMenu.setName("fileMenu");
/*     */ 
/* 196 */     ActionMap actionMap = ((GroupPurchaseWebApp)Application.getInstance(GroupPurchaseWebApp.class)).getContext().getActionMap(GroupPurchaseWebView.class, this);
/* 197 */     exitMenuItem.setAction(actionMap.get("quit"));
/* 198 */     exitMenuItem.setName("exitMenuItem");
/* 199 */     fileMenu.add(exitMenuItem);
/*     */ 
/* 201 */     this.menuBar.add(fileMenu);
/*     */ 
/* 203 */     helpMenu.setText(resourceMap.getString("helpMenu.text", new Object[0]));
/* 204 */     helpMenu.setName("helpMenu");
/*     */ 
/* 206 */     aboutMenuItem.setAction(actionMap.get("showAboutBox"));
/* 207 */     aboutMenuItem.setName("aboutMenuItem");
/* 208 */     helpMenu.add(aboutMenuItem);
/*     */ 
/* 210 */     this.menuBar.add(helpMenu);
/*     */ 
/* 212 */     this.statusPanel.setName("statusPanel");
/*     */ 
/* 214 */     this.statusPanelSeparator.setName("statusPanelSeparator");
/*     */ 
/* 216 */     this.statusMessageLabel.setName("statusMessageLabel");
/*     */ 
/* 218 */     this.statusAnimationLabel.setHorizontalAlignment(2);
/* 219 */     this.statusAnimationLabel.setName("statusAnimationLabel");
/*     */ 
/* 221 */     this.progressBar.setName("progressBar");
/*     */ 
/* 223 */     GroupLayout statusPanelLayout = new GroupLayout(this.statusPanel);
/* 224 */     this.statusPanel.setLayout(statusPanelLayout);
/* 225 */     statusPanelLayout.setHorizontalGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.statusPanelSeparator, -1, 400, 32767).addGroup(statusPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.statusMessageLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 226, 32767).addComponent(this.progressBar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.statusAnimationLabel).addContainerGap()));
/*     */ 
/* 237 */     statusPanelLayout.setVerticalGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(statusPanelLayout.createSequentialGroup().addComponent(this.statusPanelSeparator, -2, 2, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.statusMessageLabel).addComponent(this.statusAnimationLabel).addComponent(this.progressBar, -2, -1, -2)).addGap(3, 3, 3)));
/*     */ 
/* 249 */     setComponent(this.mainPanel);
/* 250 */     setMenuBar(this.menuBar);
/* 251 */     setStatusBar(this.statusPanel);
/*     */   }
/*     */ 
/*     */   private void purchaseBtnActionPerformed(ActionEvent evt) {
/* 255 */     if (this.itemList.getSelectedValue() == null) {
/* 256 */       return;
/*     */     }
/* 258 */     ListItem li = (ListItem)this.itemList.getSelectedValue();
/*     */ 
/* 260 */     JFrame mainFrame = GroupPurchaseWebApp.getApplication().getMainFrame();
/* 261 */     PurchaseConfirm purchaseBox = new PurchaseConfirm(mainFrame, this.groupPurchaseManagementSystem, li.getItem());
/* 262 */     purchaseBox.setLocationRelativeTo(mainFrame);
/* 263 */     GroupPurchaseWebApp.getApplication().show(purchaseBox);
/*     */   }
/*     */ 
/*     */   private void refreshBtnActionPerformed(ActionEvent evt) throws RemoteException {
/* 267 */     updateList();
/*     */   }
/*     */ 
/*     */   private class ListItem
/*     */   {
/*     */     private GroupPurchaseItem item;
/*     */ 
/*     */     public GroupPurchaseItem getItem()
/*     */     {
/* 295 */       return this.item;
/*     */     }
/*     */ 
/*     */     public ListItem(GroupPurchaseItem item) {
/* 299 */       this.item = item;
/*     */     }
				public ListItem(GroupPurchaseWebView groupPurchaseWebView, GroupPurchaseItem groupPurchaseItem) {
					this.item = groupPurchaseItem;
}
/*     */ 
/*     */     public String toString()
/*     */     {
/* 304 */       return String.format("%s (%.2f) %s", this.item.getProductName(), this.item.getPrice(), this.item.getIntroduction());
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/GraceHan/Desktop/应用集成第三次作业/Systems/GroupPurchaseWeb.jar
 * Qualified Name:     assignment3.GroupPurchaseWebView
 * JD-Core Version:    0.6.2
 */
package PHPay;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class HelpPanel extends JPanel {
	GradientPanel top_panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
	JPanel d1_panel;
	JPanel d2_panel;
	JList menu_list;
	JList home_list;
	JList pandt_list;
	JList dal_list;
	JList ma_list;
	JList mw_list;
	JList lands_list;
	JLabel tl1;
	JLabel tl2;
	JLabel bl1;
	JLabel bl2;
	JLabel bl3;
	JLabel bl4;
	JLabel bl5;
	JLabel bl6;
	JLabel bl7;
	JLabel bl8;
	JLabel bl9;
	JLabel bl10;
	JLabel bl11;
	JLabel bimg1;
	JLabel bimg2;
	JLabel home_label;
	JLabel pandt_label;
	JLabel dal_label;
	JLabel ma_label;
	JLabel mw_label;
	JLabel lands_label;
	JLabel home1l;
	JLabel home1t;
	JLabel home2l;
	JLabel home2t;
	JLabel home3l;
	JLabel home3t;
	JLabel home4l;
	JLabel home4t;
	JLabel home5l;
	JLabel home5t;
	JLabel home6l;
	JLabel home6t;
	JLabel home7l;
	JLabel home7t;
	JLabel home8l;
    JLabel home8t;
    JLabel pandtl1;
    JLabel pandtt1;
    JLabel pandtl2;
    JLabel pandtt2;
    JLabel pandtl3;
    JLabel pandtt3;
    JLabel pandtl4;
    JLabel pandtt4;
    JLabel d1l;
    JLabel d1t;
    JLabel d2l;
    JLabel d2t;
    JLabel ma1l;
    JLabel ma1t;
    JLabel ma2l;
    JLabel ma2t;
    JLabel ma3l;
    JLabel ma3t;
    JLabel ma4l;
    JLabel ma4t;
    JLabel mwl1;
    JLabel mwt1;
    JLabel mwl2;
    JLabel mwt2;
    JLabel lands1l;
    JLabel lands1t;
    JLabel lands2l;
    JLabel lands2t;

	public HelpPanel(String ID) {
		setForeground(new Color(51, 0, 204));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1200, 700);
		setLayout(null);
		RoundedPanel main_panel = new RoundedPanel(15);
		main_panel.setBackground(new Color(255, 255, 255));
		main_panel.setBounds(305, 107, 885, 400);
		add(main_panel);
		main_panel.setLayout(null);
		menu_list = new JList();
		menu_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 25));
		menu_list.setForeground(new Color(0, 0, 0));
		menu_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (menu_list.getSelectedValue().equals("Home")) {
					showHome();
				} else if (menu_list.getSelectedValue().equals("Payments and Transfers")) {
					showPandt();
				} else if (menu_list.getSelectedValue().equals("Disputes and Limitations")) {
					showDal();
				} else if (menu_list.getSelectedValue().equals("My Account")) {
					showMa();
				} else if (menu_list.getSelectedValue().equals("My Wallet")) {
					showMw();
				} else if (menu_list.getSelectedValue().equals("Login & Security")) {
					showLands();
				} 
			}
		});
		home_list = new JList();
		home_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		home_list.setForeground(new Color(51, 0, 204));
		home_list.setBounds(10, 52, 743, 280);
		home_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"How do I issue a refund?", "", "How do I change my password and security questions?", "", "How do I escalate a PHPAY dispute to a claim?", "", "Why is the payment I sent pending or unclaimed? Can I cancel it?", "", "How can I release my payment(s) on hold?", "", "How do I remove a limitation from my account?", "", "How do I add money to my PHPAY account from my bank?", "", "I forgot my password. How do I reset it?"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		home_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (home_list.getSelectedValue().equals("How do I issue a refund?")) {
					showh1();
				} else if (home_list.getSelectedValue().equals("How do I change my password and security questions?")) {
					showh2();
				} else if (home_list.getSelectedValue().equals("How do I escalate a PHPAY dispute to a claim?")) {
					showh3();
				} else if (home_list.getSelectedValue().equals("Why is the payment I sent pending or unclaimed? Can I cancel it?")) {
					showh4();
				} else if (home_list.getSelectedValue().equals("How can I release my payment(s) on hold?")) {
					showh5();
				} else if (home_list.getSelectedValue().equals("How do I remove a limitation from my account?")) {
					showh6();
				} else if (home_list.getSelectedValue().equals("How do I add money to my PHPAY account from my bank?")) {
					showh7();
				} else if (home_list.getSelectedValue().equals("I forgot my password. How do I reset it?")) {
					showh8();
				}
			}
		});
		main_panel.add(home_list);
		menu_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Home", "", "", "", "", "", "", "", "", "", "", "Payments and Transfers", "", "", "", "", "", "", "", "", "", "", "Disputes and Limitations", "", "", "", "", "", "", "", "", "", "", "My Account", "", "", "", "", "", "", "", "", "", "", "My Wallet", "", "", "", "", "", "", "", "", "", "", "Login & Security", "", "", "", "", "", ""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		menu_list.setBounds(10, 123, 271, 316);
		add(menu_list);
		top_panel.setBackground(SystemColor.controlHighlight);
		top_panel.setBounds(-184, -15, 1470, 111);
		add(top_panel);
		top_panel.setLayout(null);
		pandt_list = new JList();
		pandt_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		pandt_list.setForeground(new Color(51, 0, 204));
		pandt_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Can I cancel a withdrawal from my PHPAY account?", "", "How can I release my payment(s) on hold?", "", "How do I issue a refund?", "", "How do I add money to my PHPAY account from my bank?", "", "What‘s the maximum amount I can send with my PHPAY account?", "", "How do I receive money through PHPAY?", "", "What are the fees for PHPAY accounts?"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pandt_list.setBounds(10, 52, 743, 280);
		pandt_list.setVisible(false); 
		pandt_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (pandt_list.getSelectedValue().equals("Can I cancel a withdrawal from my PHPAY account?")) {
					showp1();
				} else if (pandt_list.getSelectedValue().equals("How can I release my payment(s) on hold?")) {
					showh5();
				} else if (pandt_list.getSelectedValue().equals("How do I issue a refund?")) {
					showh1();
				} else if (pandt_list.getSelectedValue().equals("How do I add money to my PHPAY account from my bank?")) {
					showh7();
				} else if (pandt_list.getSelectedValue().equals("What‘s the maximum amount I can send with my PHPAY account?")) {
					showp2();
				} else if (pandt_list.getSelectedValue().equals("How do I receive money through PHPAY?")) {
					showp3();
				} else if (pandt_list.getSelectedValue().equals("What are the fees for PHPAY accounts?")) {
					showp4();
				}
			}	});
		main_panel.add(pandt_list);
		dal_list = new JList();
		dal_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		dal_list.setForeground(new Color(51, 0, 204));
		dal_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"What should I do if I didn't receive all my items or if one or more were late?", "", "How do I remove a limitation from my account?", "", "What should I do if I think there has been unauthorized access to my PHPAY data?"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		dal_list.setBounds(10, 52, 743, 280);
		dal_list.setVisible(false); 
		dal_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (dal_list.getSelectedValue().equals("What should I do if I didn't receive all my items or if one or more were late?")) {
					showd1();
				} else if (dal_list.getSelectedValue().equals("How do I remove a limitation from my account?")) {
					showh6();
				} else if (dal_list.getSelectedValue().equals("What should I do if I think there has been unauthorized access to my PHPAY data?")) {
					showd2();
				}
			}
		});
		main_panel.add(dal_list);
		ma_list = new JList();
		ma_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"How do I view or edit my account information?", "", "How do I check the status of my payment?", "", "How do I verify my PHPAY account?", "", "Does PHPAY cover my purchase if there's a problem?"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		ma_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		ma_list.setBounds(10, 52, 743, 280);
		ma_list.setForeground(new Color(51, 0, 204));
		ma_list.setVisible(false); 
		ma_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (ma_list.getSelectedValue().equals("How do I view or edit my account information?")) {
					showma1();
				} else if (ma_list.getSelectedValue().equals("How do I check the status of my payment?")) {
					showma2();
				} else if (ma_list.getSelectedValue().equals("How do I verify my PHPAY account?")) {
					showma3();
				} else if (ma_list.getSelectedValue().equals("Does PHPAY cover my purchase if there's a problem?")) {
					showma4();
				} 
			} 
		});
		main_panel.add(ma_list);
		mw_list = new JList();
		mw_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		mw_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"How do I link a bank account to my PHPAY account?", "", "How do I link a debit or credit card to my PHPAY account?", "", "How do I add money to my PHPAY account from my bank?", ""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		mw_list.setBounds(10, 52, 743, 280);
		mw_list.setForeground(new Color(51, 0, 204));
		mw_list.setVisible(false); 
		mw_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mw_list.getSelectedValue().equals("How do I link a bank account to my PHPAY account?")) {
					showmw1();
				} else if (mw_list.getSelectedValue().equals("How do I link a debit or credit card to my PHPAY account?")) {
					showmw2();
				} else if (mw_list.getSelectedValue().equals("How do I add money to my PHPAY account from my bank?")) {
					showh7();
				} 
			} 
		});
		main_panel.add(mw_list);
		lands_list = new JList();
		lands_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		lands_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"I forgot my password. How do I reset it?", "", "How do I report potential fraud, spoof or unauthorized transactions to PHPAY?", "", "How can I access my personal data?"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lands_list.setBounds(10, 52, 743, 280);
		lands_list.setForeground(new Color(51, 0, 204));
		lands_list.setVisible(false);
		lands_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (lands_list.getSelectedValue().equals("I forgot my password. How do I reset it?")) {
					showh8();
				} else if (lands_list.getSelectedValue().equals("How do I report potential fraud, spoof or unauthorized transactions to PHPAY?")) {
					showlands1();
				} else if (lands_list.getSelectedValue().equals("How can I access my personal data?")) {
					showlands2();
				} 
			} 
		});
		main_panel.add(lands_list);
		home_label = new JLabel("Common Questions");
		home_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home_label.setBounds(10, 11, 259, 44);
		home_label.setForeground(new Color(0, 0, 0));
		main_panel.add(home_label);
		pandt_label = new JLabel("Payments and Transfers");
		pandt_label.setForeground(new Color(0, 0, 0));
		pandt_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		pandt_label.setBounds(10, 11, 251, 30);
		main_panel.add(pandt_label);
		pandt_label.setVisible(false); 
		dal_label = new JLabel("Disputes and Limitations\r\n");
		dal_label.setForeground(new Color(0, 0, 0));
		dal_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		dal_label.setBounds(10, 11, 251, 30);
		dal_label.setVisible(false); 
		main_panel.add(dal_label);
		ma_label = new JLabel("My Account\r\n");
		ma_label.setForeground(new Color(0, 0, 0));
		ma_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		ma_label.setBounds(10, 11, 251, 30);
		ma_label.setVisible(false); 
		main_panel.add(ma_label);
		mw_label = new JLabel("My Wallet");
		mw_label.setForeground(new Color(0, 0, 0));
		mw_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		mw_label.setBounds(10, 11, 251, 30);
		mw_label.setVisible(false); 
		main_panel.add(mw_label);
		lands_label = new JLabel("Login & Security");
		lands_label.setForeground(new Color(0, 0, 0));
		lands_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		lands_label.setBounds(10, 11, 251, 30);
		lands_label.setVisible(false);
		main_panel.add(lands_label);
		home1l = new JLabel("<html><p style='font-size: 15px;'>How do I issue a refund?</p></html>");
		home1l.setBounds(10, 17, 259, 24);
		main_panel.add(home1l);
		home1l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		home1l.setVisible(false); 
		home1t = new JLabel("<html><p style='font-size: 10px;'>Here's how to refund a payment:<br><br>1. Go to your Activity.<br>2. Select the payment you want to refund and click Issue a refund.<br>3. Enter the amount you want to refund.<br>4. Click Continue.<br>5. Review the information and click Issue Refund.<br><br>You can issue a full or partial refund within 180 days of the original payment date. Once you’ve sent a refund, you can’t cancel it.<br>For personal payments and payments made with a coupon or gift certificate, you can only issue a full refund. If you want to issue a partial refund, go to Send Money and create a new payment. Reference the original payment in the notes and send as a personal payment.<br><br>You won’t pay any fees to refund a payment for goods or services, but we won’t return the fees you originally paid as the seller.</html>");
		home1t.setVerticalAlignment(SwingConstants.TOP);
		home1t.setBounds(10, 52, 856, 337);
		main_panel.add(home1t);
		home1t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 9));
		home1t.setVisible(false); 
		home2l = new JLabel("<html><p style='font-size: 15px;'>How do I change my password and security questions?</p></html>");
		home2l.setForeground(Color.BLACK);
		home2l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home2l.setBounds(10, 11, 645, 30);
		home2l.setVisible(false); 
		main_panel.add(home2l);
		home2t = new JLabel("<html>\r\n<p style='font-size: 10px;'>Here's how to change your password:<br><br>\r\n1. Go to your Settings.<br>\r\n2. Click the Security tab above your name.<br>\r\n3. Click Update next to \"Password.\"<br>\r\n4. Confirm your current password, enter your new password twice, and click Change Password.<br>\r\n<br>\r\nHere's how to change your security questions:\r\n<br><br>\r\n1. Go to your Settings.<br>\r\n2. Click the Security tab above your name.<br>\r\n3. Click Update under \"Security questions.\"<br>\r\n4. From the \"Security question 1\" and \"Security question 2\" dropdown menus, select a question and type its answer.<br>\r\n5. Click Save.<br><br>\r\nWe recommend you change your password and security questions from time to time.<br>\r\n</p>\r\n</html>\r\n");
		home2t.setVerticalAlignment(SwingConstants.TOP);
		home2t.setForeground(Color.BLACK);
		home2t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home2t.setBounds(10, 52, 865, 337);
		home2t.setVisible(false);
		main_panel.add(home2t);
		home3l = new JLabel("<html><p style='font-size: 15px;'>How do I escalate a PHPAY dispute to a claim?\r\n</p></html>");
		home3l.setForeground(Color.BLACK);
		home3l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home3l.setBounds(10, 11, 540, 30);
		home3l.setVisible(false);
		main_panel.add(home3l);
		home3t = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\n<br><br><br>\r\n\r\nIn a dispute, you can exchange messages with the other party in your Resolution Center to try to solve the problem.\r\n<br>\r\nIf you’re unable to settle the dispute, you can escalate it to a claim. To escalate a dispute, we often require that at least 7 days have passed since the payment date.<br>\r\n<br>\r\nBy escalating a dispute to a claim, you’re asking PHPAY to investigate and decide the outcome. A dispute will automatically close after 20 days unless it’s been escalated. Closed disputes cannot be reopened or escalated to a claim.\r\n<br><br>\r\nHere's how to escalate a dispute:\r\n<br><br>\r\n1. Go to your Resolution Center.\r\n<br>2. Click View next to the dispute you want to escalate.\r\n<br>\r\n3. Click Escalate to PHPAY at the bottom of the page.<br>\r\n4. Add any relevant information for escalating the dispute and click Submit.<br>\r\n\r\n<br>The time it takes us to decide the outcome can vary. It depends on how quickly both parties respond to our inquiries and whether or not we need more information.\r\n<br><br>\r\nWe usually reach a decision within 14 days, but some cases can take 30 days or longer.\r\n</p><br>\r\n</html>");
		home3t.setForeground(Color.BLACK);
		home3t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home3t.setBounds(10, 11, 865, 378);
		home3t.setVisible(false);
		main_panel.add(home3t);
		home4l = new JLabel("<html><p style='font-size: 15px;'>Why is the payment I sent pending or unclaimed? Can I cancel it?\r\n</p></html>");
		home4l.setForeground(Color.BLACK);
		home4l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home4l.setBounds(10, 11, 835, 30);
		home4l.setVisible(false);
		main_panel.add(home4l);
		home4t = new JLabel("<html>\r\n<p style='font-size: 9px;'><br>\r\nIf a payment you sent is pending or unclaimed, it means the recipient hasn’t received or hasn’t accepted the payment yet.<br><br>\r\n\r\nThe payment would be pending or unclaimed if it was sent to an email address or phone number that isn’t registered to a verified PHPAY account. Check that you sent the payment to the correct email address or phone number. Or the recipient may need to set up a PHPAY account or verify their account for the payment to complete. You have the option to cancel the payment.<br><br>\r\n\r\nTo cancel an unclaimed payment on the web:<br><br>\r\n\r\n1. Go to Activity.<br>\r\n2. Click Cancel under the payment in question.<br>\r\n3. Follow the steps to cancel the payment.<br>\r\n\r\n<br><br>\r\nThe payment would be pending or unclaimed if the recipient has opted not to automatically accept certain payments. These could be payments not in their preferred currency, or from buyers with unconfirmed addresses. You won't have the option to cancel the payment yourself. The recipient needs to accept or deny the payment within 30 days.\r\n<br><br>\r\nWe automatically cancel pending or unclaimed payments after 30 days and send the money back to the original payment method. Refunds to bank accounts may take up to 5 business days, while refunds to credit or debit cards may take up to 30 days.<br>\r\n</p>\r\n</html>\r\n");
		home4t.setForeground(Color.BLACK);
		home4t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home4t.setBounds(10, 11, 865, 378);
		home4t.setVisible(false);
		main_panel.add(home4t);
		home5l = new JLabel("<html><p style='font-size: 15px;'>How can I release my payment(s) on hold?\r\n</p></html>");
		home5l.setForeground(Color.BLACK);
		home5l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home5l.setBounds(10, 11, 462, 30);
		home5l.setVisible(false);
		main_panel.add(home5l);
		home5t = new JLabel("<html>\r\n<p style='font-size: 9px;'><br>\r\nLog in to your account to see if you can help release your payments on hold. If you don’t have this option, we’ll hold your payment for up to 21 days.<br><br>\r\n\r\nYou may be able to release eligible payments by following one of the below steps:<br><br>\r\n\r\n1. Add Tracking: Use one of our approved shipping carriers, and we’ll release the hold approximately 24 hours after the courier confirms delivery to the buyer’s address.<br>\r\n2. Update the order status if the held payment is for a service or intangible item (e.g., piano lessons, e-book). We'll release the hold 7 days after you confirm the order status as Completed.<br><br>\r\n\r\nIn rare cases, after these steps are completed, we may need to hold the payment for up to 21 days. For example, this can happen if we notice an unusual change in your selling patterns.<br><br>\r\n\r\nTo add tracking information or update an order status:<br><br>\r\n\r\n1. Go to your Activity.<br>\r\n2. Find the purchase you want to update and click Get your money. If you sold a product, choose “Product” to add tracking information or print a shipping label. If you sold an intangible item or service, choose “Service or virtual product” to update the order status. You can update the order status to Completed, Pending, or Canceled.<br>\r\n3. Click Submit.<br>\r\n</p>\r\n</html>");
		home5t.setForeground(Color.BLACK);
		home5t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home5t.setBounds(10, 11, 865, 378);
		home5t.setVisible(false);
		main_panel.add(home5t);
		home6l = new JLabel("<html><p style='font-size: 15px;'>How do I remove a limitation from my account?\r\n</p></html>");
		home6l.setForeground(Color.BLACK);
		home6l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home6l.setBounds(10, 11, 589, 30);
		home6l.setVisible(false);
		main_panel.add(home6l);
		home6t = new JLabel("<html>\r\n<p style='font-size: 9px;'>\r\nA limited account means that you won’t be able to do certain things with your PHPAY account. For example, you might not be able to send or withdraw money. Usually, we ask you to complete some steps to remove your account limitation.<br><br>\r\n\r\nGo to your Resolution Center or click the bell icon at the top of your Dashboard for more info.<br><br>\r\n\r\nIf all the steps are completed and your account remains limited, it either means:<br><br>\r\n\r\n- We've already reviewed your account and sent you an email asking for more information.<br>\r\n- We're still reviewing the information you provided.<br><br>\r\n\r\nIf you're required to upload documents, review our tips for submitting documents.<br><br>\r\n\r\nThe time it takes to resolve an account limitation depends on the complexity of your specific case.<br><br>\r\n\r\nIn most cases, our customer service team can't remove your limitation over the phone. Please wait for us to contact you.<br><br>\r\n\r\nIf you received an email stating your account is limited, but don't see a limitation in the Resolution Center, you may have received a fake email. Forward it to phishing@phpay.com, and we'll investigate it for you.<br><br>\r\n\r\nAfter you forward us the email, delete it from your inbox. If you clicked any links or downloaded any attachments, log in to your account and view your payments. It's also a good idea to change your password.\r\n</p>\r\n</html>\r\n");
		home6t.setVerticalAlignment(SwingConstants.TOP);
		home6t.setForeground(Color.BLACK);
		home6t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home6t.setBounds(10, 52, 865, 337);
		home6t.setVisible(false);
		main_panel.add(home6t);
		home7l = new JLabel("<html><p style='font-size: 15px;'>How do I add money to my PHPAY account from my bank?</p></html>");
		home7l.setForeground(Color.BLACK);
		home7l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home7l.setBounds(10, 11, 633, 30);
		home7l.setVisible(false);
		main_panel.add(home7l);
		home7t = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nHow do I add money to my PHPAY account from my bank?<br><br>\r\n\r\nAdding money to a PHPAY account from a bank account may not be available in some countries.<br><br>\r\n\r\nHere’s how to add money to your PHPAY account from a bank account using your computer:<br><br>\r\n\r\n1. Go to your Wallet.<br>\r\n2. Click Transfer Money.<br>\r\n3. Click Add money to your balance.<br>\r\n4. Follow the instructions.\r\n</p>\r\n</html>\r\n");
		home7t.setVerticalAlignment(SwingConstants.TOP);
		home7t.setForeground(Color.BLACK);
		home7t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home7t.setBounds(10, 52, 865, 337);
		home7t.setVisible(false);
		main_panel.add(home7t);
		home8l = new JLabel("<html><p style='font-size: 15px;'>I forgot my password. How do I reset it?\r\n</p></html>");
		home8l.setForeground(Color.BLACK);
		home8l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home8l.setBounds(10, 11, 476, 30);
		home8l.setVisible(false);
		main_panel.add(home8l);
		home8t = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nTo reset your password on the web:<br><br>\r\n1. Go to our login.<br>\r\n2. Click Forgot password?<br>\r\n3. Enter the email address you use for PHPAY and click Next.<br>\r\n4. Choose how you want to complete our security check and click Next.<br>\r\n5. Once you complete the security check, we’ll ask you to create a new password.<br><br>\r\n\r\nTo reset your password on the app:<br><br>\r\n\r\n1. Tap Forgot password?<br>\r\n2. Enter the email address you use for PHPAY and tap Next.<br>\r\n3. Choose how you want to complete our security check and tap Next.<br>\r\n4. Once you complete the security check, we’ll ask you to create a new password.\r\n</p>\r\n</html>\r\n");
		home8t.setVerticalAlignment(SwingConstants.TOP);
		home8t.setForeground(Color.BLACK);
		home8t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home8t.setBounds(10, 52, 865, 337);
		home8t.setVisible(false);
		main_panel.add(home8t);
		pandtl1 = new JLabel("<html><p style='font-size: 15px;'>Can I cancel a withdrawal from my PHPAY account?\r\n</p></html>");
		pandtl1.setForeground(Color.BLACK);
		pandtl1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		pandtl1.setBounds(10, 11, 589, 30);
		pandtl1.setVisible(false);
		main_panel.add(pandtl1);
		pandtt1 = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nOnce you’ve requested a withdrawal from your PHPAY account, you can’t cancel it.<br>\r\n\r\nIf the transfer is complete and you need the money in your PHPAY account, you can add it back.\r\n</p>\r\n</html>\r\n");
		pandtt1.setVerticalAlignment(SwingConstants.TOP);
		pandtt1.setForeground(Color.BLACK);
		pandtt1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		pandtt1.setBounds(10, 52, 865, 337);
		pandtt1.setVisible(false);
		main_panel.add(pandtt1);
		pandtl2 = new JLabel("<html><p style='font-size: 15px;'>What‘s the maximum amount I can send with my PHPAY account?</p></html>");
		pandtl2.setForeground(Color.BLACK);
		pandtl2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		pandtl2.setBounds(10, 11, 611, 30);
		pandtl2.setVisible(false);
		main_panel.add(pandtl2);
		pandtt2 = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nIf you have a verified PHPAY account, there's no limit on the total amount of money you can send. You can send up to 60,000.00 Pesos in a single transaction, but we may limit that amount to 10,000.00 Pesos. These amounts can also vary depending on your currency.<br><br>\r\n\r\nIf you haven’t verified your PHPAY account, there will be a limit on the total amount of money you can send. You’ll be able to view this amount when you go to send money.\r\n</p>\r\n</html>\r\n");
		pandtt2.setVerticalAlignment(SwingConstants.TOP);
		pandtt2.setForeground(Color.BLACK);
		pandtt2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		pandtt2.setBounds(10, 52, 856, 337);
		pandtt2.setVisible(false);
		main_panel.add(pandtt2);
		pandtl3 = new JLabel("<html><p style='font-size: 15px;'>How do I receive money through PHPAY?</p></html>");
		pandtl3.setForeground(Color.BLACK);
		pandtl3.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		pandtl3.setBounds(10, 11, 476, 30);
		pandtl3.setVisible(false);
		main_panel.add(pandtl3);
		pandtt3 = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nWith PHPAY you receive money when someone pays to your email address or mobile number. Once that happens, we’ll send you a message letting you know you have money available.<br><br>\r\n\r\nYou can access the money you receive on your PHPAY account home page. You can then choose to:<br><br>\r\n\r\n1. Transfer it to your bank account, or<br>\r\n2. Keep it in your balance to send money to friends and family or to shop online<br><br>\r\n\r\nTo accept the money, you must open a PHPAY account and confirm your email address.<br><br>\r\n\r\nTo add an additional layer of confidence when receiving payment, we now provide the sender of funds the option to share a link directly with the recipient that the recipient can use to access and redeem their money.\r\n</p>\r\n</html>\r\n");
		pandtt3.setVerticalAlignment(SwingConstants.TOP);
		pandtt3.setForeground(Color.BLACK);
		pandtt3.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		pandtt3.setBounds(10, 52, 856, 337);
		pandtt3.setVisible(false);
		main_panel.add(pandtt3);
		pandtl4 = new JLabel("<html><p style='font-size: 15px;'>What are the fees for PHPAY accounts?</p></html>");
		pandtl4.setForeground(Color.BLACK);
		pandtl4.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		pandtl4.setBounds(10, 11, 540, 30);
		pandtl4.setVisible(false);
		main_panel.add(pandtl4);
		pandtt4 = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nHere’s how to view fees applied to any of your payments:<br>\r\n\r\n<br>1. Click Activity near the top of the page.<br>\r\n2. Find the transaction you want to check and click on it.<br>\r\n<br>\r\nFor more information on fees, click Fees at the bottom of any PHPAY page.\r\n</p>\r\n</html>\r\n");
		pandtt4.setVerticalAlignment(SwingConstants.TOP);
		pandtt4.setForeground(Color.BLACK);
		pandtt4.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		pandtt4.setBounds(10, 52, 856, 337);
		pandtt4.setVisible(false);
		main_panel.add(pandtt4);
		d1l = new JLabel("<html><p style='font-size: 15px;'>What should I do if I didn't receive all my items or if one or more were late?</p></html>");
		d1l.setForeground(Color.BLACK);
		d1l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		d1l.setBounds(10, 0, 686, 55);
		d1l.setVisible(false);
		main_panel.add(d1l);
		d1t = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nWe encourage sellers to ship items as soon as they receive payment. Most sellers ship items within 7 days. (Allow extra time for international shipments).<br><br>\r\n\r\nOccasionally, a seller may contact you if an item is out of stock. At that point, you can decide if you want to wait longer for that item or request a refund.<br><br>\r\n\r\nIf you have waited a reasonable time for the shipment and have no updates from the seller, you can decide to open a dispute for the missing item(s).<br><br>\r\n\r\nHere's how to open a dispute from the web:<br><br>\r\n\r\n1. Go to the Resolution Center and click Report a Problem.<br>\r\n2. Select the payment and click Continue.<br>\r\n3. Select the reason for your dispute, such as:\r\n   - Issues with your purchase.\r\n   - Issues with the Seller.\r\n   - Billing errors or Issues with subscriptions.\r\n   - Unauthorized activity in your PHPAY account.<br>\r\n4. Select the option that best describes the issue you're facing and click Continue.<br><br>\r\n\r\nIf your item arrives late after receiving a refund, you should work with your seller to return it or pay for it again. You can ask the seller how they would like to proceed and stick to the instructions.<br>\r\n</p>\r\n</html>");
		d1t.setVerticalAlignment(SwingConstants.TOP);
		d1t.setForeground(Color.BLACK);
		d1t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		d1t.setBounds(10, 52, 865, 337);
		d1t.setVisible(false);
		main_panel.add(d1t);
		d2l = new JLabel("<html><p style='font-size: 15px;'>What should I do if I think there has been unauthorized access to my PHPAY data?</p></html>");
		d2l.setForeground(Color.BLACK);
		d2l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		d2l.setBounds(10, 0, 779, 44);
		d2l.setVisible(false);
		main_panel.add(d2l);
		d2t = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\n    A data incident occurs when data is accessed by unauthorized persons or parties, or when there’s loss or destruction of data.\r\n    <br><br>\r\n    The security of your account is important to us. We have an extensive system of security protocols and controls in place to make sure that we never pass your personal data to an unauthorized party.\r\n    <br><br>\r\n    If you believe that an unauthorized party has accessed or is in possession of your personal data, contact us immediately. We can temporarily freeze your account while we investigate the incident.\r\n  </p>\r\n</html>\r\n");
		d2t.setVerticalAlignment(SwingConstants.TOP);
		d2t.setForeground(Color.BLACK);
		d2t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		d2t.setBounds(10, 52, 856, 337);
		d2t.setVisible(false);
		main_panel.add(d2t);
		ma1l = new JLabel("<html><p style='font-size: 15px;'>How do I view or edit my account information?</p></html>");
		ma1l.setForeground(Color.BLACK);
		ma1l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		ma1l.setBounds(10, 11, 552, 30);
		ma1l.setVisible(false);
		main_panel.add(ma1l);
		ma1t = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\nTo view or update your personal information, such as phone number, email address, street address, or language setting, please go to Settings and edit your information.\r\n<br>\r\n\r\n  </p>\r\n</html>\r\n");
		ma1t.setVerticalAlignment(SwingConstants.TOP);
		ma1t.setForeground(Color.BLACK);
		ma1t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		ma1t.setBounds(10, 52, 865, 337);
		ma1t.setVisible(false);
		main_panel.add(ma1t);
		ma2l = new JLabel("<html><p style='font-size: 15px;'>How do I check the status of my payment?</p></html>");
		ma2l.setForeground(Color.BLACK);
		ma2l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		ma2l.setBounds(10, 11, 500, 30);
		ma2l.setVisible(false);
		main_panel.add(ma2l);
		ma2t = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\n    Here’s how to check the status of a PHPAY payment:\r\n<br><br>\r\n    1. Go to your Activity.\r\n    <br>\r\n    2. Select or search for your payment. You can also click Filters to narrow your search by status or transaction type.\r\n    <br><br>\r\n    Here's how to check the status of a payment on the app:\r\n    <br><br>\r\n    1. Tap Wallet.\r\n    <br>\r\n    2. Tap Activity. \r\n    <br>\r\n    3. Select or search for your payment. You can also tap the filters icon to narrow your search by transaction, payment, or date.\r\n  </p>\r\n</html>\r\n");
		ma2t.setVerticalAlignment(SwingConstants.TOP);
		ma2t.setForeground(Color.BLACK);
		ma2t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		ma2t.setBounds(10, 52, 865, 337);
		ma2t.setVisible(false);
		main_panel.add(ma2t);
		ma3l = new JLabel("<html><p style='font-size: 15px;'>How do I verify my PHPAY account?</p></html>");
		ma3l.setForeground(Color.BLACK);
		ma3l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		ma3l.setBounds(10, 11, 540, 30);
		ma3l.setVisible(false);
		main_panel.add(ma3l);
		ma3t = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\n    We only ask you for essential information when you sign up to PHPAY but as you transact with us, we're under a legal obligation to know more about you. When you verify your account, you're proving that you own the financial details added to your account.\r\n    <br><br>\r\n    To get verified, go to your account to add and confirm your bank account or, if you prefer, add and confirm your debit or credit card.\r\n  </p>\r\n</html>\r\n");
		ma3t.setVerticalAlignment(SwingConstants.TOP);
		ma3t.setForeground(Color.BLACK);
		ma3t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		ma3t.setBounds(10, 52, 865, 337);
		ma3t.setVisible(false);
		main_panel.add(ma3t);
		ma4l = new JLabel("<html><p style='font-size: 15px;'>Does PHPAY cover my purchase if there's a problem?</p></html>");
		ma4l.setForeground(Color.BLACK);
		ma4l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		ma4l.setBounds(10, 11, 611, 30);
		ma4l.setVisible(false);
		main_panel.add(ma4l);
		ma4t = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\n    Our Purchase Protection covers all eligible PHPAY transactions. \r\n    <br><br>\r\n    To avail of our Purchase Protection, we require that your PHPAY account is kept in good standing and that you open a dispute within 180 days of payment. \r\n    <br><br>\r\n    Go to your Resolution Center and click Report a Problem.\r\n    <br><br>\r\n    In a dispute, you can exchange messages with the other party in your Resolution Center to try to solve the problem.\r\n    <br><br>\r\n    If you’re unable to settle the dispute, you can escalate it to a claim. To escalate a dispute, we often require that at least 7 days have passed since the payment date.\r\n    <br><br>\r\n    By escalating a dispute to a claim, you’re asking PHPAY to investigate and decide the outcome. A dispute will automatically close after 20 days unless it’s been escalated. Closed disputes cannot be reopened or escalated to a claim.\r\n    <br><br>\r\n    We’ll review the case and decide if you're eligible for a refund. If we decide the claim in your favor, we’ll reimburse you for the full purchase price and original shipping costs.    \r\n    <br><br>\r\n    Some items aren’t eligible for our Purchase Protection and include but aren't limited to:\r\n    <br>\r\n    - Motor vehicles \r\n    - Industrial machinery \r\n    - Real estate \r\n    - Prepaid cards \r\n    - Items that violate our policies\r\n    - Friends and Family payments\r\n  </p>\r\n</html>\r\n");
		ma4t.setVerticalAlignment(SwingConstants.TOP);
		ma4t.setForeground(Color.BLACK);
		ma4t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		ma4t.setBounds(10, 52, 865, 348);
		ma4t.setVisible(false);
		main_panel.add(ma4t);
		mwl1 = new JLabel("<html><p style='font-size: 15px;'>How do I link a bank account to my PHPAY account?</p></html>");
		mwl1.setForeground(Color.BLACK);
		mwl1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		mwl1.setBounds(10, 0, 540, 41);
		mwl1.setVisible(false);
		main_panel.add(mwl1);
		mwt1 = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\n    Here's how to link a bank account to your PHPAY account:\r\n    <br><br>\r\n    1. Click Wallet at the top of the page.\r\n    <br>\r\n    2. Click Link a bank account.\r\n    <br>\r\n    3. Follow the instructions on the page to add your bank account.\r\n    <br><br>\r\n    To link a bank on the app:\r\n    <br><br>\r\n    1. Tap Wallet.\r\n    <br>\r\n    2. Tap + across from \"Banks and cards.\"\r\n    <br>\r\n    3. Tap Banks.\r\n    <br>\r\n    4. Follow the instructions to link your bank account.\r\n    <br><br>\r\n ");
		mwt1.setVerticalAlignment(SwingConstants.TOP);
		mwt1.setForeground(Color.BLACK);
		mwt1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		mwt1.setBounds(10, 52, 865, 337);
		mwt1.setVisible(false);
		main_panel.add(mwt1);
		mwl2 = new JLabel("<html><p style='font-size: 15px;'>How do I link a debit or credit card to my PHPAY account?</p></html>");
		mwl2.setForeground(Color.BLACK);
		mwl2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		mwl2.setBounds(10, 0, 589, 44);
		mwl2.setVisible(false);
		main_panel.add(mwl2);
		mwt2 = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\n    Here’s how to link a card to your PHPAY account:\r\n    <br><br>\r\n    1. Go to your Wallet.\r\n    <br>\r\n    2. Click Link a debit or credit card.\r\n    <br>\r\n    3. Follow the instructions to link your card.\r\n    <br><br>\r\n    To link a card on the app:\r\n    <br><br>\r\n    1. Tap Wallet.\r\n    <br>\r\n    2. Tap + beside Banks and Cards.\r\n    <br>\r\n    3. Tap Debit and Credit Cards.\r\n    <br>\r\n    4. Enter your card details or scan your card.\r\n    <br><br>\r\n    You can link 4 cards to your unverified PHPAY account. When your account is verified, you can link up to 24 cards.\r\n  </p>\r\n</html>\r\n");
		mwt2.setVerticalAlignment(SwingConstants.TOP);
		mwt2.setForeground(Color.BLACK);
		mwt2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		mwt2.setBounds(10, 52, 865, 337);
		mwt2.setVisible(false);
		main_panel.add(mwt2);
		lands1l = new JLabel("<html><p style='font-size: 15px;'>How do I report potential fraud, spoof or unauthorized transactions to PHPAY?</p></html>");
		lands1l.setForeground(Color.BLACK);
		lands1l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		lands1l.setBounds(10, 0, 711, 46);
		lands1l.setVisible(false);
		main_panel.add(lands1l);
		lands1t = new JLabel("<html>\r\n  <p style='font-size: 10px;'>\r\n    It’s extremely important to report any suspected instances of fraud. If you think your account has been compromised, change your password and update your security questions right away to protect your account (we may limit what you can do on your account until you do so). Here are some types of fraudulent activity. Click on the links to learn more:\r\n    <br><br>\r\n    · <a href=\"#\">Unauthorized activity on your PHPAY account</a>\r\n    <br>\r\n    · <a href=\"#\">Fake PayPal emails or spoof websites</a>\r\n    <br>\r\n    · <a href=\"#\">Items not received or a potential fraudulent seller</a>\r\n  </p>\r\n</html>");
		lands1t.setVerticalAlignment(SwingConstants.TOP);
		lands1t.setForeground(Color.BLACK);
		lands1t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		lands1t.setBounds(10, 60, 865, 329);
		lands1t.setVisible(false);
		main_panel.add(lands1t);
		lands2l = new JLabel("<html><p style='font-size: 15px;'>How can I access my personal data?</p></html>");
		lands2l.setForeground(Color.BLACK);
		lands2l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		lands2l.setBounds(10, 0, 671, 44);
		lands2l.setVisible(false);
		main_panel.add(lands2l);
		lands2t = new JLabel("<html>\r\n  <p style='font-size: 9px;'> \r\n    You can contact us to request a copy of your data. Personal account customers in the US, UK, or European Union may download their personal data following these steps:<br><br>\r\n\r\n    1. Go to Settings.<br>\r\n    2. Click Data & Privacy.<br>\r\n    3. Click Download your data.<br>\r\n    4. Select data options, and click Submit Request.<br>\r\n    5. To access specific types of data that aren’t listed, please contact us.<br>\r\n<br>\r\n    Personal account customers in the US, UK, or European Union may download their personal data following these steps in the app:<br>\r\n\r\n    1. Tap your profile icon.<br>\r\n    2. Tap Data & privacy.<br>\r\n    3. Tap Download your data.<br>\r\n    4. Select data options, and tap Submit Request.<br>\r\n<br>\r\n    If you don’t have an account, you can submit a request here by clicking I can't log in or I don't have an account. This will require verification of your identity before we can assist you.\r\n<br>\r\n    We only disclose personal data to the owner of that data or a party authorized by the account holder.\r\n<br>\r\n    As part of any request to access or change personal data, we’ll conduct reasonable identity and verification checks to make sure you’re the account holder to ensure the security of your personal data. We reserve the right to disallow access or alteration to data if we're unable to verify your identity, if there is a conflicting legal obligation, or if doing so would put PHPAY or other parties at risk.\r\n  </p>\r\n</html>\r\n");
		lands2t.setVerticalAlignment(SwingConstants.TOP);
		lands2t.setForeground(Color.BLACK);
		lands2t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		lands2t.setBounds(10, 52, 865, 337);
		lands2t.setVisible(false);
		main_panel.add(lands2t);
		tl1 = new JLabel("Help Center - Personal Account");
		tl1.setBounds(197, 29, 332, 31);
		top_panel.add(tl1);
		tl1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		tl1.setForeground(new Color(255, 255, 255));
		tl2 = new JLabel("How can we help you?");
		tl2.setBounds(196, 61, 347, 39);
		top_panel.add(tl2);
		tl2.setForeground(new Color(255, 255, 255));
		tl2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 35));
		d1_panel = new JPanel();
		d1_panel.setBackground(new Color(192, 192, 192));
		d1_panel.setBounds(127, 572, 939, 1);
		add(d1_panel);
		d1_panel.setLayout(null);
		bl1 = new JLabel("About");
		bl1.setForeground(new Color(0, 0, 0));
		bl1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		bl1.setBounds(127, 584, 46, 14);
		bl1.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                openHelpPanel1();
	            }
	        });
		add(bl1);
		bl2 = new JLabel("Developers");
		bl2.setForeground(new Color(0, 0, 0));
		bl2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		bl2.setBounds(171, 584, 76, 14);
		bl2.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	                openHelpPanel1();
	            }
	        });
		add(bl2);
		bl3 = new JLabel("Partners");
		bl3.setForeground(new Color(0, 0, 0));
		bl3.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		bl3.setBounds(246, 584, 46, 14);
		bl3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl3);
		bl4 = new JLabel("Security");
		bl4.setForeground(new Color(0, 0, 0));
		bl4.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		bl4.setBounds(305, 584, 46, 14);
		bl4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl4);
		bl5 = new JLabel("Contact");
		bl5.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		bl5.setForeground(new Color(0, 0, 0));
		bl5.setBounds(361, 584, 46, 14);
		bl5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl5);
		bl6 = new JLabel("Help\r\n");
		bl6.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		bl6.setForeground(new Color(0, 0, 0));
		bl6.setBounds(417, 584, 46, 14);
		bl6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl6);
		bl7 = new JLabel("Fees");
		bl7.setForeground(Color.BLACK);
		bl7.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		bl7.setBounds(458, 584, 46, 14);
		bl7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl7);
		bl8 = new JLabel("©2022-2023");
		bl8.setForeground(new Color(0, 0, 0));
		bl8.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		bl8.setBounds(838, 584, 80, 14);
		bl8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl8);
		bl9 = new JLabel("Privacy");
		bl9.setForeground(new Color(0, 0, 0));
		bl9.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		bl9.setBounds(923, 584, 57, 14);
		bl9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl9);
		bl10 = new JLabel("Legal");
		bl10.setForeground(new Color(0, 0, 0));
		bl10.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		bl10.setBounds(975, 584, 46, 14);
		bl10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openHelpPanel1();
            }
        });
		add(bl10);
		bl11 = new JLabel("<html>PHPAY Pte Ltd is (i) licensed by the Monetary Authority of Singapore as a Major Payment Institution under the Payment Services Act 2019 and (ii) regulated by the Bangko Sentral ng Pilipinas <a href='https://www.bsp.gov.ph' style='color: #0000FF; text-decoration: underline;'>https://www.bsp.gov.ph</a> as an Operator of Payment Services in the Philippines under the National Payment Systems Act.<br><br>When you visit or interact with our sites, services, applications, tools or messaging, we or our authorised service providers may use cookies, web beacons, and other similar technologies for storing information to help provide you with a better, faster and safer experience and for advertising purposes. Learn more <a href='link_to_learn_more' style='color: #0000FF; text-decoration: underline;'>here</a>.</html>");
		bl11.setHorizontalAlignment(SwingConstants.CENTER);
		bl11.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		bl11.setBounds(33, 597, 1157, 116);
		add(bl11);
		bimg1 = new JLabel("");
		bimg1.setIcon(new ImageIcon(HelpPanel.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON.png")));
		bimg1.setBounds(71, 547, 46, 51);
		add(bimg1);
		bimg2 = new JLabel("");
		bimg2.setIcon(new ImageIcon(HelpPanel.class.getResource("/PHPay/phpimg/philippines (1).png")));
		bimg2.setBounds(1041, 584, 30, 14);
		add(bimg2);
		Panel d2_panel = new Panel();
		d2_panel.setBackground(new Color(192, 192, 192));
		d2_panel.setBounds(298, 96, 1, 367);
		add(d2_panel);
		d2_panel.setLayout(null);
	}
		 private void showHome() {
			 home_label.setVisible(true);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(true);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home1l.setVisible(false);
			 home1t.setVisible(false);
			 home2l.setVisible(false);
			 home2t.setVisible(false);
			 home3l.setVisible(false);
			 home3t.setVisible(false);
			 home4l.setVisible(false);
			 home4t.setVisible(false);
			 home5l.setVisible(false);
			 home5t.setVisible(false);
			 home6l.setVisible(false);
			 home6t.setVisible(false);
			 home7l.setVisible(false);
			 home7t.setVisible(false);
			 home8l.setVisible(false);
			 home8t.setVisible(false);
			 pandtl1.setVisible(false);
			 pandtt1.setVisible(false);
			 pandtl2.setVisible(false);
			 pandtt2.setVisible(false);
			 pandtl3.setVisible(false);
			 pandtt3.setVisible(false);
			 pandtl4.setVisible(false);
			 pandtt4.setVisible(false);
			 d1l.setVisible(false);
			 d1t.setVisible(false);
			 d2l.setVisible(false);
			 d2t.setVisible(false);
			 ma1l.setVisible(false);
			 ma1t.setVisible(false);
			 ma2l.setVisible(false);
			 ma2t.setVisible(false);
			 ma3l.setVisible(false);
			 ma3t.setVisible(false);
			 ma4l.setVisible(false);
			 ma4t.setVisible(false);
			 mwl1.setVisible(false);
			 mwt1.setVisible(false);
			 mwl2.setVisible(false);
			 mwt2.setVisible(false);
			 lands1l.setVisible(false);
			 lands1t.setVisible(false);
			 lands2l.setVisible(false);
			 lands2t.setVisible(false);
		 }
		 private void showPandt() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(true);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(true);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home1l.setVisible(false);
			 home1t.setVisible(false);
			 home2l.setVisible(false);
			 home2t.setVisible(false);
			 home3l.setVisible(false);
			 home3t.setVisible(false);
			 home4l.setVisible(false);
			 home4t.setVisible(false);
			 home5l.setVisible(false);
			 home5t.setVisible(false);
			 home6l.setVisible(false);
			 home6t.setVisible(false);
			 home7l.setVisible(false);
			 home7t.setVisible(false);
			 home8l.setVisible(false);
			 home8t.setVisible(false);
			 pandtl1.setVisible(false);
			 pandtt1.setVisible(false);
			 pandtl2.setVisible(false);
			 pandtt2.setVisible(false);
			 pandtl3.setVisible(false);
			 pandtt3.setVisible(false);
			 pandtl4.setVisible(false);
			 pandtt4.setVisible(false);
			 d1l.setVisible(false);
			 d1t.setVisible(false);
			 d2l.setVisible(false);
			 d2t.setVisible(false);
			 ma1l.setVisible(false);
			 ma1t.setVisible(false);
			 ma2l.setVisible(false);
			 ma2t.setVisible(false);
			 ma3l.setVisible(false);
			 ma3t.setVisible(false);
			 ma4l.setVisible(false);
			 ma4t.setVisible(false);
			 mwl1.setVisible(false);
			 mwt1.setVisible(false);
			 mwl2.setVisible(false);
			 mwt2.setVisible(false);
			 lands1l.setVisible(false);
			 lands1t.setVisible(false);
			 lands2l.setVisible(false);
			 lands2t.setVisible(false);
		 }
		 private void showDal() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(true);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(true);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home1l.setVisible(false);
			 home1t.setVisible(false);
			 home2l.setVisible(false);
			 home2t.setVisible(false);
			 home3l.setVisible(false);
			 home3t.setVisible(false);
			 home4l.setVisible(false);
			 home4t.setVisible(false);
			 home5l.setVisible(false);
			 home5t.setVisible(false);
			 home6l.setVisible(false);
			 home6t.setVisible(false);
			 home7l.setVisible(false);
			 home7t.setVisible(false);
			 home8l.setVisible(false);
			 home8t.setVisible(false);
			 pandtl1.setVisible(false);
			 pandtt1.setVisible(false);
			 pandtl2.setVisible(false);
			 pandtt2.setVisible(false);
			 pandtl3.setVisible(false);
			 pandtt3.setVisible(false);
			 pandtl4.setVisible(false);
			 pandtt4.setVisible(false);
			 d1l.setVisible(false);
			 d1t.setVisible(false);
			 d2l.setVisible(false);
			 d2t.setVisible(false);
			 ma1l.setVisible(false);
			 ma1t.setVisible(false);
			 ma2l.setVisible(false);
			 ma2t.setVisible(false);
			 ma3l.setVisible(false);
			 ma3t.setVisible(false);
			 ma4l.setVisible(false);
			 ma4t.setVisible(false);
			 mwl1.setVisible(false);
			 mwt1.setVisible(false);
			 mwl2.setVisible(false);
			 mwt2.setVisible(false);
			 lands1l.setVisible(false);
			 lands1t.setVisible(false);
			 lands2l.setVisible(false);
			 lands2t.setVisible(false);
		 }
		 private void showMa() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(true);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(true);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home1l.setVisible(false);
			 home1t.setVisible(false);
			 home2l.setVisible(false);
			 home2t.setVisible(false);
			 home3l.setVisible(false);
			 home3t.setVisible(false);  
			 home4l.setVisible(false);
			 home4t.setVisible(false);
			 home5l.setVisible(false);
			 home5t.setVisible(false);
			 home6l.setVisible(false);
			 home6t.setVisible(false);
			 home7l.setVisible(false);
			 home7t.setVisible(false);
			 home8l.setVisible(false);
			 home8t.setVisible(false);
			 pandtl1.setVisible(false);
			 pandtt1.setVisible(false);
			 pandtl2.setVisible(false);
			 pandtt2.setVisible(false);
			 pandtl3.setVisible(false);
			 pandtt3.setVisible(false);
			 pandtl4.setVisible(false);
			 pandtt4.setVisible(false);
			 d1l.setVisible(false);
			 d1t.setVisible(false);
			 d2l.setVisible(false);
			 d2t.setVisible(false);
			 ma1l.setVisible(false);
			 ma1t.setVisible(false);
			 ma2l.setVisible(false);
			 ma2t.setVisible(false);
			 ma3l.setVisible(false);
			 ma3t.setVisible(false);
			 ma4l.setVisible(false);
			 ma4t.setVisible(false);
			 mwl1.setVisible(false);
			 mwt1.setVisible(false);
			 mwl2.setVisible(false);
			 mwt2.setVisible(false);
			 lands1l.setVisible(false);
			 lands1t.setVisible(false);
			 lands2l.setVisible(false);
			 lands2t.setVisible(false);
		 }
		 private void showMw() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(true);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(true);
			 lands_list.setVisible(false);
			 home1l.setVisible(false);
			 home1t.setVisible(false);
			 home2l.setVisible(false);
			 home2t.setVisible(false);
			 home3l.setVisible(false);
			 home3t.setVisible(false);
			 home4l.setVisible(false);
			 home4t.setVisible(false);
			 home5l.setVisible(false);
			 home5t.setVisible(false);
			 home6l.setVisible(false);
			 home6t.setVisible(false);
			 home7l.setVisible(false);
			 home7t.setVisible(false);
			 home8l.setVisible(false);
			 home8t.setVisible(false);
			 pandtl1.setVisible(false);
			 pandtt1.setVisible(false);
			 pandtl2.setVisible(false);
			 pandtt2.setVisible(false);
			 pandtl3.setVisible(false);
			 pandtt3.setVisible(false);
			 pandtl4.setVisible(false);
			 pandtt4.setVisible(false);
			 d1l.setVisible(false);
			 d1t.setVisible(false);
			 d2l.setVisible(false);
			 d2t.setVisible(false); 
			 ma1l.setVisible(false);
			 ma1t.setVisible(false);
			 ma2l.setVisible(false);
			 ma2t.setVisible(false);
			 ma3l.setVisible(false);
			 ma3t.setVisible(false);
			 ma4l.setVisible(false);
			 ma4t.setVisible(false);
			 mwl1.setVisible(false);
			 mwt1.setVisible(false);
			 mwl2.setVisible(false);
			 mwt2.setVisible(false);
			 lands1l.setVisible(false);
			 lands1t.setVisible(false);
			 lands2l.setVisible(false);
			 lands2t.setVisible(false);
		 }
		 private void showLands() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(true);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(true);
			 home1l.setVisible(false);
			 home1t.setVisible(false);
			 home2l.setVisible(false);
			 home2t.setVisible(false);
			 home3l.setVisible(false);
			 home3t.setVisible(false);
			 home4l.setVisible(false);
			 home4t.setVisible(false);
			 home4l.setVisible(false);
			 home4t.setVisible(false);
			 home5l.setVisible(false);
			 home5t.setVisible(false);
			 home6l.setVisible(false);
			 home6t.setVisible(false);
			 home7l.setVisible(false);
			 home7t.setVisible(false);
			 home8l.setVisible(false);
			 home8t.setVisible(false);
			 pandtl1.setVisible(false);
			 pandtt1.setVisible(false);
			 pandtl2.setVisible(false);
			 pandtt2.setVisible(false);
			 pandtl3.setVisible(false);
			 pandtt3.setVisible(false);
			 pandtl4.setVisible(false);
			 pandtt4.setVisible(false);
			 d1l.setVisible(false);
			 d1t.setVisible(false);
			 d2l.setVisible(false);
			 d2t.setVisible(false);
			 ma1l.setVisible(false);
			 ma1t.setVisible(false);
			 ma2l.setVisible(false);
			 ma2t.setVisible(false);
			 ma3l.setVisible(false);
			 ma3t.setVisible(false);
			 ma4l.setVisible(false);
			 ma4t.setVisible(false);
			 mwl1.setVisible(false);
			 mwt1.setVisible(false);
			 mwl2.setVisible(false);
			 mwt2.setVisible(false);
			 lands1l.setVisible(false);
			 lands1t.setVisible(false);
			 lands2l.setVisible(false);
			 lands2t.setVisible(false);
		 }
		 private void showh1() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home1l.setVisible(true);
			 home1t.setVisible(true);
		 }
		 private void showh2() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home2l.setVisible(true);
			 home2t.setVisible(true);
		 }
		 private void showh3() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home3l.setVisible(true);
			 home3t.setVisible(true);
		 }
		 private void showh4() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home4l.setVisible(true);
			 home4t.setVisible(true);
		 }
		 private void showh5() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home5l.setVisible(true);
			 home5t.setVisible(true);
		 }
		 private void showh6() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home6l.setVisible(true);
			 home6t.setVisible(true);
		 }
		 private void showh7() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home7l.setVisible(true);
			 home7t.setVisible(true);
		 }
		 private void showh8() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 home8l.setVisible(true);
			 home8t.setVisible(true);

		 }
		 private void showp1() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 pandtl1.setVisible(true);
			 pandtt1.setVisible(true);
		 }
		 private void showp2() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 pandtl2.setVisible(true);
			 pandtt2.setVisible(true);
		 }
		 private void showp3() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 pandtl3.setVisible(true);
			 pandtt3.setVisible(true);
		 }

		 private void showp4() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 pandtl4.setVisible(true);
			 pandtt4.setVisible(true);
		 }
		 private void showd1() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 d1l.setVisible(true);
			 d1t.setVisible(true);
		 }
		 private void showd2() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 d2l.setVisible(true);
			 d2t.setVisible(true);
		 }
		 private void showma1() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 ma1l.setVisible(true);
			 ma1t.setVisible(true);
		 }
		 private void showma2() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 ma2l.setVisible(true);
			 ma2t.setVisible(true);
		 }
		 private void showma3() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 ma3l.setVisible(true);
			 ma3t.setVisible(true);
		 }
		 private void showma4() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 ma4l.setVisible(true);
			 ma4t.setVisible(true);
		 }
		 private void showmw1() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 mwl1.setVisible(true);
			 mwt1.setVisible(true);
		 }
		 private void showmw2() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 mwl2.setVisible(true);
			 mwt2.setVisible(true);
		 }
		 private void showlands1() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 lands1l.setVisible(true);
			 lands1t.setVisible(true);
		 }
		 private void showlands2() {
			 home_label.setVisible(false);
			 pandt_label.setVisible(false);
			 dal_label.setVisible(false);
			 ma_label.setVisible(false);
			 mw_label.setVisible(false);
			 lands_label.setVisible(false);
			 home_list.setVisible(false);
			 pandt_list.setVisible(false);
			 dal_list.setVisible(false);
			 ma_list.setVisible(false);
			 mw_list.setVisible(false);
			 lands_list.setVisible(false);
			 lands2l.setVisible(true);
			 lands2t.setVisible(true);
		 }
		 public void openHelpPanel1() {
			    HelpPanel1 helpPanel1 = new HelpPanel1();
			    helpPanel1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    helpPanel1.setResizable(true); // Make it not resizable
			    helpPanel1.setBounds(getBounds());
			    helpPanel1.setLocationRelativeTo(null); // Center on screen
			    helpPanel1.setVisible(true);
			}
}
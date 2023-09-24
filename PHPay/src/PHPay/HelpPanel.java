package PHPay;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class HelpPanel extends JPanel {
	GradientPanel panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));

	JList menu_list;
	JList home_list;
	JList pandt_list;
	JList dal_list;
	JList ma_list;
	JList mw_list;
	JList lands_list;
	JLabel lblNewLabel_1_1;
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




	
	public HelpPanel(String ID) {
		setForeground(new Color(51, 0, 204));
		
		setBackground(new Color(255, 255, 255));
		
		
		setBounds(0, 0, 1200, 700);
		setLayout(null);
		
		RoundedPanel panel_1 = new RoundedPanel(15);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(305, 107, 885, 400);
		add(panel_1);
		panel_1.setLayout(null);
		
		
		pandt_list = new JList();
		pandt_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		pandt_list.setForeground(new Color(51, 0, 204));

		pandt_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Canceling a Payment", "", "Payment Holds", "", "Refunds", "", "Transfers", "", "Sending Money", "", "Receiving Money", "", "Fees\t"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pandt_list.setBounds(10, 52, 743, 280);
		pandt_list.setVisible(false); 

		panel_1.add(pandt_list);
		
	    dal_list = new JList();
		dal_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		dal_list.setForeground(new Color(51, 0, 204));
		dal_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Disputes and Claims", "", "Account Limitations", "", "Unauthorized Transactions"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		dal_list.setBounds(10, 52, 743, 280);
		dal_list.setVisible(false); 

		panel_1.add(dal_list);
		
		ma_list = new JList();
		ma_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Profile and Settings", "", "Account Status", "", "PayPal Basics", "", "Policies", "", "Notifications", "", "Nonprofits and Donations", "", "Tax Information"};
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

		panel_1.add(ma_list);
		
		mw_list = new JList();
		mw_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		mw_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Bank Accounts", "", "Credit and Debit Cards", "", "Balance and Currencies", "", "Store Offers, Coupons, & Gift Cards\t"};
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

		panel_1.add(mw_list);
		
		lands_list = new JList();
		lands_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		lands_list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Password & Login Issues", "", "Fraudulent Emails & Scams", "", "Security\t"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lands_list.setBounds(10, 52, 743, 280);
		lands_list.setForeground(new Color(51, 0, 204));
		lands_list.setVisible(false); // Initially, hide this list
		
		panel_1.add(lands_list);
		
		home_label = new JLabel("Common Questions");
		home_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home_label.setBounds(10, 11, 476, 30);
		home_label.setForeground(new Color(0, 0, 0));
    


		panel_1.add(home_label);
		
		pandt_label = new JLabel("Payments and Transfers");
		pandt_label.setForeground(new Color(0, 0, 0));
		pandt_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		pandt_label.setBounds(10, 11, 251, 30);
		panel_1.add(pandt_label);
		pandt_label.setVisible(false); 

		
		dal_label = new JLabel("Disputes and Limitations\r\n");
		dal_label.setForeground(new Color(0, 0, 0));
		dal_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		dal_label.setBounds(10, 11, 251, 30);
		dal_label.setVisible(false); 

		panel_1.add(dal_label);
		
		ma_label = new JLabel("My Account\r\n");
		ma_label.setForeground(new Color(0, 0, 0));
		ma_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		ma_label.setBounds(10, 11, 251, 30);
		ma_label.setVisible(false); 

		panel_1.add(ma_label);
		
		mw_label = new JLabel("My Wallet");
		mw_label.setForeground(new Color(0, 0, 0));
		mw_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		mw_label.setBounds(10, 11, 251, 30);
		mw_label.setVisible(false); 

		panel_1.add(mw_label);
		
		lands_label = new JLabel("Login & Security");
		lands_label.setForeground(new Color(0, 0, 0));
		lands_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		lands_label.setBounds(10, 11, 251, 30);
		lands_label.setVisible(false);
		panel_1.add(lands_label);
		
		home1l = new JLabel("<html><p style='font-size: 15px;'>How do I issue a refund?</p></html>");
		home1l.setBounds(10, 17, 259, 24);
		panel_1.add(home1l);
		home1l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		home1l.setVisible(false); 

		
		home1t = new JLabel("<html><p style='font-size: 10px;'>Here's how to refund a payment:<br><br>1. Go to your Activity.<br>2. Select the payment you want to refund and click Issue a refund.<br>3. Enter the amount you want to refund.<br>4. Click Continue.<br>5. Review the information and click Issue Refund.<br><br>You can issue a full or partial refund within 180 days of the original payment date. Once you’ve sent a refund, you can’t cancel it.<br>For personal payments and payments made with a coupon or gift certificate, you can only issue a full refund. If you want to issue a partial refund, go to Send Money and create a new payment. Reference the original payment in the notes and send as a personal payment.<br><br>You won’t pay any fees to refund a payment for goods or services, but we won’t return the fees you originally paid as the seller.</html>");
		home1t.setBounds(20, 11, 846, 378);
		panel_1.add(home1t);
		home1t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 9));
		home1t.setVisible(false); 
		
	    home2l = new JLabel("<html><p style='font-size: 15px;'>How do I change my password and security questions?</p></html>");
		home2l.setForeground(Color.BLACK);
		home2l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home2l.setBounds(10, 11, 645, 30);
		home2l.setVisible(false); 

		panel_1.add(home2l);
		
		home2t = new JLabel("<html>\r\n<p style='font-size: 10px;'><br>Here's how to change your password:<br><br>\r\n1. Go to your Settings.<br>\r\n2. Click the Security tab above your name.<br>\r\n3. Click Update next to \"Password.\"<br>\r\n4. Confirm your current password, enter your new password twice, and click Change Password.<br>\r\n<br>\r\nHere's how to change your security questions:\r\n<br><br>\r\n1. Go to your Settings.<br>\r\n2. Click the Security tab above your name.<br>\r\n3. Click Update under \"Security questions.\"<br>\r\n4. From the \"Security question 1\" and \"Security question 2\" dropdown menus, select a question and type its answer.<br>\r\n5. Click Save.<br><br>\r\nWe recommend you change your password and security questions from time to time.<br>\r\n</p>\r\n</html>\r\n");
		home2t.setForeground(Color.BLACK);
		home2t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home2t.setBounds(10, 11, 865, 378);
		home2t.setVisible(false);
		panel_1.add(home2t);
		
		home3l = new JLabel("<html><p style='font-size: 15px;'>How do I escalate a PHPAY dispute to a claim?\r\n</p></html>");
		home3l.setForeground(Color.BLACK);
		home3l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home3l.setBounds(10, 11, 540, 30);
		home3l.setVisible(false);

		panel_1.add(home3l);
		
		home3t = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\n<br><br><br>\r\n\r\nIn a dispute, you can exchange messages with the other party in your Resolution Center to try to solve the problem.\r\n<br>\r\nIf you’re unable to settle the dispute, you can escalate it to a claim. To escalate a dispute, we often require that at least 7 days have passed since the payment date.<br>\r\n<br>\r\nBy escalating a dispute to a claim, you’re asking PHPay to investigate and decide the outcome. A dispute will automatically close after 20 days unless it’s been escalated. Closed disputes cannot be reopened or escalated to a claim.\r\n<br><br>\r\nHere's how to escalate a dispute:\r\n<br><br>\r\n1. Go to your Resolution Center.\r\n<br>2. Click View next to the dispute you want to escalate.\r\n<br>\r\n3. Click Escalate to PHPay at the bottom of the page.<br>\r\n4. Add any relevant information for escalating the dispute and click Submit.<br>\r\n\r\n<br>The time it takes us to decide the outcome can vary. It depends on how quickly both parties respond to our inquiries and whether or not we need more information.\r\n<br><br>\r\nWe usually reach a decision within 14 days, but some cases can take 30 days or longer.\r\n</p><br>\r\n</html>");
		home3t.setForeground(Color.BLACK);
		home3t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home3t.setBounds(10, 11, 865, 378);
		home3t.setVisible(false);

		panel_1.add(home3t);
		
		home4l = new JLabel("<html><p style='font-size: 15px;'>Why is the payment I sent pending or unclaimed? Can I cancel it?\r\n</p></html>");
		home4l.setForeground(Color.BLACK);
		home4l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home4l.setBounds(10, 11, 835, 30);
		home4l.setVisible(false);

		panel_1.add(home4l);
		
		home4t = new JLabel("<html>\r\n<p style='font-size: 9px;'><br>\r\nIf a payment you sent is pending or unclaimed, it means the recipient hasn’t received or hasn’t accepted the payment yet.<br><br>\r\n\r\nThe payment would be pending or unclaimed if it was sent to an email address or phone number that isn’t registered to a verified PHPay account. Check that you sent the payment to the correct email address or phone number. Or the recipient may need to set up a PHPay account or verify their account for the payment to complete. You have the option to cancel the payment.<br><br>\r\n\r\nTo cancel an unclaimed payment on the web:<br><br>\r\n\r\n1. Go to Activity.<br>\r\n2. Click Cancel under the payment in question.<br>\r\n3. Follow the steps to cancel the payment.<br>\r\n\r\n<br><br>\r\nThe payment would be pending or unclaimed if the recipient has opted not to automatically accept certain payments. These could be payments not in their preferred currency, or from buyers with unconfirmed addresses. You won't have the option to cancel the payment yourself. The recipient needs to accept or deny the payment within 30 days.\r\n<br><br>\r\nWe automatically cancel pending or unclaimed payments after 30 days and send the money back to the original payment method. Refunds to bank accounts may take up to 5 business days, while refunds to credit or debit cards may take up to 30 days.<br>\r\n</p>\r\n</html>\r\n");
		home4t.setForeground(Color.BLACK);
		home4t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home4t.setBounds(10, 11, 865, 378);
		home4t.setVisible(false);

		panel_1.add(home4t);
		
		home5l = new JLabel("<html><p style='font-size: 15px;'>How can I release my payment(s) on hold?\r\n</p></html>");
		home5l.setForeground(Color.BLACK);
		home5l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home5l.setBounds(10, 11, 462, 30);
		home5l.setVisible(false);

		panel_1.add(home5l);
		
		home5t = new JLabel("<html>\r\n<p style='font-size: 9px;'><br>\r\nLog in to your account to see if you can help release your payments on hold. If you don’t have this option, we’ll hold your payment for up to 21 days.<br><br>\r\n\r\nYou may be able to release eligible payments by following one of the below steps:<br><br>\r\n\r\n1. Add Tracking: Use one of our approved shipping carriers, and we’ll release the hold approximately 24 hours after the courier confirms delivery to the buyer’s address.<br>\r\n2. Update the order status if the held payment is for a service or intangible item (e.g., piano lessons, e-book). We'll release the hold 7 days after you confirm the order status as Completed.<br><br>\r\n\r\nIn rare cases, after these steps are completed, we may need to hold the payment for up to 21 days. For example, this can happen if we notice an unusual change in your selling patterns.<br><br>\r\n\r\nTo add tracking information or update an order status:<br><br>\r\n\r\n1. Go to your Activity.<br>\r\n2. Find the purchase you want to update and click Get your money. If you sold a product, choose “Product” to add tracking information or print a shipping label. If you sold an intangible item or service, choose “Service or virtual product” to update the order status. You can update the order status to Completed, Pending, or Canceled.<br>\r\n3. Click Submit.<br>\r\n</p>\r\n</html>");
		home5t.setForeground(Color.BLACK);
		home5t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home5t.setBounds(10, 11, 865, 378);
		home5t.setVisible(false);

		panel_1.add(home5t);
		
		home6l = new JLabel("<html><p style='font-size: 15px;'>How do I remove a limitation from my account?\r\n</p></html>");
		home6l.setForeground(Color.BLACK);
		home6l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home6l.setBounds(10, 11, 589, 30);
		home6l.setVisible(false);

		panel_1.add(home6l);
		
		home6t = new JLabel("<html>\r\n<p style='font-size: 9px;'>\r\n<br><br>\r\nA limited account means that you won’t be able to do certain things with your PHPay account. For example, you might not be able to send or withdraw money. Usually, we ask you to complete some steps to remove your account limitation.<br><br>\r\n\r\nGo to your Resolution Center or click the bell icon at the top of your Dashboard for more info.<br><br>\r\n\r\nIf all the steps are completed and your account remains limited, it either means:<br><br>\r\n\r\n- We've already reviewed your account and sent you an email asking for more information.<br>\r\n- We're still reviewing the information you provided.<br><br>\r\n\r\nIf you're required to upload documents, review our tips for submitting documents.<br><br>\r\n\r\nThe time it takes to resolve an account limitation depends on the complexity of your specific case.<br><br>\r\n\r\nIn most cases, our customer service team can't remove your limitation over the phone. Please wait for us to contact you.<br><br>\r\n\r\nIf you received an email stating your account is limited, but don't see a limitation in the Resolution Center, you may have received a fake email. Forward it to phishing@phpay.com, and we'll investigate it for you.<br><br>\r\n\r\nAfter you forward us the email, delete it from your inbox. If you clicked any links or downloaded any attachments, log in to your account and view your payments. It's also a good idea to change your password.\r\n</p>\r\n</html>\r\n");
		home6t.setForeground(Color.BLACK);
		home6t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home6t.setBounds(10, 11, 865, 378);
		home6t.setVisible(false);

		panel_1.add(home6t);
		
		home7l = new JLabel("<html><p style='font-size: 15px;'>How do I add money to my PHPay account from my bank?</p></html>");
		home7l.setForeground(Color.BLACK);
		home7l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home7l.setBounds(10, 11, 633, 30);
		home7l.setVisible(false);

		panel_1.add(home7l);
		
		home7t = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nHow do I add money to my PHPay account from my bank?<br><br>\r\n\r\nAdding money to a PHPay account from a bank account may not be available in some countries.<br><br>\r\n\r\nHere’s how to add money to your PHPay account from a bank account using your computer:<br><br>\r\n\r\n1. Go to your Wallet.<br>\r\n2. Click Transfer Money.<br>\r\n3. Click Add money to your balance.<br>\r\n4. Follow the instructions.\r\n</p>\r\n</html>\r\n");
		home7t.setForeground(Color.BLACK);
		home7t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home7t.setBounds(10, 11, 865, 378);
		home7t.setVisible(false);

		panel_1.add(home7t);
		
		
		home8l = new JLabel("<html><p style='font-size: 15px;'>I forgot my password. How do I reset it?\r\n</p></html>");
		home8l.setForeground(Color.BLACK);
		home8l.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		home8l.setBounds(10, 11, 476, 30);
		home8l.setVisible(false);

		panel_1.add(home8l);
		
		home8t = new JLabel("<html>\r\n<p style='font-size: 10px;'>\r\nTo reset your password on the web:<br><br>\r\n\r\n1. Go to our login.<br>\r\n2. Click Forgot password?<br>\r\n3. Enter the email address you use for PayPal and click Next.<br>\r\n4. Choose how you want to complete our security check and click Next.<br>\r\n5. Once you complete the security check, we’ll ask you to create a new password.<br><br>\r\n\r\nTo reset your password on the app:<br><br>\r\n\r\n1. Tap Forgot password?<br>\r\n2. Enter the email address you use for PayPal and tap Next.<br>\r\n3. Choose how you want to complete our security check and tap Next.<br>\r\n4. Once you complete the security check, we’ll ask you to create a new password.\r\n</p>\r\n</html>\r\n");
		home8t.setForeground(Color.BLACK);
		home8t.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 22));
		home8t.setBounds(10, 11, 865, 378);
		home8t.setVisible(false);

		panel_1.add(home8t);
		
		
		menu_list = new JList();
		menu_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 25));
		menu_list.setForeground(new Color(0, 0, 0));
		menu_list.addMouseListener(new MouseAdapter() {
            @Override
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
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(-184, -15, 1470, 111);
		add(panel);
		panel.setLayout(null);
		
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
			    @Override
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
			panel_1.add(home_list);
		
		
			
			
	    lblNewLabel_1_1 = new JLabel("How can we help you?");
		lblNewLabel_1_1.setBounds(196, 61, 347, 39);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 35));
		
		JLabel lblNewLabel_1 = new JLabel("Help Center - Personal Account");
		lblNewLabel_1.setBounds(197, 29, 332, 31);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();

		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(127, 572, 939, 1);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Help\r\n");
		lblNewLabel_11.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setBounds(127, 547, 46, 14);
		add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("Contact");
		lblNewLabel_11_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_1.setBounds(183, 547, 46, 14);
		add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("Fees");
		lblNewLabel_11_2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2.setBounds(250, 547, 46, 14);
		add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_2_1 = new JLabel("Security");
		lblNewLabel_11_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_1.setBounds(296, 547, 46, 14);
		add(lblNewLabel_11_2_1);
		
		JLabel lblNewLabel_11_2_2 = new JLabel("Apps");
		lblNewLabel_11_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_2.setBounds(363, 547, 46, 14);
		add(lblNewLabel_11_2_2);
		
		JLabel lblNewLabel_11_2_3 = new JLabel("Partners");
		lblNewLabel_11_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_3.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_3.setBounds(416, 584, 46, 14);
		add(lblNewLabel_11_2_3);
		
		JLabel lblNewLabel_11_2_4 = new JLabel("Developers");
		lblNewLabel_11_2_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_4.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_4.setBounds(329, 584, 87, 14);
		add(lblNewLabel_11_2_4);
		
		JLabel lblNewLabel_11_2_5 = new JLabel("Jobs");
		lblNewLabel_11_2_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_5.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_5.setBounds(271, 583, 46, 14);
		add(lblNewLabel_11_2_5);
		
		JLabel lblNewLabel_11_2_6 = new JLabel("Newsroom");
		lblNewLabel_11_2_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_6.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_6.setBounds(193, 583, 74, 14);
		add(lblNewLabel_11_2_6);
		
		JLabel lblNewLabel_11_2_7 = new JLabel("About");
		lblNewLabel_11_2_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_7.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_7.setBounds(127, 583, 46, 14);
		add(lblNewLabel_11_2_7);
		
		JLabel lblNewLabel_11_2_8 = new JLabel("Accessibility");
		lblNewLabel_11_2_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_8.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_8.setBounds(832, 584, 73, 14);
		add(lblNewLabel_11_2_8);
		
		JLabel lblNewLabel_11_2_9 = new JLabel("Privacy");
		lblNewLabel_11_2_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_9.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_9.setBounds(915, 584, 57, 14);
		add(lblNewLabel_11_2_9);
		
		JLabel lblNewLabel_11_2_10 = new JLabel("Cookies");
		lblNewLabel_11_2_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_10.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_10.setBounds(982, 584, 63, 14);
		add(lblNewLabel_11_2_10);
		
		JLabel lblNewLabel_11_2_11 = new JLabel("Legal");
		lblNewLabel_11_2_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_11.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_11.setBounds(1045, 584, 46, 14);
		add(lblNewLabel_11_2_11);
		
		JLabel lblNewLabel_11_2_12 = new JLabel("©2022-2023");
		lblNewLabel_11_2_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_12.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_12.setBounds(740, 584, 80, 14);
		add(lblNewLabel_11_2_12);
		
		JLabel lblNewLabel_11_2_13 = new JLabel("Shop");
		lblNewLabel_11_2_13.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_13.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_13.setBounds(419, 547, 46, 14);
		add(lblNewLabel_11_2_13);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(298, 96, 1, 367);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>PHPay Pte Ltd is (i) licensed by the Monetary Authority of Singapore as a Major Payment Institution under the Payment Services Act 2019 and (ii) regulated by the Bangko Sentral ng Pilipinas <a href='https://www.bsp.gov.ph' style='color: #0000FF; text-decoration: underline;'>https://www.bsp.gov.ph</a> as an Operator of Payment Services in the Philippines under the National Payment Systems Act.<br><br>When you visit or interact with our sites, services, applications, tools or messaging, we or our authorised service providers may use cookies, web beacons, and other similar technologies for storing information to help provide you with a better, faster and safer experience and for advertising purposes. Learn more <a href='link_to_learn_more' style='color: #0000FF; text-decoration: underline;'>here</a>.</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblNewLabel.setBounds(33, 597, 1157, 116);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(HelpPanel.class.getResource("/PHPay/phpimg/philippines (1).png")));
		lblNewLabel_2.setBounds(1046, 547, 30, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(HelpPanel.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON.png")));
		lblNewLabel_3.setBounds(71, 547, 46, 51);
		add(lblNewLabel_3);
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







		
}

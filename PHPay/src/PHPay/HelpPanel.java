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
	JLabel h1_1;
	JLabel h12_1;



	
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
		pandt_list.setVisible(false); // Initially, hide this list

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
		dal_list.setVisible(false); // Initially, hide this list

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
		ma_list.setVisible(false); // Initially, hide this list

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
		mw_list.setVisible(false); // Initially, hide this list

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
		home_label.setBounds(10, 11, 251, 30);
		home_label.setForeground(new Color(0, 0, 0));
     //   home_label.setVisible(false); // Initially, hide this label


		panel_1.add(home_label);
		
		 pandt_label = new JLabel("Payments and Transfers");
		pandt_label.setForeground(new Color(0, 0, 0));
		pandt_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		pandt_label.setBounds(10, 11, 251, 30);
		panel_1.add(pandt_label);
		pandt_label.setVisible(false); // Initially, hide this label

		
		 dal_label = new JLabel("Disputes and Limitations\r\n");
		dal_label.setForeground(new Color(0, 0, 0));
		dal_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		dal_label.setBounds(10, 11, 251, 30);
		dal_label.setVisible(false); // Initially, hide this label

		panel_1.add(dal_label);
		
		 ma_label = new JLabel("My Account\r\n");
		ma_label.setForeground(new Color(0, 0, 0));
		ma_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		ma_label.setBounds(10, 11, 251, 30);
		ma_label.setVisible(false); // Initially, hide this label

		panel_1.add(ma_label);
		
		 mw_label = new JLabel("My Wallet");
		mw_label.setForeground(new Color(0, 0, 0));
		mw_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		mw_label.setBounds(10, 11, 251, 30);
		mw_label.setVisible(false); // Initially, hide this label

		panel_1.add(mw_label);
		
		 lands_label = new JLabel("Login & Security");
		lands_label.setForeground(new Color(0, 0, 0));
		lands_label.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
		lands_label.setBounds(10, 11, 251, 30);
		lands_label.setVisible(false); // Initially, hide this label

		panel_1.add(lands_label);
		
		h1_1 = new JLabel("<html><p style='font-size: 15px;'>How do I issue a refund?</p></html>");
		h1_1.setBounds(10, 17, 259, 24);
		panel_1.add(h1_1);
		h1_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		h1_1.setVisible(false); // Initially, hide this label

		
		 h12_1 = new JLabel("<html><p style='font-size: 10px;'>Here's how to refund a payment:<br><br>1. Go to your Activity.<br>2. Select the payment you want to refund and click Issue a refund.<br>3. Enter the amount you want to refund.<br>4. Click Continue.<br>5. Review the information and click Issue Refund.<br><br>You can issue a full or partial refund within 180 days of the original payment date. Once you’ve sent a refund, you can’t cancel it.<br>For personal payments and payments made with a coupon or gift certificate, you can only issue a full refund. If you want to issue a partial refund, go to Send Money and create a new payment. Reference the original payment in the notes and send as a personal payment.<br><br>You won’t pay any fees to refund a payment for goods or services, but we won’t return the fees you originally paid as the seller.</html>");
		h12_1.setBounds(10, 11, 845, 378);
		panel_1.add(h12_1);
		h12_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 9));
		h12_1.setVisible(false); // Initially, hide this label


		
		 menu_list = new JList();
		menu_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 25));
		menu_list.setForeground(new Color(0, 0, 0));
		menu_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (menu_list.getSelectedValue().equals("Home")) {
                    home_label.setVisible(true);
                    pandt_label.setVisible(false);
                    dal_label.setVisible(false);
                    ma_label.setVisible(false);
                    mw_label.setVisible(false);
                    lands_label.setVisible(false);
                    h1_1.setVisible(false);
                    h12_1.setVisible(false);

                    

                    
                    home_list.setVisible(true);
                    pandt_list.setVisible(false);
                    dal_list.setVisible(false);
                    ma_list.setVisible(false);
                    mw_list.setVisible(false);
                    lands_list.setVisible(false);
                    
                } else if (menu_list.getSelectedValue().equals("Payments and Transfers")) {
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
                } else if (menu_list.getSelectedValue().equals("Disputes and Limitations")) {
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
            } else if (menu_list.getSelectedValue().equals("My Account")) {
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
           } else if (menu_list.getSelectedValue().equals("My Wallet")) {
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
          } else if (menu_list.getSelectedValue().equals("Login & Security")) {
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
		

	      //  home_list.setVisible(false); // Initially, hide this list

			home_list.setBounds(10, 52, 743, 280);
			home_list.setModel(new AbstractListModel() {
				String[] values = new String[] {"How do I issue a refund?", "", "How do I escalate a PHPAY dispute to a claim?", "", "Why is the payment I sent pending or unclaimed? Can I cancel it?", "", "How can I release my payment(s) on hold?", "", "How do I add and confirm, change or remove a phone number on my PHPAY account?", "", "How do I remove a limitation from my account?", "", "How do I add money to my PHPAY account from my bank?", "", "I forgot my password. How do I reset it?", "", "How do I open a dispute with a seller?"};
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
			            // Show the items related to issuing a refund
			            showRefundItems();
			        } else {
			            // Hide the items related to issuing a refund
			            hideRefundItems();
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
		 private void toggleListVisibility() {
		        // Toggle the visibility of the "Home" and "Payments and Transfers" lists
		        home_list.setVisible(!home_list.isVisible());
		        pandt_list.setVisible(!pandt_list.isVisible());
		        dal_list.setVisible(!dal_list.isVisible());
		        ma_list.setVisible(!ma_list.isVisible());
		        mw_list.setVisible(!mw_list.isVisible());
		        lands_list.setVisible(!lands_list.isVisible());
		        home_label.setVisible(!home_label.isVisible());
		        pandt_label.setVisible(!pandt_label.isVisible());
		        dal_label.setVisible(!dal_label.isVisible());
		        ma_label.setVisible(!ma_label.isVisible());
		        mw_label.setVisible(!mw_label.isVisible());
		        lands_label.setVisible(!lands_label.isVisible());
		        h1_1.setVisible(!h1_1.isVisible());
		        h12_1.setVisible(!h12_1.isVisible());

		        


		    }
		 private void showRefundItems() {
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
			    
			    h1_1.setVisible(true);
			    h12_1.setVisible(true);
			}

			private void hideRefundItems() {
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
			    
			    h1_1.setVisible(false);
			    h12_1.setVisible(false);
			}
}

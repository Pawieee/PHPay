package PHPay;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Panel;
import javax.swing.ImageIcon;

public class HelpPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	GradientPanel panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));

	@SuppressWarnings("rawtypes")
	JList home_list;
	@SuppressWarnings("rawtypes")
	JList pandt_list;
	@SuppressWarnings("rawtypes")
	JList dal_list;
	@SuppressWarnings("rawtypes")
	JList ma_list;
	@SuppressWarnings("rawtypes")
	JList mw_list;
	@SuppressWarnings("rawtypes")
	JList lands_list;
	JLabel home_label;
	JLabel pandt_label;
	JLabel dal_label;
	JLabel ma_label;
	JLabel mw_label;
	JLabel lands_label;

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public HelpPanel(String ID) {
		setForeground(new Color(51, 0, 204));

		setBackground(new Color(255, 255, 255));

		setBounds(0, 0, 1200, 700);
		setLayout(null);

		RoundedPanel panel_1 = new RoundedPanel(15);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(328, 107, 763, 332);
		add(panel_1);
		panel_1.setLayout(null);

		JList home_list = new JList();
		home_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		home_list.setForeground(new Color(51, 0, 204));

		// home_list.setVisible(false); // Initially, hide this list

		home_list.setBounds(10, 52, 743, 280);
		home_list.setModel(new AbstractListModel() {
			String[] values = new String[] { "How do I issue a refund?", "",
					"How do I escalate a PHPAY dispute to a claim?", "",
					"Why is the payment I sent pending or unclaimed? Can I cancel it?", "",
					"How can I release my payment(s) on hold?", "",
					"How do I add and confirm, change or remove a phone number on my PHPAY account?", "",
					"How do I remove a limitation from my account?", "",
					"How do I add money to my PHPAY account from my bank?", "",
					"I forgot my password. How do I reset it?", "", "How do I open a dispute with a seller?" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_1.add(home_list);

		JList pandt_list = new JList();
		pandt_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		pandt_list.setForeground(new Color(51, 0, 204));

		pandt_list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Canceling a Payment", "", "Payment Holds", "", "Refunds", "", "Transfers",
					"", "Sending Money", "", "Receiving Money", "", "Fees\t" };

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

		JList dal_list = new JList();
		dal_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		dal_list.setForeground(new Color(51, 0, 204));
		dal_list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Disputes and Claims", "", "Account Limitations", "",
					"Unauthorized Transactions" };

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

		JList ma_list = new JList();
		ma_list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Profile and Settings", "", "Account Status", "", "PayPal Basics", "",
					"Policies", "", "Notifications", "", "Nonprofits and Donations", "", "Tax Information" };

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

		JList mw_list = new JList();
		mw_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		mw_list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Bank Accounts", "", "Credit and Debit Cards", "",
					"Balance and Currencies", "", "Store Offers, Coupons, & Gift Cards\t" };

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

		JList lands_list = new JList();
		lands_list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		lands_list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Password & Login Issues", "", "Fraudulent Emails & Scams", "",
					"Security\t" };

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

		JLabel home_label = new JLabel("Common Questions");
		home_label.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		home_label.setBounds(10, 11, 251, 30);
		home_label.setForeground(new Color(0, 0, 0));
		// home_label.setVisible(false); // Initially, hide this label

		panel_1.add(home_label);

		JLabel pandt_label = new JLabel("Payments and Transfers");
		pandt_label.setForeground(new Color(0, 0, 0));
		pandt_label.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		pandt_label.setBounds(10, 11, 251, 30);
		panel_1.add(pandt_label);
		pandt_label.setVisible(false); // Initially, hide this label

		JLabel dal_label = new JLabel("Disputes and Limitations\r\n");
		dal_label.setForeground(new Color(0, 0, 0));
		dal_label.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		dal_label.setBounds(10, 11, 251, 30);
		dal_label.setVisible(false); // Initially, hide this label

		panel_1.add(dal_label);

		JLabel ma_label = new JLabel("My Account\r\n");
		ma_label.setForeground(new Color(0, 0, 0));
		ma_label.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		ma_label.setBounds(10, 11, 251, 30);
		ma_label.setVisible(false); // Initially, hide this label

		panel_1.add(ma_label);

		JLabel mw_label = new JLabel("My Wallet");
		mw_label.setForeground(new Color(0, 0, 0));
		mw_label.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		mw_label.setBounds(10, 11, 251, 30);
		mw_label.setVisible(false); // Initially, hide this label

		panel_1.add(mw_label);

		JLabel lands_label = new JLabel("Login & Security");
		lands_label.setForeground(new Color(0, 0, 0));
		lands_label.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		lands_label.setBounds(10, 11, 251, 30);
		lands_label.setVisible(false); // Initially, hide this label

		panel_1.add(lands_label);

		JList list = new JList();
		list.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 25));
		list.setForeground(new Color(0, 0, 0));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (list.getSelectedValue().equals("Home")) {
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

				} else if (list.getSelectedValue().equals("Payments and Transfers")) {
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
				} else if (list.getSelectedValue().equals("Disputes and Limitations")) {
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
				} else if (list.getSelectedValue().equals("My Account")) {
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
				} else if (list.getSelectedValue().equals("My Wallet")) {
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
				} else if (list.getSelectedValue().equals("Login & Security")) {
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

		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Home", "", "", "", "", "", "", "", "", "Payments and Transfers", "", "",
					"", "", "", "", "", "", "Disputes and Limitations", "", "", "", "", "", "", "", "", "My Account",
					"", "", "", "", "", "", "", "", "My Wallet", "", "", "", "", "", "", "", "", "Login & Security", "",
					"", "", "", "" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		list.setBounds(10, 123, 271, 305);
		add(list);
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(-184, -15, 1470, 111);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("How can we help you?");
		lblNewLabel_1_1.setBounds(185, 61, 344, 32);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 25));

		JLabel lblNewLabel_1 = new JLabel("Help Center - Personal Account");
		lblNewLabel_1.setBounds(185, 29, 328, 21);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		JPanel panel_2 = new JPanel();

		panel_2.setBackground(new Color(51, 0, 204));
		panel_2.setBounds(146, 521, 928, 1);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Help\r\n");
		lblNewLabel_11.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setBounds(435, 496, 46, 14);
		add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("Contact");
		lblNewLabel_11_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_1.setBounds(491, 496, 46, 14);
		add(lblNewLabel_11_1);

		JLabel lblNewLabel_11_2 = new JLabel("Fees");
		lblNewLabel_11_2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2.setBounds(558, 496, 46, 14);
		add(lblNewLabel_11_2);

		JLabel lblNewLabel_11_2_1 = new JLabel("Security");
		lblNewLabel_11_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_1.setBounds(614, 496, 46, 14);
		add(lblNewLabel_11_2_1);

		JLabel lblNewLabel_11_2_2 = new JLabel("Apps");
		lblNewLabel_11_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_2.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_2.setBounds(682, 496, 46, 14);
		add(lblNewLabel_11_2_2);

		JLabel lblNewLabel_11_2_3 = new JLabel("Partners");
		lblNewLabel_11_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_3.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_3.setBounds(723, 534, 46, 14);
		add(lblNewLabel_11_2_3);

		JLabel lblNewLabel_11_2_4 = new JLabel("Developers");
		lblNewLabel_11_2_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_4.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_4.setBounds(636, 534, 87, 14);
		add(lblNewLabel_11_2_4);

		JLabel lblNewLabel_11_2_5 = new JLabel("Jobs");
		lblNewLabel_11_2_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_5.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_5.setBounds(578, 533, 46, 14);
		add(lblNewLabel_11_2_5);

		JLabel lblNewLabel_11_2_6 = new JLabel("Newsroom");
		lblNewLabel_11_2_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_6.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_6.setBounds(500, 533, 74, 14);
		add(lblNewLabel_11_2_6);

		JLabel lblNewLabel_11_2_7 = new JLabel("About");
		lblNewLabel_11_2_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_7.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11_2_7.setBounds(434, 533, 46, 14);
		add(lblNewLabel_11_2_7);

		JLabel lblNewLabel_11_2_8 = new JLabel("Accesibility");
		lblNewLabel_11_2_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_8.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_8.setBounds(510, 571, 73, 14);
		add(lblNewLabel_11_2_8);

		JLabel lblNewLabel_11_2_9 = new JLabel("Privacy");
		lblNewLabel_11_2_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_9.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_9.setBounds(593, 571, 57, 14);
		add(lblNewLabel_11_2_9);

		JLabel lblNewLabel_11_2_10 = new JLabel("Cookies");
		lblNewLabel_11_2_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_10.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_10.setBounds(660, 571, 63, 14);
		add(lblNewLabel_11_2_10);

		JLabel lblNewLabel_11_2_11 = new JLabel("Legal");
		lblNewLabel_11_2_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_11.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_11.setBounds(723, 571, 46, 14);
		add(lblNewLabel_11_2_11);

		JLabel lblNewLabel_11_2_12 = new JLabel("©2022-2023");
		lblNewLabel_11_2_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_12.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_12.setBounds(418, 571, 80, 14);
		add(lblNewLabel_11_2_12);

		JLabel lblNewLabel_11_2_13 = new JLabel("Shop");
		lblNewLabel_11_2_13.setForeground(new Color(0, 0, 0));
		lblNewLabel_11_2_13.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblNewLabel_11_2_13.setBounds(738, 496, 46, 14);
		add(lblNewLabel_11_2_13);

		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(298, 96, 1, 367);
		add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"<html>PHPay Pte Ltd is (i) licensed by the Monetary Authority of Singapore as a Major Payment Institution under the Payment Services Act 2019 and (ii) regulated by the Bangko Sentral ng Pilipinas <a href='https://www.bsp.gov.ph' style='color: #0000FF; text-decoration: underline;'>https://www.bsp.gov.ph</a> as an Operator of Payment Services in the Philippines under the National Payment Systems Act.<br><br>When you visit or interact with our sites, services, applications, tools or messaging, we or our authorised service providers may use cookies, web beacons, and other similar technologies for storing information to help provide you with a better, faster and safer experience and for advertising purposes. Learn more <a href='link_to_learn_more' style='color: #0000FF; text-decoration: underline;'>here</a>.</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
		lblNewLabel.setBounds(33, 583, 1157, 116);
		add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setIcon(new ImageIcon(HelpPanel.class.getResource("/PHPay/phpimg/philippines (1).png")));
		lblNewLabel_2.setBounds(579, 471, 30, 14);
		add(lblNewLabel_2);
	}

	@SuppressWarnings("unused")
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

	}
}
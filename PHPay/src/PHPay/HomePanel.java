package PHPay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class HomePanel extends JPanel {
	private JScrollPane scrollPane;
	ScrollBarCustom phpayScroll;
	private RoundedPanel bluePanel;
	private RoundedPanel blackPanel;
	private JLabel partnerLabel;
	private JLabel p1;
	private JLabel p4;
	private JLabel p8;
	private JLabel p3;
	private JLabel p7;
	private JLabel p9;
	private JLabel p5;
	private JLabel p2;
	private JLabel p10;
	private JLabel p6;
	private JLabel lblYourWayTo;
	private JLabel lbll1;
	private JLabel lbll2;
	private JLabel lblPhpayValuesYour;
	private JLabel lblWeAreAn;
	private JLabel lblLicensedByThe;
	private JLabel lblRegulatedByThe;
	private JLabel lblInGcash;
	private JLabel lblPhpayValuesGcash;
	private JLabel lblPaymentWorld;
	private JLabel lblNewLabel_1;
	private JLabel lblUser;
	private JLabel lblRegisteredUsers;
	private JLabel lblNewLabel_3;
	private JLabel lblPartner;
	private JLabel lblRegisteredUsers_1;
	private JLabel lblNewLabel_5;
	private JLabel lblPhpaysRobustSecurity;
	private JLabel lblHashingTechniquesTo;
	private JLabel lblTheHighestLevel;
	private JLabel lbll3;
	private int currentLabelIndex = 0;
	private Timer timer;
	private JLabel lblNewLabel_2;
	private JLabel lblstockredemption;

	public HomePanel() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(0, 0, 1200, 1333);
		setBackground(new Color(0, 0, 0, 0));
		setForeground(new Color(0, 0, 0));
		setLayout(null);

		RoundedPanel panel = new RoundedPanel(20);
//		GradientPanel panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
//		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setPreferredSize(new Dimension(1200, 1332));
		panel.setBackground(new Color(30, 31, 33));
		add(panel);
		
//		
//		RoundedPanel panel_1 = new RoundedPanel(20);
//		panel_1.setBackground(new Color(64, 0, 128));
//		panel_1.setBounds(10, 11, 303, 115);
//		panel.add(panel_1);
//		panel_1.setLayout(null);

		scrollPane = new JScrollPane(panel);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(null);


		bluePanel = new RoundedPanel(25);
		bluePanel.setBounds(10, 1011, 1180, 260);
		bluePanel.setBackground(new Color(255, 255, 255, 15));
		bluePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(bluePanel);
		bluePanel.setLayout(null);

		partnerLabel = new JLabel("Partners");
		partnerLabel.setBorder(new CompoundBorder());
		partnerLabel.setForeground(new Color(255, 255, 255));
		partnerLabel.setFont(new Font("Couture", Font.PLAIN, 40));
		partnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partnerLabel.setBounds(0, 43, 1180, 49);
		bluePanel.add(partnerLabel);

		p1 = new JLabel("");
		p1.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner1.png")));
		p1.setBounds(53, 24, 80, 80);
		bluePanel.add(p1);

		p4 = new JLabel("");
		p4.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner2.png")));
		p4.setBounds(245, 150, 80, 80);
		bluePanel.add(p4);

		p8 = new JLabel("");
		p8.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner3.png")));
		p8.setBounds(824, 150, 80, 80);
		bluePanel.add(p8);

		p3 = new JLabel("");
		p3.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner4.png")));
		p3.setBounds(245, 24, 80, 80);
		bluePanel.add(p3);

		p7 = new JLabel("");
		p7.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner5.png")));
		p7.setBounds(824, 24, 80, 80);
		bluePanel.add(p7);

		p9 = new JLabel("");
		p9.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner6.png")));
		p9.setBounds(1012, 24, 80, 80);
		bluePanel.add(p9);

		p5 = new JLabel("");
		p5.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner7.png")));
		p5.setBounds(448, 114, 80, 80);
		bluePanel.add(p5);

		p2 = new JLabel("");
		p2.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner8.png")));
		p2.setBounds(53, 150, 80, 80);
		bluePanel.add(p2);

		p10 = new JLabel("");
		p10.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner9.png")));
		p10.setBounds(1012, 150, 80, 80);
		bluePanel.add(p10);

		p6 = new JLabel("");
		p6.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner10.png")));
		p6.setBounds(615, 114, 80, 80);
		bluePanel.add(p6);

		blackPanel = new RoundedPanel(15);
		blackPanel.setBounds(10, 1290, 1180, 45);
		blackPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		blackPanel.setBackground(new Color(0, 0, 0));
		panel.add(blackPanel);
		blackPanel.setLayout(null);

		JLabel lblCopyright = new JLabel("Copyright © 2021 PHPay. All Rights Reserved.");
		lblCopyright.setVerticalAlignment(SwingConstants.TOP);
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblCopyright.setBounds(765, 14, 405, 21);
		blackPanel.add(lblCopyright);

		lblstockredemption = new JLabel("5StockRedemption");
		lblstockredemption.setVerticalAlignment(SwingConstants.TOP);
		lblstockredemption.setHorizontalAlignment(SwingConstants.LEFT);
		lblstockredemption.setForeground(Color.WHITE);
		lblstockredemption.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblstockredemption.setBounds(10, 14, 405, 21);
		blackPanel.add(lblstockredemption);

		lblPhpayValuesYour = new JLabel("PHPay values your account’s security");
		lblPhpayValuesYour.setBounds(108, 710, 774, 61);
		lblPhpayValuesYour.setVerticalAlignment(SwingConstants.TOP);
		lblPhpayValuesYour.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhpayValuesYour.setForeground(new Color(255, 255, 255));
		lblPhpayValuesYour.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 35));
		panel.add(lblPhpayValuesYour);

		lblWeAreAn = new JLabel("We are an authorized e-money issuer and remittance agent ");
		lblWeAreAn.setBounds(118, 803, 425, 21);
		lblWeAreAn.setVerticalAlignment(SwingConstants.TOP);
		lblWeAreAn.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeAreAn.setForeground(new Color(255, 255, 255));
		lblWeAreAn.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		panel.add(lblWeAreAn);

		lblLicensedByThe = new JLabel("licensed by the BSP, ensuring the security of your funds.");
		lblLicensedByThe.setBounds(118, 824, 425, 21);
		lblLicensedByThe.setVerticalAlignment(SwingConstants.TOP);
		lblLicensedByThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblLicensedByThe.setForeground(new Color(255, 255, 255));
		lblLicensedByThe.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		panel.add(lblLicensedByThe);

		lblRegulatedByThe = new JLabel("Regulated by the Bangko Sentral ng Pilipinas");
		lblRegulatedByThe.setBounds(118, 761, 425, 21);
		lblRegulatedByThe.setVerticalAlignment(SwingConstants.TOP);
		lblRegulatedByThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegulatedByThe.setForeground(new Color(255, 255, 255));
		lblRegulatedByThe.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 15));
		panel.add(lblRegulatedByThe);

		JPanel memberPanel = new JPanel();
		memberPanel.setBounds(0, 436, 1200, 197);
		memberPanel.setBackground(new Color(64, 0, 128));
		panel.add(memberPanel);
		memberPanel.setLayout(null);

		lblInGcash = new JLabel(
				"In 2022, PHPay had 4 million users and over 22,000 partner stores all over the country.");
		lblInGcash.setBounds(474, 153, 726, 21);
		memberPanel.add(lblInGcash);
		lblInGcash.setVerticalAlignment(SwingConstants.TOP);
		lblInGcash.setHorizontalAlignment(SwingConstants.CENTER);
		lblInGcash.setForeground(new Color(192, 192, 192));
		lblInGcash.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblPhpayValuesGcash = new JLabel("PHPay is shaping a digital");
		lblPhpayValuesGcash.setBounds(0, 39, 591, 75);
		memberPanel.add(lblPhpayValuesGcash);
		lblPhpayValuesGcash.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhpayValuesGcash.setForeground(new Color(255, 255, 255));
		lblPhpayValuesGcash.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 40));

		lblPaymentWorld = new JLabel("payment world");
		lblPaymentWorld.setBounds(0, 90, 591, 90);
		memberPanel.add(lblPaymentWorld);
		lblPaymentWorld.setVerticalAlignment(SwingConstants.TOP);
		lblPaymentWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentWorld.setForeground(new Color(255, 255, 255));
		lblPaymentWorld.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 40));

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(864, 39, 86, 99);
		memberPanel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partnerships.png")));

		lblPartner = new JLabel("1M");
		lblPartner.setBounds(954, 39, 120, 90);
		lblPartner.setForeground(new Color(255, 255, 255));
		lblPartner.setVisible(false);
		memberPanel.add(lblPartner);
		lblPartner.setFont(new Font("Segoe UI Symbol", Font.BOLD, 43));

		lblRegisteredUsers_1 = new JLabel("Partner Merchants");
		lblRegisteredUsers_1.setBounds(954, 107, 192, 21);
		memberPanel.add(lblRegisteredUsers_1);
		lblRegisteredUsers_1.setVerticalAlignment(SwingConstants.TOP);
		lblRegisteredUsers_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisteredUsers_1.setForeground(new Color(192, 192, 192));
		lblRegisteredUsers_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblUser = new JLabel("11M");
		lblUser.setBounds(713, 37, 120, 90);
		lblUser.setForeground(new Color(255, 255, 255));
		memberPanel.add(lblUser);
		lblUser.setVisible(false);
		lblUser.setFont(new Font("Segoe UI Symbol", Font.BOLD, 43));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(633, 37, 70, 99);
		memberPanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/users.png")));

		lblRegisteredUsers = new JLabel("Registered Users");
		lblRegisteredUsers.setBounds(713, 105, 192, 21);
		memberPanel.add(lblRegisteredUsers);
		lblRegisteredUsers.setVerticalAlignment(SwingConstants.TOP);
		lblRegisteredUsers.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisteredUsers.setForeground(new Color(192, 192, 192));
		lblRegisteredUsers.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblPhpaysRobustSecurity = new JLabel("PHPAY's robust security utilizes cutting-edge encryption algorithms and");
		lblPhpaysRobustSecurity.setBounds(118, 866, 543, 21);
		lblPhpaysRobustSecurity.setVerticalAlignment(SwingConstants.TOP);
		lblPhpaysRobustSecurity.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhpaysRobustSecurity.setForeground(new Color(255, 255, 255));
		lblPhpaysRobustSecurity.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		panel.add(lblPhpaysRobustSecurity);

		lblHashingTechniquesTo = new JLabel(
				"hashing techniques to protect your personal information and financial data with ");
		lblHashingTechniquesTo.setBounds(118, 887, 543, 21);
		lblHashingTechniquesTo.setVerticalAlignment(SwingConstants.TOP);
		lblHashingTechniquesTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHashingTechniquesTo.setForeground(new Color(255, 255, 255));
		lblHashingTechniquesTo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		panel.add(lblHashingTechniquesTo);

		lblTheHighestLevel = new JLabel("the highest level of assurance.");
		lblTheHighestLevel.setBounds(118, 908, 543, 21);
		lblTheHighestLevel.setVerticalAlignment(SwingConstants.TOP);
		lblTheHighestLevel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheHighestLevel.setForeground(new Color(255, 255, 255));
		lblTheHighestLevel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		panel.add(lblTheHighestLevel);

		scrollPane.setBounds(0, 0, 1200, 700);
//		scrollPane.setBounds(0, 0, 1200, 1333);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);

		phpayScroll = new ScrollBarCustom();
		phpayScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		phpayScroll.setBlockIncrement(1);
		phpayScroll.setBackground(new Color(255, 255, 255));
		phpayScroll.setForeground(new Color(192, 192, 192));
		phpayScroll.setUnitIncrement(10);
		scrollPane.setVerticalScrollBar(phpayScroll);

		countUpLabel1(lblUser);
		countUpLabel2(lblPartner);

		RoundedPanel bluePanel_1 = new RoundedPanel(50);
		bluePanel_1.setBounds(-101, 75, 1180, 260);
		bluePanel_1.setLayout(null);
		bluePanel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		bluePanel_1.setBackground(new Color(255, 255, 255, 15));
		panel.add(bluePanel_1);

		lblYourWayTo = new JLabel("Your Way To Pay");
		lblYourWayTo.setBounds(585, 24, 569, 164);
		bluePanel_1.add(lblYourWayTo);
		lblYourWayTo.setForeground(new Color(255, 255, 255));
		lblYourWayTo.setVerticalAlignment(SwingConstants.TOP);
		lblYourWayTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblYourWayTo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 66));

		lbll1 = new JLabel("Your Virtual Wallet for a Seamless Financial Experience.");
		lbll1.setBounds(600, 123, 394, 21);
		bluePanel_1.add(lbll1);
		lbll1.setVerticalAlignment(SwingConstants.TOP);
		lbll1.setHorizontalAlignment(SwingConstants.LEFT);
		lbll1.setForeground(new Color(255, 255, 255));
		lbll1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lbll2 = new JLabel("Join a community of satisfied users who trust PHPAY ");
		lbll2.setBounds(600, 144, 394, 21);
		bluePanel_1.add(lbll2);
		lbll2.setVerticalAlignment(SwingConstants.TOP);
		lbll2.setHorizontalAlignment(SwingConstants.LEFT);
		lbll2.setForeground(new Color(255, 255, 255));
		lbll2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lbll3 = new JLabel("for their everyday financial needs.");
		lbll3.setBounds(600, 167, 394, 21);
		bluePanel_1.add(lbll3);
		lbll3.setVerticalAlignment(SwingConstants.TOP);
		lbll3.setHorizontalAlignment(SwingConstants.LEFT);
		lbll3.setForeground(new Color(255, 255, 255));
		lbll3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/walletBG.png")));
		lblNewLabel.setBounds(153, 0, 402, 260);
		bluePanel_1.add(lblNewLabel);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1200, 1333);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		panel.add(gradientPanel);
		gradientPanel.setLayout(null);
		
				lblNewLabel_5 = new JLabel("");
				lblNewLabel_5.setBounds(640, 656, 550, 381);
				gradientPanel.add(lblNewLabel_5);
				lblNewLabel_5.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/security.png")));
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);

//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/backgroundHome.png")));
//		lblNewLabel.setBounds(0, 0, 1200, 750);
//		panel.add(lblNewLabel);
//		
//		lblNewLabel_2 = new JLabel("New label");
//		lblNewLabel_2.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/backgroundHome.png")));
//		lblNewLabel_2.setBounds(0, 749, 1200, 502);
//		panel.add(lblNewLabel_2);

	}

	private void countUpLabel1(final JLabel label) {
		Timer timer = new Timer(100, new ActionListener() {
			long currentValue = 0;
			final long targetValue = 11; // 11M
			DecimalFormat formatter = new DecimalFormat("#,###M");
			float opacity = 0.0f; // Initial opacity

			@Override
			public void actionPerformed(ActionEvent e) {
				currentValue += 1; // Increment by 1M
				if (currentValue <= targetValue) {
					label.setText(formatter.format(currentValue));

					opacity += 0.05f; // Adjust the step size for the fade-in effect
					if (opacity > 1.0f) {
						opacity = 1.0f;
					}
					label.setOpaque(true);
					label.setBackground(label.getBackground());
					label.setForeground(label.getForeground());

					// Apply the opacity to the label
					label.setOpaque(false);
					label.repaint();
					label.setForeground(label.getForeground());
					label.setBackground(label.getBackground());
				} else {
					label.setText(formatter.format(targetValue));
					((Timer) e.getSource()).stop();

				}
			}
		});

		label.setOpaque(false);

		label.setVisible(true);
		timer.start();
	}

	private void countUpLabel2(final JLabel label) {
		Timer timer = new Timer(80, new ActionListener() {
			int currentValue = 0;
			final int targetValue = 900; // 1M
			final int stepValue = 40; // 100K
			DecimalFormat formatter = new DecimalFormat("#,###K");

			@Override
			public void actionPerformed(ActionEvent e) {
				currentValue += stepValue; // Increment by 100K
				if (currentValue <= targetValue) {
					label.setText(formatter.format(currentValue));
				} else {
					label.setText(formatter.format(targetValue));
					((Timer) e.getSource()).stop();
				}
			}
		});
		label.setVisible(true);
		timer.start();
	}
}

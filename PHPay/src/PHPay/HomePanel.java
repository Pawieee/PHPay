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
		setBounds(0, 0, 1200, 1220);
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
		setLayout(null);

		GradientPanel panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setPreferredSize(new Dimension(1200, 1220));
		panel.setBackground(new Color(30, 31, 33));

		scrollPane = new JScrollPane(panel);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(null);

		bluePanel = new RoundedPanel(25);
		bluePanel.setBackground(new Color(255, 255, 255, 15));
		bluePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		bluePanel.setBounds(10, 915, 1180, 260);
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
		blackPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		blackPanel.setBackground(new Color(0, 0, 0));
		blackPanel.setBounds(10, 1186, 1180, 45);
		panel.add(blackPanel);
		blackPanel.setLayout(null);

		JLabel lblCopyright = new JLabel("Copyright © 2021 PHPay. All Rights Reserved.");
		lblCopyright.setVerticalAlignment(SwingConstants.TOP);
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblCopyright.setBounds(765, 0, 405, 21);
		blackPanel.add(lblCopyright);

		lblstockredemption = new JLabel("5StockRedemption");
		lblstockredemption.setVerticalAlignment(SwingConstants.TOP);
		lblstockredemption.setHorizontalAlignment(SwingConstants.LEFT);
		lblstockredemption.setForeground(Color.WHITE);
		lblstockredemption.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblstockredemption.setBounds(10, 6, 405, 21);
		blackPanel.add(lblstockredemption);

		lblPhpayValuesYour = new JLabel("PHPay values your account’s security");
		lblPhpayValuesYour.setVerticalAlignment(SwingConstants.TOP);
		lblPhpayValuesYour.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhpayValuesYour.setForeground(new Color(255, 255, 255));
		lblPhpayValuesYour.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 35));
		lblPhpayValuesYour.setBounds(45, 633, 774, 61);
		panel.add(lblPhpayValuesYour);

		lblWeAreAn = new JLabel("We are an authorized e-money issuer and remittance agent ");
		lblWeAreAn.setVerticalAlignment(SwingConstants.TOP);
		lblWeAreAn.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeAreAn.setForeground(new Color(255, 255, 255));
		lblWeAreAn.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblWeAreAn.setBounds(55, 726, 425, 21);
		panel.add(lblWeAreAn);

		lblLicensedByThe = new JLabel("licensed by the BSP, ensuring the security of your funds.");
		lblLicensedByThe.setVerticalAlignment(SwingConstants.TOP);
		lblLicensedByThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblLicensedByThe.setForeground(new Color(255, 255, 255));
		lblLicensedByThe.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblLicensedByThe.setBounds(55, 747, 425, 21);
		panel.add(lblLicensedByThe);

		lblRegulatedByThe = new JLabel("Regulated by the Bangko Sentral ng Pilipinas");
		lblRegulatedByThe.setVerticalAlignment(SwingConstants.TOP);
		lblRegulatedByThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegulatedByThe.setForeground(new Color(255, 255, 255));
		lblRegulatedByThe.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 15));
		lblRegulatedByThe.setBounds(55, 684, 425, 21);
		panel.add(lblRegulatedByThe);

		JPanel memberPanel = new JPanel();
		memberPanel.setBackground(new Color(255, 255, 255));
		memberPanel.setBounds(0, 384, 1200, 197);
		panel.add(memberPanel);
		memberPanel.setLayout(null);

		lblInGcash = new JLabel(
				"In 2022, PHPay had 4 million users and over 22,000 partner stores all over the country.");
		lblInGcash.setBounds(0, 153, 1200, 21);
		memberPanel.add(lblInGcash);
		lblInGcash.setVerticalAlignment(SwingConstants.TOP);
		lblInGcash.setHorizontalAlignment(SwingConstants.CENTER);
		lblInGcash.setForeground(new Color(78, 78, 78));
		lblInGcash.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblPhpayValuesGcash = new JLabel("PHPay is shaping a digital");
		lblPhpayValuesGcash.setBounds(512, 11, 688, 75);
		memberPanel.add(lblPhpayValuesGcash);
		lblPhpayValuesGcash.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhpayValuesGcash.setForeground(new Color(102, 0, 255));
		lblPhpayValuesGcash.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 50));

		lblPaymentWorld = new JLabel("payment world");
		lblPaymentWorld.setBounds(512, 74, 688, 90);
		memberPanel.add(lblPaymentWorld);
		lblPaymentWorld.setVerticalAlignment(SwingConstants.TOP);
		lblPaymentWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentWorld.setForeground(new Color(102, 0, 255));
		lblPaymentWorld.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 50));

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(300, 43, 86, 99);
		memberPanel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partnerships.png")));

		lblPartner = new JLabel("1M");
		lblPartner.setBounds(390, 43, 120, 90);
		lblPartner.setVisible(false);
		memberPanel.add(lblPartner);
		lblPartner.setFont(new Font("Segoe UI Symbol", Font.BOLD, 43));

		lblRegisteredUsers_1 = new JLabel("Partner Merchants");
		lblRegisteredUsers_1.setBounds(390, 111, 192, 21);
		memberPanel.add(lblRegisteredUsers_1);
		lblRegisteredUsers_1.setVerticalAlignment(SwingConstants.TOP);
		lblRegisteredUsers_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisteredUsers_1.setForeground(new Color(78, 78, 78));
		lblRegisteredUsers_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblUser = new JLabel("11M");
		lblUser.setBounds(170, 43, 120, 90);
		memberPanel.add(lblUser);
		lblUser.setVisible(false);
		lblUser.setFont(new Font("Segoe UI Symbol", Font.BOLD, 43));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(90, 43, 70, 99);
		memberPanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/users.png")));

		lblRegisteredUsers = new JLabel("Registered Users");
		lblRegisteredUsers.setBounds(170, 111, 192, 21);
		memberPanel.add(lblRegisteredUsers);
		lblRegisteredUsers.setVerticalAlignment(SwingConstants.TOP);
		lblRegisteredUsers.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisteredUsers.setForeground(new Color(78, 78, 78));
		lblRegisteredUsers.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/security.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(640, 568, 550, 357);
		panel.add(lblNewLabel_5);

		lblPhpaysRobustSecurity = new JLabel("PHPAY's robust security utilizes cutting-edge encryption algorithms and");
		lblPhpaysRobustSecurity.setVerticalAlignment(SwingConstants.TOP);
		lblPhpaysRobustSecurity.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhpaysRobustSecurity.setForeground(new Color(255, 255, 255));
		lblPhpaysRobustSecurity.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblPhpaysRobustSecurity.setBounds(55, 789, 543, 21);
		panel.add(lblPhpaysRobustSecurity);

		lblHashingTechniquesTo = new JLabel(
				"hashing techniques to protect your personal information and financial data with ");
		lblHashingTechniquesTo.setVerticalAlignment(SwingConstants.TOP);
		lblHashingTechniquesTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHashingTechniquesTo.setForeground(new Color(255, 255, 255));
		lblHashingTechniquesTo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblHashingTechniquesTo.setBounds(55, 810, 543, 21);
		panel.add(lblHashingTechniquesTo);

		lblTheHighestLevel = new JLabel("the highest level of assurance.");
		lblTheHighestLevel.setVerticalAlignment(SwingConstants.TOP);
		lblTheHighestLevel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheHighestLevel.setForeground(new Color(255, 255, 255));
		lblTheHighestLevel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblTheHighestLevel.setBounds(55, 831, 543, 21);
		panel.add(lblTheHighestLevel);

		scrollPane.setBounds(0, 0, 1200, 610);
//		scrollPane.setBounds(0, 0, 1200, 1220);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);

		phpayScroll = new ScrollBarCustom();
		phpayScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		phpayScroll.setBlockIncrement(1);
		phpayScroll.setBackground(new Color(255, 255, 255));
		phpayScroll.setForeground(new Color(192, 192, 192));
		phpayScroll.setUnitIncrement(10);
		scrollPane.setVerticalScrollBar(phpayScroll);

		RoundedPanel bgpane = new RoundedPanel(15);
		bgpane.setBackground(new Color(255, 255, 255, 35));
		bgpane.setBounds(575, 40, 591, 305);
		panel.add(bgpane);
		bgpane.setLayout(null);

		lbll3 = new JLabel("for their everyday financial needs.");
		lbll3.setBounds(220, 220, 394, 21);
		panel.add(lbll3);
		lbll3.setVerticalAlignment(SwingConstants.TOP);
		lbll3.setHorizontalAlignment(SwingConstants.LEFT);
		lbll3.setForeground(new Color(255, 255, 255));
		lbll3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		slideAndFadeInLabel(lbll3);

		lblYourWayTo = new JLabel("Your Way To Pay");
		lblYourWayTo.setBounds(29, 77, 569, 164);
		panel.add(lblYourWayTo);
		lblYourWayTo.setForeground(new Color(255, 255, 255));
		lblYourWayTo.setVerticalAlignment(SwingConstants.TOP);
		lblYourWayTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblYourWayTo.setFont(new Font("Segoe UI Historic", Font.BOLD, 66));

		lbll1 = new JLabel("Your Virtual Wallet for a Seamless Financial Experience.");
		lbll1.setBounds(220, 176, 394, 21);
		panel.add(lbll1);
		lbll1.setVerticalAlignment(SwingConstants.TOP);
		lbll1.setHorizontalAlignment(SwingConstants.LEFT);
		lbll1.setForeground(new Color(255, 255, 255));
		lbll1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		slideAndFadeInLabel(lbll1);

		lbll2 = new JLabel("Join a community of satisfied users who trust PHPAY ");
		lbll2.setBounds(220, 197, 394, 21);
		panel.add(lbll2);
		lbll2.setVerticalAlignment(SwingConstants.TOP);
		lbll2.setHorizontalAlignment(SwingConstants.LEFT);
		lbll2.setForeground(new Color(255, 255, 255));
		lbll2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		slideAndFadeInLabel(lbll2);

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

	private void slideAndFadeInLabel(final JLabel label) {
		Timer timer = new Timer(50, new ActionListener() {
			int startX = label.getX();
			int targetX = 38; // The final X position
			float alpha = 0.0f; // The initial alpha (transparency)

			@Override
			public void actionPerformed(ActionEvent e) {
				if (startX > targetX) {
					startX -= 5; // Adjust the sliding speed here
					if (startX < targetX) {
						startX = targetX;
					}
				}

				alpha += 0.02f; // Adjust the fading speed here
				if (alpha > 1.0f) {
					alpha = 1.0f;
				}

				label.setBounds(startX, label.getY(), label.getWidth(), label.getHeight());
				label.setForeground(new Color(255, 255, 255, Math.min(255, (int) (alpha * 255))));

				if (startX == targetX && alpha == 1.0f) {
					((Timer) e.getSource()).stop();
					countUpLabel1(lblUser);
					countUpLabel2(lblPartner);
				}
			}
		});

		timer.start();
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
			final int stepValue = 50; // 100K
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

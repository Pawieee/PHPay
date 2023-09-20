package PHPay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JLabel lblNewLabel;
	private JLabel lblYourWayTo;
	private JLabel lblPay;
	private JLabel lblYourVirtualWallet;
	private JLabel lblXperienceTheFreedom;
	private JLabel lblPhpayValuesYour;
	private JLabel lblWeAreAn;
	private JLabel lblLicensedByThe;
	private JLabel lblRegulatedByThe;
	private JLabel lblInGcash;
	private JLabel lblPhpayValuesGcash;
	private JLabel lblPaymentWorld;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblRegisteredUsers;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblRegisteredUsers_1;
	private JLabel lblNewLabel_5;
	private JLabel lblPhpaysRobustSecurity;
	private JLabel lblHashingTechniquesTo;
	private JLabel lblTheHighestLevel;
	private JLabel lblForTheirEveryday;
	private JPanel adsPanel;
	private JLabel label1, label2;
	private int currentLabelIndex = 0;
	private Timer timer;

	public HomePanel() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBounds(0, 0, 1200, 1225);
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setPreferredSize(new Dimension(1200, 1225));
		panel.setBackground(new Color(255, 255, 255));

		scrollPane = new JScrollPane(panel);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(null);

		bluePanel = new RoundedPanel(25);
		bluePanel.setBackground(new Color(30, 144, 255));
		bluePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		bluePanel.setBounds(10, 919, 1180, 260);
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
		blackPanel.setBounds(10, 1190, 1180, 45);
		panel.add(blackPanel);
		blackPanel.setLayout(null);

		lblNewLabel = new JLabel("PHPay.");
		lblNewLabel.setForeground(new Color(102, 0, 255));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 35));
		lblNewLabel.setBounds(70, 124, 202, 45);
		panel.add(lblNewLabel);

		lblYourWayTo = new JLabel("Your way to");
		lblYourWayTo.setForeground(new Color(0, 0, 0));
		lblYourWayTo.setVerticalAlignment(SwingConstants.TOP);
		lblYourWayTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblYourWayTo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 35));
		lblYourWayTo.setBounds(70, 159, 202, 57);
		panel.add(lblYourWayTo);

		lblPay = new JLabel("Pay.");
		lblPay.setVerticalAlignment(SwingConstants.TOP);
		lblPay.setHorizontalAlignment(SwingConstants.LEFT);
		lblPay.setForeground(new Color(102, 0, 255));
		lblPay.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 35));
		lblPay.setBounds(260, 159, 86, 57);
		panel.add(lblPay);

		lblYourVirtualWallet = new JLabel("Your Virtual Wallet for a Seamless Financial Experience.");
		lblYourVirtualWallet.setVerticalAlignment(SwingConstants.TOP);
		lblYourVirtualWallet.setHorizontalAlignment(SwingConstants.LEFT);
		lblYourVirtualWallet.setForeground(new Color(0, 0, 0));
		lblYourVirtualWallet.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblYourVirtualWallet.setBounds(70, 224, 380, 21);
		panel.add(lblYourVirtualWallet);

		lblXperienceTheFreedom = new JLabel("Join a community of satisfied users who trust PHPAY ");
		lblXperienceTheFreedom.setVerticalAlignment(SwingConstants.TOP);
		lblXperienceTheFreedom.setHorizontalAlignment(SwingConstants.LEFT);
		lblXperienceTheFreedom.setForeground(Color.BLACK);
		lblXperienceTheFreedom.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblXperienceTheFreedom.setBounds(70, 245, 594, 21);
		panel.add(lblXperienceTheFreedom);

		lblPhpayValuesYour = new JLabel("PHPay values your account’s security");
		lblPhpayValuesYour.setVerticalAlignment(SwingConstants.TOP);
		lblPhpayValuesYour.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhpayValuesYour.setForeground(new Color(102, 0, 255));
		lblPhpayValuesYour.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		lblPhpayValuesYour.setBounds(121, 634, 425, 34);
		panel.add(lblPhpayValuesYour);

		lblWeAreAn = new JLabel("We are an authorized e-money issuer and remittance agent ");
		lblWeAreAn.setVerticalAlignment(SwingConstants.TOP);
		lblWeAreAn.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeAreAn.setForeground(new Color(78, 78, 78));
		lblWeAreAn.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblWeAreAn.setBounds(121, 711, 425, 21);
		panel.add(lblWeAreAn);

		lblLicensedByThe = new JLabel("licensed by the BSP, ensuring the security of your funds.");
		lblLicensedByThe.setVerticalAlignment(SwingConstants.TOP);
		lblLicensedByThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblLicensedByThe.setForeground(new Color(78, 78, 78));
		lblLicensedByThe.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblLicensedByThe.setBounds(121, 732, 425, 21);
		panel.add(lblLicensedByThe);

		lblRegulatedByThe = new JLabel("Regulated by the Bangko Sentral ng Pilipinas");
		lblRegulatedByThe.setVerticalAlignment(SwingConstants.TOP);
		lblRegulatedByThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegulatedByThe.setForeground(new Color(78, 78, 78));
		lblRegulatedByThe.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 15));
		lblRegulatedByThe.setBounds(121, 668, 425, 21);
		panel.add(lblRegulatedByThe);

		JPanel memberPanel = new JPanel();
		memberPanel.setBounds(0, 364, 1200, 197);
		panel.add(memberPanel);
		memberPanel.setLayout(null);

		lblInGcash = new JLabel(
				"In 2022, PHPay had 4 million users and over 22,000 partner stores all over the country.");
		lblInGcash.setBounds(286, 153, 580, 21);
		memberPanel.add(lblInGcash);
		lblInGcash.setVerticalAlignment(SwingConstants.TOP);
		lblInGcash.setHorizontalAlignment(SwingConstants.LEFT);
		lblInGcash.setForeground(new Color(78, 78, 78));
		lblInGcash.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblPhpayValuesGcash = new JLabel("PHPay is shaping a digital");
		lblPhpayValuesGcash.setBounds(166, 38, 776, 57);
		memberPanel.add(lblPhpayValuesGcash);
		lblPhpayValuesGcash.setVerticalAlignment(SwingConstants.TOP);
		lblPhpayValuesGcash.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhpayValuesGcash.setForeground(new Color(102, 0, 255));
		lblPhpayValuesGcash.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 30));

		lblPaymentWorld = new JLabel("payment world.");
		lblPaymentWorld.setBounds(387, 70, 336, 57);
		memberPanel.add(lblPaymentWorld);
		lblPaymentWorld.setVerticalAlignment(SwingConstants.TOP);
		lblPaymentWorld.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentWorld.setForeground(new Color(102, 0, 255));
		lblPaymentWorld.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 30));

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(764, 38, 86, 99);
		memberPanel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partnerships.png")));

		lblNewLabel_4 = new JLabel("1M");
		lblNewLabel_4.setBounds(854, 38, 120, 90);
		memberPanel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 43));

		lblRegisteredUsers_1 = new JLabel("Partner Merchants");
		lblRegisteredUsers_1.setBounds(854, 106, 192, 21);
		memberPanel.add(lblRegisteredUsers_1);
		lblRegisteredUsers_1.setVerticalAlignment(SwingConstants.TOP);
		lblRegisteredUsers_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisteredUsers_1.setForeground(new Color(78, 78, 78));
		lblRegisteredUsers_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblNewLabel_2 = new JLabel("11M");
		lblNewLabel_2.setBounds(233, 28, 120, 90);
		memberPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 43));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(153, 28, 70, 99);
		memberPanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/users.png")));

		lblRegisteredUsers = new JLabel("Registered Users");
		lblRegisteredUsers.setBounds(233, 96, 192, 21);
		memberPanel.add(lblRegisteredUsers);
		lblRegisteredUsers.setVerticalAlignment(SwingConstants.TOP);
		lblRegisteredUsers.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegisteredUsers.setForeground(new Color(78, 78, 78));
		lblRegisteredUsers.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/security.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(528, 561, 550, 357);
		panel.add(lblNewLabel_5);

		lblPhpaysRobustSecurity = new JLabel("PHPAY's robust security utilizes cutting-edge encryption algorithms and");
		lblPhpaysRobustSecurity.setVerticalAlignment(SwingConstants.TOP);
		lblPhpaysRobustSecurity.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhpaysRobustSecurity.setForeground(new Color(78, 78, 78));
		lblPhpaysRobustSecurity.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblPhpaysRobustSecurity.setBounds(121, 774, 543, 21);
		panel.add(lblPhpaysRobustSecurity);

		lblHashingTechniquesTo = new JLabel(
				"hashing techniques to protect your personal information and financial data with ");
		lblHashingTechniquesTo.setVerticalAlignment(SwingConstants.TOP);
		lblHashingTechniquesTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHashingTechniquesTo.setForeground(new Color(78, 78, 78));
		lblHashingTechniquesTo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblHashingTechniquesTo.setBounds(121, 795, 543, 21);
		panel.add(lblHashingTechniquesTo);

		lblTheHighestLevel = new JLabel("the highest level of assurance.");
		lblTheHighestLevel.setVerticalAlignment(SwingConstants.TOP);
		lblTheHighestLevel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheHighestLevel.setForeground(new Color(78, 78, 78));
		lblTheHighestLevel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblTheHighestLevel.setBounds(121, 816, 543, 21);
		panel.add(lblTheHighestLevel);

		lblForTheirEveryday = new JLabel("for their everyday financial needs.");
		lblForTheirEveryday.setVerticalAlignment(SwingConstants.TOP);
		lblForTheirEveryday.setHorizontalAlignment(SwingConstants.LEFT);
		lblForTheirEveryday.setForeground(Color.BLACK);
		lblForTheirEveryday.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblForTheirEveryday.setBounds(70, 268, 594, 21);
		panel.add(lblForTheirEveryday);

		adsPanel = new JPanel();
		adsPanel.setBackground(new Color(192, 192, 192));
		adsPanel.setForeground(new Color(192, 192, 192));
		adsPanel.setBounds(509, 34, 646, 283);
		panel.add(adsPanel);
		adsPanel.setLayout(null);

		scrollPane.setBounds(0, 0, 1200, 610);
//        scrollPane.setBounds(0, 0, 1200, 1225);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);

		label1 = new JLabel("");
		label1.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/slide ads 2.png")));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(0, 0, 646, 283);

		label2 = new JLabel("");
		label2.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/stackedBG.png")));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(0, 0, 646, 283);

//        label3 = new FadingLabel("");
//        label3.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/Background-02.png")));
//        label3.setHorizontalAlignment(SwingConstants.CENTER);
//        label3.setBounds(0, 0, 646, 283);

		adsPanel.add(label1);
		adsPanel.add(label2);
//        adsPanel.add(label3);

		label1.setVisible(true);
		label2.setVisible(false);
//        label3.setVisible(false);

		timer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchLabels();
			}
		});

		timer.start();

		phpayScroll = new ScrollBarCustom();
		phpayScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		phpayScroll.setBlockIncrement(1);
		phpayScroll.setBackground(new Color(255, 255, 255));
		phpayScroll.setForeground(new Color(192, 192, 192));
		phpayScroll.setUnitIncrement(10);
		scrollPane.setVerticalScrollBar(phpayScroll);
	}

	private void switchLabels() {
		label1.setVisible(!label1.isVisible());
		label2.setVisible(!label2.isVisible());
	}
}

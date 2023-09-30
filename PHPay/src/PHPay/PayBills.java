package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PayBills extends JPanel {
	private String session, choice; 
	private static final long serialVersionUID = 1L;
	private String id;
	private double amount;
	private JLabel receiverID;
	private JLabel amountLabel;
	private JLabel fee;
	private JLabel totalAmount;
	private String amountString;
	private RoundedTextField amountField;
	private RoundedPanel previewPane;
	private RoundedPanel blockPane;
	private JLabel billerLabel;
	private RoundedPanel transfer;

	private RoundedComboBox<String> electricityBox;
	private RoundedComboBox<String> waterBox;
	private RoundedComboBox<String> cableBox;
	private RoundedComboBox<String> healthBox;
	private RoundedComboBox<String> schoolBox;
	private RoundedComboBox<String> travelBox;
	private RoundedComboBox<String> loanBox;
	private RoundedComboBox<String> telecomBox;
	
	private JComboBox getBox;

	public PayBills(String ID) {
		this.session = ID;
		setBounds(0, 0, 1205, 754);
		setLayout(null);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1205, 1500);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pay");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblNewLabel.setBounds(55, 35, 129, 81);
		gradientPanel.add(lblNewLabel);

		JLabel lblMoney = new JLabel("Bills");
		lblMoney.setVerticalAlignment(SwingConstants.TOP);
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblMoney.setBounds(55, 94, 147, 85);
		gradientPanel.add(lblMoney);

		JLabel send = new JLabel("");
		send.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/bills.png")));
		send.setHorizontalAlignment(SwingConstants.CENTER);
		send.setBounds(108, 35, 179, 108);
		gradientPanel.add(send);

		transfer = new RoundedPanel(30);
		transfer.setLayout(null);
		transfer.setBackground(new Color(0, 0, 0, 50));
		transfer.setBounds(46, 174, 468, 562);
		gradientPanel.add(transfer);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Category");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(46, 21, 181, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1);

		RoundedButton waterButton = new RoundedButton("");
		waterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				waterButton.setBounds(142, 66, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				waterButton.setBounds(143, 67, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				waterButton.setBounds(143, 67, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				waterButton.setBounds(142, 66, 72, 72);
			}
		});
		waterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(waterBox);
			}
		});
		waterButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/wat.png")));
		waterButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		waterButton.setBounds(143, 67, 70, 70);
		transfer.add(waterButton);

		RoundedButton cableButton = new RoundedButton("");
		cableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cableButton.setBounds(242, 65, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cableButton.setBounds(243, 66, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				cableButton.setBounds(243, 66, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				cableButton.setBounds(242, 65, 72, 72);
			}
		});
		cableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				showNext(cableBox);
			}
		});
		cableButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/cable.png")));
		cableButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cableButton.setBounds(243, 66, 70, 70);
		transfer.add(cableButton);

		RoundedButton healthButton = new RoundedButton("");
		healthButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				healthButton.setBounds(339, 65, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				healthButton.setBounds(340, 66, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				healthButton.setBounds(340, 66, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				healthButton.setBounds(339, 65, 72, 72);
			}
		});
		healthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(healthBox);
			}
		});
		healthButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/heal.png")));
		healthButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		healthButton.setBounds(340, 66, 70, 70);
		transfer.add(healthButton);

		RoundedButton schoolButton = new RoundedButton("");
		schoolButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				schoolButton.setBounds(45, 177, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				schoolButton.setBounds(46, 178, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				schoolButton.setBounds(46, 178, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				schoolButton.setBounds(45, 177, 72, 72);
			}
		});
		schoolButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(schoolBox);
			}
		});
		schoolButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/sch.png")));
		schoolButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		schoolButton.setBounds(46, 178, 70, 70);
		transfer.add(schoolButton);

		RoundedButton travelButton = new RoundedButton("");
		travelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				travelButton.setBounds(142, 177, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				travelButton.setBounds(143, 178, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				travelButton.setBounds(143, 178, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				travelButton.setBounds(142, 177, 72, 72);
			}
		});
		travelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(travelBox);
			}
		});
		travelButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/lugg.png")));
		travelButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		travelButton.setBounds(143, 178, 70, 70);
		transfer.add(travelButton);

		RoundedButton loanButton = new RoundedButton("");
		loanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loanButton.setBounds(242, 177, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loanButton.setBounds(243, 178, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				loanButton.setBounds(243, 178, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				loanButton.setBounds(242, 177, 72, 72);
			}
		});
		loanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				showNext(loanBox);
			}
		});
		loanButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/loan.png")));
		loanButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		loanButton.setBounds(243, 178, 70, 70);
		transfer.add(loanButton);

		RoundedButton telecomButton = new RoundedButton("");
		telecomButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				telecomButton.setBounds(339, 177, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				telecomButton.setBounds(340, 178, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				telecomButton.setBounds(340, 178, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				telecomButton.setBounds(339, 177, 72, 72);
			}
		});
		telecomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String[] biller = { "Bayantel", "Globe Postpaid", "PLDT", "Smart Communications" };
//				createBox(biller);
				showNext(telecomBox);
			}
		});
		telecomButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/tele.png")));
		telecomButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		telecomButton.setBounds(340, 178, 70, 70);
		transfer.add(telecomButton);

		JLabel lblNewLabel_2 = new JLabel("Electricity");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(46, 141, 70, 27);
		transfer.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Water");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(143, 141, 70, 27);
		transfer.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Cable");
		lblNewLabel_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(243, 141, 70, 27);
		transfer.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Health");
		lblNewLabel_2_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(340, 141, 70, 27);
		transfer.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("School");
		lblNewLabel_2_1_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1.setBounds(46, 258, 70, 27);
		transfer.add(lblNewLabel_2_1_2_1);

		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Travel");
		lblNewLabel_2_1_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_1_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1_1.setBounds(143, 258, 70, 27);
		transfer.add(lblNewLabel_2_1_2_1_1);

		JLabel lblNewLabel_2_1_2_1_2 = new JLabel("Loan");
		lblNewLabel_2_1_2_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_1_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1_2.setBounds(243, 258, 70, 27);
		transfer.add(lblNewLabel_2_1_2_1_2);

		JLabel lblNewLabel_2_1_2_1_3 = new JLabel("Telecom");
		lblNewLabel_2_1_2_1_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2_1_3.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_1_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1_3.setBounds(340, 258, 70, 27);
		transfer.add(lblNewLabel_2_1_2_1_3);

		String[] electricityChoices = { "ALECO", "BENECO", "Davao Light", "Meralco", "SUKELCO ", "ZAMCELCO" };

		electricityBox = new RoundedComboBox<>(electricityChoices);
		electricityBox.setBounds(46, 332, 376, 47);
		electricityBox.setMaximumRowCount(6);
		electricityBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		electricityBox.setBackground(new Color(27, 0, 53));
		electricityBox.setForeground(new Color(255, 255, 255));
		electricityBox.setVisible(false);
		electricityBox.setUI(new CustomComboBoxUI());
		transfer.add(electricityBox);

		String[] waterChoices = { "Angeles Water", "Bulacan Aqua Estates", "Carcar Water District",
				"Davao City Water District", };

		waterBox = new RoundedComboBox<>(waterChoices);
		waterBox.setBounds(46, 332, 376, 47);
		waterBox.setMaximumRowCount(6);
		waterBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		waterBox.setBackground(new Color(27, 0, 53));
		waterBox.setForeground(new Color(255, 255, 255));
		waterBox.setVisible(false);
		waterBox.setUI(new CustomComboBoxUI());
		transfer.add(waterBox);

		String[] cableChoices = { "8990 FTDH", "Cignal", "GSAT", "Globe AT HOME" };

		cableBox = new RoundedComboBox<>(cableChoices);
		cableBox.setBounds(46, 332, 376, 47);
		cableBox.setMaximumRowCount(6);
		cableBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		cableBox.setBackground(new Color(27, 0, 53));
		cableBox.setForeground(new Color(255, 255, 255));
		cableBox.setVisible(false);
		cableBox.setUI(new CustomComboBoxUI());
		transfer.add(cableBox);

		String[] healthChoices = { "CLMMRH", "KonsultaMD", "Medicard" };

		healthBox = new RoundedComboBox<>(healthChoices);
		healthBox.setBounds(46, 332, 376, 47);
		healthBox.setMaximumRowCount(6);
		healthBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		healthBox.setBackground(new Color(27, 0, 53));
		healthBox.setForeground(new Color(255, 255, 255));
		healthBox.setVisible(false);
		healthBox.setUI(new CustomComboBoxUI());
		transfer.add(healthBox);

		String[] schoolChoices = { "Ateneo De Davao University", "Central Colleges", "Riverside College Inc.",
				"Rosario Institute", "University of Mindanao", "UP Diliman" };

		schoolBox = new RoundedComboBox<>(schoolChoices);
		schoolBox.setBounds(46, 332, 376, 47);
		schoolBox.setMaximumRowCount(6);
		schoolBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		schoolBox.setBackground(new Color(27, 0, 53));
		schoolBox.setForeground(new Color(255, 255, 255));
		schoolBox.setVisible(false);
		schoolBox.setUI(new CustomComboBoxUI());
		transfer.add(schoolBox);

		String[] travelChoices = { "AirAsia", "Cebu Pacific", "FastCat", "Philippine Airlines", };

		travelBox = new RoundedComboBox<>(travelChoices);
		travelBox.setBounds(46, 332, 376, 47);
		travelBox.setMaximumRowCount(6);
		travelBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		travelBox.setBackground(new Color(27, 0, 53));
		travelBox.setForeground(new Color(255, 255, 255));
		travelBox.setVisible(false);
		travelBox.setUI(new CustomComboBoxUI());
		transfer.add(travelBox);

		String[] loanChoices = { "ACOM", "BillEase", "EasyCash", "PSBank Loans", "Samulco" };

		loanBox = new RoundedComboBox<>(loanChoices);
		loanBox.setBounds(46, 332, 376, 47);
		loanBox.setMaximumRowCount(6);
		loanBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		loanBox.setBackground(new Color(27, 0, 53));
		loanBox.setForeground(new Color(255, 255, 255));
		loanBox.setVisible(false);
		loanBox.setUI(new CustomComboBoxUI());
		transfer.add(loanBox);

		String[] telecomChoices = { "Bayantel", "Globe Postpaid", "PLDT", "Smart Communications" };

		telecomBox = new RoundedComboBox<>(telecomChoices);
		telecomBox.setBounds(46, 332, 376, 47);
		telecomBox.setMaximumRowCount(6);
		telecomBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		telecomBox.setBackground(new Color(27, 0, 53));
		telecomBox.setForeground(new Color(255, 255, 255));
		telecomBox.setVisible(false);
		telecomBox.setUI(new CustomComboBoxUI());
		transfer.add(telecomBox);

		billerLabel = new JLabel("Biller");
		billerLabel.setBounds(46, 295, 87, 27);
		transfer.add(billerLabel);
		billerLabel.setForeground(Color.WHITE);
		billerLabel.setVisible(false);
		billerLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		RoundedButton nextButton = new RoundedButton("OK");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choice = (String) getBox.getSelectedItem();
				
				if (!(choice==null) || !choice.isEmpty()) {
					
					amountString = amountField.getText();
					amount = Double.parseDouble(amountString);
					
					boolean amountEdited = false;
					
					if (isNumeric(amountString)) {
						if (amount * 1.03 <= SQLQuery.getBalance(ID)) {
							amountEdited = true;
						}
					} else
						amountEdited = false;

					if (amountEdited) {
						setPreview(choice);
						previewPane.setVisible(true);

					} else
						System.out.println("failed");
				}
				
			}
		});
		nextButton.setText("Next");
		nextButton.setIconTextGap(1);
		nextButton.setForeground(UIManager.getColor("ScrollBar.background"));
		nextButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		nextButton.setAlignmentY(0.0f);
		nextButton.setBounds(159, 502, 130, 34);
		transfer.add(nextButton);

		previewPane = new RoundedPanel(30);
		previewPane.setLayout(null);
		previewPane.setBackground(new Color(0, 0, 0, 50));
		previewPane.setBounds(622, 17, 535, 706);
		gradientPanel.add(previewPane);
		previewPane.setVisible(false);

		RoundedPanel blockPane = new RoundedPanel(30);
		blockPane.setBounds(592, -1, 615, 756);
		gradientPanel.add(blockPane);
		blockPane.setLayout(null);
		blockPane.setBackground(new Color(0, 0, 0, 50));

		JLabel lblNewLabel_1 = new JLabel("Transaction Details");
		lblNewLabel_1.setBounds(41, 337, 206, 27);
		previewPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Receiver ID:");
		lblNewLabel_1_1_2_1.setBounds(41, 390, 128, 27);
		previewPane.add(lblNewLabel_1_1_2_1);
		lblNewLabel_1_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblNewLabel_1_1 = new JLabel("Transaction Fee:");
		lblNewLabel_1_1.setBounds(41, 490, 128, 27);
		previewPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblNewLabel_1_1_2 = new JLabel("Amount to send:");
		lblNewLabel_1_1_2.setBounds(41, 437, 128, 27);
		previewPane.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		receiverID = new JLabel("123123123");
		receiverID.setHorizontalAlignment(SwingConstants.RIGHT);
		receiverID.setBounds(362, 390, 128, 27);
		previewPane.add(receiverID);
		receiverID.setForeground(Color.LIGHT_GRAY);
		receiverID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		fee = new JLabel("123,123");
		fee.setHorizontalAlignment(SwingConstants.RIGHT);
		fee.setBounds(362, 490, 128, 27);
		previewPane.add(fee);
		fee.setForeground(Color.LIGHT_GRAY);
		fee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		amountLabel = new JLabel("1239178651");
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLabel.setBounds(362, 437, 128, 27);
		previewPane.add(amountLabel);
		amountLabel.setForeground(Color.LIGHT_GRAY);
		amountLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		RoundedButton electricityButton = new RoundedButton("");
		electricityButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				electricityButton.setBounds(45, 65, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				electricityButton.setBounds(46, 66, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				electricityButton.setBounds(46, 66, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				electricityButton.setBounds(45, 65, 72, 72);
			}
		});
		electricityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(electricityBox);

			}
		});
		electricityButton.setIcon(new ImageIcon(PayBills.class.getResource("/PHPay/phpimg/elec.png")));
		electricityButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		electricityButton.setBounds(46, 66, 70, 70);
		transfer.add(electricityButton);
		
				JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Amount");
				lblNewLabel_1_1_1_1_1_1_1.setBounds(46, 396, 87, 27);
				transfer.add(lblNewLabel_1_1_1_1_1_1_1);
				lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
				lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
				
						amountField = new RoundedTextField(10);
						amountField.setBounds(46, 433, 376, 47);
						transfer.add(amountField);
						amountField.setName("");
						amountField.setMargin(new Insets(2, 7, 2, 7));
						amountField.setForeground(Color.WHITE);
						amountField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
						amountField.setColumns(10);

		JPanel transfer_2_1 = new JPanel();
		transfer_2_1.setLayout(null);
		transfer_2_1.setBackground(new Color(58, 0, 117));
		transfer_2_1.setBounds(0, 538, 535, 71);
		previewPane.add(transfer_2_1);

		totalAmount = new JLabel("1239178651");
		totalAmount.setBounds(336, 22, 153, 27);
		transfer_2_1.add(totalAmount);
		totalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		totalAmount.setForeground(new Color(255, 255, 255));
		totalAmount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Total Amount:");
		lblNewLabel_1_1_2_1_1.setBounds(41, 22, 162, 27);
		transfer_2_1.add(lblNewLabel_1_1_2_1_1);
		lblNewLabel_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		RoundedCheckBox confirmBox = new RoundedCheckBox("");
		confirmBox.setText("I confirm that the details are correct");
		confirmBox.setSize(new Dimension(3, 3));
		confirmBox.setPreferredSize(new Dimension(33, 33));
		confirmBox.setHorizontalAlignment(SwingConstants.CENTER);
		confirmBox.setForeground(Color.WHITE);
		confirmBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		confirmBox.setBackground(Color.WHITE);
		confirmBox.setBounds(157, 621, 221, 23);
		previewPane.add(confirmBox);

		RoundedButton confirmButton = new RoundedButton("OK");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PayBills.this);

		        if (frame != null) {
		            frame.dispose();
		        }

				Proceed proceed = new Proceed("Processing",ID);
				proceed.setVisible(true);
				SQLQuery.payBills(ID, amount, choice);
			}
		});
		confirmButton.setText("Confirm");
		confirmButton.setIconTextGap(1);
		confirmButton.setForeground(UIManager.getColor("ScrollBar.background"));
		confirmButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		confirmButton.setEnabled(false);
		confirmButton.setAlignmentY(0.0f);
		confirmButton.setBounds(202, 654, 130, 34);
		previewPane.add(confirmButton);
		
		confirmBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmBox.isSelected()) {
					confirmButton.setEnabled(true);
				} else {
					confirmButton.setEnabled(false);
				}
			}
		});
	}

	public void showNext(@SuppressWarnings("rawtypes") JComboBox box) {
		billerLabel.setVisible(true);
		electricityBox.setVisible(false);
		waterBox.setVisible(false);
		cableBox.setVisible(false);
		healthBox.setVisible(false);
		schoolBox.setVisible(false);
		travelBox.setVisible(false);
		loanBox.setVisible(false);
		telecomBox.setVisible(false);

		box.setVisible(true);
		getBox = box;
	}
	
	private void setPreview(String choice) {
		double doubleFee = (double)Math.round((amount * 0.03)*100)/100;

		receiverID.setText(choice);
		amountLabel.setText("₱ " + amountString);
		fee.setText("₱ " + Double.toString(doubleFee));
		totalAmount.setText("₱ " + Double.toString(amount + doubleFee));

	}

	public class CustomComboBoxUI extends BasicComboBoxUI {
		@Override
		protected JButton createArrowButton() {
			return new JButton() {
				private static final long serialVersionUID = 1L;

				@Override
				public int getWidth() {
					return 0;
				}
			};
		}

		@Override
		protected ComboPopup createPopup() {
			return new BasicComboPopup(comboBox) {
				private static final long serialVersionUID = 1L;

				@Override
				protected JScrollPane createScroller() {
					JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
							JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					scroller.getViewport().setBackground(comboBox.getBackground());

					scroller.addMouseWheelListener(new MouseWheelListener() {
						@Override
						public void mouseWheelMoved(MouseWheelEvent e) {
							JScrollBar verticalScrollBar = scroller.getVerticalScrollBar();
							int units = e.getUnitsToScroll();
							int extent = verticalScrollBar.getBlockIncrement(1) / 5;

							int currentValue = verticalScrollBar.getValue();
							verticalScrollBar.setValue(currentValue + units * extent);
						}
					});

					return scroller;
				}
			};
		}

		@Override
		protected void installDefaults() {
			super.installDefaults();
			comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		}
	}
	
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}

		try {
			double value = Double.parseDouble(str);
			if (value == (int) value && value > 0) {
				return true;
			}
		} catch (NumberFormatException e) {
		}

		return false;
	}
	
	public void reset() {
		billerLabel.setVisible(true);
	}
}
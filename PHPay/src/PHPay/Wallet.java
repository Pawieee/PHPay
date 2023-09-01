package PHPay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class Wallet extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String session;

	JTextField textField;
	private JButton send;
	private boolean isVisible = false;
	private String getBal, selectedBranch = null, selectedSchool = null, selectedWater = null, selectedElectric = null,
			selectedSim = null;

	private boolean aEdited = false;
	private boolean fEdited1 = false;
	private boolean fEdited2 = false;
	private boolean fEdited3 = false;
	private boolean check = false;
	private JLabel showBalance, BG1;
	private double currentBal;
	private String getID;

	public static String addCommaSeparator(String value) {
		DecimalFormat formatter = new DecimalFormat("#,###.0");
		double number = Double.parseDouble(value);
		return formatter.format(number);
	}

	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public Wallet(String ID) {
		this.session = ID;

		setBackground(new Color(128, 0, 255));
		setLocationRelativeTo(null);

		LineBorder border = new LineBorder(Color.BLACK, 2);
		getRootPane().setBorder(border);

		currentBal = SQLQuery.getBalance(session);
		getBal = currentBal + "";

		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Wallet.class.getResource("/phpay/phpimg/icons8-pandora-app-100.png")));
		getContentPane().setForeground(Color.WHITE);
		setForeground(new Color(128, 0, 255));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 694) / 2;
		int centerY = (screenHeight - 513) / 2;
		setLocation(centerX, centerY);
		setSize(694, 513);

		setTitle("PHPAY - Virtual Wallet");
		getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setForeground(SystemColor.textHighlight);
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(0, 0, 686, 485);

		mainPanel.setLayout(null);

		getContentPane().add(mainPanel);

		textField = new JTextField("");
		textField.setBounds(10, 22, 7, -4);
		textField.setForeground(Color.GRAY);
		mainPanel.add(textField);
		mainPanel.setFocusable(true);

		JLabel sendIcon = new JLabel("");
		sendIcon.setBounds(131, 69, 59, 64);
		mainPanel.add(sendIcon);
		sendIcon.setForeground(new Color(153, 102, 204));
		sendIcon.setFont(new Font("Heebo", Font.PLAIN, 16));
		sendIcon.setHorizontalAlignment(SwingConstants.CENTER);
		sendIcon.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicon1.png")));

		JLabel loadIcon = new JLabel("");
		loadIcon.setFont(new Font("Heebo", Font.PLAIN, 16));
		loadIcon.setForeground(new Color(153, 102, 204));
		loadIcon.setBounds(32, 237, 59, 64);
		mainPanel.add(loadIcon);
		loadIcon.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicon3.png")));
		loadIcon.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel cashIn = new JLabel("");
		cashIn.setBounds(238, 144, 56, 64);
		mainPanel.add(cashIn);
		cashIn.setForeground(new Color(153, 102, 204));
		cashIn.setFont(new Font("Heebo", Font.PLAIN, 16));
		cashIn.setHorizontalAlignment(SwingConstants.LEFT);
		cashIn.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicon2.png")));

		JLabel withdraw = new JLabel("");
		withdraw.setForeground(new Color(153, 102, 204));
		withdraw.setFont(new Font("Heebo", Font.PLAIN, 16));
		withdraw.setBounds(39, 144, 56, 64);
		mainPanel.add(withdraw);
		withdraw.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/icon7.png")));
		withdraw.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel bills = new JLabel("");
		bills.setFont(new Font("Heebo", Font.PLAIN, 16));
		bills.setForeground(new Color(153, 102, 204));
		bills.setBounds(114, 288, 90, 64);
		mainPanel.add(bills);
		bills.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicon5.png")));
		bills.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel borrow = new JLabel("");
		borrow.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicons6.png")));
		borrow.setHorizontalAlignment(SwingConstants.LEFT);
		borrow.setForeground(new Color(153, 102, 204));
		borrow.setFont(new Font("Heebo", Font.PLAIN, 16));
		borrow.setBounds(230, 242, 75, 64);
		mainPanel.add(borrow);

		JLabel sLabel = new JLabel("");
		sLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 26));
		sLabel.setBounds(321, 105, 353, 45);
		sLabel.setVisible(true);
		sLabel.setForeground(new Color(0, 0, 0)); // set foreground color to white
		sLabel.setBackground(new Color(255, 255, 255)); // set background color to blue
		mainPanel.add(sLabel);

		JLabel Label1 = new JLabel("");
		Label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		Label1.setBounds(362, 177, 228, 14);
		mainPanel.add(Label1);
		Label1.setVisible(true);

		JLabel Label2 = new JLabel("");
		Label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		Label2.setBounds(362, 236, 228, 14);
		mainPanel.add(Label2);
		Label2.setVisible(true);

		JLabel Label3 = new JLabel("");
		Label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		Label3.setBounds(362, 294, 243, 14);
		mainPanel.add(Label3);
		Label3.setVisible(true);

		JTextField Field1 = new JTextField("");
		Field1.setBounds(362, 193, 273, 30);
		Field1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		mainPanel.add(Field1);
		Field1.setForeground(new Color(0, 0, 0));
		Field1.setVisible(false);
		Field1.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (!Field1.getText().isEmpty()) {
					Field1.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (!Field1.getText().isEmpty()) {
					Field1.setForeground(Color.BLACK);
				}
			}
		});

		JTextField Field2 = new JTextField("");
		Field2.setBounds(362, 251, 273, 30);
		Field2.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		mainPanel.add(Field2);
		Field2.setForeground(new Color(0, 0, 0));
		Field2.setVisible(false);
		Field2.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (!Field2.getText().isEmpty()) {
					Field2.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (!Field2.getText().isEmpty()) {
					Field2.setForeground(Color.BLACK);
				}
			}
		});

		JTextField Field3 = new JTextField("");
		Field3.setBounds(362, 308, 273, 30);
		Field3.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		mainPanel.add(Field3);
		Field3.setForeground(new Color(0, 0, 0));
		Field3.setVisible(false);
		Field3.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (!Field3.getText().isEmpty()) {
					Field3.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (!Field3.getText().isEmpty()) {
					Field3.setForeground(Color.BLACK);
				}
			}
		});

		JTextField newAmountField = new JTextField("Amount");
		newAmountField.setBounds(417, 146, 159, 27);
		newAmountField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		mainPanel.add(newAmountField);
		newAmountField.setForeground(Color.GRAY);
		newAmountField.setVisible(false);
		newAmountField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (newAmountField.getText().equals("Amount")) {
					newAmountField.setText("");
					newAmountField.setForeground(Color.BLACK);
				} else if (!newAmountField.getText().isEmpty()) {
					newAmountField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (newAmountField.getText().isEmpty()) {
					newAmountField.setText("Amount");
					newAmountField.setForeground(Color.GRAY);
				} else if (!newAmountField.getText().isEmpty()) {
					newAmountField.setForeground(Color.BLACK);
				}
			}
		});

		JCheckBox termsCheck = new JCheckBox("");
		termsCheck.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 5));
		termsCheck.setBackground(Color.LIGHT_GRAY);
		termsCheck.setForeground(new Color(128, 0, 255));
		termsCheck.setBounds(403, 382, 21, 23);
		mainPanel.add(termsCheck);
		termsCheck.setVisible(false);
		termsCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (termsCheck.isSelected()) {

					check = true;

				} else {

					check = false;

				}
			}
		});

		JButton profileButton = new JButton("PROFILE");
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile profile = new Profile();
				profile.setVisible(true);
			}
		});
		profileButton.setBackground(Color.WHITE);
		profileButton.setHorizontalAlignment(SwingConstants.LEADING);
		profileButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		profileButton.setBounds(686, 0, 150, 40);
		mainPanel.add(profileButton);

		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame logoutFrame = new JFrame("");
				JLabel successLabel = new JLabel("Are you sure you want to logout?");
				successLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
				successLabel.setHorizontalAlignment(SwingConstants.CENTER);
				logoutFrame.getContentPane().add(successLabel, BorderLayout.CENTER);
				logoutFrame.setResizable(false);

				JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns

				JButton okButton = new JButton("Yes");
				okButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
				okButton.setBackground(new Color(255, 255, 255));
				okButton.setForeground(new Color(0, 0, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dispose();
						logoutFrame.dispose();

						Welcome runFrame = new Welcome();
						runFrame.setVisible(true);

					}
				});
				JButton cancelButton = new JButton("No");
				cancelButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setForeground(new Color(0, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logoutFrame.dispose();
					}
				});
				buttonPanel.add(okButton);
				buttonPanel.add(cancelButton);

				logoutFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

				logoutFrame.setSize(300, 150);
				logoutFrame.setLocationRelativeTo(null);
				logoutFrame.setVisible(true);

			}
		});
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setHorizontalAlignment(SwingConstants.LEADING);
		logoutButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		logoutButton.setBounds(686, 45, 150, 40);
		mainPanel.add(logoutButton);

		JButton deleteButton = new JButton("DELETE ACCOUNT");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame deleteFrame = new JFrame("");
				JLabel deleteLabel = new JLabel("Are you sure?");
				deleteLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
				deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
				deleteFrame.getContentPane().add(deleteLabel, BorderLayout.CENTER);
				deleteFrame.setResizable(false);

				JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns

				JButton okButton = new JButton("Yes");
				okButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
				okButton.setBackground(new Color(255, 255, 255));
				okButton.setForeground(new Color(0, 0, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// DELETES ACCOUNT
						SQLQuery.deleteAccount(session);

						dispose();
						deleteFrame.dispose();

						Welcome runFrame = new Welcome();
						runFrame.setVisible(true);

					}
				});
				JButton cancelButton = new JButton("No");
				cancelButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
				cancelButton.setBackground(new Color(255, 255, 255));
				cancelButton.setForeground(new Color(0, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deleteFrame.dispose();
					}
				});
				buttonPanel.add(okButton);
				buttonPanel.add(cancelButton);

				deleteFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

				deleteFrame.setSize(300, 150);
				deleteFrame.setLocationRelativeTo(null);
				deleteFrame.setVisible(true);

			}
		});

		deleteButton.setHorizontalAlignment(SwingConstants.LEADING);
		deleteButton.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setBounds(686, 90, 150, 40);
		mainPanel.add(deleteButton);

		JLabel checkLabel = new JLabel("I accept the ");
		checkLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		checkLabel.setBounds(427, 386, 114, 14);
		mainPanel.add(checkLabel);
		checkLabel.setVisible(false);

		JLabel termsAndconditions = new JLabel("Terms and Conditions");
		termsAndconditions.setForeground(new Color(0, 128, 255));
		termsAndconditions.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		termsAndconditions.setBounds(491, 386, 114, 14);
		mainPanel.add(termsAndconditions);
		termsAndconditions.setVisible(false);

		JButton sendConfirm = new JButton("SEND");
		sendConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		sendConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(sendConfirm);
		sendConfirm.setBackground(new Color(255, 255, 255));
		sendConfirm.setForeground(new Color(0, 0, 0));
		sendConfirm.setVisible(false);

		JButton loadConfirm = new JButton("LOAD");
		loadConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		loadConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(loadConfirm);
		loadConfirm.setBackground(new Color(255, 255, 255));
		loadConfirm.setForeground(new Color(0, 0, 0));
		loadConfirm.setVisible(false);

		JButton cashConfirm = new JButton("CASH IN");
		cashConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		cashConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(cashConfirm);
		cashConfirm.setBackground(new Color(255, 255, 255));
		cashConfirm.setForeground(new Color(0, 0, 0));
		cashConfirm.setVisible(false);

		JButton deliveryConfirm = new JButton("PROCEED");
		deliveryConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		deliveryConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(deliveryConfirm);
		deliveryConfirm.setBackground(new Color(255, 255, 255));
		deliveryConfirm.setForeground(new Color(0, 0, 0));
		deliveryConfirm.setVisible(false);

		JButton pickupConfirm = new JButton("PROCEED");
		pickupConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		pickupConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(pickupConfirm);
		pickupConfirm.setBackground(new Color(255, 255, 255));
		pickupConfirm.setForeground(new Color(0, 0, 0));
		pickupConfirm.setVisible(false);

		JButton schoolConfirm = new JButton("CONFIRM");
		schoolConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		schoolConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(schoolConfirm);
		schoolConfirm.setBackground(new Color(255, 255, 255));
		schoolConfirm.setForeground(new Color(0, 0, 0));
		schoolConfirm.setVisible(false);

		JButton elecConfirm = new JButton("CONFIRM");
		elecConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		elecConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(elecConfirm);
		elecConfirm.setBackground(new Color(255, 255, 255));
		elecConfirm.setForeground(new Color(0, 0, 0));
		elecConfirm.setVisible(false);

		JButton waterConfirm = new JButton("CONFIRM");
		waterConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		waterConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(waterConfirm);
		waterConfirm.setBackground(new Color(255, 255, 255));
		waterConfirm.setForeground(new Color(0, 0, 0));
		waterConfirm.setVisible(false);

		JButton borrowConfirm = new JButton("BORROW");
		borrowConfirm.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		borrowConfirm.setBounds(453, 406, 102, 29);
		mainPanel.add(borrowConfirm);
		borrowConfirm.setBackground(new Color(255, 255, 255));
		borrowConfirm.setForeground(new Color(0, 0, 0));
		borrowConfirm.setVisible(false);

		JFrame successFrame = new JFrame("");
		JLabel successLabel = new JLabel("Confirm your transaction");
		successLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		successFrame.setType(Type.UTILITY);
		successLabel.setHorizontalAlignment(SwingConstants.CENTER);
		successFrame.getContentPane().add(successLabel, BorderLayout.CENTER);
		successFrame.setResizable(false);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns

		JButton okButton = new JButton("Send");
		okButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		okButton.setBackground(new Color(255, 255, 255));
		okButton.setForeground(new Color(0, 0, 0));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateBalanceLabelFromFile();
				termsCheck.setSelected(false);

				processPHP run = new processPHP(getSession());
				run.setVisible(true);
				dispose();

				successFrame.dispose();

			}
		});
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		cancelButton.setBackground(new Color(255, 255, 255));
		cancelButton.setForeground(new Color(0, 0, 0));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				successFrame.dispose();
			}
		});
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);

		successFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		successFrame.setSize(300, 150);
		successFrame.setLocationRelativeTo(null);
		successFrame.setVisible(false);

		String[] branch = { "(Select)", "7/11", "Cebuana Llhuiller", "Palawan Pawnshop", "Star Shop" };
		String[] loads = { "(Select)", "Globe", "Smart", "DITO", "GOMO", "Talk N Text" };
		String[] schools = { "(Select)", "University of Mindanao", "Ateneo de Davao University", "San Pedro College",
				"Holy Cross of Davao College" };
		String[] electric = { "(Select)", "Davao Light", "Meralco", "BUSECO", "SOCOTECO1" };
		String[] waters = { "(Select)", "Davao City Water District", "Balibago Waterworks", "CDO Water",
				"Digos Water District" };

		JComboBox<String> branchbox = new JComboBox<>(branch);
		branchbox.setBounds(362, 310, 273, 30);
		branchbox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		branchbox.setBackground(new Color(255, 255, 255));
		mainPanel.add(branchbox);
		branchbox.setVisible(false);
		branchbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedBranch = (String) branchbox.getSelectedItem();

			}
		});
		branchbox.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (true) {

				}
			}

			public void focusLost(FocusEvent e) {
				if (true) {
					branchbox.setForeground(Color.BLACK);
				}
			}
		});

		JComboBox<String> loadbox = new JComboBox<>(loads);
		loadbox.setBounds(362, 308, 273, 30);
		loadbox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		loadbox.setBackground(new Color(255, 255, 255));
		mainPanel.add(loadbox);
		loadbox.setVisible(false);
		loadbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedSim = (String) loadbox.getSelectedItem();
			}
		});
		loadbox.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (true) {

				}
			}

			public void focusLost(FocusEvent e) {
				if (true) {
					loadbox.setForeground(Color.BLACK);
				}
			}
		});

		JComboBox<String> schoolbox = new JComboBox<>(schools);
		schoolbox.setBounds(362, 193, 273, 30);
		schoolbox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		schoolbox.setBackground(new Color(255, 255, 255));
		mainPanel.add(schoolbox);
		schoolbox.setVisible(false);
		schoolbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedSchool = (String) schoolbox.getSelectedItem();
			}
		});
		schoolbox.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (true) {

				}
			}

			public void focusLost(FocusEvent e) {
				if (true) {
					schoolbox.setForeground(Color.BLACK);
				}
			}
		});

		JComboBox<String> waterbox = new JComboBox<>(waters);
		waterbox.setBounds(362, 193, 273, 30);
		waterbox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		waterbox.setBackground(new Color(255, 255, 255));
		mainPanel.add(waterbox);
		waterbox.setVisible(false);
		waterbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedWater = (String) waterbox.getSelectedItem();
			}
		});
		waterbox.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (true) {

				}
			}

			public void focusLost(FocusEvent e) {
				if (true) {
					waterbox.setForeground(Color.BLACK);
				}
			}
		});

		JComboBox<String> electricitybox = new JComboBox<>(electric);
		electricitybox.setBounds(362, 193, 273, 30);
		electricitybox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		electricitybox.setBackground(new Color(255, 255, 255));
		mainPanel.add(electricitybox);
		electricitybox.setVisible(false);
		electricitybox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedElectric = (String) electricitybox.getSelectedItem();
			}
		});
		electricitybox.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (true) {

				}
			}

			public void focusLost(FocusEvent e) {
				if (true) {
					electricitybox.setForeground(Color.BLACK);
				}
			}
		});

		JButton pickup = new JButton("PICKUP");
		pickup.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		pickup.setBounds(403, 227, 100, 33);
		mainPanel.add(pickup);
		pickup.setBackground(new Color(255, 255, 255));
		pickup.setForeground(new Color(0, 0, 0));
		pickup.setVisible(false);

		JButton delivery = new JButton("DELIVERY");
		delivery.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		delivery.setBounds(503, 227, 100, 33);
		mainPanel.add(delivery);
		delivery.setBackground(new Color(255, 255, 255));
		delivery.setForeground(new Color(0, 0, 0));
		delivery.setVisible(false);

		JLabel school = new JLabel("");
		school.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicons7.png")));
		school.setHorizontalAlignment(SwingConstants.LEFT);
		school.setForeground(new Color(153, 102, 204));
		school.setFont(new Font("Heebo", Font.PLAIN, 16));
		school.setBounds(131, 384, 73, 64);
		mainPanel.add(school);
		school.setVisible(false);

		JLabel electricity = new JLabel("");
		electricity.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicons8.png")));
		electricity.setHorizontalAlignment(SwingConstants.LEFT);
		electricity.setForeground(new Color(153, 102, 204));
		electricity.setFont(new Font("Heebo", Font.PLAIN, 16));
		electricity.setBounds(29, 358, 73, 64);
		mainPanel.add(electricity);
		electricity.setVisible(false);

		JLabel water = new JLabel("");
		water.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicons9.png")));
		water.setHorizontalAlignment(SwingConstants.LEFT);
		water.setForeground(new Color(153, 102, 204));
		water.setFont(new Font("Heebo", Font.PLAIN, 16));
		water.setBounds(232, 362, 60, 64);
		mainPanel.add(water);
		water.setVisible(false);

		JLabel schoolLabel = new JLabel("School");
		schoolLabel.setHorizontalAlignment(SwingConstants.LEFT);
		schoolLabel.setForeground(new Color(153, 102, 204));
		schoolLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		schoolLabel.setBounds(131, 435, 62, 29);
		mainPanel.add(schoolLabel);
		schoolLabel.setVisible(false);

		JLabel elecLabel = new JLabel("Electricity ");
		elecLabel.setHorizontalAlignment(SwingConstants.LEFT);
		elecLabel.setForeground(new Color(153, 102, 204));
		elecLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		elecLabel.setBounds(19, 409, 90, 29);
		mainPanel.add(elecLabel);
		elecLabel.setVisible(false);

		JLabel waterLabel = new JLabel("Water");
		waterLabel.setHorizontalAlignment(SwingConstants.LEFT);
		waterLabel.setForeground(new Color(153, 102, 204));
		waterLabel.setFont(new Font("Heebo", Font.PLAIN, 16));
		waterLabel.setBounds(237, 410, 47, 29);
		mainPanel.add(waterLabel);
		waterLabel.setVisible(false);

		sendIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Field1.setForeground(Color.BLACK);
				Field2.setForeground(Color.BLACK);
				Field3.setForeground(Color.BLACK);

				Field1.setText("");
				Field2.setText("");
				Field3.setText("");

				sLabel.setText("SEND MONEY");
				Label1.setText("Amount");
				Label2.setText("ID");
				Label3.setText("");
				Field1.setVisible(true);
				Field2.setVisible(true);
				Field3.setVisible(false);
				newAmountField.setVisible(false);
				sendConfirm.setVisible(true);
				loadConfirm.setVisible(false);
				cashConfirm.setVisible(false);
				deliveryConfirm.setVisible(false);
				pickupConfirm.setVisible(false);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);
				borrowConfirm.setVisible(false);
				pickup.setVisible(false);
				delivery.setVisible(false);
				branchbox.setVisible(false);
				loadbox.setVisible(false);
				schoolbox.setVisible(false);
				waterbox.setVisible(false);
				electricitybox.setVisible(false);
				termsCheck.setVisible(false);
				checkLabel.setVisible(false);
				termsAndconditions.setVisible(false);

				school.setVisible(false);
				electricity.setVisible(false);
				water.setVisible(false);

				elecLabel.setVisible(false);
				schoolLabel.setVisible(false);
				waterLabel.setVisible(false);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				sendConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = Field1.getText().trim();
						String receiverID = Field2.getText();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							Field1.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								Field1.setForeground(Color.RED);
								fEdited1 = false;
							} else if (amount >= currentBal) {
								Field1.setForeground(Color.RED);
								fEdited1 = false;
							} else {
								// the input is a positive number
								Field1.setForeground(Color.BLACK);
								fEdited1 = true;
							}
						}

						if (Field2.getText().isEmpty()) {
							fEdited2 = false;
						}

						double amountDouble = Double.parseDouble(amountString);
						showBalance.setText(getBal);

						// DEDUCTING THE SENDER BALANCE
						SQLQuery.sendMoney(session, receiverID, amountDouble);

						fEdited1 = false;
						fEdited2 = false;
						sLabel.setText("");
						Label1.setText("");
						Label2.setText("");
						Field1.setText("");
						Field2.setText("");
						Field1.setVisible(false);
						Field2.setVisible(false);
						sendConfirm.setVisible(false);

						successFrame.setVisible(true);

					}

				});

			}
		});

		loadIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Field1.setForeground(Color.BLACK);
				Field2.setForeground(Color.BLACK);
				Field3.setForeground(Color.BLACK);

				Field1.setText("");
				Field2.setText("");
				Field3.setText("");

				sLabel.setText("BUY LOAD");
				Label1.setText("Amount");
				Label2.setText("Mobile Number");
				Label3.setText("Sim");
				Field1.setVisible(true);
				Field2.setVisible(true);
				Field3.setVisible(false);
				newAmountField.setVisible(false);
				sendConfirm.setVisible(false);
				loadConfirm.setVisible(true);
				cashConfirm.setVisible(false);
				deliveryConfirm.setVisible(false);
				pickupConfirm.setVisible(false);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);
				borrowConfirm.setVisible(false);
				pickup.setVisible(false);
				delivery.setVisible(false);
				branchbox.setVisible(false);
				loadbox.setVisible(true);
				schoolbox.setVisible(false);
				waterbox.setVisible(false);
				electricitybox.setVisible(false);
				termsCheck.setVisible(false);
				checkLabel.setVisible(false);
				termsAndconditions.setVisible(false);

				school.setVisible(false);
				electricity.setVisible(false);
				water.setVisible(false);

				elecLabel.setVisible(false);
				schoolLabel.setVisible(false);
				waterLabel.setVisible(false);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				loadConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = Field1.getText().trim();
						selectedSim = (String) loadbox.getSelectedItem();

						if (!isNumeric(amountString)) {
							Field1.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								Field1.setForeground(Color.RED);
								fEdited1 = false;
							} else if (amount >= currentBal) {
								Field1.setForeground(Color.RED);
								fEdited1 = false;
							} else {
								Field1.setForeground(Color.BLACK);
								fEdited1 = true;
							}
						}

						if (!Field2.getText().matches("^[+\\d]{11,}$")) {
							// Field2 contains only numbers and the plus sign (+)
							// and is 11 characters or longer
							Field2.setForeground(Color.RED);
							fEdited2 = false;
						} else {
							// Field2 does not meet the restrictions
							fEdited2 = true;
						}

						if (selectedSim.equals("(Select)")) {
							loadbox.setForeground(Color.RED);
							fEdited3 = false;
						} else {
							loadbox.setForeground(new Color(0, 0, 0));
							fEdited3 = true;
						}

						// DEDUCTING THE USER BALANCE
						if (!fEdited1 || (!fEdited2) || (!fEdited3)) {

							if (Field1.getText().isEmpty() || Field2.getText().isEmpty()) {

							}

						} else {
							amountString = Field1.getText();
							double amountDouble = Double.parseDouble(amountString);

							// DEDUCTING THE SENDER BALANCE

							SQLQuery.load(ID, amountDouble);

							fEdited1 = false;
							fEdited2 = false;
							fEdited3 = false;
							aEdited = false;
							sLabel.setText("");
							Label1.setText("");
							Label2.setText("");
							Label3.setText("");
							Field1.setText("");
							Field2.setText("");
							Field1.setVisible(false);
							Field2.setVisible(false);
							loadConfirm.setVisible(false);
							loadbox.setVisible(false);

							successFrame.setVisible(true);

						}

					}

				});

			}
		});

		cashIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Field1.setForeground(Color.BLACK);
				Field2.setForeground(Color.BLACK);
				Field3.setForeground(Color.BLACK);

				termsCheck.setBackground(Color.LIGHT_GRAY);

				Field1.setText("");
				Field2.setText("");
				Field3.setText("");

				sLabel.setText("CASH IN");
				Label2.setText("ID ");
				Label1.setText("Amount");
				Label3.setText("");
				Field1.setVisible(true);
				Field2.setVisible(true);
				Field3.setVisible(false);
				newAmountField.setVisible(false);
				sendConfirm.setVisible(false);
				loadConfirm.setVisible(false);
				cashConfirm.setVisible(true);
				deliveryConfirm.setVisible(false);
				pickupConfirm.setVisible(false);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);
				borrowConfirm.setVisible(false);
				pickup.setVisible(false);
				delivery.setVisible(false);
				branchbox.setVisible(false);
				loadbox.setVisible(false);
				schoolbox.setVisible(false);
				waterbox.setVisible(false);
				electricitybox.setVisible(false);
				termsCheck.setVisible(true);
				checkLabel.setVisible(true);
				termsAndconditions.setVisible(true);

				school.setVisible(false);
				electricity.setVisible(false);
				water.setVisible(false);

				elecLabel.setVisible(false);
				schoolLabel.setVisible(false);
				waterLabel.setVisible(false);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				cashConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = Field1.getText().trim();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							Field1.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								Field1.setForeground(Color.RED);
								fEdited1 = false;
							} else {
								// the input is a positive number
								Field1.setForeground(Color.BLACK);
								fEdited1 = true;
							}
						}

						if (check) {
							termsCheck.setBackground(Color.LIGHT_GRAY);
						} else {
							termsCheck.setBackground(Color.RED);
						}

						double amountDouble = Double.parseDouble(amountString);
						SQLQuery.cashIn(session, amountDouble);

						check = false;
						fEdited1 = false;
						fEdited2 = false;
						sLabel.setText("");
						Label1.setText("");
						Label2.setText("");
						Field1.setText("");
						Field2.setText("");
						Field1.setVisible(false);
						Field2.setVisible(false);
						termsCheck.setVisible(false);
						checkLabel.setVisible(false);
						termsAndconditions.setVisible(false);
						sendConfirm.setVisible(false);
						cashConfirm.setVisible(false);

						successFrame.setVisible(true);

					}
				});

			}
		});

		withdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Field1.setForeground(Color.BLACK);
				Field2.setForeground(Color.BLACK);
				Field3.setForeground(Color.BLACK);

				termsCheck.setBackground(Color.LIGHT_GRAY);

				Field1.setText("");
				Field2.setText("");
				Field3.setText("");

				sLabel.setText("WITHDRAW");
				Label1.setText("");
				Label2.setText("");
				Label3.setText("");
				Field1.setVisible(false);
				Field2.setVisible(false);
				Field3.setVisible(false);
				newAmountField.setVisible(false);
				pickup.setVisible(true);
				delivery.setVisible(true);
				sendConfirm.setVisible(false);
				cashConfirm.setVisible(false);
				borrowConfirm.setVisible(false);
				loadConfirm.setVisible(false);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);
				branchbox.setVisible(false);
				loadbox.setVisible(false);
				schoolbox.setVisible(false);
				waterbox.setVisible(false);
				electricitybox.setVisible(false);
				termsCheck.setVisible(false);
				checkLabel.setVisible(false);
				termsAndconditions.setVisible(false);
				pickup.setBounds(403, 227, 100, 33);
				delivery.setBounds(503, 227, 100, 33);
				pickup.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
				delivery.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));

				school.setVisible(false);
				electricity.setVisible(false);
				water.setVisible(false);

				elecLabel.setVisible(false);
				schoolLabel.setVisible(false);
				waterLabel.setVisible(false);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				delivery.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Field1.setText("");
						Field2.setText("");
						Field3.setText("");

						Label1.setText("Recipient's Full Name");
						Label2.setText("Mobile Number");
						Label3.setText("Full Address");
						Field1.setVisible(true);
						Field2.setVisible(true);
						Field3.setVisible(true);
						newAmountField.setVisible(false);
						sendConfirm.setVisible(false);
						loadConfirm.setVisible(false);
						cashConfirm.setVisible(false);
						deliveryConfirm.setVisible(true);
						pickupConfirm.setVisible(false);
						schoolConfirm.setVisible(false);
						elecConfirm.setVisible(false);
						waterConfirm.setVisible(false);
						borrowConfirm.setVisible(false);
						termsCheck.setVisible(true);
						checkLabel.setVisible(true);
						branchbox.setVisible(false);
						termsAndconditions.setVisible(true);
						pickup.setVisible(false);
						delivery.setVisible(false);
						newAmountField.setVisible(true);

						school.setVisible(false);
						electricity.setVisible(false);
						water.setVisible(false);

						elecLabel.setVisible(false);
						schoolLabel.setVisible(false);
						waterLabel.setVisible(false);
						termsCheck.setSelected(false);

					}
				});

				deliveryConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = newAmountField.getText().trim();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							newAmountField.setForeground(Color.RED);
							aEdited = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else if (amount >= currentBal) {
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else {
								// the input is a positive number
								newAmountField.setForeground(Color.BLACK);
								aEdited = true;
							}
						}

						if (!Field1.getText().matches("[a-zA-Z]+")) {
							Field1.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							Field1.setForeground(Color.BLACK);
							fEdited1 = true;
						}

						if (!Field2.getText().matches("^[+\\d]{11,}$")) {
							Field2.setForeground(Color.RED);
							fEdited2 = false;
						} else {
							Field2.setForeground(new Color(0, 0, 0));
							fEdited2 = true;
						}

						if (Field3.getText().isEmpty()) {
							Field3.setForeground(Color.RED);
						} else {
							Field3.setForeground(new Color(0, 0, 0));
							fEdited3 = true;
						}

						if (check) {
							termsCheck.setBackground(Color.LIGHT_GRAY);
						} else {
							termsCheck.setBackground(Color.RED);
						}

						amountString = newAmountField.getText();
						double amountDouble = Double.parseDouble(amountString);

						// DEDUCTING THE SENDER BALANCE
						SQLQuery.withdraw(ID, amountDouble);

						fEdited1 = false;
						fEdited2 = false;
						fEdited3 = false;
						aEdited = false;
						check = false;
						sLabel.setText("");
						Label1.setText("");
						Label2.setText("");
						Label3.setText("");
						Field1.setText("");
						Field2.setText("");
						Field1.setVisible(false);
						Field2.setVisible(false);
						Field3.setVisible(false);
						newAmountField.setVisible(false);
						pickup.setVisible(false);
						delivery.setVisible(false);
						branchbox.setVisible(false);
						termsCheck.setVisible(false);
						checkLabel.setVisible(false);
						pickupConfirm.setVisible(false);
						deliveryConfirm.setVisible(false);
						termsAndconditions.setVisible(false);

						successFrame.setVisible(true);

					}
				});

				pickup.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Field1.setText("");
						Field2.setText("");
						Field3.setText("");

						Label1.setText("Recipient's Full Name");
						Label2.setText("Mobile Number");
						Label3.setText("Branch");
						Field1.setVisible(true);
						Field2.setVisible(true);
						Field3.setVisible(false);
						sendConfirm.setVisible(false);
						loadConfirm.setVisible(false);
						cashConfirm.setVisible(false);
						deliveryConfirm.setVisible(false);
						pickupConfirm.setVisible(true);
						schoolConfirm.setVisible(false);
						elecConfirm.setVisible(false);
						waterConfirm.setVisible(false);
						borrowConfirm.setVisible(false);
						branchbox.setVisible(true);
						termsCheck.setVisible(true);
						checkLabel.setVisible(true);
						termsAndconditions.setVisible(true);
						pickup.setVisible(false);
						delivery.setVisible(false);
						newAmountField.setVisible(true);

						school.setVisible(false);
						electricity.setVisible(false);
						water.setVisible(false);

						elecLabel.setVisible(false);
						schoolLabel.setVisible(false);
						waterLabel.setVisible(false);
						termsCheck.setSelected(false);
					}
				});

				pickupConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = newAmountField.getText().trim();
						selectedBranch = (String) branchbox.getSelectedItem();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							newAmountField.setForeground(Color.RED);
							aEdited = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else if (amount > currentBal) {
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else {
								// the input is a positive number
								newAmountField.setForeground(Color.BLACK);
								aEdited = true;
							}
						}

						if (!Field1.getText().matches("[a-zA-Z]+")) {
							Field1.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							Field1.setForeground(Color.BLACK);
							fEdited1 = true;
						}

						if (!Field2.getText().matches("^[+\\d]{11,}$")) {
							Field2.setForeground(Color.RED);
							fEdited2 = false;
						} else {
							Field2.setForeground(new Color(0, 0, 0));
							fEdited2 = true;
						}

						if (selectedBranch.equals("(Select)")) {
							branchbox.setForeground(Color.RED);
							fEdited3 = false;
						} else {
							branchbox.setForeground(new Color(0, 0, 0));
							fEdited3 = true;
						}

						if (check) {
							termsCheck.setBackground(Color.LIGHT_GRAY);
						} else {
							termsCheck.setBackground(Color.RED);
						}

						amountString = newAmountField.getText();
						double amountDouble = Double.parseDouble(amountString);

						// DEDUCTING THE SENDER BALANCE
						SQLQuery.withdraw(ID, amountDouble);

						fEdited1 = false;
						fEdited2 = false;
						fEdited3 = false;
						aEdited = false;
						check = false;
						sLabel.setText("");
						Label1.setText("");
						Label2.setText("");
						Label3.setText("");
						Field1.setText("");
						Field2.setText("");
						Field1.setVisible(false);
						Field2.setVisible(false);
						newAmountField.setVisible(false);
						pickup.setVisible(false);
						delivery.setVisible(false);
						branchbox.setVisible(false);
						termsCheck.setVisible(false);
						checkLabel.setVisible(false);
						pickupConfirm.setVisible(false);
						termsAndconditions.setVisible(false);

						successFrame.setVisible(true);

					}

				});

			}
		});

		bills.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Field1.setForeground(Color.BLACK);
				Field2.setForeground(Color.BLACK);
				Field3.setForeground(Color.BLACK);

				termsCheck.setBackground(Color.LIGHT_GRAY);

				Field1.setText("");
				Field2.setText("");
				Field3.setText("");

				sendConfirm.setVisible(false);
				loadConfirm.setVisible(false);
				cashConfirm.setVisible(false);
				deliveryConfirm.setVisible(false);
				pickupConfirm.setVisible(false);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);
				borrowConfirm.setVisible(false);

				sLabel.setText("");
				Label1.setText("");
				Label2.setText("");
				Label3.setText("");
				Field1.setVisible(false);
				Field2.setVisible(false);
				Field3.setVisible(false);
				newAmountField.setVisible(false);
				pickup.setVisible(false);
				delivery.setVisible(false);
				branchbox.setVisible(false);
				loadbox.setVisible(false);
				schoolbox.setVisible(false);
				waterbox.setVisible(false);
				electricitybox.setVisible(false);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);
				termsCheck.setVisible(false);
				checkLabel.setVisible(false);
				termsAndconditions.setVisible(false);

				school.setVisible(true);
				electricity.setVisible(true);
				water.setVisible(true);

				schoolLabel.setVisible(true);
				waterLabel.setVisible(true);
				elecLabel.setVisible(true);

				schoolLabel.setText("School");
				waterLabel.setText("Water");
				elecLabel.setText("Electricity");

				BG1.setVisible(true);
				termsCheck.setSelected(false);

			}
		});

		school.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				water.setVisible(false);
				electricity.setVisible(false);
				waterLabel.setText("");
				elecLabel.setText("");

				branchbox.setVisible(false);
				schoolbox.setVisible(true);
				waterbox.setVisible(false);
				electricitybox.setVisible(false);
				sLabel.setText("PAY SCHOOL BILL");
				Label1.setText("School");
				Label2.setText("Student ID/Number");
				Field2.setVisible(true);
				Label3.setText("Student Name");
				Field3.setVisible(true);
				newAmountField.setVisible(true);
				termsCheck.setVisible(true);
				checkLabel.setVisible(true);
				termsAndconditions.setVisible(true);
				schoolConfirm.setVisible(true);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				schoolConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = newAmountField.getText().trim();
						selectedSchool = (String) schoolbox.getSelectedItem();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							newAmountField.setForeground(Color.RED);
							aEdited = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else if (amount > currentBal) {
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else {
								// the input is a positive number
								newAmountField.setForeground(Color.BLACK);
								aEdited = true;
							}
						}

						if (selectedSchool.equals("(Select)")) {
							schoolbox.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							schoolbox.setForeground(new Color(0, 0, 0));
							fEdited1 = true;
						}

						if (!Field2.getText().matches("^[+\\d]{1,}$")) {
							Field2.setForeground(Color.RED);
							fEdited2 = false;
						} else {
							Field2.setForeground(new Color(0, 0, 0));
							fEdited2 = true;
						}

						if (!Field3.getText().matches("[a-zA-Z]+")) {
							Field3.setForeground(Color.RED);
							fEdited3 = false;
						} else {
							Field3.setForeground(Color.BLACK);
							fEdited3 = true;
						}

						if (check) {
							termsCheck.setBackground(Color.LIGHT_GRAY);
						} else {
							termsCheck.setBackground(Color.RED);
						}
//
//						if (!fEdited1 || !fEdited2 || !fEdited3 || !aEdited || !check) {
//
//						} else {

						amountString = newAmountField.getText();
						double amountDouble = Double.parseDouble(amountString);

						// DEDUCTING THE SENDER BALANCE
						SQLQuery.payBills(ID, amountDouble, selectedSchool);

						fEdited1 = false;
						fEdited2 = false;
						check = false;
						sLabel.setText("");
						Label1.setText("");
						Label2.setText("");
						Label3.setText("");
						Field1.setText("");
						Field2.setText("");
						Field3.setText("");
						Field1.setVisible(false);
						Field2.setVisible(false);
						Field3.setVisible(false);
						newAmountField.setVisible(false);
						pickup.setVisible(false);
						delivery.setVisible(false);
						schoolbox.setVisible(false);
						termsCheck.setVisible(false);
						checkLabel.setVisible(false);
						schoolConfirm.setVisible(false);
						termsAndconditions.setVisible(false);

						successFrame.setVisible(true);

//						}

					}
				});

			}
		});

		water.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				school.setVisible(false);
				electricity.setVisible(false);
				schoolLabel.setText("");
				elecLabel.setText("");

				branchbox.setVisible(false);
				schoolbox.setVisible(false);
				waterbox.setVisible(true);
				electricitybox.setVisible(false);
				sLabel.setText("PAY WATER BILL");
				Label1.setText("Biller");
				Label2.setText("Account Number");
				Field2.setVisible(true);
				Label3.setText("Account Name");
				Field3.setVisible(true);
				newAmountField.setVisible(true);
				termsCheck.setVisible(true);
				checkLabel.setVisible(true);
				termsAndconditions.setVisible(true);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(true);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				waterConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = newAmountField.getText();

						selectedWater = (String) waterbox.getSelectedItem();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							newAmountField.setForeground(Color.RED);
							aEdited = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else if (amount > currentBal) {
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else {
								// the input is a positive number
								newAmountField.setForeground(Color.BLACK);
								aEdited = true;
							}
						}

						if (selectedWater.equals("(Select)")) {
							waterbox.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							waterbox.setForeground(new Color(0, 0, 0));
							fEdited1 = true;
						}

						if (!Field2.getText().matches("^[+\\d]{1,}$")) {
							Field2.setForeground(Color.RED);
							fEdited2 = false;
						} else {
							Field2.setForeground(new Color(0, 0, 0));
							fEdited2 = true;
						}

						if (!Field3.getText().matches("[a-zA-Z]+")) {
							Field3.setForeground(Color.RED);
							fEdited3 = false;
						} else {
							Field3.setForeground(Color.BLACK);
							fEdited3 = true;
						}

						if (check) {
							termsCheck.setBackground(Color.LIGHT_GRAY);
						} else {
							termsCheck.setBackground(Color.RED);
						}

						amountString = newAmountField.getText();
						double amountDouble = Double.parseDouble(amountString);

						// DEDUCTING THE SENDER BALANCE
						SQLQuery.payBills(ID, amountDouble, selectedWater);

						fEdited1 = false;
						fEdited2 = false;
						check = false;
						sLabel.setText("");
						Label1.setText("");
						Label2.setText("");
						Label3.setText("");
						Field1.setText("");
						Field2.setText("");
						Field3.setText("");
						Field1.setVisible(false);
						Field2.setVisible(false);
						Field3.setVisible(false);
						newAmountField.setVisible(false);
						pickup.setVisible(false);
						delivery.setVisible(false);
						waterbox.setVisible(false);
						termsCheck.setVisible(false);
						checkLabel.setVisible(false);
						waterConfirm.setVisible(false);
						termsAndconditions.setVisible(false);

						successFrame.setVisible(true);

					}
				});

			}
		});

		electricity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				school.setVisible(false);
				water.setVisible(false);
				schoolLabel.setText("");
				waterLabel.setText("");

				branchbox.setVisible(false);
				schoolbox.setVisible(false);
				waterbox.setVisible(false);
				electricitybox.setVisible(true);
				sLabel.setText("PAY ELECTRICITY BILL");
				Label1.setText("Biller");
				Label2.setText("Account Number");
				Field2.setVisible(true);
				Label3.setText("Account Name");
				Field3.setVisible(true);
				newAmountField.setVisible(true);
				termsCheck.setVisible(true);
				checkLabel.setVisible(true);
				termsAndconditions.setVisible(true);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(true);
				waterConfirm.setVisible(false);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				elecConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = newAmountField.getText();
						selectedElectric = (String) electricitybox.getSelectedItem();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							newAmountField.setForeground(Color.RED);
							aEdited = false;
						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else if (amount > currentBal) {
								newAmountField.setForeground(Color.RED);
								aEdited = false;
							} else {
								// the input is a positive number
								newAmountField.setForeground(Color.BLACK);
								aEdited = true;
							}
						}

						if (selectedElectric.equals("(Select)")) {
							electricitybox.setForeground(Color.RED);
							fEdited1 = false;
						} else {
							electricitybox.setForeground(new Color(0, 0, 0));
							fEdited1 = true;
						}

						if (!Field2.getText().matches("^[+\\d]{1,}$")) {
							Field2.setForeground(Color.RED);
							fEdited2 = false;
						} else {
							Field2.setForeground(new Color(0, 0, 0));
							fEdited2 = true;
						}

						if (!Field3.getText().matches("[a-zA-Z]+")) {
							Field3.setForeground(Color.RED);
							fEdited3 = false;
						} else {
							Field3.setForeground(Color.BLACK);
							fEdited3 = true;
						}

						if (check) {
							termsCheck.setBackground(Color.LIGHT_GRAY);
						} else {
							termsCheck.setBackground(Color.RED);
						}

						if (!fEdited1 || !fEdited2 || !fEdited3 || !aEdited || !check) {

						} else {

							amountString = newAmountField.getText();
							double amountDouble = Double.parseDouble(amountString);

							// DEDUCTING THE SENDER BALANCE
							SQLQuery.payBills(ID, amountDouble, selectedElectric);

							fEdited1 = false;
							fEdited2 = false;
							check = false;
							sLabel.setText("");
							Label1.setText("");
							Label2.setText("");
							Label3.setText("");
							Field1.setText("");
							Field2.setText("");
							Field3.setText("");
							Field1.setVisible(false);
							Field2.setVisible(false);
							Field3.setVisible(false);
							newAmountField.setVisible(false);
							pickup.setVisible(false);
							delivery.setVisible(false);
							electricitybox.setVisible(false);
							termsCheck.setVisible(false);
							checkLabel.setVisible(false);
							elecConfirm.setVisible(false);
							termsAndconditions.setVisible(false);

							successFrame.setVisible(true);

						}

					}
				});
			}
		});

		borrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Field1.setForeground(Color.BLACK);
				Field2.setForeground(Color.BLACK);
				Field3.setForeground(Color.BLACK);

				termsCheck.setBackground(Color.LIGHT_GRAY);

				Field1.setText("");
				Field2.setText("");
				Field3.setText("");

				sLabel.setText("BORROW MONEY");
				Label1.setText("Amount");
				Label2.setText("");
				Label3.setText("");
				Field1.setVisible(true);
				Field2.setVisible(false);
				Field3.setVisible(false);
				newAmountField.setVisible(false);
				sendConfirm.setVisible(false);
				loadConfirm.setVisible(false);
				cashConfirm.setVisible(false);
				deliveryConfirm.setVisible(false);
				pickupConfirm.setVisible(false);
				schoolConfirm.setVisible(false);
				elecConfirm.setVisible(false);
				waterConfirm.setVisible(false);
				borrowConfirm.setVisible(true);
				pickup.setVisible(false);
				delivery.setVisible(false);
				branchbox.setVisible(false);
				loadbox.setVisible(false);
				schoolbox.setVisible(false);
				waterbox.setVisible(false);
				electricitybox.setVisible(false);
				termsCheck.setVisible(true);
				checkLabel.setVisible(true);
				termsAndconditions.setVisible(true);

				school.setVisible(false);
				electricity.setVisible(false);
				water.setVisible(false);

				elecLabel.setVisible(false);
				schoolLabel.setVisible(false);
				waterLabel.setVisible(false);

				BG1.setVisible(false);
				termsCheck.setSelected(false);

				borrowConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String amountString = Field1.getText();

						if (!isNumeric(amountString)) {
							// the input is not a valid number
							Field1.setForeground(Color.RED);
							fEdited1 = false;

						} else {
							double amount = Double.parseDouble(amountString);
							if (amount <= 0) {
								// the input is 0 or a negative number
								Field1.setForeground(Color.RED);
								fEdited1 = false;
							} else {
								Field1.setForeground(Color.BLACK);
								fEdited1 = true;
							}
						}
						if (check) {
							termsCheck.setBackground(Color.LIGHT_GRAY);
						} else {
							termsCheck.setBackground(Color.RED);
						}

						if (!fEdited1 || !check) {

						} else {
							// the input is a positive number
							termsCheck.setBackground(Color.LIGHT_GRAY);
							Field1.setForeground(Color.BLACK);

							// GETTING THE BALANCE OF THE RECEIVER

							amountString = newAmountField.getText();
							double amountDouble = Double.parseDouble(amountString);

							SQLQuery.addBalance(ID, amountDouble);

							fEdited1 = false;
							fEdited2 = false;
							check = false;
							sLabel.setText("");
							Label1.setText("");
							Label2.setText("");
							Field1.setText("");
							Field2.setText("");
							Field1.setVisible(false);
							Field2.setVisible(false);
							termsCheck.setVisible(false);
							checkLabel.setVisible(false);
							termsAndconditions.setVisible(false);
							sendConfirm.setVisible(false);
							cashConfirm.setVisible(false);
							borrowConfirm.setVisible(false);

							successFrame.setVisible(true);
						}

					}
				});

			}
		});

		JLabel availBal = new JLabel("AVAILABLE BALANCE");
		availBal.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 13));
		availBal.setBounds(399, 29, 163, 29);
		mainPanel.add(availBal);

		JLabel lbl1 = new JLabel("Send");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setForeground(new Color(153, 102, 204));
		lbl1.setFont(new Font("Heebo", Font.PLAIN, 16));
		lbl1.setBounds(142, 118, 47, 29);
		mainPanel.add(lbl1);

		JLabel lbl2 = new JLabel("Load");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setForeground(new Color(153, 102, 204));
		lbl2.setFont(new Font("Heebo", Font.PLAIN, 16));
		lbl2.setBounds(42, 285, 47, 29);
		mainPanel.add(lbl2);

		JLabel lbl3 = new JLabel("Bills");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setForeground(new Color(153, 102, 204));
		lbl3.setFont(new Font("Heebo", Font.PLAIN, 16));
		lbl3.setBounds(143, 339, 47, 29);
		mainPanel.add(lbl3);

		JLabel lbl4 = new JLabel("Cash In");
		lbl4.setHorizontalAlignment(SwingConstants.LEFT);
		lbl4.setForeground(new Color(153, 102, 204));
		lbl4.setFont(new Font("Heebo", Font.PLAIN, 16));
		lbl4.setBounds(237, 195, 56, 29);
		mainPanel.add(lbl4);

		JLabel lbl5 = new JLabel("Withdraw");
		lbl5.setHorizontalAlignment(SwingConstants.LEFT);
		lbl5.setForeground(new Color(153, 102, 204));
		lbl5.setFont(new Font("Heebo", Font.PLAIN, 16));
		lbl5.setBounds(32, 193, 82, 29);
		mainPanel.add(lbl5);

		JLabel lbl6 = new JLabel("Borrow");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setForeground(new Color(153, 102, 204));
		lbl6.setFont(new Font("Heebo", Font.PLAIN, 16));
		lbl6.setBounds(234, 293, 65, 29);
		mainPanel.add(lbl6);

		JLabel icon5 = new JLabel("");
		icon5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		icon5.setBounds(92, 11, 136, 49);
		mainPanel.add(icon5);
		icon5.setHorizontalAlignment(SwingConstants.CENTER);
		icon5.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpLogo1.png")));

		GradientPanel grayPanel = new GradientPanel(new Color(230, 230, 230), new Color(150, 150, 150));
		// JPanel grayPanel = new JPanel();
		// grayPanel.setBackground(new Color(192, 192, 192));
		grayPanel.setBounds(328, 0, 355, 474);
		mainPanel.add(grayPanel);
		grayPanel.setLayout(null);

		send = new JButton("");
		send.setBounds(8, 7, 34, 33);
		grayPanel.add(send);
		send.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/phpicons0.png")));
		send.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		send.setBackground(Color.LIGHT_GRAY);

		BG1 = new JLabel((String) null);
		BG1.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/walletBG.png")));
		BG1.setHorizontalAlignment(SwingConstants.CENTER);
		BG1.setForeground(Color.BLACK);
		BG1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 42));
		BG1.setBackground(Color.WHITE);
		BG1.setBounds(4, 107, 344, 337);
		grayPanel.add(BG1);

		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isVisible) {
					final int xProfile = profileButton.getX();
					final int xLogout = logoutButton.getX();
					final int xDelete = deleteButton.getX();
					int targetX = 536;

					Timer timer = new Timer(10, new ActionListener() {
						int updatedXProfile = xProfile;
						int updatedXLogout = xLogout;
						int updatedXDelete = xDelete;

						public void actionPerformed(ActionEvent e) {
							if (updatedXProfile > targetX) {
								updatedXProfile -= 10;
								profileButton.setBounds(updatedXProfile, 0, 200, 50);
							}
							if (updatedXLogout > targetX) {
								updatedXLogout -= 10;
								logoutButton.setBounds(updatedXLogout, 60, 200, 50);
							}
							if (updatedXDelete > targetX) {
								updatedXDelete -= 10;
								deleteButton.setBounds(updatedXDelete, 120, 200, 50);
							}
							if (updatedXProfile == targetX && updatedXLogout == targetX && updatedXDelete == targetX) {
								((Timer) e.getSource()).stop();
								isVisible = true;
							}
						}
					});
					timer.start();
				} else { // add this else statement
					final int xProfile = profileButton.getX();
					final int xLogout = logoutButton.getX();
					final int xDelete = logoutButton.getX();
					int targetX = 686;

					Timer timer = new Timer(10, new ActionListener() {
						int updatedXProfile = xProfile;
						int updatedXLogout = xLogout;
						int updatedXDelete = xDelete;

						public void actionPerformed(ActionEvent e) {
							if (updatedXProfile < targetX) {
								updatedXProfile += 10;
								profileButton.setBounds(updatedXProfile, 0, 200, 50);
							}
							if (updatedXLogout < targetX) {
								updatedXLogout += 10;
								logoutButton.setBounds(updatedXLogout, 60, 200, 50);
							}
							if (updatedXDelete < targetX) {
								updatedXDelete += 10;
								deleteButton.setBounds(updatedXDelete, 120, 200, 50);
							}
							if (updatedXProfile == targetX && updatedXLogout == targetX && updatedXDelete == targetX) {
								((Timer) e.getSource()).stop();
								isVisible = false;
							}
						}
					});

					timer.start();
				}
			}
		});

		termsAndconditions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = new JFrame("Terms and Conditions");
				JTextArea textArea = new JTextArea();
				JScrollPane scrollPane = new JScrollPane(textArea);
				frame.getContentPane().add(scrollPane);
				frame.setSize(500, 500);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (dim.width - frame.getSize().width) / 2;
				int y = (dim.height - frame.getSize().height) / 2;
				frame.setLocation(x, y);
				frame.setVisible(true);
				textArea.setEditable(false);

				try {
					// Replace "terms_and_conditions.txt" with the path to your text file
					BufferedReader reader = new BufferedReader(new FileReader("terms.txt"));
					String line = reader.readLine();
					while (line != null) {
						textArea.append(line + "\n");
						line = reader.readLine();
					}
					reader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		sendIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		withdraw.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loadIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		electricity.setCursor(new Cursor(Cursor.HAND_CURSOR));
		school.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bills.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cashIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		borrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
		water.setCursor(new Cursor(Cursor.HAND_CURSOR));
		send.setCursor(new Cursor(Cursor.HAND_CURSOR));

		showBalance = new JLabel("");
		showBalance.setBounds(18, 38, 344, 77);
		grayPanel.add(showBalance);
		showBalance.setIcon(new ImageIcon(Wallet.class.getResource("/phpay/phpimg/icon3.png")));
		showBalance.setForeground(new Color(0, 0, 0));
		showBalance.setBackground(new Color(255, 255, 255));
		showBalance.setHorizontalAlignment(SwingConstants.CENTER);
		showBalance.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 42));
		showBalance.setText(getBal);
		termsAndconditions.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	public void updateBalanceLabelFromFile() {
		SQLConnection newCon = new SQLConnection();
		newCon.Connect();

		String query = "SELECT `balance` FROM `users` WHERE id = ?";
		try {
			PreparedStatement ps = newCon.getCon().prepareStatement(query);
			ps.setString(1, session);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				getBal = rs.getString("balance");
				System.out.println(getBal);
				double balance = Double.parseDouble(getBal);
				String formattedBalance = addCommaSeparator(String.format("%.2f", balance));
				showBalance.setText(formattedBalance);

			}
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public String getSession() {
		return session;
	}
}

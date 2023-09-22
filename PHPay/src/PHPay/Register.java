package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private RoundedTextField firstNameField, lastNameField, phonenumberField, addressField, emailField;
	private JLabel firstNameStatusLabel, lastNameStatusLabel, phoneStatusLabel, addressStatusLabel, emailStatusLabel,
			yearLabel;
	JButton registerButton;
	boolean firstNameEdited = false;
	boolean lastNameEdited = false;
	boolean phoneEdited = false;
	boolean addressEdited = false;
	boolean emailEdited = false;
	boolean monthEdited = false;
	boolean dayEdited = false;
	boolean yearEdited = false;
	public String selectedDay, selectedMonth, selectedYear, age;
	private String fName, lName, ageStr, phone, address, saveM, saveD, saveY;
	private int year, x, y;
	private JLabel proceedButton;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JPanel blurPanel;
	private JLabel logo;
	private JComboBox<String> yearBox;
	private static final int LONG_PRESS_DURATION = 1000;
	private JProgressBar progressBar;
	private Timer longPressTimer;
	private AtomicBoolean longPressing = new AtomicBoolean(false);
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblCreateAnAccount;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPhoneNumber;
	private JLabel lblAddress;
	private JLabel lblEmailAddress;
	private PHPay.RoundedButton rndbtnClearAll;

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidName(String name) {
		String pattern = "^[a-zA-Z]+([\\s-][a-zA-Z]+)*(\\.[a-zA-Z]+)?$";

		if (name.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public Register() {
		setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 12));
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		setBackground(new Color(64, 0, 128, 0));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Register.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setForeground(new Color(255, 255, 255));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 833) / 2;
		int centerY = (screenHeight - 475) / 2;
		setLocation(centerX, centerY);
		setSize(833, 475);
		getContentPane().setLayout(null);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

		GradientPanel panel = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 833, 475);
		getContentPane().add(panel);
		panel.setLayout(null);

		JTextField textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);

		String[] months = { " Month", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };

		String[] days = new String[32];
		days[0] = " Day";
		for (int i = 1; i <= 31; i++) {
			days[i] = String.valueOf(i);
		}

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String[] years = new String[106];
		years[0] = " Year";
		for (int i = 1; i <= 105; i++) {
			years[i] = String.valueOf(currentYear - 17 - i);
		}

		RoundedPanel infoPane = new RoundedPanel(20);
		infoPane.setLayout(null);
		infoPane.setBackground(new Color(64, 0, 128, 50));
		infoPane.setBounds(315, 23, 498, 430);
		panel.add(infoPane);

		monthLabel = new JLabel("");
		monthLabel.setVisible(false);
		monthLabel.setBounds(154, 315, 20, 20);
		infoPane.add(monthLabel);
		monthLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		monthLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		firstNameStatusLabel = new JLabel("");
		firstNameStatusLabel.setVisible(false);
		firstNameStatusLabel.setBounds(217, 51, 20, 20);
		infoPane.add(firstNameStatusLabel);
		firstNameStatusLabel.setVerifyInputWhenFocusTarget(false);
		firstNameStatusLabel.setBackground(new Color(255, 255, 255));
		firstNameStatusLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		firstNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		lastNameStatusLabel = new JLabel("");
		lastNameStatusLabel.setVisible(false);
		lastNameStatusLabel.setBounds(411, 51, 20, 20);
		infoPane.add(lastNameStatusLabel);
		lastNameStatusLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		lastNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		phoneStatusLabel = new JLabel("");
		phoneStatusLabel.setVisible(false);
		phoneStatusLabel.setBounds(410, 117, 20, 20);
		infoPane.add(phoneStatusLabel);
		phoneStatusLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		phoneStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		addressStatusLabel = new JLabel("");
		addressStatusLabel.setVisible(false);
		addressStatusLabel.setBounds(410, 183, 20, 20);
		infoPane.add(addressStatusLabel);
		addressStatusLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		addressStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		emailStatusLabel = new JLabel("");
		emailStatusLabel.setVisible(false);
		emailStatusLabel.setBounds(410, 249, 20, 20);
		infoPane.add(emailStatusLabel);
		emailStatusLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		emailStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		dayLabel = new JLabel("");
		dayLabel.setVisible(false);
		dayLabel.setBounds(266, 315, 20, 20);
		infoPane.add(dayLabel);
		dayLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		dayLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		yearLabel = new JLabel("");
		yearLabel.setVisible(false);
		yearLabel.setBounds(389, 315, 20, 20);
		infoPane.add(yearLabel);
		yearLabel.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/warning.png")));
		yearLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		RoundedButton nextButton = new RoundedButton("");
		nextButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		nextButton.setText("Next");
		nextButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		nextButton.setBounds(311, 370, 124, 40);
		infoPane.add(nextButton);

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fName = firstNameField.getText();
				System.out.println(fName);
				if (fName.equals("  First Name")) {
					firstNameStatusLabel.setVisible(true);
					firstNameStatusLabel.setToolTipText("Please type in your first name");
					firstNameEdited = false;
				} else if (!isValidName(fName)) {
					firstNameStatusLabel.setVisible(true);
					firstNameStatusLabel.setToolTipText("Invalid first name");
					firstNameEdited = false;
				} else {
					firstNameStatusLabel.setVisible(false);
					firstNameEdited = true;
				}

				lName = lastNameField.getText();
				if (lastNameField.getText().equals("  Last Name")) {
					lastNameStatusLabel.setVisible(true);
					lastNameStatusLabel.setToolTipText("Please type in your last name");
					lastNameEdited = false;
				} else if (!isValidName(lName)) {
					lastNameStatusLabel.setVisible(true);
					lastNameStatusLabel.setToolTipText("Invalid last name");
					lastNameEdited = false;
				} else {
					lastNameStatusLabel.setVisible(false);
					lastNameEdited = true;
				}

				phone = phonenumberField.getText();
				if (phone.equals("  Phone Number")) {
					phoneStatusLabel.setVisible(true);
					phoneStatusLabel.setToolTipText("Please type in your phone number");
					phoneEdited = false;
				} else if (!phone.matches("^\\d{11}$")) {
					phoneStatusLabel.setVisible(true);
					phoneStatusLabel.setToolTipText("Invalid phone number");
					phoneEdited = false;
				} else if (!(phone.length() == 11)) {
					phoneStatusLabel.setVisible(true);
					phoneStatusLabel.setToolTipText("Phone number length is invalid");
					phoneEdited = false;
				} else {
					phoneStatusLabel.setVisible(false);
					phoneEdited = true;
				}

				address = addressField.getText();
				if (address.isEmpty()) {
					addressStatusLabel.setVisible(true);
					addressStatusLabel.setToolTipText("Please type in your address");
					addressEdited = false;
				} else if (addressField.getText().equals("  Address")) {
					addressStatusLabel.setVisible(true);
					addressStatusLabel.setToolTipText("Please type in your address");
					addressEdited = false;
				} else if (address.matches("^\\s+$")) {
					addressStatusLabel.setVisible(true);
					addressStatusLabel.setToolTipText("Invalid address");
					addressEdited = false;
				} else if (address.length() <= 3) {
					addressStatusLabel.setVisible(true);
					addressStatusLabel.setToolTipText("Fill your full address");
					addressEdited = false;
				} else {
					addressStatusLabel.setVisible(false);
					addressEdited = true;
				}

				String email = emailField.getText();
				if (email.equals("  Email Address")) {
					emailStatusLabel.setVisible(true);
					emailStatusLabel.setToolTipText("Please type in your email");
					emailEdited = false;
				} else if (!isValidEmail(email)) {
					emailStatusLabel.setVisible(true);
					emailStatusLabel.setToolTipText("Invalid email");
					emailEdited = false;
				} else {
					emailStatusLabel.setVisible(false);
					emailEdited = true;
				}

				Map<String, Integer> monthMap = new HashMap<>();
				monthMap.put("Month", 0);
				monthMap.put("January", 1);
				monthMap.put("February", 2);
				monthMap.put("March", 3);
				monthMap.put("April", 4);
				monthMap.put("May", 5);
				monthMap.put("June", 6);
				monthMap.put("July", 7);
				monthMap.put("August", 8);
				monthMap.put("September", 9);
				monthMap.put("October", 10);
				monthMap.put("November", 11);
				monthMap.put("December", 12);

				int birthMonth = monthMap.get(selectedMonth);
				int birthDay = Integer.parseInt(selectedDay);
				int birthYear = Integer.parseInt(selectedYear);

				if (birthMonth > 0) {
					monthEdited = true;
					monthLabel.setVisible(false);
				} else {
					monthLabel.setVisible(true);
					monthLabel.setToolTipText("Please select your birth month");
					return;
				}

				boolean isLeapYear = ((birthYear % 4 == 0 && birthYear % 100 != 0) || (birthYear % 400 == 0));

				if (selectedMonth == "February") {

					if (birthDay >= 29) {
						if (birthDay == 29) {
							if (!isLeapYear) {
								dayEdited = false;
								dayLabel.setVisible(true);
								dayLabel.setToolTipText(
										"February 29th is only available in leap years. Please choose another date.");
								return;
							} else {
								selectedYear = (String) yearBox.getSelectedItem();
								dayLabel.setVisible(false);
								dayEdited = true;
							}
						} else {
							dayEdited = false;
							dayLabel.setVisible(true);
							dayLabel.setToolTipText(
									"February typically has 28 days, but in leap years, it has 29 days.");
							return;
						}
					} else {
						dayEdited = true;
						selectedYear = (String) yearBox.getSelectedItem();
						dayLabel.setVisible(false);
					}
				}

				birthYear = Integer.parseInt(selectedYear);
				System.out.println(birthMonth + "" + birthYear + "" + birthDay);
				LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
				LocalDate currentDate = LocalDate.now();
				Period agePeriod = Period.between(birthDate, currentDate);

				int ageInt = agePeriod.getYears();
				age = String.valueOf(ageInt);

				if (selectedDay.equals(" Day")) {
					dayLabel.setVisible(true);
					dayLabel.setToolTipText("Please select your birth day");
					System.out.println("days");
					return;
				} else if (selectedDay.equals(null)) {
					dayLabel.setVisible(true);
					dayLabel.setToolTipText("Please select your birth day");
					dayEdited = false;
					System.out.println("days");
				} else {
					birthDay = Integer.parseInt(selectedDay);
					dayLabel.setVisible(false);
					dayEdited = true;
					System.out.println("days");
				}

				if (selectedYear.equals(null)) {
					yearLabel.setVisible(true);
					yearLabel.setToolTipText("Please select your birth year");
					yearEdited = false;
				} else if (selectedYear.equals(" Year")) {
					yearLabel.setVisible(true);
					yearLabel.setToolTipText("Please select your birth year");
					return;
				} else {
					birthYear = Integer.parseInt(selectedYear);
					yearLabel.setVisible(false);
					yearEdited = true;

				}

				if (firstNameEdited && lastNameEdited && monthEdited && dayEdited && yearEdited && phoneEdited
						&& addressEdited && emailEdited && yearEdited) {
					if (!firstNameField.getText().isEmpty() && !lastNameField.getText().isEmpty()
							&& !phonenumberField.getText().isEmpty() && !addressField.getText().isEmpty()
							&& !emailField.getText().isEmpty() && !(ageInt < 18)) {

						String saveF = firstNameField.getText();
						String saveL = lastNameField.getText();
						String saveA = age;
						saveM = selectedMonth;
						saveD = selectedDay;
						saveY = selectedYear;
						String saveP = phonenumberField.getText();
						String saveAd = addressField.getText();
						String saveE = emailField.getText();

						AccountInfo registerInfo = new AccountInfo(saveF, saveL, saveA, saveM, saveD, saveY, saveP,
								saveAd, saveE);

						UserPassID userpassID = new UserPassID(registerInfo);
						userpassID.setVisible(true);
						setVisible(false);
						dispose();

						System.out.println(saveF + saveL + saveA + saveM + saveD + saveY + saveP + saveAd + saveE);

					} else {

					}

				} else {

				}

			}
		});
		nextButton.setBackground(new Color(0, 0, 0));
		nextButton.setForeground(new Color(255, 255, 255));

		RoundedComboBox<String> monthBox = new RoundedComboBox<>(months);
		monthBox.setBounds(57, 310, 140, 30);
		infoPane.add(monthBox);
		monthBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		monthBox.setBackground(new Color(35, 0, 70));
		monthBox.setForeground(new Color(255, 255, 255));
		monthBox.setMaximumRowCount(4);
		JComboBox<String> dayBox = new JComboBox<>(days);
		dayBox.setBounds(210, 310, 98, 30);
		infoPane.add(dayBox);
		dayBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		dayBox.setBackground(new Color(35, 0, 70));
		dayBox.setForeground(new Color(255, 255, 255));
		dayBox.setMaximumRowCount(4);

		yearBox = new JComboBox<>(years);
		yearBox.setBounds(322, 310, 113, 30);
		infoPane.add(yearBox);
		yearBox.setForeground(new Color(255, 255, 255));
		yearBox.setBackground(new Color(35, 0, 70));
		yearBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		yearBox.setMaximumRowCount(4);

		firstNameField = new RoundedTextField(10);
		firstNameField.setBounds(57, 46, 184, 30);
		infoPane.add(firstNameField);
		firstNameField.setMargin(new Insets(2, 7, 2, 7));
		firstNameField.setToolTipText("");
		firstNameField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		firstNameField.setForeground(new Color(192, 192, 192));

		lastNameField = new RoundedTextField(10);
		lastNameField.setBounds(251, 46, 184, 30);
		infoPane.add(lastNameField);
		lastNameField.setMargin(new Insets(2, 7, 2, 7));
		lastNameField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		lastNameField.setForeground(new Color(192, 192, 192));

		phonenumberField = new RoundedTextField(10);
		phonenumberField.setBounds(57, 112, 378, 30);
		infoPane.add(phonenumberField);
		phonenumberField.setMargin(new Insets(2, 7, 2, 7));
		phonenumberField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		phonenumberField.setForeground(new Color(192, 192, 192));

		addressField = new RoundedTextField(10);
		addressField.setBounds(57, 178, 378, 30);
		infoPane.add(addressField);
		addressField.setMargin(new Insets(2, 7, 2, 7));
		addressField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		addressField.setForeground(new Color(192, 192, 192));

		emailField = new RoundedTextField(10);
		emailField.setBounds(57, 244, 378, 30);
		infoPane.add(emailField);
		emailField.setMargin(new Insets(2, 7, 2, 7));
		emailField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		emailField.setForeground(new Color(192, 192, 192));

		lblFirstName = new JLabel("First Name");
		lblFirstName.setIconTextGap(6);
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblFirstName.setBounds(57, 26, 156, 23);
		infoPane.add(lblFirstName);

		lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblLastName.setBounds(251, 26, 156, 23);
		infoPane.add(lblLastName);

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setIconTextGap(6);
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(57, 89, 156, 23);
		infoPane.add(lblPhoneNumber);

		lblAddress = new JLabel("Address");
		lblAddress.setIconTextGap(6);
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAddress.setBounds(57, 157, 156, 23);
		infoPane.add(lblAddress);

		lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setIconTextGap(6);
		lblEmailAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailAddress.setForeground(Color.WHITE);
		lblEmailAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblEmailAddress.setBounds(58, 223, 156, 23);
		infoPane.add(lblEmailAddress);

		rndbtnClearAll = new PHPay.RoundedButton("");
		rndbtnClearAll.setText("Clear All");
		rndbtnClearAll.setForeground(Color.WHITE);
		rndbtnClearAll.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		rndbtnClearAll.setBorder(new EmptyBorder(0, 0, 0, 0));
		rndbtnClearAll.setBackground(Color.BLACK);
		rndbtnClearAll.setBounds(57, 380, 69, 30);
		infoPane.add(rndbtnClearAll);

//		emailField.addFocusListener(new FocusListener() {
//			public void focusGained(FocusEvent e) {
//				if (emailField.getText().equals("  Email Address")) {
//					emailField.setText("");
//					emailField.setForeground(Color.WHITE);
//				}
//			}
//
//			public void focusLost(FocusEvent e) {
//				if (emailField.getText().isEmpty()) {
//					emailField.setText("  Email Address");
//					emailField.setForeground(Color.GRAY);
//				} else if (!emailField.getText().isEmpty() && !emailField.getText().equals("Email")) {
//					emailEdited = true;
//					if (!isValidEmail(emailField.getText())) {
//						emailStatusLabel.setText("Invalid email");
//						emailStatusLabel.setForeground(Color.RED);
//					}
//				}
//			}
//		});
//		addressField.addFocusListener(new FocusListener() {
//			public void focusGained(FocusEvent e) {
//				if (addressField.getText().equals("  Address")) {
//					addressField.setText("");
//					addressField.setForeground(Color.WHITE);
//				}
//			}
//
//			public void focusLost(FocusEvent e) {
//				if (addressField.getText().isEmpty()) {
//					addressField.setText("  Address");
//					addressField.setForeground(Color.GRAY);
//				} else {
//					addressEdited = true;
//
//				}
//			}
//		});
//		phonenumberField.addFocusListener(new FocusListener() {
//			public void focusGained(FocusEvent e) {
//				if (phonenumberField.getText().equals("  Phone Number")) {
//					phonenumberField.setText("");
//					phonenumberField.setForeground(Color.WHITE);
//				}
//			}
//
//			public void focusLost(FocusEvent e) {
//				if (phonenumberField.getText().isEmpty()) {
//					phonenumberField.setText("  Phone Number");
//					phonenumberField.setForeground(Color.GRAY);
//				} else {
//					phoneEdited = true;
//				}
//			}
//		});
//		lastNameField.addFocusListener(new FocusListener() {
//			public void focusGained(FocusEvent e) {
//				if (lastNameField.getText().equals("  Last Name")) {
//					lastNameField.setText("");
//					lastNameField.setForeground(Color.WHITE);
//				}
//			}
//
//			public void focusLost(FocusEvent e) {
//				if (lastNameField.getText().isEmpty()) {
//					lastNameField.setText("  Last Name");
//					lastNameField.setForeground(Color.GRAY);
//				} else {
//					lastNameEdited = true;
//				}
//			}
//		});
//		firstNameField.addFocusListener(new FocusListener() {
//
//			public void focusGained(FocusEvent e) {
//				if (firstNameField.getText().equals("  First Name")) {
//					firstNameField.setText("");
//					firstNameField.setForeground(Color.WHITE);
//				}
//			}
//
//			public void focusLost(FocusEvent e) {
//				if (firstNameField.getText().isEmpty()) {
//					firstNameField.setText("  First Name");
//					firstNameField.setForeground(Color.GRAY);
//				} else {
//					firstNameEdited = true;
//				}
//			}
//		});
//		yearBox.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				selectedYear = (String) yearBox.getSelectedItem();
//
//				if (selectedYear.equals(" Year")) {
//					return;
//				}
//			}
//		});
//
//		yearBox.addFocusListener(new FocusListener() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				yearBox.setBackground(new Color(0, 0, 0));
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				yearBox.setBackground(new Color(0, 0, 0));
//			}
//		});
//
//		dayBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				selectedDay = (String) dayBox.getSelectedItem();
//			}
//		});
//
//		dayBox.addFocusListener(new FocusListener() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				dayBox.setBackground(new Color(0, 0, 0));
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				dayBox.setBackground(new Color(0, 0, 0));
//			}
//		});
//		monthBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				selectedMonth = (String) monthBox.getSelectedItem();
//			}
//		});
//		monthBox.addFocusListener(new FocusListener() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				monthBox.setBackground(new Color(0, 0, 0));
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				monthBox.setBackground(new Color(0, 0, 0));
//			}
//		});

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(255, 255, 255, 0));
		titleBar.setBounds(0, 1, 833, 23);
		panel.add(titleBar);

		RoundedPanel signupPane = new RoundedPanel(20);
		signupPane.setBounds(-12, 0, 307, 476);
		panel.add(signupPane);
		signupPane.setBackground(new Color(64, 0, 128, 150));
		signupPane.setLayout(null);

		lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 47));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 70, 297, 70);
		signupPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/signup.png")));
		lblNewLabel_1.setBounds(14, 168, 309, 327);
		signupPane.add(lblNewLabel_1);

		RoundedButton btnNewButton = new RoundedButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				Timer timer = new Timer(250, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Welcome welcome = new Welcome();
						welcome.setVisible(true);
					}
				});
				timer.setRepeats(false);
				timer.start();

			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBounds(22, 23, 39, 33);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBounds(23, 24, 37, 31);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setBounds(23, 24, 37, 31);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setBounds(22, 23, 39, 33);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/goback.png")));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBounds(23, 24, 37, 31);
		signupPane.add(btnNewButton);

		lblCreateAnAccount = new JLabel("Create your account");
		lblCreateAnAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAnAccount.setForeground(Color.WHITE);
		lblCreateAnAccount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblCreateAnAccount.setBounds(10, 117, 297, 70);
		signupPane.add(lblCreateAnAccount);

		RoundedPanel signupPane_1 = new RoundedPanel(20);
		signupPane_1.setLayout(null);
		signupPane_1.setBackground(new Color(64, 0, 128, 150));
		signupPane_1.setBounds(-8, 74, 271, 103);
		signupPane.add(signupPane_1);

//		PhpaySplash mainPanel = new PhpaySplash();
//		mainPanel.setBounds(0, 0, 283, 476);
//		signupPane.add(mainPanel);
//		mainPanel.setLayout(null);
//		mainPanel.setBackground(new Color(255, 255, 255));

		titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		titleBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int newX = getX() + e.getX() - x;
				int newY = getY() + e.getY() - y;

				setLocation(newX, newY);
			}
		});

	}

	public String getFName() {
		return fName;
	}

	public String getLName() {
		return lName;
	}

	public String getAge() {
		return ageStr;
	}

	public String getMonth() {
		return selectedMonth;
	}

	public String getDay() {
		return selectedDay;
	}

	public String getYear() {
		return selectedYear;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return emailField.getText();
	}
}
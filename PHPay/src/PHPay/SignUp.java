package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;


public class SignUp extends JFrame {

	private RoundedTextField firstnameField, lastnameField, phonenumberField, addressField, emailField;
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
	boolean genderEdited = false;
	boolean civilEdited = false;
	public String selectedDay, selectedMonth, selectedYear, age;
	private String fName, lName, ageStr, phone, address, saveM, saveD, saveY;
	private int x, y;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JComboBox<String> yearBox;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblCreateAnAccount;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPhoneNumber;
	private JLabel lblAddress;
	private JLabel lblEmailAddress;
	private RoundedButton rndbtnClearAll;
	private JLabel civilLabel;
	private JLabel genderLabel;
	Calendar calendar = Calendar.getInstance();
	RoundedComboBox<String> civilBox, genderBox, monthBox, dayBox;
	int centerX;
	private AccountInfo registerInfo;
	private static final long serialVersionUID = 1L;

	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setSize(811, 512);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		centerX = (screenWidth - 811) / 2;
		int centerY = (screenHeight - 512) / 2;
		setLocation(centerX, centerY);
		setVisible(true);

		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

		GradientPanel panel = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		panel.setForeground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 814, 512);
		getContentPane().add(panel);
		panel.setLayout(null);

		dayLabel = new JLabel("");
		dayLabel.setBounds(570, 189, 20, 20);
		panel.add(dayLabel);
		dayLabel.setVisible(false);
		dayLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		dayLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		addressStatusLabel = new JLabel("");
		addressStatusLabel.setBounds(726, 330, 20, 20);
		panel.add(addressStatusLabel);
		addressStatusLabel.setVisible(false);
		addressStatusLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		addressStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		yearLabel = new JLabel("");
		yearLabel.setBounds(705, 189, 20, 20);
		panel.add(yearLabel);
		yearLabel.setVisible(false);
		yearLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		yearLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		monthLabel = new JLabel("");
		monthLabel.setBounds(470, 189, 20, 20);
		panel.add(monthLabel);
		monthLabel.setVisible(false);
		monthLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		monthLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		RoundedPanel signupPane = new RoundedPanel(20);
		signupPane.setBounds(-12, 0, 333, 512);
		panel.add(signupPane);
		signupPane.setBackground(new Color(64, 0, 128, 120));
		signupPane.setLayout(null);

		int currentMonth = calendar.get(Calendar.MONTH);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int currentYear = calendar.get(Calendar.YEAR);

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		String[] days = new String[31];
		for (int i = 0; i < 31; i++) {
			days[i] = String.valueOf(i + 1);
		}

		String[] years = new String[123];
		for (int i = 0; i <= 122; i++) {
			years[i] = String.valueOf(currentYear - i);
		}

		String[] civil = { "Single", "Married", "Widowed", "Divorced", "" };

		String[] gender = { "Male", "Female", "Other", "" };

		RoundedButton btnNewButton = new RoundedButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				Timer timer = new Timer(100, new ActionListener() {
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
		btnNewButton.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/goback.png")));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBounds(23, 24, 37, 31);
		signupPane.add(btnNewButton);

		lblCreateAnAccount = new JLabel("Personal Information");
		lblCreateAnAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAnAccount.setForeground(Color.WHITE);
		lblCreateAnAccount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblCreateAnAccount.setBounds(10, 117, 297, 70);
		signupPane.add(lblCreateAnAccount);

		lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 47));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 70, 297, 70);
		signupPane.add(lblNewLabel);

		RoundedPanel signupPane_1 = new RoundedPanel(20);
		signupPane_1.setLayout(null);
		signupPane_1.setBackground(new Color(64, 0, 128, 150));
		signupPane_1.setBounds(-8, 74, 271, 103);
		signupPane.add(signupPane_1);

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(255, 255, 255, 0));
		titleBar.setBounds(0, 0, 813, 23);
		panel.add(titleBar);

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

		JLabel lblDay_1 = new JLabel("Year");
		lblDay_1.setBounds(627, 162, 117, 23);
		panel.add(lblDay_1);
		lblDay_1.setIconTextGap(6);
		lblDay_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDay_1.setForeground(new Color(192, 192, 192));
		lblDay_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		civilLabel = new JLabel("");
		civilLabel.setBounds(705, 123, 20, 20);
		panel.add(civilLabel);
		civilLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		civilLabel.setVisible(false);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(373, 162, 117, 23);
		panel.add(lblMonth);
		lblMonth.setIconTextGap(6);
		lblMonth.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonth.setForeground(new Color(192, 192, 192));
		lblMonth.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		emailField = new RoundedTextField(10);
		emailField.setBounds(373, 394, 378, 30);
		panel.add(emailField);
		emailField.setBackground(SystemColor.info);
		emailField.setMargin(new Insets(2, 7, 2, 7));
		emailField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		emailField.setForeground(new Color(255, 255, 255));

		RoundedButton nextButton = new RoundedButton("");
		nextButton.setBounds(665, 454, 92, 30);
		panel.add(nextButton);
		nextButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		nextButton.setText("Next");
		nextButton.setBorder(new EmptyBorder(0, 0, 0, 0));

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fName = firstnameField.getText();
				if (!isValidName(fName)) {
					firstNameStatusLabel.setVisible(true);
					firstNameStatusLabel.setToolTipText("Invalid first name");
					firstNameEdited = false;
				} else {
					firstNameStatusLabel.setVisible(false);
					firstNameEdited = true;
				}

				lName = lastnameField.getText();
				if (!isValidName(lName)) {
					lastNameStatusLabel.setVisible(true);
					lastNameStatusLabel.setToolTipText("Invalid last name");
					lastNameEdited = false;
				} else {
					lastNameStatusLabel.setVisible(false);
					lastNameEdited = true;
				}

				phone = phonenumberField.getText();
				if (!phone.matches("^\\d{11}$")) {
					phoneStatusLabel.setVisible(true);
					phoneStatusLabel.setToolTipText("Invalid phone number");
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
				if (!isValidEmail(email)) {
					emailStatusLabel.setVisible(true);
					emailStatusLabel.setToolTipText("Invalid email");
					emailEdited = false;
				} else {
					emailStatusLabel.setVisible(false);
					emailEdited = true;
				}

				String gender = (String) genderBox.getSelectedItem();
				if (gender.equals(null) || gender.equals(" ")) {
					genderLabel.setVisible(true);
					genderEdited = false;
					genderLabel.setToolTipText("Please select your gender");
				} else {
					genderLabel.setVisible(false);
					genderEdited = true;
					genderLabel.setToolTipText("");
				}

				String civil = (String) civilBox.getSelectedItem();
				if (civil.equals(null) || civil.equals(" ")) {
					civilLabel.setVisible(true);
					civilEdited = false;
					civilLabel.setToolTipText("Please select your civil status");
				} else {
					civilLabel.setVisible(false);
					civilEdited = true;
					civilLabel.setToolTipText("");
				}

				int ageThreshold = currentYear - 18;
				String yearString = (String) yearBox.getSelectedItem();
				int year = Integer.parseInt(yearString);
				int monthChoice = monthBox.getSelectedIndex();
				String dayString = (String) dayBox.getSelectedItem();
				int day = Integer.parseInt(dayString);

				// BALIKAN TA NI YAWA NAA PANI BUG
				if (year == currentYear && monthChoice == currentMonth && day == (currentDay)) {
					yearLabel.setVisible(true);
					monthLabel.setVisible(true);
					dayLabel.setVisible(true);
					monthEdited = true;
					yearLabel.setToolTipText(
							"<html>It looks like you entered the wrong info.<br>Please be sure to use your real birthday.</html>");

					monthLabel.setToolTipText(
							"<html>It looks like you entered the wrong info.<br>Please be sure to use your real birthday.</html>");
					dayLabel.setToolTipText(
							"<html>It looks like you entered the wrong info.<br>Please be sure to use your real birthday.</html>");
				} else {
					yearLabel.setVisible(false);
					monthLabel.setVisible(false);
					dayLabel.setVisible(false);
					yearLabel.setToolTipText("");
					yearLabel.setToolTipText("");
					yearLabel.setToolTipText("");

					if (year > ageThreshold) {
						yearEdited = false;
						yearLabel.setVisible(true);
						yearLabel.setToolTipText("We only accept individuals who are 18 years old");
					} else {
						yearEdited = true;
						yearLabel.setVisible(false);
						yearLabel.setToolTipText("");
					}

					boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

					String month = (String) monthBox.getSelectedItem();
					if (month.equals("February")) {
						if (day < 29) {
							dayEdited = true;
							selectedYear = (String) yearBox.getSelectedItem();
							dayLabel.setVisible(false);
						} else if (day == 29 && isLeapYear) {
							dayEdited = true;
							selectedYear = (String) yearBox.getSelectedItem();
							dayLabel.setVisible(false);
						} else if (day > 29 && isLeapYear) {
							dayLabel.setToolTipText("February " + year + " typically has " + 29 + " days");
							dayEdited = false;
							dayLabel.setVisible(true);
						} else {
							dayLabel.setToolTipText("February " + year + " typically has 28 days");
							dayEdited = false;
							dayLabel.setVisible(true);

						}

					} else {
						dayEdited = true;
						monthEdited = true;
						selectedYear = (String) yearBox.getSelectedItem();
						selectedMonth = (String) monthBox.getSelectedItem();
						selectedDay = (String) dayBox.getSelectedItem();
						dayLabel.setVisible(false);

					}

				}

				// System.out.println(year + " " + currentYear);
				// System.out.println(monthChoice + " " + currentMonth);
				// System.out.println(day + " " + currentDay);
				LocalDate birthDate = LocalDate.of(year, monthChoice, day);
				LocalDate currentDate = LocalDate.now();
				Period agePeriod = Period.between(birthDate, currentDate);

				int ageInt = agePeriod.getYears();
				age = String.valueOf(ageInt);

				System.out.println(selectedYear + " " + selectedMonth + " " + selectedDay);

				if (firstNameEdited && lastNameEdited && monthEdited && dayEdited && yearEdited && phoneEdited
						&& addressEdited && emailEdited && yearEdited && genderEdited && civilEdited && ageInt >= 18) {
					// if (!firstnameField.getText().isEmpty() && !lastnameField.getText().isEmpty()
					// && !phonenumberField.getText().isEmpty() && !addressField.getText().isEmpty()
					// && !emailField.getText().isEmpty() && ageInt >= 18) {

					String saveF = firstnameField.getText();
					String saveL = lastnameField.getText();
					String saveA = age;
					saveM = selectedMonth;
					saveD = selectedDay;
					saveY = selectedYear;
					String saveP = phonenumberField.getText();
					String saveAd = addressField.getText();
					String saveE = emailField.getText();

					registerInfo = new AccountInfo(saveF, saveL, gender, civil, saveA, saveM, saveD, saveY, saveP,
							saveAd, saveE);
					UserAccount createAccount = new UserAccount(registerInfo);
					createAccount.setVisible(true);
					setVisible(false);
					dispose();
				} else {

				}

			}
		});
		nextButton.setBackground(new Color(0, 0, 0));
		nextButton.setForeground(new Color(255, 255, 255));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UserAccount user = new UserAccount(registerInfo);
				user.setVisible(true);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/signup.png")));
		lblNewLabel_1.setBounds(20, 168, 319, 327);
		signupPane.add(lblNewLabel_1);

		lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(374, 373, 156, 23);
		panel.add(lblEmailAddress);
		lblEmailAddress.setIconTextGap(6);
		lblEmailAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailAddress.setForeground(new Color(192, 192, 192));
		lblEmailAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		addressField = new RoundedTextField(10);
		addressField.setBounds(373, 325, 378, 30);
		panel.add(addressField);
		addressField.setBackground(SystemColor.info);
		addressField.setMargin(new Insets(2, 7, 2, 7));
		addressField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		addressField.setForeground(new Color(255, 255, 255));

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(373, 32, 156, 23);
		panel.add(lblFirstName);
		lblFirstName.setIconTextGap(6);
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setForeground(new Color(192, 192, 192));
		lblFirstName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		lblAddress = new JLabel("Full Address");
		lblAddress.setBounds(373, 304, 156, 23);
		panel.add(lblAddress);
		lblAddress.setIconTextGap(6);
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setForeground(new Color(192, 192, 192));
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblCivilStatus = new JLabel("Civil Status");
		lblCivilStatus.setBounds(567, 98, 98, 23);
		panel.add(lblCivilStatus);
		lblCivilStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblCivilStatus.setForeground(new Color(192, 192, 192));
		lblCivilStatus.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		firstNameStatusLabel = new JLabel("");
		firstNameStatusLabel.setBounds(533, 57, 20, 20);
		panel.add(firstNameStatusLabel);
		firstNameStatusLabel.setVisible(false);
		firstNameStatusLabel.setVerifyInputWhenFocusTarget(false);
		firstNameStatusLabel.setBackground(new Color(255, 255, 255));
		firstNameStatusLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		firstNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(567, 32, 156, 23);
		panel.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setForeground(new Color(192, 192, 192));
		lblLastName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(372, 233, 156, 23);
		panel.add(lblPhoneNumber);
		lblPhoneNumber.setIconTextGap(6);
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setForeground(new Color(192, 192, 192));
		lblPhoneNumber.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		genderLabel = new JLabel("");
		genderLabel.setBounds(513, 123, 20, 20);
		panel.add(genderLabel);
		genderLabel.setVisible(false);
		genderLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));

		lastNameStatusLabel = new JLabel("");
		lastNameStatusLabel.setBounds(727, 57, 20, 20);
		panel.add(lastNameStatusLabel);
		lastNameStatusLabel.setVisible(false);
		lastNameStatusLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		lastNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		rndbtnClearAll = new PHPay.RoundedButton("");
		rndbtnClearAll.setBounds(371, 454, 69, 30);
		panel.add(rndbtnClearAll);
		rndbtnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnameField.setText("");
				lastnameField.setText("");
				phonenumberField.setText("");
				addressField.setText("");
				emailField.setText("");

			}
		});
		rndbtnClearAll.setText("Clear All");
		rndbtnClearAll.setForeground(Color.WHITE);
		rndbtnClearAll.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		rndbtnClearAll.setBorder(new EmptyBorder(0, 0, 0, 0));
		rndbtnClearAll.setBackground(Color.BLACK);

		phonenumberField = new RoundedTextField(10);
		phonenumberField.setBounds(373, 256, 378, 30);
		panel.add(phonenumberField);
		phonenumberField.setBackground(SystemColor.info);
		phonenumberField.setMargin(new Insets(2, 7, 2, 7));
		phonenumberField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		phonenumberField.setForeground(new Color(255, 255, 255));
// yearBox.setSelectedIndex(currentYear);

		firstnameField = new RoundedTextField(10);
		firstnameField.setBounds(373, 52, 184, 30);
		panel.add(firstnameField);
		firstnameField.setBackground(SystemColor.info);
		firstnameField.setMargin(new Insets(2, 7, 2, 7));
		firstnameField.setToolTipText("");
		firstnameField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		firstnameField.setForeground(new Color(255, 255, 255));

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(526, 162, 98, 23);
		panel.add(lblDay);
		lblDay.setIconTextGap(6);
		lblDay.setHorizontalAlignment(SwingConstants.LEFT);
		lblDay.setForeground(new Color(192, 192, 192));
		lblDay.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		JLabel lblPhoneNumber_1 = new JLabel("Gender");
		lblPhoneNumber_1.setBounds(373, 98, 69, 23);
		panel.add(lblPhoneNumber_1);
		lblPhoneNumber_1.setIconTextGap(6);
		lblPhoneNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber_1.setForeground(new Color(192, 192, 192));
		lblPhoneNumber_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		phoneStatusLabel = new JLabel("");
		phoneStatusLabel.setBounds(727, 261, 20, 20);
		panel.add(phoneStatusLabel);
		phoneStatusLabel.setVisible(false);
		phoneStatusLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		phoneStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		lastnameField = new RoundedTextField(10);
		lastnameField.setBounds(567, 52, 184, 30);
		panel.add(lastnameField);
		lastnameField.setBackground(SystemColor.info);
		lastnameField.setMargin(new Insets(2, 7, 2, 7));
		lastnameField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lastnameField.setForeground(new Color(255, 255, 255));

		emailStatusLabel = new JLabel("");
		emailStatusLabel.setBounds(726, 399, 20, 20);
		panel.add(emailStatusLabel);
		emailStatusLabel.setVisible(false);
		emailStatusLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		emailStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		civilLabel = new JLabel("");
		civilLabel.setBounds(705, 123, 20, 20);
		panel.add(civilLabel);
		civilLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));
		civilLabel.setVisible(false);

		genderLabel = new JLabel("");
		genderLabel.setBounds(513, 123, 20, 20);
		panel.add(genderLabel);
		genderLabel.setVisible(false);
		genderLabel.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/warning.png")));

//		FlatDarkLaf.setup();

		civilBox = new RoundedComboBox<String>(civil);
		civilBox.setBounds(567, 118, 184, 30);
		panel.add(civilBox);
		civilBox.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				if (civilBox.getItemCount() >= 5) {
					civilBox.removeItemAt(4);
				}
				civilBox.setSelectedItem("Single");

			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				// You can handle any actions when the dropdown becomes invisible here if needed
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// You can handle any actions when the dropdown is canceled here if needed
			}
		});
		civilBox.setMaximumRowCount(4);
		civilBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Single", "Married", "Widowed", "Divorced", " " }));
		civilBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		civilBox.setForeground(new Color(255, 255, 255));
		civilBox.setBackground(new Color(27, 0, 53));
		civilBox.setSelectedItem(" ");

		genderBox = new RoundedComboBox<String>(gender);
		genderBox.setBounds(373, 118, 184, 30);
		panel.add(genderBox);
		genderBox.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				if (genderBox.getItemCount() >= 4) {
					genderBox.removeItemAt(3);
				}
				genderBox.setSelectedItem("Male");

			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				// You can handle any actions when the dropdown becomes invisible here if needed
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// You can handle any actions when the dropdown is canceled here if needed
			}
		});
		genderBox.setMaximumRowCount(3);
		genderBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female", "Other", " " }));
		genderBox.setForeground(new Color(255, 255, 255));
		genderBox.setBackground(new Color(27, 0, 53));
		genderBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		genderBox.setSelectedItem(" ");
		civilLabel.setVisible(false);

		monthBox = new RoundedComboBox<>(months);
		monthBox.setMaximumRowCount(6);
		monthBox.setBounds(373, 184, 140, 30);
		panel.add(monthBox);
		monthBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		monthBox.setBackground(new Color(27, 0, 53));
		monthBox.setForeground(new Color(255, 255, 255));
		monthBox.setSelectedIndex(currentMonth);
		monthBox.setUI(new CustomComboBoxUI());

		dayBox = new RoundedComboBox<>(days);
		dayBox.setBounds(526, 184, 87, 30);
		panel.add(dayBox);
		dayBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		dayBox.setBackground(new Color(27, 0, 53));
		dayBox.setForeground(new Color(255, 255, 255));
		dayBox.setMaximumRowCount(6);
		dayBox.setSelectedIndex(currentDay - 1);
		dayBox.setUI(new CustomComboBoxUI());

		yearBox = new JComboBox<>(years);
		yearBox.setBounds(627, 184, 124, 30);
		panel.add(yearBox);
		yearBox.setForeground(new Color(255, 255, 255));
		yearBox.setBackground(new Color(27, 0, 53));
		yearBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		yearBox.setMaximumRowCount(6);
		yearBox.setUI(new CustomComboBoxUI());

		firstnameField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				set();
			}

			public void set() {
				firstNameStatusLabel.setVisible(false);

			}
		});

		lastnameField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				set();
			}

			public void set() {
				lastNameStatusLabel.setVisible(false);

			}
		});

		phonenumberField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				set();
			}

			public void set() {
				phoneStatusLabel.setVisible(false);

			}
		});

		addressField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				set();
			}

			public void set() {
				addressStatusLabel.setVisible(false);

			}
		});

		emailField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				set();
			}

			public void set() {
				emailStatusLabel.setVisible(false);

			}
		});

	}

	public class CustomComboBoxUI extends BasicComboBoxUI {
		@Override
		protected JButton createArrowButton() {
			return new JButton() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public int getWidth() {
					return 0; // Remove the arrow button by making it have no width
				}
			};
		}

		@Override
		protected ComboPopup createPopup() {
			return new BasicComboPopup(comboBox) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected JScrollPane createScroller() {
					// Create a custom JScrollPane with scrollbars set to "NEVER"
					JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
							JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					scroller.getViewport().setBackground(comboBox.getBackground());

					// Add a MouseWheelListener to enable slower scrolling
					scroller.addMouseWheelListener(new MouseWheelListener() {
						@Override
						public void mouseWheelMoved(MouseWheelEvent e) {
							JScrollBar verticalScrollBar = scroller.getVerticalScrollBar();
							int units = e.getUnitsToScroll();
							int extent = verticalScrollBar.getBlockIncrement(1) / 5; // Adjust this value for slower
																						// scrolling
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
			comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Customize the border here
		}
	}

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

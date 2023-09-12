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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Reg extends JDialog {

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

	public Reg(JPanel blurPanel, JLabel logo) {
		this.blurPanel = blurPanel;
		this.logo = logo;
		setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 12));
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Reg.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		getContentPane().setForeground(Color.WHITE);
		setForeground(new Color(255, 255, 255));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 426) / 2;
		int centerY = (screenHeight - 446) / 2;
		setLocation(centerX, centerY);
		setSize(426, 446);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(0, 0, 0, 255));
		getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				blurPanel.setVisible(false);
				logo.setVisible(true);
			}
		});

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(new Color(0, 0, 0, 10));
		panel.setBounds(0, 0, 426, 469);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton nextButton = new JButton("Next");

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(selectedDay + "" + selectedYear);

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
					phoneStatusLabel.setVisible(true);
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

				int birthMonth = 0, birthDay = 0, birthYear = 0;
				String[] months = { " Month", "January", "February", "March", "April", "May", "June", "July", "August",
						"September", "October", "November", "December" };

				for (int i = 0; i < months.length; i++) {
					if (months[i].equals(selectedMonth)) {
						birthMonth = i;
						break;
					}
				}

				if (birthMonth > 0) {
					monthEdited = true;
					monthLabel.setVisible(false);
				} else {
					monthLabel.setVisible(true);
					monthLabel.setToolTipText("Please select your birth month");
					return;
				}

				int year = Integer.parseInt(selectedYear);

				boolean isLeapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

				int selectedDayInt = Integer.parseInt(selectedDay);

				if (selectedMonth == "February") {

					if (selectedDayInt >= 29) {
						if (selectedDayInt == 29) {
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

		yearLabel = new JLabel("");
		yearLabel.setVisible(false);

		dayLabel = new JLabel("");
		dayLabel.setVisible(false);
		dayLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		dayLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		dayLabel.setBounds(232, 354, 20, 20);
		panel.add(dayLabel);
		yearLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		yearLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		yearLabel.setBounds(355, 354, 20, 20);
		panel.add(yearLabel);
		nextButton.setBackground(new Color(0, 0, 0));
		nextButton.setForeground(new Color(0, 0, 0));
		nextButton.setBounds(144, 395, 122, 43);
		panel.add(nextButton);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 4, 158, 59);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));

		RoundedPanel titlePanel = new RoundedPanel(5);
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(103, 0, 206));
		titlePanel.setBounds(10, 9, 136, 50);
		panel.add(titlePanel);

		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});
		back.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/exit.png")));
		back.setOpaque(false);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.PLAIN, 17));
		back.setBorderPainted(false);
		back.setBorder(null);
		back.setBackground(Color.WHITE);
		back.setBounds(392, 4, 30, 33);
		panel.add(back);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 70, 507, 2);
		panel.add(panel_1);

		monthLabel = new JLabel("");
		monthLabel.setVisible(false);
		monthLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		monthLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		monthLabel.setBounds(120, 354, 20, 20);
		panel.add(monthLabel);

		firstNameStatusLabel = new JLabel("");
		firstNameStatusLabel.setVerifyInputWhenFocusTarget(false);
		firstNameStatusLabel.setBackground(new Color(255, 255, 255));
		firstNameStatusLabel.setVisible(false);
		firstNameStatusLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		firstNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		firstNameStatusLabel.setBounds(183, 102, 20, 20);
		panel.add(firstNameStatusLabel);

		lastNameStatusLabel = new JLabel("");
		lastNameStatusLabel.setVisible(false);
		lastNameStatusLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		lastNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		lastNameStatusLabel.setBounds(377, 102, 20, 20);
		panel.add(lastNameStatusLabel);

		phoneStatusLabel = new JLabel("");
		phoneStatusLabel.setVisible(false);
		phoneStatusLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		phoneStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		phoneStatusLabel.setBounds(377, 165, 20, 20);
		panel.add(phoneStatusLabel);

		addressStatusLabel = new JLabel("");
		addressStatusLabel.setVisible(false);
		addressStatusLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		addressStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		addressStatusLabel.setBounds(377, 228, 20, 20);
		panel.add(addressStatusLabel);

		firstNameField = new RoundedTextField(10);
		firstNameField.setToolTipText("");
		firstNameField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		firstNameField.setText("  First Name");
		firstNameField.setBounds(23, 97, 184, 30);
		firstNameField.setForeground(Color.GRAY);
		firstNameField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if (firstNameField.getText().equals("  First Name")) {
					firstNameField.setText("");
					firstNameField.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (firstNameField.getText().isEmpty()) {
					firstNameField.setText("  First Name");
					firstNameField.setForeground(Color.GRAY);
				} else {
					firstNameEdited = true;
				}
			}
		});
		panel.add(firstNameField);

		lastNameField = new RoundedTextField(10);
		lastNameField.setText("  Last Name");
		lastNameField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		lastNameField.setBounds(217, 97, 184, 30);
		lastNameField.setForeground(Color.GRAY);
		lastNameField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (lastNameField.getText().equals("  Last Name")) {
					lastNameField.setText("");
					lastNameField.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (lastNameField.getText().isEmpty()) {
					lastNameField.setText("  Last Name");
					lastNameField.setForeground(Color.GRAY);
				} else {
					lastNameEdited = true;
				}
			}
		});
		panel.add(lastNameField);

		phonenumberField = new RoundedTextField(10);
		phonenumberField.setText("  Phone Number");
		phonenumberField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		phonenumberField.setBounds(23, 160, 378, 30);
		phonenumberField.setForeground(Color.GRAY);
		phonenumberField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (phonenumberField.getText().equals("  Phone Number")) {
					phonenumberField.setText("");
					phonenumberField.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (phonenumberField.getText().isEmpty()) {
					phonenumberField.setText("  Phone Number");
					phonenumberField.setForeground(Color.GRAY);
				} else {
					phoneEdited = true;
				}
			}
		});
		panel.add(phonenumberField);

		addressField = new RoundedTextField(10);
		addressField.setText("  Address");
		addressField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		addressField.setBounds(23, 223, 378, 30);
		addressField.setForeground(Color.GRAY);
		addressField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (addressField.getText().equals("  Address")) {
					addressField.setText("");
					addressField.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (addressField.getText().isEmpty()) {
					addressField.setText("  Address");
					addressField.setForeground(Color.GRAY);
				} else {
					addressEdited = true;

				}
			}
		});
		panel.add(addressField);

		JTextField textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);

		String[] months = { " Month", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		RoundedComboBox<String> monthBox = new RoundedComboBox<>(months);
		monthBox.setBounds(23, 349, 140, 30);
		monthBox.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		monthBox.setBackground(new Color(0, 0, 0, 1));
		monthBox.setForeground(new Color(255, 255, 255));
		panel.add(monthBox);
		monthBox.setMaximumRowCount(4);
		monthBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMonth = (String) monthBox.getSelectedItem();
			}
		});
		monthBox.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				monthBox.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent e) {
				monthBox.setBackground(new Color(0, 0, 0));
			}
		});

		String[] days = new String[32];
		days[0] = " Day";
		for (int i = 1; i <= 31; i++) {
			days[i] = String.valueOf(i);
		}
		JComboBox<String> dayBox = new JComboBox<>(days);
		dayBox.setBounds(173, 349, 101, 30);
		dayBox.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		dayBox.setBackground(new Color(0, 0, 0, 1));
		dayBox.setForeground(new Color(255, 255, 255));
		panel.add(dayBox);
		dayBox.setMaximumRowCount(4);

		dayBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDay = (String) dayBox.getSelectedItem();
			}
		});

		dayBox.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				dayBox.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent e) {
				dayBox.setBackground(new Color(0, 0, 0));
			}
		});

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String[] years = new String[106];
		years[0] = " Year";
		for (int i = 1; i <= 105; i++) {
			years[i] = String.valueOf(currentYear - 17 - i);
		}

		yearBox = new JComboBox<>(years);
		yearBox.setForeground(new Color(255, 255, 255));
		yearBox.setBackground(new Color(0, 0, 0, 1));
		yearBox.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		yearBox.setBounds(284, 349, 113, 30);
		panel.add(yearBox);
		yearBox.setMaximumRowCount(4);
		yearBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedYear = (String) yearBox.getSelectedItem();

				if (selectedYear.equals(" Year")) {
					return;
				}
			}
		});

		yearBox.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				yearBox.setBackground(new Color(0, 0, 0));
			}

			@Override
			public void focusLost(FocusEvent e) {
				yearBox.setBackground(new Color(0, 0, 0));
			}
		});

		emailStatusLabel = new JLabel("");
		emailStatusLabel.setVisible(false);
		emailStatusLabel.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/warning.png")));
		emailStatusLabel.setBounds(377, 291, 20, 20);
		panel.add(emailStatusLabel);
		emailStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		emailField = new RoundedTextField(10);
		emailField.setText("  Email Address");
		emailField.setBounds(23, 286, 378, 30);
		panel.add(emailField);
		emailField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		emailField.setForeground(Color.GRAY);

		JLabel background = new JLabel("New label");
		background.setBackground(new Color(255, 255, 255, 10));
		background.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/Background-02.png")));
		background.setBounds(0, 0, 444, 455);
		panel.add(background);
		background.setEnabled(true);

		emailField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (emailField.getText().equals("  Email Address")) {
					emailField.setText("");
					emailField.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (emailField.getText().isEmpty()) {
					emailField.setText("  Email Address");
					emailField.setForeground(Color.GRAY);
				} else if (!emailField.getText().isEmpty() && !emailField.getText().equals("Email")) {
					emailEdited = true;
					if (!isValidEmail(emailField.getText())) {
						emailStatusLabel.setText("Invalid email");
						emailStatusLabel.setForeground(Color.RED);
					}
				}
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
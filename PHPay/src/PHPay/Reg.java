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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private String FName, lName, ageStr, phone, address, saveM, saveD, saveY;
	private int year, x, y;
	private JLabel proceedButton;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JPanel blurPanel;
	private JComboBox<String> yearBox;

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

	public Reg(JPanel blurPanel) {
		this.blurPanel = blurPanel;
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
		int centerX = (screenWidth - 395) / 2;
		int centerY = (screenHeight - 405) / 2;
		setLocation(centerX, centerY);
		setSize(395, 430);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(0, 0, 0, 180));
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
			}
		});

		GradientPanel panel = new GradientPanel(new Color(255, 255, 255), new Color(255, 255, 255));
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 395, 442);
		getContentPane().add(panel);
		panel.setLayout(null);

		proceedButton = new JLabel(">");
		proceedButton.setToolTipText("Proceed");
		proceedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int birthMonth = 0, birthDay, birthYear;

				String[] months = { "Month", "January", "February", "March", "April", "May", "June", "July", "August",
						"September", "October", "November", "December" };

				for (int i = 0; i < months.length; i++) {
					if (months[i].equals(selectedMonth)) {
						birthMonth = i;
						break;
					}
				}

				if (birthMonth > 0) {
					monthEdited = true;
					monthLabel.setForeground(Color.BLACK);
				} else {
					monthLabel.setForeground(Color.RED);
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
								return; 
							} else {
								selectedYear = (String) yearBox.getSelectedItem();
								dayEdited = true;
							}
						} else {
							dayEdited = false;
							return;
						}
					} else {
						dayEdited = true;
						selectedYear = (String) yearBox.getSelectedItem();
					}
				} 

				if (!selectedDay.equals("Day")) {
					birthDay = Integer.parseInt(selectedDay);
					dayLabel.setForeground(Color.BLACK);
					dayEdited = true;
				} else {
					dayLabel.setForeground(Color.RED);
					return;
				}
				if (!selectedYear.equals("Year")) {
					birthYear = Integer.parseInt(selectedYear);
					yearLabel.setForeground(Color.BLACK);
					yearEdited = true;
				} else {
					yearLabel.setForeground(Color.RED);
					return;
				}

				LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
				LocalDate currentDate = LocalDate.now();
				Period agePeriod = Period.between(birthDate, currentDate);

				int ageInt = agePeriod.getYears();
				age = String.valueOf(ageInt);

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

		proceedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				FName = firstNameField.getText();
				if (!isValidName(FName)) {
					firstNameStatusLabel.setText("Invalid name");
					firstNameStatusLabel.setForeground(Color.RED);
					firstNameEdited = false;
				} else if (firstNameField.getText().equals(" First Name")) {
					firstNameStatusLabel.setText("Invalid name");
					firstNameStatusLabel.setForeground(Color.RED);
					firstNameEdited = false;
				} else {
					firstNameStatusLabel.setText("");
					firstNameEdited = true;
				}

				lName = lastNameField.getText();
				if (!isValidName(lName)) {
					lastNameStatusLabel.setText("Invalid name");
					lastNameStatusLabel.setForeground(Color.RED);
					lastNameEdited = false;
				} else if (lastNameField.getText().equals(" Last Name")) {
					lastNameStatusLabel.setText("Invalid name");
					lastNameStatusLabel.setForeground(Color.RED);
					lastNameEdited = false;
				} else {
					lastNameStatusLabel.setText("");
					lastNameEdited = true;
				}

				phone = phonenumberField.getText();
				if (phone.isEmpty()) {
					phoneStatusLabel.setText("Input is empty");
					phoneStatusLabel.setForeground(Color.RED);
					phoneEdited = false;
				} else if (!phone.matches("^\\d{11}$")) {
					phoneStatusLabel.setText("Invalid phone number");
					phoneStatusLabel.setForeground(Color.RED);
					phoneEdited = false;
				} else if (!(phone.length() == 11)) {
					phoneStatusLabel.setText("Phone number length is invalid");
					phoneStatusLabel.setForeground(Color.RED);
					phoneEdited = false;
				} else {
					phoneStatusLabel.setText("");
					phoneEdited = true;
				}

				address = addressField.getText();
				if (address.isEmpty()) {
					addressStatusLabel.setText("Invalid address");
					addressStatusLabel.setForeground(Color.RED);
					addressEdited = false;
				} else if (addressField.getText().equals("  Address")) {
					addressStatusLabel.setText("Invalid address");
					addressStatusLabel.setForeground(Color.RED);
					addressEdited = false;
				} else if (address.matches("^\\s+$")) {
					addressStatusLabel.setText("Invalid address");
					addressStatusLabel.setForeground(Color.RED);
					addressEdited = false;
				} else if (address.length() <= 3) {
					addressStatusLabel.setText("Fill your full address");
					addressStatusLabel.setForeground(Color.RED);
					addressEdited = false;
				} else {
					addressStatusLabel.setText("");
					addressEdited = true;
				}

				String email = emailField.getText();
				if (!isValidEmail(email)) {
					emailStatusLabel.setText("Invalid email");
					emailStatusLabel.setForeground(Color.RED);
					emailEdited = false;
				} else {
					emailStatusLabel.setText("");
					emailEdited = true;
				}

			}

		});

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
		back.setBounds(365, 0, 30, 33);
		panel.add(back);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 70, 395, 2);
		panel.add(panel_1);

		monthLabel = new JLabel("mont");
		monthLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		monthLabel.setBounds(23, 326, 20, 20);
		panel.add(monthLabel);

		dayLabel = new JLabel("dd");
		dayLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		dayLabel.setBounds(189, 326, 20, 20);
		panel.add(dayLabel);

		proceedButton.setHorizontalAlignment(SwingConstants.CENTER);
		proceedButton.setForeground(Color.WHITE);
		proceedButton.setFont(new Font("Tahoma", Font.BOLD, 32));
		proceedButton.setBounds(337, 363, 48, 45);
		panel.add(proceedButton);

		firstNameStatusLabel = new JLabel("fn");
		firstNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		firstNameStatusLabel.setBounds(159, 95, 20, 20);
		panel.add(firstNameStatusLabel);

		lastNameStatusLabel = new JLabel("ln");
		lastNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		lastNameStatusLabel.setBounds(337, 95, 20, 20);
		panel.add(lastNameStatusLabel);

		phoneStatusLabel = new JLabel("pn");
		phoneStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		phoneStatusLabel.setBounds(337, 145, 20, 20);
		panel.add(phoneStatusLabel);

		addressStatusLabel = new JLabel("addr");
		addressStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		addressStatusLabel.setBounds(337, 195, 20, 20);
		panel.add(addressStatusLabel);

		yearLabel = new JLabel("yy");
		yearLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		yearLabel.setBounds(268, 326, 20, 20);
		panel.add(yearLabel);

		firstNameField = new RoundedTextField(10);
		firstNameField.setToolTipText("");
		firstNameField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		firstNameField.setText("  First Name");
		firstNameField.setBounds(23, 90, 160, 30);
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
		lastNameField.setBounds(209, 90, 160, 30);
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
		phonenumberField.setBounds(23, 140, 346, 30);
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
		addressField.setBounds(23, 190, 346, 30);
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
		monthBox.setBounds(23, 290, 156, 30);
		monthBox.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		monthBox.setBackground(new Color(0, 0, 0, 1));
		monthBox.setForeground(new Color(255, 255, 255));
		panel.add(monthBox);
		monthBox.setMaximumRowCount(4);
		monthBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveM = selectedMonth;
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
				monthBox.setBackground(new Color(0, 0, 0, 1));
			}
		});

		String[] days = new String[32];
		days[0] = " Day";
		for (int i = 1; i <= 31; i++) {
			days[i] = String.valueOf(i);
		}
		JComboBox<String> dayBox = new JComboBox<>(days);
		dayBox.setBounds(189, 290, 70, 30);
		dayBox.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		dayBox.setBackground(new Color(0, 0, 0, 1));
		dayBox.setForeground(new Color(255, 255, 255));
		panel.add(dayBox);
		dayBox.setMaximumRowCount(4);

		dayBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveD = selectedDay;
				selectedDay = (String) dayBox.getSelectedItem();

				if (" Day".equals(selectedDay)) {
					dayBox.setForeground(Color.RED);
				} else {
					dayBox.setForeground(Color.WHITE);
				}
			}
		});

		dayBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveD = selectedDay; // save previous value
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
				dayBox.setBackground(new Color(0, 0, 0, 1));
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
		yearBox.setBounds(268, 290, 101, 30);
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
				yearBox.setBackground(new Color(0, 0, 0, 1));
			}
		});

		emailStatusLabel = new JLabel("em");
		emailStatusLabel.setBounds(337, 245, 20, 20);
		panel.add(emailStatusLabel);
		emailStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));

		emailField = new RoundedTextField(10);
		emailField.setText("  Email Address");
		emailField.setBounds(23, 240, 346, 30);
		panel.add(emailField);
		emailField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		emailField.setForeground(Color.GRAY);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Reg.class.getResource("/PHPay/phpimg/Background-02.png")));
		lblNewLabel_1.setBounds(0, 0, 395, 431);
		panel.add(lblNewLabel_1);
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
		return FName;
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
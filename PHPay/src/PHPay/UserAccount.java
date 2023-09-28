package PHPay;

import java.awt.geom.RoundRectangle2D;
import java.util.HashSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Insets;
import PHPay.RandomID.RandomIdGenerator;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class UserAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private int x, y;
	private HashSet<Integer> usedIds;
	private Random random;
	private static String passCheck, confirmPassCheck, passkey;
	boolean def1 = true;
	boolean def2 = true;
	ImageIcon see = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/see1.png"));
	ImageIcon blind = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/blind2.png"));
	RoundedTextField userField;
	RoundedPasswordField passField, confirmPassField;
	RoundedCheckBox agreeBox;

	boolean userEdited = false;
	boolean passEdited = false;
	boolean confirmPassEdited = false;
	boolean agreeEdited = false;

	private JLabel userLabel, passLabel, confirmPassLabel;

	public UserAccount(AccountInfo account) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(UserAccount.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setBackground(new Color(255, 255, 255));
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255, 0));
		getContentPane().setLayout(null);
		setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 811) / 2;
		int centerY = (screenHeight - 512) / 2;
		setLocation(centerX, centerY);
		setSize(811, 512);
		setUndecorated(true);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

		GradientPanel panel = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		panel.setBounds(0, 0, 811, 512);
		getContentPane().add(panel);
		panel.setLayout(null);

		GradientPanel hidePane = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		hidePane.setBounds(0, 24, 492, 488);
		hidePane.setVisible(false);
		panel.add(hidePane);
		hidePane.setLayout(null);

		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1.setForeground(Color.LIGHT_GRAY);
		lblUsername_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblUsername_1.setBounds(103, 211, 75, 23);
		hidePane.add(lblUsername_1);

		JLabel lblUsername_1_1 = new JLabel("Account Information");
		lblUsername_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername_1_1.setForeground(new Color(255, 255, 255));
		lblUsername_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblUsername_1_1.setBounds(168, 25, 156, 23);
		hidePane.add(lblUsername_1_1);

		JLabel lblUsername_1_2 = new JLabel("jack4304123");
		lblUsername_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername_1_2.setForeground(new Color(255, 255, 255));
		lblUsername_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblUsername_1_2.setBounds(252, 211, 137, 23);
		hidePane.add(lblUsername_1_2);

		JLabel lblUsername_1_3 = new JLabel("Password");
		lblUsername_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1_3.setForeground(Color.LIGHT_GRAY);
		lblUsername_1_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblUsername_1_3.setBounds(103, 257, 75, 23);
		hidePane.add(lblUsername_1_3);

		JLabel lblUsername_1_4 = new JLabel("Username");
		lblUsername_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername_1_4.setForeground(new Color(255, 255, 255));
		lblUsername_1_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblUsername_1_4.setBounds(252, 257, 137, 23);
		hidePane.add(lblUsername_1_4);

		RoundedPanel signupPane_1_1 = new RoundedPanel(20);
		signupPane_1_1.setLayout(null);
		signupPane_1_1.setBackground(new Color(64, 0, 128, 150));
		signupPane_1_1.setBounds(47, 76, 398, 103);
		hidePane.add(signupPane_1_1);

		JLabel lblUsername_1_5 = new JLabel("Passkey");
		lblUsername_1_5.setBounds(161, 11, 75, 23);
		signupPane_1_1.add(lblUsername_1_5);
		lblUsername_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername_1_5.setForeground(Color.LIGHT_GRAY);
		lblUsername_1_5.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

		JLabel lblUsername_1_6 = new JLabel(passkey);
		lblUsername_1_6.setBounds(10, 34, 378, 58);
		signupPane_1_1.add(lblUsername_1_6);
		lblUsername_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername_1_6.setForeground(new Color(255, 255, 255));
		lblUsername_1_6.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 23));

		JLabel lblUsername_1_7 = new JLabel(
				"<html>Your passkey is a critical requirement for resetting your password, so be sure to save it securely, as it will help protect your account. <html>");
		lblUsername_1_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1_7.setVerticalAlignment(SwingConstants.TOP);
		lblUsername_1_7.setForeground(new Color(128, 255, 128));
		lblUsername_1_7.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblUsername_1_7.setBounds(67, 316, 362, 85);
		hidePane.add(lblUsername_1_7);

		RoundedCheckBox rndchckbxIHaveSaved = new RoundedCheckBox("");
		rndchckbxIHaveSaved.setText("I've stored my passkey.");
		rndchckbxIHaveSaved.setSize(new Dimension(3, 3));
		rndchckbxIHaveSaved.setPreferredSize(new Dimension(33, 33));
		rndchckbxIHaveSaved.setForeground(Color.WHITE);
		rndchckbxIHaveSaved.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		rndchckbxIHaveSaved.setBackground(Color.WHITE);
		rndchckbxIHaveSaved.setBounds(159, 408, 174, 23);
		hidePane.add(rndchckbxIHaveSaved);

		JLabel lblPrivacyPolicy = new JLabel("Privacy Policy");
		lblPrivacyPolicy.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrivacyPolicy.setForeground(new Color(0, 117, 234));
		lblPrivacyPolicy.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblPrivacyPolicy.setBounds(247, 400, 85, 30);
		panel.add(lblPrivacyPolicy);

		JLabel lblTerms = new JLabel("Terms");
		lblTerms.setHorizontalAlignment(SwingConstants.LEFT);
		lblTerms.setForeground(new Color(0, 117, 234));
		lblTerms.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblTerms.setBounds(184, 400, 50, 30);
		panel.add(lblTerms);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setForeground(new Color(192, 192, 192));
		lblConfirmPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(111, 306, 156, 23);
		panel.add(lblConfirmPassword);

		JLabel newEye = new JLabel("");
		newEye.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newEye.setIcon(blind);
		newEye.setBounds(350, 266, 25, 25);
		newEye.setVisible(false);
		panel.add(newEye);

		newEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def1) {
					newEye.setIcon(see);
					passField.setEchoChar((char) 0);
					newEye.setBounds(350, 268, 25, 25);
				} else {
					newEye.setIcon(blind);
					passField.setEchoChar('•');
					newEye.setBounds(350, 266, 25, 25);
				}
				def1 = !def1;
			}
		});

		JLabel confirmEye = new JLabel("");
		confirmEye.setBounds(350, 331, 25, 25);
		confirmEye.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmEye.setIcon(blind);
		confirmEye.setVisible(false);
		panel.add(confirmEye);
		confirmEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def2) {
					confirmEye.setIcon(see);
					confirmPassField.setEchoChar((char) 0);
					confirmEye.setBounds(350, 333, 25, 25);
				} else {
					confirmEye.setIcon(blind);
					confirmPassField.setEchoChar('•');
					confirmEye.setBounds(350, 331, 25, 25);
				}
				def2 = !def2;
			}
		});

		RoundedPanel signupPane = new RoundedPanel(20);
		signupPane.setBounds(492, 0, 333, 512);
		panel.add(signupPane);
		signupPane.setBackground(new Color(64, 0, 128, 120));
		signupPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(UserAccount.class.getResource("/PHPay/phpimg/secured.png")));
		lblNewLabel_1.setBounds(-1, 158, 323, 281);
		signupPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 47));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 42, 297, 70);
		signupPane.add(lblNewLabel);

		JLabel lblCreateAnAccount = new JLabel("Account Information");
		lblCreateAnAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAnAccount.setForeground(Color.WHITE);
		lblCreateAnAccount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblCreateAnAccount.setBounds(10, 89, 297, 70);
		signupPane.add(lblCreateAnAccount);

		RoundedPanel signupPane_1 = new RoundedPanel(20);
		signupPane_1.setLayout(null);
		signupPane_1.setBackground(new Color(64, 0, 128, 150));
		signupPane_1.setBounds(58, 46, 271, 103);
		signupPane.add(signupPane_1);

		RandomIdGenerator generator = new RandomIdGenerator();
		RoundedButton confirmButton = new RoundedButton("10");
		confirmButton.setBounds(93, 446, 130, 34);
		signupPane.add(confirmButton);
		confirmButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmButton.setAlignmentY(0.0f);
		confirmButton.setIconTextGap(1);
		confirmButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		confirmButton.setText("Confirm");
		confirmButton.setVisible(false);
		confirmButton.setForeground(new Color(150, 150, 150));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proceed successful = new Proceed("Account successfully created", null);
				successful.setVisible(true);

				Timer timer = new Timer(4000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						Welcome runFrame = new Welcome();
						runFrame.setVisible(true);
					}
				});
				timer.setRepeats(false);
				timer.start();
			}

		});
		confirmButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				confirmButton.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				confirmButton.setForeground(new Color(150, 150, 150));
			}
		});

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(255, 255, 255, 0));
		titleBar.setBounds(0, 0, 813, 23);
		panel.add(titleBar);

		userField = new RoundedTextField(10);
		userField.setToolTipText("");
		userField.setMargin(new Insets(2, 7, 2, 7));
		userField.setForeground(Color.WHITE);
		userField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		userField.setBackground(SystemColor.info);
		userField.setBounds(111, 179, 264, 30);
		panel.add(userField);

		passField = new RoundedPasswordField(10);
		passField.setToolTipText("");
		passField.setMargin(new Insets(2, 7, 2, 7));
		passField.setForeground(Color.WHITE);
		passField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		passField.setBackground(SystemColor.info);
		passField.setBounds(111, 264, 269, 30);
		panel.add(passField);

		confirmPassField = new RoundedPasswordField(10);
		confirmPassField.setToolTipText("");
		confirmPassField.setMargin(new Insets(2, 7, 2, 7));
		confirmPassField.setForeground(Color.WHITE);
		confirmPassField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		confirmPassField.setBackground(SystemColor.info);
		confirmPassField.setBounds(111, 329, 269, 30);
		panel.add(confirmPassField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(new Color(192, 192, 192));
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblUsername.setBounds(111, 156, 156, 23);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(new Color(192, 192, 192));
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblPassword.setBounds(111, 241, 156, 23);
		panel.add(lblPassword);

		JLabel lbl2 = new JLabel("- Contains at least one digit");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setForeground(new Color(192, 192, 192));
		lbl2.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lbl2.setBounds(85, 62, 219, 23);
		panel.add(lbl2);

		JLabel lbl3 = new JLabel("- Is at least 8 characters long");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setForeground(new Color(192, 192, 192));
		lbl3.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lbl3.setBounds(85, 84, 219, 23);
		panel.add(lbl3);

		JLabel lbl4 = new JLabel("- Contains at least one uppercase alphabetic character");
		lbl4.setHorizontalAlignment(SwingConstants.LEFT);
		lbl4.setForeground(new Color(192, 192, 192));
		lbl4.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lbl4.setBounds(85, 105, 353, 23);
		panel.add(lbl4);

		JLabel lbl1 = new JLabel("Please verify that your password:");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lbl1.setBounds(85, 28, 219, 23);
		panel.add(lbl1);

		JLabel descLabel = new JLabel("By clicking Yes, you agree to our");
		descLabel.setHorizontalAlignment(SwingConstants.LEFT);
		descLabel.setForeground(new Color(255, 255, 255));
		descLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		descLabel.setBounds(184, 379, 201, 30);
		panel.add(descLabel);

		JLabel lblAnd = new JLabel("and");
		lblAnd.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnd.setForeground(Color.WHITE);
		lblAnd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblAnd.setBounds(222, 400, 31, 30);
		panel.add(lblAnd);

		RoundedButton nextButton = new RoundedButton("10");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ID = generator.generateId() + "";
				String user = userField.getText();
				@SuppressWarnings("deprecation")
				String pass = passField.getText();
				String confirmPass = confirmPassField.getText();

				if (isValidUser(user)) {
					userEdited = true;
					userLabel.setVisible(false);
				} else {
					userEdited = false;
					userLabel.setToolTipText("Username invalid");
					userLabel.setVisible(true);
				}

				if (isValidPass(pass)) {
					passEdited = true;
					passLabel.setVisible(false);
				} else {
					passEdited = false;
					passLabel.setToolTipText("Password Invalid");
					passLabel.setVisible(true);
				}

				if (confirmPass.isEmpty()) {
					confirmPassEdited = false;
					confirmPassLabel.setToolTipText("Password should match");
					confirmPassLabel.setVisible(true);
				} else if (!confirmPass.equals(pass)) {
					confirmPassEdited = false;
					confirmPassLabel.setToolTipText("Password should match");
					confirmPassLabel.setVisible(true);
				} else {
					confirmPassEdited = true;
					confirmPassLabel.setVisible(false);
				}

				if (agreeEdited) {
					agreeBox.setForeground(new Color(255, 255, 255));
				} else {
					agreeBox.setToolTipText("You must agree to proceed");
					agreeBox.setForeground(Color.RED);
				}

				if (userEdited && passEdited && confirmPassEdited && agreeEdited) {
					String passkey = RandomID.generatePassKey();
					String hashedPasskey = AccountVerify.passkey(passkey);
					UserData newAccount = new UserData(ID, user, pass, hashedPasskey, 0, account);

					if (newAccount.accountExist() == true) {
						System.out.println("Duplicate username");
					} else if (!pass.equals(confirmPass)) {
						System.out.println("Password should match");
					} else {

						newAccount.saveAccount();
						hidePane.setVisible(true);
						confirmButton.setVisible(true);
					}

				}
			}
		});
		nextButton.setBounds(180, 440, 130, 34);
		panel.add(nextButton);
		nextButton.setText("Next");
		nextButton.setIconTextGap(1);
		nextButton.setForeground(new Color(255, 255, 255));
		nextButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		nextButton.setAlignmentY(0.0f);

		agreeBox = new RoundedCheckBox("");
		agreeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (agreeBox.isSelected()) {
					agreeEdited = true;
					agreeBox.setForeground(new Color(255, 255, 255));
				} else {
					agreeEdited = false;
				}
			}
		});
		agreeBox.setBackground(new Color(255, 255, 255));
		agreeBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		agreeBox.setForeground(new Color(255, 255, 255));
		agreeBox.setText("Yes");
		agreeBox.setSize(new Dimension(3, 3));
		agreeBox.setPreferredSize(new Dimension(33, 33));
		agreeBox.setBounds(125, 391, 46, 23);
		panel.add(agreeBox);

		RoundedButton btnNewButton = new RoundedButton("");
		btnNewButton.setBounds(11, 24, 37, 31);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				Timer timer = new Timer(100, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SignUp run = new SignUp();
						run.setVisible(true);
					}
				});
				timer.setRepeats(false);
				timer.start();

			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBounds(10, 23, 39, 33);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBounds(11, 24, 37, 31);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setBounds(11, 24, 37, 31);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setBounds(10, 23, 39, 33);
			}
		});
		btnNewButton.setIcon(new ImageIcon(SignUp.class.getResource("/PHPay/phpimg/goback.png")));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));

		userLabel = new JLabel("");
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setIcon(new ImageIcon(UserAccount.class.getResource("/PHPay/phpimg/warning.png")));
		userLabel.setBounds(381, 179, 30, 30);
		userLabel.setVisible(false);
		panel.add(userLabel);

		passLabel = new JLabel("");
		passLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passLabel.setIcon(new ImageIcon(UserAccount.class.getResource("/PHPay/phpimg/warning.png")));
		passLabel.setBounds(381, 264, 30, 30);
		passLabel.setVisible(false);
		panel.add(passLabel);

		confirmPassLabel = new JLabel("");
		confirmPassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPassLabel.setIcon(new ImageIcon(UserAccount.class.getResource("/PHPay/phpimg/warning.png")));
		confirmPassLabel.setBounds(381, 329, 30, 30);
		confirmPassLabel.setVisible(false);
		panel.add(confirmPassLabel);

		titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

		});
		confirmButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				confirmButton.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				confirmButton.setForeground(new Color(150, 150, 150));
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

		setVisible(true);
		DocumentListener documentListener = new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				setField();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				setField();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				setField();
			}

			@SuppressWarnings("deprecation")
			public void setField() {

				passCheck = passField.getText();
				confirmPassCheck = confirmPassField.getText();

				if (passCheck.contains(" ") || passCheck.equals("Password") || passCheck.equals("")) {
					newEye.setVisible(false);
				} else {
					newEye.setVisible(true);
				}
				if (confirmPassCheck.contains(" ") || confirmPassCheck.equals("Password")
						|| confirmPassCheck.equals("")) {
					confirmEye.setVisible(false);
				} else {
					confirmEye.setVisible(true);
				}

			}
		};
		passField.getDocument().addDocumentListener(documentListener);
		confirmPassField.getDocument().addDocumentListener(documentListener);

		userField.getDocument().addDocumentListener(new DocumentListener() {
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
				userLabel.setVisible(false);

			}
		});

		passField.getDocument().addDocumentListener(new DocumentListener() {
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
				passLabel.setVisible(false);

			}
		});

		confirmPassField.getDocument().addDocumentListener(new DocumentListener() {
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
				confirmPassLabel.setVisible(false);

			}
		});

	}

	public int generateId() {
		int id = random.nextInt(100000000 - 100000 + 1) + 100000;
		while (usedIds.contains(id)) {
			id = random.nextInt(100000000 - 100000 + 1) + 100000;
		}
		usedIds.add(id);
		return id;
	}

	public static boolean isValidUser(String name) {
		String pattern = "^[a-zA-Z0-9]{4,}$";

		if (name.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPass(String pass) {
		String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

		if (pass.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

}

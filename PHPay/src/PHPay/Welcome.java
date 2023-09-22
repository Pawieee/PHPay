package PHPay;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Insets;

public class Welcome extends JFrame {

	private boolean def = true;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	// private JTextField textField_1;
	private JTextField userField;
	private JPasswordField passField;
	private JPanel focusBG, titleBar;
	private JLabel logo;
	private static String userCheck, passCheck;
	// private static double angle = 0;
	private int x, y;
	private final JButton ignoreThisVariable = new JButton("");
	PhpaySplash mainPanel;
	RoundedButton loginButton;

//	private JPanel advertisementPanel; // New advertisement panel
//	private Timer advertisementTimer; // Timer for sliding animation

	public Welcome() {

		setType(Type.POPUP);
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Welcome.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 833) / 2;
		int centerY = (screenHeight - 475) / 2;
		setLocation(centerX, centerY);
		setSize(833, 475);

		setTitle("PHPAY - Virtual Wallet");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 23, 833, 452);
		panel.setLayout(null);
		getContentPane().add(panel);

		mainPanel = new PhpaySplash();
		mainPanel.setBounds(-2, 0, 835, 452);
		panel.add(mainPanel);
		mainPanel.setLayout(null);

		JButton forgotPassword = new JButton("Forgot Password?");
		forgotPassword.setToolTipText("");
		forgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				forgotPassword.setForeground(new Color(255, 255, 255, 255));
				forgotPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				forgotPassword.setForeground(new Color(255, 255, 255, 190));
				forgotPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			}
		});
		forgotPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forgotPassword.setForeground(new Color(255, 255, 255, 190));
		forgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Timer timer = new Timer(100, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new ForgotPassword();
					}
				});
				timer.setRepeats(false);
				timer.start();
				
			}
		});

		JLabel register = new JLabel("Sign Up");
		register.setBounds(136, 385, 71, 30);
		register.setForeground(new Color(0, 0, 0));
		register.setHorizontalAlignment(SwingConstants.CENTER);
		register.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mainPanel.add(register);

		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					dispose();
					Timer timer = new Timer(100, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							Register reg = new Register();
							reg.setVisible(true);

						}
					});

					timer.setRepeats(false);
					timer.start();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Font font = register.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				register.setFont(font.deriveFont(attributes));
				register.setForeground(new Color(128, 0, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Font font = register.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
				register.setFont(font.deriveFont(attributes));
				register.setForeground(Color.BLACK);
			}
		});

		ImageIcon eye = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/see.png"));
		ImageIcon blind = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/blind.png"));

		JLabel eyeLabel = new JLabel("");
		eyeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eyeLabel.setBounds(281, 192, 25, 25);
		eyeLabel.setIcon(blind);
		eyeLabel.setVisible(false);

		eyeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def) {
					eyeLabel.setIcon(eye);
					eyeLabel.setBounds(281, 194, 25, 25);
					passField.setEchoChar((char) 0);

				} else {
					eyeLabel.setIcon(blind);
					eyeLabel.setBounds(281, 192, 25, 25);
					passField.setEchoChar('*');
				}
				def = !def;
			}
		});

		mainPanel.add(eyeLabel);
//		btnNewButton.setBounds(237, 291, 85, 21);
//		grayPanel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Sign In");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Couture", Font.PLAIN, 37));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(3, 23, 345, 89);
		mainPanel.add(lblNewLabel);

		JPanel signupPanel = new RoundedPanel(15);
		signupPanel.setBackground(new Color(255, 255, 255));
		signupPanel.setBounds(136, 388, 71, 27);
		mainPanel.add(signupPanel);

		JPanel userUnderline = new JPanel();
		userUnderline.setBounds(35, 149, 273, 1);
		mainPanel.add(userUnderline);

		JPanel border = new JPanel();
		border.setBackground(new Color(128, 128, 128, 60));
		border.setBounds(347, 36, 1, 380);
		mainPanel.add(border);

		JPanel passUnderline = new JPanel();
		passUnderline.setBounds(37, 221, 273, 1);
		mainPanel.add(passUnderline);
		forgotPassword.setBounds(116, 306, 116, 21);
		mainPanel.add(forgotPassword);
		forgotPassword.setContentAreaFilled(false); // Make the button transparent
		forgotPassword.setBorder(BorderFactory.createEmptyBorder()); // Set empty border

		JLabel experienceLabel = new JLabel("Experience the convenience of cashless transactions today");
		experienceLabel.setBackground(new Color(102, 0, 204, 225));
		experienceLabel.setForeground(new Color(153, 0, 255));
		experienceLabel.setBounds(347, 87, 488, 21);
		mainPanel.add(experienceLabel);
		experienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		experienceLabel.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));

		userField = new RoundedTextField(20);
		userField.setMargin(new Insets(2, 11, 2, 11));
		userField.setBorder(new EmptyBorder(0, 0, 0, 0));
		userField.setText("Username");
		userField.setBounds(37, 119, 273, 30);
		userField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		mainPanel.add(userField);
		userField.setForeground(Color.GRAY);

		passField = new RoundedPasswordField(20);
		passField.setMargin(new Insets(2, 11, 2, 11));
		passField.setBorder(new EmptyBorder(0, 0, 0, 0));
		passField.setBounds(37, 192, 273, 30);
		passField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		mainPanel.add(passField);
		passField.setForeground(Color.GRAY);
		passField.setText("Password");
		passField.setEchoChar((char) 0);

		textField = new JTextField("");
		textField.setBounds(71, 11, -23, 1);
		textField.setForeground(Color.GRAY);
		mainPanel.add(textField);

		loginButton = new RoundedButton("LOGIN");
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginButton.setEnabled(false);
		loginButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		loginButton.setBounds(90, 265, 168, 30);
		mainPanel.add(loginButton);
		loginButton.setBackground(new Color(0, 128, 255));
		loginButton.setForeground(new Color(0, 0, 0));

		getRootPane().setDefaultButton(loginButton);
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				userCheck = userField.getText();
				passCheck = passField.getText();
				if (accountExist(userCheck, passCheck) == true) {
					System.out.println("Login successful.");
					Home home = new Home(AccountVerify.sessionID(userCheck));
					home.setVisible(true);
					dispose();
					setVisible(false);
				} else {
					passField.setForeground(Color.RED);
					userField.setForeground(Color.RED);
				}

			}
		});
		loginButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

		JLabel dontHaveAccountYet = new JLabel("Don't have an account yet?");
		dontHaveAccountYet.setForeground(new Color(255, 255, 255));
		dontHaveAccountYet.setBounds(3, 358, 345, 30);
		dontHaveAccountYet.setHorizontalAlignment(SwingConstants.CENTER);
		dontHaveAccountYet.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		mainPanel.add(dontHaveAccountYet);

		JLabel phpayLOGO = new JLabel("");
		phpayLOGO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home("admin");
				home.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		phpayLOGO.setBackground(new Color(0, 0, 0));
		phpayLOGO.setBounds(347, 119, 488, 135);
		mainPanel.add(phpayLOGO);
		phpayLOGO.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/PHPAY-BRAND-LARGE.png")));

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/phpcard.gif")));
		logo.setBounds(347, 242, 488, 173);
		mainPanel.add(logo);

		JLabel date = new JLabel("Copyright © 2023 PHPay. All Rights Reserved.");
		date.setBounds(592, 427, 268, 19);
		mainPanel.add(date);
		date.setForeground(new Color(81, 81, 81));
		date.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 10));

//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/Background-03.png")));
//		lblNewLabel_1.setBounds(2, 0, 835, 452);
//		mainPanel.add(lblNewLabel_1);

		JButton close = new JButton("");
		close.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/exit.png")));
		close.setFont(new Font("Tahoma", Font.PLAIN, 17));
		close.setBounds(804, -1, 30, 24);

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		close.setOpaque(false);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		close.setBorderPainted(false);
		close.setForeground(new Color(255, 255, 255));
		close.setBackground(new Color(255, 255, 255));
		close.setBorder(null);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				focusBG.setBounds(804, -1, 30, 23);
				focusBG.setBackground(new Color(255, 45, 50));
				focusBG.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				focusBG.setVisible(false);
			}
		});

		titleBar = new JPanel();
		titleBar.setBounds(-1, 0, 848, 23);
		getContentPane().add(titleBar);
		titleBar.setBackground(new Color(35, 35, 35));
		titleBar.setLayout(null);
		titleBar.add(close);

		// PHPAY COLOR HEX (134, 116, 237)

		JButton minimize = new JButton("");
		minimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		minimize.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/min.png")));
		minimize.setOpaque(false);
		minimize.setForeground(Color.WHITE);
		minimize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		minimize.setBorderPainted(false);
		minimize.setBorder(null);
		minimize.setBackground(new Color(255, 255, 255));
		minimize.setBounds(773, -1, 30, 24);
		titleBar.add(minimize);

		focusBG = new JPanel();
		focusBG.setBounds(900, 3, 30, 23);
		titleBar.add(focusBG);
		ignoreThisVariable.setBounds(10, 3, -8, 19);
		titleBar.add(ignoreThisVariable);
		ignoreThisVariable.setOpaque(false);
		ignoreThisVariable.setForeground(Color.WHITE);
		ignoreThisVariable.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ignoreThisVariable.setBorderPainted(false);
		ignoreThisVariable.setBorder(null);
		ignoreThisVariable.setBackground(Color.WHITE);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(0, -14, 46, 50);
		titleBar.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON3.png")));
		lblNewLabel_3_1.setForeground(new Color(166, 69, 245));
		lblNewLabel_3_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 27));

		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				focusBG.setBounds(773, -2, 30, 24);
				focusBG.setBackground(Color.GRAY);
				focusBG.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				focusBG.setVisible(false);
			}
		});

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

		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (Arrays.equals(passField.getPassword(), "Password".toCharArray())) {
					passField.setText("");
					passField.setForeground(Color.WHITE);
					passField.setEchoChar('*');

				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passField.getPassword().length == 0 || String.valueOf(passField.getPassword()).equals("Password")) {
					passField.setText("Password");
					passField.setForeground(Color.GRAY);
					passField.setEchoChar((char) 0);
				}
			}
		});

		userField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (userField.getText().equals("Username")) {
					userField.setText("");
					userField.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText("Username");
					userField.setForeground(Color.GRAY);
				} else if (!userField.getText().isEmpty()) {
					userField.setForeground(Color.WHITE);
				}
			}
		});
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
				userCheck = userField.getText();
				passCheck = passField.getText();

				if (passCheck.contains(" ") || passCheck.equals("Password") || passCheck.equals("")) {
					eyeLabel.setVisible(false);
				} else {
					eyeLabel.setVisible(true);
				}

				if (!userCheck.isEmpty() && !passCheck.isEmpty()) {
					if (!userCheck.equals("Username") && !passCheck.equals("Password")) {
						loginButton.setForeground(new Color(255, 255, 255));
						loginButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
						loginButton.setEnabled(true);

					} else {
						loginButton.setForeground(new Color(0, 0, 0));
						loginButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
						loginButton.setEnabled(false);
					}
				} else {
					loginButton.setForeground(new Color(0, 0, 0));
					loginButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
					loginButton.setEnabled(false);
				}
			}
		};
		userField.getDocument().addDocumentListener(documentListener);
		passField.getDocument().addDocumentListener(documentListener);

	}

	public boolean accountExist(String user, String pass) {
		SQLConnection newCon = new SQLConnection();
		boolean userexist = false;
		// IF ACCOUNT USERNAME DOESN'T EXIST, RETURN FALSE
		if (AccountVerify.accountExist(user) == false) {
			return userexist;
		}
		String hashed = AccountVerify.passwordHash(pass);
		String hash = "";
		String query = "SELECT `hashed_pass` FROM `users` WHERE username = ?";
		try {
			PreparedStatement pst = newCon.getCon().prepareStatement(query);
			pst.setString(1, user);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				hash = rs.getString("hashed_pass");
			}

		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (!hash.equals(hashed)) {
			return userexist;
		}
		return true;

	}

}
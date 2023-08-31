package PHPay;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.CompoundBorder;


public class Welcome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	//private JTextField textField_1;
	private JTextField userField;
	private JPasswordField passField;
	private JPanel focusBG;
	private static String userCheck, passCheck;
	// private static double angle = 0;
	private int x, y;
	private final JButton ignoreThisVariable = new JButton("");

	private JPanel advertisementPanel; // New advertisement panel
	private Timer advertisementTimer; // Timer for sliding animation
	public Welcome() {

		setType(Type.POPUP);
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Welcome.class.getResource("/PHPay/phpimg/phpsmall.png")));
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
		panel.setBounds(0, 23, 833, 475);
		panel.setLayout(null);
		getContentPane().add(panel);

		advertisementPanel = new JPanel();
		advertisementPanel.setBounds(0, -50, 833, 50); // Initially positioned above the JFrame
		advertisementPanel.setBackground(new Color(255, 215, 0)); // Yellow background, you can customize this
		panel.add(advertisementPanel); // Add the advertisement panel to the main panel

		JLabel advertisementLabel = new JLabel("WELCOME BUGO HINAYUPAK INUTIL WAY PULOS PWEH!");
		advertisementLabel.setFont(new Font("Couture", Font.PLAIN, 19));
		advertisementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		advertisementPanel.add(advertisementLabel);

		// Set up the timer for the sliding animation
		advertisementTimer = new Timer(10, e -> {
			if (advertisementPanel.getY() < 0) {
				// Slide the advertisement panel down
				advertisementPanel.setLocation(advertisementPanel.getX(), advertisementPanel.getY() + 1);
			} else {
				// Stop the timer when the advertisement panel is fully visible
				advertisementTimer.stop();
				// Start a new timer to slide the panel up after a delay
				Timer slideUpTimer = new Timer(5000, evt -> {
					new Timer(10, e1 -> {
						if (advertisementPanel.getY() > -50) {
							// Slide the advertisement panel up
							advertisementPanel.setLocation(advertisementPanel.getX(), advertisementPanel.getY() - 1);
						} else { 
							// Stop the timer when the panel is fully hidden
							((Timer) e1.getSource()).stop();
						}
					}).start();
				});
				slideUpTimer.setRepeats(false); // Run only once
				slideUpTimer.start();
			}
		});

		// Start the sliding animation when the JFrame is visible
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				advertisementTimer.start();
			}
		});

		GradientPanel grayPanel = new GradientPanel(Color.WHITE, new Color(134, 116, 237));
		grayPanel.setBounds(-2, 0, 835, 452);
		panel.add(grayPanel);
		grayPanel.setLayout(null);

		JLabel catchPhrase = new JLabel("Transforming Transactions, Powering Possibilities!");
		catchPhrase.setBounds(0, 411, 837, 30);
		grayPanel.add(catchPhrase);
		catchPhrase.setHorizontalAlignment(SwingConstants.CENTER);
		catchPhrase.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));

		userField = new JTextField("Username");
		userField.setBounds(40, 142, 273, 30);
		userField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		grayPanel.add(userField);
		userField.setForeground(Color.GRAY);

		passField = new JPasswordField();
		passField.setBounds(40, 215, 273, 30);
		passField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		grayPanel.add(passField);
		passField.setForeground(Color.GRAY);
		passField.setText("Password");
		passField.setEchoChar((char) 0);

		textField = new JTextField("");
		textField.setBounds(71, 11, -23, 1);
		textField.setForeground(Color.GRAY);
		grayPanel.add(textField);

		JButton LoginButton = new JButton("LOGIN");
		LoginButton.setBounds(116, 289, 105, 22);
		grayPanel.add(LoginButton);
		LoginButton.setBackground(new Color(255, 255, 255));
		LoginButton.setForeground(new Color(0, 0, 0));
		getRootPane().setDefaultButton(LoginButton);
		LoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				userCheck = userField.getText();
				passCheck = passField.getText();

				if (accountExist(userCheck, passCheck) == true) {
					System.out.println("Login successful.");
					Wallet wallet = new Wallet(AccountVerify.sessionID(userCheck));
					wallet.setVisible(true);
					dispose();
					setVisible(false);
				} else {
					passField.setForeground(Color.RED);
					userField.setForeground(Color.RED);
					System.out.println("Invalid username or password.");

				}

				String username = "";
				String password = "";
				if (userField.getText().equals("Username")) {
					userField.setForeground(Color.RED);
				} else {
					userField.setForeground(Color.RED);
					if (username.equals(userField.getText())) {
						userField.setForeground(Color.BLACK);
					}
				}
				if (passField.getText().equals("Password")) {
					passField.setForeground(Color.RED);
				} else {
					passField.setForeground(Color.RED);
					if (password.equals(userField.getText())) {
						passField.setForeground(Color.BLACK);
					}
				}
			}
		});
		LoginButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));

		JLabel register = new JLabel("Register");
		register.setBounds(224, 341, 89, 30);
		register.setForeground(new Color(0, 0, 255));
		register.setHorizontalAlignment(SwingConstants.LEFT);
		register.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 13));
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		grayPanel.add(register);

		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {

					Reg reg = new Reg();
					reg.setVisible(true);

					setVisible(false);
					dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Font font = register.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				register.setFont(font.deriveFont(attributes));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Font font = register.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
				register.setFont(font.deriveFont(attributes));
			}
		});

		JLabel dontHaveAccountYet = new JLabel("Don't have an account yet?");
		dontHaveAccountYet.setBounds(58, 341, 228, 30);
		dontHaveAccountYet.setHorizontalAlignment(SwingConstants.LEFT);
		dontHaveAccountYet.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 13));
		grayPanel.add(dontHaveAccountYet);

		JLabel phpayLOGO = new JLabel("");
		phpayLOGO.setBounds(400, 82, 407, 135);
		grayPanel.add(phpayLOGO);
		phpayLOGO.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/phpay1.0.png")));

		JLabel experienceLabel = new JLabel("Experience the convenience of cashless transactions today");
		experienceLabel.setBounds(400, 204, 437, 21);
		grayPanel.add(experienceLabel);
		experienceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		experienceLabel.setFont(new Font("Bahnschrift", Font.ITALIC, 14));

		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/try.gif")));
		logo.setBounds(410, 227, 373, 173);
		grayPanel.add(logo);

		JLabel date = new JLabel("2023 v.1.0");
		date.setBounds(770, 430, 74, 19);
		grayPanel.add(date);
		date.setForeground(new Color(192, 192, 192));
		date.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

		JLabel lblNewLabel = new JLabel("Hello Ka-Paulo!");
		lblNewLabel.setFont(new Font("Couture", Font.PLAIN, 31));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 53, 273, 60);
		grayPanel.add(lblNewLabel);

		JButton btnNewButton = new JButton("HOME BUTTON (BETA)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(68, 377, 204, 23);
		grayPanel.add(btnNewButton);

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

		JPanel titleBar = new JPanel();
		titleBar.setBounds(-1, 0, 848, 23);
		getContentPane().add(titleBar);
		titleBar.setBackground(new Color(35, 35, 35));
		titleBar.setLayout(null);
		titleBar.add(close);

		// PHPAY COLOR HEX (134, 116, 237)

		JButton minimize = new JButton("");
		minimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED); // Minimize the frame
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
		lblNewLabel_3_1.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/phpsmall.png")));
		lblNewLabel_3_1.setForeground(new Color(166, 69, 245));
		lblNewLabel_3_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 27));
		lblNewLabel_3_1.setBounds(3, 2, 46, 19);
		titleBar.add(lblNewLabel_3_1);

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

		passField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (Arrays.equals(passField.getPassword(), "Password".toCharArray())) {
					passField.setText("");
					passField.setForeground(Color.BLACK);
					passField.setEchoChar('*');
				}
			}

			@SuppressWarnings("deprecation")
			public void focusLost(FocusEvent e) {
				if (passField.getPassword().length == 0) {
					passField.setText("Password");
					passField.setForeground(Color.GRAY);
					passField.setEchoChar((char) 0);
				} else if (!passField.getText().isEmpty()) {

				}
			}
		});
		userField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (userField.getText().equals("Username")) {
					userField.setText("");
					userField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText("Username");
					userField.setForeground(Color.GRAY);
				} else if (!userField.getText().isEmpty()) {
					userField.setForeground(Color.BLACK);
				}
			}
		});

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
		String query = "SELECT `password_hash` FROM `users` WHERE username = ?";
		try {
			PreparedStatement pst = newCon.getCon().prepareStatement(query);
			pst.setString(1, user);
			ResultSet rs = pst.executeQuery();

			// IF HASHED PASS DOESN'T MEET DATABASED HASH, RETURN FALSE
			if (rs.next()) {
				hash = rs.getString("password_hash");
			}

		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (!hash.equals(hashed)) {
			return userexist;
		}
		return true;

	}
}
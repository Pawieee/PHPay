package PHPay;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Welcome extends JFrame{

	/**
	 * 
	 */
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
		
				JPanel blurPanel = new JPanel();
				blurPanel.setBackground(new Color(0, 0, 0, 160));
				blurPanel.setBounds(0, 0, 833, 475);
				getContentPane().add(blurPanel);
				blurPanel.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 23, 833, 475);
		panel.setLayout(null);
		getContentPane().add(panel);

		JButton seePassword = new JButton("");
		seePassword.setVisible(false);
		seePassword.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/eye-open.png")));
		seePassword.setBounds(280, 215, 30, 30);
		seePassword.setContentAreaFilled(false);
		seePassword.setBorder(BorderFactory.createEmptyBorder());
		panel.add(seePassword);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(-2, 0, 835, 452);
		panel.add(mainPanel);
		mainPanel.setLayout(null);

		JButton resetBtn = new JButton("Forgot Password?");
		resetBtn.setForeground(new Color(255, 255, 255));
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPass();

			}
		});

		JLabel register = new JLabel("Sign Up");
		register.setBounds(147, 385, 60, 30);
		register.setForeground(new Color(0, 0, 0));
		register.setHorizontalAlignment(SwingConstants.LEFT);
		register.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mainPanel.add(register);

		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {

					Timer timer = new Timer(50, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Register reg = new Register(blurPanel, logo);
							reg.setVisible(true);
						}
					});
					timer.setRepeats(false);
					timer.start();
					blurPanel.setVisible(true);
					logo.setVisible(false);
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
		resetBtn.setBounds(3, 306, 345, 21);
		mainPanel.add(resetBtn);
		resetBtn.setContentAreaFilled(false); // Make the button transparent
		resetBtn.setBorder(BorderFactory.createEmptyBorder()); // Set empty border

		JLabel experienceLabel = new JLabel("Experience the convenience of cashless transactions today");
		experienceLabel.setBackground(new Color(102, 0, 204, 225));
		experienceLabel.setForeground(new Color(153, 0, 255));
		experienceLabel.setBounds(388, 87, 449, 21);
		mainPanel.add(experienceLabel);
		experienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		experienceLabel.setFont(new Font("Bahnschrift", Font.ITALIC, 14));

		
		
		userField = new RoundedTextField(20);
		userField.setBorder(new EmptyBorder(0, 0, 0, 0));
		userField.setText(" Username");
		userField.setBounds(37, 119, 273, 30);
		userField.setFont(new Font("Consolas", Font.BOLD, 14));
		mainPanel.add(userField);
		userField.setForeground(Color.GRAY);

		passField = new RoundedPasswordField(20);
		passField.setBorder(new EmptyBorder(0, 0, 0, 0));
		passField.setBounds(37, 192, 273, 30);
		passField.setFont(new Font("Consolas", Font.BOLD, 14));
		mainPanel.add(passField);
		passField.setForeground(Color.GRAY);
		passField.setText(" Password");
		passField.setEchoChar((char) 0);

		textField = new JTextField("");
		textField.setBounds(71, 11, -23, 1);
		textField.setForeground(Color.GRAY);
		mainPanel.add(textField);
		

		JButton LoginButton = new RoundedButton("LOGIN");
		LoginButton.setEnabled(false);
		LoginButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		LoginButton.setBounds(122, 265, 105, 30);
		mainPanel.add(LoginButton);
		LoginButton.setBackground(new Color(0, 128, 255));
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
				if (userField.getText().equals(" Username")) {
					userField.setForeground(Color.RED);
				} else {
					userField.setForeground(Color.RED);
					if (username.equals(userField.getText())) {
						userField.setForeground(Color.WHITE);
					}
				}
				if (passField.getText().equals(" Password")) {
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

		JLabel dontHaveAccountYet = new JLabel("Don't have an account yet?");
		dontHaveAccountYet.setForeground(new Color(255, 255, 255));
		dontHaveAccountYet.setBounds(3, 358, 345, 30);
		dontHaveAccountYet.setHorizontalAlignment(SwingConstants.CENTER);
		dontHaveAccountYet.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		mainPanel.add(dontHaveAccountYet);

		JLabel phpayLOGO = new JLabel("");
		phpayLOGO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
				setVisible(false);
			}
		});
		phpayLOGO.setBackground(new Color(0, 0, 0));
		phpayLOGO.setBounds(347, 119, 490, 135);
		mainPanel.add(phpayLOGO);
		phpayLOGO.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/PHPAY-BRAND-LARGE.png")));

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/phpcard.gif")));
		logo.setBounds(347, 242, 490, 173);
		mainPanel.add(logo);

		JLabel date = new JLabel("Copyright © 2023 PHPay. All Rights Reserved.");
		date.setBounds(592, 427, 268, 19);
		mainPanel.add(date);
		date.setForeground(new Color(81, 81, 81));
		date.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 10));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/Background-03.png")));
		lblNewLabel_1.setBounds(2, 0, 835, 452);
		mainPanel.add(lblNewLabel_1);

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
				if (Arrays.equals(passField.getPassword(), " Password".toCharArray())) {
					passField.setText("");
					passField.setForeground(Color.WHITE);
					passField.setEchoChar('*');
					System.out.println("eye1");
					seePassword.setVisible(true);

				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passField.getPassword().length == 0
						|| String.valueOf(passField.getPassword()).equals(" Password")) {
					passField.setText(" Password");
					passField.setForeground(Color.GRAY);
					passField.setEchoChar((char) 0);
					System.out.println("hideeye1");
					seePassword.setVisible(false);
				}
			}
		});

		userField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (userField.getText().equals(" Username")) {
					userField.setText("");
					userField.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText(" Username");
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
				
				if (!userCheck.isEmpty() && !passCheck.isEmpty()) {
					LoginButton.setForeground(new Color(213, 10, 214));
					LoginButton.setEnabled(true);
				} else {
					LoginButton.setForeground(new Color(0, 0, 0));
					LoginButton.setEnabled(false);
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

			// IF HASHED PASS DOESN'T MEET DATABASED HASH, RETURN FALSE
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
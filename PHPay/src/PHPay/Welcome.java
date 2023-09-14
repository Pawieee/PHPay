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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

public class Welcome extends JFrame {

	/**
	 * 
	 */
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
				blurPanel.setBounds(0, 0, 835, 498);
				getContentPane().add(blurPanel);
				blurPanel.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 23, 833, 475);
		panel.setLayout(null);
		getContentPane().add(panel);

		JPanel grayPanel = new JPanel();
		grayPanel.setBounds(-2, 0, 835, 452);
		panel.add(grayPanel);
		grayPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Reset Pass");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPass();
				
			}
		});
		ImageIcon eye = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/eyetest.png"));
		ImageIcon eye2 = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/eyetes2.png"));

		JLabel eye_label = new JLabel("New label");
		eye_label.setIcon(eye);
		eye_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def) {
					eye_label.setIcon(eye2);
				} else {
					eye_label.setIcon(eye);
				}
				def = !def;
			}
		});
		eye_label.setBounds(288, 216, 25, 25);
		grayPanel.add(eye_label);
		btnNewButton.setBounds(237, 291, 85, 21);
		grayPanel.add(btnNewButton);

		JLabel experienceLabel = new JLabel("Experience the convenience of cashless transactions today");
		experienceLabel.setForeground(new Color(102, 51, 204));
		experienceLabel.setBounds(373, 81, 432, 21);
		grayPanel.add(experienceLabel);
		experienceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		experienceLabel.setFont(new Font("Bahnschrift", Font.ITALIC, 14));

		JLabel catchPhrase = new JLabel("Transforming Transactions, Powering Possibilities!");
		catchPhrase.setForeground(new Color(255, 255, 255));
		catchPhrase.setBounds(373, 400, 432, 30);
		grayPanel.add(catchPhrase);
		catchPhrase.setHorizontalAlignment(SwingConstants.CENTER);
		catchPhrase.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));

		userField = new JTextField(" Username");
		userField.setBounds(40, 142, 273, 30);
		userField.setFont(new Font("Consolas", Font.BOLD, 14));
		grayPanel.add(userField);
		userField.setForeground(Color.GRAY);

		passField = new JPasswordField();
		passField.setBounds(40, 215, 273, 30);
		passField.setFont(new Font("Consolas", Font.BOLD, 14));
		grayPanel.add(passField);
		passField.setForeground(Color.GRAY);
		passField.setText(" Password");
		passField.setEchoChar((char) 0);

		textField = new JTextField("");
		textField.setBounds(71, 11, -23, 1);
		textField.setForeground(Color.GRAY);
		grayPanel.add(textField);

		JButton LoginButton = new JButton("LOGIN");
		LoginButton.setBounds(116, 284, 105, 30);
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
				if (userField.getText().equals(" Username")) {
					userField.setForeground(Color.RED);
				} else {
					userField.setForeground(Color.RED);
					if (username.equals(userField.getText())) {
						userField.setForeground(Color.BLACK);
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

		JLabel register = new JLabel("Register");
		register.setBounds(237, 340, 60, 30);
		register.setForeground(new Color(128, 255, 128));
		register.setHorizontalAlignment(SwingConstants.LEFT);
		register.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 13));
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		grayPanel.add(register);

		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {

					Timer timer = new Timer(50, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Reg reg = new Reg(blurPanel);
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
		dontHaveAccountYet.setForeground(new Color(255, 255, 255));
		dontHaveAccountYet.setBounds(69, 340, 228, 30);
		dontHaveAccountYet.setHorizontalAlignment(SwingConstants.LEFT);
		dontHaveAccountYet.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 13));
		grayPanel.add(dontHaveAccountYet);

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
		phpayLOGO.setBounds(337, 113, 500, 135);
		grayPanel.add(phpayLOGO);
		phpayLOGO.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/PHPAY-BRAND-LARGE.png")));

		logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/phpcard.gif")));
		logo.setBounds(373, 229, 432, 173);
		grayPanel.add(logo);

		JLabel date = new JLabel("Copyright © 2023 PHPay. All Rights Reserved.");
		date.setBounds(18, 422, 268, 19);
		grayPanel.add(date);
		date.setForeground(new Color(81, 81, 81));
		date.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 10));

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Couture", Font.PLAIN, 37));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(3, 41, 341, 89);
		grayPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/Background-03.png")));
		lblNewLabel_1.setBounds(2, 0, 835, 452);
		grayPanel.add(lblNewLabel_1);

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

		passField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (Arrays.equals(passField.getPassword(), " Password".toCharArray())) {
					passField.setText("");
					passField.setForeground(Color.BLACK);
					passField.setEchoChar('*');
				}
			}

			@SuppressWarnings("deprecation")
			public void focusLost(FocusEvent e) {
				if (passField.getPassword().length == 0) {
					passField.setText(" Password");
					passField.setForeground(Color.GRAY);
					passField.setEchoChar((char) 0);
				} else if (!passField.getText().isEmpty()) {

				}
			}
		});
		userField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (userField.getText().equals(" Username")) {
					userField.setText("");
					userField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText(" Username");
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
package PHPay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
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
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import java.awt.Window.Type;
import java.awt.geom.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;

public class Welcome extends JFrame {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField userField, IDField;
	private JPasswordField passField;
	private JPanel focusBG;
	private static String idToCheck;
	private static double angle = 0;
	private int x, y;
	private final JButton ignoreThisVariable = new JButton("");

	public Welcome() {

		setType(Type.POPUP);
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Welcome.class.getResource("/phpay/phpimg/icons8-pandora-app-100.png")));
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

		GradientPanel grayPanel = new GradientPanel(Color.WHITE, new Color(134, 116, 237));
		grayPanel.setBounds(-2, 0, 835, 452);
		panel.add(grayPanel);
		grayPanel.setLayout(null);

		JLabel IDLabel = new JLabel("");
		IDLabel.setBounds(88, 162, 161, 23);
		IDLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		grayPanel.add(IDLabel);

		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setBounds(0, 47, 349, 62);
		grayPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 29));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Transforming Transactions, Powering Possibilities!");
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 411, 837, 30);
		grayPanel.add(lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));

		IDField = new JTextField("ID");
		IDField.setBounds(88, 132, 161, 30);
		IDField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		grayPanel.add(IDField);
		IDField.setForeground(Color.GRAY);

		userField = new JTextField("Username");
		userField.setBounds(40, 195, 273, 30);
		userField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		grayPanel.add(userField);
		userField.setForeground(Color.GRAY);

		passField = new JPasswordField();
		passField.setBounds(40, 246, 273, 30);
		passField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 12));
		grayPanel.add(passField);
		passField.setForeground(Color.GRAY);
		passField.setText("Password");
		passField.setEchoChar((char) 0);

		textField = new JTextField("");
		textField.setBounds(71, 11, -23, 1);
		textField.setForeground(Color.GRAY);
		grayPanel.add(textField);

		JButton checkID = new JButton("");
		checkID.setBounds(259, 141, 15, 10);
		checkID.setForeground(new Color(255, 255, 255));
		checkID.setBackground(new Color(255, 255, 255));
		grayPanel.add(checkID);
		checkID.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));

		JButton LoginButton = new JButton("LOGIN");
		LoginButton.setBounds(116, 311, 105, 22);
		grayPanel.add(LoginButton);
		LoginButton.setBackground(new Color(255, 255, 255));
		LoginButton.setForeground(new Color(0, 0, 0));
		getRootPane().setDefaultButton(LoginButton);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				idToCheck = IDField.getText();
				if (!idToCheck.equals("ID")) {
					String fileName = idToCheck + ".txt";
					File file = new File(fileName);
					if (file.exists()) {
						checkID.setBackground(Color.GREEN);
						IDLabel.setText("");
						IDLabel.setForeground(Color.BLACK);
						try {
							try {
								String filename = "ID.txt";
								FileWriter fileWriter = new FileWriter(filename);
								BufferedWriter writer = new BufferedWriter(fileWriter);
								writer.write("ID: " + idToCheck);
								writer.close();
							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
							}
							BufferedReader br = new BufferedReader(new FileReader(file));
							String line;
							String username = "";
							String password = "";
							while ((line = br.readLine()) != null) {
								if (line.startsWith("Username:")) {
									username = line.substring(line.indexOf(":") + 1).trim();
								} else if (line.startsWith("Password:")) {
									password = line.substring(line.indexOf(":") + 1).trim();
								}
							}
							br.close();

							if (username.equals(userField.getText()) && password.equals(passField.getText())) {
								System.out.println("Login successful.");
								Wallet wallet = new Wallet();
								wallet.setVisible(true);
								dispose();
								setVisible(false);

							} else {
								passField.setForeground(Color.RED);
								userField.setForeground(Color.RED);
								System.out.println("Invalid username or password.");

							}

						} catch (IOException ex) {
							ex.printStackTrace();
						}
					} else {
						IDLabel.setText("ID is not registered");
						IDLabel.setForeground(Color.RED);
						checkID.setBackground(Color.RED);
					}
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

				if (IDField.getText().equals("ID")) {
					IDField.setForeground(Color.RED);
				} else {
					IDField.setForeground(Color.BLACK);
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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(390, 81, 407, 135);
		grayPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/NEWPHPAY.png")));

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Experience the convenience of cashless transactions today");
		lblNewLabel_1_1_1_1.setBounds(400, 204, 437, 21);
		grayPanel.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Bahnschrift", Font.ITALIC, 14));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Welcome.class.getResource("/phpay/phpimg/walletBG2.png")));
		lblNewLabel_2.setBounds(418, 173, 373, 279);
		grayPanel.add(lblNewLabel_2);
		
		JLabel date = new JLabel("2023 v.1.0");
		date.setBounds(770, 430, 74, 19);
		grayPanel.add(date);
		date.setForeground(new Color(192, 192, 192));
		date.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

		JButton close = new JButton("");
		close.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/exit.png")));
		close.setFont(new Font("Tahoma", Font.PLAIN, 17));
		close.setBounds(803, -1, 30, 24);

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
				focusBG.setBounds(803, -1, 30, 23);
				focusBG.setBackground(new Color(255, 45, 50));
				focusBG.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				focusBG.setVisible(false);
			}
		});

		JPanel titleBar = new JPanel();
		titleBar.setBounds(0, 0, 833, 23);
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
		minimize.setBounds(772, -1, 30, 24);
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

		JLabel lblNewLabel_3 = new JLabel("PAY");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(25, 3, 30, 19);
		titleBar.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("PH");
		lblNewLabel_3_1.setForeground(new Color(166, 69, 245));
		lblNewLabel_3_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(8, 3, 111, 19);
		titleBar.add(lblNewLabel_3_1);

		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				focusBG.setBounds(772, -2, 30, 24);
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
		checkID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idToCheck = IDField.getText();
				if (!idToCheck.equals("ID")) {
					String fileName = idToCheck + ".txt";
					File file = new File(fileName);
					if (file.exists()) {
						System.out.println("ID exists and is registered.");
						checkID.setBackground(Color.GREEN);
					} else if (!idToCheck.equals("ID")) {
						checkID.setBackground(Color.RED);
					} else {
						System.out.println("ID is not registered.");
						checkID.setBackground(Color.RED);
					}
				}
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
		IDField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (IDField.getText().equals("ID")) {
					IDField.setText("");
					IDField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (IDField.getText().isEmpty()) {
					IDField.setText("ID");
					IDField.setForeground(Color.GRAY);
				}

			}
		});
	}
}
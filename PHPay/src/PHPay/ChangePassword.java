package PHPay;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;

	private static String username;

	private int x, y;
	private RoundedPasswordField newPasswordField, confirmPasswordField;
	private boolean def1 = true;
	private boolean def2 = true;
	ImageIcon see = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/see1.png"));
	ImageIcon blind = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/blind2.png"));

	public ChangePassword(String username) {
		ChangePassword.username = username;
		initialize();
	}

	private void initialize() {
		setTitle("PHPAY");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setUndecorated(true);
		getContentPane().setLayout(null);
		setBounds(0, 0, 427, 489);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 427) / 2;
		int centerY = (screenHeight - 489) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
		setVisible(true);

		JPanel blurPanel = new JPanel();
		blurPanel.setBackground(new Color(0, 0, 0, 160));
		blurPanel.setBounds(0, 0, 428, 489);
		getContentPane().add(blurPanel);
		blurPanel.setVisible(false);

		GradientPanel mainPane = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		mainPane.setBounds(0, 0, 428, 489);
		getContentPane().add(mainPane);
		mainPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setBounds(37, 18, 204, 46);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		mainPane.add(lblNewLabel);

		JLabel lblReq = new JLabel("Please verify that your password:");
		lblReq.setHorizontalAlignment(SwingConstants.LEFT);
		lblReq.setForeground(Color.WHITE);
		lblReq.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblReq.setBounds(37, 75, 219, 23);
		mainPane.add(lblReq);

		RoundedPanel pass1 = new RoundedPanel(20);
		pass1.setBounds(37, 208, 353, 266);
		pass1.setBackground(new Color(64, 0, 128, 50));
		mainPane.add(pass1);
		pass1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(350, 18, 40, 46);
		mainPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ForgotPassword.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON3.png")));

		JLabel passkeyLabel = new JLabel("Enter your passkey");
		passkeyLabel.setVisible(false);

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(255, 255, 255, 0));
		titleBar.setBounds(0, 0, 428, 23);
		mainPane.add(titleBar);

		JLabel lblMatch = new JLabel("Passwords must match");
		lblMatch.setVisible(false);
		lblMatch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatch.setForeground(new Color(255, 0, 0));
		lblMatch.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblMatch.setBounds(138, 26, 183, 23);
		pass1.add(lblMatch);

		JLabel newEye = new JLabel("");
		newEye.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newEye.setIcon(blind);
		newEye.setBounds(289, 63, 25, 25);
		pass1.add(newEye);
		newEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def1) {
					newEye.setIcon(see);
					newPasswordField.setEchoChar((char) 0);
					newEye.setBounds(289, 65, 25, 25);
				} else {
					newEye.setIcon(blind);
					newPasswordField.setEchoChar('•');
					newEye.setBounds(289, 63, 25, 25);
				}
				def1 = !def1;
			}
		});

		JLabel confirmeEye = new JLabel("");
		confirmeEye.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmeEye.setIcon(blind);
		confirmeEye.setBounds(289, 154, 25, 25);
		pass1.add(confirmeEye);
		confirmeEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def2) {
					confirmeEye.setIcon(see);
					confirmPasswordField.setEchoChar((char) 0);
					confirmeEye.setBounds(289, 156, 25, 25);
				} else {
					confirmeEye.setIcon(blind);
					confirmPasswordField.setEchoChar('•');
					confirmeEye.setBounds(289, 154, 25, 25);
				}
				def2 = !def2;
			}
		});

		newPasswordField = new RoundedPasswordField(10);
		newPasswordField.setMargin(new Insets(2, 7, 2, 7));
		newPasswordField.setForeground(new Color(255, 255, 255));
		newPasswordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		newPasswordField.setBounds(31, 58, 291, 34);
		pass1.add(newPasswordField);
		newPasswordField.setColumns(10);
		newPasswordField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				lblReq.setForeground(Color.WHITE);
				lblMatch.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				lblReq.setForeground(Color.WHITE);
				lblMatch.setVisible(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				lblReq.setForeground(Color.WHITE);
				lblMatch.setVisible(false);
			}

		});

		confirmPasswordField = new RoundedPasswordField(10);
		confirmPasswordField.setMargin(new Insets(2, 7, 2, 7));
		confirmPasswordField.setForeground(new Color(255, 255, 255));
		confirmPasswordField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		confirmPasswordField.setBounds(31, 149, 291, 34);
		pass1.add(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		confirmPasswordField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				lblReq.setForeground(Color.WHITE);
				lblMatch.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				lblReq.setForeground(Color.WHITE);
				lblMatch.setVisible(false);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				lblReq.setForeground(Color.WHITE);
				lblMatch.setVisible(false);
			}

		});

		JLabel lblWe_1_4 = new JLabel("New Password");
		lblWe_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_4.setForeground(new Color(192, 192, 192));
		lblWe_1_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblWe_1_4.setBounds(31, 25, 113, 23);
		pass1.add(lblWe_1_4);

		JLabel lblWe_1_4_1 = new JLabel("Re-enter Your New Password");
		lblWe_1_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_4_1.setForeground(new Color(192, 192, 192));
		lblWe_1_4_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblWe_1_4_1.setBounds(31, 117, 219, 23);
		pass1.add(lblWe_1_4_1);

		RoundedButton next = new RoundedButton("10");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String newPass = newPasswordField.getText();
				@SuppressWarnings("deprecation")
				String confirmPass = confirmPasswordField.getText();

				if (newPass.equals(confirmPass)) {

					if (isValidPass(newPass)) {
						String newPassHash = AccountVerify.passwordHash(confirmPass);
						SQLQuery.updatePass(newPassHash, username);

						blurPanel.setVisible(true);
						Proceed successful = new Proceed("Password changed successfully");
						successful.setVisible(true);

						Timer timer = new Timer(4000, new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								dispose();
								
								
								
								
							}
						});
						timer.setRepeats(false);
						timer.start();

					} else {
						lblReq.setForeground(Color.RED);
					}
				} else {
					lblMatch.setVisible(true);
				}

			}

		});
		next.setBounds(192, 205, 130, 34);
		pass1.add(next);
		next.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				next.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				next.setForeground(new Color(150, 150, 150));
			}
		});
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		next.setAlignmentY(0.0f);
		next.setIconTextGap(1);
		next.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		next.setText("Confirm");
		next.setForeground(new Color(200, 200, 200));

		JLabel cancel = new JLabel("Cancel");
		cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancel.setHorizontalAlignment(SwingConstants.LEFT);
		cancel.setForeground(new Color(128, 0, 255));
		cancel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		cancel.setBounds(38, 217, 67, 23);
		pass1.add(cancel);

		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Font font = cancel.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				cancel.setFont(font.deriveFont(attributes));
				cancel.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Font font = cancel.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
				cancel.setFont(font.deriveFont(attributes));
				cancel.setForeground(new Color(128, 0, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Welcome getBack = new Welcome();
				getBack.setVisible(true);
			}
		});

		JLabel lblWe_1_1 = new JLabel("- Contains at least one digit");
		lblWe_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_1.setForeground(new Color(192, 192, 192));
		lblWe_1_1.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_1.setBounds(37, 108, 219, 23);
		mainPane.add(lblWe_1_1);

		JLabel lblWe_1_2 = new JLabel("- Is at least 8 characters long");
		lblWe_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_2.setForeground(new Color(192, 192, 192));
		lblWe_1_2.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_2.setBounds(37, 130, 219, 23);
		mainPane.add(lblWe_1_2);

		JLabel lblWe_1_3 = new JLabel("- Contains at least one uppercase alphabetic character");
		lblWe_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_3.setForeground(new Color(192, 192, 192));
		lblWe_1_3.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_3.setBounds(37, 151, 353, 23);
		mainPane.add(lblWe_1_3);

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

	public static boolean isValidPass(String pass) {
		String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

		if (pass.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}
	
//	public static String getPassHash(String ID) {
//		SQLConnection newCon = new SQLConnection();
//		String query = "SELECT `hashed_pass` FROM `users` WHERE username = ?";
//		String hash = "";
//		try {
//			PreparedStatement pst = newCon.getCon().prepareStatement(query);
//			pst.setString(1, ID);
//			ResultSet rs = pst.executeQuery();
//
//			if (rs.next()) {
//				hash = rs.getString("hashed_pass");
//			}
//
//		} catch (SQLException ex) {
//			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return hash;
//	}

}
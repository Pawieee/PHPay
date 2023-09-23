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

import java.awt.BorderLayout;
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
import javax.swing.UIManager;
import PHPay.RandomID.RandomIdGenerator;

public class UserAccount extends JFrame {

	private int x, y;
	private HashSet<Integer> usedIds;
	private Random random;
	boolean def1 = true;
	boolean def2 = true;
	
	ImageIcon see = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/see.png"));
	ImageIcon blind = new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/blind.png"));
	RoundedPasswordField passField, confirmPassField;

	public UserAccount(AccountInfo account) {
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

		

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setForeground(new Color(192, 192, 192));
		lblConfirmPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(111, 357, 156, 23);
		panel.add(lblConfirmPassword);

		JLabel newEye = new JLabel("");
		newEye.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newEye.setIcon(blind);
		newEye.setBounds(350, 317, 25, 25);
		panel.add(newEye);
		newEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def1) {
					newEye.setIcon(see);
					passField.setEchoChar((char) 0);
					newEye.setBounds(350, 319, 25, 25);
				} else {
					newEye.setIcon(blind);
					passField.setEchoChar('*');
					newEye.setBounds(350, 317, 25, 25);
				}
				def1 = !def1;
			}
		});

		JLabel confirmEye = new JLabel("");
		confirmEye.setBounds(350, 382, 25, 25);
		confirmEye.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirmEye.setIcon(blind);
		panel.add(confirmEye);
		confirmEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (def2) {
					confirmEye.setIcon(see);
					confirmPassField.setEchoChar((char) 0);
					confirmEye.setBounds(350, 384, 25, 25);
				} else {
					confirmEye.setIcon(blind);
					confirmPassField.setEchoChar('*');
					confirmEye.setBounds(350, 382, 25, 25);
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
		RoundedButton next = new RoundedButton("10");
		next.setBounds(93, 446, 130, 34);
		signupPane.add(next);
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		next.setAlignmentY(0.0f);
		next.setIconTextGap(1);
		next.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		next.setText("Confirm");
		next.setForeground(new Color(200, 200, 200));

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(255, 255, 255, 0));
		titleBar.setBounds(0, 0, 813, 23);
		panel.add(titleBar);

		RoundedTextField userField = new RoundedTextField(10);
		userField.setToolTipText("");
		userField.setMargin(new Insets(2, 7, 2, 7));
		userField.setForeground(Color.WHITE);
		userField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		userField.setBackground(SystemColor.info);
		userField.setBounds(111, 229, 269, 30);
		panel.add(userField);

		passField = new RoundedPasswordField(10);
		passField.setToolTipText("");
		passField.setMargin(new Insets(2, 7, 2, 7));
		passField.setForeground(Color.WHITE);
		passField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		passField.setBackground(SystemColor.info);
		passField.setBounds(111, 315, 269, 30);
		panel.add(passField);

		confirmPassField = new RoundedPasswordField(10);
		confirmPassField.setToolTipText("");
		confirmPassField.setMargin(new Insets(2, 7, 2, 7));
		confirmPassField.setForeground(Color.WHITE);
		confirmPassField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		confirmPassField.setBackground(SystemColor.info);
		confirmPassField.setBounds(111, 380, 269, 30);
		panel.add(confirmPassField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(new Color(192, 192, 192));
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblUsername.setBounds(111, 206, 156, 23);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(new Color(192, 192, 192));
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblPassword.setBounds(111, 292, 156, 23);
		panel.add(lblPassword);

		JLabel lblWe_1_1 = new JLabel("- Contains at least one digit");
		lblWe_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_1.setForeground(new Color(192, 192, 192));
		lblWe_1_1.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_1.setBounds(85, 62, 219, 23);
		panel.add(lblWe_1_1);

		JLabel lblWe_1_2 = new JLabel("- Is at least 8 characters long");
		lblWe_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_2.setForeground(new Color(192, 192, 192));
		lblWe_1_2.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_2.setBounds(85, 84, 219, 23);
		panel.add(lblWe_1_2);

		JLabel lblWe_1_3 = new JLabel("- Contain any other special characters or symbols");
		lblWe_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_3.setForeground(new Color(192, 192, 192));
		lblWe_1_3.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_3.setBounds(85, 105, 353, 23);
		panel.add(lblWe_1_3);

		JLabel lblWe_1_3_1 = new JLabel("- Contains at least one uppercase alphabetic character");
		lblWe_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_3_1.setForeground(new Color(192, 192, 192));
		lblWe_1_3_1.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_3_1.setBounds(85, 128, 353, 23);
		panel.add(lblWe_1_3_1);

		JLabel lblReq = new JLabel("Please verify that your password:");
		lblReq.setHorizontalAlignment(SwingConstants.LEFT);
		lblReq.setForeground(Color.WHITE);
		lblReq.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblReq.setBounds(85, 28, 219, 23);
		panel.add(lblReq);
		
		JLabel lblWe_1_3_1_1 = new JLabel("Password Example:   imPaulo24?");
		lblWe_1_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe_1_3_1_1.setForeground(Color.LIGHT_GRAY);
		lblWe_1_3_1_1.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblWe_1_3_1_1.setBounds(111, 159, 327, 23);
		panel.add(lblWe_1_3_1_1);
		
		RoundedButton btnNewButton = new RoundedButton("");
		btnNewButton.setBounds(11, 24, 37, 31);
		panel.add(btnNewButton);
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
		btnNewButton.setIcon(new ImageIcon(Register.class.getResource("/PHPay/phpimg/goback.png")));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = generator.generateId() +"";
				String user = userField.getText();
				String pass = confirmPassField.getText();
				String passkey = RandomID.generatePassKey();
				String hashedPasskey = AccountVerify.passkey(passkey);
				
				UserData newAccount = new UserData(ID, user, pass, hashedPasskey, 0,
						account);
				if (newAccount.accountExist() == true) {
					System.out.println("Duplicate username");
					System.exit(0);
				}
				newAccount.saveAccount();
			}

		});
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
		titleBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int newX = getX() + e.getX() - x;
				int newY = getY() + e.getY() - y;

				setLocation(newX, newY);
			}
		});

		setVisible(true);

	}

	public int generateId() {
		int id = random.nextInt(100000000 - 100000 + 1) + 100000;
		while (usedIds.contains(id)) {
			id = random.nextInt(100000000 - 100000 + 1) + 100000;
		}
		usedIds.add(id);
		return id;
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

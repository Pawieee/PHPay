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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ForgotPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private RoundedTextField usernameField;
	private JTextField passkeyField;
	private int x, y;
	JLabel invalidLabel;

	public ForgotPassword() {
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

		GradientPanel mainPane = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		mainPane.setBounds(0, 0, 428, 489);
		getContentPane().add(mainPane);
		mainPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setBounds(37, 18, 204, 46);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		mainPane.add(lblNewLabel);

		RoundedPanel forgot1 = new RoundedPanel(20);
		forgot1.setBounds(37, 124, 353, 338);
		forgot1.setBackground(new Color(64, 0, 128, 50));
		mainPane.add(forgot1);
		forgot1.setLayout(null);

		JLabel passkeyLabel = new JLabel("Enter your passkey");
		passkeyLabel.setVisible(false);

		JLabel desc2 = new JLabel("username's account info");
		desc2.setVisible(false);
		desc2.setHorizontalAlignment(SwingConstants.LEFT);
		desc2.setForeground(Color.WHITE);
		desc2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		desc2.setBounds(31, 198, 264, 23);
		forgot1.add(desc2);

		JLabel desc1 = new JLabel("Your passkey should be match to your ");
		desc1.setVisible(false);
		desc1.setHorizontalAlignment(SwingConstants.LEFT);
		desc1.setForeground(Color.WHITE);
		desc1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		desc1.setBounds(31, 181, 264, 23);
		forgot1.add(desc1);
		passkeyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		passkeyLabel.setForeground(new Color(192, 192, 192));
		passkeyLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		passkeyLabel.setBounds(30, 112, 156, 23);
		forgot1.add(passkeyLabel);

		JLabel userLabel = new JLabel("Enter your username");
		userLabel.setBounds(31, 83, 156, 23);
		forgot1.add(userLabel);
		userLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userLabel.setForeground(new Color(192, 192, 192));
		userLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));

		usernameField = new RoundedTextField(10);
		usernameField.setBounds(30, 114, 292, 34);
		usernameField.setName("");
		usernameField.setMargin(new Insets(2, 7, 2, 7));
		usernameField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		usernameField.setForeground(new Color(255, 255, 255));
		forgot1.add(usernameField);
		usernameField.setColumns(10);
		usernameField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				invalidLabel.setText("");
				passkeyField.setText("");
				invalidLabel.setVisible(false);
				passkeyField.setVisible(false);
				passkeyLabel.setVisible(false);
				desc1.setVisible(false);
				desc2.setVisible(false);
				usernameField.setBounds(30, 114, 292, 34);
				userLabel.setBounds(31, 83, 156, 23);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				invalidLabel.setText("");
				passkeyField.setText("");
				invalidLabel.setVisible(false);
				passkeyField.setVisible(false);
				passkeyLabel.setVisible(false);
				desc1.setVisible(false);
				desc2.setVisible(false);
				usernameField.setBounds(30, 114, 292, 34);
				userLabel.setBounds(31, 83, 156, 23);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				invalidLabel.setText("");
				passkeyField.setText("");
				invalidLabel.setVisible(false);
				passkeyField.setVisible(false);
				passkeyLabel.setVisible(false);
				desc1.setVisible(false);
				desc2.setVisible(false);
				usernameField.setBounds(30, 114, 292, 34);
				userLabel.setBounds(31, 83, 156, 23);

			}

		});

		passkeyField = new RoundedTextField(10);
		passkeyField.setMargin(new Insets(2, 7, 2, 7));
		passkeyField.setForeground(new Color(255, 255, 255));
		passkeyField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		passkeyField.setBounds(31, 144, 291, 34);
		forgot1.add(passkeyField);
		passkeyField.setVisible(false);
		passkeyField.setColumns(10);
		passkeyField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				invalidLabel.setText("");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				invalidLabel.setText("");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				invalidLabel.setText("");
			}

		});

		RoundedButton next = new RoundedButton("OK");
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				next.setForeground(new Color(255, 255, 255));
				next.setBounds(191, 274, 132, 36);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				next.setForeground(new Color(150, 150, 150));
				next.setBounds(192, 275, 130, 34);
			}
			public void mousePressed(MouseEvent e) {
				next.setForeground(new Color(255, 255, 255));
				next.setBounds(192, 275, 130, 34);
			}
			public void mouseReleased(MouseEvent e) {
				next.setBounds(191, 274, 132, 36);
				next.setForeground(new Color(255, 255, 255));
			}
		});
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		next.setAlignmentY(0.0f);
		next.setIconTextGap(1);
		next.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		next.setText("Next");
		next.setForeground(new Color(200, 200, 200));
		next.setBounds(192, 275, 130, 34);
		forgot1.add(next);

		JLabel back = new JLabel("Go Back");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Font font = back.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				back.setFont(font.deriveFont(attributes));
				back.setForeground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Font font = back.getFont();
				Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
				back.setFont(font.deriveFont(attributes));
				back.setForeground(new Color(128, 0, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Timer timer = new Timer(100, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Welcome getBack = new Welcome();
						getBack.setVisible(true);
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		});
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setHorizontalAlignment(SwingConstants.LEFT);
		back.setForeground(new Color(128, 0, 255));
		back.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		back.setBounds(31, 283, 67, 23);
		forgot1.add(back);

		invalidLabel = new JLabel();
		invalidLabel.setVisible(false);
		invalidLabel.setBackground(new Color(255, 0, 0));
		invalidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidLabel.setForeground(new Color(255, 0, 0));
		invalidLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		invalidLabel.setBounds(207, 248, 103, 23);
		forgot1.add(invalidLabel);

		JLabel lblWe = new JLabel("We'll help you recover your account");
		lblWe.setHorizontalAlignment(SwingConstants.LEFT);
		lblWe.setForeground(Color.WHITE);
		lblWe.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblWe.setBounds(38, 86, 282, 23);
		mainPane.add(lblWe);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(350, 18, 40, 46);
		mainPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ForgotPassword.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON3.png")));

		JPanel titleBar = new JPanel();
		titleBar.setBackground(new Color(255, 255, 255, 0));
		titleBar.setBounds(0, 0, 428, 23);
		mainPane.add(titleBar);

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

		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = usernameField.getText();
				String passkey = passkeyField.getText();

				if (AccountVerify.accountExist(user)) {
					invalidLabel.setVisible(false);
					passkeyField.setVisible(true);
					passkeyLabel.setVisible(true);
					desc1.setVisible(true);
					desc2.setVisible(true);
					usernameField.setBounds(31, 58, 292, 34);
					userLabel.setBounds(31, 24, 156, 23);
					if (!user.isEmpty() && !passkey.isEmpty()) {
						invalidLabel.setVisible(true);
						if (AccountVerify.passkey(passkey).equals(SQLQuery.getPassKey(user))) {
							dispose();
							ChangePassword reset = new ChangePassword(user);
							reset.setVisible(true);
						} else {
							invalidLabel.setVisible(true);
							invalidLabel.setText("Invalid passkey");
						}
					}

				} else {
					invalidLabel.setVisible(true);
					invalidLabel.setText("No search result");
				}

			}
		});

	}
}

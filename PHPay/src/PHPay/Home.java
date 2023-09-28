package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;

public class Home extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y;
	private ServicePanel servicePanel;
	private SummaryPanel summaryPanel;
	private HomePanel homePanel;
	private HelpPanel helpPanel;
	private SendMoney sendMoney;
	private String session;
	private JLabel home, wallet, activity, help;
	private JPanel movingPane;
	private JLabel balance;
	private JLabel lblNewLabel;
	private String getBal;
	private double currentBal;
	private JLabel lblLogout_1;
	private JLabel lblLogout_2;

	public static String addCommaSeparator(String value) {
		DecimalFormat formatter = new DecimalFormat("#,###.0");
		double number = Double.parseDouble(value);
		return formatter.format(number);
	}

	public Home(String ID) {

		this.session = ID;
		

		setTitle("PHPAY");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setUndecorated(true);
		getContentPane().setLayout(null);
		setBounds(0, 0, 1464, 754);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 1496) / 2;
		int centerY = (screenHeight - 749) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
		setVisible(true);
		
		JPanel top = new JPanel();
		top.setBackground(new Color(255, 255, 255, 0));
		top.setBounds(1, 0, 1561, 17);
		getContentPane().add(top);
		top.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		top.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int newX = getX() + e.getX() - x;
				int newY = getY() + e.getY() - y;

				setLocation(newX, newY);
			}
		});

		GradientPanel panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1464, 754);
		getContentPane().add(panel);
		panel.setLayout(null);

		RoundedPanel idPane = new RoundedPanel(10);
		idPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		idPane.setBackground(new Color(36, 0, 72));
		idPane.setBounds(-14, 116, 247, 111);
		panel.add(idPane);
		idPane.setLayout(null);

		balance = new JLabel("1,000,000.00");
		balance.setBounds(36, 26, 211, 73);
		idPane.add(balance);
		balance.setForeground(new Color(255, 255, 255));
		balance.setBackground(new Color(255, 255, 255));
		balance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		balance.setHorizontalAlignment(SwingConstants.LEFT);

		lblNewLabel = new JLabel("Balance");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(30, 15, 64, 32);
		idPane.add(lblNewLabel);

		RoundedPanel panelArea = new RoundedPanel(20);
		panelArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelArea.setBackground(new Color(255, 255, 255));
		panelArea.setBounds(263, 0, 1233, 754);
		panel.add(panelArea);
		panelArea.setLayout(null);

		servicePanel = new ServicePanel(session);
		summaryPanel = new SummaryPanel(session);
		helpPanel = new HelpPanel(session);
		homePanel = new HomePanel();
		sendMoney = new SendMoney(session);
		
		
		servicePanel.setVisible(false);
		summaryPanel.setVisible(false);
		helpPanel.setVisible(false);
		sendMoney.setVisible(false);
		
		panelArea.add(homePanel);
		panelArea.add(servicePanel);
		panelArea.add(summaryPanel);
		panelArea.add(helpPanel);
		panelArea.add(sendMoney);
		

		wallet = new JLabel("   Wallet");
		wallet.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/wallet-.png")));
		wallet.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		wallet.setBounds(28, 302, 115, 50);
		panel.add(wallet);
		wallet.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(servicePanel);
				
				
				
			}
		});
		wallet.setHorizontalAlignment(SwingConstants.LEFT);
		wallet.setForeground(new Color(255, 255, 255));

		home = new JLabel("   Home");
		home.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/home-.png")));
		home.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		home.setBounds(28, 238, 115, 50);
		panel.add(home);
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(homePanel);

			}
		});
		home.setHorizontalAlignment(SwingConstants.LEFT);
		home.setForeground(new Color(255, 255, 255));

		help = new JLabel("   Help");
		help.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/help-.png")));
		help.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		help.setBounds(28, 601, 115, 50);
		panel.add(help);
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(helpPanel);

			}
		});
		help.setHorizontalAlignment(SwingConstants.LEFT);
		help.setForeground(new Color(255, 255, 255));

		activity = new JLabel("   Transactions");
		activity.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/activity-.png")));
		activity.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		activity.setBounds(28, 540, 148, 50);
		panel.add(activity);
		activity.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(summaryPanel);

			}

		});
		activity.setHorizontalAlignment(SwingConstants.LEFT);
		activity.setForeground(new Color(255, 255, 255));

		movingPane = new JPanel();
		movingPane.setBounds(3, 752, 301, 73);
		panel.add(movingPane);
		movingPane.setBackground(new Color(0, 0, 0, 100));

		RoundedPanel profilePane = new RoundedPanel(42);
		profilePane.setBackground(new Color(82, 82, 82));
		profilePane.setBorder(new EmptyBorder(0, 0, 0, 0));
		profilePane.setBounds(28, 25, 70, 69);
		panel.add(profilePane);
		profilePane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("HJ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(-1, -1, 70, 70);
		profilePane.add(lblNewLabel_1);

		JLabel nameLabel = new JLabel(SQLQuery.getFullName(ID));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setBounds(109, 30, 191, 36);
		panel.add(nameLabel);

		RoundedButton btnNewButton = new RoundedButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome back = new Welcome();
				back.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/logout.png")));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBounds(28, 711, 46, 30);
		panel.add(btnNewButton);
		
		JLabel lblLogout = new JLabel("Log Out");
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
		lblLogout.setBounds(95, 705, 104, 36);
		panel.add(lblLogout);
		
		lblLogout_1 = new JLabel(SQLQuery.getID(ID));
		lblLogout_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout_1.setForeground(Color.WHITE);
		lblLogout_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblLogout_1.setBounds(131, 56, 94, 36);
		panel.add(lblLogout_1);
		
		lblLogout_2 = new JLabel("ID");
		lblLogout_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout_2.setForeground(Color.WHITE);
		lblLogout_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblLogout_2.setBounds(110, 56, 22, 36);
		panel.add(lblLogout_2);
		
		JLabel lblSendMoney = new JLabel("Send Money");
		lblSendMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(sendMoney);
			}
		});
		lblSendMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblSendMoney.setForeground(Color.WHITE);
		lblSendMoney.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblSendMoney.setBounds(72, 355, 115, 30);
		panel.add(lblSendMoney);
		
		JLabel lblBuyLoad = new JLabel("Buy Load");
		lblBuyLoad.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuyLoad.setForeground(Color.WHITE);
		lblBuyLoad.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblBuyLoad.setBounds(72, 390, 115, 30);
		panel.add(lblBuyLoad);
		
		JLabel lblPayBills = new JLabel("Pay Bills");
		lblPayBills.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayBills.setForeground(Color.WHITE);
		lblPayBills.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblPayBills.setBounds(72, 425, 115, 30);
		panel.add(lblPayBills);
		
		JLabel lblCashIn = new JLabel("Cash In");
		lblCashIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCashIn.setForeground(Color.WHITE);
		lblCashIn.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblCashIn.setBounds(72, 460, 115, 30);
		panel.add(lblCashIn);
		
		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransfer.setForeground(Color.WHITE);
		lblTransfer.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblTransfer.setBounds(72, 495, 115, 30);
		panel.add(lblTransfer);

		updateBalanceLabelFromFile();
		currentBal = SQLQuery.getBalance(session);
		getBal = currentBal + "";

	}

	public void updateBalanceLabelFromFile() {
		SQLConnection newCon = new SQLConnection();
		newCon.Connect();

		String query = "SELECT `balance` FROM `users` WHERE user_id = ?";
		try {
			PreparedStatement ps = newCon.getCon().prepareStatement(query);
			ps.setString(1, session);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				getBal = rs.getString("balance");
				double doubleBalance = 0.0;
				doubleBalance = Double.parseDouble(getBal);

				String formattedBalance = addCommaSeparator(String.format("%.2f", doubleBalance));
				balance.setText(formattedBalance);

			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public String getSession() {
		return session;
	}

	private void titleClicked(JPanel selectedPanel) {
		summaryPanel.setVisible(false);
		servicePanel.setVisible(false);
		homePanel.setVisible(false);
		helpPanel.setVisible(false);
		sendMoney.setVisible(false);

		selectedPanel.setVisible(true);
	}
}
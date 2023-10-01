package PHPay;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;

public class Home extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y;
	private Transactions summaryPanel;
	private HomePanel homePanel;
	private HelpPanel helpPanel;
	private SendMoney sendMoney;
	private PayBills payBills;
	private BuyLoad buyLoad;
	private CashIn cashIn;
	private CashOut cashOut;
	private String session;
	private JLabel home, wallet, activity, help;
	private JPanel movingPane;
	private JLabel balance;
	private JLabel lblNewLabel;
	private JLabel lblLogout_1;
	private JLabel lblLogout_2;
	private JLabel lblSendMoney, lblBuyLoad, lblPayBills, lblCashIn, lblTransfer;
	private GradientPanel panel;
	private JSeparator separator;
	private RoundedPanel accountStatus;
	private JLabel statusLabel;
	private int countdown = 1000;
	private boolean isCountdownActive = true;
	static Timer inactive;
	private JPanel selectedPane;

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
		int centerX = (screenWidth - 1464) / 2;
		int centerY = (screenHeight - 754) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
		setVisible(true);

		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			@Override
			public void eventDispatched(AWTEvent event) {
				resetCountdown();
			}
		}, AWTEvent.MOUSE_EVENT_MASK | AWTEvent.KEY_EVENT_MASK);

		inactive = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isCountdownActive) {
					if (countdown > 0) {
						countdown--;
					} else {
						disconnectUser();
					}
				}
			}
		});
		inactive.start();

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

		panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1464, 754);
		getContentPane().add(panel);
		panel.setLayout(null);

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

			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(0, 238, 266, 50);
			}
		});
		home.setHorizontalAlignment(SwingConstants.LEFT);
		home.setForeground(new Color(255, 255, 255));

		statusLabel = new JLabel("Active");
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setForeground(Color.WHITE);
		statusLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		statusLabel.setBounds(96, 81, 166, 36);
		panel.add(statusLabel);

		JLabel time = new JLabel("");
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		time.setForeground(new Color(192, 192, 192));
		time.setBounds(1275, 20, 133, 19);
		panel.add(time);

		Timer timer1 = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendar = Calendar.getInstance();
				Date currentTime = calendar.getTime();

				SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
				String formattedTime = timeFormat.format(currentTime);
				time.setText(formattedTime);
			}
		});
		timer1.start();

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(49, 357, 2, 175);
		panel.add(separator);

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
		panelArea.setBounds(265, 0, 1233, 754);
		panel.add(panelArea);
		panelArea.setLayout(null);

		summaryPanel = new Transactions(session);
		helpPanel = new HelpPanel(session);
		homePanel = new HomePanel();
		sendMoney = new SendMoney(session);
		buyLoad = new BuyLoad(session);
		payBills = new PayBills(session);
		cashIn = new CashIn(session);
		cashOut = new CashOut(session);

		summaryPanel.setVisible(false);
		helpPanel.setVisible(false);
		sendMoney.setVisible(false);
		buyLoad.setVisible(false);
		payBills.setVisible(false);
		cashIn.setVisible(false);
		cashOut.setVisible(false);

		panelArea.add(homePanel);
		panelArea.add(summaryPanel);
		panelArea.add(helpPanel);
		panelArea.add(sendMoney);
		panelArea.add(buyLoad);
		panelArea.add(payBills);
		panelArea.add(cashIn);
		panelArea.add(cashOut);

		wallet = new JLabel("   Wallet");
		wallet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(1, 303, 266, 50);

			}
		});
		wallet.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/wallet-.png")));
		wallet.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		wallet.setBounds(28, 302, 115, 50);
		panel.add(wallet);
		wallet.setHorizontalAlignment(SwingConstants.LEFT);
		wallet.setForeground(new Color(255, 255, 255));

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
			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(1, 602, 266, 50);
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

			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(1, 541, 266, 50);
			}
		});
		activity.setHorizontalAlignment(SwingConstants.LEFT);
		activity.setForeground(new Color(255, 255, 255));

		movingPane = new JPanel();
		movingPane.setBounds(3, 752, 301, 73);
		panel.add(movingPane);
		movingPane.setBackground(new Color(0, 0, 0, 100));

		JLabel nameLabel = new JLabel(SQLQuery.getFullName(ID));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setBounds(80, 32, 166, 36);
		panel.add(nameLabel);

		RoundedButton btnNewButton = new RoundedButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Proceed logout = new Proceed("Logging out");
				logout.setVisible(true);
				
				dispose();
				
				inactive.setRepeats(false);
				Welcome back = new Welcome();
				back.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/logout.png")));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBounds(28, 701, 46, 30);
		panel.add(btnNewButton);

		JLabel lblLogout = new JLabel("Log Out");
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 15));
		lblLogout.setBounds(84, 697, 70, 36);
		panel.add(lblLogout);

		RoundedPanel profilePane = new RoundedPanel(42);
		profilePane.setBackground(new Color(128, 0, 255, 100));
		profilePane.setBorder(new EmptyBorder(0, 0, 0, 0));
		profilePane.setBounds(13, 33, 55, 55);
		panel.add(profilePane);
		profilePane.setLayout(null);

		String fullName = SQLQuery.getFullName(ID);
		char first;
		String firstInitial = null;

		first = fullName.charAt(0);
		firstInitial = String.valueOf(first);

		JLabel lblNewLabel_1 = new JLabel(firstInitial);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(4, 3, 45, 45);
		profilePane.add(lblNewLabel_1);

		lblLogout_1 = new JLabel(SQLQuery.getID(ID));
		lblLogout_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout_1.setForeground(Color.WHITE);
		lblLogout_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblLogout_1.setBounds(98, 56, 82, 36);
		panel.add(lblLogout_1);

		lblLogout_2 = new JLabel("ID");
		lblLogout_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout_2.setForeground(Color.WHITE);
		lblLogout_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblLogout_2.setBounds(81, 56, 22, 36);
		panel.add(lblLogout_2);

		lblSendMoney = new JLabel("Send Money");
		lblSendMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!SQLQuery.getStatus(ID) == false)
					titleClicked(sendMoney);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(49, 352, 220, 30);
			}
		});
		lblSendMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblSendMoney.setForeground(Color.WHITE);
		lblSendMoney.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblSendMoney.setBounds(72, 352, 115, 30);
		panel.add(lblSendMoney);

		lblBuyLoad = new JLabel("Buy Load");
		lblBuyLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!SQLQuery.getStatus(ID) == false)
					titleClicked(buyLoad);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(49, 389, 220, 30);
			}
		});
		lblBuyLoad.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuyLoad.setForeground(Color.WHITE);
		lblBuyLoad.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblBuyLoad.setBounds(72, 389, 115, 30);
		panel.add(lblBuyLoad);

		lblPayBills = new JLabel("Pay Bills");
		lblPayBills.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!SQLQuery.getStatus(ID) == false)
					titleClicked(payBills);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(49, 427, 220, 30);
			}
		});
		lblPayBills.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayBills.setForeground(Color.WHITE);
		lblPayBills.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblPayBills.setBounds(72, 427, 115, 30);
		panel.add(lblPayBills);

		lblCashIn = new JLabel("Cash In");
		lblCashIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!SQLQuery.getStatus(ID) == false)
					titleClicked(cashIn);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(49, 466, 220, 30);
			}
		});
		lblCashIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCashIn.setForeground(Color.WHITE);
		lblCashIn.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblCashIn.setBounds(72, 465, 115, 30);
		panel.add(lblCashIn);

		lblTransfer = new JLabel("Cash Out");
		lblTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!SQLQuery.getStatus(ID) == false)
					titleClicked(cashOut);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				selectedPane.setBounds(49, 501, 220, 30);
			}
		});
		lblTransfer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransfer.setForeground(Color.WHITE);
		lblTransfer.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
		lblTransfer.setBounds(72, 501, 115, 30);
		panel.add(lblTransfer);
		accountStatus = new RoundedPanel(42);
		accountStatus.setBounds(81, 95, 10, 10);
		panel.add(accountStatus);
		accountStatus.setToolTipText("Account Status");
		accountStatus.setLayout(null);
		accountStatus.setBorder(new EmptyBorder(0, 0, 0, 0));
		accountStatus.setBackground(new Color(255, 255, 255));

		selectedPane = new JPanel();
		selectedPane.setBackground(new Color(89, 0, 179));
		selectedPane.setBounds(0, 238, 266, 50);
		panel.add(selectedPane);

		// AUTOMATICALLY SET STATUS AT LOG-IN
		if (SQLQuery.getStatus(ID) == false) {
			checkStatus(ID);
			setDisabled(true);
		}

		//TIMER TO UPDATE STATUS
		Timer status = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (SQLQuery.getStatus(ID) == false) {
					setDisabled(true);
					checkStatus(ID);
				} else {
					setDisabled(false);
					checkStatus(ID);
				}
			}
		});
		status.start();
		

		checkStatus(ID);

//		Timer status1 = new Timer(10000, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				checkStatus(ID);
//			}
//		});
//		status1.start();

		updateBalanceLabelFromFile();
		int interval = 5000;

		Timer timer = new Timer(interval, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateBalanceLabelFromFile();
			}
		});

		timer.start();

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
				double doubleBalance = rs.getDouble("balance");

	            String formattedBalance;
	            
	            if (doubleBalance == 0.0) {
	                formattedBalance = "0.0";
	            } else {
	                formattedBalance = addCommaSeparator(String.format("%.2f", doubleBalance));
	            }
	            
	            balance.setText("₱ " +formattedBalance);

			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void checkStatus(String ID) {
		if (SQLQuery.getStatus(ID) == false) {
			accountStatus.setBackground(Color.RED);
			statusLabel.setText("Your account was put on hold");
			statusLabel.setForeground(Color.red);
			statusLabel.setToolTipText("Submit a ticket to comply for account reactivation");
		} else {
			accountStatus.setBackground(Color.GREEN);
			statusLabel.setText("Active");
			statusLabel.setForeground(Color.white);
			statusLabel.setToolTipText("");
		}
	}

	public String getSession() {
		return session;
	}

	private void titleClicked(JPanel selectedPanel) {
		homePanel.setVisible(false);
		summaryPanel.setVisible(false);
		helpPanel.setVisible(false);
		sendMoney.setVisible(false);
		buyLoad.setVisible(false);
		payBills.setVisible(false);
		cashIn.setVisible(false);
		cashOut.setVisible(false);

		if (selectedPanel == sendMoney)
			sendMoney.reset();
		else if (selectedPanel == buyLoad)
			buyLoad.reset();
		else if (selectedPanel == payBills)
			payBills.reset();
		else if (selectedPanel == cashIn)
			cashIn.reset();
		else if (selectedPanel == cashOut) 
			cashOut.reset();
		
		if (selectedPanel == helpPanel) 
			helpPanel.showHome();

		selectedPanel.setVisible(true);
	}

	private void setDisabled(boolean disable) {
		if (disable == true) {
			lblSendMoney.setForeground(Color.GRAY);
			lblBuyLoad.setForeground(Color.GRAY);
			lblPayBills.setForeground(Color.GRAY);
			lblCashIn.setForeground(Color.GRAY);
			lblTransfer.setForeground(Color.GRAY);
		} else {
			lblSendMoney.setForeground(Color.WHITE);
			lblBuyLoad.setForeground(Color.WHITE);
			lblPayBills.setForeground(Color.WHITE);
			lblCashIn.setForeground(Color.WHITE);
			lblTransfer.setForeground(Color.WHITE);
		}

	}

	private void resetCountdown() {
		countdown = 30;
		isCountdownActive = true;
	}

	private void disconnectUser() {
		Proceed logout = new Proceed("Disconnecting");
		logout.setVisible(true);

		Timer inactivityTimer = new Timer(4000, new ActionListener() { //FROM 4000
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

				Welcome welcome = new Welcome();
				welcome.timeoutVisible();
				welcome.setVisible(true);

				inactive.setRepeats(false);

			}
		});
		inactivityTimer.start();
		inactivityTimer.setRepeats(false);

		isCountdownActive = false;
	}

	public void stopInactiveTimer() {
		inactive.stop();
		inactive.setRepeats(false);
	}
}
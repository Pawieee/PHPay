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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y;
	private ServicePanel servicePanel;
	private SummaryPanel summaryPanel;
	private HomePanel homePanel;
	private String session;

	public Home(String ID) {
		this.session = ID;
		setTitle("PHPAY");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setUndecorated(true);
		getContentPane().setLayout(null);
		setBounds(0, 0, 1444, 749);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 1200) / 2;
		int centerY = (screenHeight - 750) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
		setVisible(true);

		GradientPanel panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1444, 1220);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel wallet = new JLabel("   Wallet");
		wallet.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/wallet-.png")));
		wallet.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		wallet.setBounds(30, 297, 176, 70);
		panel.add(wallet);
		wallet.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(servicePanel);
			}
		});
		wallet.setHorizontalAlignment(SwingConstants.LEFT);
		wallet.setForeground(new Color(255, 255, 255));

		JLabel home = new JLabel("   Home");
		home.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/home-.png")));
		home.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		home.setBounds(30, 217, 176, 70);
		panel.add(home);
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(homePanel);

			}
		});
		home.setHorizontalAlignment(SwingConstants.LEFT);
		home.setForeground(new Color(255, 255, 255));

		JLabel activity = new JLabel("   Activity");
		activity.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/activity-.png")));
		activity.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		activity.setBounds(30, 378, 186, 70);
		panel.add(activity);
		activity.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(summaryPanel);
			}
		});
		activity.setHorizontalAlignment(SwingConstants.LEFT);
		activity.setForeground(new Color(255, 255, 255));

		JLabel help = new JLabel("   Help");
		help.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/help-.png")));
		help.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
		help.setBounds(30, 458, 156, 70);
		panel.add(help);
		help.setHorizontalAlignment(SwingConstants.LEFT);
		help.setForeground(new Color(255, 255, 255));

		RoundedPanel panelArea = new RoundedPanel(20);
		panelArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelArea.setBackground(new Color(255, 255, 255));
		panelArea.setBounds(234, 31, 1200, 700);
		panel.add(panelArea);
		panelArea.setLayout(null);

		servicePanel = new ServicePanel(session);
		summaryPanel = new SummaryPanel(session);

		servicePanel.setVisible(false);
		summaryPanel.setVisible(false);
		homePanel = new HomePanel();
		panelArea.add(homePanel);

		panelArea.add(servicePanel);
		panelArea.add(summaryPanel);
		
		RoundedButton btnNewButton = new RoundedButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/logout.png")));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBounds(83, 668, 57, 38);
		panel.add(btnNewButton);
		
		RoundedPanel profilePane = new RoundedPanel(42);
		profilePane.setBounds(80, 34, 70, 69);
		panel.add(profilePane);
		profilePane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/user1.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 70, 70);
		profilePane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cristian Jay");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(20, 112, 191, 36);
		panel.add(lblNewLabel_2);

		JPanel top = new JPanel();
		top.setBounds(1, 0, 1443, 17);
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
	}

	private void titleClicked(JPanel selectedPanel) {
		summaryPanel.setVisible(false);
		servicePanel.setVisible(false);
		homePanel.setVisible(false);

		selectedPanel.setVisible(true);
	}
}
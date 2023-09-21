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
		setBounds(0, 0, 1200, 749);
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
		panel.setBounds(0, 0, 1200, 1220);
		getContentPane().add(panel);
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(89, 89, 89, 1));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(256, 43, 2, 69);
		panel.add(separator);

		JLabel lblWallet = new JLabel("Wallet");
		lblWallet.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblWallet.setBounds(385, 38, 70, 70);
		panel.add(lblWallet);
		lblWallet.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(servicePanel);
			}
		});
		lblWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblWallet.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblNewLabel.setBounds(302, 38, 70, 70);
		panel.add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(homePanel);

			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1 = new JLabel("Activity");
		lblNewLabel_1_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(467, 38, 70, 70);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(summaryPanel);
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1_1 = new JLabel("Help");
		lblNewLabel_1_1_1.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(547, 38, 70, 70);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));

		JLabel line = new JLabel("");
		line.setBounds(37, 42, 188, 66);
		panel.add(line);
		line.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND.png")));
		line.setHorizontalAlignment(SwingConstants.CENTER);
		line.setForeground(Color.WHITE);
		line.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 38));

		JPanel panelArea = new JPanel();
		panelArea.setBackground(new Color(255, 255, 255));
		panelArea.setBounds(0, 139, 1200, 610);
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

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(89, 89, 89, 1));
		separator_1.setBounds(377, 57, 2, 35);
		panel.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(new Color(89, 89, 89, 1));
		separator_1_1.setBounds(459, 57, 2, 35);
		panel.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBackground(new Color(89, 89, 89, 1));
		separator_1_1_1.setBounds(541, 57, 2, 35);
		panel.add(separator_1_1_1);

		JPanel top = new JPanel();
		top.setBounds(1, 0, 1200, 17);
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
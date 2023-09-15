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

public class Home extends JFrame {
	private static final long serialVersionUID = 1L;
	private int x, y;
	private ServicePanel servicePanel;
	private SummaryPanel summaryPanel;
	private HomePanel homePanel;

	public Home() {
		
		setTitle("PHPAY");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1200, 750);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panelArea = new JPanel();
		panelArea.setBackground(new Color(255, 255, 255));
		panelArea.setBounds(0, 141, 1200, 610);
		panel.add(panelArea);
		panelArea.setLayout(null);
		
		servicePanel = new ServicePanel();
		summaryPanel = new SummaryPanel();
		
		servicePanel.setVisible(false);
		summaryPanel.setVisible(false);
		homePanel = new HomePanel();
		panelArea.add(homePanel);
		
		panelArea.add(servicePanel);
		panelArea.add(summaryPanel);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(homePanel);
			}
		});
		lblNewLabel.setBounds(260, 39, 106, 77);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		

		JLabel lblWallet = new JLabel("Wallet");
		lblWallet.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(servicePanel);
			}
		});
		lblWallet.setBounds(380, 39, 106, 77);
		panel.add(lblWallet);
		lblWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblWallet.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1 = new JLabel("Summary");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				titleClicked(summaryPanel);
			}
		});
		lblNewLabel_1_1.setBounds(500, 39, 106, 77);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1_1 = new JLabel("Ambot");
		lblNewLabel_1_1_1.setBounds(620, 39, 106, 77);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));

		JLabel line = new JLabel("");
		line.setBounds(33, 39, 188, 66);
		panel.add(line);
		line.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND.png")));
		line.setHorizontalAlignment(SwingConstants.CENTER);
		line.setForeground(Color.WHITE);
		line.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 38));

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Home.class.getResource("/PHPay/phpimg/Home Background.jpg")));
		background.setBounds(0, 0, 1201, 750);
		panel.add(background);

		JPanel top = new JPanel();
		top.setBounds(1, 0, 1200, 17);
		panel.add(top);
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
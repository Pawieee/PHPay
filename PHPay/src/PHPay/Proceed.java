package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Proceed extends JFrame {

	private static final long serialVersionUID = 1L;
	private static String message;
	private String session;

	public Proceed(String message) {
		Proceed.message = message;
		setTitle("PHPAY");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setUndecorated(true);
		getContentPane().setLayout(null);
		setBounds(0, 0, 323, 137);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 323) / 2;
		int centerY = (screenHeight - 137) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
		setVisible(true);

		GradientPanel panel = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		panel.setBackground(new Color(64, 0, 128, 20));
		panel.setBounds(0, 0, 323, 137);
		getContentPane().add(panel);
		panel.setLayout(null);

		RoundedPanel panel_1 = new RoundedPanel(20);
		panel_1.setBackground(new Color(64, 0, 128));
		panel_1.setBounds(10, 11, 303, 115);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel messageLabel = new JLabel("");
		messageLabel.setBounds(0, 16, 303, 50);
		panel_1.add(messageLabel);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setText(message);
		messageLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		messageLabel.setForeground(new Color(255, 255, 255));

		JLabel countdownLabel = new JLabel("");
		countdownLabel.setBackground(new Color(0, 0, 0));
		countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countdownLabel.setForeground(new Color(255, 255, 255));
		countdownLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		countdownLabel.setBounds(84, 65, 134, 33);
		panel_1.add(countdownLabel);

		Timer timer = new Timer(1000, new ActionListener() {
			int count = 3;
			String dots = ".";

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					countdownLabel.setText(dots);
					dots += ".";
					count--;
				} else {
					((Timer) e.getSource()).stop();
					dispose();
				}
			}
		});

		timer.start();

	}
	//OVERLOAD ANOTHER PROCEED FOR TRANSACTION PURPOSES	
	public Proceed(String message, String ID) {
		Proceed.message = message;
		this.session = ID;
		setTitle("PHPAY");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setUndecorated(true);
		getContentPane().setLayout(null);
		setBounds(0, 0, 323, 137);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 323) / 2;
		int centerY = (screenHeight - 137) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
		setVisible(true);

		GradientPanel panel = new GradientPanel(Color.decode("#16002c"), Color.decode("#16002c"));
		panel.setBackground(new Color(64, 0, 128, 20));
		panel.setBounds(0, 0, 323, 137);
		getContentPane().add(panel);
		panel.setLayout(null);

		RoundedPanel panel_1 = new RoundedPanel(20);
		panel_1.setBackground(new Color(64, 0, 128));
		panel_1.setBounds(10, 11, 303, 115);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel messageLabel = new JLabel("");
		messageLabel.setBounds(0, 16, 303, 50);
		panel_1.add(messageLabel);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setText(message);
		messageLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		messageLabel.setForeground(new Color(255, 255, 255));

		JLabel countdownLabel = new JLabel("");
		countdownLabel.setBackground(new Color(0, 0, 0));
		countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countdownLabel.setForeground(new Color(255, 255, 255));
		countdownLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		countdownLabel.setBounds(84, 65, 134, 33);
		panel_1.add(countdownLabel);

		Timer timer = new Timer(1000, new ActionListener() {
			int count = 3;
			String dots = ".";

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count > 0) {
					countdownLabel.setText(dots);
					dots += ".";
					count--;
				} else {
					((Timer) e.getSource()).stop();
					dispose();
					
					Receipt receipt = new Receipt(ID);
					receipt.setVisible(true);
					
				}
			}
		});

		timer.start();
	}

	public String getSession() {
		return this.session;
	}

}

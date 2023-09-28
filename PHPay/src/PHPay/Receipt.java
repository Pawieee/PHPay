package PHPay;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Receipt extends JFrame {

	private String session;

	public Receipt(String ID) {
		this.session = ID;
		initialize();
	}

	private void initialize() {
		getContentPane().setBackground(new Color(255, 255, 255, 0));
		setBounds(100, 100, 452, 554);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 672) / 2;
		int centerY = (screenHeight - 596) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

		GradientPanel panel = new GradientPanel(new Color(0x360079), new Color(0x360079));
		panel.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 452, 554);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel operationMessage = new JLabel("Transaction Success!");
		operationMessage.setForeground(new Color(255, 255, 255));
		operationMessage.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		operationMessage.setHorizontalAlignment(SwingConstants.CENTER);
		operationMessage.setBounds(42, 29, 368, 38);
		panel.add(operationMessage);

		RoundedPanel extraPane = new RoundedPanel(15);
		extraPane.setLayout(null);
		extraPane.setBackground(new Color(0, 0, 0, 50));
		extraPane.setBounds(36, 170, 380, 412);
		panel.add(extraPane);

		RoundedButton ok = new RoundedButton("Done");
		ok.setBackground(new Color(64, 0, 128));
		ok.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		ok.setBounds(120, 329, 115, 40);
		extraPane.add(ok);

		JSeparator separator = new JSeparator();
		separator.setBounds(34, 151, 311, 2);
		extraPane.add(separator);

		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setBounds(34, 178, 126, 27);
		extraPane.add(lblTransactionId);
		lblTransactionId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTransactionId.setForeground(new Color(255, 255, 255));

		JLabel transactID = new JLabel("123E12QWE");
		transactID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		transactID.setHorizontalAlignment(SwingConstants.RIGHT);
		transactID.setBounds(170, 178, 172, 27);
		extraPane.add(transactID);
		transactID.setForeground(new Color(255, 255, 255));

		JLabel lblTime = new JLabel("Date");
		lblTime.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTime.setBounds(34, 224, 85, 27);
		extraPane.add(lblTime);
		lblTime.setForeground(new Color(255, 255, 255));

		JLabel time = new JLabel("02/03/23");
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		time.setBounds(213, 226, 132, 27);
		extraPane.add(time);
		time.setForeground(new Color(255, 255, 255));

		JLabel lblReceiver = new JLabel("Sent to");
		lblReceiver.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblReceiver.setBounds(34, 24, 85, 27);
		extraPane.add(lblReceiver);
		lblReceiver.setForeground(new Color(255, 255, 255));

		JPanel extraPane_1 = new JPanel();
		extraPane_1.setLayout(null);
		extraPane_1.setBackground(new Color(0, 0, 0, 50));
		extraPane_1.setBounds(165, 24, 215, 63);
		extraPane.add(extraPane_1);

		JLabel receiver_1 = new JLabel("123123123");
		receiver_1.setBounds(2, 29, 178, 23);
		extraPane_1.add(receiver_1);
		receiver_1.setHorizontalAlignment(SwingConstants.RIGHT);
		receiver_1.setForeground(Color.WHITE);
		receiver_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

		JLabel receiver = new JLabel("Cristian Jay Cosep");
		receiver.setBounds(2, 7, 181, 23);
		extraPane_1.add(receiver);
		receiver.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		receiver.setHorizontalAlignment(SwingConstants.RIGHT);
		receiver.setForeground(new Color(255, 255, 255));

		JLabel cash = new JLabel("1,000,000");
		cash.setBounds(173, 107, 172, 27);
		extraPane.add(cash);
		cash.setHorizontalAlignment(SwingConstants.RIGHT);
		cash.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		cash.setForeground(new Color(255, 255, 255));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblAmount.setBounds(34, 107, 115, 27);
		extraPane.add(lblAmount);

		JLabel lblTime_2 = new JLabel("Time");
		lblTime_2.setForeground(Color.WHITE);
		lblTime_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTime_2.setBounds(34, 270, 85, 27);
		extraPane.add(lblTime_2);

		JLabel time_1 = new JLabel("23:04");
		time_1.setHorizontalAlignment(SwingConstants.RIGHT);
		time_1.setForeground(Color.WHITE);
		time_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		time_1.setBounds(213, 270, 132, 27);
		extraPane.add(time_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(192, 78, 67, 67);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Receipt.class.getResource("/PHPay/phpimg/checking.png")));
		setVisible(true);
	}
}

package PHPay;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Receipt extends JFrame {

	private static final long serialVersionUID = 1L;
	private String session;

	public Receipt(String ID) {
		this.session = ID;
		initialize();
	}

	private void initialize() {
		
		Home homeInstance = new Home(session); 
		homeInstance.dispose();
		homeInstance.stopInactiveTimer(); 
		
		getContentPane().setBackground(new Color(255, 255, 255, 0));
		setBounds(100, 100, 495, 594);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 495) / 2;
		int centerY = (screenHeight - 599) / 2;
		setLocation(centerX, centerY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

		GradientPanel panel = new GradientPanel(new Color(0x360079), new Color(0x360079));
		panel.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 495, 595);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel operationMessage = new JLabel("Transaction Success!");
		operationMessage.setForeground(new Color(255, 255, 255));
		operationMessage.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		operationMessage.setHorizontalAlignment(SwingConstants.CENTER);
		operationMessage.setBounds(55, 32, 368, 38);
		panel.add(operationMessage);

		RoundedPanel extraPane = new RoundedPanel(15);
		extraPane.setLayout(null);
		extraPane.setBackground(new Color(0, 0, 0, 50));
		extraPane.setBounds(36, 143, 416, 439);
		panel.add(extraPane);

		RoundedButton ok = new RoundedButton("Done");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ok.setBounds(152, 388, 113, 38);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ok.setBounds(153, 389, 115, 40);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ok.setBounds(153, 389, 115, 40);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ok.setBounds(152, 388, 113, 38);
			}
			
		});
		ok.setForeground(new Color(255, 255, 255));
		ok.setBackground(new Color(255, 255, 255));
		ok.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home(session);
				home.setVisible(true);

			}
		});
		ok.setBounds(153, 389, 115, 40);
		extraPane.add(ok);

		JSeparator separator = new JSeparator();
		separator.setBounds(31, 333, 349, 2);
		extraPane.add(separator);

		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setBounds(31, 121, 126, 27);
		extraPane.add(lblTransactionId);
		lblTransactionId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTransactionId.setForeground(new Color(255, 255, 255));

		JLabel transactID = new JLabel(SQLQuery.getTransaction(session)[0]);
		transactID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		transactID.setHorizontalAlignment(SwingConstants.RIGHT);
		transactID.setBounds(208, 121, 172, 27);
		extraPane.add(transactID);
		transactID.setForeground(new Color(255, 255, 255));

		JLabel lblTime = new JLabel("Date / Time");
		lblTime.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTime.setBounds(31, 171, 98, 27);
		extraPane.add(lblTime);
		lblTime.setForeground(new Color(255, 255, 255));

		JLabel time = new JLabel(SQLQuery.getTransaction(session)[3]);
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		time.setBounds(205, 171, 175, 27);
		extraPane.add(time);
		time.setForeground(new Color(255, 255, 255));

		JLabel lblReceiver = new JLabel("Sent to");
		lblReceiver.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblReceiver.setBounds(31, 33, 123, 40);
		extraPane.add(lblReceiver);
		lblReceiver.setForeground(new Color(255, 255, 255));

		JPanel extraPane_1 = new JPanel();
		extraPane_1.setLayout(null);
		extraPane_1.setBackground(new Color(0, 0, 0, 50));
		extraPane_1.setBounds(165, 24, 215, 63);
		extraPane.add(extraPane_1);

		JLabel receiver_1 = new JLabel(SQLQuery.getTransaction(session)[5]);
		receiver_1.setBounds(2, 29, 178, 23);
		extraPane_1.add(receiver_1);
		receiver_1.setHorizontalAlignment(SwingConstants.RIGHT);
		receiver_1.setForeground(Color.WHITE);
		receiver_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));

		JLabel receiver = new JLabel(SQLQuery.getFullName(SQLQuery.getTransaction(session)[5]));
		receiver.setBounds(2, 7, 181, 23);
		extraPane_1.add(receiver);
		receiver.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		receiver.setHorizontalAlignment(SwingConstants.RIGHT);
		receiver.setForeground(new Color(255, 255, 255));

		JLabel cash = new JLabel("₱ " + (double)Math.round(Double.valueOf(SQLQuery.getTransaction(session)[4])/1.03));
		cash.setBounds(208, 227, 172, 27);
		extraPane.add(cash);
		cash.setHorizontalAlignment(SwingConstants.RIGHT);
		cash.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		cash.setForeground(new Color(255, 255, 255));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblAmount.setBounds(31, 227, 115, 27);
		extraPane.add(lblAmount);

		JLabel lblTime_2 = new JLabel("Transaction Fee (0.03%)");
		lblTime_2.setForeground(Color.WHITE);
		lblTime_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTime_2.setBounds(31, 278, 167, 27);
		extraPane.add(lblTime_2);

		JLabel time_1 = new JLabel("₱ " + (double)Math.round(((Double.valueOf(SQLQuery.getTransaction(session)[4]) /1.03) * 0.03)*100)/100);
		time_1.setHorizontalAlignment(SwingConstants.RIGHT);
		time_1.setForeground(Color.WHITE);
		time_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		time_1.setBounds(248, 278, 132, 27);
		extraPane.add(time_1);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTotal.setBounds(31, 352, 115, 27);
		extraPane.add(lblTotal);
		
		JLabel cash_1 = new JLabel("₱ " + SQLQuery.getTransaction(session)[4]);
		cash_1.setHorizontalAlignment(SwingConstants.RIGHT);
		cash_1.setForeground(Color.WHITE);
		cash_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		cash_1.setBounds(208, 352, 172, 27);
		extraPane.add(cash_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(204, 66, 67, 67);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Receipt.class.getResource("/PHPay/phpimg/checking.png")));
		setVisible(true);
		
	
	}
}

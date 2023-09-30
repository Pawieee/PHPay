package PHPay;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServicePanel extends JPanel {
	@SuppressWarnings("unused")
	private String session;
	private static final long serialVersionUID = 1L;

	public ServicePanel(String ID) {
		this.session = ID;
		setBounds(0, 0, 1205, 754);
		setLayout(null);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1205, 1500);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		add(gradientPanel);
		gradientPanel.setLayout(null);

		RoundedPanel sendPane = new RoundedPanel(15);
		sendPane.setBackground(new Color(0, 0, 0, 50));
		sendPane.setBounds(35, 50, 179, 108);
		gradientPanel.add(sendPane);
		sendPane.setLayout(null);

		JLabel send = new JLabel("");
		send.setHorizontalAlignment(SwingConstants.CENTER);
		send.setIcon(new ImageIcon(ServicePanel.class.getResource("/PHPay/phpimg/send icon.png")));
		send.setBounds(0, 0, 179, 108);
		sendPane.add(send);

		JLabel sendLabel = new JLabel("Send Money");
		sendLabel.setForeground(new Color(255, 255, 255));
		sendLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		sendLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sendLabel.setBounds(35, 166, 179, 28);
		gradientPanel.add(sendLabel);

		RoundedPanel loadPane = new RoundedPanel(15);
		loadPane.setBackground(new Color(0, 0, 0, 50));
		loadPane.setBounds(35, 301, 179, 108);
		gradientPanel.add(loadPane);
		loadPane.setLayout(null);

		JLabel load = new JLabel("");
		load.setIcon(new ImageIcon(ServicePanel.class.getResource("/PHPay/phpimg/load.png")));
		load.setHorizontalAlignment(SwingConstants.CENTER);
		load.setBounds(0, 0, 179, 108);
		loadPane.add(load);

		JLabel lblLoad = new JLabel("Buy Load");
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoad.setForeground(Color.WHITE);
		lblLoad.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblLoad.setBounds(35, 420, 179, 28);
		gradientPanel.add(lblLoad);

		RoundedPanel billPane = new RoundedPanel(15);
		billPane.setBackground(new Color(0, 0, 0, 50));
		billPane.setBounds(35, 538, 179, 108);
		gradientPanel.add(billPane);
		billPane.setLayout(null);

		JLabel bill = new JLabel("");
		bill.setIcon(new ImageIcon(ServicePanel.class.getResource("/PHPay/phpimg/bills.png")));
		bill.setHorizontalAlignment(SwingConstants.CENTER);
		bill.setBounds(0, 0, 179, 108);
		billPane.add(bill);

		JLabel lblPayBill = new JLabel("Pay Bills");
		lblPayBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayBill.setForeground(Color.WHITE);
		lblPayBill.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblPayBill.setBounds(36, 657, 179, 28);
		gradientPanel.add(lblPayBill);

		RoundedPanel withdrawPane = new RoundedPanel(15);
		withdrawPane.setBackground(new Color(0, 0, 0, 50));
		withdrawPane.setBounds(303, 50, 179, 108);
		gradientPanel.add(withdrawPane);
		withdrawPane.setLayout(null);

		JLabel withdraw = new JLabel("");
		withdraw.setIcon(new ImageIcon(ServicePanel.class.getResource("/PHPay/phpimg/withdrawal.png")));
		withdraw.setHorizontalAlignment(SwingConstants.CENTER);
		withdraw.setBounds(0, 0, 179, 108);
		withdrawPane.add(withdraw);

		JLabel withdrawLabel = new JLabel("Withdraw");
		withdrawLabel.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawLabel.setForeground(Color.WHITE);
		withdrawLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		withdrawLabel.setBounds(303, 170, 179, 28);
		gradientPanel.add(withdrawLabel);

		RoundedPanel cashInPane = new RoundedPanel(15);
		cashInPane.setBackground(new Color(0, 0, 0, 50));
		cashInPane.setBounds(303, 302, 179, 108);
		gradientPanel.add(cashInPane);
		cashInPane.setLayout(null);

		JLabel cashIn = new JLabel("");
		cashIn.setHorizontalAlignment(SwingConstants.CENTER);
		cashIn.setIcon(new ImageIcon(ServicePanel.class.getResource("/PHPay/phpimg/cash in icon.png")));
		cashIn.setBounds(0, 0, 179, 108);
		cashInPane.add(cashIn);

		JLabel cashLabel = new JLabel("Cash In");
		cashLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cashLabel.setForeground(Color.WHITE);
		cashLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		cashLabel.setBounds(303, 420, 179, 28);
		gradientPanel.add(cashLabel);

		RoundedPanel transfer = new RoundedPanel(15);
		transfer.setBackground(new Color(0, 0, 0, 50));
		transfer.setBounds(303, 538, 179, 108);
		gradientPanel.add(transfer);
		transfer.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ServicePanel.class.getResource("/PHPay/phpimg/bank transfer.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 179, 108);
		transfer.add(lblNewLabel);

		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setForeground(Color.WHITE);
		lblTransfer.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblTransfer.setBounds(303, 657, 179, 28);
		gradientPanel.add(lblTransfer);

		JLabel time = new JLabel("");
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		time.setForeground(new Color(255, 255, 255));
		time.setBounds(1031, 11, 149, 28);
		gradientPanel.add(time);

		RoundedPanel extraPane = new RoundedPanel(15);
		extraPane.setLayout(null);
		extraPane.setBackground(new Color(0, 0, 0, 50));
		extraPane.setBounds(580, 50, 571, 596);
		gradientPanel.add(extraPane);

		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendar = Calendar.getInstance();
				Date currentTime = calendar.getTime();

				SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
				String formattedTime = timeFormat.format(currentTime);
				time.setText(formattedTime);
			}
		});
		timer.start();

	}
}

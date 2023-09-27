package PHPay;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Receipt {

	private JFrame frame;
	private String session;

	public Receipt(String ID) {
		this.session = ID;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel operationMessage = new JLabel(SQLQuery.getTransaction(session)[2]);
		operationMessage.setBounds(177, 45, 132, 27);
		frame.getContentPane().add(operationMessage);

		JLabel cash = new JLabel(Double.valueOf(SQLQuery.getTransaction(session)[4])/1.03 + "₱");
		cash.setBounds(163, 82, 132, 27);
		frame.getContentPane().add(cash);

		JLabel transactID = new JLabel(SQLQuery.getTransaction(session)[0]);
		transactID.setBounds(163, 136, 132, 23);
		frame.getContentPane().add(transactID);

		JLabel time = new JLabel(SQLQuery.getTransaction(session)[3]);
		time.setBounds(163, 171, 132, 23);
		frame.getContentPane().add(time);

		JLabel receiver = new JLabel(SQLQuery.getTransaction(session)[5]);
		receiver.setBounds(163, 204, 132, 23);
		frame.getContentPane().add(receiver);

		JButton ok = new JButton("New button");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();;
			}
		});

		ok.setBounds(163, 338, 85, 21);
		frame.getContentPane().add(ok);

		JLabel lblNewLabel = new JLabel("Operation");
		lblNewLabel.setBounds(41, 45, 85, 13);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCash = new JLabel("Cash");
		lblCash.setBounds(41, 88, 85, 13);
		frame.getContentPane().add(lblCash);

		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setBounds(41, 136, 85, 13);
		frame.getContentPane().add(lblTransactionId);

		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(41, 171, 85, 13);
		frame.getContentPane().add(lblTime);

		JLabel lblReceiver = new JLabel("Receiver");
		lblReceiver.setBounds(41, 208, 85, 13);
		frame.getContentPane().add(lblReceiver);
		
		JLabel lblNewLabel_1 = new JLabel("3% Service Fee");
		lblNewLabel_1.setBounds(41, 250, 112, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel ServiceFee = new JLabel((Double.valueOf(SQLQuery.getTransaction(session)[4])/1.03)*0.03+" ₱");
		ServiceFee.setBounds(163, 243, 132, 27);
		frame.getContentPane().add(ServiceFee);
		
		JLabel lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setBounds(41, 299, 85, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel total = new JLabel(SQLQuery.getTransaction(session)[4] + " ₱");
		total.setBounds(163, 299, 132, 23);
		frame.getContentPane().add(total);
		frame.setVisible(true);
	}
}

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
		frame.setBounds(100, 100, 450, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel operationMessage = new JLabel(SQLQuery.getTransaction(session)[2]);
		operationMessage.setBounds(177, 48, 132, 27);
		frame.getContentPane().add(operationMessage);

		JLabel cash = new JLabel(SQLQuery.getTransaction(session)[4] + "P");
		cash.setBounds(177, 106, 132, 27);
		frame.getContentPane().add(cash);

		JLabel transactID = new JLabel(SQLQuery.getTransaction(session)[0]);
		transactID.setBounds(177, 143, 132, 23);
		frame.getContentPane().add(transactID);

		JLabel time = new JLabel(SQLQuery.getTransaction(session)[3]);
		time.setBounds(177, 194, 132, 23);
		frame.getContentPane().add(time);

		JLabel receiver = new JLabel(SQLQuery.getTransaction(session)[5]);
		receiver.setBounds(177, 227, 132, 23);
		frame.getContentPane().add(receiver);

		JButton ok = new JButton("New button");
		ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		ok.setBounds(163, 260, 85, 21);
		frame.getContentPane().add(ok);

		JLabel lblNewLabel = new JLabel("Operation");
		lblNewLabel.setBounds(41, 62, 85, 13);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCash = new JLabel("cash");
		lblCash.setBounds(41, 120, 85, 13);
		frame.getContentPane().add(lblCash);

		JLabel lblTransactionId = new JLabel("Transaction ID");
		lblTransactionId.setBounds(41, 153, 85, 13);
		frame.getContentPane().add(lblTransactionId);

		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(41, 204, 85, 13);
		frame.getContentPane().add(lblTime);

		JLabel lblReceiver = new JLabel("Receiver");
		lblReceiver.setBounds(41, 237, 85, 13);
		frame.getContentPane().add(lblReceiver);
		frame.setVisible(true);
	}
}

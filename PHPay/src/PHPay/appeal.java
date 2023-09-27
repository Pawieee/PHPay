package PHPay;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appeal {

	private String session;
	private JFrame frame;

	public appeal(String ID) {
		this.session = ID;
		initialize();
	}

	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setBounds(103, 40, 70, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(91, 73, 255, 141);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = textArea.getText();
				SQLQuery.createAppeal(session, message);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(275, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}
}

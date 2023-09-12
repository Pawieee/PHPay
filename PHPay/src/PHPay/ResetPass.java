package PHPay;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResetPass {

	private JFrame frame;
	private JTextField userName;
	private JTextField passKeyConfirm;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ResetPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(154, 66, 96, 19);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		passKeyConfirm = new JTextField();
		passKeyConfirm.setBounds(154, 133, 96, 19);
		frame.getContentPane().add(passKeyConfirm);
		passKeyConfirm.setColumns(10);
		
		JButton confirm = new JButton("OK");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userName.getText();
				String passkeycon = passKeyConfirm.getText();
				
				if (AccountVerify.accountExist(user)) {
					if (AccountVerify.passkey(passkeycon).equals(SQLQuery.getPassKey(user))) {
						System.out.println("tama man");
						new ResetPass1(user);
					}
					else {
						System.out.println("wrong passkey");
					}
				} else {
					System.out.println("User doesn't exist");
				}
				
			}
		});
		confirm.setBounds(165, 192, 85, 21);
		frame.getContentPane().add(confirm);
		frame.setVisible(true);
	}
}

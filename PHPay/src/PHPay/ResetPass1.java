package PHPay;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResetPass1 {

	private static String username;

	private JFrame frame;
	private JTextField newPass;
	private JTextField newPassConfirm;

	public ResetPass1(String username) {
		this.username = username;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		newPass = new JTextField();
		newPass.setBounds(162, 76, 96, 19);
		frame.getContentPane().add(newPass);
		newPass.setColumns(10);

		newPassConfirm = new JTextField();
		newPassConfirm.setBounds(162, 142, 96, 19);
		frame.getContentPane().add(newPassConfirm);
		newPassConfirm.setColumns(10);

		JButton confirm = new JButton("New button");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(username);
				String newPasst = newPass.getText();
				String newPassCon = newPassConfirm.getText();
				
				System.out.println("passt: " +newPasst);
				System.out.println("newpass: " +newPassCon);

				if (newPasst.equals(newPassCon)) {
					String newPassHash = AccountVerify.passwordHash(newPassCon);
					SQLQuery.updatePass(newPassHash, username);
					frame.dispose();

				} else {
					System.out.println("Passwords do not match");
				}

			}
		});
		confirm.setBounds(162, 198, 85, 21);
		frame.getContentPane().add(confirm);
		frame.setVisible(true);
	}

}

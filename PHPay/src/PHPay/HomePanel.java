package PHPay;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public HomePanel() {
		setBounds(0, 0, 1200, 610);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("this is home");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(474, 181, 360, 230);
		add(lblNewLabel);
	}

}

package PHPay;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ServicePanel extends JPanel {
	private String session;
	private static final long serialVersionUID = 1L;

	public ServicePanel(String ID) {
		this.session = ID;
		setBounds(0, 0, 1200, 610);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("this is service");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(474, 181, 360, 230);
		add(lblNewLabel);

	}

}

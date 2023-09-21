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

	}

}

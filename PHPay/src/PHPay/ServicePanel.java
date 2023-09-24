package PHPay;

import javax.swing.JPanel;

public class ServicePanel extends JPanel {
	@SuppressWarnings("unused")
	private String session;
	private static final long serialVersionUID = 1L;

	public ServicePanel(String ID) {
		this.session = ID;
		setBounds(0, 0, 1200, 610);
		setLayout(null);

	}

}

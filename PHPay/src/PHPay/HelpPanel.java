package PHPay;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HelpPanel extends JPanel {
	public HelpPanel(String ID) {
		setBackground(new Color(128, 0, 255));
		
		
		setBounds(0, 0, 1200, 700);
		setLayout(null);
		
		GradientPanel panel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		panel.setBounds(0, 0, 1200, 68);
		add(panel);
		
		
		
		JLabel lblNewLabel = new JLabel("How can we help you?");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 30));
		lblNewLabel.setBounds(323, 49, 494, 84);
		add(lblNewLabel);
		
		RoundedPanel panel_1 = new RoundedPanel(15);
		panel_1.setBounds(201, 130, 782, 359);
		add(panel_1);
		
		JLabel lblYourGuideTo = new JLabel("Your guide to PHPAY");
		lblYourGuideTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourGuideTo.setForeground(Color.WHITE);
		lblYourGuideTo.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 30));
		lblYourGuideTo.setBounds(323, 500, 494, 84);
		add(lblYourGuideTo);

		
	}
}

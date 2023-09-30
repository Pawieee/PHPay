package PHPay;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServicePanel extends JPanel {
	@SuppressWarnings("unused")
	private String session;
	private static final long serialVersionUID = 1L;

	public ServicePanel(String ID) {
		this.session = ID;
		setBounds(0, 0, 1205, 754);
		setLayout(null);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1205, 1500);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		add(gradientPanel);
		gradientPanel.setLayout(null);


	}
}

package PHPay;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;

public class Home extends JFrame {
	public Home() {
		setUndecorated(true);
		getContentPane().setLayout(null);
		setBounds(0, 0, 1200, 750);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 1200) / 2;
		int centerY = (screenHeight - 750) / 2;
		setLocation(centerX, centerY);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1200, 750);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel titlePanel = new JPanel(); // 20 is the corner radius
		titlePanel.setBackground(new Color(103, 0, 206));
		titlePanel.setBounds(1, 33, 1199, 77);
		panel.add(titlePanel);
		titlePanel.setLayout(null);
		
//		RoundedPanel titlePanel = new RoundedPanel(10); // 20 is the corner radius
//		titlePanel.setBackground(new Color(103, 0, 206));
//		titlePanel.setBounds(1, 33, 1199, 77);
//		panel.add(titlePanel);
//		titlePanel.setLayout(null);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(1085, 23, 89, 29);
		titlePanel.add(btnNewButton);

		JLabel line = new JLabel("__");
		line.setVerticalAlignment(SwingConstants.TOP);
		line.setHorizontalAlignment(SwingConstants.LEFT);
		line.setForeground(Color.WHITE);
		line.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 38));
		line.setBounds(11, -18, 86, 100);
		titlePanel.add(line);

		JLabel PHPAY = new JLabel("PHPay");
		PHPAY.setVerticalAlignment(SwingConstants.TOP);
		PHPAY.setForeground(Color.WHITE);
		PHPAY.setFont(new Font("Cocogoose Pro SemiLight", Font.BOLD | Font.ITALIC, 35));
		PHPAY.setBounds(10, 20, 224, 43);
		titlePanel.add(PHPAY);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(200, 0, 106, 77);
		titlePanel.add(lblNewLabel);
		
		JLabel lblWallet = new JLabel("Wallet");
		lblWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblWallet.setForeground(Color.WHITE);
		lblWallet.setBounds(320, 0, 106, 77);
		titlePanel.add(lblWallet);
		
		JLabel lblNewLabel_1_1 = new JLabel("Summary");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(440, 0, 106, 77);
		titlePanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ambot");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(560, 0, 106, 77);
		titlePanel.add(lblNewLabel_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 0, 1200, 30);
		panel.add(panel_2);
	}

class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Make the panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2d = (Graphics2D) g.create();

        // Create a rounded rectangle shape
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius * 2, cornerRadius * 2);

        // Set rendering hints for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Fill the shape with the panel's background color
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

        g2d.dispose();
    }
}
}

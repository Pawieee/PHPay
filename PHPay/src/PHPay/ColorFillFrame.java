package PHPay;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFillFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel colorPanel;
	private JLabel helloLabel;
	private Timer timer;
	private int radius = 0;
	private boolean paintingDone = false;
	private Timer labelTimer;

	public ColorFillFrame() {

		setTitle("Color Fill Frame");
		setSize(500, 500);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 400) / 2;
		int centerY = (screenHeight - 200) / 2;
		setLocation(centerX, centerY);
		setSize(400, 200);

		colorPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int diameter = 2 * radius;
                g.fillOval(centerX - radius, centerY - radius, diameter, diameter);

                if (!paintingDone && radius >= Math.min(getWidth(), getHeight()) / 2) {
                    paintingDone = true;
                    labelTimer.start(); 
                }
            }
        };
        colorPanel.setBackground(new Color(0, 0, 0, 0));
        getContentPane().add(colorPanel);
        
       

		timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				radius += 2;
				colorPanel.repaint();

				int maxRadius = Math.min(colorPanel.getWidth(), colorPanel.getHeight()) / 2;
				if (radius > maxRadius) {
					int diagonalRadius = (int) Math.sqrt((colorPanel.getWidth() / 2) * (colorPanel.getWidth() / 2)
							+ (colorPanel.getHeight() / 2) * (colorPanel.getHeight() / 2));
					if (radius > diagonalRadius) {
						timer.stop();
					}
				}
			}
		});
		colorPanel.setBackground(new Color(0, 0, 0, 0));
		labelTimer = new Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				labelTimer.stop();
				addHelloLabel();
			}
		});

		timer.start();
	}

	private void addHelloLabel() {
		helloLabel = new JLabel("Hello");
		helloLabel.setFont(new Font("Arial", Font.BOLD, 24));
		helloLabel.setBounds(207, 219, 100, 100);
		helloLabel.setForeground(Color.WHITE);
		helloLabel.setHorizontalAlignment(JLabel.CENTER);
		helloLabel.setVerticalAlignment(JLabel.CENTER);
		colorPanel.add(helloLabel);
		colorPanel.revalidate();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ColorFillFrame frame = new ColorFillFrame();
				frame.setVisible(true);
			}
		});
	}
}

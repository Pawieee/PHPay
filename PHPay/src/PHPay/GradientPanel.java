package PHPay;

import javax.swing.*;
import java.awt.*;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.geom.*;

public class GradientPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color startColor;
	private Color endColor;

	public GradientPanel(Color startColor, Color endColor) {
		this.startColor = startColor;
		this.endColor = endColor;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();

		int panelWidth = getWidth();
		int panelHeight = getHeight();

		GradientPaint gradient = new GradientPaint(0, 0, startColor, panelWidth, panelHeight, endColor);

		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, panelWidth, panelHeight);

		g2d.dispose();
	}
}



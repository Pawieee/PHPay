package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class RoundedPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, cornerRadius * 2,
				cornerRadius * 2);

		// Set rendering hints for smooth edges
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		// Fill the shape with the panel's background color
		g2d.setColor(getBackground());
		g2d.fill(roundedRectangle);

		g2d.dispose();
	}
}

//ROUNDED BUTTON
class RoundedButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
	private Color foregroundColor;

	public RoundedButton(String text) {
		super(text);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		setPreferredSize(new Dimension(100, 40)); // Set your preferred size here
		backgroundColor = new Color(255, 255, 255, 50); // Set your background color
		foregroundColor = Color.BLACK; // Set your foreground (text) color
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int width = getWidth();
		int height = getHeight();
		RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, 20, 20);

		g2.setColor(backgroundColor);
		g2.fill(roundedRectangle);

		g2.setColor(foregroundColor);
		g2.setFont(getFont());
		FontMetrics metrics = g2.getFontMetrics(getFont());
		int x = (width - metrics.stringWidth(getText())) / 2;
		int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
		g2.drawString(getText(), x, y);

		g2.dispose();
		super.paintComponent(g);
	}

	// Optional: Add hover and click effects if desired

	public void setButtonBackgroundColor(Color color) {
		backgroundColor = color;
		repaint();
	}

	public void setButtonForegroundColor(Color color) {
		foregroundColor = color;
		repaint();
	}

}

//ROUNDED COMBOBOX
class RoundedComboBox<E> extends JComboBox<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private Color backgroundColor; // Added field for background color

	public RoundedComboBox(E[] items) {
		super(items);
		setOpaque(false);
		this.backgroundColor = getBackground(); // Store the original background color
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (!isOpaque()) {
			super.paintComponent(g);
			return;
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Adjust the radius as
																								// needed
		}

		g2d.setColor(backgroundColor); // Use the stored background color
		g2d.fill(shape);

		super.paintComponent(g);
	}
}

class RoundedRadioButton extends JRadioButton {

    private Shape shape;
    private Color backgroundColor;

    public RoundedRadioButton(String text) {
        super(text);
        setOpaque(false);
        this.backgroundColor = getBackground();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            super.paintComponent(g);
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }

        g2d.setColor(backgroundColor);
        g2d.fill(shape);

        super.paintComponent(g);
    }
}

//ROUNDED PASSWORDFIELD
class RoundedPasswordField extends JPasswordField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;

	public RoundedPasswordField(int columns) {
		super(columns);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (!isOpaque()) {
			super.paintComponent(g);
			return;
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Adjust the radius as
																								// needed
		}

		g2d.setColor(getBackground());
		g2d.fill(shape);

		super.paintComponent(g);
	}
}

//ROUNDED TEXTFIELD
class RoundedTextField extends JTextField {

	private static final long serialVersionUID = 1L;
	private Shape shape;

	public RoundedTextField(int columns) {
		super(columns);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (!isOpaque()) {
			super.paintComponent(g);
			return;
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Adjust the radius as
																								// needed
		}

		g2d.setColor(getBackground());
		g2d.fill(shape);

		super.paintComponent(g);
	}
}
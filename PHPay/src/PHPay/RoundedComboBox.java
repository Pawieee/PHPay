package PHPay;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedComboBox<E> extends JComboBox<E> {

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
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15); // Adjust the radius as needed
        }

        g2d.setColor(backgroundColor); // Use the stored background color
        g2d.fill(shape);

        super.paintComponent(g);
    }
}

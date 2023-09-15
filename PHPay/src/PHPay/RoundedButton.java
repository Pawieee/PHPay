package PHPay;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
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
        backgroundColor = new Color(192, 192, 192, 50); // Set your background color
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

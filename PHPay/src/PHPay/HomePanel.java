package PHPay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomePanel extends JPanel {
    private JScrollPane scrollPane;
    ScrollBarCustom phpayScroll;

    public HomePanel() {
        setBounds(0, 0, 1200, 910);
        setBackground(new Color(0, 0, 0));
        setForeground(new Color(0, 0, 0));
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1200, 910));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel.setBounds(202, 38, 264, 192);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel_1.setBounds(593, 383, 264, 192);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(33, 652, 264, 192);
        panel.add(lblNewLabel_2);

        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 1200, 610);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        phpayScroll = new ScrollBarCustom();
        phpayScroll.setBlockIncrement(1);
        phpayScroll.setBackground(new Color(255, 255, 255));
        phpayScroll.setForeground(new Color(64, 0, 128));
        phpayScroll.setUnitIncrement(10);
        scrollPane.setVerticalScrollBar(phpayScroll);
    }
}

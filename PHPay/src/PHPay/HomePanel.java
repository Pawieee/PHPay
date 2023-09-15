package PHPay;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class HomePanel extends JPanel {
    private JScrollPane scrollPane;
    ScrollBarCustom phpayScroll;
    private RoundedPanel bluePanel;
    private RoundedPanel blackPanel;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;

    public HomePanel() {
    	setBorder(new EmptyBorder(0, 0, 0, 0));
        setBounds(0, 0, 1200, 910);
        setBackground(new Color(0, 0, 0));
        setForeground(new Color(0, 0, 0));
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel.setPreferredSize(new Dimension(1200, 910));
        panel.setBackground(new Color(255, 255, 255));

        scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel.setLayout(null);
        
        bluePanel = new RoundedPanel(25);
        bluePanel.setBackground(new Color(30, 144, 255));
        bluePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        bluePanel.setBounds(10, 608, 1180, 260);
        panel.add(bluePanel);
        bluePanel.setLayout(null);
        
        lblNewLabel = new JLabel("Partners");
        lblNewLabel.setBorder(new CompoundBorder());
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Couture", Font.PLAIN, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 24, 1180, 49);
        bluePanel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner1.png")));
        lblNewLabel_1.setBounds(53, 24, 80, 80);
        bluePanel.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner2.png")));
        lblNewLabel_2.setBounds(245, 150, 80, 80);
        bluePanel.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner3.png")));
        lblNewLabel_3.setBounds(824, 150, 80, 80);
        bluePanel.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner4.png")));
        lblNewLabel_4.setBounds(245, 24, 80, 80);
        bluePanel.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner5.png")));
        lblNewLabel_5.setBounds(824, 24, 80, 80);
        bluePanel.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner6.png")));
        lblNewLabel_6.setBounds(1012, 24, 80, 80);
        bluePanel.add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner7.png")));
        lblNewLabel_7.setBounds(442, 114, 80, 80);
        bluePanel.add(lblNewLabel_7);
        
        lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner8.png")));
        lblNewLabel_8.setBounds(53, 150, 80, 80);
        bluePanel.add(lblNewLabel_8);
        
        lblNewLabel_9 = new JLabel("");
        lblNewLabel_9.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner9.png")));
        lblNewLabel_9.setBounds(1012, 150, 80, 80);
        bluePanel.add(lblNewLabel_9);
        
        lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setIcon(new ImageIcon(HomePanel.class.getResource("/PHPay/phpimg/partner10.png")));
        lblNewLabel_10.setBounds(615, 114, 80, 80);
        bluePanel.add(lblNewLabel_10);
        
        blackPanel = new RoundedPanel(15);
        blackPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        blackPanel.setBackground(new Color(0, 0, 0));
        blackPanel.setBounds(10, 879, 1180, 45);
        panel.add(blackPanel);
        blackPanel.setLayout(null);
        scrollPane.setBounds(0, 0, 1200, 610);
//        scrollPane.setBounds(0, 0, 1200, 910);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        phpayScroll = new ScrollBarCustom();
        phpayScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
        phpayScroll.setBlockIncrement(1);
        phpayScroll.setBackground(new Color(255, 255, 255));
        phpayScroll.setForeground(new Color(192, 192, 192));
        phpayScroll.setUnitIncrement(10);
        scrollPane.setVerticalScrollBar(phpayScroll);
    }
}

package PHPay;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class Loading extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textField;

	public Loading() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Loading.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));

		setType(Type.UTILITY);
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBounds(275, 55, 495, 275);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 495, 276);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel sy = new JLabel("2023.8");
		sy.setVerticalAlignment(SwingConstants.TOP);
		sy.setHorizontalAlignment(SwingConstants.LEFT);
		sy.setForeground(Color.WHITE);
		sy.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		sy.setBounds(314, 137, 86, 24);
		panel.add(sy);
		
		JLabel Stock = new JLabel("5StockRedemption");
		Stock.setHorizontalAlignment(SwingConstants.LEFT);
		Stock.setVerticalAlignment(SwingConstants.TOP);
		Stock.setForeground(Color.WHITE);
		Stock.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		Stock.setBounds(168, 157, 118, 24);
		panel.add(Stock);
		
		JLabel PHPAY = new JLabel("");
		PHPAY.setHorizontalAlignment(SwingConstants.CENTER);
		PHPAY.setIcon(new ImageIcon(Loading.class.getResource("/PHPay/phpimg/PHPAY-BRAND.png")));
		PHPAY.setForeground(new Color(255, 255, 255));
		PHPAY.setFont(new Font("Cocogoose Pro SemiLight", Font.BOLD | Font.ITALIC, 55));
		PHPAY.setBounds(-16, 105, 494, 69);
		panel.add(PHPAY);
		
		textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);

		JLabel PHPAYLOADING = new JLabel("");
		PHPAYLOADING.setBounds(-1, 0, 502, 275);
		panel.add(PHPAYLOADING);
		PHPAYLOADING.setIcon(new ImageIcon(Loading.class.getResource("/PHPay/phpimg/stackedBG.png")));
		PHPAYLOADING.setVisible(true);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 255, 255));
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setBounds(-1, 270, 502, 13);
		panel.add(progressBar);
		
		progressBar.setVisible(true);
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

			protected Void doInBackground() throws Exception {
				for (int i = 0; i <= 130; i++) {
					progressBar.setValue(i);
					Thread.sleep(20);
				}
				return null;
			}

			protected void done() {
				progressBar.setVisible(false);
				Loading.this.setVisible(false); // hide the current frame
				Loading.this.dispose(); // dispose of the current frame

				Welcome runFrame = new Welcome();
				runFrame.setVisible(true);
			}
		};
		worker.execute();
	}

	public void runloadingPHP() {
		Loading Fframe = new Loading();
		Fframe.setSize(480, 159);
		Fframe.setResizable(false);
		Fframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Fframe.setVisible(true);
	}
}

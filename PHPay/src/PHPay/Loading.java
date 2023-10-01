package PHPay;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class Loading extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField textField;
	PhpaySplash curvesPanel1;

	public Loading() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Loading.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		setType(Type.UTILITY);
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBounds(275, 55, 495, 275);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		curvesPanel1 = new PhpaySplash();
		curvesPanel1.setForeground(SystemColor.textHighlight);
		curvesPanel1.setBackground(Color.WHITE);
		curvesPanel1.setBounds(0, 0, 495, 276);
		getContentPane().add(curvesPanel1);
		curvesPanel1.setLayout(null);

		JLabel SPhoto = new JLabel("");
		SPhoto.setIcon(new ImageIcon(Loading.class.getResource("/PHPay/phpimg/5S-Small.png")));
		SPhoto.setBounds(431, 207, 59, 52);
		curvesPanel1.add(SPhoto);

		JLabel Stock = new JLabel("5StockRedemption");
		Stock.setHorizontalAlignment(SwingConstants.LEFT);
		Stock.setVerticalAlignment(SwingConstants.TOP);
		Stock.setForeground(new Color(255, 255, 255));
		Stock.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		Stock.setBounds(195, 157, 105, 24);
		curvesPanel1.add(Stock);

		JLabel PHPAY = new JLabel("");
		PHPAY.setHorizontalAlignment(SwingConstants.CENTER);
		PHPAY.setIcon(new ImageIcon(Loading.class.getResource("/PHPay/phpimg/PHPAY-BRAND.png")));
		PHPAY.setForeground(new Color(255, 255, 255));
		PHPAY.setFont(new Font("Cocogoose Pro SemiLight", Font.BOLD | Font.ITALIC, 55));
		PHPAY.setBounds(0, 105, 494, 69);
		curvesPanel1.add(PHPAY);

		textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		curvesPanel1.add(textField);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 255, 255));
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setBounds(-1, 270, 502, 13);
		curvesPanel1.add(progressBar);

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

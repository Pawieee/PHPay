package PHPay;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Process extends JFrame {
	private static final long serialVersionUID = 1L;

	private String session;
	JTextField textField;

	public Process(String ID) {
		this.session = ID;

		setType(Type.UTILITY);

		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Administrator\\Downloads\\JAVA\\PHPAY\\PHPAY LOGO.png"));
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBounds(275, 55, 480, 111);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 464, 111);
		getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(138, 43, 226));
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setBounds(-6, 60, 470, 17);
		panel.add(progressBar);

		JLabel processingLabel = new JLabel("PROCESSING");
		processingLabel.setIcon(new ImageIcon(Process.class.getResource("/phpay/phpimg/icons8-enter-60.png")));
		processingLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 34));
		processingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		processingLabel.setBounds(9, -22, 398, 103);
		panel.add(processingLabel);
		processingLabel.setVisible(true);

		JLabel loadingLabel = new JLabel("......");
		loadingLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 34));
		loadingLabel.setBounds(347, -26, 160, 103);
		panel.add(loadingLabel);
		loadingLabel.setVisible(true);

		Timer timer = new Timer(250, new ActionListener() {
			int dotCount = 0;

			public void actionPerformed(ActionEvent e) {
				String text = "";
				for (int i = 0; i < dotCount; i++) {
					text += ". ";
				}
				loadingLabel.setText(text);
				dotCount = (dotCount + 1) % 6;
			}
		});
		timer.start();

		progressBar.setVisible(true);
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

			protected Void doInBackground() throws Exception {
				for (int i = 0; i <= 250; i++) {
					progressBar.setValue(i);
					Thread.sleep(10);
				}
				return null;
			}

			protected void done() {
				progressBar.setVisible(false);
				Process.this.setVisible(false); // hide the current frame
				Process.this.dispose(); // dispose of the current frame

				new Receipt(session);
//				Wallet run = new Wallet(getSession());
//				run.setVisible(true);

			}
		};
		worker.execute();

	}

	public void process1() {

		Process Fframe = new Process(getSession());
		Fframe.setSize(480, 159);
		Fframe.setResizable(false);
		Fframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Fframe.setVisible(true);
	}

	public String getSession() {
		return this.session;
	}

	public Process() {

		setType(Type.UTILITY);

		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Administrator\\Downloads\\JAVA\\PHPAY\\PHPAY LOGO.png"));
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBounds(275, 55, 480, 111);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 464, 111);
		getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(138, 43, 226));
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setBounds(-6, 60, 470, 17);
		panel.add(progressBar);

		JLabel processingLabel = new JLabel("PROCESSING");
		processingLabel.setIcon(new ImageIcon(Process.class.getResource("/phpay/phpimg/icons8-enter-60.png")));
		processingLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 34));
		processingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		processingLabel.setBounds(9, -22, 398, 103);
		panel.add(processingLabel);
		processingLabel.setVisible(true);

		JLabel loadingLabel = new JLabel("......");
		loadingLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 34));
		loadingLabel.setBounds(347, -26, 160, 103);
		panel.add(loadingLabel);
		loadingLabel.setVisible(true);

		Timer timer = new Timer(250, new ActionListener() {
			int dotCount = 0;

			public void actionPerformed(ActionEvent e) {
				String text = "";
				for (int i = 0; i < dotCount; i++) {
					text += ". ";
				}
				loadingLabel.setText(text);
				dotCount = (dotCount + 1) % 6;
			}
		});
		timer.start();

		progressBar.setVisible(true);
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

			protected Void doInBackground() throws Exception {
				for (int i = 0; i <= 250; i++) {
					progressBar.setValue(i);
					Thread.sleep(10);
				}
				return null;
			}

			protected void done() {
				progressBar.setVisible(false);
				Process.this.setVisible(false); // hide the current frame
				Process.this.dispose(); // dispose of the current frame

				Wallet run = new Wallet(session);
				run.setVisible(true);

			}
		};
		worker.execute();

	}

	public void process() {
		Process Fframe = new Process();
		Fframe.setSize(480, 159);
		Fframe.setResizable(false);
		Fframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Fframe.setVisible(true);
	}
}
package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.SwingConstants;
import java.awt.Font;

public class loadingPHP extends JFrame{
	

	JTextField textField;	
	
	public loadingPHP() {
		
	setType(Type.UTILITY);
	setUndecorated(true);
	setAlwaysOnTop(false);
	setResizable(false);
	setIconImage(Toolkit.getDefaultToolkit().getImage(loadingPHP.class.getResource("/phpay/phpimg/phpLogo1.png")));
	getContentPane().setForeground(Color.WHITE);
	setForeground(Color.WHITE);
	setBounds(275, 55, 465, 125);
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setForeground(SystemColor.textHighlight);
	panel.setBackground(Color.WHITE);
	panel.setBounds(0, 0, 464, 111);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	
	
	textField = new JTextField("");
	textField.setForeground(Color.GRAY);
	textField.setBounds(10, 22, 444, -5);
	panel.add(textField);
	
	JLabel PHPAYLOADING = new JLabel("");
	PHPAYLOADING.setBounds(-17, 0, 522, 104);
	PHPAYLOADING.setIcon(new ImageIcon(loadingPHP.class.getResource("/phpay/phpimg/PHPAY LOGO.png")));
	panel.add(PHPAYLOADING);
	
	JProgressBar progressBar = new JProgressBar();
	progressBar.setForeground(new Color(138, 43, 226));
	progressBar.setBackground(new Color(0, 0, 0));
	progressBar.setBounds(-6, 94, 470, 17);
	panel.add(progressBar);

	progressBar.setVisible(true);
	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

	    protected Void doInBackground() throws Exception {
	        for (int i = 0; i <= 100; i++) {
	            progressBar.setValue(i);
	            Thread.sleep(10);
	        }
	        return null;
	    }


	    protected void done() {
	        progressBar.setVisible(false);
	        loadingPHP.this.setVisible(false); // hide the current frame
	        loadingPHP.this.dispose(); // dispose of the current frame

	        Welcome runFrame = new Welcome();
	        runFrame.setVisible(true);
	    }
	};
	worker.execute();
	
}

	
	public void runloadingPHP() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        loadingPHP Fframe = new loadingPHP();
        Fframe.setSize(480, 159);
        Fframe.setResizable(false);
        Fframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Fframe.setVisible(true);
    }
	}

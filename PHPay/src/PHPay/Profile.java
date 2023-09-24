package PHPay;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private String profileID;

	public Profile() {
		setBackground(new Color(192, 192, 192));
		setResizable(false);
		setTitle("PROFILE");
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Profile.class.getResource("/phpay/phpimg/icons8-pandora-app-100.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(308, 347);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setWrapStyleWord(true);
		textArea.setTabSize(2);
		textArea.setEditable(false);
		textArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14)); // set font and size

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(350, 250));

		panel.add(scrollPane, BorderLayout.CENTER);

		try {
			String fileName = "ID.txt";
			File file = new File(fileName);
			if (file.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while ((line = br.readLine()) != null) {
					if (line.startsWith("ID: ")) {
						profileID = line.substring(line.indexOf(":") + 1).trim();
					}
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(profileID + ".txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("Password: ")) {
					String asterisks = "";
					for (int i = 0; i < line.substring(line.indexOf(":") + 1).trim().length(); i++) {
						asterisks += "*";
					}
					textArea.append("Password: " + asterisks + "\n");
				} else {
					textArea.append(line + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		getContentPane().add(panel);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Profile();
	}
}
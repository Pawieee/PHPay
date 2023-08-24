package PHPay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.UUID;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import PHPay.RandomID.RandomIdGenerator;
import javax.swing.SwingConstants;;

public class UserPassID extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;

	private String saveID;

	private String randomID;
	private JPasswordField passField;
	private HashSet<Integer> usedIds;
	private Random random;

	boolean userFieldEdited = false;
	boolean passFieldEdited = false;
	boolean idEdited = false;

	public JTextField textField, userField;
	JLabel IDStatusLabel, userStatusLabel, passStatusLabel, passStatusLabel1, note1, note2;

	public static boolean isValidUser(String name) {
		// Regular expression pattern to match only letters and digits
		String pattern = "^[a-zA-Z0-9]+$";

		// Check if the name matches the pattern
		if (name.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPass(String pass) {
		// Check if password is at least 8 characters and contains a combination of
		// letters and numbers
		String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

		// Check if password matches the pattern
		if (pass.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public UserPassID() {
		setBackground(Color.WHITE);

		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Administrator\\Downloads\\JAVA\\PHPAY\\PHPAY LOGO.png"));
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBounds(275, 55, 480, 595);
		setLocationRelativeTo(null);
		setTitle("PHPAY - Virtual Wallet");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 464, 595);
		getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);

		textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);

		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(99, 32, 243, 30);
		panel.add(lblNewLabel);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(Color.BLACK);
		panel_1_1_1_1.setBounds(88, 32, 386, 30);
		panel.add(panel_1_1_1_1);

		this.randomID = UUID.randomUUID().toString();
		RandomIdGenerator generator = new RandomIdGenerator();

		JTextField idField = new JTextField();
		idField.setBackground(Color.WHITE);
		idField.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 17));
		idField.setEditable(false);
		idField.setText("");
		idField.setBounds(88, 147, 290, 46);

		panel.add(idField);

		IDStatusLabel = new JLabel("");
		IDStatusLabel.setBounds(88, 230, 103, 23);
		panel.add(IDStatusLabel);

		userStatusLabel = new JLabel("");
		userStatusLabel.setBounds(88, 302, 103, 23);
		panel.add(userStatusLabel);

		passStatusLabel = new JLabel("");
		passStatusLabel.setBounds(88, 363, 290, 30);
		panel.add(passStatusLabel);

		passStatusLabel1 = new JLabel("");
		passStatusLabel1.setBounds(88, 383, 290, 30);
		panel.add(passStatusLabel1);

		note1 = new JLabel("");
		note1.setBounds(60, 398, 356, 30);
		panel.add(note1);

		note2 = new JLabel("");
		note2.setBounds(60, 416, 356, 30);
		panel.add(note2);

		boolean registerPressed = false;

		JButton generateButton = new JButton("Generate ID");
		generateButton.setBackground(Color.WHITE);
		generateButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 11));
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!registerPressed) {
					// Generate a new ID if the register button has not been pressed
					int id = generator.generateId();
					IDStatusLabel.setText(" ");

					// Update the ID field with the generated ID
					idField.setText(String.valueOf(id));
				}
			}
		});
		generateButton.setBounds(88, 204, 103, 23);
		panel.add(generateButton);

		JPanel progressPanel = new JPanel();
		progressPanel.setBounds(88, 480, 290, 30);
		progressPanel.setVisible(false);
		panel.add(progressPanel);
		progressPanel.setLayout(new BorderLayout(0, 0));

		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setForeground(new Color(128, 0, 255));
		progressBar.setStringPainted(true);
		progressPanel.add(progressBar);

		JButton RegisterButton = new JButton("REGISTER");
		RegisterButton.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		RegisterButton.setBackground(new Color(255, 255, 255));
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!userFieldEdited || !passFieldEdited || !idEdited) {

				} else {
					note1.setText("Please take note of your username and password as they are");
					note2.setText("important for accessing your account in the future.");
					progressPanel.setVisible(true);

					SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
						protected Void doInBackground() throws Exception {
							for (int i = 0; i <= 100; i++) {
								progressBar.setValue(i);
								Thread.sleep(50);
							}
							return null;
						}

						protected void done() {

							// SAVING REGISTER DATA

							// SAVING USERPASSID DATA
							String saveID = idField.getText();
							String saveUser = userField.getText();
							@SuppressWarnings("deprecation")
							String savePass = passField.getText();
							double balance = 0;

							userDATA account = new userDATA(saveID, saveUser, savePass, balance);
							account.saveAccount();
							CustomerID(saveID);

							progressPanel.setVisible(false);

							JFrame logoutFrame = new JFrame("");
							JLabel successLabel = new JLabel("Account created succesfully!");
							successLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
							successLabel.setHorizontalAlignment(SwingConstants.CENTER);
							logoutFrame.getContentPane().add(successLabel, BorderLayout.CENTER);
							logoutFrame.setResizable(false);

							JPanel buttonPanel = new JPanel(new GridLayout(1, 1)); // 1 row, 2 columns

							JButton okButton = new JButton("Next");
							okButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
							okButton.setBackground(new Color(255, 255, 255));
							okButton.setForeground(new Color(0, 0, 0));
							okButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {

									dispose();
									logoutFrame.dispose();

									Welcome mainpage = new Welcome();
									mainpage.setVisible(true);
									setVisible(false);
									dispose();

								}
							});
							buttonPanel.add(okButton);
							logoutFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

							logoutFrame.setSize(300, 150);
							logoutFrame.setLocationRelativeTo(null);
							logoutFrame.setVisible(true);

						}
					};
					worker.execute();
				}
			}
		});

		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String User = userField.getText();
				String Pass = passField.getText();

				if (idField.getText().isEmpty()) {
					IDStatusLabel.setText("Generate your ID");
					IDStatusLabel.setForeground(Color.RED);
				} else {
					IDStatusLabel.setText(" ");
					idEdited = true;
				}

				String user = userField.getText();
				if (!isValidUser(user)) {
					userStatusLabel.setText("Invalid username");
					userStatusLabel.setForeground(Color.RED);
					userFieldEdited = false;
				} else if (userField.getText().equals("Username")) { // Check if input is only spaces
					userStatusLabel.setText("Invalid username");
					userStatusLabel.setForeground(Color.RED);
					userFieldEdited = false;
				} else {
					userStatusLabel.setText("");
					userFieldEdited = true;
				}

				String pass = passField.getText();
				if (!isValidPass(pass)) {
					passStatusLabel.setText("Contains a combination of letters and numbers");
					passStatusLabel1.setText("At least 8 characters");
					passStatusLabel.setForeground(Color.RED);
					passStatusLabel1.setForeground(Color.RED);
					passFieldEdited = false;
				} else {
					passStatusLabel.setText("");
					passStatusLabel1.setText("");
					passFieldEdited = true;
				}

			}
		});

		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		RegisterButton.setBounds(172, 497, 124, 30);
		panel.add(RegisterButton);

		// Move the RegisterButton and progressPanel up
		panel.setComponentZOrder(RegisterButton, 0);
		panel.setComponentZOrder(progressPanel, 1);
		progressPanel.setBounds(RegisterButton.getBounds().x, RegisterButton.getBounds().y - 40,
				RegisterButton.getBounds().width, 20);

		JButton showPassword = new JButton("0");
		showPassword.setBackground(Color.WHITE);
		showPassword.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 8));
		showPassword.setForeground(Color.DARK_GRAY);
		showPassword.setBounds(332, 336, 39, 22);
		showPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(showPassword);

		showPassword.addActionListener(new ActionListener() {
			boolean passwordVisible = false;

			public void actionPerformed(ActionEvent e) {
				if (passwordVisible) {
					passField.setEchoChar('*'); // Mask password
					passwordVisible = false;
				} else {
					passField.setEchoChar((char) 0); // Show password
					passwordVisible = true;
				}
			}
		});

		userField = new JTextField("Username");
		userField.setBackground(Color.WHITE);
		userField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		userField.setBounds(88, 272, 290, 30);
		userField.setForeground(Color.GRAY);
		userField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (userField.getText().equals("Username")) {
					userField.setText("");
					userField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText("Username");
					userField.setForeground(Color.GRAY);
				} else if (!userField.getText().isEmpty()) {
					userFieldEdited = true;
				}
			}
		});
		panel.add(userField);

		passField = new JPasswordField();
		passField.setBackground(Color.WHITE);
		passField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		passField.setBounds(88, 333, 290, 30);
		passField.setForeground(Color.GRAY);
		passField.setText("Password");
		passField.setEchoChar((char) 0);
		passField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (Arrays.equals(passField.getPassword(), "Password".toCharArray())) {
					passField.setText("");
					passField.setForeground(Color.BLACK);
					passField.setEchoChar('*');
				}
			}

			public void focusLost(FocusEvent e) {
				if (passField.getPassword().length == 0) {
					passField.setText("Password");
					passField.setForeground(Color.GRAY);
					passField.setEchoChar((char) 0);
				} else if (!passField.getText().isEmpty()) {
					passFieldEdited = true;
				}
			}
		});
		panel.add(passField);

		JButton backButton = new JButton("<");
		backButton.setBackground(Color.WHITE);
		backButton.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 16));
		backButton.setBounds(30, 32, 48, 30);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reg runFrame = new Reg();
				runFrame.RunReg();
				UserPassID UserPassID = (UserPassID) SwingUtilities.getWindowAncestor(backButton);
				UserPassID.dispose();
			}
		});
		panel.add(backButton);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(0, 545, 474, 1);
		panel_1_2.setBackground(Color.BLACK);
		panel.add(panel_1_2);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(0, 11, 464, 1);
		panel_1_2_1.setBackground(Color.BLACK);
		panel.add(panel_1_2_1);

		JPanel eff1_2_1_1 = new JPanel();
		eff1_2_1_1.setLayout(null);
		eff1_2_1_1.setBackground(Color.LIGHT_GRAY);
		eff1_2_1_1.setBounds(0, 0, 474, 560);
		panel.add(eff1_2_1_1);

	}

	public int generateId() {
		int id = random.nextInt(100000000 - 100000 + 1) + 100000;
		while (usedIds.contains(id)) {
			id = random.nextInt(100000000 - 100000 + 1) + 100000;
		}
		usedIds.add(id);
		return id;
	}

	public void RunUserPassID() {

		UserPassID frame = new UserPassID();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void CustomerID(String saveID) {

		this.saveID = saveID;

		try {
			// Open original file for reading
			BufferedReader reader = new BufferedReader(new FileReader("tempUPID.txt"));

			// Open temporary file for reading
			BufferedReader tempReader = new BufferedReader(new FileReader("tempREG.txt"));

			// Open file for writing (overwrite existing data)
			String customer = saveID + ".txt";
			BufferedWriter writer = new BufferedWriter(new FileWriter(customer));

			// Read and write data from original file
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}

			// Read and write data from temporary file
			while ((line = tempReader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}

			// Close readers and writer
			reader.close();
			tempReader.close();
			writer.close();

			System.out.println("Successfully merged data into " + customer);
		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
		}
	}
}

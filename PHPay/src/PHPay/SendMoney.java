package PHPay;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendMoney extends JPanel {
	private String session;
	private static final long serialVersionUID = 1L;
	private String id;
	private double amount;
	private JLabel receiverName;
	private JLabel receiverID;
	private JLabel amountLabel;
	private JLabel fee;
	private JLabel totalAmount;
	private String amountString;
	private RoundedTextField idField, amountField;
	private RoundedPanel previewPane;
	private JLabel sendError, amountError;

	public SendMoney(String ID) {
		this.session = ID;
		setBounds(0, 0, 1205, 754);
		setLayout(null);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1205, 1500);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Send");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblNewLabel.setBounds(55, 35, 223, 81);
		gradientPanel.add(lblNewLabel);

		JLabel lblMoney = new JLabel("Money");
		lblMoney.setVerticalAlignment(SwingConstants.TOP);
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblMoney.setBounds(55, 94, 223, 137);
		gradientPanel.add(lblMoney);

		JLabel send = new JLabel("");
		send.setIcon(new ImageIcon(SendMoney.class.getResource("/PHPay/phpimg/send icon.png")));
		send.setHorizontalAlignment(SwingConstants.CENTER);
		send.setBounds(149, 22, 179, 108);
		gradientPanel.add(send);

		RoundedPanel transfer = new RoundedPanel(30);
		transfer.setLayout(null);
		transfer.setBackground(new Color(0, 0, 0, 50));
		transfer.setBounds(43, 281, 468, 350);
		gradientPanel.add(transfer);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Send to (ID)");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(46, 23, 96, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1);

		idField = new RoundedTextField(10);
		idField.setName("");
		idField.setMargin(new Insets(2, 7, 2, 7));
		idField.setForeground(Color.WHITE);
		idField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		idField.setColumns(10);
		idField.setBounds(46, 61, 376, 47);
		transfer.add(idField);
		//kini
		idField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				set();
			}

			public void set() {
				sendError.setVisible(false);

			}
		});

		amountField = new PHPay.RoundedTextField(10);
		amountField.setName("");
		amountField.setMargin(new Insets(2, 7, 2, 7));
		amountField.setForeground(Color.WHITE);
		amountField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		amountField.setColumns(10);
		amountField.setBounds(46, 191, 376, 47);
		transfer.add(amountField);
		//kini
		amountField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				set();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				set();
			}

			public void set() {
				amountError.setVisible(false);

			}
		});

		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Amount");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(46, 153, 181, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1_1);

		previewPane = new RoundedPanel(30);
		previewPane.setLayout(null);
		previewPane.setBackground(new Color(0, 0, 0, 50));
		previewPane.setBounds(622, 46, 535, 657);
		gradientPanel.add(previewPane);
		previewPane.setVisible(false);

		RoundedPanel blockPane = new RoundedPanel(30);
		blockPane.setBounds(592, -1, 615, 756);
		gradientPanel.add(blockPane);
		blockPane.setLayout(null);
		blockPane.setBackground(new Color(0, 0, 0, 50));

		receiverName = new JLabel(SQLQuery.getFullName(id));
		receiverName.setHorizontalAlignment(SwingConstants.CENTER);
		receiverName.setForeground(Color.WHITE);
		receiverName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		receiverName.setBounds(165, 181, 206, 27);
		previewPane.add(receiverName);

		JLabel lblNewLabel_1 = new JLabel("Transaction Details");
		lblNewLabel_1.setBounds(41, 260, 206, 27);
		previewPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Receiver ID:");
		lblNewLabel_1_1_2_1.setBounds(41, 320, 128, 27);
		previewPane.add(lblNewLabel_1_1_2_1);
		lblNewLabel_1_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblNewLabel_1_1 = new JLabel("Transaction Fee:");
		lblNewLabel_1_1.setBounds(41, 420, 128, 27);
		previewPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblNewLabel_1_1_2 = new JLabel("Amount to send:");
		lblNewLabel_1_1_2.setBounds(41, 367, 128, 27);
		previewPane.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		receiverID = new JLabel("123123123");
		receiverID.setHorizontalAlignment(SwingConstants.RIGHT);
		receiverID.setBounds(362, 320, 128, 27);
		previewPane.add(receiverID);
		receiverID.setForeground(Color.LIGHT_GRAY);
		receiverID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		fee = new JLabel("123,123");
		fee.setHorizontalAlignment(SwingConstants.RIGHT);
		fee.setBounds(362, 420, 128, 27);
		previewPane.add(fee);
		fee.setForeground(Color.LIGHT_GRAY);
		fee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		amountLabel = new JLabel("1239178651");
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLabel.setBounds(362, 367, 128, 27);
		previewPane.add(amountLabel);
		amountLabel.setForeground(Color.LIGHT_GRAY);
		amountLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		RoundedPanel transfer_2 = new RoundedPanel(35);
		transfer_2.setBounds(182, 89, 172, 71);
		previewPane.add(transfer_2);
		transfer_2.setLayout(null);
		transfer_2.setBackground(new Color(128, 0, 255, 100));

		JLabel receiverInitials = new JLabel("CJ");
		receiverInitials.setBounds(26, 0, 110, 71);
		transfer_2.add(receiverInitials);
		receiverInitials.setHorizontalAlignment(SwingConstants.CENTER);
		receiverInitials.setForeground(Color.WHITE);
		receiverInitials.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 35));
		receiverInitials.setBackground(Color.WHITE);

		JLabel lblNewLabel_1_4 = new JLabel("You are sending to");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1_4.setBounds(41, 29, 206, 27);
		previewPane.add(lblNewLabel_1_4);

		JPanel transfer_2_1 = new JPanel();
		transfer_2_1.setLayout(null);
		transfer_2_1.setBackground(new Color(58, 0, 117));
		transfer_2_1.setBounds(0, 476, 535, 71);
		previewPane.add(transfer_2_1);

		totalAmount = new JLabel("1239178651");
		totalAmount.setBounds(336, 22, 153, 27);
		transfer_2_1.add(totalAmount);
		totalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		totalAmount.setForeground(new Color(255, 255, 255));
		totalAmount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Total Amount:");
		lblNewLabel_1_1_2_1_1.setBounds(41, 22, 162, 27);
		transfer_2_1.add(lblNewLabel_1_1_2_1_1);
		lblNewLabel_1_1_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		RoundedButton confirmButton = new RoundedButton("OK");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SendMoney.this);

				if (frame != null) {
					frame.dispose();
				}

				Proceed proceed = new Proceed("Processing", getSession(), true, true);
				proceed.setVisible(true);
				SQLQuery.sendMoney(ID, id, amount);

			}
		});
		confirmButton.setText("Confirm");
		confirmButton.setIconTextGap(1);
		confirmButton.setForeground(UIManager.getColor("ScrollBar.background"));
		confirmButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		confirmButton.setAlignmentY(0.0f);
		confirmButton.setBounds(201, 598, 130, 34);
		previewPane.add(confirmButton);
		confirmButton.setEnabled(false);

		RoundedCheckBox confirmBox = new RoundedCheckBox("");
		confirmBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmBox.isSelected()) {
					confirmButton.setEnabled(true);
				} else {
					confirmButton.setEnabled(false);
				}
			}
		});
		confirmBox.setHorizontalAlignment(SwingConstants.CENTER);
		confirmBox.setText("I confirm that the details are correct");
		confirmBox.setSize(new Dimension(3, 3));
		confirmBox.setPreferredSize(new Dimension(33, 33));
		confirmBox.setForeground(Color.WHITE);
		confirmBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		confirmBox.setBackground(Color.WHITE);
		confirmBox.setBounds(157, 565, 221, 23);
		previewPane.add(confirmBox);

		Timer status = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (SQLQuery.getStatus(ID) == false)
					confirmBox.setEnabled(false);
				else
					confirmBox.setEnabled(true);
			}
		});
		status.start();

		JLabel lblNewLabel_1_4_1 = new JLabel("Please fill in the fields");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1_4_1.setBounds(187, 229, 206, 27);
		gradientPanel.add(lblNewLabel_1_4_1);

		RoundedButton nextButton = new RoundedButton("OK");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean idEdited, amountEdited = false;

				amountString = amountField.getText();

				id = idField.getText();

				if (SQLQuery.IDExists(id)) {
					idEdited = true;
					sendError.setVisible(false);
				}
				else {
					idEdited = false;
					sendError.setVisible(true);
				}

				if (isNumeric(amountString)) {
					amount = Double.parseDouble(amountString);
					if (amount * 1.03 <= SQLQuery.getBalance(ID)) {
						amountEdited = true;
					}
				} else
					amountEdited = false;

				if (idEdited && amountEdited) {
					setPreview();
					previewPane.setVisible(true);

				} else
					System.out.println("failed");

			}
		});
		nextButton.setText("Next");
		nextButton.setIconTextGap(1);
		nextButton.setForeground(UIManager.getColor("ScrollBar.background"));
		nextButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		nextButton.setAlignmentY(0.0f);
		nextButton.setBounds(169, 271, 130, 34);
		transfer.add(nextButton);
		
		sendError = new JLabel("ID does not exist");
		sendError.setVisible(false);
		sendError.setVerticalAlignment(SwingConstants.BOTTOM);
		sendError.setHorizontalAlignment(SwingConstants.LEFT);
		sendError.setForeground(new Color(255, 0, 0));
		sendError.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		sendError.setBounds(45, 109, 119, 18);
		transfer.add(sendError);
		
		amountError = new JLabel("ID does not exist");
		amountError.setVisible(false);
		amountError.setVerticalAlignment(SwingConstants.BOTTOM);
		amountError.setHorizontalAlignment(SwingConstants.LEFT);
		amountError.setForeground(Color.RED);
		amountError.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		amountError.setBounds(46, 239, 119, 18);
		transfer.add(amountError);

	}

	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}

		try {
			double value = Double.parseDouble(str);
			if (value == (int) value && value > 0) {
				return true;
			}
		} catch (NumberFormatException e) {
		}

		return false;
	}

	private void setPreview() {
		double doubleFee = (double) Math.round((amount * 0.03) * 100) / 100;

		receiverName.setText(SQLQuery.getFullName(id));
		receiverID.setText(id);
		amountLabel.setText("₱ " + amountString);
		fee.setText("₱ " + Double.toString(doubleFee));
		totalAmount.setText("₱ " + Double.toString(amount + doubleFee));

	}

	public String getSession() {
		return session;
	}

	public void reset() {
		previewPane.setVisible(false);
		idField.setText("");
		amountField.setText("");
	}

}

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

public class CashIn extends JPanel {
	private String session;
	private static final long serialVersionUID = 1L;
	private double amount;
	private JLabel receiverID;
	private JLabel amountLabel, amountError;
	private JLabel totalAmount;
	private String amountString;
	private RoundedTextField amountField;
	private RoundedPanel previewPane;

	public CashIn(String ID) {
		this.session = ID;
		setBounds(0, 0, 1205, 754);
		setLayout(null);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1205, 1500);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cash In");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblNewLabel.setBounds(55, 35, 218, 81);
		gradientPanel.add(lblNewLabel);

		JLabel send = new JLabel("");
		send.setIcon(new ImageIcon(CashIn.class.getResource("/PHPay/phpimg/cash in icon.png")));
		send.setHorizontalAlignment(SwingConstants.CENTER);
		send.setBounds(226, 31, 129, 112);
		gradientPanel.add(send);

		RoundedPanel transfer = new RoundedPanel(30);
		transfer.setLayout(null);
		transfer.setBackground(new Color(0, 0, 0, 50));
		transfer.setBounds(43, 281, 468, 350);
		gradientPanel.add(transfer);

		amountField = new PHPay.RoundedTextField(10);
		amountField.setName("");
		amountField.setMargin(new Insets(2, 7, 2, 7));
		amountField.setForeground(Color.WHITE);
		amountField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		amountField.setColumns(10);
		amountField.setBounds(47, 153, 376, 47);
		transfer.add(amountField);

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
		
		amountError = new JLabel("Invalid Amount");
		amountError.setVisible(false);
		amountError.setVerticalAlignment(SwingConstants.BOTTOM);
		amountError.setHorizontalAlignment(SwingConstants.LEFT);
		amountError.setForeground(Color.RED);
		amountError.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		amountError.setBounds(47, 204, 119, 18);
		transfer.add(amountError);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Amount");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(47, 116, 97, 27);
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

		JLabel lblNewLabel_1_1_2 = new JLabel("Amount to cash-in:");
		lblNewLabel_1_1_2.setBounds(41, 367, 152, 27);
		previewPane.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		receiverID = new JLabel("123123123");
		receiverID.setHorizontalAlignment(SwingConstants.RIGHT);
		receiverID.setBounds(362, 320, 128, 27);
		previewPane.add(receiverID);
		receiverID.setForeground(Color.LIGHT_GRAY);
		receiverID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		amountLabel = new JLabel("1239178651");
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLabel.setBounds(362, 367, 128, 27);
		previewPane.add(amountLabel);
		amountLabel.setForeground(Color.LIGHT_GRAY);
		amountLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

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

				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CashIn.this);

				if (frame != null) {
					frame.dispose();
				}

				Proceed proceed = new Proceed("Processing", getSession(), false, false);
				proceed.setVisible(true);
				SQLQuery.cashIn(ID, amount);

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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CashIn.class.getResource("/PHPay/phpimg/PHPAY-BRAND-LARGE.png")));
		lblNewLabel_2.setBounds(26, 76, 486, 113);
		previewPane.add(lblNewLabel_2);

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

				boolean amountEdited = false;

				amountString = amountField.getText();
				
				if (!amountString.isEmpty()) {
					if (isNumeric(amountString)) {
						amount = Double.parseDouble(amountString);
						if (amount >= 0) {
							amountEdited = true;
							amountError.setVisible(false);
						}
					} else {
						amountEdited = false;
						amountError.setVisible(true);
					}
					
					if (amountEdited) {
						setPreview();
						previewPane.setVisible(true);
					}
				}

			}
		});
		nextButton.setText("Next");
		nextButton.setIconTextGap(1);
		nextButton.setForeground(UIManager.getColor("ScrollBar.background"));
		nextButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		nextButton.setAlignmentY(0.0f);
		nextButton.setBounds(169, 271, 130, 34);
		transfer.add(nextButton);

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

		receiverID.setText(session);
		amountLabel.setText("₱ " + amountString);
		totalAmount.setText("₱ " + Double.toString(amount));

	}

	public String getSession() {
		return session;
	}

	public void reset() {
		previewPane.setVisible(false);
		amountField.setText("");
	}
}

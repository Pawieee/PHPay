package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import PHPay.SignUp.CustomComboBoxUI;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.UIManager;

public class BuyLoad extends JPanel {
	private static final long serialVersionUID = 1L;
	private String session;
	private RoundedTextField numField;
	private RoundedComboBox telcoBox;
	private String number;
	private String telco;
	private RoundedComboBox numberType;
	private RoundedTextField amountField;
	private String type;
	private String amountString;
	private double amount;
	private RoundedPanel previewPane;
	private JLabel receiverLabel;
	private JLabel amountLabel;
	private JLabel fee;
	private JLabel totalAmount;

//	private RoundedPanel previewPane;

	public BuyLoad(String ID) {
		this.session = ID;

		this.session = ID;
		setBounds(0, 0, 1205, 754);
		setLayout(null);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1205, 1500);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Buy");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblNewLabel.setBounds(55, 35, 114, 81);
		gradientPanel.add(lblNewLabel);

		JLabel lblMoney = new JLabel("Load");
		lblMoney.setVerticalAlignment(SwingConstants.TOP);
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblMoney.setBounds(55, 94, 223, 137);
		gradientPanel.add(lblMoney);

		JLabel lblNewLabel_1_4_1 = new JLabel("Please fill in the fields");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1_4_1.setBounds(188, 199, 206, 27);
		gradientPanel.add(lblNewLabel_1_4_1);

		previewPane = new RoundedPanel(30);
		previewPane.setLayout(null);
		previewPane.setBackground(new Color(0, 0, 0, 50));
		previewPane.setBounds(622, 46, 535, 657);
		gradientPanel.add(previewPane);
		previewPane.setVisible(false);

		RoundedPanel blockPane = new RoundedPanel(30);
		blockPane.setLayout(null);
		blockPane.setBackground(new Color(0, 0, 0, 50));
		blockPane.setBounds(590, 0, 615, 756);
		gradientPanel.add(blockPane);

		RoundedPanel transfer = new RoundedPanel(30);
		transfer.setLayout(null);
		transfer.setBackground(new Color(0, 0, 0, 50));
		transfer.setBounds(44, 251, 468, 452);
		gradientPanel.add(transfer);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Buy load for");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(46, 23, 181, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1);

		numField = new PHPay.RoundedTextField(10);
		numField.setName("");
		numField.setMargin(new Insets(2, 7, 2, 7));
		numField.setForeground(Color.WHITE);
		numField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		numField.setColumns(10);
		numField.setBounds(107, 61, 315, 47);
		transfer.add(numField);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Telecommunications");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(46, 270, 181, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1_1);

		RoundedButton nextButton = new RoundedButton("OK");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean numEdited = false, telcoEdited = false, amountEdited = false;

				number = numField.getText();
				amountString = amountField.getText();
				amount = Double.parseDouble(amountString);
				telco = (String) telcoBox.getSelectedItem();
				type = (String) numberType.getSelectedItem();

				if (isNumber(number)) {
					if (number.length() == 10) {
						numEdited = true;
						System.out.println("num");
					} else {
						numEdited = false;
					}
				} else {
					numEdited = false;
				}

				if (isNumeric(amountString)) {
					if (amount * 1.03 <= SQLQuery.getBalance(ID)) {
						amountEdited = true;
					} else {
						amountEdited = false;
					}
				} else {
					amountEdited = false;
				}

				if (!telco.equals(" ")) {
					telcoEdited = true;
				} else {
					telcoEdited = false;
				}

				if (numEdited && amountEdited && telcoEdited) {
					setPreview();
					previewPane.setVisible(true);
				}

//				SQLQuery.load(ID, amountDouble, num);

			}
		});
		nextButton.setText("Next");
		nextButton.setIconTextGap(1);
		nextButton.setForeground(UIManager.getColor("ScrollBar.background"));
		nextButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		nextButton.setAlignmentY(0.0f);
		nextButton.setBounds(169, 386, 130, 34);
		transfer.add(nextButton);

		String[] type = { "+63" };

		numberType = new RoundedComboBox<>(type);
		numberType.setMaximumRowCount(6);
		numberType.setBounds(46, 61, 51, 47);
		transfer.add(numberType);
		numberType.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		numberType.setBackground(new Color(27, 0, 53));
		numberType.setForeground(new Color(255, 255, 255));
		numberType.setUI(new CustomComboBoxUI());

		JLabel lblNewLabel_1 = new JLabel("Transaction Details");
		lblNewLabel_1.setBounds(41, 45, 206, 27);
		previewPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Mobile Number:");
		lblNewLabel_1_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(41, 97, 128, 27);
		previewPane.add(lblNewLabel_1_1_2_1);

		receiverLabel = new JLabel("123123123");
		receiverLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		receiverLabel.setForeground(Color.LIGHT_GRAY);
		receiverLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		receiverLabel.setBounds(362, 97, 128, 27);
		previewPane.add(receiverLabel);

		amountLabel = new JLabel("1239178651");
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLabel.setForeground(Color.LIGHT_GRAY);
		amountLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		amountLabel.setBounds(362, 144, 128, 27);
		previewPane.add(amountLabel);

		JLabel lblNewLabel_1_1_2 = new JLabel("Amount to send:");
		lblNewLabel_1_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(41, 144, 128, 27);
		previewPane.add(lblNewLabel_1_1_2);

		fee = new JLabel("123,123");
		fee.setHorizontalAlignment(SwingConstants.RIGHT);
		fee.setForeground(Color.LIGHT_GRAY);
		fee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		fee.setBounds(362, 197, 128, 27);
		previewPane.add(fee);

		JLabel lblNewLabel_1_1 = new JLabel("Transaction Fee:");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(41, 197, 128, 27);
		previewPane.add(lblNewLabel_1_1);

		JPanel transfer_2_1 = new JPanel();
		transfer_2_1.setLayout(null);
		transfer_2_1.setBackground(new Color(58, 0, 117));
		transfer_2_1.setBounds(0, 476, 535, 71);
		previewPane.add(transfer_2_1);

		totalAmount = new JLabel("1239178651");
		totalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		totalAmount.setForeground(Color.WHITE);
		totalAmount.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		totalAmount.setBounds(336, 22, 153, 27);
		transfer_2_1.add(totalAmount);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Total Amount:");
		lblNewLabel_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1_1.setBounds(41, 22, 162, 27);
		transfer_2_1.add(lblNewLabel_1_1_2_1_1);

		String[] telco = { "Globe", "Smart", "Talk N Text", "DITO", "GOMO", " " };

		telcoBox = new RoundedComboBox<>(telco);
		telcoBox.setMaximumRowCount(6);
		telcoBox.setBounds(46, 308, 376, 47);
		transfer.add(telcoBox);
		telcoBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		telcoBox.setBackground(new Color(27, 0, 53));
		telcoBox.setForeground(new Color(255, 255, 255));
		telcoBox.setSelectedItem(" ");
		telcoBox.setUI(new CustomComboBoxUI());

		RoundedButton confirmButton = new RoundedButton("OK");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(BuyLoad.this);

				if (frame != null) {
					frame.dispose();
				}

				dispose();
				Proceed proceed = new Proceed("Processing", getSession());
				proceed.setVisible(true);
				SQLQuery.load(ID, amount, number);

			}

			private void dispose() {

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
					confirmButton.setEnabled(true);
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

		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("Amount");
		lblNewLabel_1_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(46, 141, 181, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1_2);

		amountField = new PHPay.RoundedTextField(10);
		amountField.setName("");
		amountField.setMargin(new Insets(2, 7, 2, 7));
		amountField.setForeground(Color.WHITE);
		amountField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		amountField.setColumns(10);
		amountField.setBounds(46, 179, 376, 47);
		transfer.add(amountField);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(BuyLoad.class.getResource("/PHPay/phpimg/load.png")));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblNewLabel_11.setBounds(164, 35, 114, 81);
		gradientPanel.add(lblNewLabel_11);
		telcoBox.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				if (telcoBox.getItemCount() >= 6) {
					telcoBox.removeItemAt(5);
				}
				telcoBox.setSelectedItem("Globe");

			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
		});

	}

	protected String getSession() {
		return session;
	}

	private void setPreview() {
		double doubleFee = amount * 0.03;
		String completNum = (type + "" + number);

		receiverLabel.setText(completNum);
		amountLabel.setText("₱ " + amountString);
		fee.setText("₱ " + Double.toString(doubleFee));
		totalAmount.setText("₱ " + Double.toString(amount + doubleFee));

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

	public static boolean isNumber(String str) {
		try {
			Long.parseLong(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public class CustomComboBoxUI extends BasicComboBoxUI {
		@Override
		protected JButton createArrowButton() {
			return new JButton() {
				private static final long serialVersionUID = 1L;

				@Override
				public int getWidth() {
					return 0;
				}
			};
		}

		@Override
		protected ComboPopup createPopup() {
			return new BasicComboPopup(comboBox) {
				private static final long serialVersionUID = 1L;

				@Override
				protected JScrollPane createScroller() {
					JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
							JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					scroller.getViewport().setBackground(comboBox.getBackground());

					scroller.addMouseWheelListener(new MouseWheelListener() {
						@Override
						public void mouseWheelMoved(MouseWheelEvent e) {
							JScrollBar verticalScrollBar = scroller.getVerticalScrollBar();
							int units = e.getUnitsToScroll();
							int extent = verticalScrollBar.getBlockIncrement(1) / 5;

							int currentValue = verticalScrollBar.getValue();
							verticalScrollBar.setValue(currentValue + units * extent);
						}
					});

					return scroller;
				}
			};
		}

		@Override
		protected void installDefaults() {
			super.installDefaults();
			comboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		}
	}

	public void reset() {
		previewPane.setVisible(false);
		numField.setText("");
		amountField.setText("");
	}

}

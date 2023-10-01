package PHPay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class CashOut extends JPanel {
	private String choice;
	private static final long serialVersionUID = 1L;
	private double amount;
	private JLabel receiverID;
	private JLabel amountLabel;
	private JLabel fee;
	private JLabel totalAmount;
	private String amountString;
	private RoundedTextField amountField;
	private RoundedPanel previewPane;
	private JLabel billerLabel;
	private RoundedPanel transfer;

	private RoundedComboBox<String> convenienceBox;
	private RoundedComboBox<String> remmitanceBox;
	private RoundedComboBox<String> supermarketBox;
	private RoundedComboBox<String> departmentBox;

	private JComboBox<String> getBox;

	public CashOut(String ID) {
		setBounds(0, 0, 1205, 754);
		setLayout(null);

		GradientPanel gradientPanel = new GradientPanel(new Color(0x360079), new Color((0x000000)));
		gradientPanel.setBounds(0, 0, 1205, 1500);
		gradientPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradientPanel.setPreferredSize(new Dimension(1200, 1220));
		add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cash Out");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 55));
		lblNewLabel.setBounds(55, 35, 257, 81);
		gradientPanel.add(lblNewLabel);

		JLabel send = new JLabel("");
		send.setIcon(new ImageIcon(CashOut.class.getResource("/PHPay/phpimg/withdrawal.png")));
		send.setHorizontalAlignment(SwingConstants.CENTER);
		send.setBounds(249, 28, 179, 108);
		gradientPanel.add(send);

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
		lblNewLabel_1.setBounds(41, 257, 206, 27);
		previewPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Receiver ID:");
		lblNewLabel_1_1_2_1.setBounds(41, 310, 128, 27);
		previewPane.add(lblNewLabel_1_1_2_1);
		lblNewLabel_1_1_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblNewLabel_1_1 = new JLabel("Transaction Fee:");
		lblNewLabel_1_1.setBounds(41, 410, 128, 27);
		previewPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblNewLabel_1_1_2 = new JLabel("Amount to send:");
		lblNewLabel_1_1_2.setBounds(41, 357, 128, 27);
		previewPane.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JPanel transfer_2_1 = new JPanel();
		transfer_2_1.setLayout(null);
		transfer_2_1.setBackground(new Color(58, 0, 117));
		transfer_2_1.setBounds(0, 473, 535, 71);
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
		lblNewLabel_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_2_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

		receiverID = new JLabel("123123123");
		receiverID.setHorizontalAlignment(SwingConstants.RIGHT);
		receiverID.setBounds(362, 310, 128, 27);
		previewPane.add(receiverID);
		receiverID.setForeground(Color.LIGHT_GRAY);
		receiverID.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		fee = new JLabel("123,123");
		fee.setHorizontalAlignment(SwingConstants.RIGHT);
		fee.setBounds(362, 410, 128, 27);
		previewPane.add(fee);
		fee.setForeground(Color.LIGHT_GRAY);
		fee.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		amountLabel = new JLabel("1239178651");
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLabel.setBounds(362, 357, 128, 27);
		previewPane.add(amountLabel);
		amountLabel.setForeground(Color.LIGHT_GRAY);
		amountLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		transfer = new RoundedPanel(30);
		transfer.setLayout(null);
		transfer.setBackground(new Color(0, 0, 0, 50));
		transfer.setBounds(46, 174, 468, 562);
		gradientPanel.add(transfer);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Amount");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(46, 398, 87, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		billerLabel = new JLabel("Biller");
		billerLabel.setBounds(46, 305, 87, 27);
		transfer.add(billerLabel);
		billerLabel.setForeground(Color.WHITE);
		billerLabel.setVisible(false);
		billerLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		amountField = new RoundedTextField(10);
		amountField.setBounds(46, 433, 376, 47);
		transfer.add(amountField);
		amountField.setName("");
		amountField.setMargin(new Insets(2, 7, 2, 7));
		amountField.setForeground(Color.WHITE);
		amountField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		amountField.setColumns(10);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Over the Counter");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(143, 20, 181, 27);
		transfer.add(lblNewLabel_1_1_1_1_1_1);

		RoundedButton remmitanceButton = new RoundedButton("");
		remmitanceButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				remmitanceButton.setBounds(298, 57, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				remmitanceButton.setBounds(299, 58, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				remmitanceButton.setBounds(299, 58, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				remmitanceButton.setBounds(298, 57, 72, 72);
			}
		});
		remmitanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(remmitanceBox);
			}
		});
		remmitanceButton.setIcon(new ImageIcon(CashOut.class.getResource("/PHPay/phpimg/remmitance.png")));
		remmitanceButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		remmitanceButton.setBounds(299, 58, 70, 70);
		transfer.add(remmitanceButton);

		RoundedButton supermarketButton = new RoundedButton("");
		supermarketButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				supermarketButton.setBounds(79, 183, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				supermarketButton.setBounds(80, 184, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				supermarketButton.setBounds(80, 184, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				supermarketButton.setBounds(79, 183, 72, 72);
			}
		});
		supermarketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				showNext(supermarketBox);
			}
		});
		supermarketButton.setIcon(new ImageIcon(CashOut.class.getResource("/PHPay/phpimg/supermarket.png")));
		supermarketButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		supermarketButton.setBounds(80, 184, 70, 70);
		transfer.add(supermarketButton);

		RoundedButton departmentButton = new RoundedButton("");
		departmentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				departmentButton.setBounds(298, 183, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				departmentButton.setBounds(299, 184, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				departmentButton.setBounds(299, 184, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				departmentButton.setBounds(298, 183, 72, 72);
			}
		});
		departmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(departmentBox);
			}
		});
		departmentButton.setIcon(new ImageIcon(CashOut.class.getResource("/PHPay/phpimg/department.png")));
		departmentButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		departmentButton.setBounds(299, 184, 70, 70);
		transfer.add(departmentButton);

		RoundedButton convenienceButton = new RoundedButton("");
		convenienceButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				convenienceButton.setBounds(79, 57, 72, 72);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				convenienceButton.setBounds(80, 58, 70, 70);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				convenienceButton.setBounds(80, 58, 70, 70);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				convenienceButton.setBounds(79, 57, 72, 72);
			}
		});
		convenienceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext(convenienceBox);

			}
		});
		convenienceButton.setIcon(new ImageIcon(CashOut.class.getResource("/PHPay/phpimg/convenience.png")));
		convenienceButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		convenienceButton.setBounds(80, 58, 70, 70);
		transfer.add(convenienceButton);

		JLabel lblNewLabel_2 = new JLabel("Convenience Store");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(37, 136, 158, 27);
		transfer.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Remmitance Center");
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(257, 136, 153, 27);
		transfer.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Supermarket");
		lblNewLabel_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(49, 262, 133, 27);
		transfer.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Department Store");
		lblNewLabel_2_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(266, 262, 137, 27);
		transfer.add(lblNewLabel_2_1_2);

		RoundedCheckBox confirmBox = new RoundedCheckBox("");
		confirmBox.setText("I confirm that the details are correct");
		confirmBox.setSize(new Dimension(3, 3));
		confirmBox.setPreferredSize(new Dimension(33, 33));
		confirmBox.setHorizontalAlignment(SwingConstants.CENTER);
		confirmBox.setForeground(Color.WHITE);
		confirmBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		confirmBox.setBackground(Color.WHITE);
		confirmBox.setBounds(157, 565, 221, 23);
		previewPane.add(confirmBox);

		RoundedButton confirmButton = new RoundedButton("OK");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CashOut.this);

				if (frame != null) {
					frame.dispose();
				}

				Proceed proceed = new Proceed("Processing", ID, true);
				proceed.setVisible(true);
				SQLQuery.payBills(ID, amount, choice);
			}
		});
		confirmButton.setText("Confirm");
		confirmButton.setIconTextGap(1);
		confirmButton.setForeground(UIManager.getColor("ScrollBar.background"));
		confirmButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		confirmButton.setEnabled(false);
		confirmButton.setAlignmentY(0.0f);
		confirmButton.setBounds(202, 598, 130, 34);
		previewPane.add(confirmButton);

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(CashOut.class.getResource("/PHPay/phpimg/PHPAY-BRAND-LARGE.png")));
		lblNewLabel_2_2.setBounds(26, 76, 486, 113);
		previewPane.add(lblNewLabel_2_2);

		String[] convenienceChoices = { "7-11", "Central Convenience", "MINISTOP", };

		convenienceBox = new RoundedComboBox<>(convenienceChoices);
		convenienceBox.setBounds(46, 338, 376, 47);
		convenienceBox.setMaximumRowCount(6);
		convenienceBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		convenienceBox.setBackground(new Color(27, 0, 53));
		convenienceBox.setForeground(new Color(255, 255, 255));
		convenienceBox.setVisible(false);
		convenienceBox.setUI(new CustomComboBoxUI());
		transfer.add(convenienceBox);

		String[] remmitanceChoices = { "Cebuana Lhuillier", "RD Pawnshop", "Villarica Pawnshop", };

		remmitanceBox = new RoundedComboBox<>(remmitanceChoices);
		remmitanceBox.setBounds(46, 338, 376, 47);
		remmitanceBox.setMaximumRowCount(6);
		remmitanceBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		remmitanceBox.setBackground(new Color(27, 0, 53));
		remmitanceBox.setForeground(new Color(255, 255, 255));
		remmitanceBox.setVisible(false);
		remmitanceBox.setUI(new CustomComboBoxUI());
		transfer.add(remmitanceBox);

		String[] supermarketChoices = { "Puregold" };

		supermarketBox = new RoundedComboBox<>(supermarketChoices);
		supermarketBox.setBounds(46, 338, 376, 47);
		supermarketBox.setMaximumRowCount(6);
		supermarketBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		supermarketBox.setBackground(new Color(27, 0, 53));
		supermarketBox.setForeground(new Color(255, 255, 255));
		supermarketBox.setVisible(false);
		supermarketBox.setUI(new CustomComboBoxUI());
		transfer.add(supermarketBox);

		String[] departmentChoices = { "SM Store", "Robinsons", };

		departmentBox = new RoundedComboBox<>(departmentChoices);
		departmentBox.setBounds(46, 338, 376, 47);
		departmentBox.setMaximumRowCount(6);
		departmentBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		departmentBox.setBackground(new Color(27, 0, 53));
		departmentBox.setForeground(new Color(255, 255, 255));
		departmentBox.setVisible(false);
		departmentBox.setUI(new CustomComboBoxUI());
		transfer.add(departmentBox);

		RoundedButton nextButton = new RoundedButton("OK");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choice = (String) getBox.getSelectedItem();

				if (!(choice == null) || !choice.isEmpty()) {

					amountString = amountField.getText();

					boolean amountEdited = false;

					if (isNumeric(amountString)) {
						amount = Double.parseDouble(amountString);
						if (amount * 1.03 <= SQLQuery.getBalance(ID)) {
							amountEdited = true;
						}
					} else
						amountEdited = false;

					if (amountEdited) {
						setPreview(choice);
						previewPane.setVisible(true);

					} else
						System.out.println("failed");
				}

			}
		});
		nextButton.setText("Next");
		nextButton.setIconTextGap(1);
		nextButton.setForeground(UIManager.getColor("ScrollBar.background"));
		nextButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		nextButton.setAlignmentY(0.0f);
		nextButton.setBounds(159, 502, 130, 34);
		transfer.add(nextButton);

	}

	@SuppressWarnings("unchecked")
	public void showNext(@SuppressWarnings("rawtypes") JComboBox box) {
		billerLabel.setVisible(true);
		convenienceBox.setVisible(false);
		remmitanceBox.setVisible(false);
		supermarketBox.setVisible(false);
		departmentBox.setVisible(false);

		box.setVisible(true);
		getBox = box;
	}

	private void setPreview(String choice) {
		double doubleFee = (double) Math.round((amount * 0.03) * 100) / 100;

		receiverID.setText(choice);
		amountLabel.setText("₱ " + amountString);
		fee.setText("₱ " + Double.toString(doubleFee));
		totalAmount.setText("₱ " + Double.toString(amount + doubleFee));

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

	public void reset() {
		previewPane.setVisible(false);
		amountField.setText("");
	}
}

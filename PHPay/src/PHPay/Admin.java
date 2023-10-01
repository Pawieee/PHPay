package PHPay;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class Admin {

	private JFrame frmPhpayAdministrator;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField message;
	private JTextField id;
	private int index = 0;
	private JTextField accToDisable;
	private JButton disable;
	private JTextField textField;
	private JLabel idLabel;
	private JButton acceptButton, declineButton;
	private JButton statsButton;
	private JLabel totalCurrency;
	private JLabel totalCurrency_1;
	private JLabel totalActivity;
	private JLabel frequentType;
	private JLabel l3;
	private JLabel biggestTransaction;
	private JLabel l4;
	private JButton btnLogOut;
	private int x, y;
	private JLabel dashboard;
	private JSeparator separator_1;
	private JLabel lblUserId;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatLightFlatIJTheme.setup();
					Admin window = new Admin();
					window.frmPhpayAdministrator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin() {
		initialize();
	}

	private void initialize() {
		frmPhpayAdministrator = new JFrame();
		frmPhpayAdministrator.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/PHPay/phpimg/PHPAY-BRAND-ICON2.png")));
		frmPhpayAdministrator.setTitle("PHPay  (Administrator)");
		frmPhpayAdministrator.setBounds(100, 100, 1241, 553);
		frmPhpayAdministrator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhpayAdministrator.getContentPane().setLayout(null);
		frmPhpayAdministrator.setLocationRelativeTo(null);
		frmPhpayAdministrator.setResizable(false);
		frmPhpayAdministrator.setUndecorated(true);
		
		dashboard = new JLabel("Dashboard");
		dashboard.setVerticalAlignment(SwingConstants.TOP);
		dashboard.setForeground(new Color(51, 51, 51));
		dashboard.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		dashboard.setBounds(194, 102, 555, 72);
		frmPhpayAdministrator.getContentPane().add(dashboard);

		totalActivity = new JLabel("123123123");
		totalActivity.setVerticalAlignment(SwingConstants.TOP);
		totalActivity.setForeground(new Color(51, 51, 51));
		totalActivity.setFont(new Font("Segoe UI Semibold", Font.BOLD, 45));
		totalActivity.setBounds(712, 344, 555, 85);
		frmPhpayAdministrator.getContentPane().add(totalActivity);

		biggestTransaction = new JLabel("10,000,000,000");
		biggestTransaction.setVerticalAlignment(SwingConstants.TOP);
		biggestTransaction.setForeground(new Color(51, 51, 51));
		biggestTransaction.setFont(new Font("Segoe UI Semibold", Font.BOLD, 45));
		biggestTransaction.setBounds(228, 344, 555, 85);
		frmPhpayAdministrator.getContentPane().add(biggestTransaction);

		l4 = new JLabel("Biggest Value Transaction");
		l4.setForeground(new Color(51, 51, 51));
		l4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		l4.setBounds(218, 315, 304, 39);
		frmPhpayAdministrator.getContentPane().add(l4);

		JLabel l2 = new JLabel("Total Record of All Activity");
		l2.setForeground(new Color(51, 51, 51));
		l2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		l2.setBounds(702, 315, 304, 39);
		frmPhpayAdministrator.getContentPane().add(l2);

		JLabel l1 = new JLabel("Total Currency in Circulation");
		l1.setForeground(new Color(51, 51, 51));
		l1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		l1.setBounds(218, 175, 304, 39);
		frmPhpayAdministrator.getContentPane().add(l1);

		totalCurrency = new JLabel("123123123");
		totalCurrency.setVerticalAlignment(SwingConstants.TOP);
		totalCurrency.setForeground(new Color(51, 51, 51));
		totalCurrency.setFont(new Font("Segoe UI Semibold", Font.BOLD, 45));
		totalCurrency.setBounds(228, 204, 555, 85);
		frmPhpayAdministrator.getContentPane().add(totalCurrency);

		frequentType = new JLabel("123123123");
		frequentType.setVerticalAlignment(SwingConstants.TOP);
		frequentType.setForeground(new Color(51, 51, 51));
		frequentType.setFont(new Font("Segoe UI Semibold", Font.BOLD, 45));
		frequentType.setBounds(712, 204, 521, 85);
		frmPhpayAdministrator.getContentPane().add(frequentType);

		l3 = new JLabel("Frequently Service Used");
		l3.setForeground(new Color(51, 51, 51));
		l3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		l3.setBounds(702, 175, 304, 39);
		frmPhpayAdministrator.getContentPane().add(l3);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(164, 76, 1032, 393);
		frmPhpayAdministrator.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		JLabel lblDashboard = new JLabel("");
		lblDashboard.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		lblDashboard.setBounds(206, 26, 304, 39);
		frmPhpayAdministrator.getContentPane().add(lblDashboard);

		RoundedButton prev = new RoundedButton("<");
		prev.setFont(new Font("Tahoma", Font.BOLD, 11));
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String[]> tickets = SQLQuery.getTickets();

				if (index > 0) {

					index--;
					id.setText(tickets.get(index)[0]);

					message.setText(tickets.get(index)[1]);
				}
			}
		});
		prev.setBounds(0, 199, 62, 21);
		panel.add(prev);

		RoundedButton next = new RoundedButton(">");
		next.setFont(new Font("Tahoma", Font.BOLD, 11));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String[]> tickets = SQLQuery.getTickets();

				int size = tickets.size();
				if (index < size - 1) {

					index++;
					id.setText(tickets.get(index)[0]);

					message.setText(tickets.get(index)[1]);
				}
			}
		});
		next.setBounds(970, 199, 62, 21);
		panel.add(next);

		message = new JTextField();
		message.setHorizontalAlignment(SwingConstants.LEFT);
		message.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		message.setBounds(60, 98, 910, 242);
		panel.add(message);
		message.setColumns(10);

		id = new JTextField();
		id.setEditable(false);
		id.setBounds(118, 31, 110, 32);
		panel.add(id);
		id.setColumns(10);
		
		lblUserId = new JLabel("User ID");
		lblUserId.setVerticalAlignment(SwingConstants.TOP);
		lblUserId.setForeground(new Color(51, 51, 51));
		lblUserId.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblUserId.setBounds(61, 36, 62, 25);
		panel.add(lblUserId);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 76, 1032, 393);
		scrollPane_1.setVisible(false);
		frmPhpayAdministrator.getContentPane().add(scrollPane_1);

		disable = new JButton("Freeze");
		disable.setVisible(false);
		disable.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		disable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = accToDisable.getText();
				SQLQuery.disableUser(ID);
				accToDisable.setText("");
			}
		});

		accToDisable = new JTextField();
		accToDisable.setVisible(false);
		accToDisable.setBounds(868, 493, 217, 28);
		frmPhpayAdministrator.getContentPane().add(accToDisable);
		accToDisable.setColumns(10);
		disable.setBounds(1111, 490, 85, 32);

		JButton appealButton = new JButton("Appeals");
		appealButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		appealButton.setBounds(10, 193, 141, 40);
		appealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				disable.setVisible(false);
				accToDisable.setVisible(false);
				scrollPane_1.setVisible(false);
				acceptButton.setVisible(true);
				declineButton.setVisible(true);
				panel.setVisible(true);
				idLabel.setVisible(false);
				
				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(false);
				l4.setVisible(false);
				totalCurrency.setVisible(false);
				totalActivity.setVisible(false);
				frequentType.setVisible(false);
				biggestTransaction.setVisible(false);
				dashboard.setVisible(false);

				ArrayList<String[]> tickets = SQLQuery.getTickets();

				if (tickets.size() > 0) {
					id.setText(tickets.get(0)[0]);

					message.setText(tickets.get(0)[1]);

				} else {
					message.setText("Such empty");
				}

			}
		});
		frmPhpayAdministrator.getContentPane().add(appealButton);

		idLabel = new JLabel("User ID");
		idLabel.setVisible(false);
		idLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(783, 497, 85, 21);
		frmPhpayAdministrator.getContentPane().add(idLabel);

		textField = new JTextField();
		textField.setBounds(0, 0, 17, 0);
		frmPhpayAdministrator.getContentPane().add(textField);
		textField.setColumns(10);

		frmPhpayAdministrator.getContentPane().add(disable);

		JButton transactionButton = new JButton("Transactions");
		transactionButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSus(scrollPane_1);
				scrollPane_1.setVisible(true);
				accToDisable.setVisible(true);
				disable.setVisible(true);
				panel.setVisible(false);
				idLabel.setVisible(true);

				acceptButton.setVisible(false);
				declineButton.setVisible(false);
				
				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(false);
				l4.setVisible(false);
				totalCurrency.setVisible(false);
				totalActivity.setVisible(false);
				frequentType.setVisible(false);
				biggestTransaction.setVisible(false);
				dashboard.setVisible(false);
				

			}
		});
		transactionButton.setBounds(10, 141, 141, 40);
		frmPhpayAdministrator.getContentPane().add(transactionButton);

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setIcon(new ImageIcon(Admin.class.getResource("/PHPay/phpimg/PHPAY-BRAND BLACK.png")));
		lblNewLabel1.setBounds(0, 19, 181, 65);
		frmPhpayAdministrator.getContentPane().add(lblNewLabel1);

		JSeparator separator = new JSeparator();
		separator.setBounds(7, 76, 1226, 8);
		frmPhpayAdministrator.getContentPane().add(separator);

		// METHODS

		allAmount();
		allActivity();
		mostFrequentType();
		biggestTransaction();

		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				idLabel.setVisible(false);
				accToDisable.setVisible(false);
				acceptButton.setVisible(false);
				declineButton.setVisible(false);

				disable.setVisible(false);
				accToDisable.setVisible(false);
				scrollPane_1.setVisible(false);
				acceptButton.setVisible(false);
				declineButton.setVisible(false);
				panel.setVisible(false);
				
				l1.setVisible(true);
				l2.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				totalCurrency.setVisible(true);
				totalActivity.setVisible(true);
				frequentType.setVisible(true);
				biggestTransaction.setVisible(true);
				dashboard.setVisible(true);

			}
		});
		homeButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		homeButton.setBounds(10, 90, 141, 40);
		frmPhpayAdministrator.getContentPane().add(homeButton);

		acceptButton = new JButton("Accept");
		acceptButton.setVisible(false);
		acceptButton.setBounds(966, 490, 110, 32);
		frmPhpayAdministrator.getContentPane().add(acceptButton);
		acceptButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		declineButton = new JButton("Decline");
		declineButton.setVisible(false);
		declineButton.setBounds(1086, 490, 110, 32);
		frmPhpayAdministrator.getContentPane().add(declineButton);
		declineButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));

		statsButton = new JButton("Stats");
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSus1(scrollPane_1);
				scrollPane_1.setVisible(true);
				accToDisable.setVisible(true);
				disable.setVisible(true);
				panel.setVisible(false);
				idLabel.setVisible(true);

				acceptButton.setVisible(false);
				declineButton.setVisible(false);
				idLabel.setVisible(false);
				accToDisable.setVisible(false);
				disable.setVisible(false);
				
				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(false);
				l4.setVisible(false);
				totalCurrency.setVisible(false);
				totalActivity.setVisible(false);
				frequentType.setVisible(false);
				biggestTransaction.setVisible(false);
				dashboard.setVisible(false);
			}
		});
		statsButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		statsButton.setBounds(10, 244, 141, 40);
		frmPhpayAdministrator.getContentPane().add(statsButton);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogOut.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnLogOut.setBounds(10, 496, 141, 40);
		frmPhpayAdministrator.getContentPane().add(btnLogOut);
		
		JPanel titleBar = new JPanel();
		titleBar.setBounds(0, 0, 1241, 21);
		titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});

		titleBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int newX = frmPhpayAdministrator.getX() + e.getX() - x;
				int newY = frmPhpayAdministrator.getY() + e.getY() - y;

				frmPhpayAdministrator.setLocation(newX, newY);
			}
		});
		
		frmPhpayAdministrator.getContentPane().add(titleBar);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(159, 79, 6, 500);
		frmPhpayAdministrator.getContentPane().add(separator_1);
		declineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String[]> tickets = SQLQuery.getTickets();
				if (tickets.size() > 0) {
					String getID = id.getText();
					SQLQuery.appealProcess(getID, false, "DENIED", Integer.valueOf(tickets.get(index)[2]));
					id.setText(null);
					message.setText(null);
				}
			}
		});
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String[]> tickets = SQLQuery.getTickets();
				if (tickets.size() > 0) {
					String getID = id.getText();
					SQLQuery.appealProcess(getID, true, "SUCCESS", Integer.valueOf(tickets.get(index)[2]));
					id.setText(null);
					message.setText(null);
				}

			}
		});

	}

	public void getSus(JScrollPane scrollPane) {

		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "User ID", "Time", "Transaction ID", "Amount", "Description", "Receiver" }) {
			private static final long serialVersionUID = 8961818422329199291L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (i == 1 || i == (table.getColumnCount() - 2))
				table.getColumnModel().getColumn(i).setPreferredWidth(80);
			else if (i == 2 || i == 3)
				table.getColumnModel().getColumn(i).setPreferredWidth(10);
			else
				table.getColumnModel().getColumn(i).setPreferredWidth(30);
		}

		DefaultTableCellRenderer whiteBackgroundRenderer = new DefaultTableCellRenderer();
//		whiteBackgroundRenderer.setBackground(Color.BLACK);

		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRender);
		}

		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		table.setRowMargin(1);

		table.setGridColor(new Color(0, 0, 0));
		table.setRowHeight(30);
		table.setOpaque(false);
		table.getColumnModel().getColumn(0).setCellRenderer(whiteBackgroundRenderer);

		JTableHeader header = table.getTableHeader();
		scrollPane = new JScrollPane(table);
		scrollPane_1.setViewportView(scrollPane);

		scrollPane.setColumnHeaderView(header);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(Color.black);
		scrollPane.getViewport().setBackground(Color.black);

		SQLConnection con = new SQLConnection();
		String query = "SELECT * FROM `transactions`";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			String user_id, date, transaction_id, amount, status, receiver;
			while (rs.next()) {
				transaction_id = rs.getString(1);
				user_id = rs.getString(2);
				status = rs.getString(3);
				date = rs.getString(4);
				amount = rs.getString(5);
				receiver = rs.getString(6);

				model.addRow(new Object[] { user_id, date, transaction_id, amount, status, receiver });
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void allTransaction(DefaultTableModel model) {
		try {
			SQLConnection con = new SQLConnection();
			String query = "SELECT user_id, COUNT(transaction_id) AS transaction_count, SUM(operation) AS total_amount FROM transactions GROUP BY user_id";
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			String user_id;
			int transaction_count;
			double total_amount;

			while (rs.next()) {
				user_id = rs.getString("user_id");
				transaction_count = rs.getInt("transaction_count");
				total_amount = rs.getDouble("total_amount");

				model.addRow(new Object[] { user_id, transaction_count, total_amount });
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void allAmount() {
		try {
			SQLConnection con = new SQLConnection();
			String query = "SELECT SUM(operation) AS total_amount FROM transactions";
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			double totalAmountDouble = 0.0;

			while (rs.next()) {
				totalAmountDouble = rs.getDouble("total_amount");
			}

			String totalAmount = Double.toString(totalAmountDouble);
			totalCurrency.setText(totalAmount);

		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void allActivity() {
		try {
			SQLConnection con = new SQLConnection();
			String query = "SELECT COUNT(*) AS total_transactions FROM transactions";
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			int totalTransactions = 0;

			while (rs.next()) {
				totalTransactions = rs.getInt("total_transactions");
			}

			String totalTransactionsStr = Integer.toString(totalTransactions);
			totalActivity.setText(totalTransactionsStr);

		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void mostFrequentType() {
		try {
			SQLConnection con = new SQLConnection();
			String query = "SELECT type, COUNT(*) AS type_count FROM transactions GROUP BY type ORDER BY type_count DESC LIMIT 1";
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			String mostFrequentType = "";

			while (rs.next()) {
				mostFrequentType = rs.getString("type");
			}

			frequentType.setText(mostFrequentType);

		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void biggestTransaction() {
		try {
			SQLConnection con = new SQLConnection();
			String query = "SELECT * FROM transactions ORDER BY operation DESC LIMIT 1";
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			double bigTransactionDouble = 0.0;

			while (rs.next()) {
				bigTransactionDouble = rs.getDouble("operation");
			}

			String bigString = Double.toString(bigTransactionDouble);
			biggestTransaction.setText(bigString);

		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void getSus1(JScrollPane scrollPane) {
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "User ID", "Total Transactions", "Total Amount" }) {
			private static final long serialVersionUID = 8961818422329199291L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(table);

		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		table.setRowMargin(1);

		table.setGridColor(new Color(0, 0, 0, 100));
		table.setRowHeight(30);
		table.setOpaque(false);

		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);

		allTransaction(model);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
	}
}

package PHPay;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SummaryPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private String session;

	public SummaryPanel(String ID) {
		this.session = ID;
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1200, 610);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Transactions");
		lblNewLabel.setForeground(new Color(51, 0, 204));
		lblNewLabel.setFont(new Font("Oswald", Font.PLAIN, 36));
		lblNewLabel.setBounds(20, 11, 178, 54);
		add(lblNewLabel);

		JLabel lblAll = new JLabel("All");
		lblAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions();
			}
		});
		lblAll.setForeground(new Color(0, 0, 0));
		lblAll.setFont(new Font("Oswald", Font.PLAIN, 16));
		lblAll.setBounds(285, 49, 43, 54);
		add(lblAll);

		JLabel lblSend = new JLabel("Send");
		lblSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("Send Money");
			}
		});
		lblSend.setForeground(new Color(0, 0, 0));
		lblSend.setFont(new Font("Oswald", Font.PLAIN, 16));
		lblSend.setBounds(332, 49, 43, 54);
		add(lblSend);

		JLabel lblReceive = new JLabel("Receive");
		lblReceive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("Received Money");
			}
		});
		lblReceive.setForeground(new Color(0, 0, 0));
		lblReceive.setFont(new Font("Oswald", Font.PLAIN, 16));
		lblReceive.setBounds(385, 49, 59, 54);
		add(lblReceive);

		JLabel lblPayment = new JLabel("Payment");
		lblPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("?bill paid");
			}
		});
		lblPayment.setForeground(new Color(0, 0, 0));
		lblPayment.setFont(new Font("Oswald", Font.PLAIN, 16));
		lblPayment.setBounds(454, 49, 59, 54);
		add(lblPayment);

		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("Withdraw Money");
			}
		});

		lblWithdraw.setForeground(new Color(0, 0, 0));
		lblWithdraw.setFont(new Font("Oswald", Font.PLAIN, 16));
		lblWithdraw.setBounds(523, 49, 59, 54);
		add(lblWithdraw);

		JLabel lblSortBy = new JLabel("Sort By:");
		lblSortBy.setForeground(new Color(0, 0, 0));
		lblSortBy.setFont(new Font("Oswald", Font.PLAIN, 16));
		lblSortBy.setBounds(1031, 49, 59, 54);
		add(lblSortBy);

		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new EmptyBorder(1, 1, 1, 1));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Date", "Transactions", "Name" }));
		comboBox.setBounds(1087, 63, 91, 30);
		add(comboBox);

		JButton resizeButton = new JButton("Resize Table");
		resizeButton.setFont(new Font("Oswald", Font.PLAIN, 10));
		resizeButton.setBounds(921, 63, 84, 30);
		add(resizeButton);

		// Add an ActionListener to the button
		resizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the method to resize rows and columns
				resizeTableColumnsToDefault();
			}
		});

	}

	private static class LeftAlignedHeaderRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

		public LeftAlignedHeaderRenderer() {
			setHorizontalAlignment(SwingConstants.LEFT);
		}
	}

	private void resizeTableColumnsToDefault() {
		// Reset column widths to their default values
		for (int i = 0; i < table.getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			TableCellRenderer headerRenderer = column.getHeaderRenderer();
			if (headerRenderer == null) {
				headerRenderer = table.getTableHeader().getDefaultRenderer();
			}
			Component headerComp = headerRenderer.getTableCellRendererComponent(table, column.getHeaderValue(), false,
					false, -1, i);
			int headerWidth = headerComp.getPreferredSize().width;

			int maxCellWidth = 0;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer cellRenderer = table.getCellRenderer(row, i);
				Component cellComp = cellRenderer.getTableCellRendererComponent(table, table.getValueAt(row, i), false,
						false, row, i);
				int cellWidth = cellComp.getPreferredSize().width;
				maxCellWidth = Math.max(maxCellWidth, cellWidth);
			}

			int newColumnWidth = Math.max(headerWidth, maxCellWidth);
			column.setPreferredWidth(newColumnWidth);
		}
	}
	
	private void clearTable(DefaultTableModel model) {
	    model.setRowCount(0);
	}
	
	public void getTransactions() {
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "Name", "Date", "Invoice ID", "Amount", "Status" }) {
			private static final long serialVersionUID = 8961818422329199291L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellSelected(int row, int column) {
				return false;
			}
		};
		
		if (scrollPane != null) {
	        remove(scrollPane);
	    }
		clearTable(model);
		
		table.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		table.setRowMargin(1);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(255, 255, 255));

		table.setGridColor(new Color(0, 0, 0, 20));
		table.setRowHeight(30);
		table.setOpaque(false);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(30);
		}

		DefaultTableCellRenderer whiteBackgroundRenderer = new DefaultTableCellRenderer();
		whiteBackgroundRenderer.setBackground(Color.WHITE);
		table.getColumnModel().getColumn(0).setCellRenderer(whiteBackgroundRenderer);

		DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
		leftRender.setHorizontalAlignment(SwingConstants.LEFT);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(leftRender);
		}

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new LeftAlignedHeaderRenderer());
		header.setBackground(Color.WHITE);
		header.setForeground(new Color(128, 0, 128));
		header.setReorderingAllowed(false);
		scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(header);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(285, 104, 893, 484);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane);

		SQLConnection con = new SQLConnection();
		String query = "SELECT * FROM `transactions` WHERE user_id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, session);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();

			String date, transaction_id, amount, status;
			while (rs.next()) {
				transaction_id = rs.getString(1);
				status = rs.getString(3);
				date = rs.getString(4);
				amount = rs.getString(5);

				model.addRow(new Object[] { session, date, transaction_id, amount, status });
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	//METHOD OVERLOADING
	public void getTransactions(String op) {
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "Name", "Date", "Invoice ID", "Amount", "Status" }) {
			private static final long serialVersionUID = 8961818422329199291L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellSelected(int row, int column) {
				return false;
			}
		};
		if (scrollPane != null) {
	        remove(scrollPane);
	    }
		clearTable(model);
		
		table.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		table.setRowMargin(1);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(255, 255, 255));

		table.setGridColor(new Color(0, 0, 0, 20));
		table.setRowHeight(30);
		table.setOpaque(false);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(30);
		}

		DefaultTableCellRenderer whiteBackgroundRenderer = new DefaultTableCellRenderer();
		whiteBackgroundRenderer.setBackground(Color.WHITE);
		table.getColumnModel().getColumn(0).setCellRenderer(whiteBackgroundRenderer);

		DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
		leftRender.setHorizontalAlignment(SwingConstants.LEFT);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(leftRender);
		}

		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new LeftAlignedHeaderRenderer());
		header.setBackground(Color.WHITE);
		header.setForeground(new Color(128, 0, 128));
		header.setReorderingAllowed(false);
		scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(header);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(285, 104, 893, 484);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane);

		SQLConnection con = new SQLConnection();
		String query = "SELECT * FROM `transactions` WHERE user_id = ? AND type = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, session);
			ps.setString(2, op);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();

			String date, transaction_id, amount, status;
			while (rs.next()) {
				transaction_id = rs.getString(1);
				status = rs.getString(3);
				date = rs.getString(4);
				amount = rs.getString(5);
				
				model.addRow(new Object[] { session, date, transaction_id, amount, status });
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

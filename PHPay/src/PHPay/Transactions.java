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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Transactions extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private String session;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Transactions(String ID) {
		this.session = ID;
		setBackground(new Color(64, 0, 128));
		setBounds(0, 0, 1200, 754);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Transactions");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 36));
		lblNewLabel.setBounds(25, 31, 318, 54);
		add(lblNewLabel);

		String[] types = { "Date", "Transactions", "Name" };

		RoundedButton resizeButton = new RoundedButton("Resize");
		resizeButton.setForeground(new Color(255, 255, 255));
		resizeButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		resizeButton.setBounds(1098, 133, 81, 30);
		add(resizeButton);


		resizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resizeTableColumnsToDefault();
			}
		});
		getTransactions();

	}

	// CHANGED FROM PRIVATE TO PUBLIC TO ACCOMODATE ADMINPANEL
	public static class LeftAlignedHeaderRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;

		public LeftAlignedHeaderRenderer() {
			setHorizontalAlignment(SwingConstants.LEFT);
		}
	}

	private void resizeTableColumnsToDefault() {
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
				new String[] { "ID", "Date", "Invoice ID", "Amount", "Description", "Receipient" }) {
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

		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
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
		header.setBackground(Color.BLUE); // Change to your preferred background color
		header.setForeground(Color.WHITE); // Change to your preferred text color
		header.setReorderingAllowed(false);
		scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		scrollPane.setColumnHeaderView(header);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBackground(new Color(192, 192, 192));
		scrollPane.setBounds(0, 172, 1222, 582);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane);

		SQLConnection con = new SQLConnection();
		String query = "SELECT * FROM `transactions` WHERE user_id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, session);
			ResultSet rs = ps.executeQuery();

			String date, transaction_id, amount, status, receiver;
			while (rs.next()) {
				transaction_id = rs.getString(1);
				status = rs.getString(3);
				date = rs.getString(4);
				amount = rs.getString(5);
				receiver = rs.getString(6);

				model.addRow(new Object[] { session, date, transaction_id, "₱ " + amount, status, receiver });
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JLabel lblAll = new JLabel("All");
		lblAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblAll.setForeground(Color.WHITE);
		lblAll.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblAll.setBounds(3, 126, 81, 45);
		add(lblAll);
		lblAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions();
				resizeTableColumnsToDefault();
			}
		});

		JLabel lblSend = new JLabel("Send");
		lblSend.setBounds(80, 126, 92, 45);
		add(lblSend);
		lblSend.setHorizontalAlignment(SwingConstants.CENTER);
		lblSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("Sent Money");
				resizeTableColumnsToDefault();
			}
		});
		lblSend.setForeground(new Color(255, 255, 255));
		lblSend.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblReceive = new JLabel("Receive");
		lblReceive.setBounds(181, 126, 92, 45);
		add(lblReceive);
		lblReceive.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("Received Money");
				resizeTableColumnsToDefault();
			}
		});
		lblReceive.setForeground(new Color(255, 255, 255));
		lblReceive.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setBounds(392, 126, 92, 45);
		add(lblPayment);
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("?bill paid");
				resizeTableColumnsToDefault();
			}
		});
		lblPayment.setForeground(new Color(255, 255, 255));
		lblPayment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setBounds(292, 126, 92, 45);
		add(lblWithdraw);
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getTransactions("Withdraw Money");
				resizeTableColumnsToDefault();
			}
		});

		lblWithdraw.setForeground(new Color(255, 255, 255));
		lblWithdraw.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));

		JSeparator separator = new JSeparator();
		separator.setBounds(31, 132, 31, 4);
		add(separator);
		
		resizeTableColumnsToDefault();
	}

	public void getTransactions(String op) {
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "ID", "Date", "Invoice ID", "Amount", "Description", "Receiver" }) {
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

		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
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
		header.setForeground(new Color(0, 0, 0));
		header.setReorderingAllowed(false);
		scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(header);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 172, 1222, 582);
		scrollPane.getViewport().setBackground(Color.WHITE);
		add(scrollPane);

		SQLConnection con = new SQLConnection();
		String query = "SELECT * FROM `transactions` WHERE user_id = ? AND type = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, session);
			ps.setString(2, op);
			ResultSet rs = ps.executeQuery();

			String date, transaction_id, amount, status, receiver;
			while (rs.next()) {
				transaction_id = rs.getString(1);
				status = rs.getString(3);
				date = rs.getString(4);
				amount = rs.getString(5);
				receiver = rs.getString(6);

				model.addRow(new Object[] { session, date, transaction_id, "₱ " + amount, status, receiver });
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

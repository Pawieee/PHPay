package PHPay;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class adminPanel {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField message;
	private JTextField id;
	private int index = 0;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPanel window = new adminPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public adminPanel() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(205, 47, 491, 345);
		frame.getContentPane().add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(211, 30, 446, 393);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Sus transacts");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSus(scrollPane_1);
				scrollPane_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		btnNewButton.setBounds(6, 86, 130, 21);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton prev = new JButton("<");
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
		prev.setBounds(10, 10, 62, 21);
		panel.add(prev);
		
		JButton next = new JButton(">");
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
		next.setBounds(374, 10, 62, 21);
		panel.add(next);
		
		message = new JTextField();
		message.setBounds(20, 88, 397, 252);
		panel.add(message);
		message.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ok");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setBounds(267, 350, 62, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("no");
		btnNewButton_2_1.addActionListener(new ActionListener() {
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
		btnNewButton_2_1.setBounds(339, 350, 62, 21);
		panel.add(btnNewButton_2_1);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(20, 59, 96, 19);
		panel.add(id);
		id.setColumns(10);
		
		JButton btnAppeals = new JButton("Appeals");
		btnAppeals.setBounds(26, 147, 92, 21);
		btnAppeals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				scrollPane_1.setVisible(false);
				panel.setVisible(true);
				
				ArrayList<String[]> tickets = SQLQuery.getTickets();
				
				if (tickets.size() > 0) {
					id.setText(tickets.get(0)[0]);
					
					message.setText(tickets.get(0)[1]);
					
				} else {
					message.setText("Such empty");
				}
				
				
			}
		});
		frame.getContentPane().add(btnAppeals);
		
	}
	
	public void getSus(JScrollPane scrollPane) {
		
		
		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "USER ID", "Time", "Ticket ID", "Cash" }) {
			private static final long serialVersionUID = 8961818422329199291L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		scrollPane.setViewportView(table);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(30);
		}

		DefaultTableCellRenderer whiteBackgroundRenderer = new DefaultTableCellRenderer();
		whiteBackgroundRenderer.setBackground(Color.WHITE);

		DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
		leftRender.setHorizontalAlignment(SwingConstants.LEFT);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(leftRender);
		}
		
		table.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		table.setRowMargin(1);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(255, 255, 255));
		
				table.setGridColor(new Color(0, 0, 0, 20));
				table.setRowHeight(30);
				table.setOpaque(false);
				table.getColumnModel().getColumn(0).setCellRenderer(whiteBackgroundRenderer);
				
						JTableHeader header = table.getTableHeader();
						scrollPane = new JScrollPane(table);
						scrollPane_1.setViewportView(scrollPane);
		scrollPane.setColumnHeaderView(header);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		
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
	
//	public void getAppeals() {
//
//		
//		SQLConnection con = new SQLConnection();
//		String query = "SELECT * FROM `appeals`";
//
//		try {
//			PreparedStatement ps = con.getCon().prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//
//			String ticket,user_id, message, status;
//			while (rs.next()) {
//				ticket = rs.getString(1);
//				user_id = rs.getString(2);
//				message= rs.getString(3);
//				status = rs.getString(4);
//			}
//		} catch (SQLException ex) {
//			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
}

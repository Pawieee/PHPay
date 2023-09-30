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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Admin {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField message;
	private JTextField id;
	private int index = 0;
	private JTextField accToDisable;
	private JButton disable;

	public static void main(String[] args) {
		String laf = "com.jtattoo.plaf.smart.SmartLookAndFeel";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(laf);
					Admin window = new Admin();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(177, 76, 564, 393);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
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
		next.setBounds(458, 10, 62, 21);
		panel.add(next);
		
		message = new JTextField();
		message.setBounds(80, 88, 397, 252);
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
		btnNewButton_2.setBounds(196, 350, 62, 21);
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
		btnNewButton_2_1.setBounds(299, 350, 62, 21);
		panel.add(btnNewButton_2_1);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(20, 59, 96, 19);
		panel.add(id);
		id.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 76, 823, 393);
		frame.getContentPane().add(scrollPane_1);
		
		disable = new JButton("Disable");
		disable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = accToDisable.getText();
				SQLQuery.disableUser(ID);
				accToDisable.setText("");
			}
		});
		
		accToDisable = new JTextField();
		accToDisable.setBounds(433, 500, 96, 19);
		frame.getContentPane().add(accToDisable);
		accToDisable.setColumns(10);
		disable.setBounds(559, 499, 85, 21);
		frame.getContentPane().add(disable);
		
		JButton btnNewButton = new JButton("Transactions");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSus(scrollPane_1);
				scrollPane_1.setVisible(true);
				accToDisable.setVisible(true);
				disable.setVisible(true);
				panel.setVisible(false);
			}
		});
		btnNewButton.setBounds(273, 30, 96, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAppeals = new JButton("Appeals");
		btnAppeals.setBounds(524, 30, 92, 21);
		btnAppeals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				disable.setVisible(false);
				accToDisable.setVisible(false);
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
		new String[] { "USER ID", "Time", "Transaction ID", "Amount", "Description", "Receiver"}) {
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
		
		table.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		table.setRowMargin(1);

//		table.setSelectionForeground(new Color(255, 255, 255));
//		table.setSelectionBackground(new Color(255, 255, 255));
		
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
}

package PHPay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLQuery {
	static SQLConnection con = new SQLConnection();

	public boolean IDExists(String ID) {

		String query = "SELECT `user_id` FROM `users`";
		try {
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String checkID = rs.getString("user_id");
				if (checkID.equals(ID)) {
					return true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static void updatePass(String newPass, String user) {

		String query = "UPDATE `users` SET `hashed_pass` = ? WHERE username = ?";
		// FINISH THIS
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, newPass);
			ps.setString(2, user);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static String getPassKey(String user) {
		String passkey = "";
		String query = "SELECT `passkey` FROM `users` WHERE username = ?";
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				passkey = rs.getString("passkey");
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return passkey;

	}

	public static double getBalance(String ID) {
		double bal = 0.0;
		String query = "SELECT `balance` FROM `users` WHERE user_id = ?";
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				bal = rs.getDouble("balance");
				System.out.println(bal);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return bal;
	}

	// Transaction NAME
	public static String getTransName(String user) {
		String query = "SELECT `fName` FROM `user_profile` WHERE user_id = ?";
		String Fname = "";
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Fname = rs.getString("fName");
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return Fname;

	}

	// Getting ID
	public static String getID(String user) {
		String query = "SELECT `user_id` FROM `users` WHERE user_id = ?";
		String userID = "";
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userID = rs.getString("user_id");
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return userID;

	}

	public static void deleteAccount(String ID) {

		String query = "DELETE FROM `user_profile` WHERE user_id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query2 = "DELETE FROM `users` WHERE user_id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query2);
			ps.setString(1, ID);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void addBalance(String ID, double addCash) {

		String query = "UPDATE `users` SET `balance` = balance + ? WHERE user_id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setDouble(1, addCash);
			ps.setString(2, ID);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void deductBalance(String ID, double amount) {

		String query = "UPDATE `users` SET `balance` = balance - ? WHERE user_id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setString(2, ID);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void cashIn(String ID, double amount) {
		addBalance(ID, amount);
		String aamount = amount + "";
		transaction(ID, "Cash-In", aamount, "PHPay");
	}

	public static void sendMoney(String senderID, String receiverID, double amount) {
		amount = amount * 0.97;
		deductBalance(senderID, amount);
		String aamount = amount + "";
		transaction(senderID, "Sent Money", aamount, receiverID);
		addBalance(receiverID, amount);
		transaction(receiverID, "Received Money", aamount, senderID);
	}

	public static void load(String ID, double amount, String receiver) {
		amount = amount * 0.97;
		deductBalance(ID, amount);
		String aamount = amount + "";
		transaction(ID, "Bought Load", aamount, receiver);
	}

	public static void withdraw(String ID, double amount, String receiver) {
		amount = amount * 0.97;
		deductBalance(ID, amount);
		String aamount = amount + "";
		transaction(ID, "Withdraw Money", aamount, receiver);
	}

	public static void payBills(String ID, double amount, String bill) {
		amount = amount * 0.97;
		deductBalance(ID, amount);
		String aamount = amount + "";
		transaction(ID, "Paid Bill",  aamount, bill);
	}

	public static void transaction(String ID, String type, String amount, String receiver) {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = format.format(date);

		String query = "INSERT INTO `transactions`(`user_id`, `type`, `time`, `operation`, `receiver` ) VALUES (?, ?, ?, ?, ?)";

		double amount1 = Double.valueOf(amount);
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ps.setString(2, type);
			ps.setString(3, currentDateTime);
			ps.setDouble(4, amount1);
			ps.setString(5, receiver);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static String[] getTransaction(String ID) {
		String query = "SELECT * FROM `transactions` WHERE user_id = ?";

		String[] details = new String[6];
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String transaction_id = rs.getString(1);
				String user_id = rs.getString(2);
				String type = rs.getString(3);
				String time = rs.getString(4);
				String operation = rs.getString(5);
				String receiver = rs.getString(6);

				details[0] = transaction_id;
				details[1] = user_id;
				details[2] = type;
				details[3] = time;
				details[4] = operation;
				details[5] = receiver;
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return details;
	}
	
	//CREATES AN APPEAL TICKET
	public static void createAppeal(String ID, String message) {
		String query = "INSERT INTO `appeals`(`user_id`, `message`) VALUES (?, ?)";
		
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ps.setString(2, message);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	//GET APPEAL TICKETS
	public static ArrayList<String[]>getTickets() {
		String query = "SELECT * FROM `appeals` WHERE `status` = ?";

		ArrayList<String[]> appeals = new ArrayList<>();
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, "PENDING");
			ResultSet rs = ps.executeQuery();

			String ticket,user_id, message, status;
			while (rs.next()) {
				ticket = rs.getString(1);
				user_id = rs.getString(2);
				message= rs.getString(3);
				status = rs.getString(4);
				
				String[] appeal = {user_id, message, ticket};
				appeals.add(appeal);
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return appeals;
	}
	
	//PROCESS APPEAL
	public static void appealProcess(String ID, boolean op, String verdict, int ticket) {
		String query = "UPDATE `users` SET `status` = ? WHERE `user_id` = ?";
		
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setBoolean(1, op);
			ps.setString(2, ID);
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		String query2 = "UPDATE `appeals` SET `status` = ? WHERE `ticket` = ?";
		
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query2);
			ps.setString(1, verdict);
			ps.setInt(2, ticket);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	

}

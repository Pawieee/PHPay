package PHPay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLQuery {

	public boolean IDExists(String ID) {
		SQLConnection con = new SQLConnection();

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
		SQLConnection con = new SQLConnection();

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
		SQLConnection con = new SQLConnection();
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
		SQLConnection con = new SQLConnection();
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
	
	//Transaction NAME
	public static String getTransName(String user) {
		SQLConnection con = new SQLConnection();
		String query = "SELECT `fName`, `lName` FROM `user_profile` WHERE user_id = ?";
		String Fname = "";
		String Dname = "";
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Fname = rs.getString("fName");
				 Dname = rs.getString("lName");
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		return Fname +" "+ Dname;

	}
	

	public static void deleteAccount(String ID) {
		SQLConnection con = new SQLConnection();

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
		SQLConnection con = new SQLConnection();

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
		SQLConnection con = new SQLConnection();

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
		transaction(ID, "Cash-In", "+" + aamount);
	}

	public static void sendMoney(String senderID, String receiverID, double amount) {
		deductBalance(senderID, amount);
		String aamount1 = amount + "";
		transaction(senderID, "Sent Money", "-" + aamount1);
		addBalance(receiverID, amount);
		String aamount2 = amount + "";
		transaction(receiverID, "Received Money", "+" + aamount2);
	}

	public static void load(String ID, double amount) {
		deductBalance(ID, amount);
		String aamount = amount + "";
		transaction(ID, "Bought Load", "-" + aamount);
	}

	public static void withdraw(String ID, double amount) {
		deductBalance(ID, amount);
		String aamount = amount + "";
		transaction(ID, "Withdraw Money", "-" + aamount);
	}

	public static void payBills(String ID, double amount, String bill) {
		deductBalance(ID, amount);
		String aamount = amount + "";
		transaction(ID, bill + " bill paid", "-" + aamount);
	}

	public static void transaction(String ID, String type, String amount) {
		SQLConnection con = new SQLConnection();

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = format.format(date);

		String query = "INSERT INTO `transactions`(`user_id`, `type`, `time`, `operation`) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ps.setString(2, type);
			ps.setString(3, currentDateTime);
			ps.setString(4, amount + " ₱");
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}

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

	public static double getBalance(String ID) {
		SQLConnection con = new SQLConnection();
		double bal = 0.0;
		String query = "SELECT `balance` FROM `users` WHERE id = ?";
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				bal = rs.getDouble("balance");
				System.out.println(bal);
			}
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}
		return bal;
	}

	public boolean IDExists(String ID) {
		SQLConnection con = new SQLConnection();

		String query = "SELECT `id` FROM `users`";
		try {
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String checkID = rs.getString("id");
				if (checkID.equals(ID)) {
					return true;
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static void deleteAccount(String ID) {
		SQLConnection con = new SQLConnection();


		String query = "DELETE FROM `user_profile` WHERE id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}
		String query2 = "DELETE FROM `users` WHERE id = ?";
		
		try {
			PreparedStatement ps = con.getCon().prepareStatement(query2);
			ps.setString(1, ID);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void addBalance(String ID, double addCash) {
		SQLConnection con = new SQLConnection();

		String query = "UPDATE `users` SET `balance` = balance + ? WHERE id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setDouble(1, addCash);
			ps.setString(2, ID);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void deductBalance(String ID, double amount) {
		SQLConnection con = new SQLConnection();

		String query = "UPDATE `users` SET `balance` = balance - ? WHERE id = ?";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setString(2, ID);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void cashIn(String ID, double amount) {
		addBalance(ID, amount);
		transaction(ID, "Cash-In");
	}

	public static void sendMoney(String senderID, String receiverID, double amount) {
		deductBalance(senderID, amount);
		transaction(senderID, "Sent Money");
		addBalance(receiverID, amount);
		transaction(receiverID, "Received Money");
	}

	public static void load(String ID, double amount) {
		deductBalance(ID, amount);
		transaction(ID, "Bought Load");
	}

	public static void withdraw(String ID, double amount) {
		deductBalance(ID, amount);
		transaction(ID, "Withdraw Money");
	}

	public static void payBills(String ID, double amount, String bill) {
		deductBalance(ID, amount);
		transaction(ID, bill + " bill paid");
	}

	public static void transaction(String ID, String type) {
		SQLConnection con = new SQLConnection();

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = format.format(date);

		String query = "INSERT INTO `transactions`(`user_id`, `type`, `time`) VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = con.getCon().prepareStatement(query);
			ps.setString(1, ID);
			ps.setString(2, type);
			ps.setString(3, currentDateTime);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}

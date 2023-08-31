package PHPay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLQuery {
	private static SQLConnection con;

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

}

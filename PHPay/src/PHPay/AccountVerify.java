package PHPay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountVerify {

	static SQLConnection con = new SQLConnection();

	public static String passwordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(password.getBytes());

			byte[] result = md.digest();

			StringBuilder sb = new StringBuilder();

			for (byte b : result) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean accountExist(String user) {
		ArrayList<String> names = new ArrayList<>();
		con.Connect();
		String query = "SELECT `username` FROM `users`";
		try {
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("username");
				names.add(name);
			}
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (names.isEmpty()) {
			return false;
		}
		for (String name : names) {
			if (user.equals(name)) {
				return true;
			}
		}
		return false;
	}

}

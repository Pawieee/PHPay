package PHPay;

import java.sql.*;

public class SQLConnect {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public SQLConnect() {
		Connect();
	}

	public void Connect() {
		String url = "jdbc:mysql://localhost:3306/PHPay";
		String username = "root";
		String password = "password";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			/*
			 * String sql = "INSERT INTO student(student_id, name, major) VALUES(?,?,?)";
			 * PreparedStatement ps = connection.prepareStatement(sql); ps.setString(1,"5"
			 * ); ps.setString(2, "Yawa"); ps.setString(3, "BS"); ps.executeUpdate();
			 */

		} catch (SQLException e) {
			System.out.println("Oops, error!");
			e.printStackTrace();
		}

	}
}

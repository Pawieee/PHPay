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


		} catch (SQLException e) {
			System.out.println("Oops, error!");
			e.printStackTrace();
		}

	}
}

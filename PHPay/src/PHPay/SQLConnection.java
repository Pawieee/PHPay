package PHPay;

import java.sql.*;

public class SQLConnection {

	private Connection connection;

	public SQLConnection() {
		Connect();
	}

	public void Connect() {
		String url = "jdbc:mysql://192.168.5.101:3306/PHPay";
		String username = "username";
		String password = "password";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			setCon(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void setCon(String url, String username, String password) {
		try {
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return connection;
	}

}

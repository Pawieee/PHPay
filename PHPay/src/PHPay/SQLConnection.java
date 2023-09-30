package PHPay;

import java.sql.*;

public class SQLConnection {

	private Connection connection;

	public SQLConnection() {
		Connect();
	}

	public void Connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			setCon("jdbc:mysql://localhost:3306/PHPay", "root", "4304Qwe123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void setCon(String url, String username, String password) {
		try {
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return connection;
	}

}

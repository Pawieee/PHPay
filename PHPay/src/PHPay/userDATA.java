package PHPay;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class userDATA {

	private String userID, userName, userPass;

	private double balance;

	private SQLConnection con;

	public userDATA(String userID, String userName, String userPass, double balance) {

		this.userID = userID;
		this.userName = userName;
		this.userPass = userPass;
		this.balance = balance;
		this.con = new SQLConnection();

	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	public void saveAccount() {
		this.con.Connect();
		String query = "INSERT INTO `users`(`id`, `username`, `password_hash`) VALUES (?, ?, ?)";

		String hashed = AccountVerify.passwordHash(this.userPass);
		try {
			PreparedStatement pst = this.con.getCon().prepareStatement(query);
			pst.setString(1, this.userID);
			pst.setString(2, this.userName);
			pst.setString(3, hashed);
			pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public boolean accountExist() {
		return AccountVerify.accountExist(this.userName);
	}

}
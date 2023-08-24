package PHPay;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class userDATA {

	private String saveID, saveUser, savePass;

	private double balance;

	public userDATA(String saveID, String saveUser, String savePass, double balance) {

		this.saveID = saveID;
		this.saveUser = saveUser;
		this.savePass = savePass;
		this.balance = balance;

	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	public void saveAccount() {
		SQLConnect newCon = new SQLConnect();
		newCon.Connect();
		
		
		String hashed = passwordHash(this.savePass);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "password");
            PreparedStatement ps =  (PreparedStatement) con.prepareStatement("INSERT INTO `users`(`id`, `username`, `password_hash`) VALUES (?, ?, ?)");
            ps.setString(1,"");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	//try
	
	public String passwordHash(String password) {
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

}
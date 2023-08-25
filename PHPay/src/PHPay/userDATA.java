package PHPay;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class userDATA {

	private String saveID, saveUser, savePass;

	private double balance;
	
	private SQLConnection con;

	public userDATA(String saveID, String saveUser, String savePass, double balance) {

		this.saveID = saveID;
		this.saveUser = saveUser;
		this.savePass = savePass;
		this.balance = balance;
		this.con = new SQLConnection();

	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	public void saveAccount() {
		this.con.Connect();
		String query = "INSERT INTO `users`(`id`, `username`, `password_hash`) VALUES (?, ?, ?)";
				
		
		String hashed = passwordHash(this.savePass);
		try {
			PreparedStatement pst = this.con.getCon().prepareStatement(query);
            pst.setString(1,this.saveID);
            pst.setString(2,this.saveUser);
            pst.setString(3, hashed);
            pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		} 

	}
	
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
	
	public boolean accountExist() {
		ArrayList<String> names = new ArrayList<>();
		this.con.Connect();
		String query = "SELECT `username` FROM `users`";
		try {
			Statement stmt = this.con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
            	String name = rs.getString("username");
            	names.add(name);
            }
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		for (String name: names) {
			if (this.saveUser.equals(name)) {
				return false;
			}
		}
		return true;
	}

}
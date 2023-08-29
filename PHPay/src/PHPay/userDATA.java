package PHPay;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class userDATA {

	private String userID, userName, userPass;
	
	private accountInfo account;

	@SuppressWarnings("unused")
	private double balance;

	private SQLConnection con;

	public userDATA(String userID, String userName, String userPass, double balance, accountInfo account) {
		this.userID = userID;
		this.userName = userName;
		this.userPass = userPass;
		this.balance = balance;
		this.account = account;
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
		
		String query2 = "INSERT INTO `user_profile`(`id`, `f_name`, `l_name`, `age`, `birth_month`, `birth_day`, `birth_year`, `phone_number`, `address`, `email`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pst = this.con.getCon().prepareStatement(query2);
			pst.setString(1, this.userID);
			pst.setString(2, account.getfName());
			pst.setString(3, account.getlName());
			pst.setString(4, account.getAge());
			pst.setString(5, account.getMonth());
			pst.setString(6, account.getDay());
			pst.setString(7, account.getYear());
			pst.setString(8, account.getPhoneNum());
			pst.setString(9, account.getAddress());
			pst.setString(10, account.getEmail());
			pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(userDATA.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public boolean accountExist() {
		return AccountVerify.accountExist(this.userName);
	}

}
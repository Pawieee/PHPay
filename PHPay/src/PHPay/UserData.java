package PHPay;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserData {

	private String userID, userName, userPass;
	
	private AccountInfo account;

	@SuppressWarnings("unused")
	private double balance;

	private SQLConnection con;

	public UserData(String userID, String userName, String userPass, double balance, AccountInfo account) {
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
		String query = "INSERT INTO `users`(`user_id`, `username`, `hashed_pass`) VALUES (?, ?, ?)";

		String hashed = AccountVerify.passwordHash(this.userPass);
		try {
			PreparedStatement pst = this.con.getCon().prepareStatement(query);
			pst.setString(1, this.userID);
			pst.setString(2, this.userName);
			pst.setString(3, hashed);
			pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		String query2 = "INSERT INTO `user_profile`(`user_id`, `fName`, `lName`, `age`, `bMonth`, `bDay`, `bYear`, `phoneNum`, `address`, `email`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
			Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public boolean accountExist() {
		return AccountVerify.accountExist(this.userName);
	}

}
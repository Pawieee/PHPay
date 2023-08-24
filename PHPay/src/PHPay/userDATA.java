package PHPay;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class userDATA {

    private String 
    saveID,
    saveUser,
    savePass;

    private double 
    balance;
    
    public userDATA(
    		String saveID, 
    		String saveUser, 
    		String savePass, double balance) {
        
        this.saveID = saveID;
        this.saveUser = saveUser;
        this.savePass = savePass;
        this.balance = balance;
       
    }		
    
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

   
	public void saveAccountToFile() {
        try {
            String filename = "tempUPID.txt";
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            
            bufferedWriter.write("ID: " + saveID);
            bufferedWriter.newLine();
            bufferedWriter.write("Username: " + saveUser);
            bufferedWriter.newLine();
            bufferedWriter.write("Password: " + savePass);
            bufferedWriter.newLine();
            bufferedWriter.write("Balance: " + balance);
            bufferedWriter.newLine();
            bufferedWriter.write(" ");
            bufferedWriter.newLine();
            
            
            
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + saveID + ".txt'");
        }
        }
	
}
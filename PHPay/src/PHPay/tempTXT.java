package PHPay;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class tempTXT {
	
	private String 
	saveF, saveL, saveA, 
	saveM, saveD, saveY, 
	saveP, saveAd, saveE;
	
	
	
	public  tempTXT(String saveF, String saveL, 
			String saveA, String saveM, String saveD, 
			String saveY,String saveP, String saveAd,
			String saveE) 
	{
		
		this.saveF = saveF;
        this.saveL = saveL;
        this.saveA = saveA;
        this.saveM = saveM;
        this.saveD = saveD;
        this.saveY = saveY;
        this.saveP = saveP;
        this.saveAd = saveAd;
        this.saveE = saveE;
		
	}
	public void tempDATA() {

	try {
		String temporary = "tempREG.txt";
           FileWriter fileWriter = new FileWriter(temporary);
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	    bufferedWriter.write("First Name: " + saveF);
        bufferedWriter.newLine();
        bufferedWriter.write("Last Name: " + saveL);
        bufferedWriter.newLine();
        bufferedWriter.write("Age: " + saveA);
        bufferedWriter.newLine();
        bufferedWriter.write("Month: " + saveM);
        bufferedWriter.newLine();
        bufferedWriter.write("Day: " + saveD);
        bufferedWriter.newLine();
        bufferedWriter.write("Year: " + saveY);
        bufferedWriter.newLine();
        bufferedWriter.write("Phone Number: " + saveP);
        bufferedWriter.newLine();
        bufferedWriter.write("Address: " + saveAd);
        bufferedWriter.newLine();
        bufferedWriter.write("Email: " + saveE);
        bufferedWriter.newLine();

        bufferedWriter.close();
	} catch (IOException e) {
	    System.out.println("An error occurred: " + e);
	    
	}
}
}
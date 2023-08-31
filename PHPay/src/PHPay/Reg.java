package PHPay;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.SwingUtilities;

public class Reg extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField firstNameField,lastNameField,ageField,phonenumberField,addressField,emailField,textField,yearField;
	private JLabel firstNameStatusLabel, lastNameStatusLabel,ageStatusLabel,phoneStatusLabel,addressStatusLabel,emailStatusLabel, yearStatusLabel;
	JButton registerButton;
	boolean firstNameEdited = false;
	boolean lastNameEdited = false;
	boolean phoneEdited = false;
	boolean addressEdited = false;
	boolean emailEdited = false;
	boolean ageEdited = false;
	boolean yearEdited = false;
	public String selectedDay,selectedMonth;
	private String FName, lName, ageStr, phone, address, saveM, saveD;
	private int year;
	private JPanel focusBG;
	private final JButton ignoreThisVariable = new JButton("");	 
	
	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
				"[a-zA-Z0-9_+&*-]+)*@" + 
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				"A-Z]{2,7}$";
		
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
	
	public static boolean isValidName(String name) {
	    // Regular expression pattern to match letters, hyphen, and optional dot at the end
		String pattern = "^[a-zA-Z]+([\\s-][a-zA-Z]+)*(\\.[a-zA-Z]+)?$";

	    // Check if the name matches the pattern
	    if (name.matches(pattern)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public Reg() {
		setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 12));
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setAlwaysOnTop(false);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Downloads\\JAVA\\PHPAY\\PHPAY LOGO.png"));
		getContentPane().setForeground(Color.WHITE);
		setForeground(new Color(255, 255, 255));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int centerX = (screenWidth - 833) / 2;
		int centerY = (screenHeight - 475) / 2;
		setLocation(centerX, centerY);
		setSize(833, 475);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel titleBar = new JPanel();
		titleBar.setBounds(0, 0, 833, 23);
		getContentPane().add(titleBar);
		titleBar.setBackground(new Color(35, 35, 35));
		titleBar.setLayout(null);
		
		JButton minimize = new JButton("");
		minimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED); // Minimize the frame
			}
		});
		minimize.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/min.png")));
		minimize.setOpaque(false);
		minimize.setForeground(Color.WHITE);
		minimize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		minimize.setBorderPainted(false);
		minimize.setBorder(null);
		minimize.setBackground(new Color(255, 255, 255));
		minimize.setBounds(772, -1, 30, 24);
		titleBar.add(minimize);
		
		JButton close = new JButton("");
		close.setIcon(new ImageIcon(Welcome.class.getResource("/PHPay/phpimg/exit.png")));
		close.setFont(new Font("Tahoma", Font.PLAIN, 17));
		close.setBounds(803, -1, 30, 24);
		titleBar.add(close);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		close.setOpaque(false);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		close.setBorderPainted(false);
		close.setForeground(new Color(255, 255, 255));
		close.setBackground(new Color(255, 255, 255));
		close.setBorder(null);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				focusBG.setBounds(803, -1, 30, 23);
				focusBG.setBackground(new Color(255, 45, 50));
				focusBG.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				focusBG.setVisible(false);
			}
		});
		
		minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				focusBG.setBounds(772, -2, 30, 24);
				focusBG.setBackground(Color.GRAY);
				focusBG.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				focusBG.setVisible(false);
			}
		});
		
		focusBG = new JPanel();
		focusBG.setBounds(900, 3, 30, 23);
		titleBar.add(focusBG);
		ignoreThisVariable.setBounds(10, 3, -8, 19);
		titleBar.add(ignoreThisVariable);
		ignoreThisVariable.setOpaque(false);
		ignoreThisVariable.setForeground(Color.WHITE);
		ignoreThisVariable.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ignoreThisVariable.setBorderPainted(false);
		ignoreThisVariable.setBorder(null);
		ignoreThisVariable.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 455, 562);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton registerButton = new JButton("NEXT");
		registerButton.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		registerButton.setForeground(new Color(0, 0, 0));
		registerButton.setBackground(new Color(255, 255, 255));
		registerButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
		        
				if (!firstNameEdited || !lastNameEdited || !ageEdited || !phoneEdited ||
		                !addressEdited || !emailEdited || !yearEdited ) {
		        if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || ageField.getText().isEmpty() || phonenumberField.getText().isEmpty() ||
		                addressField.getText().isEmpty() || emailField.getText().isEmpty() || yearField.getText().isEmpty()) {
		        
		
		        }
				
		        } else {
		        	
		        	String saveF = firstNameField.getText();
    		    	String saveL = lastNameField.getText();
    		    	String saveA = ageField.getText();
    		    	saveM = selectedMonth;
    		    	saveD = selectedDay;
    		    	String saveY = yearField.getText();
    		    	String saveP = phonenumberField.getText();
    		    	String saveAd = addressField.getText();
    		    	String saveE = emailField.getText();
    		    	
    		    	accountInfo registerInfo = new accountInfo
    		    			(
    		    			 saveF, saveL, saveA, 
    		    			 saveM, saveD, saveY, 
    		    			 saveP, saveAd,saveE
    		    			 );
		       
		        	
		            UserPassID userpassID = new UserPassID(registerInfo);
		            userpassID.setVisible(true);
		            setVisible(false);
		            dispose();
		        }
				}
			
		});

		registerButton.setBounds(172, 497, 124, 30);
		panel.add(registerButton);

		firstNameStatusLabel = new JLabel("");
		firstNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		firstNameStatusLabel.setBounds(88, 114, 290, 20);
		panel.add(firstNameStatusLabel);
		
		lastNameStatusLabel = new JLabel("");
		lastNameStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		lastNameStatusLabel.setBounds(88, 168, 290, 20);
		panel.add(lastNameStatusLabel);
		
		ageStatusLabel = new JLabel("");
		ageStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		ageStatusLabel.setBounds(88, 219, 290, 20);
		panel.add(ageStatusLabel);
		
		phoneStatusLabel = new JLabel("");
		phoneStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		phoneStatusLabel.setBounds(88, 332, 290, 20);
		panel.add(phoneStatusLabel);

		addressStatusLabel = new JLabel("");
		addressStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		addressStatusLabel.setBounds(88, 389, 290, 20);
		panel.add(addressStatusLabel);
		
		emailStatusLabel = new JLabel("");
		emailStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		emailStatusLabel.setBounds(88, 449, 290, 20);
		panel.add(emailStatusLabel);
		
		yearStatusLabel = new JLabel("");
		yearStatusLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		yearStatusLabel.setBounds(268, 265, 110, 31);
		panel.add(yearStatusLabel);
		
		// Update RegisterButton ActionListener to check for empty field
		getRootPane().setDefaultButton(registerButton);
		registerButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 

		    	FName = firstNameField.getText();
		        if (!isValidName(FName)) {
		        	 firstNameStatusLabel.setText("Invalid name");
		        	 firstNameStatusLabel.setForeground(Color.RED);
		        	 firstNameEdited = false;
		        }
		        else if (firstNameField.getText().equals("First Name")) { // Check if input is only spaces
		        	firstNameStatusLabel.setText("Invalid name");
		        	firstNameStatusLabel.setForeground(Color.RED);
		        	firstNameEdited = false;
		        }
		        else {
		        	firstNameStatusLabel.setText("");
		        	firstNameEdited = true;
		        }
		        	
		        lName = lastNameField.getText();
		        if (!isValidName(lName)) {
		            lastNameStatusLabel.setText("Invalid name");
		            lastNameStatusLabel.setForeground(Color.RED);
		            lastNameEdited = false;
		        } 
		        else if (lastNameField.getText().equals("Last Name")) { // Check if input is only spaces
		        	lastNameStatusLabel.setText("Invalid name");
		        	lastNameStatusLabel.setForeground(Color.RED);
		        	lastNameEdited = false;
		        }
		        else {
		            lastNameStatusLabel.setText("");
		            lastNameEdited = true;
		        }
		        
		        ageStr = ageField.getText();
		        int age;
		        try {
		            age = Integer.parseInt(ageStr);
		            if (age < 18 ) {
		                ageStatusLabel.setText("Must be 18 up");
		                ageStatusLabel.setForeground(Color.RED);
		                ageEdited = false;
		            }
		            else if (age > 115  ) {
		                ageStatusLabel.setText("You're too old");
		                ageStatusLabel.setForeground(Color.RED);
		                ageEdited = false;
		            }
		            else {
		                ageStatusLabel.setText("");
		                ageEdited = true;
		            }
		        } catch (NumberFormatException ee) {
		            ageStatusLabel.setText("Invalid age");
		            ageStatusLabel.setForeground(Color.RED);
		            ageEdited = false;
		        }
		        
		        phone = phonenumberField.getText();
		        if (phone.isEmpty()) {
		            phoneStatusLabel.setText("Input is empty");
		            phoneStatusLabel.setForeground(Color.RED);
		            phoneEdited = false;
		        } else if (!phone.matches("[+]?[\\d\\s]+")) { // allow +, digits and spaces
		            phoneStatusLabel.setText("Invalid phone number");
		            phoneStatusLabel.setForeground(Color.RED);
		            phoneEdited = false;
		        } else if (phone.length() < 10) { // check minimum length
		            phoneStatusLabel.setText("Phone number is too short");
		            phoneStatusLabel.setForeground(Color.RED);
		            phoneEdited = false;
		        } else {
		            phoneStatusLabel.setText("");
		            phoneEdited = true;
		        }

		        
		        address = addressField.getText().trim(); // Trim any leading/trailing whitespace
		        if (address.isEmpty()) {
		            addressStatusLabel.setText("Invalid address");
		            addressStatusLabel.setForeground(Color.RED);
		            addressEdited = false;
		        } else if (addressField.getText().equals("Address")) { // Check if input is only spaces
		            addressStatusLabel.setText("Invalid address");
		            addressStatusLabel.setForeground(Color.RED);
		            addressEdited = false;
		        } else if (address.matches("^\\s+$")) { // Check if input is only spaces
		            addressStatusLabel.setText("Invalid address");
		            addressStatusLabel.setForeground(Color.RED);
		            addressEdited = false;
		        } else if (address.length() <=3 ) { // Check if input is between 1 and 3 characters long
		            addressStatusLabel.setText("Fill your full address");
		            addressStatusLabel.setForeground(Color.RED);
		            addressEdited = false;
		        } else {
		            addressStatusLabel.setText("");
		            addressEdited = true;
		        }

		        
		        // Check if the email input is valid
		        String email = emailField.getText();
		        if (!isValidEmail(email)) {
		            emailStatusLabel.setText("Invalid email");
		            emailStatusLabel.setForeground(Color.RED);
		            emailEdited = false;
		        } else {
		            emailStatusLabel.setText("");
		            emailEdited = true;
		        }
		        

		        try {
		            year = Integer.parseInt(yearField.getText());
		            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		            int age1 = currentYear - year;
		            if (age1 < 18) { 
		                yearStatusLabel.setText("Must be 18 up");
		                yearStatusLabel.setForeground(Color.RED);
		                yearEdited = false;
		            }
		             else if (age1 > 115) { 
			                yearStatusLabel.setText("Really?");
			                yearStatusLabel.setForeground(Color.RED);
			                yearEdited = false;    
		                
		            } else {
		                yearStatusLabel.setText("");
		                yearEdited = true;
		            }
		        } catch (NumberFormatException ex) {
		            yearStatusLabel.setText("Invalid year");
		            yearStatusLabel.setForeground(Color.RED);
		            yearEdited = false;
		        }

		        	
		        
		    }
		});

		firstNameField = new JTextField("First Name");
		firstNameField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		firstNameField.setBounds(88, 84, 290, 30);
		firstNameField.setForeground(Color.GRAY);
		firstNameField.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        if (firstNameField.getText().equals("First Name")) {
		            firstNameField.setText("");
		            firstNameField.setForeground(Color.BLACK);
		        }
		    }

		    public void focusLost(FocusEvent e) {
		        if (firstNameField.getText().isEmpty()) {
		            firstNameField.setText("First Name");
		            firstNameField.setForeground(Color.GRAY);
		        } else {
		            firstNameEdited = true;
		        }
		    }
		});
		panel.add(firstNameField);
		
		lastNameField = new JTextField("Last Name");
		lastNameField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		lastNameField.setBounds(88, 138, 290, 30);
		lastNameField.setForeground(Color.GRAY);
		lastNameField.addFocusListener(new FocusListener() {
		  public void focusGained(FocusEvent e) {
		    if (lastNameField.getText().equals("Last Name")) {
		    	lastNameField.setText("");
		    	lastNameField.setForeground(Color.BLACK);
		    }
		  }
		  public void focusLost(FocusEvent e) {
		    if (lastNameField.getText().isEmpty()) {
		    	lastNameField.setText("Last Name");
		    	lastNameField.setForeground(Color.GRAY);
	        } else {
	        	lastNameEdited = true;
	        }
	    }
	});
		panel.add(lastNameField);
		
		ageField = new JTextField("Age");
		ageField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		ageField.setForeground(Color.GRAY);
		ageField.setBounds(88, 188, 290, 30);
		panel.add(ageField);
		ageField.addFocusListener(new FocusListener() {
			  public void focusGained(FocusEvent e) {
			    if (ageField.getText().equals("Age")) {
			    	ageField.setText("");
			    	ageField.setForeground(Color.BLACK);
			    }
			  }
			  public void focusLost(FocusEvent e) {
			    if (ageField.getText().isEmpty()) {
			    	ageField.setText("Age");
			    	ageField.setForeground(Color.GRAY);
		        } else {
		        	ageEdited = true;
		        }
		    }
		});
		
		phonenumberField = new JTextField("Phone Number");
		phonenumberField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		phonenumberField.setBounds(88, 302, 290, 30);
		phonenumberField.setForeground(Color.GRAY);
		phonenumberField.addFocusListener(new FocusListener() {
		  public void focusGained(FocusEvent e) {
		    if (phonenumberField.getText().equals("Phone Number")) {
		    	phonenumberField.setText("");
		    	phonenumberField.setForeground(Color.BLACK);
		    }
		  }
		  public void focusLost(FocusEvent e) {
		    if (phonenumberField.getText().isEmpty()) {
		    	phonenumberField.setText("Phone Number");
		    	phonenumberField.setForeground(Color.GRAY);
	        } else {
	        	phoneEdited = true;
	        }
	    }
	});
		panel.add(phonenumberField);
		
		addressField = new JTextField("Address");
		addressField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		addressField.setBounds(88, 359, 290, 30);
		addressField.setForeground(Color.GRAY);
		addressField.addFocusListener(new FocusListener() {
		  public void focusGained(FocusEvent e) {
		    if (addressField.getText().equals("Address")) {
		    	addressField.setText("");
		    	addressField.setForeground(Color.BLACK);
		    }
		  }
		  public void focusLost(FocusEvent e) {
		    if (addressField.getText().isEmpty()) {
		    	addressField.setText("Address");
		    	addressField.setForeground(Color.GRAY);
	        } else {
	            addressEdited = true;

	        }
	    }
		});
		panel.add(addressField);
		
		emailField = new JTextField("Email");
		emailField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		emailField.setBounds(88, 419, 290, 30);
		emailField.setForeground(Color.GRAY);
		emailField.addFocusListener(new FocusListener() {
		public void focusGained(FocusEvent e) {
		if (emailField.getText().equals("Email")) {
		emailField.setText("");
		emailField.setForeground(Color.BLACK);
		}
		}
		public void focusLost(FocusEvent e) {
		if (emailField.getText().isEmpty()) {
		emailField.setText("Email");
		emailField.setForeground(Color.GRAY);
		}
		else if(!emailField.getText().isEmpty() && !emailField.getText().equals("Email")) {
	            emailEdited = true;
	            if(!isValidEmail(emailField.getText())) {
	            	emailStatusLabel.setText("Invalid email");
	            	emailStatusLabel.setForeground(Color.RED);
	        	}
	        }		
		}
		});
		panel.add(emailField);
	
		textField = new JTextField("");
		textField.setForeground(Color.GRAY);
		textField.setBounds(10, 22, 444, -5);
		panel.add(textField);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(99, 32, 243, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(Color.BLACK);
		panel_1_1_1_1.setBounds(88, 32, 386, 30);
		panel.add(panel_1_1_1_1);

		saveM = "";
		saveD = "";
		

		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		JComboBox<String> monthBox = new JComboBox<>(months);
		monthBox.setBounds(88, 240, 77, 30);
		monthBox.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		monthBox.setBackground(Color.WHITE);
		monthBox.setForeground(Color.BLACK);
		panel.add(monthBox);
		monthBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        saveM = selectedMonth; // save previous value
		        selectedMonth = (String) monthBox.getSelectedItem();
		    }
		});

		String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};    
		JComboBox<String> dayBox = new JComboBox<>(days);
		dayBox.setBounds(179, 240, 77, 30);
		dayBox.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		dayBox.setBackground(Color.WHITE);
		dayBox.setForeground(Color.BLACK);
		panel.add(dayBox);
		dayBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        saveD = selectedDay; // save previous value
		        selectedDay = (String) dayBox.getSelectedItem();
		    }
		});

		yearField = new JTextField("Year");
		yearField.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		yearField.setForeground(Color.GRAY);
		yearField.setBounds(268, 240, 110, 31);
		panel.add(yearField);
		yearField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			    if (yearField.getText().equals("Year")) {
			    	yearField.setText("");
			    	yearField.setForeground(Color.BLACK);
				    } else {
				    	
				    }
				  }

			public void focusLost(FocusEvent e) {
				if (yearField.getText().isEmpty()) {
					yearField.setText("Year");
					yearField.setForeground(Color.GRAY);
			    }
				else if (!yearField.getText().isEmpty()) {
					try {
					      int year = Integer.parseInt(yearField.getText());
					      int currentYear = Calendar.getInstance().get(Calendar.YEAR);
					      if (currentYear - year < 18) {
					    	  yearStatusLabel.setText("Must be 18 and up.");
					          yearStatusLabel.setForeground(Color.RED);
					      }
					    } catch (NumberFormatException ex) {
					     
					      
					    }
		        	yearEdited = false; 
				}
				else {
					yearEdited = true; 
		        }
			  }
			});

		JButton backButton = new JButton("<");
		backButton.setBackground(new Color(255, 255, 255));
		backButton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		backButton.setBounds(30, 32, 48, 28);
		backButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  	Welcome runFrame = new Welcome(); 
		        runFrame.setVisible(true);
		        Reg reg = (Reg) SwingUtilities.getWindowAncestor(backButton);
		        reg.dispose();
		  }
		});
		panel.add(backButton);
		
		JPanel eff1_2_1_1 = new JPanel();
		eff1_2_1_1.setLayout(null);
		eff1_2_1_1.setBackground(Color.LIGHT_GRAY);
		eff1_2_1_1.setBounds(0, 0, 454, 560);
		panel.add(eff1_2_1_1);
		
	}
	
	public String getFName() {
        return FName;
    }
	public String getLName() {
        return lName;
    }
	public String getAge() {
        return ageStr;
    }
	public String getMonth() {
        return selectedMonth;
    }
	public String getDay() {
        return selectedDay;
    }
	public String getYear() {
        return yearField.getText();
    }
	public String getPhone() {
        return phone;
    }
	public String getAddress() {
        return address;
    }
	public String getEmail() {
        return emailField.getText();
    }

	public void RunReg() {
		
		Reg frame = new Reg();
	 	frame.setResizable(false);
	 	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 	frame.setVisible(true); 
		
	}
}
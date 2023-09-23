package PHPay;

public class AccountInfo {
	private String fName, lName, gender, civil, age, month, day, year, phoneNum, address, email;
	
	public AccountInfo(String fName, String lName, String gender, String civil, String age, String month, String day, String year, String phoneNum, String address, String email) {
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.civil = civil;
		this.age = age;
		this.month = month;
		this.day = day;
		this.year = year;
		this.phoneNum = phoneNum;
		this.address = address;
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getGender() {
		return gender;
	}
	
	public String getCivil() {
		return civil;
	}
	
	public String getAge() {
		return age;
	}

	public String getMonth() {
		return month;
	}

	public String getDay() {
		return day;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getYear() {
		return year;
	}
}

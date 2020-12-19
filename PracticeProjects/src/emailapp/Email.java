package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength =  10;
	private String alternateEmail;
	private String email;
	private String companySuffix = "anycompany.com";
	// constructor to receive first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = setDepartment();
		this.password = randomPassword(defaultPasswordLength);
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +companySuffix;
		System.out.println("Password: "+password);
	}
	// ask for department
	private String setDepartment() {
		System.out.print("Department Codes:\n1: Sales\n"
				+ "2: Development"
				+ "\n3: Accounting\n0: None"
				+ "\nEnter dept:");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if(deptChoice == 1) return "sales.";
		else if(deptChoice == 2) return "dev.";
		else if(deptChoice == 3) return "acct.";
		else return "";  
	}
	// generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	// set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	// set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	// change the password
	public void changePassword(String password) {
		this.password = password;
	}
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	public String showInfo() {
		return "Display Name: "+firstName+" "+lastName+
				"\nCompany Email: "+email+
				"\nMailbox Capacity: "+mailboxCapacity+"mb";
	}
}

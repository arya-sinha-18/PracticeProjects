package bankaccountapp;

import java.util.Random;

public abstract class Account implements IBaseRate{
	// list common properties for savings and checking accounts
	private String name;
	private String ssn;
	private double balance;
	
	static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	// constructor to set base properties and initialize account
	public Account(String name, String ssn, double initDeposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = initDeposit;
		// set account number
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	}
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN = ssn.substring(ssn.length()-2, ssn.length());
		int uniqueId = index;
		// create a 3 digit random number
		int randomNumber = (int)generateRandom(3);
		return lastTwoOfSSN + uniqueId + randomNumber;
	}
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		showBalance();
	}
	// list common methods
	public void deposit(double amount) {
		balance += amount;
		showBalance();
	}
	public void withdraw(double amount) {
		balance -= amount;
		showBalance();
	}
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		showBalance();
	}
	public void showBalance() {
		System.out.println("Your balance is $"+balance);
	}
	public void showInfo() {
		System.out.println(
				"Name: "+name+
				"\nAccount Number: "+accountNumber+
				"\nBalance: "+balance+
				"\nRate: "+rate
				);
	}
	public static long generateRandom(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9)+'1');
		for(int i=1; i<length; i++) {
			digits[i] = (char)(random.nextInt(10)+'0');
		}
		return Long.parseLong(new String(digits));
	}
}

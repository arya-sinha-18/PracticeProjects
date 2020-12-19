package bankaccountapp;

public class Checking extends Account{
	// list properties specific to checking account
	private long debitCardNumber;
	private int debitCardPin;
	
	// constructor to initialize checking account properties
	public Checking(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = '2' + accountNumber;
		setDebitCard();
	}
	@Override
	public void setRate() {
		rate = getBaseRate()*0.15;
	}
	// list any methods specific to checking account
	private void setDebitCard() {
		debitCardNumber = generateRandom(12);
		debitCardPin = (int)generateRandom(4);
	}
	public void showInfo() {
		System.out.println("Type: Checking Account");
		super.showInfo();
		System.out.println(
				"Your checking account features: \n"+
			    "Debit Card Number: "+debitCardNumber+
			    "\nDebit Card Pin: "+debitCardPin
				);
	}
}

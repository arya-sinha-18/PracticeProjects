package bankaccountapp;

public class Savings extends Account {
	// list properties specific to savings account
	private int safetyDepositBoxId;// 3 digit 
	private int safetyDepositBoxKey;// 4 digit
	
	// constructor to initialize for the savings account
	public Savings(String name, String ssn, double initDeposit) {
		super(name, ssn, initDeposit);
		accountNumber = '1' + accountNumber;
		setSafetyDepositBox();
	}
	private void setSafetyDepositBox() {
		safetyDepositBoxId = (int)generateRandom(3);
		safetyDepositBoxKey = (int)generateRandom(4);
	}
	// list methods specific to savings account
	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
	public void showInfo() {
		System.out.println("Type: Savings Account");
		super.showInfo();
		System.out.println(
				"Your savings account features: \n"+
			    "Safety Deposit Box Id: "+safetyDepositBoxId+
			    "\nSafety Deposit Box Key: "+safetyDepositBoxKey
				);
	}
}

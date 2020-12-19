package bankaccountapp;
import java.util.LinkedList;
import java.util.List;
public class BankAccountApp {
	
	public static void main(String[] args) {
		
		List<Account> accounts = new LinkedList<Account>();
		
		String file = "C:\\Users\\dell\\Desktop\\NewBankAccounts.csv";
		// read a csv file to create new accounts
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for(String[] accountHolder: newAccountHolders) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
//			System.out.println(name+" "+ssn+" "+accountType+" "+initDeposit);
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name,ssn,initDeposit));
			}else if(accountType.equals("Checking")) {
				accounts.add(new Checking(name,ssn,initDeposit));
			}else {
				System.out.println("INVALID ACCOUNT TYPE");
			}
		}
		for(Account acc: accounts) {
			System.out.println("\n************");
			acc.showInfo();
		}
	}
}

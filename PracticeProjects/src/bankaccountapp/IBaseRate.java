package bankaccountapp;

public interface IBaseRate {
	// method to return the base rate
	default double getBaseRate() {
		return 2.5;
	}
}

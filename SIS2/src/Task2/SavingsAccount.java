package Task2;

public class SavingsAccount extends Account {
    private double interestRate = 5;

    public SavingsAccount(int a) {
        super(a);
    }
    
    public void setInterestRate(int interestRate) {
    	this.interestRate = interestRate;
    }

    public void addInterest() {
    	deposit(getBalance() * interestRate/100);
    }
    
    public String toString() {
    	return super.toString() + " => My interest rate: " + interestRate;
    }   
}
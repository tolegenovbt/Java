package Task2;

public class Account {
    private double balance;
    private int accNumber;

    public Account(int a) {
        balance = 0.0;
        accNumber = a;
    }

    public void deposit(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
    	if(sum>0)
        balance -= sum;
    }

    public double getBalance() {
        return balance;
    }

    public double getAccountNumber() {
        return accNumber;
    }

    public void transfer(double amount, Account other) {
        balance -= amount;
        other.balance += amount;
    }

    @Override
    public String toString() {
        return "Account number: " + accNumber + " Balance: " + balance + " ";
    }

    public final void print() {
        System.out.println(toString());
    }
    
    /*public boolean equals(Object o) {
		  if ((o == null) || !(o instanceof Account)) 
		  return false;
		  
		  return ((Account) o).getAccountNumber() == accNumber;
	}*/
}
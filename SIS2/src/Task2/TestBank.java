package Task2;

public class TestBank {
	
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		SavingsAccount savingsAccount = new SavingsAccount(1);
		CheckingAccount checkingAccount = new CheckingAccount(2);
		Account account = new Account(3);
		
		bank.openAccount(savingsAccount);
		bank.openAccount(checkingAccount);
		bank.openAccount(account);

		bank.update(500);
		savingsAccount.addInterest();
		System.out.println(bank.toString());
		bank.closeAccount(savingsAccount);
		account.transfer(40, checkingAccount);
		
		System.out.println(bank.toString());
	}

}

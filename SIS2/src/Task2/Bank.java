package Task2;

import java.util.Vector;

public class Bank {
   Vector<Account> accounts = new Vector<Account>();
   
   public void update(int sum) {
	   for(Account account : accounts) {
		   account.deposit(sum);
		   
		   if(account instanceof CheckingAccount) 
			   ((CheckingAccount) account).deductFee();
		   else if(account instanceof SavingsAccount) 
			   ((SavingsAccount) account).addInterest();
	   }
   }
   
   public void openAccount(Account account) {
	   accounts.add(account);
   }
   
   public void closeAccount(Account account) {
	   accounts.remove(account);
   }
   
   public String toString() {
	   String str = "";
	   for(Account account : accounts) {
		   str += account.toString() + "\n";
	   }
	   return str;
   }
}

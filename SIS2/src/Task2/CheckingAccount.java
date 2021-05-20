package Task2;

public class CheckingAccount extends Account{
    
	private int counter;
    private int FREE_TRANSACTIONS = 2;

    public CheckingAccount(int a) {
        super(a);
    }
    
    public void deductFee() {
    	counter++;
    	if(counter >= FREE_TRANSACTIONS)
    		withdraw(0.02);
    }
    
    public String toString() {
    	if(counter == 1) return super.toString() + " => I have made " + counter +  " transaction";
    	else return super.toString() + "I have made " + counter +  " transactions";
    }
}
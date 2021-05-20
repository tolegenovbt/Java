import java.util.Scanner;
public class Task5 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your current balance: ");
		double curBal = in.nextDouble();
		System.out.println("Enter interest: ");
		double interest = in.nextDouble();
		addBal(curBal, interest);
		in.close();
	}
	public static void addBal(double curBal, double interest)
	{
		double newBal = curBal+ curBal*interest*0.01;
		System.out.println("Your new balance: "+newBal);
	}
}

import java.util.Scanner;
public class Task3 {
	public static void main(String[] args)
	{
		System.out.print("Enter your number: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		getGrade(n);
		in.close();
	}
	public static void getGrade(int n)
	{
		if(n<=100 && n>=0)
		{
			if(n<=100 && n>=95)
				System.out.println("A");
			if(n<95 && n>=90)
				System.out.println("A-");
			if(n<90 && n>=85)
				System.out.println("B+");
			if(n<85 && n>=80)
				System.out.println("B");
			if(n<80 && n>=75)
				System.out.println("B-");
			if(n<75 && n>=70)
				System.out.println("C+");
			if(n<70 && n>=65)
				System.out.println("C");
			if(n<65 && n>=60)
				System.out.println("C-");
			if(n<60 && n>=55)
				System.out.println("D+");
			if(n<55 && n>=50)
				System.out.println("D");
			if(n<50)
				System.out.println("F");
		}
		else
		{
			System.out.println("Incorrect number!");
		}
	}
}

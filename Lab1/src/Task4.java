import java.util.Scanner;
public class Task4 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();		
		Roots(a,b,c);
		in.close();
	}
	public static void Roots(int a, int b, int c)
	{
		int D = b*b - 4*a*c;
		if(D<0)
			System.out.println("Impossible to find roots");
		else
		{
			double x1 = (-b+Math.sqrt(D))/2*a;
			double x2 = (-b-Math.sqrt(D))/2*a;
//			if((-b+Math.sqrt(D))%2*a==0)
			System.out.println("the first root is "+x1);
			System.out.println("the second root is "+x2);
		}
	}
}

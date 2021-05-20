import java.util.Scanner;
public class Task2 {
	public static void main(String[] args)
	{
		System.out.print("Please enter a square's side: ");
		Scanner in = new Scanner(System.in);
		int side = in.nextInt();
		Find(side);
		in.close();
	}
	public static void Find(int a)
	{
		int area = a*a;
		int perimeter = 4*a;
		double diagonal = a*Math.sqrt(2);
		System.out.println("The area of the square is "+area);
		System.out.println("The perimeter of the square is "+perimeter);
		System.out.println("The lenght of diagonal of the square is "+diagonal);
	}
}

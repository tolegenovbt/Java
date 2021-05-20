import java.util.Scanner;
public class Task1 {
	public static void main(String[] args)
	{
		System.out.print("Please enter your name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		Print(name);
		in.close();
	}
	public static void Print(String name)
	{
		int n = name.length();
		System.out.print("+");
		for(int i =0 ;i<n;i++)
		System.out.print("-");
		System.out.println("+");
		System.out.println("|"+name+"|");
		System.out.print("+");
		for(int i =0 ;i<n;i++)
		System.out.print("-");
		System.out.println("+");
	}
}

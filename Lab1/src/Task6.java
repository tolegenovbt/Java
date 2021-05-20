import java.util.Scanner;
public class Task6 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a string to check if it is a polindrom: ");
		String s = in.nextLine();
		System.out.print(Check(s));
		in.close();
	}
	public static String Check(String s) {
		int n = s.length();
		s = s.toUpperCase();
		for(int i = 0; i<=n/2; i++)
		{
			if(s.charAt(i) != s.charAt(n-i-1))
			{
				return "The string is not a polindrom!";
			}
		}
		return "The string is a polindrom!";
	}
}

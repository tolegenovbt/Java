package Task2;
import java.util.Scanner;
class StarTriangle
{
	public int width;
	public StarTriangle(int width)
	{
		this.width = width;
	}
	public String toString()
	{
		String s = "";
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<=i;j++)
				s+="[*]";
			s+="\n";
		}
		return s;
	}
}
public class Task2 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter width of the Star Triangle: ");
		StarTriangle st = new StarTriangle(in.nextInt());
		System.out.print(st.toString());
		in.close();
	}
}

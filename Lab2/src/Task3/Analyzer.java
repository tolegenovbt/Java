package Task3;
import java.util.Scanner;
class Data
{
	private int cnt=0;
	private double sum = 0;
	private double maximum;
	
	public Data()
	{
		
	}
	
	public void setData(int integer)
	{
		sum+=integer;
		cnt++;
		if(cnt==1)
		maximum=integer;
		else
			if(maximum<integer)
				maximum=integer;
	}
	public double getAverage()
	{
		if(cnt!=0)
			return sum/cnt;
		else
			return 0;
	}
	public double getMax()
	{
		return maximum;
	}
}

public class Analyzer{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
//		String s = "0";
		Data data = new Data();
		while(true)
		{
			System.out.print("Enter number or Q to quit: ");
			 String s = in.nextLine();
			 if(s.toUpperCase().equals("Q") )
				 break;
			 else if(isNumeric(s))
				 data.setData(Integer.parseInt(s));
			 else
				 System.out.println("Enter a correct input!");
			 
		}
		System.out.println("Average = "+data.getAverage());
		System.out.println("Maximum = "+data.getMax());
		in.close();
	}
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
}

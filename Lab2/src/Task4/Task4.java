package Task4;
import java.util.Scanner;

class Time
{
	private int hour;
	private int minute;
	private int second;
	
	public Time(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public String toUniversal()
	{
		return checkOut(hour)+":"+checkOut(minute)+":"+checkOut(second);
	}
	public String toStandart()
	{
		String end;
		if(hour>12)
		{
			hour-=12;
			end = "PM";
		}
		else
			end = "AM";
		return checkOut(hour)+":"+checkOut(minute)+":"+checkOut(second)+" "+end;
	}
	private String checkOut(int time)
	{
		if(time<10)
			return "0"+time;
		else
			return ""+time;
	}
	public void add(Time t2)
	{
		t2.second=second+t2.second;
		t2.minute=minute+t2.minute;
		t2.hour=hour+t2.hour;
		if(t2.second>=60)
		{
			t2.minute++;
			t2.second-=60;
		}
		else if(t2.minute>=60)
		{
			t2.hour++;
			t2.minute-=60;
		}
		else if(t2.hour>=24)
		{
			t2.hour-=24;
		}
		System.out.println(t2.toUniversal());
		System.out.println(t2.toStandart());
		
	}
//	private String checkHour(int hour)
//	{
//		if(hour<10)
//			return 0+Integer.toString(hour)+":";
//		else
//			return Integer.toString(hour)+":";
//	}
//	private String checkHour2(int hour)
//	{
//		if(hour>12)
//		{
//			hour-=12;
//			if(hour<10)
//				return 0+Integer.toString(hour)+":";
//			else
//				return Integer.toString(hour)+":";
//		}
//		else
//		{
//			if(hour<10)
//				return 0+Integer.toString(hour)+":";
//			else
//				return Integer.toString(hour)+":";
//		}
//	}
//	private String checkMinute(int minute)
//	{
//		if(minute<10)
//			return 0+Integer.toString(minute)+":";
//		else
//			return Integer.toString(minute)+":";
//	}
//	private String checkSecond(int second)
//	{
//		if(second<10)
//			return 0+Integer.toString(second);
//		else
//			return Integer.toString(second);
//	}
}
public class Task4 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
//		Time t = new Time(in.nextInt(),in.nextInt(),in.nextInt());
		int h = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt();
		int h2 = in.nextInt();
		int m2 = in.nextInt();
		int s2 = in.nextInt();
		
		if(h<24 && h>=0 && m<60 && m>=0 && s<60 && s>=0 && h2<24 && h2>=0 && m2<60 && m2>=0 && s2<60 && s2>=0)
		{
			Time t= new Time(h,m,s);
			Time t2 = new Time(h2,m2,s2);
			System.out.println(t.toUniversal());
			System.out.println(t.toStandart());
			t.add(t2);
		}else
			System.out.println("Incorrect input!");
		in.close();
			
	}
}


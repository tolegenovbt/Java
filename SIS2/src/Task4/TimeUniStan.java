package Task4;


class Time implements Comparable{
	
	private int hour,minute,second;
	
	Time(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute; 
		this.second= second;
	}
	
	
	   public void Add(Time t) {
		   this.hour += t.hour;
		   this.minute += t.minute;
		   this.second += t.second;
	   }
	
	   String toUniversal() {
		   String str = "";
		   if(this.hour< 10) {
			   str += "0" + Integer.toString(this.hour) + ":";
		   }
		   else {
			   str += Integer.toString(this.hour) + ":";
		   }
		   if(this.minute < 10) {
			   str += "0" + Integer.toString(this.minute) + ":";
		   }
		   else {
			   str += Integer.toString(this.minute) + ":";
		   }
		   if(this.second < 10) {
			   str += "0" + Integer.toString(this.second);
		   }
		  
		   return str;
	   }
	   
	   String toStandard() {
		   String str2 = "";
		   if (this.hour >= 12 && this.minute > 0 && this.hour <= 23)
		   {
			   
			   str2 += Integer.toString(this.hour - 12) + ":";
			   
			   if(this.minute < 10)
			   {
				   str2 += "0" + Integer.toString(this.minute)+ ":"; 
			   }
			   else {
				   str2 += this.minute + ":";
			   }
			   if(this.second < 10)
			   {
				   str2 += "0" + Integer.toString(this.second)+ " PM"; 
			   }
			   else {
				   str2 += Integer.toString(this.second) + " PM";
			   }
		   }
		   else 
		   {
			 if(this.hour == 24) {
				 str2 += "00:";
			 }
			 else {
				 str2 += Integer.toString(this.hour) + ":";
			 }
			 if(this.minute < 10)
			   {
				   str2 += "0" + Integer.toString(this.minute)+ ":"; 
			   }
			   else {
				   str2 += Integer.toString(this.minute) + ":";
			   }
			   if(this.second < 10)
			   {
				   str2 += "0" + Integer.toString(this.second)+ " AM"; 
			   }
			   else {
				   str2 += Integer.toString(this.second) + " AM";
			   }
		   }
		    
		   return str2;
}


	@Override
	public int compareTo(Object  o) {
		Time other = (Time) o;
		if(hour < other.hour) return -1;
		if(hour > other.hour) return 1;
		return 0;
	}
}

public class TimeUniStan {
     public static void main(String[] args) {
    	 Time time = new Time(11, 5, 7);
         System.out.println("Standard: " + time.toStandard());
         System.out.println("Universal: " + time.toUniversal());
         Time t2 = new Time(4, 24, 34);
         time.Add(t2);
         System.out.println("----------------------------------");
         System.out.println("Standard: " + time.toStandard());
         System.out.println("Universal: " + time.toUniversal());
         System.out.println(time.compareTo(t2));
	}    
}

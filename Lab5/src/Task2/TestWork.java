package Task2;

import java.util.Date;

public class TestWork {
	   public static void main(String[] args) {
		   
		   Employee bekzat = new Employee("Bekzat", 19, 12015,new Date(),"18BD111651");
		   Employee aibar = new Employee("Aibar" ,18 ,11500,new Date(),"18BD111209");
		   
		   System.out.println(bekzat.compareTo(aibar));
		   
		   System.out.println("");
		   
		   Manager aibarManager = new Manager("Aibar",18, 150000, new Date(), "18BD111209", 12000);
		   Manager bekzatManager = new Manager("Bekzat", 18, 150000, new Date(), "18BD111651", 13000);
		   System.out.println(aibarManager.compareTo(bekzatManager));
	}
	}
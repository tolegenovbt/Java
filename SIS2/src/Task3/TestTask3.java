package Task3;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestTask3 {
	   public static void main(String[] args) throws CloneNotSupportedException {
		   
		   Date bekzatDate = new GregorianCalendar(2014, 2, 11).getTime();
		   Date diasDate = new Date();
		   Date adilbekDate = new GregorianCalendar(2018, 10, 12).getTime();
		   
		   Employee bekzat = new Employee("Bekzat", 18, 12015,bekzatDate,"18BD111651");
		   Employee dias = new Employee("Dias" ,18 ,11500,diasDate,"18BD111209");
		   Employee adilbek = new Employee("Adilbek" ,18 ,1200,adilbekDate,"18BD111459");
		   
		   System.out.println("Employee compare: " + bekzat.compareTo(dias));
		   
		   System.out.println("-------------------------");
		   
		   Manager diasManager = new Manager("Dias",18, 150000, new Date(), "18BD111209", 12000);
		   Manager bekzatManager = new Manager("Bekzat", 18, 150000, new Date(), "18BD111651", 13000);
		   System.out.println("Manager Compare: "+ bekzatManager.compareTo(diasManager));
		   Manager m1 = bekzatManager.clone();
		   
		   System.out.println("-------------------------");
		   System.out.println(m1.toString());
		  
		   
		   ArrayList<Employee> myArrayList  = new ArrayList<Employee>();
		   myArrayList.add(bekzat);
		   myArrayList.add(dias);
		   myArrayList.add(adilbek);
		   
		   System.out.println("-------------------------\nJustPrint: ");
		   for(Employee e: myArrayList) {
			   System.out.println(e);
		   }
		   
		   NameComparator nmc = new NameComparator();
		   myArrayList.sort(nmc);
		   
		   System.out.println("-------------------------\nSorted by name: ");
		   for(Employee e: myArrayList) {
			   System.out.println(e);
		   }
		   
		  HireDateComparator hdc = new HireDateComparator();
		  myArrayList.sort(hdc);
		  
		  
		  System.out.println("--------------------------\nSorted by hire date: ");
		  for(Employee e: myArrayList) {
			   System.out.println(e);
		   }
		   
		   
	}
	}
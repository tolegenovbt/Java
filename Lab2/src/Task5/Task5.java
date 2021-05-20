package Task5;
import java.util.Scanner;


public class Task5 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("What is the day of the week today? ");
    String dayofweak = in.nextLine();
    
    Class class1 = new Class(Day.valueOf(dayofweak.toUpperCase()));
    
    System.out.print(class1.WhatToDo());
    in.close();
  }
}


enum Day{
  MONDAY,
  TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

class Class{
 
  String str = ""; 
  Day day;

  public Class(Day day) {
      this.day = day;
  }

  String WhatToDo() {
	  
	  switch(day)
	  {
	  case MONDAY:
		  return "\nRussian language                                            -- 13:00 - 14:00 \r\n" + 
		         "Differential Equations and Application to the Circuit Theory  ---  15:00-18:00 ";
		   
	  case TUESDAY:
		  str = "\nYou have a creative day today!!! ";
		  break;
	  case WEDNESDAY:
		  str = "\nDataBase practice      --   12:00-13:00 \r\n"+
				  "Russian language       -- 13:00 - 14:00 \r\n"+
				  "DataBase lecture      --   16:00-18:00";
		  break;
	  case THURSDAY:
		  str = "\nOOP      --   10:00-13:00";
		  break;
	
	  case FRIDAY:
		  str = "\nComuter Networks  ---    9:00-12:00 \r\n" + 
                "Russian language    ---    13:00-16:00";
		  break;
	  case SATURDAY:
		  str = "\nAlgorithms and data structures         ---       8:00-11:00 \r\n ";
		  break;
	  case SUNDAY:
		   str = "\nYou have a rest today";
		   break;
	  default:
		  str = "\nAre you sure that it is the day of weak? ";
		
	  }
    
   return str;
}
}


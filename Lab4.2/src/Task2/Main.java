/*package Task2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

public static void main(String[] args) throws ClassNotFoundException, IOException { 
	 Scanner in = new Scanner(System.in);
     String log;
     String username;
     String password;
     while(true)
     {
         System.out.println("Log in as Admin - write <admin>");
         System.out.println("Log in as User - write <user>");
         System.out.println("Quit the system - write <quit>");
         log = in.next();
         switch (log)
         {
             case "admin":
                 System.out.println("Please, write your username:");
                 username = in.next();
                 System.out.println("Please, write your password:");
                 password = in.next();
                 Driver.adminMode(username, password);
                 break;
             case "user":
                 Driver.userMode();
                 break;
             case "quit":
                 System.exit(0);
             default:
                 System.out.println("Wrong input format!");
                 break;
         }
         	
     }
}

}*/

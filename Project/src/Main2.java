import java.util.*;
import java.lang.*;
import java.io.*;
public class Main2 {
	public static void deserializeObjects() throws IOException, ClassNotFoundException{
        if(new File("users.ser").exists()) Database.desUsers();
//        if(new File("specialities.ser").exists()) Database.desSpecialities();
//        if(new File("students.ser").exists()) Database.desStudents();
//        if(new File("teachers.ser").exists()) Database.desTeachers();
//        if(new File("managers.ser").exists()) Database.desManagers();
//        if(new File("techSupportGuys.ser").exists()) Database.desTechSupportGuys();
//        if(new File("admins.ser").exists()) Database.desAdmins();
//        if(new File("orders.ser").exists()) Database.desOrders();
//        if(new File("courses.ser").exists()) Database.desCourses();
    }
	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException
	{
		try
		{
//			deserializeObjects();
			Database.desUsers();
			System.out.println("----------Users-------------\n");
			for(User user:Database.users)
			{
				System.out.println(user.toString());
			}
//			System.out.println("\n\n----------Teachers-------------\n");
//			for(Teacher teacher:Database.teachers)
//			{
//				System.out.println(teacher.toString());
//			}
//			System.out.println("\n\n----------Students-------------\n");
//			for(Student student:Database.students)
//			{
//				System.out.println(student.toString());
//			}
		}
		catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Can’t read from file");
        }
		
	}
}	
package Task1;
import java.util.Scanner;

public class StudentTask {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter name of a student: ");
		String name = in.nextLine();
		System.out.println("Enter the student's ID: ");
		String	ID = in.nextLine();
		Student student = new Student(name, ID);
		System.out.println(student.getName()+"  "+student.getID()+"  "+student.getYear());
		in.close();
	}
	
}

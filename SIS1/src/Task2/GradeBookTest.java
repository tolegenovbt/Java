package Task2;
import java.util.Scanner;

import SS.Student;
public class GradeBookTest {
	public static void main(String[] args)
	{
		Course course = new Course("Object-oriented Programming", "OOP in Java", 3);
		GradeBook gradeBook = new GradeBook(course);
		gradeBook.setStudent(new Student("Bekzat", "18BD111653"));
		gradeBook.setStudent(new Student("Nurzhan", "18BD101754"));
		gradeBook.setStudent(new Student("Aidana", "18BD110302"));
		gradeBook.setStudent(new Student("Gaziz", "18BD101985"));
		gradeBook.setStudent(new Student("Aruzhan", "18BD111123"));
		gradeBook.setStudent(new Student("Oleg", "18BD110298"));
		Scanner in = new Scanner(System.in);
		gradeBook.displayMessage();
		System.out.println("Please, input grades for students: ");
		for(int i=0;i<gradeBook.students.size();i++)
		{
			System.out.printf("Student %s: ", gradeBook.students.get(i).getName() );
			double grade = in.nextDouble();
			if(grade<=100 && grade>=0)
			gradeBook.students.get(i).setGrade(grade);
		}
		gradeBook.displayGradeReport();
		in.close();
	}
}

package Task2;
import java.util.ArrayList;
import SS.Student;
public class GradeBook {
	private Course course;
	public  ArrayList<Student> students= new ArrayList<Student>();
	public GradeBook()
	{
		
	}
	public GradeBook(Course course)
	{
		this.course = course;
	}
	public void setStudent(Student student)
	{
		students.add(student);
	}
	void displayMessage()
	{
		System.out.printf("Welcome to the grade book for %s!\n",course.getName());
	}
	void displayGradeReport()
	{
		determineClassAverage();
		determineClassMax();
		determineClassMin();
		outputBarChar();
	}
	void determineClassAverage()
	{
		double sum=0;
		for(int i=0;i<students.size();i++)
		{	
			double grade = students.get(i).getGrade();
			sum+=grade;
		}
		System.out.println("Class average is "+sum/students.size());
		
	}
	void determineClassMax()
	{
		int maxIndex=0;
		double max=0;
		for(int i=0;i<students.size();i++)
		{	
			double grade = students.get(i).getGrade();
			if(grade>max)
			{
				maxIndex=i;
				max=grade;
			}
		}
		System.out.printf("The highest grade is "+ max+"(Student: %s, id: %s) .",students.get(maxIndex).getName(),students.get(maxIndex).getID());
	}
	void determineClassMin()
	{
		int minIndex=0;
		double min=100;
		for(int i=0;i<students.size();i++)
		{	
			double grade = students.get(i).getGrade();
			if(grade<min)
			{
				minIndex=i;
				min=grade;
			}
		}
		System.out.printf("The lowest grade is "+min+"(Student: %s, id: %s).\n",students.get(minIndex).getName(),students.get(minIndex).getID());
	}
	void outputBarChar()
	{
		int[] cnt;
		cnt = new int[11];
		for(int i=0;i<students.size();i++)
		{
			double grade = students.get(i).getGrade();
			if(grade==100)
				cnt[10]++;
			if(grade<=99 && grade>=90)
				cnt[9]++;
			if(grade<=89 && grade>=80)
				cnt[8]++;
			if(grade<=79 && grade>=70)
				cnt[7]++;
			if(grade<=69 && grade>=60)
				cnt[6]++;
			if(grade<=59 && grade>=50)
				cnt[5]++;
			if(grade<=49 && grade>=40)
				cnt[4]++;
			if(grade<=39 && grade>=30)
				cnt[3]++;
			if(grade<=29 && grade>=20)
				cnt[2]++;
			if(grade<=19 && grade>=10)
				cnt[1]++;
			if(grade<=9 && grade>=0)
				cnt[0]++;
		}
		System.out.println("Grades distribution");
		int a=0,b=9;
		for(int i=0;i<11;i++)
		{
			if(a!=100)
			System.out.printf("%d-%d:",a,b);
			else
				System.out.print("100: ");
			for(int j=0;j<cnt[i];j++)
				System.out.print("* ");
			System.out.print("\n");
			a+=10; b+=10;
		}
		
	}
}

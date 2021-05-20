package SS;
public class Student
{
	private String name;
	private String id;
//	private int year;
	private double grade;
	public Student(String name, String id)
	{
		this.name = name;
		this.id = id;
//		year = 19-Integer.parseInt(id.substring(0, 2))+1;
	}
	
	public String getName() {return name;}
	public String getID() {return id;}
	public double getGrade() {return grade;}
//	public int getYear()
//	{
//		
//		return ++year;
//	}
	public String toString()
	{
		return name+" "+id+"";
	}
	public void setGrade(double grade)
	{
		this.grade = grade;
	}
}
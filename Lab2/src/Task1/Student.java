package Task1;

public class Student
{
	private String name;
	private String id;
	private int year;
	
	public Student(String name, String id)
	{
		this.name = name;
		this.id = id;
		year = 19-Integer.parseInt(id.substring(0, 2))+1;
	}
	
	public String getName() {return name;}
	public String getID() {return id;}
	public int getYear(){return ++year;}
	public String toString()
	{
		return name+" "+id+"";
	}
}
package Task2;
import java.util.ArrayList;
public class Course {
	private String name;
	private String description;
	private int credits;
	private ArrayList<String> prerequisites;
	
	public Course(String name, String description, int credits)
	{
		this.name = name;
		this.description = description;
		this.credits = credits;
	}
	public String toString()
	{
		return name+" "+description+" "+credits;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public int getCredits()
	{
		return credits;
	}
	public ArrayList<String> getPrerequisites()
	{
		return prerequisites;
	}
}

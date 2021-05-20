import java.io.Serializable;
import java.util.Vector;
public class Student implements Serializable{
	int id;
	String name;
	Vector<Course> courses = new Vector<Course>();
	public Student(String name) {
		this.id = Database.students.size()+1;
		this.name = name;
	}
	public boolean addCourse(Course c){
		return courses.add(c);
	}
	public String toString(){
		return name+ ", id is "+id+", registered courses:  "+(courses.size()==0?"No courses yet ":courses);
	}
}

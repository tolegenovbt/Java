package Task2;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Course implements Serializable{

	private String courseTitle;
    private Textbook textbook;
    private Instructor instructor;
    
	public Course(String courseTitle, Textbook textbook, Instructor instructor) {
		this.courseTitle = courseTitle;
		this.textbook = textbook;
		this.instructor = instructor;
	}
	
	public String getCourseTitle() {
        return courseTitle;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setTextbook(Textbook textbook) {
        this.textbook = textbook;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
   
    @Override
    public String toString() {
    	return "\tCourse:" + courseTitle + "\n\t" + "Teacher: "+ instructor.toString() + "\n\t" + "Book: " +  textbook.toString();
    }
    
    public boolean equals(Object object) {
    	if(object == this ) return true;
    	if(object instanceof Course) {
    		Course c = (Course)object;
    		return (this.courseTitle.equals(c.courseTitle) &&
    				this.instructor.equals(c.instructor) &&
    				this.textbook.equals(c.textbook));
    	}
    	return false;
    }
    
    public static void save(Vector<Course> courses) throws IOException {
        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("Courses.out", false));
        oos.writeObject(courses);
        oos.close();
    }

    public static Vector<Course> get() throws IOException, ClassNotFoundException{
    	FileInputStream fis = new FileInputStream("Courses.out"); 
        ObjectInputStream ois = new ObjectInputStream(fis);
        @SuppressWarnings("unchecked")
		Vector<Course> courses = (Vector<Course>)ois.readObject();
        ois.close();
        return courses;
    }

}

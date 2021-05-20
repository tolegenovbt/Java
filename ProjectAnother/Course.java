package package1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("serial")
public class Course implements Serializable{
	ArrayList<Student> students;
	Teacher lector;
	static int idNext = Database.courses.size()+1;
	String courseName;
	int courseId ;
	int credits;
	int courseIsFor;
	boolean available = false;
	ArrayList<CourseFile> courseFiles;
	Date finalDate;
	private ArrayList<Course> prerequisites;
	
	public Course(Teacher teacher,String courseName, int credits, int courseFor, boolean available) {
		this.courseId = idNext++;
		this.courseName = courseName;
		this.lector = teacher; this.credits = credits; this.courseIsFor = courseFor;
		this.available = available;
	}
	
	public void setCourseLector(Teacher lector) {
		this.lector = lector;
	}
	
	public void addCourseFile(CourseFile cs) {
		if (courseFiles==null)
			courseFiles = new ArrayList<CourseFile>();
		courseFiles.add(cs);
	}
	
	public void setAvailableTrue() {
		this.available = true;
	}
	
	public void setAvailableFalse() {
		this.available = false;
	}
	
	public void addStudent(Student student) {
		if (students==null)
			students = new ArrayList<Student>();
		students.add(student);
		student.addCourse(this);
	}
	
	public String toString() {
		return "Course Name : " + courseName + " " + courseId + " Teacher " + lector + " Credits " + credits + " CourseIsFor " + courseIsFor + " Available " + 
				available + " Prerequisites " + prerequisites + "\n";
	}
	
	public boolean equals(Object c) {
		if (c == this)
			return true;
		if (c==null || c.getClass()!=this.getClass())
			return false;
		Course course = (Course) c;
		return course.available == this.available && course.courseId==this.courseId && course.courseIsFor == this.courseIsFor
				&& course.courseName == this.courseName && course.credits == this.credits;
	}
	
	public int compareTo(Object o) {
		Course ch = (Course) o;
		if (ch.courseId < this.courseId) {
			return 1;
		}else if (ch.courseId > this.courseId){
			return -1;
		}
		return 0;
	}
	
}

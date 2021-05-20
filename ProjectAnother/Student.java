package package1;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Student extends User implements Serializable{
	private static int idNext = 0;
	private int studentId;
	private int yearOfStudy;
	private ArrayList<StudentCourse> courses;
	private ArrayList<Course> retake;
	private Faculty faculty;
	private ArrayList<StudentCourse> closedCredits;
	
	public Student () {
		idNext += Database.students.size();
	}
	
	public Student(String login, String password, String userSurName, String userName, String userFatherName,
			int yearOfStudy, Faculty faculty) {
		super(login,password,userSurName,userName,userFatherName);
		this.studentId = ++idNext;
		this.yearOfStudy = yearOfStudy;
		this.faculty = faculty;
	}
	
	public boolean registerForCourse(int courseId) {
		Course course = null;
		for(Course c : Database.courses) {
			if (c.courseId == courseId) {
				course = c;
			}
		}
		if (course==null)
			return false;
		if (course.courseIsFor == yearOfStudy) {
			StudentCourse sc = new StudentCourse(course, new Mark());
			if (courses == null)
				courses = new ArrayList<StudentCourse>();
			courses.add(sc);
			return true;
		}
		return false;
	}
	
	public boolean putMarkForCourse(Course cs , int a, int b, int f) {
		
		for(StudentCourse stc : courses) {
			if (stc.course.equals(cs)) {
				stc.mark = new Mark(a,b,f);
				return true;
			}
		}
		return false;
		
		
//		for(StudentCourse sc : courses) {
//			if (sc.course.equals(cs)) {
//				sc.setMark(a, b, f);
//				return true;
//			}
//		}
//		return false;
	}
	
	public ArrayList<Course> viewAvailableCourses(){
		ArrayList<Course> availableCourses = new ArrayList<Course>();
		for(Course c : Database.courses) {
			if (c.courseIsFor == yearOfStudy && c.available == true) {
				availableCourses.add(c);
			}
		}
		return availableCourses;
	}
	
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	
	public void addCourse(Course course) {
		StudentCourse sc = new StudentCourse(course, new Mark());
		if (courses == null) {
			courses = new ArrayList<StudentCourse>();
		}
		courses.add(sc);
	}
	
	public ArrayList<StudentCourse> viewActiveCourses(){
		return this.courses;
	}
	
	public void incrementYearOfStudy() {
		this.yearOfStudy++;
	}

	public ArrayList<Course> viewRetakeCourses(){
		return this.retake;
	}
	
	public void addRetake(Course course) {
		this.retake.add(course);
	}
	
	public double getGPA() {
		double sum = 0;
		for(StudentCourse sc : courses) {
			sum += sc.mark.getTotal();
		}
		return 4 * sum / courses.size();
	}
	
	public ArrayList<StudentCourse> viewClosedCourses(){
		if (closedCredits == null)
			return null;
		return this.closedCredits;
	}
	
	public int compareTo(Object o) {
		Student ch = (Student) o;
		if (ch.studentId < this.studentId) {
			return 1;
		}else if (ch.studentId > this.studentId){
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return studentId + " " + super.toString() + " " + yearOfStudy + " " + faculty;
	}
}

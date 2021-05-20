package package1;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Manager extends Employee implements Serializable{		
	public Manager(String login, String password, String userSurName, String userName, String userFatherName,
			int salary) {
		super(login, password, userSurName, userName, userFatherName, salary);
	}
	
	public boolean sendMessageTo(int tid, String body) {
		for(Teacher t : Database.teachers) {
			if (t.getId() == tid) {
				t.receiveMessage(body);
				return true;
			}
		}
		return false;
	}
	
	public void openCourseRegistration() {
		for(Course course : Database.courses) {
			course.setAvailableTrue();
		}
	}
	
	public boolean setCourseTeacher(int cid, int tid) {
		for(Course c : Database.courses) {
			if (c.courseId == cid) {
				for(Teacher t : Database.teachers) {
					if (t.getId() == tid) {
						c.setCourseLector(t);
						t.addCourse(c);
						return true;
					}
				}
			}	
		}
		return false;
	}
	
	public void closeCourseRegistration() {
		for(Course course : Database.courses) {
			course.setAvailableFalse();
		}
	}
	
	public boolean createCourse(int teachId, String courseName, int credits, int yearOfStudy) {
		for(Teacher t : Database.teachers) {
			if (t.getId() == teachId) {
				Course course = new Course(t, courseName, credits, yearOfStudy , false);
				Database.addCourse(course);
				t.addCourse(course);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Student> getStudents(){
		return Database.students;
	}
	
	public boolean registerStudentsTo(int cid) {
		for(Course c : Database.courses) {
			if (cid == c.courseId) {
				if (c.lector == null)
					return false;
				for(Student s : Database.students) {
					if (s.getYearOfStudy() == c.courseIsFor) {
						c.addStudent(s);
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Course> getCourses(){
		return Database.courses;
	}
	
	public ArrayList<Teacher> getTeachers(){
		return Database.teachers;
	}
	
	public String toString() {
		return super.toString();
	}
	
}

package package1;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Teacher extends Employee implements Serializable{
	private TeacherRole teacherRole = TeacherRole.Lector;
	private ArrayList<String> messages;
	private ArrayList<Course> courses;
	public Teacher() {
		courses = new ArrayList<Course>();
	}
	public Teacher(String login, String password, String userSurName, String userName, String userFatherName,
			TeacherRole post, int salary) {
		super(login,password,userSurName,userName,userFatherName, salary);
		this.teacherRole = post;
	}
	
	public ArrayList<Course> getCourses(){
		if (courses != null) {
			return courses;
		}
		return null;
	}
	
	public void receiveMessage(String body) {
		if (messages == null)
			messages = new ArrayList<String>();
		messages.add(body);
	}
	
	public ArrayList<String> viewMessages(){
		return messages;
	}
	
	public void sendMessage(TechSupport ts, String title, String report) {
		Order o = new Order(title, report);
		ts.receiveOrder(o);
	}
	
	public void addCourse(Course course) {
		course.setCourseLector(this);
		Database.addCourse(course);
		if (courses == null) {
			courses = new ArrayList<Course>();
		}
		this.courses.add(course);
	}
	
	private boolean isThisTeacher(Course course) {
		for(Course c : courses) {
			if (c.equals(course)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean sendReport(int tid, String title, String report) {
		for(TechSupport t : Database.techSupports) {
			if (t.getId() == tid) {
				t.receiveOrder(new Order(title, report));
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Student> getListOfStudentOf(int cid){
		for(Course c : courses) {
			if (c.courseId == cid) {
				return c.students;
			}
		}
		return null;
	}
	
	public Course getCourse(int cid) {
		for(Course c : courses) {
			if (cid == c.courseId) {
				return c;
			}
		}
		return null;
	}
	
	public boolean putMarkForAtt(Student st, Course cs, int m1, int m2 , int f1) {
		for(StudentCourse stc : st.viewActiveCourses()) {
			if (stc.course.equals(cs)) {
				stc.mark = new Mark(m1,m2,f1);
				return true;
			}
		}
		return false;
	}
	public boolean putMarkForAtt(Student st, Course cs, int m1, int m2) {
		for(Student st2 : cs.students) {
			if (st2.equals(st)) {
				for(StudentCourse stc : st2.viewActiveCourses()) {
					if (stc.course.equals(cs)) {
						stc.mark.setAttestation(m1, m2);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean putMarkForAtt(Student st, Course cs, int m1) {
		for(Student st2 : cs.students) {
			if (st2.equals(st)) {
				for(StudentCourse stc : st2.viewActiveCourses()) {
					if (stc.course.equals(cs)) {
						stc.mark.setAttestation(m1);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean putMarkForFinal(Student st, Course cs, int f1) {
		for(Student st2 : cs.students) {
			if (st2.equals(st)) {
				for(StudentCourse stc : st2.viewActiveCourses()) {
					if (stc.course.equals(cs)) {
						stc.mark.setFinal(f1);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean addCourseFile(int cid, String title , String body) {
		for(Course cs : courses) {
			if (cs.courseId == cid) {
				cs.addCourseFile(new CourseFile(title,body));
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o==null || o.getClass()!=this.getClass())
			return false;
		Teacher t = (Teacher)o;
		return this.teacherRole==t.teacherRole && this.courses==t.courses;
	}
	
	public String toString() {
		return super.toString() + " " + teacherRole;
	}
	
	public int compareTo(Object o) {
		Teacher ch = (Teacher) o;
		if (ch.getId() < this.getId()) {
			return 1;
		}else if (ch.getId() > this.getId()){
			return -1;
		}
		return 0;
	}
}

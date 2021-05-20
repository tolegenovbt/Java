package package1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentCourse implements Serializable {
	Course course;
	Mark mark;
	
	StudentCourse(){}
	
	StudentCourse(Course course, Mark mark){
		this.course = course;
		this.mark = mark;
	}
	
	public String getCourseName() {
		return course.courseName;
	}
	
	public void setPoints(int point1, int point2 , int point3) {
		mark.setAttestation(point1, point2 , point3);
	}
	public void setPoints(int point1, int point2) {
		mark.setAttestation(point1, point2);
	}
	public void setPoints(int point1) {
		mark.setAttestation(point1);
	}
	
	public void setFirstAtt(int point) {
		mark.setAttestation1(point);
	}
	
	public void setSecondAtt(int point) {
		mark.setAttestation2(point);
	}
	
	public void setFinalAtt(int point) {
		mark.setFinal(point);
	}
	
	public Mark getMark() {
		return mark;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public String toString() {
		return course + " " + mark;
	}
	
	public void setMark(int a, int b, int f) {
		mark.setAttestation(a, b, f);
	}
	
	public int compareTo(Object o) {
		StudentCourse ch = (StudentCourse) o;
		if (ch.course.courseId < this.course.courseId) {
			return 1;
		}else if (ch.course.courseId > this.course.courseId){
			return -1;
		}
		return 0;
	}
}

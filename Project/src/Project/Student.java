package Project;
import java.util.*;

public class Student extends User {

    private Degree degree;
    private int yearOfStudy;
    private Speciality speciality;
    private int gpa;
    public HashMap<Integer, Course> courses;
    private HashMap<Course, Mark> transcript;
    public HashMap<Course, Integer> courseMarks;
    private int cnt = 0;
    
    public Student() {
        super();
    }

    public Student(String name, String surname,int age, String id, String password) {
        super(name, surname, age,  id, password);
    }

    public Student(String name, String surname,int age, String id, String password, Degree degree, int yearOfStudy, Speciality speciality) {
        super(name, surname,age, id, password);
        this.degree = degree;
        this.yearOfStudy = yearOfStudy;
        this.speciality = speciality;
        this.transcript = new HashMap<Course, Mark>();
        this.courseMarks = new HashMap<Course, Integer>();
        this.courses = new HashMap<Integer, Course>();
        cnt = transcript.size();
    }


    public Degree getDegree() {
        return this.degree;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public Speciality getSpeciality() {
        return this.speciality;
    }

    public int compareTo(Object other) {
        Student a = (Student) other;
        if(super.compareTo(a) == 0){
            if(this.yearOfStudy > a.yearOfStudy) return 1;
            else if (this.yearOfStudy < a.yearOfStudy) return -1;
            else{
                if(this.gpa > a.gpa) return 1;
                else if(this.gpa < a.gpa) return -1;
                return 0;
            }
        }
        return super.compareTo(a);
    }

    public User clone() throws CloneNotSupportedException {
        Student a = (Student) super.clone();
        return a;
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    public boolean equals(Object a) {
        Student b = (Student) a;
        return Objects.equals(this, b);
    }

    public int getGpa() {
        return this.gpa;
    }

    public String getCourse() {
        return this.courses.toString();
    }

    public String getTranscript() {
        return this.transcript.toString();
    }

    public String viewInfoAboutTeacher(Teacher a) {
        return a.toString();
    }

    public void rateTeacher(Teacher a, int b) {
        a.setRating((a.getRating() + b)/(a.cnt + 1));
    }

    public String getAllMarks() {
        return this.courseMarks.toString();
    }

    public int getCourseMarks(Course course) {
        return this.courseMarks.get(course);
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent [degree=" + degree + ", yearOfStudy=" + yearOfStudy + ", speciality=" + speciality + ", gpa="
                + gpa + "]";
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public void setGpa(int gpa) {
        this.gpa = (this.gpa + gpa)/(cnt + 1);
    }

    public void setCourse(int id, Course course) {
        this.courses.put(id, course);
    }

    public void setCourseTranscript(Course course, Mark a) {
        this.transcript.put(course, a);
    }

    public void setCourseMarks(Course course, int value) {
        value = value + this.courseMarks.get(course);
        this.courseMarks.put(course, value);
    }

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
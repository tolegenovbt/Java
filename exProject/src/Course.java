
import java.util.*;
import java.io.*;

public class Course implements Serializable, Cloneable, Comparable {

    private String courseTitle;
    public Vector<Teacher> teachers;
    private Vector<File> files;

    public Course() {
        this.courseTitle = "unknown";
        this.teachers = null;
        this.files = null;
    }

    public Course(String courseTitle) {
        this.courseTitle = courseTitle;
        this.teachers = new Vector<Teacher>();
        this.files = new Vector<File>();
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Vector<Teacher> getTeachers() {
        return this.teachers;
    }

    public void setTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public int compareTo(Object other) {
        Course course = (Course)other;
        return this.courseTitle.compareTo(course.courseTitle);


    }
    public Object clone() throws CloneNotSupportedException {
        Course course = new Course();
        course.courseTitle = this.courseTitle;
        course.teachers = (Vector)this.teachers.clone();
        course.files = (Vector)this.files.clone();
        return course;
    }

    public int hashCode() {
        return Objects.hash(this.courseTitle);
    }

    public boolean equals(Object other) {
        if(other == null) return false;
        if(this == other) return true;
        if(!(other instanceof Course)) return false;
        Course course = (Course)other;
        return this.courseTitle.equals(course.courseTitle) && this.teachers.equals(course.teachers) &&
                this.files.equals(course.files);
    }

    public Vector<File> getFiles() {
        return this.files;
    }

    public void setFiles(File file) {
        this.files.add(file);
    }

    public File updateFile(int i) {
        return this.files.get(i);
    }

    public String toString() {
        return "\nCourse title: " + this.courseTitle + "\nTeachers: " + this.teachers.toString() + "\nFiles: " + this.files.toString();
    }

    public String toShow() {
        return "\nCourse title: " + this.courseTitle;
    }
}
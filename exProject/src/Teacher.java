import java.util.*;
import java.lang.*;

public class Teacher extends Employee {

    public HashMap<Integer, Course> courses;
    public HashMap<Course, Vector<Student> > students;

    private Position position;
    private Degree degree;
    private int rating = 0;
    public int cnt = 0;

    public Teacher() {
        super();
    }

    public Teacher(String name, String surname, String id, String password,Degree degree, Position position) {
        super(name, surname, id, password);
        this.position = position;
        this.degree = degree;
        this.courses = new HashMap<Integer, Course>();
        this.students = new HashMap<Course, Vector<Student>>();
    }

    public Teacher(Position position, Degree degree) {
        super();
        this.position = position;
        this.degree = degree;
    }
    public String getCourses() {
        return this.courses.toString();
    }

    public void manageCourseFiles() {
    }

    public Vector<Student> getStudentsCourse(Course course) {
        return this.students.get(course);
    }

    public int compareTo(Object other) {
        Object a = (Teacher) other;
        return super.compareTo(a);
    }

    public User clone() throws CloneNotSupportedException {
        Teacher cloned = (Teacher) super.clone();
        return cloned;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + cnt;
        //result = prime * result + ((courses == null) ? 0 : courses.hashCode());
        result = prime * result + ((degree == null) ? 0 : degree.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + rating;
        result = prime * result + ((students == null) ? 0 : students.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Teacher other = (Teacher) obj;
        if (cnt != other.cnt)
            return false;
        if (courses == null) {
            if (other.courses != null)
                return false;
        } else if (!courses.equals(other.courses))
            return false;
        if (degree != other.degree)
            return false;
        if (position != other.position)
            return false;
        if (rating != other.rating)
            return false;
        if (students == null) {
            if (other.students != null)
                return false;
        } else if (!students.equals(other.students))
            return false;
        return true;
    }



    public Position getPosition() {
        return this.position;
    }

    public Degree getDegree() {
        return this.degree;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTeacher [position=" + position + ", degree=" + degree + ", rating=" + rating + "]";
    }

    public void setCourse(int id, Course course) {
        if(Database.courses.contains(course)) {
            this.courses.put(id, course);
            course.teachers.add(this);
        }
    }

    public void setStudentToCourse(Course course, Student student) {
        this.students.get(course).add(student);
        int j = student.course.size() + 1;
        student.course.put(j, course);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        cnt = cnt + 1;
        this.rating = (this.rating + rating)/cnt;
    }

    
}
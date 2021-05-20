package Project;

import java.util.*;

public class Manager extends Employee {

    private ManagerType place;
    private Order order;
    private Report report;
    private News news;

    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Manager(String name, String surname,int age, String id, String password,  ManagerType place) {
        super(name, surname,age, id, password);
        this.place = place;
    }
    
    public ManagerType getPlace() {
        return this.place;
    }

    public void setPlace(ManagerType place) {
        this.place = place;
    }

    public Report getReport() {
        return this.report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public void setCourse(Course course) {
        Database.courses.add(course);
    }

    public News getNews() {
        return this.news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public int compareTo(Object other) {
        return super.compareTo(other);
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    @Override
    public String toString() {
        return super.toString() +"\nManager [place=" + place + "]";
    }

    public boolean equals(Object a) {
        Manager aa = (Manager) a;
        return Objects.equals(this, a);
    }

    public User clone() throws CloneNotSupportedException {
        Manager cloned = (Manager) super.clone();
        cloned.report = this.report;
        return cloned;
    }
}
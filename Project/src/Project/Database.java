package Project;
import java.util.*;
import java.io.*;
public class Database {
    static Vector<User> users  = new Vector<User>();
    static Vector<Admin> admins = new Vector<Admin>();
    static Vector<Student> students = new Vector<Student>();
    static Vector<Teacher> teachers = new Vector<Teacher>();
    static Vector<Manager> managers = new Vector<Manager>();
    static Vector<TechSupportGuy> techSupportGuys = new Vector<TechSupportGuy>();
    static Vector<Course> courses = new Vector<Course>();
    static Vector<Speciality> specialities = new Vector<Speciality>();
    static Vector<Order> orders = new Vector<Order>();
    
    static FileInputStream fis;
    static ObjectInputStream ois;
    static FileOutputStream fos;
    static ObjectOutputStream oos;
    

    public static void serUsers() throws IOException{
        fos = new FileOutputStream("users.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
    }
    public static void deserUsers() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("users.ser");
        ois = new ObjectInputStream(fis);
        users = (Vector<User>) ois.readObject();
    }

    public static void serAdmins() throws IOException{
        fos = new FileOutputStream("admins.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(admins);
        oos.close();

    }
    public static void deserAdmins() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("admins.ser");
        ois = new ObjectInputStream(fis);
        admins = (Vector<Admin>) ois.readObject();
    }
    public static void serStudents() throws IOException{
        fos = new FileOutputStream("students.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.close();

    }
    public static void deserStudents() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("students.ser");
        ois = new ObjectInputStream(fis);
        students = (Vector<Student>) ois.readObject();
    }
    

    public static void serTeachers() throws IOException{
        fos = new FileOutputStream("teachers.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(teachers);
        oos.close();

    }
    public static void deserTeachers() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("teachers.ser");
        ois = new ObjectInputStream(fis);
        teachers = (Vector<Teacher>) ois.readObject();
    }
    
    public static void serManagers() throws IOException{
        fos = new FileOutputStream("managers.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(managers);
        oos.close();

    }
    public static void deserManagers() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("managers.ser");
        ois = new ObjectInputStream(fis);
        managers = (Vector<Manager>) ois.readObject();
    }
    
    public static void serTechSupportGuys() throws IOException{
        fos = new FileOutputStream("techSupportGuys.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(techSupportGuys);
        oos.close();

    }
    public static void deserTechSupportGuys() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("techSupportGuys.ser");
        ois = new ObjectInputStream(fis);
        techSupportGuys = (Vector<TechSupportGuy>) ois.readObject();
    }
    

    public static void serCourses() throws IOException{
        fos = new FileOutputStream("courses.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
    }
    public static void deserCourses() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("courses.ser");
        ois = new ObjectInputStream(fis);
        courses = (Vector<Course>) ois.readObject();
    }

    public static void serSpecialities() throws IOException{
        fos = new FileOutputStream("specialities.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(specialities);
        oos.close();

    }
    public static void deserSpecialities() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("specialities.ser");
        ois = new ObjectInputStream(fis);
        specialities = (Vector<Speciality>) ois.readObject();
    }

    public static void serOrders() throws IOException{
        fos = new FileOutputStream("orders.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(orders);
        oos.close();

    }
    public static void deserOrders() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("orders.ser");
        ois = new ObjectInputStream(fis);
        orders = (Vector<Order>) ois.readObject();
    }


}
import java.util.*;
import java.io.*;
public class Database {
    static Vector<User> users  = new Vector<User>();
    static Vector<Student> students = new Vector<Student>();
    static Vector<Teacher> teachers = new Vector<Teacher>();
    static Vector<Manager> managers = new Vector<Manager>();
    static Vector<Executor> executors = new Vector<Executor>();
    static Vector<Admin> admins = new Vector<Admin>();
    static Vector<Speciality> specialities = new Vector<Speciality>();
    static Vector<Order> orders = new Vector<Order>();
    static Vector<Course> courses = new Vector<Course>();

    static FileInputStream fis;
    static FileOutputStream fos;
    static ObjectOutputStream oos;
    static ObjectInputStream ois;

    public static void desUsers() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("users.ser");
        ois = new ObjectInputStream(fis);
        users = (Vector<User>) ois.readObject();
    }

    public static void serUsers() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("users.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();
    }

    public static void desCourses() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("courses.ser");
        ois = new ObjectInputStream(fis);
        courses = (Vector<Course>) ois.readObject();
    }

    public static void serCourses() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("courses.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.close();
    }

    public static void serSpecialities() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("specialities.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(specialities);
        oos.close();

    }
    public static void desSpecialities() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("specialities.ser");
        ois = new ObjectInputStream(fis);
        specialities = (Vector<Speciality>) ois.readObject();
    }

    public static void serStudents() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("students.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.close();

    }
    public static void desStudents() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("students.ser");
        ois = new ObjectInputStream(fis);
        students = (Vector<Student>) ois.readObject();
    }

    public static void serManagers() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("managers.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(managers);
        oos.close();

    }
    public static void desManagers() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("managers.ser");
        ois = new ObjectInputStream(fis);
        managers = (Vector<Manager>) ois.readObject();
    }

    public static void serTeachers() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("teachers.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(teachers);
        oos.close();

    }
    public static void desTeachers() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("teachers.ser");
        ois = new ObjectInputStream(fis);
        teachers = (Vector<Teacher>) ois.readObject();
    }

    public static void serExecutors() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("executors.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(executors);
        oos.close();

    }
    public static void desExecutors() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("executors.ser");
        ois = new ObjectInputStream(fis);
        executors = (Vector<Executor>) ois.readObject();
    }

    public static void serAdmins() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("admins.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(admins);
        oos.close();

    }
    public static void desAdmins() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("admins.ser");
        ois = new ObjectInputStream(fis);
        admins = (Vector<Admin>) ois.readObject();
    }

    public static void serOrders() throws IOException, ClassNotFoundException{
        fos = new FileOutputStream("orders.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(orders);
        oos.close();

    }
    public static void desOrders() throws IOException, ClassNotFoundException{
        fis = new FileInputStream("orders.ser");
        ois = new ObjectInputStream(fis);
        orders = (Vector<Order>) ois.readObject();
    }


}


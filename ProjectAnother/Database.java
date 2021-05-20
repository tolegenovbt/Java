package package1;
import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Database implements Serializable {
	
	static ArrayList<User> users = new ArrayList<User>();

	static ArrayList<Order> orders = new ArrayList<Order>();
	static ArrayList<String> messages = new ArrayList<String>();
	
	static ArrayList<Manager> managers= new ArrayList<Manager>();
	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	static ArrayList<TechSupport> techSupports = new ArrayList<TechSupport>();
	static ArrayList<Course> courses= new ArrayList<Course>();
	
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	private static ObjectInputStream oin;
	
	public static boolean addUser(User user) {
		users.add(user);
		if (user instanceof Manager) {
			managers.add((Manager)user);
		}else if (user instanceof Student) {
			students.add((Student)user);
		}else if (user instanceof Teacher) {
			teachers.add((Teacher)user);
		}else if (user instanceof TechSupport) {
			techSupports.add((TechSupport)user);
		}else {
			return false;
		}
		return true;
	}
	
	public static void serUsers()throws IOException{
		fos = new FileOutputStream("users.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void desUsers() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("users.txt");
		oin = new ObjectInputStream(fis);
		users = (ArrayList<User>) oin.readObject();
	}
	
	public static void serManagers()throws IOException{
		fos = new FileOutputStream("manager.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(managers);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void desManagers() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("manager.txt");
		oin = new ObjectInputStream(fis);
		managers = (ArrayList<Manager>) oin.readObject();
	}
	
	public static void serTeachers()throws IOException{
		fos = new FileOutputStream("teacher.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(teachers);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void desTeachers() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("teacher.txt");
		oin = new ObjectInputStream(fis);
		teachers = (ArrayList<Teacher>) oin.readObject();
	}
	
	public static void serTechSupports()throws IOException{
		fos = new FileOutputStream("techSupports.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(techSupports);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void desTechSupports() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("techSupports.txt");
		oin = new ObjectInputStream(fis);
		techSupports = (ArrayList<TechSupport>) oin.readObject();
	}
	
	@SuppressWarnings("unchecked")
	public  static void desStudents() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("students.txt");
		oin = new ObjectInputStream(fis);
		students = (ArrayList<Student>) oin.readObject();
	}
		
	public static void serStudents()throws IOException{
		fos = new FileOutputStream("students.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(students);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public  static void desCourses() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("courses.txt");
		oin = new ObjectInputStream(fis);
		courses = (ArrayList<Course>) oin.readObject();
	}
		
	public static void serCourses()throws IOException{
		fos = new FileOutputStream("courses.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
	}
	
	public static boolean addCourse(Course course) {
		courses.add(course);
		return true;
	}
	
}

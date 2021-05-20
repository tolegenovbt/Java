package package1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	static User curUser;
	@SuppressWarnings("resource")
	static	boolean checkAdmin(String login, String password) throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("admin.txt");
		ObjectInputStream oin = new ObjectInputStream(fis);
		Admin admin = (Admin) oin.readObject();
		if (admin.getLogin().equals(login) && admin.getPass().equals(password)) {
			curUser = admin;
			return true;
		}
		return false;		
	}
	static int checkUser(String login, String password) throws ClassNotFoundException, IOException {
		if (checkAdmin(login,password)== false) {
			for(User user : Database.users) {
				if (user.getLogin().equals(login) && user.getPass().equals(password)) {
					curUser = user;
					return 1;
				}
			}
		}else {
			return 2;
		}
		return 0;
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		Admin us = new Admin("wspadm","wsppass", "admin" ,"admin" ,"admin" ,250000);
//		
//		FileOutputStream fos = new FileOutputStream("admin.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(us);
//		oos.close();
		
		
//		Teacher t1 = new Teacher("t_teacher","pass","T_Sur","T_Name","T_FName",TeacherRole.SeniorLector, 150000);
//		Course course1 = new Course(t1,"OOP", 3, 2, true);
//		Student student = new Student("b_ospan", "pass" , "Ospan" , "Bekbolatabyaly", "Bisembiuly", 2 , Faculty.FIT);
//		course1.addStudent(student);
//		t1.addCourse(course1);
//		User u1 = new Student("b_ospan", "pass" , "Ospan" , "Bekbolatabyaly", "Bisembiuly", 2 , Faculty.FIT);
//		Database.addUser(u1);
//		User u2 = (User)t1;
//		Database.addUser(u2);
//		User u3 = new Manager("m_man", "pass", "ManS", "ManN", "ManF", 150000);
//		Database.addUser(u3);
//		User u4 = new TechSupport("t_tech", "pass", "TechS", "TechN", "TechF", 250000);
//		Database.addUser(u4);
//		
//		Database.serCourses(); 
//		Database.serStudents();
//		Database.serTeachers();
//		Database.serTechSupports();
//		Database.serManagers();
//		Database.serUsers();
		
		Database.desCourses();
		Database.desManagers();
		Database.desStudents();
		Database.desTeachers();
		Database.desTechSupports();
		Database.desUsers();
//
//		for(User u : Database.users) {
//			System.out.println(u);
//		}
//		for(Course c : Database.courses) {
//			System.out.println(c);
//		}
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Login : ");
		String login = scan.next();
		System.out.println("Password : ");
		String password = scan.next();
		
		int cmd = checkUser(login, password);
		int command = -1;
		if (cmd == 1) {
			System.out.println("Welcome, " + curUser.getLogin());
			if (curUser instanceof Student) {
				Student s = (Student)curUser;
				while(!(command ==0)) {
					System.out.println("[1] Show Active courses");
					System.out.println("[2] Show Retake courses");
					System.out.println("[3] Show Available courses");
					System.out.println("[4] Register For Course");
					System.out.println("[5] Change Password");
					System.out.println("[0] Exit");
					command = scan.nextInt();
					if (command == 1) {
						System.out.println(s.viewActiveCourses());
					}else if (command == 2) {
						System.out.println(s.viewRetakeCourses());
					}else if (command == 3) {
						System.out.println(s.viewAvailableCourses());
					}else if (command == 4) {
						int courseId = scan.nextInt();
						System.out.println(s.registerForCourse(courseId));
					}else if (command == 5) {
						String pass = scan.next(), newPass = scan.next();
						System.out.println(s.changePassword(pass, newPass));
					}else if (command == 0) {
						System.out.println("Bye");
						
						Database.serCourses(); 
						Database.serStudents();
						Database.serTeachers();
						Database.serTechSupports();
						Database.serManagers();
						Database.serUsers();
						break;
					}
					// Student works;
				}
			}else if (curUser instanceof Manager) {
				Manager m = (Manager)curUser;
				while(!(command ==0)) {
					System.out.println("[1] Show courses");
					System.out.println("[2] Show teachers");
					System.out.println("[3] Show students");
					System.out.println("[4] Open Registration");
					System.out.println("[5] Close Registration");
					System.out.println("[6] Add Course");
					System.out.println("[7] Set Course teacher");
					System.out.println("[8] Register Students for Course");
					System.out.println("[9] Send message to Teacher");
					System.out.println("[10] Change Password");
					System.out.println("[0] Exit");
					command = scan.nextInt();
					if (command == 1) {
						System.out.println(m.getCourses());
					}else if (command == 2) {
						System.out.println(m.getTeachers());
					}else if (command == 3) {
						System.out.println(m.getStudents());
					}else if (command == 4) {
						m.openCourseRegistration();
					}else if (command == 5) {
						m.closeCourseRegistration();
					}else if (command == 6) {
						int teachId = scan.nextInt();
						String courseName = scan.next();
						int credits = scan.nextInt(), forYearOfStudy = scan.nextInt();
						System.out.println(m.createCourse(teachId, courseName, credits, forYearOfStudy));
					}else if (command == 7) {
						int courseId = scan.nextInt(),teachId = scan.nextInt();
						System.out.println(m.setCourseTeacher(courseId,teachId));
					}else if (command == 8) {
						int courseId = scan.nextInt();
						System.out.println(m.registerStudentsTo(courseId));
					}else if (command == 9) {
						int teacherId = scan.nextInt();
						String body = scan.nextLine();
						System.out.println(m.sendMessageTo(teacherId, body));
					}else if (command == 10) {
						String old = scan.next(), newPass = scan.next();
						System.out.println(m.changePassword(old, newPass));
					}else if (command == 0) {
						System.out.println("Bye");
						
						Database.serCourses(); 
						Database.serStudents();
						Database.serTeachers();
						Database.serTechSupports();
						Database.serManagers();
						Database.serUsers();
						break;
					}
					// Manager works;
				}
			}else if (curUser instanceof Teacher) {
				while(!(command ==0)) {
					Teacher teach = (Teacher)curUser;
					System.out.println("[1] Show courses");
					System.out.println("[2] Show Course Students");
					System.out.println("[3] Put Marks");
					System.out.println("[4] Put Marks For Final");
					System.out.println("[5] Add Course File");
					System.out.println("[6] Send Report");
					System.out.println("[7] View Messages");
					System.out.println("[0] Exit");
					command = scan.nextInt();
					if (command == 1) {
						System.out.println(teach.getCourses());
					}else if (command == 2) {
						int courseId = scan.nextInt();
						System.out.println(teach.getListOfStudentOf(courseId));
					}else if (command == 3) {
						int courseId = scan.nextInt();
						if (teach.getCourse(courseId)!=null) {
							Course course = teach.getCourse(courseId);
							for(Student s : course.students) {
								System.out.println(s);
								System.out.println("Mark");
								int m1 = scan.nextInt(), m2 = scan.nextInt(), f1 = scan.nextInt();
//								System.out.println(teach.putMarkForAtt(s, course, m1, m2, f1));
								System.out.println(s.putMarkForCourse(course, m1 ,m2,f1));
							}
						}
					}else if (command == 4) {
						int courseId = scan.nextInt();
						if (teach.getCourse(courseId)!=null) {
							Course course = teach.getCourse(courseId);
							for(Student s : course.students) {
								System.out.println(s);
								System.out.println("Final");
								int f1 = scan.nextInt();
								System.out.println(teach.putMarkForFinal(s , course ,f1));
							}
						}
					}else if (command == 5) {
						System.out.println("Course id");
						int courseId = scan.nextInt();
						System.out.println("Title");
						String title = scan.nextLine();
						System.out.println("Body");
						String body = scan.nextLine();
						System.out.println(teach.addCourseFile(courseId, title, body));
					}else if (command == 6) {
						int techSupportId = scan.nextInt();
						String title = scan.next(), report = scan.nextLine();
						System.out.println(teach.sendReport(techSupportId, title, report));
					}else if (command == 7) {
						System.out.println(teach.viewMessages());
					}else if (command == 0) {
						System.out.println("Bye");
						
						Database.serCourses(); 
						Database.serStudents();
						Database.serTeachers();
						Database.serTechSupports();
						Database.serManagers();
						Database.serUsers();
						break;
					}
					//Teacher works
				}
			}else if (curUser instanceof TechSupport) {
				TechSupport tech = (TechSupport) curUser;
				while(!(command ==0)) {
					System.out.println("[1] Show orders");
					System.out.println("[2] Show Done orders");
					System.out.println("[3] Show Not Done orders");
					System.out.println("[4] Set done Order");
					System.out.println("[5] Change Password");
					System.out.println("[0] Exit");
					command = scan.nextInt();
					if (command == 1) {
						System.out.println(tech.getOrders());
					}else if (command == 2) {
						System.out.println(tech.getDoneOrders());
					}else if (command == 3) {
						System.out.println(tech.getNotDoneOrders());
					}else if (command == 4) {
						int orderId = scan.nextInt();
						System.out.println(tech.setDoneOrder(orderId));
					}else if (command == 5) {
						String old = scan.next(), newPass = scan.next();
						System.out.println(tech.changePassword(old, newPass));
					}else if (command == 0) {
						System.out.println("Bye");
						
						Database.serCourses(); 
						Database.serStudents();
						Database.serTeachers();
						Database.serTechSupports();
						Database.serManagers();
						Database.serUsers();
						break;
					}
				}
			}
		}else if (cmd == 2) {
			System.out.println(curUser.getLogin());
			while(!(command ==0)) {
				System.out.println("[1] Create User");
				System.out.println("[2] Delete User");
				System.out.println("[3] Change Password for users");
				System.out.println("[4] View Users");
				System.out.println("[0] Exit");
				command = scan.nextInt();
				if (command == 1) {
					User user;
					System.out.println("Login :");
					String loginn = scan.next();
					System.out.println("Password :");
					String passwordd = scan.next();
					System.out.println("surName :");
					String userSurName = scan.next();
					System.out.println("Name :");
					String userName = scan.next();
					System.out.println("FatherName :");
					String userFatherName = scan.next();
					System.out.println("Role :");
					String role = scan.next();
					if (role.equals("Student")) {
						System.out.println("Year of Study : ");
						int yearOfStudy = scan.nextInt();
						Faculty faculty;
						System.out.println("Faculty : ");
						String facult = scan.next();
						if (facult.equals("FIT")) {
							faculty = Faculty.FIT;
						}else if (facult.equals("MCM")) {
							faculty = Faculty.MCM;
						}else{
							faculty = Faculty.IBS;
						}
						user = new Student(loginn,passwordd,userSurName,userName,userFatherName,yearOfStudy,faculty);
					}else if (role == "Manager") {
						System.out.println("Salary : ");
						int salary = scan.nextInt();
						user = new Manager(loginn,passwordd, userSurName, userName, userFatherName, salary);
					}else if (role == "Teacher") {
						System.out.println("Salary : ");
						int salary = scan.nextInt();
						TeacherRole post = null;
						System.out.println("Role : ");
						String teacherRole = scan.next();
						if (teacherRole.equals("Lector")) {
							post = TeacherRole.Lector;
						}else if (teacherRole.equals("SeniorLector")) {
							post = TeacherRole.SeniorLector;
						}else if (teacherRole.equals("Doctor")){
							post = TeacherRole.Doctor;
						}else if (teacherRole.equals("Professor")){
							post = TeacherRole.Professor;
						}
						user = new Teacher(loginn,passwordd, userSurName, userName, userFatherName,post, salary);
					}else {
						System.out.println("Salary : ");
						int salary = scan.nextInt();
						user = new TechSupport(loginn,passwordd, userSurName, userName, userFatherName, salary );
					}
					System.out.println(Database.addUser(user));
				}else if (command == 2) {
					int id = scan.nextInt();
					System.out.println(Admin.deleteUser(id));
				}else if (command == 3) {
					int id = scan.nextInt();
					String pass = scan.next();
					Admin.setPassword(id, pass);
				}else if (command == 4) {
					for(User u : Database.users) {
						System.out.println(u);
					}
				}else if (command == 0) {
					System.out.println("Bye");
					Database.serCourses(); 
					Database.serStudents();
					Database.serTeachers();
					Database.serTechSupports();
					Database.serManagers();
					Database.serUsers();
					break;
				}
			}
			
		}else if (cmd == 0) {
			System.out.println("Wrong login / password");
		}
		
		Database.serCourses(); 
		Database.serStudents();
		Database.serTeachers();
		Database.serTechSupports();
		Database.serManagers();
		Database.serUsers();
	}

}

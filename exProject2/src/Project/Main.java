package Project;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void deserializeObjects() throws IOException, ClassNotFoundException{
        if(new File("users.ser").exists()) Database.desUsers();
        if(new File("specialities.ser").exists()) Database.desSpecialities();
        if(new File("students.ser").exists()) Database.desStudents();
        if(new File("teachers.ser").exists()) Database.desTeachers();
        if(new File("managers.ser").exists()) Database.desManagers();
        if(new File("techSupportGuys.ser").exists()) Database.desTechSupportGuys();
        if(new File("admins.ser").exists()) Database.desAdmins();
        if(new File("orders.ser").exists()) Database.desOrders();
        if(new File("courses.ser").exists()) Database.desCourses();
    }
	public static void save() throws IOException, ClassNotFoundException{
        Database.serUsers();
        Database.serSpecialities();
        Database.serStudents();
        Database.serTeachers();
        Database.serManagers();
        Database.serTechSupportGuys();
        Database.serAdmins();
        Database.serOrders();
        Database.serCourses();
    }
	public static void clear() {
        Database.users.clear();
        Database.admins.clear();
        Database.techSupportGuys.clear();
        Database.managers.clear();
        Database.students.clear();
    }
	public static void main(String args[])
	{
		try{
			String inputName,inputSurname, inputID,inputPassword,inputSpeciality,inputPosition,choice;
			int inputAge,inputYearOfStudy, index = 1;;
			Boolean idCheck = false, passwordCheck = false;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer token;
	        User user = null;
	        Degree degree;
	        Order order;
	        Position position;
	        ManagerPlace place;
	        Speciality speciality = new Speciality("IS", "5B070300");
	        Database.specialities.add(speciality);
	        Admin admin = new Admin("Bekzat", "Tolegenov", 19,"18BD111653", "12345");
	        Student student = new Student("Aiymzhan","Syzdykbek",  19, "18BD100200", "12345", Degree.BACHELOR,2,speciality);
	        Teacher teacher = new Teacher("Pakita","Shamoi", 30, "12TD000001", "shamoi", Degree.PHD, Position.PROFESSOR);
	        Database.students.add(student);
	        Database.users.add(student);
	        Database.teachers.add(teacher);
	        Database.users.add(teacher);
	        Database.users.add(admin);
	        Database.admins.add(admin);
	        System.out.println("Welcome!");
	        mainPage: while(true)
	        {
	        	System.out.println("Select action: ");
	        	System.out.println("1) Login");
	        	System.out.println("2) Exit");
	        	choice = in.readLine();
	        	if(choice.equals("2"))
	        	{
	        		System.out.println("Bye!");
	        	}
	        	else if(choice.equals("1"))
	        	{
	        		System.out.println("Please ENTER your ID: ");
	        		inputID = in.readLine();
		        	System.out.println("Please ENTER your PASSWORD: ");
		        	inputPassword = in.readLine();
		        	for(User usr:Database.users)
		        	{
		        		if(inputID.equals(usr.getId()))
		        		{
		        			idCheck = true;
		        			if(inputPassword.equals(usr.getPassword()))
		        			{
		        				passwordCheck = true;
		        				user=usr;
		        			}
		        		}
		        	}
		        	if(idCheck && passwordCheck)
		        	{
		        		System.out.println("\nHello, "+user.getName()+"\n");
		        		if(user instanceof Admin)
		        		{
		        			adminsPage : while(true)
		        			{
		        				System.out.println("Select action: ");
		        				System.out.println("1) Add user");
		        				System.out.println("2) Remove user");
		        				System.out.println("3) Update user");
		        				System.out.println("4) Logout");
		        				choice = in.readLine();
		        				if(choice.equals("1"))
		        				{
		        					System.out.println("SELECT type of the new user");
		        					System.out.println("1) Student");
		        					System.out.println("2) Teacher");
		        					System.out.println("3) Manager");
		        					System.out.println("4) TechSupportGuy");
		        					System.out.println("5) Admin");
		        					System.out.println("\n6) BACK");
		        					choice = in.readLine();
		        					if(choice.equals("1"))
		        					{
		        						System.out.println("New Student: ");
		        						System.out.println("ID: ");
			        					inputID = in.readLine(); 
			        					System.out.println("PASSWORD: ");
			        					inputPassword = in.readLine();
			        					System.out.println("NAME: ");
			        					inputName = in.readLine();
			        					System.out.println("SURNAME: ");
			        					inputSurname = in.readLine();
			        					System.out.println("AGE:");
			        					inputAge = Integer.parseInt(in.readLine());
			        					System.out.println("Choose degree: ");
			        					for(Degree value: Degree.values()){
                                            System.out.println(index+ ") " + value.name());
                                            index++;
                                        }
                                        index = 1;
                                        choice = in.readLine();
                                        degree  = Degree.values()[Integer.parseInt(choice)-1];
                                        System.out.println("Year of Study:");
                                        inputYearOfStudy = Integer.parseInt(in.readLine());
                                        System.out.println("Choose Speciality");
                                        for(int i = 0; i < Database.specialities.size(); i++) {
                                            System.out.println(i + 1+")"+ Database.specialities.get(i).toString());
                                        }
                                        choice = in.readLine();
                                        speciality = (Speciality)Database.specialities.get(Integer.parseInt(choice)-1);
                                        Student newStudent = new Student(inputName,inputSurname, inputAge,inputID,inputPassword, degree, inputYearOfStudy, speciality);
                                        Database.students.add(newStudent);
                                        Database.users.add(newStudent);
                                        System.out.println("\nNew Student added successfully!\n");
                                        
		        					}
		        					else if(choice.equals("2"))
		        					{
		        						System.out.println("New Teacher: ");
		        						System.out.println("ID: ");
			        					inputID = in.readLine(); 
			        					System.out.println("PASSWORD: ");
			        					inputPassword = in.readLine();
			        					System.out.println("NAME: ");
			        					inputName = in.readLine();
			        					System.out.println("SURNAME: ");
			        					inputSurname = in.readLine();
			        					System.out.println("AGE:");
			        					inputAge=Integer.parseInt(in.readLine());
			        					System.out.println("Choose degree: ");
			        					for(Degree value: Degree.values()){
                                            System.out.println(index+ ") " + value.name());
                                            index++;
                                        }
                                        index = 1;
                                        choice = in.readLine();
                                        degree  = Degree.values()[Integer.parseInt(choice)-1];
			        					System.out.println("Choose position: ");
			        					for(Position value: Position.values()){
                                            System.out.println(index+ ") " + value.name());
                                            index++;
                                        }
                                        index = 1;
                                        choice = in.readLine();
                                        position  = Position.values()[Integer.parseInt(choice)-1];
                                        Teacher newTeacher = new Teacher(inputName,inputSurname,inputAge,inputID,inputPassword,degree,position);
                                        Database.teachers.add(newTeacher);
                                        Database.users.add(newTeacher);
                                        System.out.println("\nNew Teacher added successfully!\n");
		        					}
		        					else if(choice.equals("3"))
		        					{
		        						System.out.println("New Manager: ");
		        						System.out.println("ID: ");
			        					inputID = in.readLine(); 
			        					System.out.println("PASSWORD: ");
			        					inputPassword = in.readLine();
			        					System.out.println("NAME: ");
			        					inputName = in.readLine();
			        					System.out.println("SURNAME: ");
			        					inputSurname = in.readLine();
			        					System.out.println("AGE:");
			        					inputAge=Integer.parseInt(in.readLine());
			        					System.out.println("Choose place of management: ");
			        					for(ManagerPlace value: ManagerPlace.values()){
                                            System.out.println(index+ ") " + value.name());
                                            index++;
                                        }
                                        index = 1;
                                        choice = in.readLine();
                                        place = ManagerPlace.values()[Integer.parseInt(choice)-1];
                                        Manager newManager = new Manager(inputName, inputSurname, inputAge,inputID,inputPassword,place);
			        					Database.managers.add(newManager);
			        					Database.users.add(newManager);
			        					System.out.println("\nNew Manager added successfully!\n");
		        					}
		        					else if(choice.equals("4"))
		        					{
		        						System.out.println("New TechSupportGuy: ");
		        						System.out.println("ID: ");
			        					inputID = in.readLine(); 
			        					System.out.println("PASSWORD: ");
			        					inputPassword = in.readLine();
			        					System.out.println("NAME: ");
			        					inputName = in.readLine();
			        					System.out.println("SURNAME: ");
			        					inputSurname = in.readLine();
			        					System.out.println("AGE:");
			        					inputAge=Integer.parseInt(in.readLine());
			        					TechSupportGuy newTechSupportGuy = new TechSupportGuy(inputName, inputSurname, inputAge,inputID,inputPassword);
			        					Database.techSupportGuys.add(newTechSupportGuy);
			        					Database.users.add(newTechSupportGuy);
			        					System.out.println("\nNew TechSupportGuy added successfully!\n");
		        					}
		        					else if(choice.equals("5"))
		        					{
		        						System.out.println("New Admin: ");
		        						System.out.println("ID: ");
			        					inputID = in.readLine(); 
			        					System.out.println("PASSWORD: ");
			        					inputPassword = in.readLine();
			        					System.out.println("NAME: ");
			        					inputName = in.readLine();
			        					System.out.println("SURNAME: ");
			        					inputSurname = in.readLine();
			        					System.out.println("AGE:");
			        					inputAge=Integer.parseInt(in.readLine());
			        					Admin newAdmin= new Admin(inputName, inputSurname, inputAge,inputID,inputPassword);
			        					Database.admins.add(newAdmin);
			        					Database.users.add(newAdmin);
			        					System.out.println("\nNew Admin added successfully!\n");
		        					}
		        					else {
		        						continue mainPage;
		        					}
		        					continue adminsPage;
		        				}
		        				else if(choice.equals("2"))
		        				{
		        					//Remove user
		        				}
		        				else if(choice.equals("3"))
		        				{
		        					//Update user
		        				}
		        				else if(choice.equals("4"))
		        				{
		        					continue mainPage;
		        				}
		        			}
		        		}
		        		else if(user instanceof Student)
		        		{
		        			while(true) {
                                System.out.println("1) View GPA");
                                System.out.println("2) View transcript");
                                System.out.println("3) View courses");
                                System.out.println("4) View course marks");
                                System.out.println("5) View all marks");
                                System.out.println("6) Logout");
                                choice = in.readLine();
                                if(choice.equals("1")){
                                    System.out.println(((Student) user).getGpa());
                                }

                                else if(choice.equals("2")){
                                    System.out.println(((Student) user).getTranscript());
                                }

                                else if(choice.equals("3")){
                                    System.out.println(((Student) user).getCourse());
                                }

                                else if(choice.equals("4")){
                                    System.out.println(((Student) user).getCourse());
                                    System.out.println("Enter course id");
                                    choice = in.readLine();
                                    Course current = ((Student) user).course.get(Integer.parseInt(choice));
                                    System.out.println(((Student) user).getCourseMarks(current));
                                }

                                else if(choice.equals("5")){
                                    System.out.println(((Student) user).getAllMarks());
                                }

                                else {
                                    break;
                                }
		        			}
		        		}
		        		else if(user instanceof Teacher)
		        		{
		        			teachersPage: while(true) {
                                System.out.println("1) Send order");
                                System.out.println("2) View courses");
                                System.out.println("3) View students of specified course");
                                System.out.println("4) Put mark to student");
                                System.out.println("5) Put final grade to student's transcript");
                                System.out.println("6) Logout");

                                choice = in.readLine();
                                if(choice.equals("1")){
                                    System.out.println();
                                }

                                else if(choice.equals("2")){
                                    System.out.println(((Teacher) user).getCourses());
                                }

                                else if(choice.equals("3")){
                                    System.out.println(((Teacher) user).getCourses());
                                    System.out.println("Enter id of the course");
                                    choice = in.readLine();
                                    Course current = ((Teacher) user).courses.get(Integer.parseInt(choice));
                                    System.out.println(current.toString());
                                }

                                else if(choice.equals("4")){
                                    System.out.println(((Teacher) user).getCourses());
                                    System.out.println("Enter id of the course");
                                    choice = in.readLine();
                                    Course current = ((Teacher) user).courses.get(Integer.parseInt(choice));
                                    Vector<Student> stud = ((Teacher) user).students.get(current);
                                    for(int i = 0; i < stud.size(); i++){
                                        System.out.println(i+1 + " " + stud.get(i));
                                    }
                                    System.out.println("Enter id of the student");
                                    choice = in.readLine();
                                    Student curStudent = stud.get(Integer.parseInt(choice));
                                    System.out.println("Enter Mark of the student");
                                    choice = in.readLine();
                                    curStudent.setCourseMarks(current, Integer.parseInt(choice));
                                }

                                else if(choice.equals("5")){
                                    System.out.println(((Teacher) user).getCourses());
                                    System.out.println("Enter id of the course");
                                    choice = in.readLine();
                                    Course current = ((Teacher) user).courses.get(Integer.parseInt(choice));
                                    Vector<Student> stud = ((Teacher) user).students.get(current);
                                    for(int i = 0; i < stud.size(); i++){
                                        System.out.println(i+1 + " " + stud.get(i));
                                    }
                                    System.out.println("Enter id of the student");
                                    choice = in.readLine();
                                    Student curStudent = stud.get(Integer.parseInt(choice));
                                    System.out.println("Enter final score of the student");
                                    choice = in.readLine();
                                    Mark curMark = new Mark(Integer.parseInt(choice));
                                    curStudent.setCourseTranscript(current, curMark);
                                }

                                else {
                                    break;
                                }
                            }
		        		}
		        		else if(user instanceof Manager)
		        		{
		        			managersPage: while(true) {
                                System.out.println("1) Create course");
                                System.out.println("2) Add course to techer");
                                System.out.println("3) Add student to specified course");
                                System.out.println("4) Logout");

                                choice = in.readLine();
                                if(choice.equals("1")){
                                    System.out.println("Enter course title");
                                    String _title = in.readLine();
                                    Course current = new Course(_title);
                                    Database.courses.add(current);
                                }

                                else if(choice.equals("2")){

                                    Course current;
                                    for(int i = 0; i < Database.courses.size(); i++) {
                                        System.out.println(i+1 + " " + Database.courses.get(i).toShow());
                                    }

                                    System.out.println("Enter course number");
                                    choice = in.readLine();
                                    current = Database.courses.get(Integer.parseInt(choice)-1);

                                    for(int i = 0; i < Database.teachers.size(); i++) {
                                        System.out.println(i+1 + " " + Database.teachers.get(i));
                                    }

                                    System.out.println("Enter teacher's number");
                                    choice = in.readLine();

                                    Teacher CurTeacher =  Database.teachers.get(Integer.parseInt(choice)-1);

                                    int k = CurTeacher.courses.size();
                                    CurTeacher.setCourse(k, current);

                                }

                                else if(choice.equals("3")){

                                    for(int i = 0; i < Database.teachers.size(); i++) {
                                        System.out.println(i+1 + " " + Database.teachers.get(i));
                                    }

                                    System.out.println("Enter teacher's number");
                                    choice = in.readLine();

                                    Teacher CurrentTeacher =  Database.teachers.get(Integer.parseInt(choice)-1);

                                    for(int i = 0; i < CurrentTeacher.courses.size(); i++) {
                                        System.out.println(i+1 + " " + CurrentTeacher.courses.get(i));
                                    }

                                    System.out.println("Enter course number");
                                    choice = in.readLine();
                                    Course currentCourse = CurrentTeacher.courses.get(Integer.parseInt(choice)-1);

                                    for(int i = 0; i < Database.students.size(); i++) {
                                        System.out.println(i+1 + " " + Database.students.get(i));
                                    }

                                    System.out.println("Enter student's number");
                                    choice = in.readLine();
                                    Student currentStudent = Database.students.get(Integer.parseInt(choice)-1);

                                    CurrentTeacher.setStudenttoCourse(currentCourse, currentStudent);

                                }
                                else {
                                    break;
                                }
                            }
		        		}
		        		else if(user instanceof TechSupportGuy)
		        		{
		        			TechSupportGuysPage: while(true) {
                                System.out.println("1) View orders");
                                System.out.println("2) Add done order to list");
                                System.out.println("3) View done orders");
                                System.out.println("4) Quit");
                                choice = in.readLine();
                                if(choice.equals("1")) {
                                    System.out.println(((TechSupportGuy) user).getOrder().toString());
                                }
                                else if(choice.equals("2")){
                                    System.out.println("Enter id of the order");
                                    choice  = in.readLine();
                                    ((TechSupportGuy) user).doneOrder(Database.orders.get(Integer.parseInt(choice)-1));
                                }
                                else if(choice.equals("3")){
                                    System.out.println(((TechSupportGuy) user).viewDoneOrders());
                                }
                                else {
                                    break;
                                }
                            }
		        		}
		        	}
		        	else {
		        		System.out.println("Wrong ID or PASSWORD!");
		        		continue mainPage;
		        	}
	        	}
	        	
	        }
		}catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Can not read from file");
		}
		catch(ArrayIndexOutOfBoundsException oute)
		{
			System.out.println("Try again!");
		}
//        catch(FileNotFoundException fe) {
//            System.out.println("File not found");
//        } 
	}
}

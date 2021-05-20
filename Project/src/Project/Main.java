package Project;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	public static void uploadObjects() throws IOException, ClassNotFoundException{
        if(new File("users.ser").exists()) Database.deserUsers();
        if(new File("specialities.ser").exists()) Database.deserSpecialities();
        if(new File("students.ser").exists()) Database.deserStudents();
        if(new File("teachers.ser").exists()) Database.deserTeachers();
        if(new File("managers.ser").exists()) Database.deserManagers();
        if(new File("techSupportGuys.ser").exists()) Database.deserTechSupportGuys();
        if(new File("admins.ser").exists()) Database.deserAdmins();
        if(new File("orders.ser").exists()) Database.deserOrders();
        if(new File("courses.ser").exists()) Database.deserCourses();
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
	public static void main(String args[])throws CloneNotSupportedException, ClassNotFoundException
	{
		try{
			
			String inputName,inputSurname, inputID,inputPassword,inputSpeciality,inputPosition,choice;
			int inputAge,inputYearOfStudy, index = 1;;
			Boolean idCheck = false, passwordCheck = false;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        User user = null;
	        Degree degree;
	        Order order;
	        Position position;
	        ManagerType type;
	        Speciality speciality;
	        
	        
	        Speciality speciality1 = new Speciality("IS", "5B070300");
	        Speciality speciality2 = new Speciality("Computer technology and software", "5B070400");
	        Speciality speciality3 = new Speciality("Automation and Control", "5B070200");
	        Database.specialities.add(speciality1);
	        Database.specialities.add(speciality2);
	        Database.specialities.add(speciality3);
	        Admin admin = new Admin("Bekzat", "Tolegenov", 19,"18BD111653", "12345");
	        Student student = new Student("Aiymzhan","Syzdykbek",  19, "18BD100200", "12345", Degree.BACHELOR,2,speciality1);
	        Teacher teacher = new Teacher("Pakita","Shamoi", 30, "12TD000001", "shamoi", Degree.PHD, Position.PROFESSOR);
	        Manager manager = new Manager("Zangar", "Taubay", 19, "18ME100200", "zangar", ManagerType.OR_MANAGER);
	        TechSupportGuy techSupportGuy = new TechSupportGuy("TechSupportGuy", "TechSupportGuyev", 33, "10TS123456","12345");
	        Database.users.add(admin);
	        Database.admins.add(admin);
	        Database.students.add(student);
	        Database.users.add(student);
	        Database.teachers.add(teacher);
	        Database.users.add(teacher);
	        Database.managers.add(manager);
	        Database.users.add(manager);
	        Database.techSupportGuys.add(techSupportGuy);
	        Database.users.add(techSupportGuy);
	        Course course = new Course("OOP");
	        Database.courses.add(course);
	        course.setTeacher(teacher);
	        File file = new File("OopFile");
	        course.setFiles(file);
	        
	        System.out.println("Do you want to upload data from previous session?\n\n     [1]Yes                [2]No");
	        choice = in.readLine();
	        if(choice.equals("1"))
	        {
	        	uploadObjects();
	        	System.out.println("\n\nUploaded!");
	        }
	        
	        
	        System.out.println("Welcome!");
	        mainPage: while(true)
	        {
	        	System.out.println("Select action: ");
	        	System.out.println("1) Login");
	        	System.out.println("2) Exit");
	        	choice = in.readLine();
	        	if(choice.equals("2"))
	        	{
	        		System.out.println("Save the changes?\n\n     [1]Yes                [2]No");
	        		choice = in.readLine();
	        		if(choice.equals("1"))
	        		{
	        			save();
	        			System.out.println("Changes are saved!");
	        		}
	        		System.out.println("Bye!");
	        		break;
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
			        					for(ManagerType value: ManagerType.values()){
                                            System.out.println(index+ ") " + value.name());
                                            index++;
                                        }
                                        index = 1;
                                        choice = in.readLine();
                                        type = ManagerType.values()[Integer.parseInt(choice)-1];
                                        Manager newManager = new Manager(inputName, inputSurname, inputAge,inputID,inputPassword,type);
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
		        						continue adminsPage;
		        					}
		        				}
		        				else if(choice.equals("2"))
		        				{
		        					//Remove user
		        					System.out.println("Choose User");
                                    for(int i = 0; i < Database.users.size(); i++) {
                                        System.out.println(i+1 + Database.users.get(i).toString());
                                    }
                                    choice = in.readLine();
                                    System.out.println( Database.users.get(Integer.parseInt(choice)-1).toString());
                                    ((Admin) user).removeUser(Integer.parseInt(choice)-1);
                                    System.out.println("User is removed!");
		        				}
		        				else if(choice.equals("3"))
		        				{
		        					//Update user
		        					System.out.println("Choose User");
                                    for(int i = 0; i < Database.users.size(); i++) {
                                        System.out.println(i+1 + Database.users.get(i).toString());
                                    }
                                    choice = in.readLine();
                                    System.out.println( Database.users.get(Integer.parseInt(choice)-1).toString());
                                    User userUpdate = Database.users.get(Integer.parseInt(choice)-1);
                                    
                                    while(true){
                                        System.out.println("\n 1) Change name\n 2) Change surname\n 3) Change id\n 4) reset password\n 5) quit");
                                        choice = in.readLine();
                                        if(choice.equals("1")){
                                            System.out.println("Enter new NAME");
                                            inputName = in.readLine();
                                            if(inputName.equals("0"))
                                            {
                                            	continue adminsPage;
                                            }
                                            userUpdate.setName(inputName);
                                        }

                                        else if(choice.equals("2")){
                                            System.out.println("Enter new SURNAME");
                                            inputSurname = in.readLine();
                                            if(inputSurname.equals("0"))
                                            {
                                            	continue adminsPage;
                                            }
                                            userUpdate.setSurname(inputSurname);
                                        }

                                        else if(choice.equals("3")){
                                            System.out.println("Enter new ID");
                                            inputID = in.readLine();
                                            if(inputID.equals("0"))
                                            {
                                            	continue adminsPage;
                                            }
                                            userUpdate.setId(inputID);
                                        }

                                        else if(choice.equals("4")){
                                        	System.out.println("Enter new PASSWORD");
                                        	inputPassword = in.readLine();
                                        	if(inputPassword.equals("0"))
                                            {
                                            	continue adminsPage;
                                            }
                                            userUpdate.setPassword(inputPassword);
                                        }

                                        else if(choice.equals("5")){
                                            break;
                                        }
                                    }
		        				}
		        				else if(choice.equals("4"))
		        				{
		        					continue mainPage;
		        				}
		        			}
		        		}
		        		else if(user instanceof Student)
		        		{
		        			studentsPage: while(true) {
                                System.out.println("1) View GPA");
                                System.out.println("2) View transcript");
                                System.out.println("3) View courses");
                                System.out.println("4) View courses marks");
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
                                    System.out.println("Enter courses id");
                                    choice = in.readLine();
                                    Course current = ((Student) user).courses.get(Integer.parseInt(choice));
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
                                System.out.println("3) View students of specified courses");
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
                                    System.out.println("Enter id of the courses");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue teachersPage;
                                    }
                                    Course current = ((Teacher) user).courses.get(Integer.parseInt(choice));
                                    System.out.println(current.toString());
                                }

                                else if(choice.equals("4")){
                                    System.out.println(((Teacher) user).getCourses());
                                    System.out.println("Enter id of the courses");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue teachersPage;
                                    }
                                    Course current = ((Teacher) user).courses.get(Integer.parseInt(choice));
                                    Vector<Student> stud = ((Teacher) user).students.get(current);
                                    for(int i = 0; i < stud.size(); i++){
                                        System.out.println(i+1 + " " + stud.get(i));
                                    }
                                    System.out.println("Enter id of the student");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue teachersPage;
                                    }
                                    Student curStudent = stud.get(Integer.parseInt(choice));
                                    System.out.println("Enter Mark of the student");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue teachersPage;
                                    }
                                    curStudent.setCourseMarks(current, Integer.parseInt(choice));
                                }

                                else if(choice.equals("5")){
                                    System.out.println(((Teacher) user).getCourses());
                                    System.out.println("Enter id of the courses");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue teachersPage;
                                    }
                                    Course current = ((Teacher) user).courses.get(Integer.parseInt(choice));
                                    Vector<Student> stud = ((Teacher) user).students.get(current);
                                    for(int i = 0; i < stud.size(); i++){
                                        System.out.println(i+1 + " " + stud.get(i));
                                    }
                                    System.out.println("Enter id of the student");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue teachersPage;
                                    }
                                    Student curStudent = stud.get(Integer.parseInt(choice));
                                    System.out.println("Enter final score of the student");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue teachersPage;
                                    }
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
                                System.out.println("1) Create courses");
                                System.out.println("2) Add courses to teacher");
                                System.out.println("3) Add student to specified courses");
                                System.out.println("4) Logout");

                                choice = in.readLine();
                                if(choice.equals("1")){
                                    System.out.println("Enter courses title or 0 to exit");
                                    if(choice.equals("0"))
                                    {
                                    	continue managersPage;
                                    }
                                    String _title = in.readLine();
                                    Course current = new Course(_title);
                                    Database.courses.add(current);
                                }

                                else if(choice.equals("2")){

                                    Course current;
                                    for(int i = 0; i < Database.courses.size(); i++) {
                                        System.out.println(i+1 + ") " + Database.courses.get(i).toShow());
                                    }

                                    System.out.println("Enter courses number or 0 to exit");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue managersPage;
                                    }
                                    current = Database.courses.get(Integer.parseInt(choice)-1);

                                    for(int i = 0; i < Database.teachers.size(); i++) {
                                        System.out.println(i+1 + ") " + Database.teachers.get(i));
                                    }

                                    System.out.println("Enter teacher's number");
                                    
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue managersPage;
                                    }
                                    Teacher CurTeacher =  Database.teachers.get(Integer.parseInt(choice)-1);

                                    int k = CurTeacher.courses.size();
                                    CurTeacher.setCourse(k, current);

                                }

                                else if(choice.equals("3")){

                                    for(int i = 0; i < Database.teachers.size(); i++) {
                                        System.out.println(i+1 + ") " + Database.teachers.get(i));
                                    }

                                    System.out.println("Enter teacher's number or 0 to exit");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue managersPage;
                                    }
                                    Teacher CurrentTeacher =  Database.teachers.get(Integer.parseInt(choice)-1);

                                    for(int i = 0; i < CurrentTeacher.courses.size(); i++) {
                                        System.out.println(i+1 + " " + CurrentTeacher.courses.get(i));
                                    }

                                    System.out.println("Enter courses number or 0 to exit");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue managersPage;
                                    }
                                    Course currentCourse = CurrentTeacher.courses.get(Integer.parseInt(choice)-1);
//                                    System.out.println(currentCourse);
                                    for(int i = 0; i < Database.students.size(); i++) {
                                        System.out.println(i+1 + ") " + Database.students.get(i));
                                    }
                                    
                                    System.out.println("Enter student's number or 0 to exit");
                                    choice = in.readLine();
                                    if(choice.equals("0"))
                                    {
                                    	continue managersPage;
                                    }
                                    Student currentStudent = Database.students.get(Integer.parseInt(choice)-1);
//                                    System.out.println(currentStudent);
                                    CurrentTeacher.setStudentToCourse(currentCourse, currentStudent);

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
                                System.out.println("4) Logout");
                                choice = in.readLine();
                                if(choice.equals("1")) {
                                    System.out.println(((TechSupportGuy) user).getOrder().toString());
                                }
                                else if(choice.equals("2")){
                                    System.out.println("Enter id of the order or 0 to exit");
                                    choice = in.readLine();
                                    if(choice.equals("0")) 
                                    {
                                    	continue TechSupportGuysPage;
                                    }
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

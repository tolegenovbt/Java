package Project;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Driver {

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

    public static void clear() {
        Database.users.clear();
        Database.admins.clear();
        Database.techSupportGuys.clear();
        Database.managers.clear();
        Database.students.clear();
    }

    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException {
        String inputId, inputPassword, inputName, inputSurname, inputSpeciality, inputPosition;
        String line, id, password;
        String currentInput;
        String choice;
        String title, text;
        int inputYearOfStudy, index = 1;

        boolean idCheck = false, passwordCheck = false;
        try {
            deserializeObjects();
            BufferedReader br = new BufferedReader(new FileReader("base.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("base.txt", true));
            //\Scanner in = new Scanner(System.in);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer token;
            User user = null;
            Degree degree;
            Order order;
            Position position;
            ManagerPlace place;

            //
			clear();
			Admin a = new Admin("Ruslan", "Sarybayev",20, "17BD090499", "rruss");
			Database.users.add(a);
			Database.admins.add(a);
			/*Speciality spec = new Speciality("IS", "5B070300");
			Database.specialities.add(spec);
			Student s = new Student("Student", "Studentov", "16SD00001", "111", Degree.BACHELOR, 2, spec);
			Database.users.add(s);
			Database.students.add(s);
			Teacher t = new Teacher("Teacher", "Teacherov", "16TD00001", "111", Degree.PHD, Position.LECTOR);
			Database.users.add(t);
			Database.teachers.add(t);
			Manager m = new Manager("Manager", "Managerov", "16MD00001", "111", ManagerPlace.OR_MANAGER);
			Database.users.add(m);
			Database.managers.add(m);
			TechSupportGuy e = new TechSupportGuy("TechSupportGuy", "Executorov", "16ED00001", "111");
			Database.users.add(e);
			Database.techSupportGuys.add(e);*/
			//

            System.out.println("Welcome!");
            main : while(true) {
                System.out.println("Enter your id and password else '0' to exit");
                inputId = null;
                inputPassword = null;
                in = new BufferedReader(new InputStreamReader(System.in));
                inputId = in.readLine();
                //			System.out.println(Database.users.get(0).getId());
                if(inputId.equals("0")) {
                    System.out.println("Goodbye!");

                    break;
                }
                else {
                    inputPassword = in.readLine();
                    for(User u : Database.users) {
                        //System.out.println(u.toString());
                        if((u.getId()).equals(inputId)){
                            idCheck = true;
                            if((u.getPassword()).equals(inputPassword)) {
                                passwordCheck = true;
                                user = u;
                            }
                        }
                    }



                    if(idCheck) {
                        if(passwordCheck) {
                            System.out.println("Hello, " + user.getName());
                            if(user instanceof Admin) {
                                admin : while(true) {
                                    System.out.println("What do you want to do?");
                                    System.out.println("\n 1) Add User \n 2) Update User \n 3) Remove User \n 4) Add order for TechSupportGuy\n 5) Return back \n 6) Exit");

                                    choice = in.readLine();
                                    if(choice.equals("1")) {
                                        adding : while(true) {
                                            System.out.println("Enter information about User");
                                            System.out.println("Enter name, surname, user id and set password \n 1) Return back \n 2) Exit");
                                            inputName = in.readLine();
                                            if(inputName.equals("1")) {

                                                continue admin;

                                            }
                                            else if(inputName.equals("2")) {
                                                break main;
                                            }
                                            else {
                                                inputSurname = in.readLine();
                                                inputId = in.readLine();
                                                inputPassword = in.readLine();
                                                System.out.println("What type of User you want to add?");
                                                System.out.println("\n 1) Student \n 2) Teacher \n 3) Manager \n 4) TechSupportGuy \n 5) Admin");
                                                choice = in.readLine();
                                                if(choice.equals("1")) {
                                                    System.out.println("Enter  information about Student");
                                                    System.out.println("Choose degree, enter year of study and speciality");
                                                    System.out.println("Choose degree");

                                                    for(Degree value: Degree.values()){
                                                        System.out.println(index+ ") " + value.name());
                                                        index++;
                                                    }
                                                    index = 1;
                                                    choice = in.readLine();
                                                    degree  = Degree.values()[Integer.parseInt(choice)-1];
                                                    inputYearOfStudy = Integer.parseInt(in.readLine());

                                                    System.out.println("Choose Speciality");
                                                    for(int i = 0; i < Database.specialities.size(); i++) {
                                                        System.out.println(i + 1 + Database.specialities.get(i).toString());
                                                    }
                                                    choice = in.readLine();
                                                    Speciality speciality = (Speciality)Database.specialities.get(Integer.parseInt(choice)-1).clone();
                                                    ((Admin) user).addUser(new Student(inputName, inputSurname, inputId, inputPassword, degree, inputYearOfStudy, speciality));
                                                    Database.students.add(new Student(inputName, inputSurname, inputId, inputPassword, degree, inputYearOfStudy, speciality));

                                                    System.out.println(("The Sudent: \n" + new Student(inputName, inputSurname, inputId, inputPassword, degree, inputYearOfStudy, speciality).toString() + "\nwas added sucessfully!"));
                                                }
                                                else if(choice.equals("2")) {
                                                    System.out.println("Enter information about Teacher");
                                                    System.out.println("Choose degree");

                                                    for(Degree value: Degree.values()){
                                                        System.out.println(index+ ") " + value.name());
                                                        index++;
                                                    }
                                                    index = 1;
                                                    choice = in.readLine();
                                                    degree  = Degree.values()[Integer.parseInt(choice)-1];

                                                    System.out.println("Choose position");

                                                    for(Position value: Position.values()){
                                                        System.out.println(index+ ") " + value.name());
                                                        index++;
                                                    }
                                                    index = 1;
                                                    choice = in.readLine();
                                                    position  = Position.values()[Integer.parseInt(choice)-1];
                                                    ((Admin) user).addUser(new Teacher(inputName, inputSurname, inputId, inputPassword, degree, position));
                                                    Database.teachers.add(new Teacher(inputName, inputSurname, inputId, inputPassword, degree, position));

                                                    System.out.println(("The Teacher: \n" + new Teacher(inputName, inputSurname, inputId, inputPassword, degree, position).toString() + "\nwas added sucessfully!"));

                                                }
                                                else if(choice.equals("3")) {
                                                    System.out.println("Enter information about Manager");
                                                    System.out.println("Choose Manager Place");

                                                    for(ManagerPlace value: ManagerPlace.values()){
                                                        System.out.println(index+ ") " + value.name());
                                                        index++;
                                                    }
                                                    index = 1;
                                                    choice = in.readLine();
                                                    place  = ManagerPlace.values()[Integer.parseInt(choice)-1];

                                                    ((Admin) user).addUser(new Manager(inputName, inputSurname, inputId, inputPassword, place));
                                                    Database.managers.add(new Manager(inputName, inputSurname, inputId, inputPassword, place));

                                                    System.out.println(("The Manager: \n" + new Manager(inputName, inputSurname, inputId, inputPassword,place).toString() + "\nwas added sucessfully!"));

                                                }
                                                else if(choice.equals("4")) {
                                                    ((Admin) user).addUser(new TechSupportGuy(inputName, inputSurname, inputId, inputPassword));
                                                    Database.techSupportGuys.add(new TechSupportGuy(inputName, inputSurname, inputId, inputPassword));

                                                    System.out.println(("The TechSupportGuy: \n" + new TechSupportGuy(inputName, inputSurname, inputId, inputPassword).toString() + "\nwas added sucessfully!"));
                                                }
                                                else if(choice.equals("5")) {
                                                    ((Admin) user).addUser(new Admin(inputName, inputSurname, inputId, inputPassword));
                                                    Database.admins.add(new Admin(inputName, inputSurname, inputId, inputPassword));

                                                    System.out.println(("The Admin: \n" + new Admin(inputName, inputSurname, inputId, inputPassword).toString() + "\nwas added sucessfully!"));
                                                }
                                            }


                                        }

                                    }
                                    else if(choice.equals("2")) {
                                        System.out.println("Choose User");
                                        for(int i = 0; i < Database.users.size(); i++) {
                                            System.out.println(i+1 + Database.users.get(i).toString());
                                        }
                                        choice = in.readLine();
                                        System.out.println( Database.users.get(Integer.parseInt(choice)-1).toString());
                                        User userUpdate = Database.users.get(Integer.parseInt(choice)-1);
                                        boolean v = true;
                                        while(v){
                                            System.out.println("\n 1) Change name\n 2) Change surname\n 3) Change id\n 4) reset password\n 5) quit");
                                            choice = in.readLine();
                                            if(choice.equals("1")){
                                                System.out.println("Enter name");
                                                inputName = in.readLine();
                                                userUpdate.setName(inputName);
                                            }

                                            else if(choice.equals("2")){
                                                System.out.println("Enter surname");
                                                inputSurname = in.readLine();
                                                userUpdate.setSurname(inputSurname);
                                            }

                                            else if(choice.equals("3")){
                                                System.out.println("Enter Id");
                                                inputId = in.readLine();
                                                userUpdate.setId(inputId);
                                            }

                                            else if(choice.equals("4")){
                                                userUpdate.setPassword("kbtu123");
                                            }

                                            else if(choice.equals("5")){
                                                v = false;
                                            }
                                        }
                                    }
                                    else if(choice.equals("3")) {
                                        System.out.println("Choose User");
                                        for(int i = 0; i < Database.users.size(); i++) {
                                            System.out.println(i+1 + Database.users.get(i).toString());
                                        }
                                        choice = in.readLine();
                                        System.out.println( Database.users.get(Integer.parseInt(choice)-1).toString());
                                        //((Admin) user).removeUser(Database.users.get(Integer.parseInt(choice)-1));
                                        ((Admin) user).removeUser(Integer.parseInt(choice)-1);
                                    }
                                    else if(choice.equals("4")) {

                                        System.out.println("Enter title and text of your order");
                                        title = in.readLine();
                                        text = in.readLine();

                                        order = new Order(title, text, Database.orders.size()+1);

                                        ((Admin) user).setOrder(order);
                                        System.out.println("You added succesfully");
                                    }
                                    else if(choice.equals("5")) continue main;
                                    else {
                                        System.out.println("Goodbye!");
                                        break main;
                                    }
                                }

                            }
                            else if(user instanceof TechSupportGuy) {
                                while(true) {
                                    System.out.println("1) to view orders");
                                    System.out.println("2) to add done order to list");
                                    System.out.println("3) to view done orders");
                                    System.out.println("4) quit");
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
                            else if(user instanceof Student) {
                                while(true) {
                                    System.out.println("1) to view gpa");
                                    System.out.println("2) to view transcript");
                                    System.out.println("3) to view courses");
                                    System.out.println("4) to view course marks");
                                    System.out.println("5) to view all marks");
                                    System.out.println("6) quit");
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
                            else if(user instanceof Manager) {
                                while(true) {
                                    System.out.println("1) to create course");
                                    System.out.println("2) to add course to techer");
                                    System.out.println("3) to add student to specified course");
                                    System.out.println("4) quit");

                                    choice = in.readLine();
                                    if(choice.equals("1")){
                                        System.out.println("Enter course title");
                                        String _title = in.readLine();
                                        Course current = new Course(_title);
                                        Database.courses.add(current);
                                        //System.out.println( Database.courses.size());
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
                            else if(user instanceof Teacher) {
                                while(true) {
                                    System.out.println("1) to send order");
                                    System.out.println("2) to view courses");
                                    System.out.println("3) to view students of specified course");
                                    System.out.println("4) to put mark to student");
                                    System.out.println("5) to put final grade to student's transcript");
                                    System.out.println("6) quit");

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
                            else if(user instanceof Student) {

                            }

                        }
                        else {
                            System.out.println("Wrong password!!!");
                            continue main;
                        }
                    }
                    else {
                        System.out.println("Wrong ID!!!");
                        continue main;
                    }


                }
            }
            save();
            bw.close();
            br.close();
        }
        catch(FileNotFoundException fe) {
            System.out.println("File not found");
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Can’t read from file");
        }


    }

}

/*br = new BufferedReader(new FileReader("base.txt"));
 * while((line = br.readLine()) != null) {

if(line.contains(inputId)) {
	token = new StringTokenizer(line, " ", false);
	id = token.nextToken();
	password = token.nextToken();
	position = token.nextToken();

	if(password.equals(inputPassword)) {
		ok = true;
		System.out.println("You have signed in as " + position);

if(position.equals("Admin")) {

}
}
else {

ok = true;
System.out.println("Wrong password!");
break;
}

}


}

if(!ok) {
System.out.println("Wrong id");
}*/

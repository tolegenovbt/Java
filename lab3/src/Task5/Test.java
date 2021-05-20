package Task5;
import java.util.Scanner;
import java.util.Vector;

public class Test {
	private static Vector<Student> students = new Vector<Student>();
	private static Vector<Staff> staffs = new Vector<Staff>();
    private static Vector<Person> persons = new Vector<Person>();
	
	public static void addStudent(Student student) {
		students.add(student);
	}
	
	public static  void addStaff(Staff staff) {
		staffs.add(staff);
	}
	
	public static  void addPerson(Person person) {
		persons.add(person);
	}
	
	
	public static void printInfo() {
	    students.forEach(students->System.out.println("\n"+students));
	    staffs.forEach(staffs->System.out.println(staffs));
	    persons.forEach(persons->System.out.println(persons));
	}
	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	//System.out.println("1.Print information\n" + "2.Add new Person");
	
	while(true) {
		System.out.println("\n1.Print information\n" + "2.Add new Person");
		String choice = in.next();
	
	
			if(Integer.parseInt(choice) == 2) {
				System.out.println("Please enter S if you want to add student or E for staff or P for person: ");
				String str = in.next();
				if(str.toUpperCase().charAt(0) == 'S' && str.length() == 1) {
					System.out.println("Please enter name, address, program, year, fee:");
					Student student = new Student(in.next(), in.next(), in.next(), in.nextInt(), in.nextDouble());
					 addStudent(student);
					 System.out.println("\nSuccessfully added!");
				}
				else if(str.toUpperCase().charAt(0) == 'E' && str.length() == 1) {
					System.out.println("Please enter name, address, school, pay:");
					Staff staff = new Staff(in.next(), in.next(), in.next(), in.nextDouble());
					 addStaff(staff);
					 System.out.println("\nSuccessfully added!");
				}
				else if(str.toUpperCase().charAt(0) == 'P' && str.length() == 1) {
					System.out.println("Please enter name, address: ");
					Person person = new Person(in.next(), in.next());
					 addPerson(person);
					 System.out.println("\nSuccessfully added!");
				}
				else if(str.length() > 1 && str.toUpperCase().charAt(0) != 'S' && str.toUpperCase().charAt(0) == 'E' && str.toUpperCase().charAt(0) == 'P') {
					System.out.println("Please write in right case!!!");
					break;
				}
			}
			
			if(Integer.parseInt(choice) == 1) {
				printInfo();
			}
	} 
	 in.close();
  }
}

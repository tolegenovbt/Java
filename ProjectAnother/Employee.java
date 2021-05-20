package package1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee extends User implements Serializable{
	
	private int salary;
	private int experience = 1;
	
	public Employee() {}
	public Employee(String login, String password, String userSurName, String userName, String userFatherName,
			int salary) {
		super(login,password, userSurName, userName, userFatherName);
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public void incrementExperience() {
		experience++;
	}
	
	public int compareTo(Object o) {
		Employee ch = (Employee) o;
		if (ch.salary < this.salary) {
			return 1;
		}else if (ch.salary > this.salary){
			return -1;
		}
		return 0;
	}
	
	public String toString() {	
		return super.toString() + " Experience " + experience + " Salary :"  + salary;
	}
}

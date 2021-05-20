package package1;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Admin extends Employee implements Serializable{
	@SuppressWarnings("unused")
	private Database database = new Database();
		
	public Admin(String login, String password, String userSurName, String userName, String userFatherName, int salary) {
		super(login, password, userSurName, userName, userFatherName, salary);
	}
	
	public static User createUser(User user) {
		Database.addUser(user);
		return user;
	}
	
	public static boolean setPassword(int id,String pass) {
		for(User u : Database.users) {
			if (u.getId() == id) {
				u.setPassword(pass);
				return true;
			}
		}
		return false;
	}
	
	public static boolean deleteUser(int id) {
		for(User u : Database.users) {
			if (u.getId() == id) {
				Database.users.remove(u);
				System.out.println(u);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return super.toString();
	}
	
}

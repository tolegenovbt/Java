package package1;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class User implements Serializable{
	private static int idNext = Database.users.size();
	private String login;
	private String password;
	private int userId;
	private String userSurName;
	private String userName;
	private String userFatherName;
		
	public User() {}
	public User(String login, String password, String userSurName, String userName, String userFatherName) {
		this.login = login;
		this.password = password;
		this.userSurName = userSurName;
		this.userName = userName;
		this.userFatherName = userFatherName;
		this.userId = idNext++;
	}
	
	public int getId() {
		return this.userId;
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		if (this.password.equals(oldPassword)) {
			this.password = newPassword;
			return true;
		}else {
			return false;
		}
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getPass() {
		return this.password;
	}
	public String getLogin() {
		return this.login;
	}
	
	public int compareTo(Object o) {
		User ch = (User) o;
		if (ch.userId < this.userId) {
			return 1;
		}else if (ch.userId > this.userId){
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return userId + " "  + login + " " + password + " " + userSurName+ " " + userName+ " " + userFatherName + " ";
	}
}

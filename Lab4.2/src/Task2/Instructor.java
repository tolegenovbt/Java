package Task2;

import java.io.*;
import java.util.*;

public class Instructor implements Serializable{
    private String name;
    private String surname;
    private String department;
    private String email;
    
	public Instructor(String name, String surname, String department, String email) {
		this.name= name;
		this.surname = surname;
		this.department = department;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return name + " " + surname + " | " + department + " | " + email;
	}
	
	public boolean equals(Object object) {
		if(object == this) return true;
		if(object instanceof Instructor) {
			Instructor i = (Instructor)object;
			return (this.name.equals(i.name) &&
					this.surname.equals(i.surname) &&
					this.department.equals(i.department) &&
					this.email.equals(i.email));
		}
		return false;
	}
	
	public static void save(Vector<Instructor> instructors) throws IOException{
        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("Instructors.out"));
        oos.writeObject(instructors);
        oos.close();
    }

    public static Vector<Instructor> get() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Instructors.out"));
        Vector<Instructor> instructors = (Vector<Instructor>) ois.readObject();
        ois.close();
        return instructors;
    }
	

}

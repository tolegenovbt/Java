import java.util.*;

public class Admin extends Employee {
    public Admin() {
        super();
    }
    public Admin( String name, String surname, int age, String id, String password) {
        super(name, surname, age, id, password);
    }
    public int compareTo(Object a) {
        return super.compareTo(a);
    }
    @Override
    public String toString() {
        return super.toString() +"\nAdmin";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object a) {
        Admin aa = (Admin) a;
        return Objects.equals(this, aa);
    }

//    public User clone() throws CloneNotSupportedException {
//        Admin cloned = (Admin) super.clone();
//        return cloned;
//    }

    public void removeUser(int index) {
        Database.users.remove(index);
        //Database.managers.remove(index);
    }

    public void addUser(User user) {
        Database.users.add(user);
    }

    public void updateUser(User a, String name, String surname, String id, String password) {
        a.setName(name);
        a.setSurname(surname);
        a.setId(id);
        a.setPassword(password);
    }

}



import java.util.*;

public class Employee extends User {

    private int salary;

    public Employee() {
        super();
    }


    public Employee(String name, String surname, String id, String password) {
        super(name, surname, id, password);

    }


    public Employee(int salary) {
        super();
        this.salary = salary;
    }


    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "\n" + super.toString();
    }

    public int compareTo(Object other) {
        return super.compareTo(other);
    }

    public User clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        return cloned;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + salary;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (salary != other.salary)
            return false;
        return true;
    }

    public Vector<Order> getOrder() {
        return Database.orders;
    }

    public void setOrder(Order order) {
        Database.orders.add(order);
    }
}
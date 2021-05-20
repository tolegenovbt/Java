package Project;

import java.util.*;

public class TechSupportGuy extends Employee {

    private Vector<Order> orders;
    private Vector<Order> doneOrders;

    public TechSupportGuy() {
        super();
    }

    public TechSupportGuy(int salary) {
        super(salary);
    }

    public TechSupportGuy(String name, String surname,int age, String id, String password) {
        super(name, surname,age, id, password);
        orders = new Vector<Order>();
        doneOrders = new Vector<Order>();
    }

    public int compareTo(Object other) {
        return super.compareTo(other);
    }

    public String toString() {
        return super.toString();
    }

    public int hashCode() {
        return Objects.hash(this);
    }

    public User clone() throws CloneNotSupportedException {
        TechSupportGuy cloned = (TechSupportGuy) super.clone();
        return cloned;
    }

    public boolean equals(Object a) {
        TechSupportGuy aa = (TechSupportGuy) a;
        return Objects.equals(this, aa);
    }

    public void setSalary(int salary) {
        super.setSalary(salary * orders.size());;
    }



    public void acceptOrder(Order a) {
        orders.addElement(a);
    }

    public void doneOrder(Order a) {
        this.doneOrders.add(a);
        Database.orders.removeElementAt(a.getId()-1);
        setSalary(this.getSalary());
    }

    public void rejectOrder(Order a) {
        orders.removeElement(a);
    }

    public Vector<Order> viewOrders() {
        return orders;
    }


    public Vector<Order> viewDoneOrders() {
        return doneOrders;
    }
}


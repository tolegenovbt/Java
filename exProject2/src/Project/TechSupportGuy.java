package Project;

import java.util.*;

public class TechSupportGuy extends Employee {

    private Vector<Order> order;

    private Vector<Order> doneOrder;

    public TechSupportGuy() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TechSupportGuy(int salary) {
        super(salary);
        // TODO Auto-generated constructor stub
    }

    public TechSupportGuy(String name, String surname,int age, String id, String password) {
        super(name, surname,age, id, password);
        order = new Vector<Order>();
        doneOrder = new Vector<Order>();
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
        super.setSalary(salary * order.size());;
    }



    public void acceptOrder(Order a) {
        order.addElement(a);
    }

    public void doneOrder(Order a) {
        this.doneOrder.add(a);
        Database.orders.removeElementAt(a.getId()-1);
        setSalary(this.getSalary());
    }

    public void rejectOrder(Order a) {
        order.removeElement(a);
    }

    public Vector<Order> viewOrders() {
        return order;
    }


    public Vector<Order> viewDoneOrders() {
        return doneOrder;
    }
}


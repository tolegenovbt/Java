
import java.util.*;

public class Executor extends Employee {

    private Vector<Order> order;

    private Vector<Order> doneOrder;

    public Executor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Executor(int salary) {
        super(salary);
        // TODO Auto-generated constructor stub
    }

    public Executor(String name, String surname, String id, String password) {
        super(name, surname, id, password);
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
        Executor cloned = (Executor) super.clone();
        return cloned;
    }

    public boolean equals(Object a) {
        Executor aa = (Executor) a;
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


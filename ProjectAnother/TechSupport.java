package package1;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class TechSupport extends Employee{
	private ArrayList<Order> orders;
	
	public TechSupport(String login, String password, String userSurName, String userName, String userFatherName,
			int salary) {
		super(login, password, userSurName, userName, userFatherName, salary);
	}
	
	public ArrayList<Order> getOrders(){
		if (orders !=null)
			return orders;
		else
			return null;
	}
	
	public ArrayList<Order> getDoneOrders(){
		ArrayList<Order> ans = new ArrayList<Order>();
		if (orders == null)
			return null;
		for(Order o : orders)
			if (o.getOrderStatus().equals("Done"))
				ans.add(o);
		return ans;
	}
	public ArrayList<Order> getNotDoneOrders(){
		ArrayList<Order> ans = new ArrayList<Order>();
		if (orders == null)
			return null;
		for(Order o : orders)
			if (o.getOrderStatus().equals("NotDone"))
				ans.add(o);
		return ans;
	}
	
	public boolean setDoneOrder(int orderId) {
		if (orders == null)
			return false;
		for(Order o : orders) {
			if (o.getOrderId() == orderId) {
				o.setDone();
				return true;
			}
		}
		return false;
	}
	
	public void receiveOrder(Order order) {
		if (orders==null)
			orders = new ArrayList<Order>();
		orders.add(order);
	}
	
	public int compareTo(Object o) {
		TechSupport ch = (TechSupport) o;
		if (ch.orders.size() < this.orders.size()) {
			return 1;
		}else if (ch.orders.size() > this.orders.size()){
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return super.toString();
	}
}

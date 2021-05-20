package package1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Order implements Serializable{
	private static int orders = 0;
	private int orderId;
	private String title;
	private String report;
	private boolean done;
	public Order() {
		done = false;
	}
	
	public Order(String title, String report) {
		this.orderId = ++orders;
		this.title = title;
		this.report = report;
	}
	
	public void setDone() {
		done = true;
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public String getOrderStatus() {
		if (done)
			return "Done";
		else
			return "NotDone";
	}
	
	public int compareTo(Object o) {
		Order ch = (Order) o;
		if (ch.done ==true && this.done == false) {
			return 1;
		}else if (ch.done ==false && this.done == true){
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return "Title " + title + " Report : " + report + " ";
	}
	
}

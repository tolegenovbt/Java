
import java.util.*;
import java.lang.*;

public class Order extends Text {


    private int id;
    public Order() {
        super();
    }

    public Order(String orderTitle, String orderText, int id) {
        super(orderTitle, orderText);
        this.id = id;
    }

    public Order(String orderTitle) {
        super(orderTitle);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return super.toString() + "\nId: " + this.id;
    }
}
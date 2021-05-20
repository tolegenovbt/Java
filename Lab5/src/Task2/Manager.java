package Task2;

import java.util.Date;
import java.util.Vector;


public class Manager extends Employee implements Comparable {
   private Vector<Employee> team = new Vector<Employee>();
   double bonus;
   
   public Manager() {
	   super();
	   bonus = 0;
   }
   
   public Manager(String name,int age,double salary,Date hireDate,String insuranceNumber,double bonus) {
         super(name, age, salary, hireDate , insuranceNumber);
         this.bonus = bonus;
   }
   
   public void add(Employee employee) {
	   team.add(employee);
   }
   
   @Override
   public boolean equals(Object object) {
	   if(object instanceof Manager) {
		   Manager manager = (Manager)object;
		   	return (super.equals(manager) && this.team.equals(manager) && this.bonus == manager.bonus);
	   }
	   
	   return false;
   }
   
   @Override
   public String toString() {
	   String str = null + "\n";
	   for(Employee employee: this.team) {
		   str += employee.toString() + "\n";
	   }
	   
	   return super.toString() + ("Bonus: " + bonus + "\n" + "Team: " + str + "\n");
    }
   
   @Override
	public int compareTo(Object o) {
		Manager other = (Manager)o;
		int compare = super.compareTo(other);
		if(compare == 0) {
			if(bonus < other.bonus) return -1;
			if(bonus > other.bonus) return 1; 
		}
		return compare;
	}
}

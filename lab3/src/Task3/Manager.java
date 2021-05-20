package Task3;

import java.util.Vector;


public class Manager extends Employee{
   private Vector<Employee> team = new Vector<Employee>();
   double bonus;
   
   public Manager() {
	   super();
	   bonus = 0;
   }
   
   public Manager(String name,int age,double salary,int year,String insuranceNumber,double bonus) {
         super(name, age, salary, year, insuranceNumber);
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
}

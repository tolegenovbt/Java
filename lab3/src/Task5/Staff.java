package Task5;

public class Staff extends Person{
      private String school;
      private double pay;
      
      public Staff(){
    	  super();
    	  this.school = "unknown";
    	  this.pay = 0 ;
      }
      
      public Staff(String name,String address,String school,double pay) {
    	  super(name,address);
    	  this.school = school;
    	  this.pay = pay;
      }
      
      public String getSchool() {
      	return school;
      }
      
      public void setSchool(String school) {
      	this.school = school;
      }
      
      public Double getPay() {
      	return pay;
      }
      
      public void setPay(double pay) {
      	this.pay = pay;
      }
      
      @Override
      public String toString() {
      	return super.toString() + "School: \t" + getSchool() + "\n" + "Pay: \t" + getPay()+ "\n";
      }
}

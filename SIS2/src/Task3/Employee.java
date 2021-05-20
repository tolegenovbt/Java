package Task3;

import java.util.Date;

public class Employee extends Person implements Comparable, Cloneable{
	private double salary;
	private Date hireDate;
	private String insuranceNumber;
	
	public Employee() {
		super();
		this.salary = 0;
		this.hireDate = new Date();
		this.insuranceNumber = "No insurance number";
	}
	
	public Employee(String name,int age,double salary,Date hireDate,String insuranceNumber) {
		super(name,age);
		this.salary = salary;
		this.hireDate = hireDate;
		this.insuranceNumber = insuranceNumber;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Employee) {
			Employee employee = (Employee)object;
			return(super.equals(employee) && this.salary == employee.salary && this.hireDate == employee.hireDate && 
					this.insuranceNumber.equals(employee.insuranceNumber));
		}
		return false;  
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Salary: " + salary + "\n" +
	                              "hireDate:   " + hireDate   + "\n" +
	                              "Insurance number: " + insuranceNumber + "\n";
	}

	@Override
	public int compareTo(Object o) {
		Employee other = (Employee)o;
		if(salary < other.salary) return -1;
		if(salary > other.salary) return 1;
		return 0;  
	}
	
	@Override
    public Employee clone() throws CloneNotSupportedException {
        Employee e = (Employee) super.clone();
        e.hireDate = hireDate;
        e.insuranceNumber = insuranceNumber;
        return e;
	}

}


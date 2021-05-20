package Task3;

public class Employee extends Person{
	private double salary;
	private int year;
	private String insuranceNumber;
	
	public Employee() {
		super();
		this.salary = 0;
		this.year = 0;
		this.insuranceNumber = "No insurance number";
	}
	
	public Employee(String name,int age,double salary,int year,String insuranceNumber) {
		super(name,age);
		this.salary = salary;
		this.year = year;
		this.insuranceNumber = insuranceNumber;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Employee) {
			Employee employee = (Employee)object;
			return(super.equals(employee) && this.salary == employee.salary && this.year == employee.year && 
					this.insuranceNumber.equals(employee.insuranceNumber));
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Salary: " + salary + "\n" +
	                              "Year:   " + year   + "\n" +
	                              "Insurance number: " + insuranceNumber + "\n";
	}

}

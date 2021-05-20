package Task5;

public class Student extends Person {
    private String program;
    private int year;
    private double fee;
    
    public Student() {
    	super();
    	this.program = "no program";
    	this.year = 0;
    	this.fee  = 0;
    }
    
    public Student(String name,String address,String program,int year,double fee) {
    	super(name,address);
    	this.program = program;
    	this.year = year;
    	this.fee = fee;
    }
    
    public Student(String name,String address)
    {
    	super(name,address);
    	program = "no program";
    	year = 0;
    	fee = 0;
    }
    
    public String getProgram() {
    	return program;
    }
    
    public void setProgram(String program) {
    	this.program = program;
    }
    
    public Integer getYear() {
    	return year;
    }
    
    public void setYear(int year) {
    	this.year = year;
    }
    
    public Double getFee() {
    	return fee;
    }
    
    public void setFee(double fee) {
    	this.fee = fee;
    }
    
    @Override
    public String toString() {
    	return super.toString() + "Program: \t" + getProgram() + "\n" + "Year: \t" + getYear() + "\n" + 
               "Fee: \t" + getFee() + "\n";
    }
    
}

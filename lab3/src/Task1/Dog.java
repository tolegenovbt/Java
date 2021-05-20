package Task1;

public class Dog extends Animal{
   
	public Dog() {
		super();
	}
	
	public Dog(String name,String breed,String color,int age) {
		 super(name, breed, color, age);
	}
	
	public String getAllInfo() {
        return "Animal: Dog\n" + super.getAllInfo();
    }

    public String getAllInfo(String message) {
        return this.getAllInfo() + String.format("Additionally: " + message + "\n", message);
    }
}

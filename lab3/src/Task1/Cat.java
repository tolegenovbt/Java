package Task1;

public class Cat extends Animal {
   
	public Cat() {
	   super();
   }
	
	public Cat(String name, String breed, String color,int age) {
		super(name,breed,color,age);
	}
     
	public String getAllInfo() {
        return "Animal: Cat\n" + super.getAllInfo();
    }

	
	
    public String getAllInfo(String message) {
        return this.getAllInfo() + String.format("Additionally: " + message  + "\n", message);
    }
}

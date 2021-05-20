package Task1;

public class Mouse extends Animal {
	
	public Mouse() {
		super();
	}
	
	public Mouse(String name,String breed,String color,int age) {
		 super(name, breed, color, age);
	}
	
	public String getAllInfo() {
        return "Animal: Mouse\n" + super.getAllInfo();
    }

    public String getAllInfo(String message) {
        return this.getAllInfo() + String.format("Additionally: " + message + "\n", message);
    }
}

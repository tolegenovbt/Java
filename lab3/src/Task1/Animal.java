package Task1;

public class Animal {
    String name;
    String breed;
    String color;
    int age;
    
    public Animal() {
    	this.name =  "No name";
    	this.breed = "No breed";
    	this.color = "No color";
    	this.age =    0;
    }
    
	public Animal(String name){
	   this.name = name;
	}
	
	public Animal(String name,String breed){
		this(name);
		this.breed = breed;
	}
	
	public Animal(String name,String breed,String color) {
		this(name,breed);
		this.color = color;
	}
	
	public Animal(String name,String breed,String color,int age) {
		this(name,breed,color);
		this.age = age;
	}
	
	public String getAllInfo() {
		return ("Name: " + name + "\n" +
	           "Age:  " + age + "\n" + 
			   "Breed: "+ breed + "\n" +
	           "Color: "+ color + "\n");
	}
	
}

package Task3;

public class Person {
	   private String name;
	   private int age;
	   
	   public Person() {
		   this.name = "no name";
		   this.age = 0;
		   }
	   
	   public Person(String name,int age) {
		   this.name = name;
		   this.age = age;
	}
	   
	    public String getName() {
		return name;
	}
	   public void setName(String name) {
		this.name = name;
	}
	   
	   
	   @Override
	   public boolean equals(Object object) {
		   if(object instanceof Person) {
			   Person person = (Person)object;
			   return (this.age == person.age && this.name.equals(person.name));
		   }
		   return false;
	   }
	   
	   @Override
	   public String toString() {
		   return ("Name: " + name + "\n" + "Age: " + age + "\n");
	   }
	}

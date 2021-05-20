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
   
   @Override
   public boolean equals(Object object) {
	   if(object instanceof Person)
		  if(((Person)object).name.equals(this.name) && ((Person)object).age==this.age)
			  return true;
	   return false;
   }
   
   @Override
   public String toString() {
	   return ("Name: " + name + "\n" + "Age: " + age + "\n");
   }
   
}

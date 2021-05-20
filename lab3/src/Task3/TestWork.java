package Task3;

public class TestWork {
   public static void main(String[] args) {
	
	   Person bekzat = new Person("Bekzat" , 19);
	   Person noname = new Person();
	   
	   System.out.println(bekzat.toString());
	   System.out.println(noname.toString());
	   System.out.println("Bekzat equals to noname: " + bekzat.equals(noname));
	   System.out.println("---------------------------------------------------\n");
	   
	   Employee bekzatEmployee = new Employee("Bekzat", 18, 150000, 2, "18BD111653");
	   Employee nonameEmployee = new Employee();
	   
	   System.out.println(bekzatEmployee.toString());
	   System.out.println(nonameEmployee.toString());
	   System.out.println("Bekzat equals to noname: " + bekzatEmployee.equals(nonameEmployee));
	   System.out.println("---------------------------------------------------\n");
	   
	   Manager bekzatManager = new Manager("Bekzat", 19, 150000, 2, "18BD111653", 15000);
	   Manager nonameManager = new Manager();
	   
	   bekzatManager.add(new Employee("Rakhat", 18, 160000, 2, "18BD112233"));
       bekzatManager.add(new Employee("Nurzhan", 19, 155000, 1, "18BD445566"));
       bekzatManager.add(new Employee("Ilyas", 17, 200000, 3, "18BD778899"));
	   
	   System.out.println(bekzatManager.toString());
	   System.out.println(nonameManager.toString());
	   System.out.println("Bekzat equals to noname: " + bekzatManager.equals(nonameManager));
	   System.out.println("---------------------------------------------------\n");
	   
	   
}
}

package Task5;
import java.util.Scanner;
class Stat{
	
	static int mystatic = 100;
	int nonstatic = 15;
}


class Overload
{
	void test() {
		System.out.print("Test");
	}
	
	void print(int num) {
		System.out.println(num);
	}
	
	void sum(int x,int y)
	{
		System.out.println(x+y);
	}
	
	void sum(double x,double y)
	{
		System.out.println(x+y);
	}
	
	void sum(int x,int y,int z)
	{
		System.out.println(x+y+z);
	}
}

class InitializationBlock{
	  private String name;
	  private String poroda;
	  private int age;
	  
	  {
		  name = "Sharik";
		  poroda = "labrador";
		  age = 3;
	  }
	  
	  String getName() {
		  return name;
	  }
	  
	  String getPoroda() {
		  return poroda;
	  }
	  int getAge() {
		  return age;
	  }
	  
}

class Final{
	final double pi = Math.PI;
	
}


public class Task5p2 {
    public static void main(String[] args) {
    	
    	//Пример для статика
    	  Stat.mystatic += 20;
    	  System.out.println(Stat.mystatic); 
    	 
    	  Stat stat = new Stat();
    	  System.out.println("Статическая переменная 1 = " + Stat.mystatic);
    	  stat.nonstatic +=20;  
    	  System.out.println("Не статическая переменная 1 = " + stat.nonstatic);
    	  
    	  Stat stat2 = new Stat();
    	  System.out.println("Статическая переменная 2 = " + Stat.mystatic);  
    	  System.out.println("Не статическая переменная 2 = " + stat2.nonstatic);
    	  System.out.println("------------------------");
    	 
    	  //Пример для файнала 
    	  
    	  Final final1 = new Final();
    	  System.out.print(final1.pi);
    	  
    	// Пример для перегрузки 
	    Overload over = new Overload();
	    over.test();
	    over.print(5);
	    over.sum(4, 5);
	    over.sum(4.5, 1.2);
    	over.sum(20, 12, 2);
    	
    	//пример для блока инициализации
    	System.out.println("--------------------------");
    	InitializationBlock init = new InitializationBlock();
    	System.out.println("Name: " + init.getName());
    	System.out.println("Poroda: " + init.getPoroda());
    	System.out.println("Age: "+ init.getAge());  
    }
    
}

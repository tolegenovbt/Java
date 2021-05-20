package Task1;

public class TestAnimal {
  public static void main(String[] args) {
	  Dog dog = new Dog("Rex", "Shepherd", "black", 4);
      Dog nulldog = new Dog();
      Cat kotya   = new Cat("Kotya","Burmilla","gray",3);
      Mouse mouse = new Mouse("Steward Little", "Labratorian" ,"white",2);

      System.out.print(dog.getAllInfo("Please, be kind with him!")+'\n');
      System.out.print(nulldog.getAllInfo() + "\n");
      System.out.print(kotya.getAllInfo()+'\n');
      System.out.print(mouse.getAllInfo("little bastard")+'\n');
}
} 

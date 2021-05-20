package Task3;
import java.util.Vector;
public class Dragon{

	Vector<Person> vector = new Vector<Person>();
	
	public void kindap(Person person){
		vector.addElement(person);
	}
	
	public boolean willDragonEatorNot()
	{
		int count = 0;
		
		for(int i = 0; i < vector.size(); i++){
			
			if(vector.elementAt(i).gender == Gender.BOY){
			count++;
			}
			else if(vector.elementAt(i).gender == Gender.GIRL){
			count--;
			}
			if(count < 0) { return true; }
		}
		
		return (count != 0);
	}
	
	
	
	public static void main(String[] args) {
		
		Person person1 = new Person(Gender.BOY);
		Person person2 = new Person(Gender.GIRL);
		Dragon dragon = new Dragon();
		
//		dragon.kindap(person1);
//		dragon.kindap(person1);
//		dragon.kindap(person2);
//		dragon.kindap(person2); //false  BBGG
		
		dragon.kindap(person2);
		dragon.kindap(person1);
		dragon.kindap(person2);
		dragon.kindap(person1);  // true GBGB
		
		
		
		System.out.println(dragon.willDragonEatorNot());
		
	}

}

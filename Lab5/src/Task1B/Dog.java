package Task1B;

public class Dog extends Mammal implements Barkable, Moveable{
   
	String type;
	
	public Dog(String type) {
		this.type = type;
	}
	
	
	@Override
	public String getAction() {
		return Moveable.action;
	}

	@Override
	public String getSound() {
		return Barkable.sound;
	}

	@Override
	public String type() {
		return this.type;
	}

}
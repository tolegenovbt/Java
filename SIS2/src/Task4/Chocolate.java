package Task4;

public class Chocolate implements Comparable<Chocolate>{
	private double weight;
	public String name;
  
	public Chocolate(double weight, String name) {
		this.weight = weight;
		this.name = name;
	}
	
	public String toString() {
		return name + " " + weight;
	}

	@Override	
	public int compareTo(Chocolate o) {
		Chocolate other = (Chocolate) o;
		if(this.weight < other.weight) return -1;
		if(this.weight > other.weight) return 1;
		return 0;
	}
	
	

}

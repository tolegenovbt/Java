package Task1;

public class MainB {
	public static void main(String[] args) {
		Methods files = new Methods();
		files.read("scores.txt");
		files.writeStats("grades.txt");	
	}
}
package Task1;

public class TestPartB {
	public static void main(String[] args) {
	Files files = new Files();
	files.read("scores.txt");
	files.writeStats("grades.txt");	
}

}

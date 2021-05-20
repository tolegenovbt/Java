package Task1;

public class MainA {
    public static void main(String[] args) {
		Methods files = new Methods();
		files.read("scores.txt");
		files.writeGrades("grades.txt");
	}
}
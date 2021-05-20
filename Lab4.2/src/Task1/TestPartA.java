package Task1;

public class TestPartA {
    public static void main(String[] args) {
		Files files = new Files();
		files.read("scores.txt");
		files.writeGrades("grades.txt");
	}

}

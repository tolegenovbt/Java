package Task1;

public class Students {
	private String name;
	private String surname;
	private int score;
	public static int bestScore = 0;
	public static int worstScore = 101;
	public static int sumOfScores = 0;

	public Students(String name, String sname, int score) {
		this.name = name;
		this.surname = sname;
		this.score = score;
	}
	
	public String grade() {
		if(score >= bestScore - 10) {
			return "A";
		}
		if(score >= bestScore - 20) {
			return "B";
		} 
		if(score >= bestScore - 30) {
			return "C";
		}
		if(score >= bestScore - 40) {
			return "D";
		}
		return "F";
	}
	
	@Override
	public String toString() {
		return name + " " + surname;
 	}

}

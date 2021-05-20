package package1;

public class CourseFile {
	String title = "";
	String body = "";
	
	public CourseFile() {}
	public CourseFile(String title, String body) {
		this.title  = title;
		this.body = body;
	}
	
	public int compareTo(Object o) {
		CourseFile ch = (CourseFile) o;
		if (ch.body.length() < this.body.length()) {
			return 1;
		}else if (ch.body.length() > this.body.length()){
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return title + " \n" + body + "\n";
	}
}

package Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Files {
	
	Vector<Students> students; 

	public Files() {
		students = new Vector<Students>();
	}
	
	public void addStudent(String str) {
		String[] parts = str.split(" ");
		int score = Integer.parseInt(parts[2]);
		students.add(new Students(parts[0], parts[1], score));
			Students.bestScore = Math.max(Students.bestScore, score);
			Students.worstScore = Math.min(Students.worstScore, score);
			Students.sumOfScores += score;		
		}
	
	
	public void read(String path) {
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while((line = br.readLine()) != null) {
				addStudent(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void writeGrades(String path) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,false))){
		int i = 1;
		for(Students st: students) {
				bw.write(String.format("%d) %s - \"%s\"\n", i++, st.toString(), st.grade()));
			}
		}
		catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			
    }
	
	public void writeStats(String path) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
			bw.write(String.format("Average - %f\n",Students.sumOfScores/students.size() * 1.0));
			bw.write(String.format("Maximum - %d\n",Students.bestScore));
			bw.write(String.format("Minimum - %d\n",Students.worstScore));
			bw.close();
			}
			catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
	}
	

}

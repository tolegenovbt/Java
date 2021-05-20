package package1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mark implements Serializable{
	int firstAttestation;
	int secondAttestation;
	int finalExam;
	
	public Mark() {
		this.finalExam = 0;
		this.firstAttestation = 0;
		this.secondAttestation = 0;
	}
	public Mark(int first) {
		this.firstAttestation = first;
	}
	public Mark(int first, int second) {
		this(first);
		this.secondAttestation = second;
	}
	public Mark(int first, int second, int finalPoint) {
		this(first,second);
		this.finalExam = finalPoint;
	}
	
	public void setAttestation(int first) {
		this.firstAttestation = first;
	}
	public void setAttestation1(int fir) {
		this.firstAttestation = fir;
	}
	public void setAttestation2(int sec) {
		this.secondAttestation = sec;
	}
	public void setFinal(int finall) {
		this.finalExam = finall;
	}
	public void setAttestation(int first, int second) {
		setAttestation(first);
		this.secondAttestation = second;
	}
	public void setAttestation(int first, int second, int finalPoint) {
		setAttestation(first, second);
		this.finalExam = finalPoint;
		System.out.println(this.firstAttestation + " " + this.secondAttestation + " " + this.finalExam);
	}
	
	public int getTotalAttestation() {
		return this.secondAttestation + this.firstAttestation;
	}
	
	public int getFinal() {
		return this.finalExam;
	}
	
	public int getTotal() {
		return this.finalExam + this.firstAttestation + this.secondAttestation;
	}
	
	public String toString() {
		return "First Attestation : "+this.firstAttestation + " Second : " + this.secondAttestation +
				" Final Exam " + this.finalExam + "\n" ;
	}
	
	
}

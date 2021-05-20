
import java.io.Serializable;
import java.util.*;

public class Mark implements Serializable, Cloneable, Comparable {

    private double score;
    private Grade grade;

    public Mark() {
        this.score = 0;
        this.grade = null;
    }

    public Mark(double score) {
        this.score = score;
        calculateGrade();
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void calculateGrade() {
        if(this.score >= 94.5){
            this.grade = Grade.A;
        }
        else if(this.score >= 89.5 && this.score < 94.5){
            this.grade = Grade.A_MINUS;
        }
        else if(this.score >= 84.5 && this.score < 89.5){
            this.grade = Grade.B_PLUS;
        }
        else if(this.score >= 79.5 && this.score < 84.5){
            this.grade = Grade.B;
        }
        else if(this.score >= 74.5 && this.score < 79.5){
            this.grade = Grade.B_MINUS;
        }
        else if(this.score >= 69.5 && this.score < 74.5){
            this.grade = Grade.C_PLUS;
        }
        else if(this.score >= 64.5 && this.score < 69.5){
            this.grade = Grade.C;
        }
        else if(this.score >= 59.5 && this.score < 64.5){
            this.grade = Grade.C_MINUS;
        }
        else if(this.score >= 54.5 && this.score < 59.5){
            this.grade = Grade.D_PLUS;
        }
        else if(this.score >= 49.5 && this.score < 54.5){
            this.grade = Grade.D;
        }
        else if(this.score < 49.5 ){
            this.grade = Grade.F;
        }
    }


    public int compareTo(Object other) {
        Mark mark = (Mark)other;
        if(this.score > mark.score) return 1;
        else if(this.score < mark.score) return -1;
        else return 0;
    }

    public Object clone() throws CloneNotSupportedException{
        Mark mark = new Mark();
        mark.score = this.score;
        mark.grade = this.grade;
        return mark;
    }

    public int hashCode() {
        return Objects.hash(this.score, this.grade);
    }

    public boolean equals(Object other) {
        if(other == null) return false;
        if(this == other) return true;
        if(!(other instanceof Mark)) return false;
        Mark mark = (Mark)other;
        return this.score == mark.score;
    }

    public String toString() {
        return "\nScore: " + this.score + "\nGrade: " + this.grade;
    }
}
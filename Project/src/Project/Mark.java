package Project;

import java.io.Serializable;
import java.util.*;

public class Mark implements Serializable, Cloneable, Comparable {

    private double score;
    private LetterGrade letterGrade;

    public Mark() {
        this.score = 0;
        this.letterGrade = null;
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

    public LetterGrade getGrade() {
        return this.letterGrade;
    }

    public void setGrade(LetterGrade letterGrade) {
        this.letterGrade = letterGrade;
    }

    public void calculateGrade() {
        if(this.score >= 94.5){
            this.letterGrade = LetterGrade.A;
        }
        else if(this.score >= 89.5 && this.score < 94.5){
            this.letterGrade = LetterGrade.A_MINUS;
        }
        else if(this.score >= 84.5 && this.score < 89.5){
            this.letterGrade = LetterGrade.B_PLUS;
        }
        else if(this.score >= 79.5 && this.score < 84.5){
            this.letterGrade = LetterGrade.B;
        }
        else if(this.score >= 74.5 && this.score < 79.5){
            this.letterGrade = LetterGrade.B_MINUS;
        }
        else if(this.score >= 69.5 && this.score < 74.5){
            this.letterGrade = LetterGrade.C_PLUS;
        }
        else if(this.score >= 64.5 && this.score < 69.5){
            this.letterGrade = LetterGrade.C;
        }
        else if(this.score >= 59.5 && this.score < 64.5){
            this.letterGrade = LetterGrade.C_MINUS;
        }
        else if(this.score >= 54.5 && this.score < 59.5){
            this.letterGrade = LetterGrade.D_PLUS;
        }
        else if(this.score >= 49.5 && this.score < 54.5){
            this.letterGrade = LetterGrade.D;
        }
        else if(this.score < 49.5 ){
            this.letterGrade = LetterGrade.F;
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
        mark.letterGrade = this.letterGrade;
        return mark;
    }

    public int hashCode() {
        return Objects.hash(this.score, this.letterGrade);
    }

    public boolean equals(Object other) {
        if(other == null) return false;
        if(this == other) return true;
        if(!(other instanceof Mark)) return false;
        Mark mark = (Mark)other;
        return this.score == mark.score;
    }

    public String toString() {
        return "\nScore: " + this.score + "\nGrade: " + this.letterGrade;
    }
}
import java.util.*;
import java.io.*;
import java.lang.*;


public class Text implements Comparable, Cloneable, Serializable{
    private String textTitle;
    private String textText;
    private Date date;

    public Text() {
        this.textText = "unknown";
        this.textTitle = "unknown";
        this.date = null;
    }

    public Text(String textTitle, String textText) {
        this.textTitle = textTitle;
        this.textText = textText;
        this.date = new Date();
    }

    public Text(String textTitle) {
        this.textTitle = textTitle;
        this.date = new Date();
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }
    public String getTextTitle() {
        return this.textTitle;
    }

    public void setTextText(String textText) {
        this.textText = textText;
    }

    public String getTextText() {
        return this.textText;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public boolean equals(Object other) {
        if(other == null) return false;
        if(this == other) return true;
        if(!(other instanceof Text)) return false;
        Text text = (Text)other;
        if(this.textTitle.equals(text.textTitle) && this.textText.equals(text.textText) && this.date.equals(text.date)) return true;
        else return false;
    }

    public int compareTo(Object other) {
        Text text = (Text)other;
        if(this.date.compareTo(text.date) == 0) {
            if(this.textTitle.compareTo(text.textTitle) == 0) {
                return this.textText.compareTo(text.textText);
            }
            else return this.textTitle.compareTo(text.textTitle);
        }
        else return this.date.compareTo(text.date);
    }

    public Object clone() {
        Text text = new Text();
        text.textTitle = this.textTitle;
        text.textText = this.textText;
        text.date = this.date;
        return text;
    }

    public int hashCode() {
        return Objects.hash(this.textTitle, this.textText, this.date);
    }

    public String toString() {
        return "\nTitle: " + this.textTitle + "\nText: " + this.textText + "\nDate: " + this.date;
    }
}
package Project;
import java.io.Serializable;
import java.util.*;

public class Speciality implements Serializable, Cloneable, Comparable {

    private String specialityTitle;
    private String code;

    public Speciality() {
        this.specialityTitle = "unknown";
        this.code = "unknown";
    }

    public Speciality(String specialityTitle, String code) {
        this.specialityTitle = specialityTitle;
        this.code = code;
    }

    public String getSpecialityTitle() {
        return this.specialityTitle;
    }

    public void setSpecialityTitle(String specialityTitle) {
        this.specialityTitle = specialityTitle;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int compareTo(Object other) {
        Speciality sp = (Speciality)other;
        if(this.specialityTitle.compareTo(sp.specialityTitle) == 0) {
            return this.code.compareTo(sp.code);
        }
        else return this.specialityTitle.compareTo(sp.specialityTitle);
    }

    public Object clone() {
        Speciality sp = new Speciality();
        sp.specialityTitle = this.specialityTitle;
        sp.code = this.code;
        return sp;
    }

    public int hashCode() {
        return Objects.hash(this.specialityTitle, this.code);
    }

    public boolean equals(Object other) {
        if(other == null) return false;
        if(this == other) return true;
        if(!(other instanceof Speciality)) return false;
        Speciality sp = (Speciality)other;
        return this.specialityTitle.equals(sp.specialityTitle) && this.code.equals(sp.code);
    }

    public String toString() {
        return "\nSpeciality title: " + this.specialityTitle + "\nSpeciality code: " + this.code;
    }
}
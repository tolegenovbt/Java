import java.io.Serializable;
import java.util.*;

public class Speciality implements Serializable, Cloneable, Comparable {

    private String specialityTitle;
    private String cipher;

    public Speciality() {
        this.specialityTitle = "unknown";
        this.cipher = "unknown";
    }

    public Speciality(String specialityTitle, String cipher) {
        this.specialityTitle = specialityTitle;
        this.cipher = cipher;
    }

    public String getSpecialityTitle() {
        return this.specialityTitle;
    }

    public void setSpecialityTitle(String specialityTitle) {
        this.specialityTitle = specialityTitle;
    }

    public String getCipher() {
        return this.cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public int compareTo(Object other) {
        Speciality sp = (Speciality)other;
        if(this.specialityTitle.compareTo(sp.specialityTitle) == 0) {
            return this.cipher.compareTo(sp.cipher);
        }
        else return this.specialityTitle.compareTo(sp.specialityTitle);
    }

    public Object clone() {
        Speciality sp = new Speciality();
        sp.specialityTitle = this.specialityTitle;
        sp.cipher = this.cipher;
        return sp;
    }

    public int hashCode() {
        return Objects.hash(this.specialityTitle, this.cipher);
    }

    public boolean equals(Object other) {
        if(other == null) return false;
        if(this == other) return true;
        if(!(other instanceof Speciality)) return false;
        Speciality sp = (Speciality)other;
        return this.specialityTitle.equals(sp.specialityTitle) && this.cipher.equals(sp.cipher);
    }

    public String toString() {
        return "\nSpeciality title: " + this.specialityTitle + "\nSpeciality cipher: " + this.cipher;
    }
}
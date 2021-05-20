
import java.io.Serializable;
import java.lang.*;
import java.util.*;
import java.util.Objects;



public abstract class User implements Serializable, Cloneable, Comparable {

    private String id;
    private String password;
    private String name;
    private String surname;



    public User() {
        this.id = null;
        this.password = null;
        this.name = null;
        this.surname = null;
    }

    public User(String name, String surname, String id, String password) {
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }

    @Override
    public int compareTo(Object other) {
        User user = (User)other;
        if(this.surname.compareTo(user.surname) == 0) {
            return this.name.compareTo(user.name);
        }
        else return this.surname.compareTo(user.surname);
    }

    public Object clone() throws CloneNotSupportedException {
        User cloned = (User) super.clone();
        return cloned;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }
}
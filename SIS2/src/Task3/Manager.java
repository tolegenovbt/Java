package Task3;

import java.util.Date;
import java.util.Vector;

public class Manager extends Employee implements Cloneable{

    private Vector <Employee> team = new Vector <Employee>();
    private double bonus;

    public Manager() {
        super();
        bonus = 0;
    }

    public Manager(String name, int age, double salary, Date hireDate, String insuranceNumber, double bonus) {
        super(name, age, salary, hireDate, insuranceNumber);
        this.bonus = bonus;
    }

    public void addEmployee(Employee e) {
        team.add(e);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj instanceof Manager) {
            Manager m = (Manager) obj;
            return (super.equals(m) && this.team.equals(m.team) && this.bonus == m.bonus);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 17*31*(int)bonus + team.hashCode() + super.hashCode();
    }

    @Override
    public String toString() {
        String tm = "----------\n";
        for(Employee e: this.team){
            tm += e.toString() + "\n";
        }
        return super.toString() + String.format("Bonus: %f\nTeam:\n%s\n", this.bonus, tm);
    }

    @Override
    public int compareTo(Object obj) {

        Manager other = (Manager) obj;
        int compare = super.compareTo(other);
        if(compare == 0) {
            if (bonus < other.bonus) return -1;
            if (bonus > other.bonus) return 1;
        }
        return compare;
    }


    @Override
    public Manager clone() throws CloneNotSupportedException{
        Manager m = (Manager) super.clone();
        m.team = team;
        return m;
        /*return (Manager) super.clone();*/
    }

}
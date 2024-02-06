package lab3ex4;

import java.util.Date;
import java.util.Vector;

public class Manager extends Employee {
    private double bonus;
    private Vector<Employee> team;
    public Manager (String name, double salary, Date hireDate, String insuranceNumber, double bonus, Vector<Employee> team) {
        super(name, salary, hireDate, insuranceNumber);
        this.bonus = bonus;
        this.team = team;
    }
    public double getBonus() {
        return bonus;
    }
    public Vector<Employee> getTeam() {
        return team;
    }
    @Override
    public String toString() {
        return super.toString() + " Team:" + team + " Bonus:" + bonus;
    }
    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        Manager m = (Manager)o;
        return m.bonus == bonus && team.equals(m.team);
    }
    public Manager clone() throws CloneNotSupportedException {
        Manager clone1 = (Manager) super.clone();
        clone1.team = (Vector<Employee>) team.clone();
        return clone1;
    }
    @Override
    public int compareTo(Object o) {
        Manager m = (Manager) o;
        if (super.compareTo(o) != 0)
            return super.compareTo(o);
        else
            return Double.compare(this.getBonus(), m.getBonus());
    }
}

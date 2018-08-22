package javacore.equals;

/**
 * Created by mac on 17/7/20.
 */
public class Manager extends Employee {

    private double bonus;

    Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus() {
        this.bonus = bonus;
    }

    public int hashCode() {
        return super.hashCode() + (10 * Double.hashCode(bonus));
    }

    public String toString() {
        return super.toString() + "; bonus="+bonus;
    }

}

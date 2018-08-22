package javacore.equals;

import java.util.Objects;


public class Employee {

    private String name;
    private double salary;

    public double getSalary() {
        return this.salary;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return getClass().getName() + " name=" + this.name + " salary=" + this.salary;
    }

    public Employee(String name, double salary) {

        this.name=name;
        this.salary=salary;
    }

    public boolean equals(Object otherOj) {

        if (otherOj == this) {
            return true;
        }
        if (otherOj == null) {
            return false;
        }
        if (getClass() != otherOj.getClass()) {
            return false;
        }

        Employee temp= (Employee)otherOj;

        return Objects.equals(name, temp.name) && salary == temp.salary;

    }

    public int hashCode() {
        return Objects.hash(name, salary);
    }

}




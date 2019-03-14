package javacore.equals;

/**
 * Created by mac on 17/7/20.
 */
public class EmployeeTest {
    public static void main(String[] args) {

        Employee employee1 = new Employee("employee1", 10000);
        Employee employee2 = employee1;
        Employee employee3 = new Employee("employee3", 8000);
        Employee employee4 = new Employee("employee1", 10000);
        System.out.println("employee1 == employee2 is " + (employee1 == employee2));
        System.out.println("employee1 == employee3 is " + (employee1 == employee3));
        System.out.println("employee1 == employee4 is " + (employee1 == employee4));
        System.out.println("employee1.equals(employee4) is " + (employee1.equals(employee4)));

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
        System.out.println(employee3.hashCode());
        System.out.println(employee4.hashCode());

    }

}

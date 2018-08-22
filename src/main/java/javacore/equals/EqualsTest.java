package javacore.equals;

/**
 * Created by mac on 17/7/20.
 */
public class EqualsTest {
    public static void main(String[] args) {

        Employee sam1 = new Employee("sam1", 10000);
        Employee sam2 = sam1;
        Employee sam3 = new Employee("sam3", 8000);
        Employee sam4 = new Employee("sam1", 10000);
        System.out.println(sam1 == sam2);
        System.out.println(sam1 == sam3);
        System.out.println(sam1 == sam4);

        System.out.println(sam1.equals(sam4));
        System.out.println("test:" + sam1);

        Manager m = new Manager("zhang", 50000);
        System.out.println("" + m);

        System.out.println(sam1.hashCode());
        System.out.println(sam2.hashCode());
        System.out.println(sam3.hashCode());
        System.out.println(sam4.hashCode());

    }

}

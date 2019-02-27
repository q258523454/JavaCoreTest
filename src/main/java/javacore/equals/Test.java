package javacore.equals;

/**
 * Created by mac on 17/7/20.
 */
public class Test {
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

        // --------------------- String (本身重写了equals) ---------------------
        String str1 = "Hello"; // 堆-方法区-常量区
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = str2;

        System.out.println("str1 == str2 is " + (str1 == str2)); // true
        System.out.println("str1 == str3 is " + (str1 == str3)); // false
        System.out.println("str1 == str4 is " + (str1 == str4)); // true

        System.out.println("str1.equals(str2) is " + (str1.equals(str2))); // true
        System.out.println("str1.equals(str3) is " + (str1.equals(str3))); // true
        System.out.println("str1.equals(str4) is " + (str1.equals(str4))); // true

        // --------------------- String.intern() ---------------------
        str3 = str3.intern();
        System.out.println("str3 after intern().");
        System.out.println("str1 == str3 is " + (str1 == str3)); // false


    }

}

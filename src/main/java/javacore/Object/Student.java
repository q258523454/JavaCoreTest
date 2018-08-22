package javacore.Object;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-01
 */

public class Student extends People {

    String a;

    Student() {
        this.a = "10";
        System.out.println("Student Class");
    }
    public void say() {
        System.out.println("Student say hello!");
    }


    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public static void main(String[] args) {

        Student ss = new Student();



        People people = new Student();
//
//        System.out.println(people.a);
//        people.say();

        Student student = (Student) new People();
        System.out.println(student.a);
        student.say();

    }
}

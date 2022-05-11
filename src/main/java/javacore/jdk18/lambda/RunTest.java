package javacore.jdk18.lambda;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Date: 2019-07-22
 * @Version 1.0
 */
public class RunTest {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setId(1);
        stu1.setName("a");
        stu1.setAge(11);

        Student stu2 = new Student();
        stu2.setId(2);
        stu2.setName("b");
        stu2.setAge(22);

        Student stu3 = new Student();
        stu3.setId(3);
        stu3.setName("c");
        stu3.setAge(33);

        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(stu1);
        studentList1.add(stu3);
        studentList1.add(stu2);

        // 1.普通lambda 表达式: 年龄升序
        System.out.println("\nlambda排序前:\t" + JSON.toJSONString(studentList1));
        Collections.sort(studentList1, ((o1, o2) -> String.valueOf(o1.getAge()).compareTo(String.valueOf(o2.getAge()))));
        System.out.println("lambda排序后:\t" + JSON.toJSONString(studentList1));

        // 2.lambda 引用
        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(stu1);
        studentList2.add(stu3);
        studentList2.add(stu2);
        System.out.println("\nlambda排序前:\t" + JSON.toJSONString(studentList2));
        Collections.sort(studentList2); // 默认执行实现 Comparable 接口的方法
        System.out.println("lambda排序后:\t" + JSON.toJSONString(studentList2));

        System.out.println("lambda引用方法1(类方法)\nlambda排序前:\t" + JSON.toJSONString(studentList2));
        // studentList2.sort(((o1, o2) -> Student.compareByAge(o1, o2))); // 普通调用方式
        studentList2.sort((Student::compareByAge)); // 引用调用方式:注意必须要与
        System.out.println("lambda排序后:\t" + JSON.toJSONString(studentList2));

        System.out.println("lambda引用方法2(实例方法)\nlambda排序前:\t" + JSON.toJSONString(studentList2));
        studentList2.sort((studentList2.get(0)::compareByName)); // 引用调用方式:注意必须要与
        System.out.println("lambda排序后:\t" + JSON.toJSONString(studentList2));


    }
}

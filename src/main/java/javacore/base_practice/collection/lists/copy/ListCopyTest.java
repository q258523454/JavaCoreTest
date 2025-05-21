package javacore.base_practice.collection.lists.copy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCopyTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student(1, "张三");
        Student s2 = new Student(2, "李四");

        List<Student> org = new ArrayList<>();
        org.add(s1);
        org.add(s2);

        // 方法1(浅拷贝): new ArrayList拷贝,String类型本身是final修饰,每次都是新对象,不存在深浅拷贝的说法.
        List<Student> copy1 = new ArrayList<>(org);

        // 方法2(浅拷贝): Collections.addAll 效率最高
        List<Student> copy2 = new ArrayList<>();
        Student[] orgArr = {s1, s2};
        Collections.addAll(copy2, orgArr);

        // 方法3(深拷贝): 一个一个的新增赋值.
        List<Student> deepCopy = new ArrayList<>();
        for (Student entity : org) {
            // 实际过程可以用mapStruct来快速实现.
            Student clone = (Student) entity.clone();
            deepCopy.add(clone);
        }

        s1.setName("修改名字");
        System.out.println(JSON.toJSONString(org));
        System.out.println(JSON.toJSONString(copy1));
        System.out.println(JSON.toJSONString(copy2));
        System.out.println(JSON.toJSONString(deepCopy));
    }
}

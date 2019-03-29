package javacore.copy_deep_shallow.test1_shallowcopy;

import com.alibaba.fastjson.JSONObject;
import javacore.copy_deep_shallow.test1_shallowcopy.entity.Bag;
import javacore.copy_deep_shallow.test1_shallowcopy.entity.Student;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Bag bag = new Bag();
        bag.setName("耐克1号");
        bag.setColor("红色");

        Student student1 = new Student();
        student1.setName("张小凡");
        student1.setAge(16);
        student1.setBag(bag);

        // Object的clone方法(必须实现Cloneable), 默认是浅拷贝, 注意2点:
        // 1.student2是new地址
        // 2.student2中的非基本数据类型和student1是指向的同一个
        System.out.println("----------------- 浅拷贝测试1 ------------------");
        Student student2 = (Student) student1.clone();
        System.out.println("stu1 == stu2: " + (student1 == student2));                             // false, 不是同一个地址
        System.out.println("stu1.bag == stu2.bag: " + (student1.getBag() == student2.getBag()));   // true 浅拷贝, 拷贝了引用
        System.out.println(JSONObject.toJSONString(student1));
        System.out.println(JSONObject.toJSONString(student2));

        System.out.println("----------------- 浅拷贝测试2 ------------------");
        student1.setName("王五");                                 // 基本数据类型, 不存在引用拷贝
        bag.setName("耐克1号(修补)");                       // student1和student2都输出"耐克1号(修补)", 同一个对象引用
        System.out.println(JSONObject.toJSONString(student1));
        System.out.println(JSONObject.toJSONString(student2));
        System.out.println("bag是否指向同一个:" + (student1.getBag() == student2.getBag())); // true 指向同一个bag

        System.out.println("----------------- 浅拷贝测试3 ------------------");
        Bag bag2 = new Bag();
        bag2.setName("阿迪达斯(新书包)");
        bag2.setColor("蓝色");
        student1.setBag(bag2);      // 当stundet1的bag引用更改了, student1的bag变了, student2还是之前的bag
        System.out.println(JSONObject.toJSONString(student1));
        System.out.println(JSONObject.toJSONString(student2));
        System.out.println("bag 是否指向同一个:" + (student1.getBag() == student2.getBag())); // false student1的bag是新的对象

    }
}

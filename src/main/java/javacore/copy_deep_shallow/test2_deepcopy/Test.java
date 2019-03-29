package javacore.copy_deep_shallow.test2_deepcopy;

import com.alibaba.fastjson.JSONObject;
import javacore.copy_deep_shallow.test2_deepcopy.entity.Bag;
import javacore.copy_deep_shallow.test2_deepcopy.entity.Student;

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

        // student2中的非基本数据类型Bag(书包)已经实现了深拷贝
        System.out.println("----------------- 深拷贝测试1 ------------------");
        Student student2 = (Student) student1.clone();
        System.out.println("stu1 == stu2: " + (student1 == student2));                             // false, 不是同一个地址
        System.out.println("stu1.bag == stu2.bag: " + (student1.getBag() == student2.getBag()));   //  false 深拷贝, 不同引用
        System.out.println(JSONObject.toJSONString(student1));
        System.out.println(JSONObject.toJSONString(student2));

        System.out.println("----------------- 深拷贝测试2 ------------------");
        student1.setName("王五");                                 // 基本数据类型, 不存在引用拷贝
        bag.setName("耐克1号(修补)");                            // 深拷贝, student1和student2中的bag没有关系了
        System.out.println(JSONObject.toJSONString(student1));
        System.out.println(JSONObject.toJSONString(student2));
        System.out.println("bag是否指向同一个:" + (student1.getBag() == student2.getBag())); // flase 深拷贝
    }

}

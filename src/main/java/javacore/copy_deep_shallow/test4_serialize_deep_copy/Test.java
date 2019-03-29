package javacore.copy_deep_shallow.test4_serialize_deep_copy;

import com.alibaba.fastjson.JSONObject;
import javacore.copy_deep_shallow.test4_serialize_deep_copy.entity.Bag;
import javacore.copy_deep_shallow.test4_serialize_deep_copy.entity.Pen;
import javacore.copy_deep_shallow.test4_serialize_deep_copy.entity.Student;
import javacore.copy_deep_shallow.test4_serialize_deep_copy.util.CloneUtils;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Pen pen = new Pen();
        pen.setType("圆珠笔");
        pen.setColor("黑色");

        Bag bag = new Bag();
        bag.setName("耐克1号");
        bag.setColor("红色");
        bag.setPen(pen);

        Student student1 = new Student();
        student1.setName("张小凡");
        student1.setAge(16);
        student1.setBag(bag);

        // 序列化——深拷贝
        // 相当于重写字节流, 再创建新对象,  跟原对象没有任何引用共享, 无需嵌套重现 Cloneable.clone(), 只需要实现 Serializable (每个子类)
        System.out.println("----------------- 序列化-深拷贝测试1 ------------------");
        // Student student2 = (Student) student1.deepClone(); // 方法一
        Student student2 = CloneUtils.deepClone(student1); // 方法二: 使用工具

        System.out.println("stu1 == stu2: " + (student1 == student2));
        System.out.println("stu1.bag == stu2.bag: " + (student1.getBag() == student2.getBag()));
        System.out.println("stu1.bag.pen == stu2.bag.pen: " + (student1.getBag().getPen() == student2.getBag().getPen()));

        System.out.println(JSONObject.toJSONString(student1));
        System.out.println(JSONObject.toJSONString(student2));

        System.out.println("----------------- 序列化-深拷贝测试2 ------------------");
        pen.setType("钢笔");
        pen.setColor("红色");
        System.out.println(JSONObject.toJSONString(student1));
        System.out.println(JSONObject.toJSONString(student2));

    }

}

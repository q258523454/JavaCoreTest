package javacore.base.copy_deep_shallow.test3_deepcopy_deepcopy;

import com.alibaba.fastjson.JSONObject;
import javacore.base.copy_deep_shallow.test3_deepcopy_deepcopy.entity.Bag;
import javacore.base.copy_deep_shallow.test3_deepcopy_deepcopy.entity.Pen;
import javacore.base.copy_deep_shallow.test3_deepcopy_deepcopy.entity.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunTest {
    public static void main(String[] args) throws CloneNotSupportedException {

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

        // student2中的复合数据类型Bag(书包)已经实现了深拷贝,但是Bag中的Pen(笔)没有重写Clonable.clone(),无法深拷贝Pen
        log.info("----------------- 深拷贝测试1 ------------------");
        Student student2 = (Student) student1.clone();
        log.info("student1 == student2: " + (student1 == student2));                             // false, 不是同一个地址
        log.info("student1.bag == student2.bag: " + (student1.getBag() == student2.getBag()));   //  false 深拷贝, 不同引用

        // 特别注意: 下面为true, 虽然是深拷贝, 但深拷贝对象的复合数据类型仍可能含有复合数据类型,导致完全深拷贝失败, 由此我们可以发现:
        // clone() 深拷贝不适合嵌套对象, 特别是嵌套类型很多的情况, 因为对这些类实现深拷贝, 每一个类都需要重写Cloneable.clone()方法
        // 因此我们可以选择另外一种方式实现深拷贝————序列化
        log.info("注意: student1.bag.pen == student2.bag.pen:" + (student1.getBag().getPen() == student2.getBag().getPen()));

        log.info(JSONObject.toJSONString(student1));
        log.info(JSONObject.toJSONString(student2));

        log.info("----------------- 深拷贝测试2 ------------------");
        pen.setType("钢笔");
        pen.setColor("红色");
        log.info(JSONObject.toJSONString(student1));
        log.info(JSONObject.toJSONString(student2));
        log.info("pen是否指向同一个:" + (student1.getBag().getPen() == student2.getBag().getPen()));
    }
}


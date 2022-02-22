package javacore.base.copy_deep_shallow.test1_shallowcopy;

import com.alibaba.fastjson.JSONObject;
import javacore.base.copy_deep_shallow.test1_shallowcopy.entity.Bag;
import javacore.base.copy_deep_shallow.test1_shallowcopy.entity.Student;
import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
@Slf4j
public class RunTest {

    /**
     * 8种基本类型和String
     * Java中8种基本类型都在栈内存，clone都是深拷贝，不存在浅拷贝(引用拷贝)
     * 第1类：整型--》byte,short,int,long
     * 第2类：浮点--》float,double
     * 第3类：逻辑--》boolean
     * 第4类：字符--》char
     *
     * String 存在于堆内存、常量池；这种比较特殊, 本身没有实现 Cloneable, 传递是引用地址；
     * 由本身的final性, 每次赋值都是一个新的引用地址，原对象的引用和副本的引用互不影响。
     * 因此String就和基本数据类型一样,表现出了"深拷贝"特性.
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        // Bag 未实现 Cloneable
        Bag bag = new Bag();
        bag.setName("耐克1号");
        bag.setColor("红色");

        // student 实现了 Cloneable
        Student student1 = new Student();
        String name = "张小凡";
        student1.setName(name);
        student1.setAge(18);
        student1.setBag(bag);

        // Object的clone方法(必须实现 Cloneable), 默认是浅拷贝(引用拷贝), 注意2点:
        // 1.student2是new地址
        // 2.student2中的复合类型(Bag)和student1中的(Bag)是同一个对象（引用拷贝）
        log.info("----------------- 浅拷贝测试1 ------------------");
        Student student2 = (Student) student1.clone();
        // false, 不是同一个地址
        log.info("student1 == student2: " + (student1 == student2));
        // true 浅拷贝, 引用拷贝
        log.info("student1.bag == student1.bag: " + (student1.getBag() == student2.getBag()));
        log.info(JSONObject.toJSONString(student1));
        log.info(JSONObject.toJSONString(student2));

        log.info("----------------- 浅拷贝测试2 ------------------");
        // String类型, 这里并不会改变student1和student2中的的name;
        // String 存在于堆内存、常量池；这种比较特殊, 本身没有实现 Cloneable, 传递是引用地址；
        // 由本身的final性, 每次赋值都是一个新的引用地址，原对象的引用和副本的引用互不影响。
        // 因此String就和基本数据类型一样,表现出了"深拷贝"特性.
        name = "张大凡";
        // student1和student2中的bag.name同时修改, 因为是浅拷贝是同一个引用地址
        bag.setName("耐克1号(修补)");
        log.info(JSONObject.toJSONString(student1));
        log.info(JSONObject.toJSONString(student2));
        // true 指向同一个bag地址
        log.info("bag引用地址是否相同:" + (student1.getBag() == student2.getBag()));

        log.info("----------------- 浅拷贝测试3 ------------------");
        Bag bag2 = new Bag();
        bag2.setName("阿迪达斯(新书包)");
        bag2.setColor("蓝色");
        // 修改stundet1的bag引用不影响student2的bag
        student1.setBag(bag2);
        log.info(JSONObject.toJSONString(student1));
        log.info(JSONObject.toJSONString(student2));
        // false student1的bag是新的对象
        log.info("bag 是否指向同一个:" + (student1.getBag() == student2.getBag()));
    }
}

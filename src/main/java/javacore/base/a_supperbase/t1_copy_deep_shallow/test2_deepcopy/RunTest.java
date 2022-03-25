package javacore.base.a_supperbase.t1_copy_deep_shallow.test2_deepcopy;

import com.alibaba.fastjson.JSONObject;
import javacore.base.a_supperbase.t1_copy_deep_shallow.test2_deepcopy.entity.Bag;
import javacore.base.a_supperbase.t1_copy_deep_shallow.test2_deepcopy.entity.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Bag bag = new Bag();
        bag.setName("耐克1号");
        bag.setColor("红色");

        Student student1 = new Student();
        student1.setName("张小凡");
        student1.setAge(16);
        student1.setBag(bag);

        // student2中的非基本数据类型Bag(书包)已经实现了深拷贝
        log.info("----------------- 深拷贝测试1 ------------------");
        Student student2 = (Student) student1.clone();
        // false, 不是同一个地址
        log.info("student1 == student2: " + (student1 == student2));
        //  false 深拷贝, 不同引用
        log.info("student1.bag == student2.bag: " + (student1.getBag() == student2.getBag()));
        log.info(JSONObject.toJSONString(student1));
        log.info(JSONObject.toJSONString(student2));

        log.info("----------------- 深拷贝测试2 ------------------");
        // String类型, 每次赋值都是一个新对象, 表现的就是深拷贝, 新旧对象互不影响
        student1.setName("王五");
        // 深拷贝, student1和student2中的bag是两个不同的引用, 相互独立
        bag.setName("耐克1号(修补)");
        log.info(JSONObject.toJSONString(student1));
        log.info(JSONObject.toJSONString(student2));
        // flase 深拷贝
        log.info("bag是否指向同一个:" + (student1.getBag() == student2.getBag()));
    }
}

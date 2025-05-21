package javacore.base.a_supperbase.t1_copy_deep_shallow.test1_shallowcopy;

import com.alibaba.fastjson.JSON;

import javacore.base.a_supperbase.t1_copy_deep_shallow.test1_shallowcopy.entity2.Bag;
import javacore.base.a_supperbase.t1_copy_deep_shallow.test1_shallowcopy.entity2.MyObject;
import javacore.base.a_supperbase.t1_copy_deep_shallow.test1_shallowcopy.entity2.Student;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RunTest2 {
    /**
     * BeanUtils.copyProperties 浅拷贝,会复制所有的对应的属性名.
     */
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder()
                .id(1)
                .name("zhangsan")
                .bag(Bag.builder().name("bag1").color("yellow").build())
                .build());
        studentList.add(Student.builder()
                .id(2)
                .name("lisi")
                .bag(Bag.builder().name("bag2").color("red").build())
                .build());
        myObject.setId(1);
        myObject.setStudentList(studentList);

        System.out.println(JSON.toJSONString(myObject));
        MyObject myObject2 = new MyObject();
        // 复制所有的值，只要属性名一样（注意类型要对应，否则可能会出现丢失）
        BeanUtils.copyProperties(myObject, myObject2);
        System.out.println(JSON.toJSONString(myObject2));

        System.out.println("-------------------- 浅拷贝 -------------------- 浅拷贝");
        myObject2.getStudentList().get(0).setName("change(浅拷贝)");
        System.out.println(JSON.toJSONString(myObject));
        System.out.println(JSON.toJSONString(myObject2));
    }
}

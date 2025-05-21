package javacore.base.a_supperbase.t0_value_transfer;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnlyValueTransfer_Object {

    @Data
    @AllArgsConstructor
    static class Student {
        int id;
        String name;
    }

    /**
     * Java中只有值传递
     * 非基本数据量,参数值:原'指向'的副本
     */
    public static void main(String[] args) {
        Student student = new Student(1, "1");
        log.info("before,{}", JSON.toJSONString(student));
        newObject(student);
        log.info("after,{}", JSON.toJSONString(student));
        log.info("---------------");
        student = new Student(1, "1");
        log.info("before,{}", JSON.toJSONString(student));
        changeObjectValue(student);
        log.info("after,{}", JSON.toJSONString(student));


    }

    /**
     * 值传递——复制的指向student的'指向'
     * 方法内部 student=new Student(...)是'指向'副本的修改,不影响原数据
     * student.set()是'指向'副本对原数据的操作,所以会改变原数据
     */
    public static void newObject(Student student) {
        student = new Student(2, "newObject");
        log.info("newObject(),{}", JSON.toJSONString(student));
    }

    /**
     * 值传递——复制的指向student的'指向'
     * 直接修改会改变原数据
     */
    public static void changeObjectValue(Student student) {
        student.setId(2);
        student.setName("xiugai");
        log.info("changeObjectValue(),{}", JSON.toJSONString(student));
    }
}

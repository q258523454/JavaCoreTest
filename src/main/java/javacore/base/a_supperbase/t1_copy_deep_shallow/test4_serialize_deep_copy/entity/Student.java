package javacore.base.a_supperbase.t1_copy_deep_shallow.test4_serialize_deep_copy.entity;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
@Slf4j
public class Student implements Serializable {

    private String name;
    private int age;
    private Bag bag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    /**
     * 重点:反序列化注入（漏洞注入）
     * 这里自定义实现一个 readObject, 执行反序列化的时候, 会首先调用类自己的 readObject()方法，因此这会弹出计算器
     */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Runtime.getRuntime().exec("calc");
        log.info("反序列化注入");
    }
}

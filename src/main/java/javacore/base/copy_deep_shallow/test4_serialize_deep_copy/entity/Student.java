package javacore.base.copy_deep_shallow.test4_serialize_deep_copy.entity;

import java.io.*;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
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

    public Object deepClone() throws IOException, ClassNotFoundException {
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        oos.close();

        // 反序列化: 分配内存, 写入原始对象, 生成新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object object = ois.readObject();
        return object;
    }
}

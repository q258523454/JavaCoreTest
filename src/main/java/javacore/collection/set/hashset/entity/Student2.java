package javacore.collection.set.hashset.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-04
 */
public class Student2 {

    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < 5; i++) {
            int rand = new Random().nextInt(10);
            hash = (hash + rand) * 10;
        }

        System.out.println(JSONObject.toJSONString(this) + " hashCode is: " + hash);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(JSONObject.toJSONString(this)+"进入了equals()方法");
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Student2 user = (Student2) o;
        return (name.equals(user.name) && (age == age));
    }
}

package javacore.collection.set.hashset.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-04
 */
public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
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
        // 通用方法一:
        // int hash = 7;
        // hash = 31 * hash + (int) age;
        // hash = 31 * hash + (name == null ? 0 : name.hashCode());

        // 通用方法二:
        int hash = age * name.hashCode();

        System.out.println(JSONObject.toJSONString(this) + " hashCode is: " + hash);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(JSONObject.toJSONString(this) + "进入了equals()方法");
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Student user = (Student) o;
        return (name.equals(user.name) && (age == age));
    }
}

package javacore.base.t2_collection.set.hashset.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-04
 */
@Slf4j
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

        log.info(JSONObject.toJSONString(this) + " hashCode is: " + hash);
        return hash;
    }

    /**
     * 同类型、判断属性值相等
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        log.info(JSONObject.toJSONString(this) + "进入了equals()方法");
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

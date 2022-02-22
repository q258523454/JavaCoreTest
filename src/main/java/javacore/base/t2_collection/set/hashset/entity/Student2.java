package javacore.base.t2_collection.set.hashset.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-04
 */
@Slf4j
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

    /**
     * 随机规则生成hashCode
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < 5; i++) {
            int rand = new Random().nextInt(10);
            hash = (hash + rand) * 10;
        }

        log.info(JSONObject.toJSONString(this) + " hashCode is: " + hash);
        return hash;
    }

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
        Student2 user = (Student2) o;
        return (name.equals(user.name) && (age == age));
    }
}

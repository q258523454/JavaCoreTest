package javacore.base_practice.collection.map.hashmap.object2map;

import java.util.List;

/**
 * @Author: zhangj
 * @Date: 2019-12-03
 * @Version 1.0
 */
public class Student {
    private String name;
    private int age;
    private List<String> skills;

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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}

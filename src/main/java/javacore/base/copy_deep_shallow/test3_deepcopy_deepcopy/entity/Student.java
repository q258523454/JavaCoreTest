package javacore.base.copy_deep_shallow.test3_deepcopy_deepcopy.entity;

import lombok.Data;

@Data
public class Student implements Cloneable {

    private String name;
    private int age;
    private Bag bag;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.setBag((Bag) this.bag.clone()); // bag 需要实现 Cloneable
        return student;
    }
}


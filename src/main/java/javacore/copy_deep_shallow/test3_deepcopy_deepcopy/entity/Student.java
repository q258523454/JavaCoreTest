package javacore.copy_deep_shallow.test3_deepcopy_deepcopy.entity;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
public class Student implements Cloneable {

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.setBag((Bag) this.bag.clone()); // bag 需要实现 Cloneable
        return student;
    }
}

package javacore.base.copy_deep_shallow.test2_deepcopy.entity;

import lombok.Data;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */

@Data
public class Student implements Cloneable {

    private String name;
    private int age;
    private Bag bag;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        // bag 需要实现 Cloneable, [强调]注意: Bag 这里只有基本数据类
        // 如果要实现完全深拷贝, Teacher类中只能含有非基本数据类型, 如果有非基本数据类, 那么在 bag.clone()中必须再做一次类似的深拷贝复制
        student.setBag((Bag) this.bag.clone());
        return student;
    }
}

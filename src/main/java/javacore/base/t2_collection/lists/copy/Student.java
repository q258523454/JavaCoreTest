package javacore.base.t2_collection.lists.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable {
    private int id;
    private String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 只能含有非基本数据类型, 如果有非基本数据类, 那么需要再次递归实现clone
        return super.clone();
    }
}

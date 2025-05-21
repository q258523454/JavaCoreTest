package javacore.base_practice.collection.lists.copy;

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
        // 注意：如果属性含有有非基本数据类, 那么非基本数据类型的数据，也需要递归实现clone
        return super.clone();
    }
}

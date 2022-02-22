package javacore.base.copy_deep_shallow.test3_deepcopy_deepcopy.entity;

import lombok.Data;

@Data
public class Bag implements Cloneable {

    private String name;
    private String color;
    private Pen pen;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

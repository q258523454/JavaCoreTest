package javacore.base.a_supperbase.t1_copy_deep_shallow.test2_deepcopy.entity;

import lombok.Data;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
@Data
public class Bag implements Cloneable {

    private String name;
    private String color;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

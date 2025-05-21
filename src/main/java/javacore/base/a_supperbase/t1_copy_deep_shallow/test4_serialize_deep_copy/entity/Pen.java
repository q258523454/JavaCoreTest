package javacore.base.a_supperbase.t1_copy_deep_shallow.test4_serialize_deep_copy.entity;

import java.io.Serializable;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
public class Pen implements Serializable {
    private String type; // 笔类型
    private String color;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

package javacore.copy_deep_shallow.test2_deepcopy.entity;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-29
 */
public class Bag implements Cloneable {

    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

package javacore.base.a_supperbase.t0_value_transfer;

public class OnlyValueTransfer {


    /**
     * Java中只有值传递
     */
    public static void main(String[] args) {
        String name = "zhangxiaofan";
        // 修改name, 如果是引用传递,那么值一定会被更改
        // 说明: 值传递, 只是这里传递的
        pass(name);
        System.out.println("print in main , name is " + name);
    }

    public static void pass(String name) {
        name = "wangwu";
        System.out.println("print in pass , name is " + name);
    }
}

package javacore.base.a_supperbase.t0_value_transfer;

public class OnlyValueTransfer_Basic {


    /**
     * Java中只有[值传递]
     * 不管是基本数据类型(传值),还是引用数据类型(传引用地址值的副本)
     * 引用数据类型参考 OnlyValueTransfer_Object
     */
    public static void main(String[] args) {
        int id = 1;
        // 内部修改name,不影响原数据
        System.out.println("before id=" + id);
        test1(id);
        System.out.println("after id=" + id);
    }

    public static void test1(int id) {
        id = 2;
        System.out.println("change id=" + id);
    }
}

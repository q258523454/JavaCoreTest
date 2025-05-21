package javacore.base.a_supperbase.t0_value_transfer;

public class OnlyValueTransfer_String {


    /**
     * Java中只有[值传递]
     * 特殊类型非基本类型: String (表现深拷贝)
     */
    public static void main(String[] args) {
        String name = new String("zhangxiaofan");
        System.out.println("before name=" + name);
        test1(name);
        System.out.println("after name=" + name);
    }

    public static void test1(String str) {
        str = "zhangxiaofan";
        System.out.println("change name=" + str);
    }
}

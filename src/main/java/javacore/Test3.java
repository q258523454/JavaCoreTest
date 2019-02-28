package javacore;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class Test3 {
    private static Test3 Test3 = new Test3();
    public static int count1;
    public static int count2 = 0;

    private Test3() {
        count1++;
        count2++;
    }

    public static Test3 getInstance() {
        return Test3;
    }

    public static void main(String[] args) {
//        Test3 test3 = Test3.getInstance();
        Test3 test3 = new Test3();

        System.out.println("count1=" + Test3.count1);
        System.out.println("count2=" + Test3.count2);
    }
}

package javacore.base.a_supperbase.t0_access_privilege.fatherpack;

public class RunTest {
    public static void main(String[] args) {

        AccessTest accessTest = new AccessTest();
        // 同一个包下,无法访问private
        accessTest.defalutAttribute = 100;
        accessTest.protectedAttribute = 200;
        accessTest.publicAttribute = 300;
        System.out.println(accessTest);
    }
}

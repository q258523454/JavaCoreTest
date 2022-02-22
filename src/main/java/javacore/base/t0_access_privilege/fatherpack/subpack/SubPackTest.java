package javacore.base.t0_access_privilege.fatherpack.subpack;

import javacore.base.t0_access_privilege.fatherpack.AccessTest;

public class SubPackTest {
    public static void main(String[] args) {

        AccessTest accessTest = new AccessTest();
        // 不同的包下(即使是子包),无法访问 protected 和 default
        accessTest.publicAttribute = 300;
        System.out.println(accessTest);
    }
}

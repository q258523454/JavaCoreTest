package designmode.t3_proxy.dynamicproxy.entity;

public class Student {

    public void goHome(String name) {
        System.out.println(name + " public method...");
    }

    private void doCry(String name) {
        System.out.println(name + " private method...");
    }
}


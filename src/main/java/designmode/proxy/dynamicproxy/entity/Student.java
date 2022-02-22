package designmode.proxy.dynamicproxy.entity;

public class Student {

    public void run(String name) {
        System.out.println(name + " public method...");
    }

    private void cry(String name) {
        System.out.println(name + " private method...");
    }
}


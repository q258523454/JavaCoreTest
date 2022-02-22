package javacore.base.t0_constrcutor.nooverride;

public class Son extends Father {

    public Son() {
        System.out.println("Son");
    }

    /**
     * 构造函数能重载(overload), 但是不能继承和覆盖(override)
     */
    public void Father() {
        System.out.println("Sub Father");
    }

    @Override
    public void say() {
        Father();
        System.out.println("I am son");
    }

    public static void main(String[] args) {
        Father father = new Father();
        father.say();
        System.out.println("--------------------");
        Son son = new Son();
        son.say();
    }
}

package javacore.base.a_supperbase.t0_extends;

public class Child extends Base {

    public int id = 101;

    @Override
    public void doSomething() {
        System.out.println("Child");
    }

    public static void main(String[] args) {
        System.out.println("-------------------");
        Base base1 = new Base();
        System.out.println(base1.id);
        base1.doSomething();

        System.out.println("-------------------");
        Base base2 = new Child();
        System.out.println(base2.id);
        base2.doSomething();

        System.out.println("-------------------");
        Child child = new Child();
        System.out.println(child.id);
        child.doSomething();

        System.out.println("-------------------");
        System.out.println("Base强制转换成Child后:" + ((Child) base2).id);
    }

}

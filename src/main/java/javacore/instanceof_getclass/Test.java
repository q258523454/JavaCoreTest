package javacore.instanceof_getclass;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class Test {

    public static void testInstanceof(Object x) {
        System.out.println("x instanceof Parent:  " + (x instanceof Parent));
        System.out.println("x instanceof Child:  " + (x instanceof Child));
        System.out.println("x getClass Parent:  " + (x.getClass() == Parent.class));
        System.out.println("x getClass Child:  " + (x.getClass() == Child.class));
    }

    /***
     * 总结: instanceof考虑派生, getClass()不考虑派生(精准判断)
     * @param args
     */
    public static void main(String[] args) {
        testInstanceof(new Parent());
        System.out.println("---------------------------");
        testInstanceof(new Child());
    }
}

class Parent {

}

class Child extends Parent {


}
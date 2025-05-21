package javacore.base.jvm.t03_instanceof_getclass;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class RunTest {
    private static class Parent {

    }

    private static class Child extends Parent {


    }

    /***
     * 总结:
     * a是否和b同类:getClass,            eg:a.getClass()==b.getClass()
     * a是否为b子类:instanceof,          eg:a instanceof b
     * a是否为b父类:isAssignableFrom,    eg:a.isAssignableFrom(b)
     *
     * 1.instanceof考虑派生, getClass()不考虑派生(精准判断)
     * 2.isAssignableFrom, 判定是否为父类.
     */
    public static void main(String[] args) {
        instanceOf_VS_GetClass(new Child());
        System.out.println("---------------------------");
        instanceOf_VS_isAssignedFrom(new Child());
    }

    public static void instanceOf_VS_GetClass(Object x) {
        System.out.println(x.getClass().getSimpleName() + " 是 Parent 子类吗？:  " + (x instanceof Parent));
        System.out.println(x.getClass().getSimpleName() + " 是 Child 子类吗？:  " + (x instanceof Child));
        System.out.println(x.getClass().getSimpleName() + " 是 Parent 同类吗？:  " + (x.getClass() == Parent.class));
        System.out.println(x.getClass().getSimpleName() + " 是 Child 同类吗？:  " + (x.getClass() == Child.class));
    }

    /**
     * a.isAssignedFrom(b): a是否为b的父类
     */
    public static void instanceOf_VS_isAssignedFrom(Object x) {
        Class<?> aClass = x.getClass();
        System.out.println(aClass.getSimpleName() + " 是 Parent 子类吗？:  " + (x instanceof Parent));
        System.out.println(aClass.getSimpleName() + " 是 Child 子类吗？:  " + (x instanceof Child));
        System.out.println(aClass.getSimpleName() + " 是 Parent 父类吗?:  " + (aClass.isAssignableFrom(Parent.class)));
        System.out.println(aClass.getSimpleName() + " 是 Child 父类吗?:  " + (aClass.isAssignableFrom(Child.class)));
        System.out.println(Parent.class.getSimpleName() + " 是 Child 父类吗？:  " + (Child.class.isAssignableFrom(aClass)));
    }

}


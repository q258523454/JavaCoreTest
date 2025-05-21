package javacore.base.jdk.threadlocal.inheritable;


/**
 * 嵌套线程共享/传递
 */
public class MyInheritableThreadLocal extends InheritableThreadLocal<Integer> {

    @Override
    protected Integer initialValue() {
        return 0;
    }

    @Override
    protected Integer childValue(Integer parentValue) {
        return super.childValue(parentValue);
    }

}

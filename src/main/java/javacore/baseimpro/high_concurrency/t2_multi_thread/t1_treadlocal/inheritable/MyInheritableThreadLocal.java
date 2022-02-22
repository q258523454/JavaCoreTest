package javacore.baseimpro.high_concurrency.t2_multi_thread.t1_treadlocal.inheritable;


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

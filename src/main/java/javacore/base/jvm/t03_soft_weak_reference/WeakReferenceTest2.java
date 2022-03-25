package javacore.base.jvm.t03_soft_weak_reference;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;


@Slf4j
public class WeakReferenceTest2 {


    @SneakyThrows
    public static void main(String[] args) {

        // 单独new的对象,没有强关联
        WeakReference<ByteBean> bSoftReference = new WeakReference<>(new ByteBean(50 * 1024 * 1024));

        log.info("----------初始GC信息-------------");
        log.info("初始信息,bSoftReference.get()=" + bSoftReference.get());
        System.out.println();


        log.info("----------第1次GC-------------");
        // WeakReference 首次GC就会被回收
        System.gc();
        log.info("第1次GC后,bSoftReference.get()=" + bSoftReference.get());
        System.out.println();


        System.exit(0);
    }
}

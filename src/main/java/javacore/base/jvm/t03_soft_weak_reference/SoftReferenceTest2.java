package javacore.base.jvm.t03_soft_weak_reference;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;


@Slf4j
public class SoftReferenceTest2 {

    @SneakyThrows
    public static void main(String[] args) {

        /**
         *  vm options: -Xms200m -Xmx200m -XX:+PrintGC
         *  直接在堆中new,没有其他地方引用, 即没有强关联
         *
         */
        SoftReference<ByteBean> bSoftReference = new SoftReference<>(new ByteBean(50 * 1024 * 1024));

        log.info("----------初始GC信息（即使没有强关联, 但是内存充足, 主动GC, 不会回收 ）-------------");
        System.gc();
        log.info("初始信息,bSoftReference.get()=" + bSoftReference.get());
        System.out.println();

        log.info("----------第2次GC(内存不足,自动GC,会回收)-------------");
        // 内存不足,才会被GC
        byte[] bytesNew = new byte[100 * 1024 * 1024];
        log.info("分配120M后,bSoftReference.get()=" + bSoftReference.get());
        System.out.println();

        System.exit(0);
    }
}

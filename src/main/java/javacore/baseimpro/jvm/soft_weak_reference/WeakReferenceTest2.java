package javacore.baseimpro.jvm.soft_weak_reference;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;


@Slf4j
public class WeakReferenceTest2 {


    /**
     * vm options: -Xms200m -Xmx200m -XX:+PrintGC
     * 总结:
     *   byte[] byteBean = new byte[X]
     *   XxxReference<byte[]> xxxReference = new XxxReference<byte[]>(byteBean)
     *   1.如果是 WeakReference(软引用): 下一次GC,并不会回收bSoftReference,除非内存不足
     *   2.如果是 WeakReference(弱引用): 下一次GC,不管内存是否充足,都会GC
     */
    @SneakyThrows
    public static void main(String[] args) {

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

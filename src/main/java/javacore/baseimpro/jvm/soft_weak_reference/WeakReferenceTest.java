package javacore.baseimpro.jvm.soft_weak_reference;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;


@Slf4j
public class WeakReferenceTest {


    /**
     * vm options: -Xms200m -Xmx200m -XX:+PrintGC
     * 总结:
     *   byte[] bytes = new byte[X]
     *   XxxReference<byte[]> xxxReference = new XxxReference<byte[]>(bytes)
     *   1.如果是 SoftReference(软引用): 下一次GC,并不会回收bSoftReference,除非内存不足
     *   2.如果是 WeakReference(弱引用): 下一次GC,不管内存是否充足,都会GC
     */
    @SneakyThrows
    public static void main(String[] args) {

        byte[] bytes = new byte[100 * 1024 * 1024];

        WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes);

        log.info("----------初始GC信息-------------");
        System.gc();
        log.info("初始信息,bytes=" + bytes);
        log.info("初始信息,weakReference.get()=" + weakReference.get());
        System.out.println();

        log.info("-----bytes开始置为null----------");
        // 去掉强引用
        //注意: bytes=null,Reference 不管是什么类型引用仍然指向原来new byte[]的地址.
        bytes = null;
        log.info("第一次GC前,bytes=" + bytes);
        log.info("第一次GC前,weakReference.get()=" + weakReference.get());
        System.out.println();

        log.info("----------开始第1次GC-------------");
        log.info("----------不管内存充足与否，bytes = null后，weakReference都会GC -------------");
        System.gc();
        Thread.sleep(200);
        log.info("第一次GC后,bytes=" + bytes);
        log.info("第一次GC后,weakReference.get()=" + weakReference.get());
        System.out.println();

        System.exit(0);
    }
}

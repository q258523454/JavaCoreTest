package javacore.base.jvm.t03_soft_weak_reference;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;


@Slf4j
public class SoftReferenceTest {


    /**
     * vm options: -Xms200m -Xmx200m -XX:+PrintGC
     * 总结:
     * byte[] byteBean = new byte[X]
     * XxxReference<byte[]> xxxReference = new XxxReference<byte[]>(byteBean)
     * 1.如果是 SoftReference(软引用): 下一次GC,如果 没有强关联+内存不足 会回收
     * 2.如果是 WeakReference(弱引用): 下一次GC,如果 没有强关联(不管内存充足与否),会回收
     */
    @SneakyThrows
    public static void main(String[] args) {

        // 强引用
        ByteBean byteBean = new ByteBean(50 * 1024 * 1024);
        SoftReference<ByteBean> bSoftReference = new SoftReference<>(byteBean);

        log.info("----------初始GC信息-------------");
        // 存在强引用,不会GC
        System.gc();
        log.info("初始信息,byteBean=" + byteBean);
        log.info("初始信息,bSoftReference.get()=" + bSoftReference.get());
        System.out.println();

        log.info("-----bytes开始置为null----------");
        // 去掉强引用
        // 注意: 虽然 byteBean=null, 但是 bSoftReference 由于内存充足，没有被回收。
        byteBean = null;
        log.info("第一次GC前,byteBean=" + byteBean);
        log.info("第一次GC前,bSoftReference.get()=" + bSoftReference.get());
        System.out.println();

        System.gc();
        log.info("----------第1次GC(手动触发)-------------");
        Thread.sleep(200);
        log.info("第一次GC(内存充足),byteBean=" + byteBean);
        log.info("第一次GC(内存充足),bSoftReference.get()=" + bSoftReference.get());
        System.out.println();

        log.info("----------第2次GC(内存不足,自动触发)-------------");
        // 手动申请内存,导致内存不足
        byte[] bytesNew = new byte[120 * 1024 * 1024];
        log.info("分配120M后(内存不足)自动GC,byteBean=" + byteBean);
        log.info("分配120M后(内存不足)自动GC,bSoftReference.get()=" + bSoftReference.get());
        System.out.println();


        System.exit(0);
    }
}

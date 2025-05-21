package javacore.base.jdk.string;

/**
 * @Description
 * @author zhang
 * @date 2022-03-07 19:30
 * @modify
 */
public class My_StringBuffer {

    /**
     * String           字符串'常量', 每次更改相当于创建一个新的String对象, 不存安全问题
     * StringBuffer     字符串变量, synchronized 线程安全
     * StringBuilder    字符串变量, 线程不安全
     *
     * 总结:
     * 常量用 String
     * 频繁修改 StringBuffer/StringBuilder(线程不安全)
     *
     * 一般情况 StringBuffer 只比 StringBuilder 性能低 10%~15%
     * 除非确定系统的瓶颈是在 StringBuffer 上, 一般建议使用 StringBuffer
     */
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append("c");
        String s = stringBuffer.toString();
        System.out.println(s);
    }
}

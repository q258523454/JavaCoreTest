package javacore.base.jdk.string;

/**
 * @Description
 * @author zhang
 * @date 2022-03-07 19:30
 * @modify
 */
public class My_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("c");
        String s = sb.toString();
        System.out.println(s);
    }
}

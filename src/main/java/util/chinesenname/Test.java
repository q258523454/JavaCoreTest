
package util.chinesenname;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(ChineseNameUtil.getName());
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(ChineseNameUtil.getSpecialName());
        }
    }
}

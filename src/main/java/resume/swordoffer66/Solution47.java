package resume.swordoffer66;

/**
 * Created By
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * @author :   zhangj
 * @date :   2019-01-08
 */
public class Solution47 {


    // 1.用逻辑操作的短路特性(&&)
    // 2.用try异常终止递归
    // 3.用构造函数 (java在创建对象的时候并不实例化,用C++)
    public int Sum_Solution(int n) {
        try {
            int a = 1 / n;
            return n + Sum_Solution(n - 1);
        } catch (Exception e) {
            // TODO
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution47().Sum_Solution(100));
    }
}

package swordoffer66;

/**
 * Created By
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author :   zhangj
 * @date :   2019-01-09
 */
public class Solution47_2 {

    // 1.用逻辑操作的短路特性(&&)
    // 2.用try异常终止递归
    // 3.用构造函数 (java在创建对象的时候并不实例化,用C++)
    public int Sum_Solution(int n) {
        int sum = n;
        // sum && (sum += Sum_Solution(sum - 1)); // C++版本
        boolean b = (sum != 0) && ((sum += Sum_Solution(sum - 1)) != 0); // java版本
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Solution47().Sum_Solution(100));
    }
}

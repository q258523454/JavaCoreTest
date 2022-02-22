package resume.swordoffer66;

import java.util.Arrays;

/**
 * Created By
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 即B[i]=A的累积/A[i]
 * 不能使用除法。
 *
 * @author :   zhangj
 * @date :   2019-01-11
 */
public class Solution53 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];

        int temp = 1;
        int[] rightTriangle = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            rightTriangle[A.length - 1 - i] = temp;
            temp *= A[A.length - 1 - i];
        }

        int leftTriangle = 1;
        for (int i = 1; i < A.length; i++) {
            leftTriangle *= A[i - 1];
            B[i] = leftTriangle * rightTriangle[i];
        }

        B[0] = rightTriangle[0];

        return B;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution53().multiply(a)));

    }
}

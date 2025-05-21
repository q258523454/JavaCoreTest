package resume.onlineAC.a1_arrylist;

import com.alibaba.fastjson.JSON;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2022-05-16
 */
public class Solution_Merge {

    /**
     * [4,5,6],[1,2,3]
     * [1,2,3,4,5,6]
     * 说明：
     * A数组为[4,5,6]，B数组为[1,2,3]，后台程序会预先将A扩容为[4,5,6,0,0,0]，B还是为[1,2,3]，
     * m=3，n=3，传入到函数merge里面，
     * 然后请同学完成merge函数，将B的数据合并A里面，最后后台程序输出A数组
     */
    public static void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                a[k--] = a[i--];
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                a[k--] = b[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6};
        int[] b = {1, 2, 3};
        merge(a, 3, b, 3);
        System.out.println(JSON.toJSONString(a));
    }
}

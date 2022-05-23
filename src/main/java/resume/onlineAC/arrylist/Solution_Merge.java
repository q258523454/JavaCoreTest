package resume.onlineAC.arrylist;

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
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                A[k--] = A[i--];
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                A[k--] = B[j--];
            }
        }
    }
}

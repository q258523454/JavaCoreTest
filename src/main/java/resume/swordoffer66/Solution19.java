package resume.swordoffer66;

import java.util.ArrayList;

/**
 * Created By
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 * @author :   zhangj
 * @date :   2018-12-25
 */


public class Solution19 {

    /***
     * 比想象中的细节要多
     * 1.确定循环圈数
     * 2.避免重复提取数据
     * 3.矩阵为向量的时候
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                arrayList.add(matrix[0][i]);
            }
            return arrayList;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                arrayList.add(matrix[i][0]);
            }
            return arrayList;
        }

        int h = matrix.length;
        int w = matrix[0].length;

        int maxCircle = h < w ? h : w;

        for (int r = 0; r < (maxCircle + 1) / 2; r++) {

            int subH = h - 2 * r;
            int subW = w - 2 * r;

            for (int i = r; i < r + subW; i++) {
                arrayList.add(matrix[r][i]);
            }

            for (int i = r + 1; i < r + subH; i++) {
                arrayList.add(matrix[i][r + subW - 1]);
            }

            if ((r + subH - 1) <= r) {
                continue;
            }

            for (int i = (r + subW - 1) - 1; i >= r; i--) {
                arrayList.add(matrix[r + subH - 1][i]);
            }

            for (int i = (r + subH - 1) - 1; i > r; i--) {
                arrayList.add(matrix[i][r]);
            }
        }

        return arrayList;
    }

    public static void main(String[] args) {


        int[][] a = new int[5][];
//        a[0] = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < a.length; i++) {
            int[] b = new int[1];
            b[0] = i + 1;
//            b[1] = i + 1;
            a[i] = b;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        Solution19 solution19 = new Solution19();
        ArrayList<Integer> arrayList2 = solution19.printMatrix(a);
        System.out.println(arrayList2.toString());
    }

}

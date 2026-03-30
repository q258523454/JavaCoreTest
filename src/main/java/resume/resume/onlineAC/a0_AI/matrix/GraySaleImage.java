package resume.resume.onlineAC.a0_AI.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraySaleImage {

    /**
     *
     * 原题:
     * CV287499 灰度图像对比度计算器
     * <a href="https://www.nowcoder.com/practice/9acf08634aca4a338fad76e09e7f9b16?tpId=381&tqId=11121277&sourceUrl=%2Fexam%2Foj%3FquestionJobId%3D10%26subTabName%3Donline_coding_page">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[][] A = getInputMatrix(sc);

            calcGrayPix(A);
        }
    }

    private static int[][] getInputMatrix(Scanner sc) {
        String line = sc.nextLine();
        line = line.replaceAll(" ", "");
        String[] split = line.split("],\\[");
        int m = split.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String temp = split[i].replaceAll("\\[\\[", "");
            temp = temp.replaceAll("]]", "");
            String[] arr = temp.split(",");
            int[] tempArr = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                tempArr[j] = Integer.parseInt(arr[j]);
            }
            list.add(tempArr);
        }
        int n = list.get(0).length;
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = list.get(i)[j];
            }
        }
        return A;
    }

    public static void calcGrayPix(int[][] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] > max) {
                    max = A[i][j];
                }
                if (A[i][j] < min) {
                    min = A[i][j];
                }
            }
        }
        System.out.println(max - min);
    }

}
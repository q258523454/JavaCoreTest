package resume.resume.onlineAC.a0_AI.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixReverse {
    /**
     * LA2 矩阵转置
     * <a href="https://www.nowcoder.com/practice/7a8b443abda641bba5f70e0b4ebd8161?tpId=378&tqId=11118026&sourceUrl=%2Fexam%2Foj">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[][] A = getInputMatrix(sc);
            int[][] R = calcReverse(A);
            // System.out.println(JSON.toJSONString(R));
            printMatrix(R);
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


    /**
     * 矩阵转置
     */
    public static int[][] calcReverse(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] R = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                R[j][i] = matrix[i][j];
            }
        }
        return R;
    }

    public static void printMatrix(int[][] matrix) {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < matrix.length; i++) {
            str.append("[");
            for (int j = 0; j < matrix[i].length; j++) {
                if (j < matrix[i].length - 1) {
                    str.append(matrix[i][j]).append(",");
                } else {
                    str.append(matrix[i][j]);
                }
            }
            str.append("]");
            if (i < matrix.length - 1) {
                str.append(",");
            }
        }
        str.append("]");
        System.out.println(str);
    }

}
package resume.resume.onlineAC.a0_AI.matrix;

import java.math.BigDecimal;
import java.util.Scanner;

public class RREFMatrix {

    /**
     * LA23 实现简化行阶梯形（RREF）函数
     * 未提交,用例需要处理-0(带符号的0)
     * <a href="https://www.nowcoder.com/practice/48380187ac2d412d8defc1e16446744f?tpId=378&tqId=11127560&sourceUrl=%2Fexam%2Foj%3FquestionJobId%3D10%26subTabName%3Donline_coding_page">...</a>
     *
     * 核心:
     * 1.按列依次计算
     * 2.矩阵row交换:0元素行交换非0元素行
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            double[][] A = getInputMatrix(sc.nextLine());

            int m = A.length;
            int n = A[0].length;
            // double[][] doubles = exchangeMatrixRow(A, 0, 1);
            calc(A);
        }
    }

    private static void calc(double[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][i] == 0) {
                // 从第i行开始,找到当前列的非0行进行交换
                A = getExchangeMatrix(A, i, m);
                // 如果找不到非0行,列无需再简化
                if (A[i][i] == 0) {
                    continue;
                }
            }
            double rowFirstElement = A[i][i];
            // 行列式首元素归一
            for (int j = i; j < n; j++) {
                A[i][j] = A[i][j] / rowFirstElement;
            }
            for (int j = 0; j < m; j++) {
                if (j == i) {
                    continue;
                }
                double firstElement = A[j][i];
                if (firstElement == 0) {
                    continue;
                }
                for (int k = i; k < n; k++) {
                    A[j][k] = A[j][k] - firstElement * A[i][k];
                }
            }
        }
        printMatrix(A);
    }

    private static double[][] getExchangeMatrix(double[][] A, int i, int m) {
        for (int j = i; j < m; j++) {
            if (A[j][i] != 0) {
                A = exchangeMatrixRow(A, i, j);
            }
        }
        return A;
    }

    /**
     * 获取输入的矩阵
     *
     * @param line [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
     * @return 矩阵
     */
    private static double[][] getInputMatrix(String line) {
        line = line.replaceAll(" ", "");
        String[] split1 = line.split("],\\[");
        int m = split1.length;
        double[][] matrix = new double[m][];
        for (int i = 0; i < split1.length; i++) {
            String string = split1[i];
            String temp = string.replaceAll("\\[", "").replaceAll("]", "");
            String[] split2 = temp.split(",");
            double[] doubles = new double[split2.length];
            for (int j = 0; j < split2.length; j++) {
                doubles[j] = Double.parseDouble(split2[j]);
            }
            matrix[i] = doubles;
        }
        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        String line = "[";
        for (int i = 0; i < matrix.length; i++) {
            String temp = "[";
            for (int j = 0; j < matrix[0].length; j++) {
                BigDecimal bigDecimal = BigDecimal.valueOf(matrix[i][j]).stripTrailingZeros();
                temp = temp + bigDecimal + ", ";
            }
            temp = temp.substring(0, temp.length() - 2);
            temp = temp + "]";
            line = line + temp + "\n";
        }
        line = line.substring(0, line.length() - 1);
        line = line + "]";
        System.out.println(line);
    }

    /**
     * 矩阵交换row1与row2
     */
    public static double[][] exchangeMatrixRow(double[][] matrix, int row1, int row2) {
        if (row1 == row2) {
            return matrix;
        }
        if (row1 > row2) {
            int temp = row1;
            row1 = row2;
            row2 = temp;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        double[] tempRow = new double[n];
        double[][] result = new double[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == row1) {
                    tempRow[j] = matrix[row1][j];
                    result[row1][j] = matrix[row2][j];
                } else if (i == row2) {
                    result[row2][j] = tempRow[j];
                } else {
                    result[i][j] = matrix[i][j];
                }
            }
        }
        return result;
    }
}

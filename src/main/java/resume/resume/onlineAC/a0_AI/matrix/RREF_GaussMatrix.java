package resume.resume.onlineAC.a0_AI.matrix;

import java.math.BigDecimal;
import java.util.Scanner;

public class RREF_GaussMatrix {

    /**
     * LA26 高斯消元法求解线性方程组
     * 牛客解题排名第一
     * 思路:转换成求 简化行阶梯形（RREF）函数
     * <a href="https://www.nowcoder.com/practice/02b6ff112b9b4eb2ad4403e30e0f076a?tpId=378&tqId=11127509&sourceUrl=%2Fexam%2Foj%3FquestionJobId%3D10%26subTabName%3Donline_coding_page">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            double[][] inputMatrix1 = getInputMatrix(line1);
            String line2 = sc.nextLine();
            double[][] inputMatrix2 = reverseMatrix(getInputMatrix(line2));
            double[][] A = matrixPlusColumMatrix(inputMatrix1, inputMatrix2);
            // printMatrix(A);
            calcSimpleMatrix(A);
        }
    }

    public static void calcSimpleMatrix(double[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][i] == 0) {
                for (int j = i; j < n; j++) {
                    if (A[i][j] != 0) {
                        A = exchangeMatrixRow(A, i, j);
                    }
                }
            }
            if (A[i][i] == 0) {
                continue;
            }
            double firstElement = A[i][i];
            // 归一化
            for (int j = i; j < n; j++) {
                A[i][j] = A[i][j] / firstElement;
            }

            for (int j = 0; j < m; j++) {
                if (i == j) {
                    continue;
                }
                double innerFirstElement = A[j][i];
                for (int k = i; k < n; k++) {
                    A[j][k] = A[j][k] - A[i][k] * innerFirstElement;
                }
            }
        }
        // printMatrix(A);
        String temp = "[";
        for (int i = 0; i < m; i++) {
            temp += A[i][n - 1] + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        temp += "]";
        System.out.println(temp);
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

    public static double[][] matrixPlusColumMatrix(double[][] inputMatrix1, double[][] inputMatrix2) {
        int m = inputMatrix1.length;
        int n = inputMatrix1[0].length;
        double[][] result = new double[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = inputMatrix1[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            result[i][n] = inputMatrix2[i][0];
        }
        return result;
    }

    /**
     * 矩阵的转置T
     */
    public static double[][] reverseMatrix(double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        double[][] result = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
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

package resume.resume.onlineAC.a0_AI.matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class IteratorJacobiMatrix {

    /**
     * 题目: LA21 使用Jacobi方法求解线性方程组
     * 牛客解题排名第一
     * <a href="https://www.nowcoder.com/practice/d2e8bb3721974d0494cf026198f40cb7?tpId=378&tqId=11125095&sourceUrl=%2Fexam%2Foj%3FquestionJobId%3D10%26subTabName%3Donline_coding_page">...</a>
     * 公式参考:
     * <a href="https://www.cnblogs.com/wc529065/p/18767247">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            double[][] A = getInputMatrix(line);
            String line2 = sc.nextLine();
            double[][] b = getInputMatrix(line2);
            String line3 = sc.nextLine();
            int iter = Double.valueOf(line3).intValue();

            double[] newX = new double[A[0].length];
            for (int i = 0; i < newX.length; i++) {
                newX[i] = 0;
            }
            for (int i = 0; i < iter; i++) {
                newX = calcJacobiMatrix(A, newX, b[0]);
            }
            printVector(newX);
        }
    }

    public static void printVector(double[] vector) {
        String temp = "[";
        for (int i = 0; i < vector.length; i++) {
            BigDecimal bd = BigDecimal.valueOf(vector[i]);
            bd = bd.setScale(4, RoundingMode.HALF_UP);
            temp = temp + bd + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        temp = temp + "]";
        System.out.println(temp);
    }

    /**
     * 雅可比迭代公式
     *
     * @param A A矩阵
     * @param X 上次X向量
     * @param b b常量向量
     */
    public static double[] calcJacobiMatrix(double[][] A, double[] X, double[] b) {
        int m = A.length;
        int n = A[0].length;
        if ((X.length != n) || (b.length != n)) {
            throw new IllegalArgumentException("X and Y arrays must have the same length");
        }
        double[] newX = new double[n];
        for (int i = 0; i < m; i++) {
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += A[i][j] * X[j];
                }
            }
            newX[i] = (b[i] - sum) / A[i][i];
        }
        return newX;
    }

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
}

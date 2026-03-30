package resume.resume.ai.D0917;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Attention {


    /**
     * 题目参考:
     * <a href="https://mp.weixin.qq.com/s/o5iKWAiGqUYgFdtlR852Og">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();

        double[][] X = new double[n][m];
        initX(n, m, X);

        double[][] triangle = getTriangle(m, h);
        double[][] W = new double[m][h];
        initW(m, h, W, triangle);

        double[][] Q = matrixMultiply(X, W);
        double[][] K = matrixMultiply(X, W);
        double[][] V = matrixMultiply(X, W);

        double[][] tempMatrix = matrixMultiply(Q, reverse(K));
        double[] rowSum = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                tempMatrix[i][j] = tempMatrix[i][j] / Math.sqrt(h);
                sum += tempMatrix[i][j];
            }
            rowSum[i] = sum;
        }

        // 计算 softmax
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempMatrix[i][j] = tempMatrix[i][j] / rowSum[i];
            }
        }
        // 计算 Y
        double[][] Y = matrixMultiply(tempMatrix, V);

        double result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < h; j++) {
                result += Y[i][j];
            }
        }

        BigDecimal bigDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();
        System.out.println(bigDecimal.toString());
    }

    private static void initW(int m, int h, double[][] W, double[][] triangle) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < h; j++) {
                W[i][j] = triangle[i][j];
            }
        }
    }

    private static void initX(int n, int m, double[][] X) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                X[i][j] = 1;
            }
        }
    }

    /**
     * 矩阵的转置
     */
    public static double[][] reverse(double[][] A) {
        int n = A.length;
        int m = A[0].length;
        double[][] B = new double[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }

    /**
     * 计算矩阵相乘
     */
    public static double[][] matrixMultiply(double[][] A, double[][] B) {
        int n1 = A.length;
        int m1 = A[0].length;
        int n2 = B.length;
        int m2 = B[0].length;
        if (m1 != n2) {
            throw new ArithmeticException();
        }
        double[][] C = new double[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    /**
     * 获取上三角矩阵(1)
     */
    public static double[][] getTriangle(int m, int h) {
        int rc = Math.max(m, h);
        double[][] equalMatrix = new double[rc][rc];
        for (int i = 0; i < rc; i++) {
            for (int j = 0; j < rc; j++) {
                if (i <= j) {
                    equalMatrix[i][j] = 1;
                } else {
                    equalMatrix[i][j] = 0;
                }
            }
        }
        return equalMatrix;
    }

}

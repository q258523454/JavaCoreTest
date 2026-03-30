package resume.resume.onlineAC.a0_AI.matrix;

import java.math.BigDecimal;
import java.util.Scanner;

public class IteratorGaussSeidelMatrix {

    /**
     * LA25 Gauss-Seidel法求解线性方程组
     * 注意与 Jacobi迭代的区别
     * <a href="https://www.nowcoder.com/practice/b5550537abf343c8842ec6a806970fb3?tpId=378&tqId=11127521&sourceUrl=%2Fexam%2Foj%3FquestionJobId%3D10%26subTabName%3Donline_coding_page">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            double[][] A = getInputMatrix(line);
            String line2 = sc.nextLine();
            double[][] inputMatrix2 = getInputMatrix(line2);
            double[][] b = reverseMatrix(inputMatrix2);
            String line3 = sc.nextLine();
            int n = Integer.parseInt(line3);

            double[] X = new double[A[0].length];
            for (int i = 0; i < n; i++) {
                X = calc(A, b, X);
            }
            printResult(X);
        }

    }

    private static void printResult(double[] X) {
        String temp = "[";
        for (int i = 0; i < X.length; i++) {
            // BigDecimal bigDecimal = BigDecimal.valueOf(X[i]).setScale(10, RoundingMode.HALF_UP).stripTrailingZeros();
            BigDecimal bigDecimal = BigDecimal.valueOf(X[i]);
            temp += bigDecimal + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        temp += "]";
        System.out.println(temp);
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

    public static double[] calc(double[][] A, double[][] b, double[] X) {
        int m = A.length;
        int n = A[0].length;
        if (n != X.length || m != b.length) {
            throw new ArithmeticException();
        }
        double[] newX = new double[n];
        for (int i = 0; i < n; i++) {
            newX[i] = X[i];
        }
        for (int i = 0; i < m; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // 与Jacobi雅可比的差别就是迭代过程中,Gauss迭代就会用最新的x值,而Jacobi是需要等每一轮迭代完成后才用最新的x
                    sum += A[i][j] * newX[j];
                }
            }
            newX[i] = (b[i][0] - sum) / A[i][i];
        }
        return newX;
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
}

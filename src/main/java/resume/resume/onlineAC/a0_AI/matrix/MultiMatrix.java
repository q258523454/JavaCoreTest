package resume.resume.onlineAC.a0_AI.matrix;

import java.math.BigDecimal;
import java.util.Scanner;

public class MultiMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            double[][] matrix1 = getInputMatrix(line);
            String line2 = sc.nextLine();
            double[][] matrix2 = getInputMatrix(line2);
            calcMultiMatrix(matrix1, matrix2);
        }
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

    public static void calcMultiMatrix(double[][] matrix1, double[][] matrix2) {
        int m1 = matrix1.length;
        int n1 = matrix1[0].length;
        int m2 = matrix2.length;
        int n2 = matrix2[0].length;
        if (n1 != m2) {
            System.out.println("-1");
            return;
        }

        double[][] result = new double[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                double sum = 0;
                for (int k = 0; k < n1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }
        printMatrix(result);
    }

    public static void printMatrix(double[][] matrix) {
        String line = "[";
        for (int i = 0; i < matrix.length; i++) {
            String temp = "[";
            for (int j = 0; j < matrix[0].length; j++) {
                BigDecimal bigDecimal = BigDecimal.valueOf(matrix[i][j]).stripTrailingZeros();
                temp = temp + bigDecimal.toPlainString() + ", ";
            }
            temp = temp.substring(0, temp.length() - 2);
            temp = temp + "]";
            line = line + temp + ", ";
        }
        line = line.substring(0, line.length() - 2);
        line = line + "]";
        System.out.println(line);
    }
}

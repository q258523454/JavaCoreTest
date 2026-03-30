package resume.resume.onlineAC.a0_AI.matrix;

import java.math.BigDecimal;
import java.util.Scanner;

public class ReshapeMatrix {

    /**
     * 重塑矩阵
     * <a href="https://www.nowcoder.com/practice/87ee1f70415249108a55457065b16b85?tpId=378&tqId=11118027&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DAI%25E7%25AF%2587%26topicId%3D378">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replaceAll(" ", "");
            String[] split1 = line.split("],\\[");
            int m = split1.length;
            double[][] matrix = new double[m][];
            for (int i = 0; i < split1.length; i++) {
                String string = split1[i];
                String temp = string.replaceAll("\\[", "").replaceAll("]", "");
                String[] split2 = temp.split(",");
                double[] tempMatrix = new double[split2.length];
                for (int j = 0; j < split2.length; j++) {
                    tempMatrix[j] = Double.parseDouble(split2[j]);
                }
                matrix[i] = tempMatrix;
            }
            String line2 = sc.nextLine();
            line2 = line2.replaceAll(" ", "");
            line2 = line2.replaceAll("\\(", "").replaceAll("\\)", "");
            String[] split2 = line2.split(",");
            int tm = Integer.parseInt(split2[0]);
            int tn = Integer.parseInt(split2[1]);
            reshape(matrix, tm, tn);
        }
    }


    public static void reshape(double[][] matrix, int tm, int tn) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m * n != tm * tn) {
            System.out.println(-1);
            return;
        }
        double[][] newMatrix = new double[tm][tn];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                int ii = index / tn;
                int jj = index % tn;
                newMatrix[ii][jj] = matrix[i][j];
            }
        }
        printMatrix(newMatrix);
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
            line = line + temp + ", ";
        }
        line = line.substring(0, line.length() - 2);
        line = line + "]";
        System.out.println(line);
    }
}
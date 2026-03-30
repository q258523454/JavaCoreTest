package resume.resume.onlineAC.a0_AI.matrix;

import java.util.Scanner;

public class InverseMatrix2x2 {

    /**
     * 计算矩阵的逆
     * <a href="https://www.nowcoder.com/practice/3b8f90d945484200b517cc61c2445ae5?tpId=378&tqId=11118161&sourceUrl=%2Fexam%2Foj%3FquestionJobId%3D10%26subTabName%3Donline_coding_page">...</a>
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
                double[] doubles = new double[split2.length];
                for (int j = 0; j < split2.length; j++) {
                    doubles[j] = Double.parseDouble(split2[j]);
                }
                matrix[i] = doubles;
            }
            calcNiMatrix(matrix);
        }
    }

    public static void calcNiMatrix(double[][] matrix) {
        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[1][0];
        double d = matrix[1][1];

        double temp = a * d - b * c;
        if (temp == 0) {
            System.out.println("None");
            return;
        }
        double[][] nMatrix = new double[matrix.length][matrix[0].length];
        nMatrix[0][0] = d / temp;
        nMatrix[0][1] = -b / temp;
        nMatrix[1][0] = -c / temp;
        nMatrix[1][1] = a / temp;
        printMatrix(nMatrix);
    }

    public static void printMatrix(double[][] matrix) {
        String line = "[";
        for (int i = 0; i < matrix.length; i++) {
            String temp = "[";
            for (int j = 0; j < matrix[0].length; j++) {
                temp = temp + matrix[i][j] + ", ";
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
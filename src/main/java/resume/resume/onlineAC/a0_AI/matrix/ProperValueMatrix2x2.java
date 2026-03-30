package resume.resume.onlineAC.a0_AI.matrix;

import java.util.Scanner;

public class ProperValueMatrix2x2 {

    /**
     * LA17 计算2x2矩阵的特征值
     * <a href="https://www.nowcoder.com/practice/d3d4db55f1f541a689bda29d54bf5db4?tpId=378&tqId=11118030&sourceUrl=%2Fexam%2Foj%3FquestionJobId%3D10%26subTabName%3Donline_coding_page">...</a>
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
            calcProperValueMatrix(matrix);
        }
    }

    /**
     * 可以求出通用公式
     */
    public static void calcProperValueMatrix(double[][] matrix) {
        double a = matrix[0][0];
        double b = matrix[0][1];
        double c = matrix[1][0];
        double d = matrix[1][1];
        double proper1 = (a + d + Math.sqrt(a * a + d * d - 2 * a * d + 4 * c * b)) / 2;
        double proper2 = (a + d - Math.sqrt(a * a + d * d - 2 * a * d + 4 * c * b)) / 2;
        System.out.println("[" + proper1 + ", " + proper2 + "]");
    }
}

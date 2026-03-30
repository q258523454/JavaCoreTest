package resume.resume.onlineAC.a0_AI.matrix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class GraySaleImageAvg {

    /**
     * CV287580 计算图像亮度
     * <a href="https://www.nowcoder.com/practice/f5368378abe24b2098bb06d11a5e5795?tpId=381&tqId=11127417&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DAI%25E7%25AF%2587%26topicId%3D378">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            double[][] inputMatrix = getInputMatrix(line);
            if (inputMatrix == null) {
                System.out.println("-1.00");
                continue;
            }

            boolean errorFlag = false;
            int colLength = inputMatrix[0].length;
            for (int i = 0; i < inputMatrix.length; i++) {
                if (inputMatrix[i].length != colLength) {
                    errorFlag = true;
                    break;
                }
            }
            if (errorFlag) {
                System.out.println("-1.00");
                continue;
            }
            int m = inputMatrix.length;
            int n = inputMatrix[0].length;

            double sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (inputMatrix[i][j] < 0 || inputMatrix[i][j] > 255) {
                        errorFlag = true;
                        break;
                    }
                    sum += inputMatrix[i][j];
                }
            }
            if (errorFlag) {
                System.out.println("-1.00");
                continue;
            }

            double avg = sum / (m * n);
            BigDecimal bigDecimal = new BigDecimal(avg);
            bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
            System.out.println(bigDecimal);
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
        if (split1.length <= 1) {
            return null;
        }
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

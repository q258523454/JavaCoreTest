package resume.resume.onlineAC.a0_AI.vectors;

import java.util.Scanner;

public class RectangularProjection {
    /**
     * LA10 实现向量到直线的正交投影
     * <a href="https://www.nowcoder.com/practice/968947df07f44f349f1b54d17d811fd1?tpId=378&tqId=11127423&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DAI%25E7%25AF%2587%26topicId%3D378">...</a>
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "");
            String[] split1 = line.split(",");
            double[] v = new double[split1.length];
            for (int i = 0; i < split1.length; i++) {
                v[i] = Double.parseDouble(split1[i]);
            }
            String line2 = sc.nextLine();
            line2 = line2.replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "");
            String[] split2 = line2.split(",");
            double[] L = new double[split2.length];
            for (int i = 0; i < split2.length; i++) {
                L[i] = Double.parseDouble(split2[i]);
            }
            double r1 = calcVL(L, L);
            double r2 = calcVL(v, L);
            double[] res = calcVectorMultiplyNumber(L, r2 / r1);
            print(res);
        }

    }

    private static void print(double[] res) {
        StringBuilder str = new StringBuilder("[");
        for (double re : res) {
            str.append(re).append(", ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 2));
        str.append("]");
        System.out.println(str);
    }

    public static double[] calcVectorMultiplyNumber(double[] v, double n) {
        double[] result = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            result[i] = v[i] * n;
        }
        return result;
    }

    public static double calcVL(double[] v1, double[] v2) {
        double sum = 0;
        for (int i = 0; i < v1.length; i++) {
            sum += v1[i] * v2[i];
        }
        return sum;
    }
}

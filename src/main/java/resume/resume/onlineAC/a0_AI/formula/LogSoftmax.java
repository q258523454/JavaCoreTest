package resume.resume.onlineAC.a0_AI.formula;

import java.math.BigDecimal;
import java.util.Scanner;

public class LogSoftmax {

    /**
     * DL4 Log Softmax函数的实现
     * 注意:
     * Math.log 就是 e 为底数
     * <a href="https://www.nowcoder.com/practice/a8a0934f25f04c7e97d64d3e1b77219a?tpId=380&tqId=11127647&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DAI%25E7%25AF%2587%26topicId%3D378">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replaceAll("\\s+", "");
            line = line.replaceAll("\\[", "").replaceAll("]", "");
            String[] split1 = line.split(",");
            double[] array = new double[split1.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Double.parseDouble(split1[i]);
            }

            double sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += Math.pow(Math.E, array[i]);
            }
            double p2 = Math.log(sum);
            double[] result = new double[array.length];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i] - p2;
            }

            printArray(result);
        }
    }

    public static void printArray(double[] array) {
        String temp = "[";
        for (int i = 0; i < array.length; i++) {
            BigDecimal bigDecimal = new BigDecimal(array[i]);
            bigDecimal = bigDecimal.setScale(8, BigDecimal.ROUND_HALF_UP);
            temp += bigDecimal + " ";
        }
        temp = temp.substring(0, temp.length() - 1);
        temp += "]";
        System.out.println(temp);
    }
}

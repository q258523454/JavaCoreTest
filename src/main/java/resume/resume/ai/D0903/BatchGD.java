package resume.resume.ai.D0903;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BatchGD {

    /**
     * 5
     * dev1,NaN,50,NaN,-2.0,25,0
     * dev2,180,90,18.0,9.0,4.0,0
     * dev3,NaN,80,1500.0,800.0,NaN,0
     * dev4,-100,-50,-5.0,-2.0,-1,0
     * dev5,200,NaN,20.0,NaN,5,1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String[]> list = new ArrayList<>();
        List<List<Double>> sortList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sortList.add(new ArrayList<>());
            sortList.get(i).sort((o1, o2) -> Double.compare(o2, o1));
        }

        double[] sum = new double[7];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] split = str.split(",");
            list.add(split);
            for (int j = 1; j < 6; j++) {
                if (!split[j].equals("NaN")) {
                    double temp = Double.parseDouble(split[j]);
                    sum[j - 1] = sum[j - 1] + temp;
                    sortList.get(j - 1).add(temp);
                }
            }
        }
        double[] avg = new double[5];
        double[] mean = new double[5];

        for (int i = 0; i < 5; i++) {
            avg[i] = sum[i] / n;
        }

        for (int i = 0; i < sortList.size(); i++) {
            List<Double> doubles = sortList.get(i);
            doubles.sort((o1, o2) -> Double.compare(o2, o1));
            mean[i] = doubles.get(n / 2);
        }

        System.out.println(JSON.toJSONString(avg));
        for (String[] temp : list) {
            for (int j = 1; j <= 5; j++) {
                if (temp[j].equalsIgnoreCase("NaN")) {
                    temp[j] = avg[j - 1] + "";
                }
                if ((j == 1 || j == 2) && Double.parseDouble(temp[j]) < 0) {
                    temp[j] = mean[j - 1] + "";
                }
                if ((j == 3 || j == 4) && ((Double.parseDouble(temp[j]) < 0) || Double.parseDouble(temp[j]) > 1000)) {
                    temp[j] = mean[j - 1] + "";
                }
                if ((j == 5) && ((Double.parseDouble(temp[j]) < 0) || Double.parseDouble(temp[j]) > 1000)) {
                    temp[j] = mean[j - 1] + "";
                }
            }
        }
    }
}

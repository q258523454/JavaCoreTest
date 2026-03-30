package resume.resume.ai.D0827;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KNN {
    /**
     * 题目可参考:
     * <a href="https://mp.weixin.qq.com/s/zgx-jeSE4JB_u1KJBDjNJg">...</a>
     * 题目: 标签样本数量
     * 输入描述
     * 第1行：k m n s:
     * 第2行：待分类样本
     * 第3行~第m十2行：m个样本，每一行n+1列，最后一列为类别标签label
     * 输入例子1：
     * 3 6 2 2
     * 0.00 0.00
     * 0.20 0.10 0.0
     * 0.30 0.00 0.0
     * 0.00 0.40 1.0
     * 0.60 0.60 1.0
     * 0.05 0.02 0.0
     * 0.90 0.90 1.0
     * 输出例子1：
     * 0 3
     * 例子说明1：
     * 距离最近的 3 个样本依次为 (0.05,0.02,0), (0.20,0.10,0), (0.30,0.00,0)。
     * 多数票为标签 0，且在前 K=3 个邻居中出现 3 次，故输出“0 3”。
     *
     * 输入例子2：
     * 4 6 2 3
     * 1.00 1.00
     * 0.95 0.95 2.0
     * 1.10 1.00 2.0
     * 0.90 1.10 1.0
     * 0.80 0.90 1.0
     * 2.00 2.00 3.0
     * 1.30 1.40 1.0
     * 输出例子2：
     * 2 2
     * 例子说明2：
     * 最近的 4 个邻居按距离为：(0.95,0.95,2)、(1.10,1.00,2)、(0.90,1.10,1)、(0.80,0.90,1)。
     * 标签 1 与 2 在前 K=4 中均出现 2 次，构成并列；比较并列集合中“最近”的样本，其最近者为 (0.95,0.95,2)
     * 因此最终返回标签 2；同时输出该标签在前 K 中出现的次数 2。
     */
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String[] split = sc.nextLine().split(" ");
            int k = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int n = Integer.parseInt(split[2]);
            int s = Integer.parseInt(split[3]);
            String[] split2 = sc.nextLine().split(" ");
            List<Double> classifyNodeList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                classifyNodeList.add(Double.parseDouble(split2[i]));
            }
            KNode classifyNode = new KNode(classifyNodeList, null);

            List<KNode> kNodeList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] tempSplit = sc.nextLine().split(" ");
                List<Double> tempList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    tempList.add(Double.parseDouble(tempSplit[j]));
                }
                kNodeList.add(new KNode(tempList, Double.parseDouble(tempSplit[n])));
            }

            Queue<KNodeDistance> queue = new PriorityQueue<>(new Comparator<KNodeDistance>() {
                @Override
                public int compare(KNodeDistance o1, KNodeDistance o2) {
                    return Double.compare(o1.distance, o2.distance);
                }
            });

            for (KNode kNode : kNodeList) {
                double distance = calcDistance(classifyNode, kNode);
                KNodeDistance kNodeDistance = new KNodeDistance(distance, kNode.label);
                queue.add(kNodeDistance);
            }

            Map<Double, Integer> kLabelCountMap = new LinkedHashMap<>();
            int maxCount = 0;
            for (int i = 0; i < k; i++) {
                KNodeDistance kNodeDistance = queue.poll();
                int count = 1;
                if (kLabelCountMap.containsKey(kNodeDistance.label)) {
                    count = kLabelCountMap.get(kNodeDistance.label) + 1;
                    kLabelCountMap.put(kNodeDistance.label, count);
                } else {
                    kLabelCountMap.put(kNodeDistance.label, count);
                }
                if (maxCount < count) {
                    maxCount = count;
                }
            }

            for (Map.Entry<Double, Integer> doubleIntegerEntry : kLabelCountMap.entrySet()) {
                if (doubleIntegerEntry.getValue() == maxCount) {
                    Double label = doubleIntegerEntry.getKey();
                    int count = doubleIntegerEntry.getValue();
                    BigDecimal bLabel = new BigDecimal(label).stripTrailingZeros();
                    System.out.println(bLabel + " " + count);
                    break;
                }
            }
        }
    }

    public static class KNode {
        public List<Double> pix;
        public Double label;

        public KNode(List<Double> pix, Double label) {
            this.pix = pix;
            this.label = label;
        }
    }

    public static class KNodeDistance {
        public Double distance;
        public Double label;

        public KNodeDistance(Double distance, Double label) {
            this.distance = distance;
            this.label = label;
        }
    }

    public static double calcDistance(KNode a, KNode b) {
        List<Double> aPix = a.pix;
        List<Double> bPix = b.pix;
        double distance = 0;
        for (int i = 0; i < aPix.size(); i++) {
            double temp = aPix.get(i) - bPix.get(i);
            distance = distance + Math.pow(temp, 2);
        }
        return distance;
    }
}
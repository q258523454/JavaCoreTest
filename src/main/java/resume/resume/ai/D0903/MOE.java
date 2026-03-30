package resume.resume.ai.D0903;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MOE {
    /**
     * 题目参考:
     * https://mp.weixin.qq.com/s/OeX33IxvH_IQhltPssg3-w
     *
     * 8 4 4 2
     * 0.5 0.01 0.09 0.023 0.027 0.05 0.1 0.2
     */
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int k = sc.nextInt();

            if (m <= 0 || n / m <= 0 || n < k || n < p) {
                System.out.println("ERROR");
                return;
            }
            List<Double> orgList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                orgList.add(sc.nextDouble());
            }
            System.out.println("orgList" + JSON.toJSONString(orgList));
            calc(n, m, p, k, orgList);
        }
    }


    static class GroupMaxAndIndex {
        int index;
        double value;

        public GroupMaxAndIndex(int index, double value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public double getValue() {
            return value;
        }
    }


    private static void calc(int n, int m, int p, int k, List<Double> orgList) {
        int groupSize = n / m;
        System.out.println("group size: " + groupSize);

        List<Queue<GroupMaxAndIndex>> everySingleGroupQueue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            // 降序
            Queue<GroupMaxAndIndex> queue = new PriorityQueue<>(new Comparator<GroupMaxAndIndex>() {
                @Override
                public int compare(GroupMaxAndIndex o1, GroupMaxAndIndex o2) {
                    return Double.compare(o2.getValue(), o1.getValue());
                }
            });
            everySingleGroupQueue.add(queue);
        }

        int j = -1;
        for (int i = 0; i < orgList.size(); i++) {
            if (i % groupSize == 0) {
                j++;
            }
            everySingleGroupQueue.get(j).add(new GroupMaxAndIndex(i, orgList.get(i)));
        }
        System.out.println("everySingleGroupQueue" + JSON.toJSONString(everySingleGroupQueue));

        Queue<GroupMaxAndIndex> groupMaxAndIndexQueue = new PriorityQueue<>(new Comparator<GroupMaxAndIndex>() {
            @Override
            public int compare(GroupMaxAndIndex o1, GroupMaxAndIndex o2) {
                return Double.compare(o2.value, o1.value);
            }
        });
        for (int i = 0; i < everySingleGroupQueue.size(); i++) {
            double maxValue = everySingleGroupQueue.get(i).peek().getValue();
            groupMaxAndIndexQueue.add(new GroupMaxAndIndex(i, maxValue));
        }

        List<Integer> groupIndexList = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            groupIndexList.add(groupMaxAndIndexQueue.poll().getIndex());
        }
        System.out.println("groupIndexList" + JSON.toJSONString(groupIndexList));

        Queue<GroupMaxAndIndex> sortAllQueue = new PriorityQueue<>(new Comparator<GroupMaxAndIndex>() {
            @Override
            public int compare(GroupMaxAndIndex o1, GroupMaxAndIndex o2) {
                return Double.compare(o2.value, o1.value);
            }
        });

        for (Integer index : groupIndexList) {
            Queue<GroupMaxAndIndex> temp = everySingleGroupQueue.get(index);
            while (!temp.isEmpty()) {
                sortAllQueue.add(temp.poll());
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(sortAllQueue.poll().getIndex());
        }
    }
}

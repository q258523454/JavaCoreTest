package javacore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-28
 */
public class ThreadStudy {
    private List<String> names = new ArrayList<>();

    private synchronized void add(String name) {
        names.add(name);
    }

    private synchronized void printAll() {
        for (Object name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final ThreadStudy ts = new ThreadStudy();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ts.add("小");
                    ts.add("刀");
                    ts.add("哥");
                    ts.printAll();
                }
            });
            thread.start();
        }
    }
}

package javacore.baseimpro.high_concurrency.t2_multi_thread.t99_practical.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-07
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int temvalue = 0;
        int[] nums = {1, 2, 3, 4, 5, 6};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.print(atomicIntegerArray.get(j) + " ");
        }
        System.out.println();
        temvalue = atomicIntegerArray.getAndSet(0, 2);
        System.out.println("temvalue:" + temvalue + ";  i:" + atomicIntegerArray);
        temvalue = atomicIntegerArray.getAndIncrement(0);
        System.out.println("temvalue:" + temvalue + ";  i:" + atomicIntegerArray);
        temvalue = atomicIntegerArray.getAndAdd(0, 5);
        System.out.println("temvalue:" + temvalue + ";  i:" + atomicIntegerArray);
    }
}

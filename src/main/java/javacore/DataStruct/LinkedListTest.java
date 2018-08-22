package javacore.DataStruct;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by mac on 17/7/24.
 */
public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<String> a = new LinkedList<>();
        LinkedList<String> b = new LinkedList<>();

        a.add("a");
        a.add("b");
        a.add("c");

        b.add("A");
        b.add("B");
        b.add("C");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }

        System.out.println(a);



        LinkedList<String> c = new LinkedList<>();
        c.add("A");
        c.add("B");
        ListIterator<String> cIter=c.listIterator();
        System.out.println(cIter.next());

        c.removeAll(b);
        System.out.println(c);
    }

}

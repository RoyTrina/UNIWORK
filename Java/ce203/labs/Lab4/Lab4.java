package labs.Lab4;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Lab4 {
    private static <T extends Comparable<T>> int smallest(List<T> l) {
        // should not do this!
        if (l.size() == 0) {
            return 0;
        } else {
            Iterator<T> it = l.iterator();
            T smallestSoFar = it.next();
            T temp;
            int smallestPos = 0;
            int i = 1; //used to indicate position in list of next item
            while (it.hasNext()) {
                // compare next item with smallest so far
                // if it's smaller update smallestSoFar and smallestPos
                temp = it.next();
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Vector<String> vec1 = new Vector<>();
        vec1.add("Hello");
        vec1.add("world");
        vec1.add("xxxx");
        vec1.add("aardvark");
        int smallPos = smallest(vec1);
        if (smallPos != -1)
            System.out.println("smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos);
        Vector<Integer> vec2 = new Vector<>();
        vec2.add(47);
        vec2.add(17);
        vec2.add(399);
        vec2.add(247);
        smallPos = smallest(vec2);
        if (smallPos != -1)
            System.out.println("smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos);
    }
}

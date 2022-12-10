package lectures_programs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Lecture6 {

    public static final List<String> nameList = new ArrayList<>();

    public static void main(String[] args) {
        wrapping();
        workingWithLists();
        forEachLoop();
        autoBoxingAndRemove();
        getAndSet();
        testListIterators();
        testRemDuplicates();
        testRawList();
    }

    public static void wrapping() {
        Integer answer = 42;
        int answerAsInt = answer;
        System.out.println("### Wrapping Integers");
        System.out.println(answer + " " + answerAsInt + "\n");
        int x, y;
        x = 12; // x boxed to Integer
        y = 15; // y boxed to Integer
        System.out.println(x + y); // x, y unboxed so that addition can be performed
    }

    public static void workingWithLists() {
        System.out.println("### Working with lists");
        System.out.println("nameList= " + nameList);
        nameList.add("Alice"); // Add Alice
        System.out.println("nameList= " + nameList);
        nameList.add("Clara"); // Add Clara to end of list
        System.out.println("nameList= " + nameList);
        nameList.add("David"); // Add David to end of list
        System.out.println("nameList= " + nameList);
        nameList.add(1, "Bill"); // Insert Bill at position 1
        System.out.println("nameList= " + nameList);
        nameList.add("Donald"); // Add Donald to end of list
        System.out.println("nameList= " + nameList);
        nameList.remove("David"); // Remove David
        System.out.println("nameList= " + nameList);
        nameList.remove(2); // Remove third element
        System.out.println("nameList2= " + nameList);
        String s = nameList.get(1); // Gets 2nd element
        System.out.println("nameList.get(1)= " + s);
        nameList.set(2, "Chris"); // Sets 3rd element to Chris
        System.out.println("nameList= " + nameList);
        int whereIsDonald = nameList.indexOf("Donald");
        System.out.println("whereIsDonald= " + whereIsDonald);
        int occ = nameList.indexOf("Bill");
        System.out.println("First occurrence of new String(\"Bill\") is " + occ);
        System.out.println();
    }

    public static void getAndSet() {
        System.out.println("### get and set");
        System.out.println("nameList=" + nameList);
        System.out.println("nameList.get(1)=" + nameList.get(1));
        System.out.println("nameList.set(1);");
        nameList.set(2, "Claire");
        System.out.println("nameList=" + nameList + "\n");
    }

    public static void forEachLoop() {
        System.out.println("### for (each) loop on lists");
        List<Integer> xs = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++)
            xs.add(rnd.nextInt(6));
        double sum = 0;
        for (Integer d : xs)
            sum += d;
        System.out.println("sum" + xs + " = " + sum + "\n");
    }

    public static void autoBoxingAndRemove() {
        System.out.println("### Autoboxing and remove");
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(2);
        intList.add(5);
        intList.add(7);
        intList.add(4);
        System.out.println("intList= " + intList);
        intList.remove(2);
        System.out.println("intList.remove(2);");
        System.out.println("intList= " + intList);
        intList.remove(Integer.valueOf(2));
        System.out.println("intList.remove(new(Integer(2));");
        System.out.println("intList= " + intList);
        System.out.println();
    }

    public static <E> void remDuplicates(List<E> xs) {
        List<E> seen = new ArrayList<>();
        ListIterator<E> it = xs.listIterator();
        while (it.hasNext()) {
            E e = it.next();
            if (seen.contains(e))
                it.remove();
            else
                seen.add(e);
        }
    }

    public static void testRemDuplicates() {
        System.out.println("### testing remDuplicates");
        Random rnd = new Random();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(rnd.nextInt(5) - 2);
        }
        System.out.println("integers= " + integers);
        remDuplicates(integers);
        System.out.println("integers= " + integers + "\n");
    }

    public static void testListIterators() {
        System.out.println("### ListIterator");
        System.out.println("nameList= " + nameList);
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            nameList.set(i, name.toUpperCase());
        }
        System.out.println("nameList= " + nameList);
        ListIterator<String> inter = nameList.listIterator();
        while (inter.hasNext()) {
            String element = inter.next();
            inter.set(element.toLowerCase());
        }
        System.out.println("nameList= " + nameList + "\n");
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void testRawList() {
        System.out.println("### testing raw list");
        List myList = new ArrayList();
        myList.add("Alfred");
        myList.add(28);
        System.out.println(myList);
        String name = (String) myList.get(0);
        int age = (int) myList.get(1);
        System.out.println("name= " + name + ",age= " + age + "\n");
    }

}

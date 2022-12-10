package lectures_programs;

import java.util.*;

public class Lecture7 {

    public static double average(double x, double y) {
        return (x + y) / 2;
    }

    public double average(double[] x) {
        if (x.length == 0)
            return 0;
        double sum = 0;
        for (double d : x)
            sum += d;
        return sum / x.length;
    }

    public double average(Collection<Double> x) {
        if (x.size() == 0)
            return 0;
        double sum = 0;
        for (double d : x)
            sum += d;
        return sum / x.size();
    }

    public static Set<Integer> lottoNumbers() {
        Random rnd = new Random();
        final int MAX_LOTTO = 49;
        Set<Integer> result = new TreeSet<>();
        for (int i = 0; i < 6; ) {
            int number = 1 + rnd.nextInt(MAX_LOTTO);
            if (result.add(number))
                i++;
        }
        return result;
    }

    private static List<Integer> randomIntegers() {
        Random rnd = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            result.add(rnd.nextInt(10));
        return result;
    }

    public static void hashCodeExamples() {
        System.out.println("### hashCode");
        String[] names = {"Anna", "Bertie", "Charles", "David"};
        for (String name : names)
            System.out.println(name + " " + name.hashCode());
    }

    private static <E> Map<E, Integer> freq(List<E> x) {
        Map<E, Integer> map = new HashMap<>();
        for (E e : x) {
            Integer f = map.get(e);
            int value = f == null ? 1 : f + 1;
            map.put(e, value);
        }
        return map;
    }

    public static void freqExample() {
        System.out.println("### freq");
        List<Integer> numbers = randomIntegers();
        System.out.println(numbers);
        System.out.println(freq(numbers));
    }

    public static void mapExample() {
        System.out.println("### map");
        Map<String, Integer> phones = new TreeMap<>();
        phones.put("Charles", 5678);
        phones.put("Anna", 1234);
        phones.put("Bertie", 2345);
        // Changing value associated with a key
        phones.put("Anne", 5678);
        System.out.println(phones);

        for (Map.Entry<String, Integer> entry : phones.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " -> " + value);
        }

        int bertiesNumber = phones.get("Bertie");
        System.out.println("Bertie's phone number: " + bertiesNumber);
        phones.remove("Bertie");
        System.out.println("keySet= " + phones.keySet());
    }

    public static void treeMapExceptionExample() {
        System.out.println("### Treemap example with ClassCastException");
        Map<Circle, Integer> myMap = new TreeMap<>();
        myMap.put(new Circle(10, 10, 10), 1);
        System.out.println(myMap);

    }


    private static void treeSetExceptionExample() {
        System.out.println("### Tree set example with ClassCastException");
        Set<Shape> mySet = new TreeSet<>();
        mySet.add(new Circle(10, 10, 10));
        System.out.println(mySet);
    }

    public static void main(String[] args) {
        System.out.println("### lottoNumbers " + lottoNumbers());
        hashCodeExamples();
        mapExample();
        freqExample();
        treeSetExceptionExample();
        average(46.5, 9.9);
        treeMapExceptionExample();
        treeSetExceptionExample();
        //treeMapExample();

    }

}

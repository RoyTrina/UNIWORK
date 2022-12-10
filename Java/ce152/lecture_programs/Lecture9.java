package lectures_programs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lecture9 {
    public static void main(String[] args) {
        time(Lecture9::fac, "fac", 20);
        time(Lecture9::facIter, "facIter", 20);
        timeFibs(38);
        qsortTest2();
    }

    public static <A, B> void time(Function<A, B> function, String name, A argument) {
        System.out.println("### Executing " + name + "(" + argument + ")");
        long t0 = System.nanoTime();
        B result = function.apply(argument);
        long t1 = (System.nanoTime() - t0) / 1000;
        System.out.println("Result:  " + result);
        System.out.println("Time taken: " + t1 + " microseconds\n ");
    }

    public static <A> void timeConsumer(Consumer<A[]> consumer, String name, A[] argument) {
        System.out.println("### Executing " + name + "\n" + Arrays.toString(argument));
        long t0 = System.nanoTime();
        consumer.accept(argument);
        long t1 = (System.nanoTime() - t0) / 1000;
        System.out.println("Result: " + Arrays.toString(argument));
        System.out.println("Time taken: " + t1 + " microseconds ");
    }

    public static void timeFibs(int n) {
        time(Lecture9::fib, "fib", n);
        time(Lecture9::fibCached, "fibCached", n);
        time(Lecture9::fibIter, "fibIter", n);
    }

    public static void qsortTest() {
        Integer[] xs = new Integer[20];
        for (int i = 0; i < 20; i++)
            xs[i] = (int) (Math.random() * 50);
        timeConsumer(Lecture9::qsort, "qsort", xs);
    }

    public static void qsortTest2() {
        Character[] xs = new Character[]{'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        timeConsumer(Lecture9::qsort, "qsort", xs);
    }

    public static long fac(int n) {
        if (n == 0)
            return 1;
        else
            return n * fac(n - 1);
    }

    public static long facIter(int n) {
        long result = 1;
        while (n > 0)
            result *= n--;
        return result;
    }

    public static long fib(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static long fibIter(int n) {
        if (n < 2)
            return n;
        long[] f = new long[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }

    public static long fibCached(int n) {
        return fibCached(n, new Long[n + 1]);
    }

    public static long fibCached(int n, Long[] res) {
        if (n < 2)
            return n;
        if (res[n] == null)
            res[n] = fibCached(n - 1, res) + fibCached(n - 2, res);
        return res[n];
    }

    // Quicksort on Arrays

    public static <E extends Comparable<E>> void qsort(E[] a) {
        qsort(a, 0, a.length - 1);
    }

    private static <E extends Comparable<E>> void qsort(E[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int pivotIndex = (lo + hi) / 2;
        System.out.println("qsort(" + Arrays.toString(a) + ", " + lo + ", " + hi + ")");
        System.out.println("// pivot index= " + pivotIndex + ", pivot= " + a[pivotIndex]);
        exch(a, lo, pivotIndex); // use middle element as partition
        int last = lo;
        for (int i = lo + 1; i <= hi; i++)
            if (a[i].compareTo(a[lo]) < 0) {
                last++;
                exch(a, last, i);
            }
        exch(a, lo, last);
        qsort(a, lo, last - 1);
        qsort(a, last + 1, hi);
    }

    // exchange a[i] and a[j]
    private static <E> void exch(E[] a, int i, int j) {
        E swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // WARNING: INCORRECT METHOD FOR BUG FINDING EXAMPLE
    public static <E> boolean isPermutation(List<E> xs, List<E> ys) {
        return xs.size() == ys.size() && xs.containsAll(ys) && ys.containsAll(xs);
    }

}

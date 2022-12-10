package lectures_programs;

public class MyMath {
    public static double square(double x) {
        return x * x;
    }

    // array addition without side effect
    public static double[] add(double[] a, double[] b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i] + b[i];
        return c;
    }

    // array addition with side-effect
    // the result is written to an array passed as parameter
    public static void add(double[] a, double[] b, double[] c) {
        for (int i = 0; i < a.length; i++)
            c[i] = a[i] + b[i];
    }

}

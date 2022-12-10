package lectures_programs;

import java.util.Arrays;

public class Lecture3 {

    public static void main(String[] args) {
        weekdays();
        intArray();
        doubleArray();
        arrayCopying();
        garbageCollection();
        deckOfCards();
        twoDimArrays();
        matrixMult();
        pascal();
        raggedArray();
        testAdd();
    }

    public static void weekdays() {
        String[] days;
        days = new String[7];

        days[0] = "Sunday";
        days[1] = "Monday";
        days[2] = "Tuesday";
        days[3] = "Wednesday";
        days[4] = "Thursday";
        days[5] = "Friday";
        days[6] = "Saturday";
        System.out.println("days: ");
        for (String day : days)
            System.out.println(day);

        String[] days2 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println("days2.length= " + days2.length);
    }

    public static void intArray() {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (100 * Math.random());
        System.out.println(Arrays.toString(a));
        for (int j : a) System.out.println(j);
        int max = Integer.MIN_VALUE;
        for (int j : a)
            if (j > max)
                max = j;
        System.out.println("max = " + max);

        for (int elem : a)
            System.out.println(elem);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void doubleArray() {
        double[] myArray = new double[10];
        for (int i = 0; i < myArray.length; i++)
            myArray[i] = 100 * Math.random();
        System.out.println(Arrays.toString(myArray));
        double sum = 0;
        for (double v : myArray) sum += v;
        double mean = sum / myArray.length;
        System.out.println("mean = " + mean);
        double max = Double.NEGATIVE_INFINITY;
        for (double v : myArray)
            if (v > max)
                max = v;
        System.out.println("max = " + max);
        System.out.println(Arrays.toString(myArray));
    }

    public static void arrayCopying() {
        int[] a = {3, 1, 4, 1, 5, 9};
        a[0] = -1;
        System.out.println("a[0]=" + a[0]);
        int[] c = new int[a.length];
        System.arraycopy(a, 0, c, 0, a.length);
    }

    public static void garbageCollection() {
        int[] alpha;
        int[] beta = {4, 1, 5, 9};
        alpha = beta;
        System.out.println(Arrays.toString(alpha));
        System.out.println(Arrays.toString(beta));
    }

    public static void deckOfCards() {
        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        // constants
        int SUITS = suit.length;
        int RANKS = rank.length;
        String[] deck = new String[SUITS * RANKS];
        for (int i = 0; i < RANKS; i++)
            for (int j = 0; j < SUITS; j++)
                deck[SUITS * i + j] = rank[i] + " of " + suit[j];
        for (String s : deck)
            System.out.println(s);
        for (int i = deck.length - 1; i > 0; i--) {
            int r = (int) (Math.random() * (i + 1));
            String c = deck[i];
            deck[i] = deck[r];
            deck[r] = c;
        }
        for (String s : deck)
            System.out.println(s);
    }

    public static void twoDimArrays() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        for (int i = 0; i < a.length; i++)
            System.out.println("a[" + i + "]=" + Arrays.toString(a[i]));
        final int ROWS = 10;
        final int COLS = 5;
        double[][] randomArray = new double[ROWS][COLS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                randomArray[i][j] = Math.random();
        // printing it
        for (double[] row : randomArray)
            System.out.println(Arrays.toString(row));
    }

    public static void matrixMult() {
        final int N = 3;
        int[][] a = {{1, 0, 0}, {0, 1, 1}, {0, 1, -1}};
        int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    c[i][j] += a[i][k] * b[k][j];
        System.out.println(Arrays.deepToString(c));
    }

    public static void raggedArray() {
        double[][] pascal = new double[6][];
        pascal[0] = new double[]{1};
        pascal[1] = new double[]{1, 1};
        pascal[2] = new double[]{1, 2, 1};
        pascal[3] = new double[]{1, 3, 3, 1};
        pascal[4] = new double[]{1, 4, 6, 4, 1};
        pascal[5] = new double[]{1, 5, 10, 10, 5, 1};
        System.out.println(Arrays.deepToString(pascal));
    }

    public static void pascal() {
        final int ROWS = 6;
        int[][] pt = new int[ROWS][];
        for (int i = 0; i < ROWS; i++) {
            pt[i] = new int[i + 1];
            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i)
                    pt[i][j] = 1;
                else
                    pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
        }
        for (int[] row : pt)
            System.out.println(Arrays.toString(row));
    }

    public static void testAdd() {
        System.out.println("testAdd");
        System.out.println("Without side effect");
        double[] myArray = MyMath.add(new double[]{1.0, 2.0}, new double[]{3.0, 4.0});
        System.out.println(Arrays.toString(myArray));

        // reset variable
        myArray = new double[2];
        System.out.println("With modification of array");
        MyMath.add(new double[]{1.0, 2.0}, new double[]{3.0, 4.0}, myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void testSquare() {
        double x = MyMath.square(256);
        System.out.println("MyMath.square(256) = " + x);
    }

}

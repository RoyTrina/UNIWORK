package ResitAss;

import java.util.Arrays;

/**
 * Created by tr17548 on 23/04/2018.
 * Modified by tr17548 on 25/03/2020.
 */
public class Exercise2 {
    public int[][] array = {{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}};
    public static int rows = 0;
    public static int cols = 0;
    public static int sumRow;
    public static int sumCol;

    public static void main(String[] args) {
        int[][] testArray = {{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}};
        for (int[] ints : testArray) System.out.println(Arrays.toString(ints));
        System.out.println("sum = " + Arrays.toString(sum(testArray)));
        System.out.println("rowSum = " + Arrays.toString(rowSums(testArray)));
        System.out.println("colSum = " + Arrays.toString(columnSums(testArray)));
    }

    private static int[] sum(int[][] array) {
        rows = array.length;
        cols = array[0].length;

        return new int[sumRow + sumCol];
    }

    public static int[] rowSums(int[][] array) {
        rows = array.length;
        cols = array[0].length;

        for (int i = 0; i < rows; i++) {
            sumRow = 0;
            for (int e = 0; e < cols; e++) {
                sumRow = sumRow + array[i][e];
            }
        }
        return new int[]{sumRow};
    }

    public static int[] columnSums(int[][] array) {
        rows = array.length;
        cols = array[0].length;


        return new int[]{sumCol};
    }
}

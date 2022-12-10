package Assignment2019;

//Date of backup: 14/12/2019

public class Exercise1 {
    public static int mainDiagonalElementSum(int[][] array) {
        while (true) {
            try {
                int[][] test_array = new int[][]{{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}, {2, 1, 6, -2}};
                int sum;
                sum = test_array[0][0] + test_array[1][1] + test_array[2][2] + test_array[3][3];

                System.out.println("The sum is " + sum);

                /*//This is for checking purposes
                if (sum == 17) {
                    System.out.println("This is working!");
                    return sum;}
                    else {
                        System.out.println("This needs to work.")
                        }*/
            } catch (NumberFormatException ex) {
                System.out.println();
            }
            throw new NumberFormatException();
        }
    }

    public static int maxRowAbsSumValue(int[][] array) {
        while (true) {
            int[][] test_array = array;
            test_array = new int[][]{{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}, {2, 1, 6, -2}};

            int sumR0;
            sumR0 = test_array[0][0] + test_array[0][1] + test_array[0][2] + test_array[0][3];

            int sumR1;
            sumR1 = test_array[1][0] + test_array[1][1] + test_array[1][2] + test_array[1][3];

            int sumR2;
            sumR2 = test_array[2][0] + test_array[2][1] + test_array[2][2] + test_array[2][3];

            int sumR3 = test_array[3][0] + test_array[3][1] + test_array[3][2] + test_array[3][3];

            /*//This is for checking purposes
            if (sumR0 == 6) {
                System.out.println("The sum of " + "sumR0" + " is 6.");
            } else {
                System.out.println("This needs to work.");
            }

            if (sumR1 == 18) {
                System.out.println("The sum of " + "sumR1" + " is 18.");
            } else {
                System.out.println("This needs to work.");
            }

            if (sumR2 == 7 && sumR3 == 7) {
                System.out.println("The sum of " + "sumR2" + " and " + "sumR3" + "is 7.");
            } else {
                System.out.println("This needs to work");
            }*/
            return Math.abs(Math.max(Math.max(sumR0, sumR1), Math.max(sumR2, sumR3)));
        }
    }

    public static int maxColumnAbsSumValue(int[][] array) {
        while (true) {
            int[][] test_array = array;
            test_array = new int[][]{{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}, {2, 1, 6, -2}};

            int sumC0;
            sumC0 = test_array[0][0] + test_array[1][0] + test_array[2][0] + test_array[3][0];

            int sumC1;
            sumC1 = test_array[0][1] + test_array[1][1] + test_array[2][1] + test_array[3][1];

            int sumC2;
            sumC2 = test_array[0][2] + test_array[1][2] + test_array[2][2] + test_array[3][2];

            int sumC3;
            sumC3 = test_array[0][3] + test_array[1][3] + test_array[2][3] + test_array[3][3];

                /*//This is for checking purposes
                if (sumC0 == 15 && sumC2 == 15) {
                    System.out.println("The sum of " + sumC0 + "and " + sumC2 + "is 15.");
                } else {
                    System.out.println("This needs to work.");
                }

                if (sumC1 == 12) {
                    System.out.println("This is working!");
                } else {
                    System.out.println("This needs to work.");
                }

                if (sumC3 == -4) {
                    System.out.println("This is working!");
                } else {
                    System.out.println("This needs to work");
                }*/
            return Math.abs(Math.max(Math.max(sumC0, sumC1), Math.max(sumC2, sumC3)));
        }
    }

    public static void main(String[] args) {
        int[][] test_array;
        test_array = new int[][]{{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}, {2, 1, 6, -2}};

        //mainDiagonalElementSum(test_array);
        //maxRowAbsSumValue(test_array);
        maxColumnAbsSumValue(test_array);
    }
}
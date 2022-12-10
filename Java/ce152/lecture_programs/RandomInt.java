package lectures_programs;

import java.util.Scanner;

public class RandomInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer:");
        int n = input.nextInt();
        double r1 = Math.random();
        int r2 = (int) (r1 * n);
        System.out.println("random integer is " + r2);
        input.close();
    }
}


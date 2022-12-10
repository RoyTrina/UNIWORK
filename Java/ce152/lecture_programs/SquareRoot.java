package lectures_programs;

import java.util.Scanner;

public class SquareRoot {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter a double:");
        double epsilon = 1e-15;
        double c = input.nextDouble();
        double t = c;
        int count = 0;
        while (Math.abs(c - t * t) > epsilon) {
            t = (c / t + t) / 2.0;
            count++;
        }
        System.out.println("result= " + t);
        System.out.println("count= " + count);
        input.close();
    }

}

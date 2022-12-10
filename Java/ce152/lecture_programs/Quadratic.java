package lectures_programs;

import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        // read coefficients from console

        System.out.println("Solving x*x + b * x + c = 0:");
        System.out.println("Please enter coefficients b and c:");
        Scanner input = new Scanner(System.in);
        double b = input.nextDouble();
        double c = input.nextDouble();
        // calculate roots and print them
        double discriminant = b * b - 4.0 * c;
        double d = Math.sqrt(discriminant);
        double root1 = (-b + d) / 2.0;
        double root2 = (-b - d) / 2.0;
        System.out.println(root1);
        System.out.println(root2);
        input.close();
    }
}

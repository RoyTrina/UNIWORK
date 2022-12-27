package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int i = scan.nextInt();

        System.out.println("Enter second number: ");
        int j = scan.nextInt();

        int result = tet.add(i, j);
        System.out.println("The addition is " + result);

        int sub_result = tet.subtract(i, j);
        System.out.println("The subtraction is " + sub_result);

        int prod_result = tet.prod(i, j);
        System.out.println("The multiplication is " + prod_result);

        int division_result = tet.divide(i, j);
        System.out.println("The division is " + division_result);
    }
}

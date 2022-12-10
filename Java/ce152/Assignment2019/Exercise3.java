package Assignment2019;
//Date of backup: 14/12/2019

import java.util.Scanner;

public class Exercise3 {
    public static boolean isNarcissisticNumber(int number) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: \n");
        System.out.println("Enter the number of digits: \n");

        number = input.nextInt();
        int digit = input.nextInt();
        int count = 0;

        while (number > 0) {
            number = number / 10;
            count = count + 1;
        }


        int sum = (int) Math.pow(number, digit);

        if (number == sum) {
            System.out.println("The number " + number + " is narcissistic.");
        }
        return true;
    }

    public static int sum() {
        Scanner input = new Scanner(System.in);
        int current_number = 0;
        int previous_number = 0;
        int number = input.nextInt();
        int sum = current_number + previous_number + number;
        return sum();
    }

    public static void main(String[] args) {
        //isNarcissisticNumber();
        // sum();
    }
}

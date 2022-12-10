package Assignment2019;
//Date of backup: 14/12/2019

import java.util.Random;
import java.util.Scanner;

public class Exercise2 {
    private static void partA() {

        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Exercise 2A \n");

        for (int i = 0; i < 6; i++) {
            int a = rnd.nextInt(21 - 9) + 9;
            int b = rnd.nextInt(21 - 9) + 9;

            int q = 0;

            while (q <= 21) {
                System.out.println("Question " + q);
                q++;
                System.out.println(a + " % " + b + " = " + " ? ");
                System.out.println("Enter the answer: \n");
                int answer = sc.nextInt();
                int score = 0;
                int counter = 0;
                int performance1 = 0;
                int performance = 0;
                int[] remainder = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                if (answer == remainder[0]) {
                    for (i = 0; i <= 20; i += 20) {
                        score = score + 20;
                        counter++;
                        System.out.println("Correct answer, Current score: " + score + "performance " + performance1 + "/" + performance);
                        System.out.println("The counter is" + counter);
                    }
                } else {
                    System.out.println("Incorrect answer," + "Current score: 40, " + "performance: 2/3");
                }
            }
        }
    }

    private static void partB() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Exercise 2B \n");

        for (int i = 0; i < 6; i++) {
            int a = rnd.nextInt(21 - 9) + 9;
            int b = rnd.nextInt(21 - 9) + 9;

            System.out.println(a + " % " + b + " = " + " ? ");
            System.out.println("Enter the answer: \n");
            int answer = sc.nextInt();
            int score = 0;
            int counter = 0;
            int[] remainder = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            if (answer == remainder[0]) {
                for (i = 0; i <= 20; i += 20) {
                    score = score + 20;
                    counter++;
                    System.out.println("Correct answer. " + " current score: , " + score);
                }
            } else {
                System.out.println("Incorrect answer, " + " Current score: , " + score + " performance:");
            }
        }
    }

    public static void main(String[] args) {
        //partA();
        partB();
    }
}

/* https://www.youtube.com/watch?v=dlA67TRejww */
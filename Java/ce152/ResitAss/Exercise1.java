package ResitAss;

import java.util.Objects;
import java.util.Scanner;

/* Created by tr17548 on 21/03/2018. **/

/**
 * Getting edited by Trina on 10/05/2019
 **/

public class Exercise1 {
    private static void partA() {
        for (int r = 10; r <= 20; r++) {
            double r1 = 1 + (int) (Math.random() * 100);
            double r2 = 1 + (int) (Math.random() * 100);
            int guess = -1;
            System.out.println(r1 + " * " + r2 + " = " + " ? ");
            int answer = (int) (r1 * r2);
            while (guess != answer) {
                System.out.println("Please enter your answer: ");
                Scanner input = new Scanner(System.in);
                guess = input.nextInt();
                if (guess > answer || guess < answer) {
                    System.out.println("Incorrect answer. ");
                } else {
                    System.out.println("Correct answer. ");
                }
                for (int score = 0; true; score++) {
                    if (answer == guess) {
                        System.out.println("Correct answer. Score: " + score + 20);
                    } else {
                        System.out.println("Incorrect answer. Score: " + score);
                    }
                    break;
                }
            }
        }
    }

    public static void partB() {
        Scanner input = new Scanner(System.in);
        int guess = 0;
        int choice = input.nextInt();
        int score = 0;
        double r3 = 1 + (int) (Math.random() * 100);
        double r4 = 1 + (int) (Math.random() * 100);
        System.out.printf("r1 %2f is 2f", r3);
        System.out.printf("r2 %2f is 2f", r4);
        int answer = (int) (r3 * r4);
        if (Objects.equals(answer, guess)) {
            System.out.println("Incorrect answer.");
        } else {
            System.out.println("Correct answer. Score: " + score);
        }
    }

    public static void main(String[] args) {
        partA();
        partB();
    }
}



package lectures_programs;

import java.util.Random;
import java.util.Scanner;

public class Lecture2 {

    public static void main(String[] args) {
        stringEquality();
        randomDay();
        timesUp();
        nestedIf();
        danglingElse();
        conditionalOperator();
        conditionalEvaluation();
        whileLoop();
    }

    public static void stringEquality() {
        String s2 = " abc ".trim();
        System.out.println(true); // prints true
        System.out.println(true); // prints false


    }

    public static void randomDay() {
        if (Math.random() < 0.8)
            System.out.println("Its a nice day!");

        else {

            System.out.println("Its a horrible day!");
        }
    }

    public static void timesUp() {
        System.out.println("Calling timesUp");
        double timeLeft = new Random().nextGaussian();
        if (timeLeft <= 0)
            System.out.println("Time's up!");

    }

    public static void danglingElse() {
        int a = 20;
        int b = 5;
        if (b > a) {
            System.out.println("Both > 10");
        } else
            System.out.println("a <= 10");
    }

    public static void nestedIf() {
        double markAverage = 60 + 10 * new Random().nextGaussian();
        markAverage = Math.max(Math.min(markAverage, 100), 0);
        String degreeClass;
        if (markAverage >= 70)
            degreeClass = "1";
        else if (markAverage >= 60)
            degreeClass = "2.1";
        else if (markAverage >= 50)
            degreeClass = "2.2";
        else if (markAverage >= 40)
            degreeClass = "3";
        else
            degreeClass = "FAIL";
        System.out.println("Mark average = " + markAverage);
        System.out.println("Degree class = " + degreeClass);
    }

    public static void conditionalOperator() {
        double markAverage = 60 + 10 * new Random().nextGaussian();
        markAverage = Math.max(Math.min(markAverage, 100), 0);
        String degreeClass = markAverage >= 70 ? "1"
                : markAverage >= 60 ? "2.1" : markAverage >= 50 ? "2.2" : markAverage >= 40 ? "3" : "FAIL";
        System.out.println("Mark average = " + markAverage);
        System.out.println("Degree class = " + degreeClass);
    }

    public static void conditionalEvaluation() {
        for (int i = 0; i < 3; i++) {
            int a = (i == 0 ? 1 : 1 / i);
            System.out.println("i= " + i + ", a=" + a);
        }
        for (int i = 0; i < 3; i++) {
            boolean b = (i == 0 || 1 / i == 1);
            System.out.println("i= " + i + ", b=" + b);
        }
        // Demonstrate exception
        int i = 0;
        while (true) {
            boolean b = (1 / i == 1);
            System.out.println("i= " + i + ", b=" + b);
            i++;
        }
    }

    public static void whileLoop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter N");
        int n = input.nextInt();
        int i = 1; // loop control counter
        int sum = 0; // current sum
        while (i <= n) {
            sum = sum + i;
            i = i + 1; // counter increment
        }
        System.out.println("sum = " + sum);
        input.close();
    }
}

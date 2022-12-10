package lectures_programs;

import java.util.Scanner;

public class GuessNumber {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // guessNumber();
        guessNumberWithQuit();
    }

    public static void guessNumber() {
        int secret = 1 + (int) (Math.random() * 100);
        int guess = -1;
        while (guess != secret) {
            System.out.println("Please enter your guess ");
            guess = input.nextInt();
            if (guess > secret)
                System.out.println("Your guess is too high");
            else if (guess < secret)
                System.out.println("Your guess is too low");
            else //
                System.out.println("Right guess!");
        }
        input.close();
    }

    public static void guessNumberWithQuit() {
        int secret = 1 + (int) (Math.random() * 100);
        int guess;
        boolean found = false;
        while (true) {
            System.out.println("Please enter your guess (-1 to quit)");
            guess = input.nextInt();
            if (guess == -1)
                break;
            if (guess == secret) {
                found = true;
                break;
            }
            System.out.println("Your guess is too " + (guess < secret ? "low" : "high"));
        }
        System.out.println(found ? "Right guess" : "Number was " + secret);
        System.out.println("Good-bye!");
        input.close();
    }
}

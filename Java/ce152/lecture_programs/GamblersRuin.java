package lectures_programs;

import java.util.Scanner;

//Based on http://introcs.cs.princeton.edu/java/lectures, modified 
public class GamblersRuin {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter stake, goal, and number of tries");
        int stake = input.nextInt();
        int goal = input.nextInt();
        int tries = input.nextInt();
        int wins = 0;
        // repeat experiment for number of tries
        for (int t = 0; t < tries; t++) {
            // do one gambler's ruin experiment
            int cash = stake;
            while (cash > 0 && cash < goal) {
                // flip coin and update
                if (Math.random() < 0.5)
                    cash++;
                else
                    cash--;
            }
            if (cash >= goal)
                wins++;
        }
        System.out.println(wins + " wins of " + tries);
        input.close();
    }

}

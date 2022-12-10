package lab2;
import java.util.Scanner;

/**
 * Created by tr17548 on 24/01/2018.
 */
public class Lab {
    public static void statesOfWater() {
        Scanner input = new Scanner(System.in);
        System.out.println("Exercise: States of Water - Celsius and Fahrenheit");
        System.out.println("Please enter temperature (digit)");
        double temperature = input.nextDouble();
        System.out.println("Please enter scale (C or F)");
        String scale = input.next().trim().toUpperCase();
        if (!scale.equals("C") && !scale.equals("F")) {
            System.out.println("Invalid temperature scale");
            return;
        }
        double freezingPoint = scale.equals("C") ? 0 : 32;
        double boilingPoint = scale.equals("C") ? 100 : 212;
        String state = "liquid";
        if (temperature < freezingPoint)
            state = "frozen";
        else if (temperature > boilingPoint)
            state = "gaseous";

        System.out.print("Water is " + state + " at " + temperature + " " + scale);
    }

}

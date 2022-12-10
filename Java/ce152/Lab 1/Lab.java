package lab1;
import java.util.Scanner;
/**
 * Java program to calculate compound interest, means, reads and concatenates strings, escapes sequences, next characters and age difference
 * Used the websites: http://www.hubberspot.com/2012/05/how-to-calculate-compound-interest-in.html, https://www.wikihow.com/Write-a-Program-in-Java-to-Calculate-the-Mean
 * Created by tr17548 on 24/01/2018.
 */
public class Lab {
    public static void calcInterest() {
        System.out.println("Exercise: Calculating Compound Interest");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How to calculate compound interest in Java");

        System.err.println("Please enter initial balance: ");
        float balance = scanner.nextFloat();

        System.err.println("Please enter number of years: ");
        float years = scanner.nextFloat();

        System.err.println("Please enter rate: ");
        float rate = scanner.nextFloat();

        double compoundInterest = balance * Math.pow((1 + rate / 100), years);
        System.out.println("Simple interested balance is: " + compoundInterest);
    }

    public static void calcMeans() {
        System.out.println("Exercise: Calculating Means");
        int sum = 0, inputNum;
        int counter;
        float mean;
        Scanner NumScanner = new Scanner(System.in);

        System.out.println("Enter the total number of terms you want to calculate ");

        counter = NumScanner.nextInt();

        System.out.println("Please enter " + counter + " numbers: ");

        for (int x = 1; x <= counter; x++) {
            inputNum = NumScanner.nextInt();
            sum = sum + inputNum;
            System.out.println();
        }
        mean = sum / counter;
        System.out.println("The mean of the " + counter + " numbers you entered is " + mean);
    }

    public static void greetName() {
        System.out.println("Exercise: Reading and Concatenating Strings");
        System.out.println("Please enter first name and family name.");
        Scanner input = new Scanner(System.in);
        String firstName = input.next().trim();
        String familyName = input.next().trim();
        System.out.println("Hello " + firstName + " " + familyName + "!");
    }

    public static void escapeSeq() {
        System.out.println("Exercise: Escape Sequences");
        String s ="\"Hello,\n World\"";
        System.out.println(s);
        s = "\t\\t|t//t/";
        System.out.println(s);
        s = "#\'a\\ab\\b'^";
        System.out.println(s);
    }

    public static void nextCharacters() {
        System.out.println("Exercise: Next Characters");
        System.out.println("Please enter a letter:");
        Scanner input = new Scanner(System.in);
        char c = input.next().charAt(0);
        c++;
        System.out.print(c);
        c--;
        System.out.print(c);
        System.out.println();
    }

    public static void ageDifference() {
        System.out.println("Exercise: Age Difference");
        System.out.println("Please enter age of first person in years and months ");
        Scanner input = new Scanner(System.in);
        int y1 = input.nextInt();
        int m1 = input.nextInt();
        System.out.println("Please enter age of second person in years and months ");
        int y2 = input.nextInt();
        int m2 = input.nextInt();
        int totalMonthDiff = Math.abs(y1 * 12 + m1 - y2 * 12 - m2);
        int yearDiff = totalMonthDiff / 12;
        int monthDiff = totalMonthDiff % 12;
        System.out.println("Age difference is " + yearDiff + " years and " + monthDiff + " months");
    }
}
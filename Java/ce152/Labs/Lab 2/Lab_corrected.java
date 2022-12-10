package lab2;

import java.util.Scanner;

public class Lab_corrected {

	public static void nandTruthTable() {
		System.out.println("Exercise: NAND Truth Table");
		Boolean x, y;
		System.out.println("   x   |   y   | (x NAND y)");
		System.out.println("------------------------");
		x = false;
		y = false;
		System.out.println(" " + x + " | " + y + " | " + !(x && y));
		y = true;
		System.out.println(" " + x + " | " + y + "  | " + !(x && y));
		x = true;
		y = false;
		System.out.println(" " + x + "  | " + y + " | " + !(x && y));
		y = true;
		System.out.println(" " + x + "  | " + y + "  | " + !(x && y) + "\n");
	}

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

	public static void calcInterest() {
		Scanner input = new Scanner(System.in);
		System.out.println("Exercise: Calculating Compound Interest");
		System.out.println("Please enter initial balance, rate and number of years");
		double balance = input.nextDouble();
		double rate = input.nextDouble() / 100.0;
		int years = input.nextInt();
		for (int i = 1; i <= years; i++) {
			balance += balance * rate;
		}
		System.out.println("Balance after " + years + " years: " + balance);
	}

	public static void isPalindrome() {
		System.out.println("Exercise: Palindrome Words");
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a word:");
		String word = input.next().toUpperCase();
		int n = word.length();
		String outcome = "";
		for (int i = 0; i < n / 2; i++) {
			if (word.charAt(i) != word.charAt(n - 1 - i)) {
				outcome = "not ";
				break;
			}
		}
		System.out.print(word + " is " + outcome + "a palindrome");
	}

	public static void calcPrimes() {
		System.out.println("Exercise: Prime Numbers");
		System.out.printf("%4d", 2);
		int count = 1;
		for (int n = 3; count < 100; n += 2) {
			boolean isPrime = true;
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.printf("%4d", n);
				count++;
				if (count % 10 == 0)
					System.out.println();
			}
		}
	}

	public static void factors() {
		System.out.println("Exercise: Factoring Long Integers");
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a positive integer");
		long n = input.nextLong();
		System.out.print("Factors: ");
		for (long i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				n = n / i;
				System.out.print(i + " ");
			}
		}
		if (n > 1)
			System.out.println(n);
	}

}

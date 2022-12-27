package labs.Lab3;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        int number;
        int number1;
        char operator;
        double answer = 0.0;

        Scanner scanObject = new Scanner(System.in);

        System.out.println("PLease enter 1st number: ");
        number = scanObject.nextInt();

        System.out.println("Please enter 2nd number: ");
        number1 = scanObject.nextInt();

        System.out.println("What operation? ");
        operator = scanObject.next().charAt(0);

        switch (operator) {
            case '+' -> answer = number + number1;
            case '-' -> answer = number - number1;
            case '*' -> answer = number * number1;
            case '/' -> answer = number / number1;
            case '%' -> answer = number % number1;
        }
        int intanswer = (int) answer;

        System.out.println(number + " " + operator + " " + number1 + " = " + intanswer);
    }

}

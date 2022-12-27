package labs.Lab2.solutions.lab2_Solution.Students;

import labs.Lab1.organization.employee;

import java.util.Scanner;

public class sales extends employee {
    final Scanner input = new Scanner(System.in);
    private int numSales;

// --Commented out by Inspection START (08/08/2021 23:35):
//    public int getNumSales() {
//        return numSales;
//    }
// --Commented out by Inspection STOP (08/08/2021 23:35)

    public int setNumSales(int numSales) {
        this.numSales = numSales;
        return numSales;
    }

    public sales(String Names, int Salary, int Birth) {
        super(Names, Salary, Birth);
        System.out.println("please input sales's number");
        this.numSales = setNumSales(input.nextInt());

    }

    public void information() {
        System.out.println("number of sales is " + numSales);
    }
}

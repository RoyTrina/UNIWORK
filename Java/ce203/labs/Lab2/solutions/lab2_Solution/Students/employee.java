package labs.Lab2.solutions.lab2_Solution.Students;

import java.util.Scanner;

public abstract class employee {
    final Scanner input = new Scanner(System.in);
    protected String Names;
    protected final int Salary;
    protected final int Birth;
    public employee(){
        System.out.println("please input names of " + Names);
        this.Names = input.next();
        System.out.println("please input salary of "+ Names);
        this.Salary = input.nextInt();
        System.out.println("please input "+ Names+ "'s birthday");
        this.Birth = input.nextInt();
        System.out.println("name is " + Names);
        System.out.println("gsalary for " + Names + " is " + Salary);
        System.out.println("birthday for " + Names + " is " +Birth);


    }

    // --Commented out by Inspection (08/08/2021 23:35):public abstract void information();
}

package labs.Lab2.solutions.lab2_Solution.Students;

import java.util.Scanner;

public class Development extends employee {
    final Scanner input = new Scanner(System.in);
    private String DevelpTrend;


    public String getDevelpTrend() {
        return DevelpTrend;
    }


    public void setDevelpTrend(String develpTrend) {
        DevelpTrend = develpTrend;
    }

    public Development(String Names, int Salary, int Birth) {
        super();
        System.out.println("please input development number");
        this.DevelpTrend = input.next();
    }


    public void information() {
        System.out.println("trend for " + Names + " is " + DevelpTrend);

    }
}

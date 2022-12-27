package labs.Lab2.solutions.lab2_Solution.Students;

import java.util.Scanner;

public class managers extends employee {
    final Scanner input = new Scanner(System.in);
    private String GradeMan;

    public String setGradeMan(String grade) {
        this.GradeMan = grade;
        return grade;
    }

    public managers(String Names, int Salary, int Birth) {
        super();
        this.Names = "manager";
        System.out.println("please input grade of manager");
        this.GradeMan = setGradeMan(input.next());
    }

    public void information() {
        System.out.println("grade for " + Names + " is " + GradeMan);
    }
}

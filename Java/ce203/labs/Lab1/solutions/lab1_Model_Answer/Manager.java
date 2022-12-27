package labs.Lab1.solutions.lab1_Model_Answer;

public class Manager extends Employee {
    protected final int Number_of_Staff;


    public Manager(int Number_of_staff, String name, int salary, String DoB, String EmployeeNumber) {
        this.name = name;
        this.Number_of_Staff = Number_of_staff;
        this.salary = salary;
        this.DOB = DoB;
        this.EmployeeNumber = EmployeeNumber;

    }

    @Override
    public void info() {
        System.out.println("The amount of employees managed is " + Number_of_Staff);
    }
}

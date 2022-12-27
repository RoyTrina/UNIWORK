package labs.Lab1.solutions.lab1_Model_Answer;

public abstract class Employee {
    protected String name;
    protected int salary;
    protected String DOB;
    protected String EmployeeNumber;


    public void printName() {

        System.out.println("Name = " + name);
    }

    public void info() {
        System.out.println("Salary =  " + salary + " , DOB = " + DOB + " , Employee number = " + EmployeeNumber);

    }
}

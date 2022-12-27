package labs.Lab1.solutions.lab1_Model_Answer;

public class Development extends Employee {
    protected final int Number_of_programs_D;

    public Development(int Number_of_programs_D, String name, int salary, String DoB, String EmployeeNumber) {
        //super(name, salary, DOB, EmployeeNumber );

        this.name = name;
        this.salary = salary;
        this.DOB = DoB;
        this.EmployeeNumber = EmployeeNumber;
        this.Number_of_programs_D = Number_of_programs_D;
    }


    @Override
    public void info() {
        if (Number_of_programs_D == 1) {
            System.out.println("The number of programs developed by the employee is " + 1);
        } else {
            System.out.println("The number of programs developed by the employee are " + Number_of_programs_D);
        }


    }

}

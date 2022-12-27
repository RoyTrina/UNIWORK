package labs.Lab1.solutions.lab1_Model_Answer;

public class Sales extends Employee
{
    protected final int SalesRecorded;
    protected final String Point_of_Sale;

    public Sales(int SalesRecorded, String Point_of_Sale, String name, int salary, String DoB, String EmployeeNumber)
    {
        this.name=name;
        this.SalesRecorded=SalesRecorded;
        this.Point_of_Sale = Point_of_Sale;
        this.salary=salary;
        this.DOB=DoB;
        this.EmployeeNumber=EmployeeNumber;
    }

    @Override
    public void info()
    {
        System.out.println("The amount of products sold by the employee is " + SalesRecorded);
        System.out.println("The product was sold at point " + Point_of_Sale);
    }
}

package labs.Lab1.organization;

public abstract class employee {
    protected int EmployeeId;
    protected String name;
    protected String surname;
    protected String dateOfBirth;
    protected int age;
    protected int salary;

    public employee(String name, String surname, int age, int employeeId, String DOB, int salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.EmployeeId = employeeId;
        this.dateOfBirth = DOB;
        this.salary = salary;
    }


    public employee(String name, int salary, int birth) {
        this.name = name;
        this.salary = salary;
        this.dateOfBirth = String.valueOf(birth);
    }
}

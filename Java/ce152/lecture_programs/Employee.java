package lectures_programs;

public class Employee {

    public String name;
    public int salary;

    public Employee(String aName, int aSalary) {
        name = aName;
        salary = aSalary;
    }

    public int getPay() {
        return salary;
    }

    public Employee copy() {
        return new Employee(name, salary);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[name=" + name + ",salary=" + salary + "]";
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("E1", 16000);
        Employee e2 = new Employee("E1", 16000);
        System.out.println("e1.equals(e2)=" + e1.equals(e2));
    }
}
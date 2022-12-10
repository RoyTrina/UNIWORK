package lectures_programs;

public class Manager extends Employee {

    public int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public int getPay() {
        return super.getPay() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }

    @Override
    public Manager copy() {
        return new Manager(this.name, this.salary, bonus);
    }

    public static void main(String[] args) {
        Employee e = new Employee("Jo", 16000);
        Employee m = new Manager("Pete", 25000, 500);
        System.out.println("e= " + e);
        System.out.println("m= " + m);
        e = (Math.random() < 0.5) ? new Employee("A", 300000) : new Manager("B", 30000, 1000);
        assert e instanceof Manager;
        @SuppressWarnings("unused")
        Manager m1 = (Manager) e;
    }
}
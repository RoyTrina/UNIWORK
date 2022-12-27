package labs.Lab1.solutions.lab1_Model_Answer;

public class Exercise3 {
    public static void main(String[] args) {
        Employee[] Employed = new Employee[3];
        Employed[0] = new Development(12, "Moh", 500000, "01-10-1990", "MO789");
        Employed[1] = new Sales(250, "Till01", "Uzair", 50000, "09-12-1980", "Uz1120");
        Employed[2] = new Manager(25, "Manager", 200000, "12-12-1987", "Ma001");
        for (Employee Ex3 : Employed) {
            Ex3.printName();
            Ex3.info();
            System.out.println("\n");
        }

    }

}

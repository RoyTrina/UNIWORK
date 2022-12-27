package labs.Lab2.solutions.lab2_Solution.Students;

public class Test {
    public static void main(String[] args) {
        managers man = new managers("manager",100,100);
        man.information();
        sales sale = new sales("sales",100,100);
        sale.information();
        Development development = new Development("development",100,100);
        development.information();
    }
}

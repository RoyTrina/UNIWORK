package labs.Lab2.solutions.lab2_Solution;


import lectures.Lect1.Person;


public class Student extends Person {
    private final int regNo;


    public Student(String s, int d, int r) {
        super(s, d);
        regNo = r;
    }


    public int regNumber() {
        return regNo;
    }


    public void details() {
        System.out.println("Student " + this.regNo);
    }


    public String toString() {
        return super.toString() + "Reg no. " + regNumber();
    }


}


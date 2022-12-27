package labs.Lab2.solutions.lab2_Solution.Students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

abstract class Person {
    protected final int regNo;
    protected final String name;

    abstract void details();

    Person(String n, int number) {
        name = n;
        regNo = number;
    }

}

class Student extends Person {
    @Override
    void details() {
        System.out.println("Student " + regNo);
    }

    Student(String s, int a) {
        super("Student ", a);
    }
}

class Lecturer extends Person {
    @Override
    void details() {
        System.out.println("Lecturer " + regNo);
    }

    Lecturer(String w, int a) {
        super("Lecturer ", a);
    }
}

public class Exam {
    final Collection<Person> myList = new ArrayList<>();

    public Exam(Person[] myObjects) {
        myList.addAll(Arrays.asList(myObjects));
    }

    public void getDetails() {
        for (Person person : myList) {
            person.details();
        }
    }
}

class Count {
    static final Person[] uni = {new Lecturer("John", 1500), new Student("Max", 1502), new Student("Veer", 1501), new Lecturer("Don", 1504)};

    public static void main(String[] args) {
        Exam ex = new Exam(uni);
        ex.getDetails();
    }
}

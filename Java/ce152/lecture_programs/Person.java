package lectures_programs;

import java.util.Arrays;

public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equalsCompare(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return this.compareTo(other) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    @Override
    public int compareTo(Person other) {
        int result = this.age - other.age;
        if (result == 0)
            result = this.name.compareTo(other.name);
        return result;
    }

    public static void main(String[] args) {
        testEquals();
        // testSorting();
    }

    public static void testSorting() {
        Person[] persons = new Person[5];
        persons[0] = new Person("Eric", 43);
        persons[1] = new Person("Brian", 17);
        persons[2] = new Person("Charlie", 43);
        persons[3] = new Person("Alice", 25);
        persons[4] = new Person("Denise", 65);
        System.out.println(Arrays.toString(persons));
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));
    }

    public static void testEquals() {
        System.out.println("### testEquals");
        Person[] persons = new Person[4];
        persons[0] = new Person("Emma", 43);
        persons[1] = new Person("Brian", 65);
        persons[2] = new Person("Emma", 22);
        persons[3] = new Person("Brian", 65);
        for (Person p : persons)
            System.out.println(p);
        boolean error = false;
        for (Person p : persons)
            for (Person q : persons) {
                // System.out.println("(" + p + ").equals(" + q + ")=" + p.equals(q));
                if (!(p.equals(q) == p.equalsCompare(q))) {
                    System.out.println("Error: " + p + " " + q);
                    error = true;
                }
            }

        if (!error)
            System.out.println("No error");
    }


}

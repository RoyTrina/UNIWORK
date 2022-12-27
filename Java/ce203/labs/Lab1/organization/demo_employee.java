package labs.Lab1.organization;

import static java.lang.System.arraycopy;
import static java.lang.System.out;


public class demo_employee {
    /**
     * Here is a demonstration of how one can declare, setup and use static
     * variables. In the class Employee, fields age, salary, name and id are
     * defined. These fields are unique to each OBJECT: that is any variable
     * (object) of type Employee has its own name, age, salary and id. There
     * are also one constructor and 4 regular methods. The regular methods
     * also are per object. Now we have a static variable nextID and a
     * static method getNextID(). These fields are unique to CLASS not
     * objects. In other words there is only one nextID variable and all
     * objects of Employee class share the same variable. Similarly, there is
     * only one getNextID() method and all objects of class Employee share
     * the same getNextID(). In fact one can invoke this method even without
     * any Employee object is present. The static methods and fields are
     * allocated as soon as class is defined, not when an object is declared
     * or constructed.
     */

    static class Employee {
        private final int age;
        private final double salary;
        private final String name;
        private final int id;

        //next ID is initialized  to 1. It is one for all objects of this class until it is changed.

        private static int nextID = 1;

        /*In the constructor in addition to age, salary and name fields
        which are passed as parameters to  the constructor, the id
        field is also set. Our desire is that this id be unique to
        every employee object, in other words, no two employees should
        have the same id. We use the static variable nextID as our
        source of information about the next available id number that
        is not use. We set that number to id of the new object and
        increment th nextID variable. Through this mechanism we are
        guaranteed that each new employee has a unique id. Note the
        method that invokes the constructor does not know of which id
        numbers are already used. Such method need not be even aware of
        existence of other Employee objects. Through the mechanism of
        static variables we can guarantee uniqueness of ID.*/

        Employee(int age, double salary, String name) {
            this.age = age;
            this.salary = salary;
            this.name = name;

            id = nextID++;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        /*The static method getNextID() can only access static fields of
        class Employee. It cannot access nonstatic fields. It can
        only call other static methods of Employee; it cannot call a
        nonstatic method of the class.*/

        static int getNextID() {
            return nextID;
        }

        public double getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        /**
         * This method gets a character array and sets it to the name field of
         * Employee class object
         */
        void setName(char[] name) {
            //This does not do what we want because Java is call by value. Comment it out.
            //name=this.name.toCharArray();

           /* This works because we are not changing the parameter to the method
            i.e. name. Rather we are changing the contents of what the parameter
            is refering. Uncomment it and see the result.*/

            char[] newName = this.name.toCharArray();
            arraycopy(newName, 0, name, 0, newName.length);
        }


    }

    static class testStatic {
        public static void main(String[] argv) {
            /*We can call Employee class's static field and access
            its static fields without even a single object of this
            class having been constructed first:*/

            out.println("Here is the initial available ID: " +
                    Employee.getNextID());

            Employee john, mary;

           /* A new Employee object  mary is constructed, and its ID is
            set.*/
            mary = new Employee(34, 61563.67, "Mary Madeline");

            out.println("\nEmployee Name: " + mary.getName() +
                    "\nAge: " + mary.getAge() +
                    "\nEmployee ID:   " + mary.getID());


            /*A new Employee object john is constructed and its
            unique id is set.*/
            john = new Employee(44, 38762.87, "John Russell");
            out.println("\nEmployee Name: " + john.getName() +
                    "\nAge: " + john.getAge() +
                    "\nEmployee ID:   " + john.getID());

            out.println("Here is the next available ID: " +
                    Employee.getNextID());

            //newName is a char array which will be set in setName method. Make


            char[] newName = new char[john.getName().length()];
            john.setName(newName);

            out.println("new name is now: " + new String(newName));

            System.out.println("Mary's salary is: " + mary.getSalary());
            System.out.println("John's salary is: " + john.getSalary());
        }
    }
}

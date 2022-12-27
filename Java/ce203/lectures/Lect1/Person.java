package lectures.Lect1;

public class Person {
    private String name;
    private final int age;

 
 
    public Person(String nameIn, int ageIn) {
        name = nameIn;
        age = ageIn;
    }
 
 

    public void setName(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

 
    public boolean isOlder(Person p) {
        return getAge() > p.getAge();
    }

    public boolean isYounger(Person w){
        return getAge() < w.getAge();
    }
 

    public String toString() {
        return "Name: " + getName() + "\n" + "Age: " + getAge();
    }
}

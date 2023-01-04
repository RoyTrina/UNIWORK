import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* Note that calling the clone() method can be complicated and error-prone. It IS
* better to simply create a copy() method and copy all object instances in there to
* ensure deep copy.
* */
public class Student implements Cloneable, Serializable {

    public String name;
    public ArrayList<String> programmingLanguages;

    public Student(String name, ArrayList<String> programmingLanguages){
        this.name = name;
        this.programmingLanguages = programmingLanguages;
    }

    public ArrayList<String> getProgrammingLanguages(){
        return programmingLanguages;
    }

    public void addProgrammingLanguage(String language){
        programmingLanguages.add(language);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student1 = (Student) o;
        return Objects.equals(name, student1.name) &&
                Objects.equals(programmingLanguages, student1.programmingLanguages);
    }


    public void serialise(Student student, String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream(filename)));
            out.writeObject(student);
            System.out.println("Serialisation successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student deserialise(String filename){
        Student student = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            student = (Student) in.readObject();
            System.out.println("De-serialisation successful.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static void main (String[] args) {
        Student student, clone;
        student = new Student("Pete", new ArrayList<>(
                Arrays.asList("Java", "C")));

        student.serialise(student, "student3.dat");
        student.deserialise("student3.dat");

    }

}

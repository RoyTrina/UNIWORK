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


    public Student clone() {
//        return shallowClone();
        return deepClone();
    }

    public Student shallowClone(){
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Note that the ArrayList is not immutable, so we have to copy all of its elements in the clone
    public Student deepClone(){
        ArrayList<String> listClone = new ArrayList<>();
        for (String item : this.programmingLanguages)
            listClone.add(item);

        return new Student(this.name, listClone);
    }

    public static void main (String[] args) {
    }

}

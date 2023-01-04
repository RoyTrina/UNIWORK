import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/** This is a simple Student class, containing the name of the student and a list of the programming
 * languages this student knows. **/
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
        return deepClone();
    }

    public Student deepClone(){
        ArrayList<String> languagesCopy = new ArrayList<>(programmingLanguages);
        return new Student(this.name, languagesCopy);
    }

    public Student shallowClone(){
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main (String[] args) {
    }

}

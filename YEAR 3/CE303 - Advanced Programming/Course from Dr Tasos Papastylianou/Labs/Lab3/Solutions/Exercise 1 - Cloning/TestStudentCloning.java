import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestStudentCloning {
    Student student, clone;

    @Before
    public void setup() {
        student = new Student("Pete", new ArrayList<>(
                Arrays.asList("Java", "C")));
        clone = student.clone();
    }

    @Test
    public void testClone() {
        assertNotSame(student, clone);/* ('NotSame' equivalent to '==' ).
        We don't want them to be pointing to the same reference! */

        assertEquals(student, clone);
        assertEquals(student.getClass(), clone.getClass());
    }

    @Test
    public void testDeepClone1() {
        clone.addProgrammingLanguage("QBasic");
        assertNotEquals(student, clone);
        assertEquals(student, new Student("Pete", new ArrayList<>(
                Arrays.asList("Java", "C"))));
    }

    @Test
    public void testDeepClone2() {
        clone.getProgrammingLanguages().remove(0);
        assertNotEquals(student, clone);
        assertEquals(student, new Student("Pete", new ArrayList<>(
                Arrays.asList("Java", "C"))));
    }

}

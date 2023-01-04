import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestStudentSerialisation {

    Student student;

    @Before
    public void setup() {
        student = new Student("Pete", new ArrayList<>(
                Arrays.asList("Java", "C")));
    }

    @Test
    public void testSerialisation() {
        student.serialise(student, "test.dat");
        Student student2 = student.deserialise("test.dat");

        assertEquals(student, student2);
        assertEquals(student.getClass(), student2.getClass());
    }
}

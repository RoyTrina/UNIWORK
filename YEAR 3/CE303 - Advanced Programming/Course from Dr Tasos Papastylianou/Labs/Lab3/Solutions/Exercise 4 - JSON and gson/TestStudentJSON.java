import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestStudentJSON {

    Student student;
    Gson gson = new Gson();

    @Before
    public void setup() throws IOException {
        student = new Student("Pete", new ArrayList<>(
                Arrays.asList("Java", "C")));

        Path path = Paths.get("student.json");
        BufferedWriter writer = Files.newBufferedWriter(path);
        gson.toJson(student, writer);
        writer.close();
    }

    @Test
    public void testGson() throws IOException {
        Path path = Paths.get("student.json");
        BufferedReader reader = Files.newBufferedReader(path);
        Type t = new TypeToken<Student>(){}.getType();

        Student copy = gson.fromJson(reader,t);
        reader.close();
        assertEquals(student, copy);
        assertEquals(student.getClass(), copy.getClass());
    }



}

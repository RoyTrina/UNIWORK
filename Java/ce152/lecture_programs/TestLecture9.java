package lectures_programs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static lectures_programs.Lecture9.isPermutation;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLecture9 {

    List<Integer> xs = new ArrayList<>();
    List<Integer> ys = new ArrayList<>();

    @Before
    public void reset() {
        xs.clear();
        ys.clear();
    }

    @Test
    public void testIsPermutation() {
        assertTrue(isPermutation(xs, ys));
        xs.add(3);
        assertFalse(isPermutation(xs, ys));
        ys.add(3);
        assertTrue(isPermutation(xs, ys));
        ys.add(1);
        assertFalse(isPermutation(xs, ys));
        xs.add(1);
        assertTrue(isPermutation(xs, ys));
        xs.add(1);
        assertFalse(isPermutation(xs, ys));
    }

    @Test
    public void testIsPermutationRandom() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            xs.add(i);
            ys.add(r.nextInt(i + 1), i);
        }
        System.out.println(ys);
        assertTrue(isPermutation(xs, ys));
    }

    @Test
    public void testIsPermutationDuplicates1() {
        xs.addAll(Arrays.asList(1, 2, 2));
        ys.addAll(Arrays.asList(2, 1, 2));
        assertTrue(isPermutation(xs, ys));
    }

    @Test
    public void testIsPermutationDuplicates2() {
        xs.addAll(Arrays.asList(1, 1, 2));
        ys.addAll(Arrays.asList(1, 2, 2));
        assertFalse(isPermutation(xs, ys));
    }

}

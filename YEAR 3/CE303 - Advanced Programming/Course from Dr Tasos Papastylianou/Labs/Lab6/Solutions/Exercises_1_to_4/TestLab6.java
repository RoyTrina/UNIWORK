import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestLab6 {

  static final long SEED = System.nanoTime();
  static final int RANGE = 3000;

  @Test
  public void testConcat() {
    List<Integer> list1  = Arrays.asList(1, 2, 3);
    List<Integer> list2  = Arrays.asList(4, 5, 6);
    List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6);
    assertEquals(result, Lab6.concat(list1, list2));
  }

  @Test
  public void testFrequencyMap() {
    List<Integer> arg = Arrays.asList(1, 2, 3, 4, 1, 2);
    Map<Integer, Integer> result = new HashMap<>();
    result.put(1, 2);
    result.put(2, 2);
    result.put(3, 1);
    result.put(4, 1);
    assertEquals(result, Lab6.frequencyMap(arg));
  }


  @Test
  public void testZipWith() {
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(4, 5, 6);
    List<Integer> expected = Arrays.asList(5,7,9);
    assertEquals(expected, Lab6.zipWith((x,y) -> x+y, list1, list2));
  }


  @Test
  public void testMapPerformance() {
    Map<Integer, Integer> treeMap = new TreeMap<>();
    Map<Integer, Integer> hashMap = new HashMap<>(RANGE);
    for (Map<Integer, Integer> map : Arrays.asList(treeMap, hashMap)) {
      long time = timeFreqMap(map, RANGE);
      System.out.println("testMapPerformance, map.size()= " + map.size());
      System.out.println("testMapPerformance(" + map.getClass() + "), time taken = " + time
          + "ms");
    }
    assertEquals(treeMap, hashMap);
  }

  public static long timeFreqMap(Map<Integer, Integer> map, int range) {
    final java.util.Random random = new java.util.Random(SEED);
    int collSize = range * range;
    List<Integer> testList = new ArrayList<Integer>();
    for (int i = 0; i < collSize; i++)
      testList.add(random.nextInt(range));
    long time0 = System.currentTimeMillis();
    Lab6.frequencyMap(testList, map);
    long time1 = System.currentTimeMillis();
    return time1 - time0;
  }
}

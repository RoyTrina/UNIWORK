import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Lab6 {

  @SafeVarargs
  public static <A> List<A> concat(List<A>... lists) {
    List<A> result = new ArrayList<A>();
    for (List<A> list : lists)
      result.addAll(list);
    return result;
  }

  public static <A> Map<A, Integer> frequencyMap(Collection<A> c) {
    Map<A, Integer> result = new HashMap<A, Integer>();
    for (A a : c) {
      Integer x = result.get(a);
      int y = x == null ? 0 : x;
      result.put(a, y + 1);
    }
    return result;
  }

  public static <A> void frequencyMap(Collection<A> c, Map<A, Integer> map) {
    for (A a : c) {
      Integer x = map.get(a);
      int y = x == null ? 0 : x;
      map.put(a, y + 1);
    }
  }

  public static <A, B, C> List<C> zipWith(BiFunction<? super A, ? super B, ? extends C> f, List<A> list1,
      List<B> list2) {
    List<C> result = new ArrayList<C>();
    Iterator<? extends A> it1 = list1.iterator();
    Iterator<? extends B> it2 = list2.iterator();
    while (it1.hasNext() && it2.hasNext()) {
      result.add(f.apply(it1.next(), it2.next()));
    }
    return result;
  }

  public static int max(int... elements) {
    int result = Integer.MIN_VALUE;
    for (int i : elements) {  if (i > result) { result = i; }  }
    return result;
  }

  public static void main(String[] args) {
    int[] results = new int[] { max(), max(1), max(1, 2), max(1, 2, 3), max(new int[] { 1, 2, 3 }) };
    System.out.println(results);
  }

}

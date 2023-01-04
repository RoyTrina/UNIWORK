import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class ZipWithOptional {

  public static <A, B, C> List<C> zipWith( BiFunction<? super A, ? super B, ? extends C> f, List<A> list1, List<B> list2 )
  {   List<C>            result = new ArrayList<C>();
      Iterator<? extends A> it1 = list1.iterator();
      Iterator<? extends B> it2 = list2.iterator();

      while ( it1.hasNext() && it2.hasNext() )
      {   result.add( f.apply( it1.next(), it2.next() ) );
      }

      return result;
  }

  public static <A, B, C> List<Optional<C>> zipWithOptional(BiFunction<? super A, ? super B, ? extends C> f, List<A> list1, List<B> list2)
  {   List<Optional<C>>  result = new ArrayList<Optional<C>>();
      Iterator<? extends A> it1 = list1.iterator();
      Iterator<? extends B> it2 = list2.iterator();

      while (it1.hasNext() && it2.hasNext())
      {   try
          {   result.add(Optional.of(f.apply(it1.next(), it2.next())));
          }
          catch (Exception e)
          {   result.add(Optional.empty());
          }
      }

      return result;
  }

  public static void main(String[] args) {
    List<String> list1 = Arrays.asList("1", "2", "3");
    List<String> list2 = Arrays.asList("-1", "0", "1");
    List<Optional<String>> out = zipWithOptional( (a, b) -> Integer.valueOf( Integer.parseInt(a) / Integer.parseInt(b) ).toString(), list1, list2 );
    System.out.println( Arrays.toString( out.toArray() ) );
  }
}

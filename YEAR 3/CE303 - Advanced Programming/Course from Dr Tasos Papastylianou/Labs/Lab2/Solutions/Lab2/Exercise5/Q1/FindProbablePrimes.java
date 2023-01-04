package Lab2.Exercise5.Q1;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;

public class FindProbablePrimes
implements Runnable, Function<BigInteger, BigInteger>
{   final static int N = 8;
    final static int BITS = 20;
    final static List<BigInteger> list = new ArrayList<>();
    final static Map<BigInteger, BigInteger> primes = new HashMap<>();

    int id;

    public FindProbablePrimes( int id ){ this.id = id; }

    public static
    Map<BigInteger, BigInteger> sequential( List<BigInteger> arguments )
    {   Map<BigInteger, BigInteger> map = new HashMap<>();
        for (BigInteger item : arguments) { map.put( item, item.nextProbablePrime() ); }
        return map;
    }


    public static
    Map<BigInteger, BigInteger> parallel( List<BigInteger> arguments)
    {   Map<BigInteger, BigInteger> map = copy(primes);
        return map;
    }


    public static
    Map<BigInteger, BigInteger> parallel2( List<BigInteger> arguments)
    {   Map<BigInteger, BigInteger> map = copy(primes);
        return map;
    }


    public static <K,M> Map<K,M> copy( Map<K, M> map )
    {   var mapCopy = new HashMap<K,M>();

        for (Map.Entry<K,M> set : map.entrySet())
        { mapCopy.put( set.getKey(), set.getValue() ); }

        return mapCopy;
    }


    @Override
    public BigInteger apply( BigInteger t ) { return t.nextProbablePrime(); }


    @Override
    public void run()
    {

        /**
         ** Uncomment as needed
         **/

     /* 1st way, without Functional interface */
//      primes.put( list.get( id ), list.get( id ).nextProbablePrime() );

     /* 2nd way, with Functional interface */
//      primes.put( list.get( id ), new FindProbablePrimes( id ).apply( list.get( id ) ) );

     /* 3rd way, with Functional interface and lambda expression */
        Function<BigInteger, BigInteger> f = (a) -> a.nextProbablePrime();
        primes.put( list.get( id ), f.apply( list.get( id ) ) );
    }


    public static void main (String[] args) throws InterruptedException {
//      List<BigInteger> list = new ArrayList<>();
        BigInteger big;
        Thread[] threads = new Thread[ N ];

        for (int i = 0; i < N; i++)
        {   big = new BigInteger( BITS, new Random() );
            list.add( big );
            threads[ i ] = new Thread( new FindProbablePrimes( i ) );
            threads[ i ].start();
        }

        for (Thread th : threads) { th.join(); }

        long t1 = System.nanoTime();
        Map<BigInteger, BigInteger> sequential = sequential( list );
        long t2 = System.nanoTime();
        System.out.println("Time taken for sequential: " + (t2 - t1) / 1e9);

        t1 = System.nanoTime();
        Map<BigInteger, BigInteger> parallel = parallel( list );
        t2 = System.nanoTime();
        System.out.println("Time taken for parallel: " + (t2 - t1) / 1e9);

    }
}

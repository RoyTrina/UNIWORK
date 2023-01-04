package Lab2.Exercise4.Q1;

import java.math.BigInteger;
import java.util.*;

public class FindProbablePrimes
{
    public static
    Map<BigInteger, BigInteger> sequential( List<BigInteger> arguments )
    {   var result = new TreeMap<BigInteger, BigInteger>();
        for (var value : arguments) { result.put( value, value.nextProbablePrime() ); }
        return result;
    }

    public static
    Map<BigInteger, BigInteger> parallel( List<BigInteger> arguments )
    {   var threads = new Thread     [ arguments.size() ];
        var array   = new BigInteger [ arguments.size() ];

        for (var i = 0; i < arguments.size(); i++)
        {   int i1 = i;

            threads[ i ] = new Thread(
                () -> { array[ i1 ] = arguments.get( i1 ).nextProbablePrime(); }
            );

            threads[ i ].start();
        }

        try { for (var t : threads) { t.join(); } }
        catch (Exception e) { }

        var result = new TreeMap<BigInteger, BigInteger>();

        for (int i = 0; i < arguments.size(); i++)
        { result.put(arguments.get(i), array[i]); }

        return result;
    }


    public static void main(String[] args)
    {   var arguments = new ArrayList<BigInteger>();
        var rnd = new Random();

        for (int i = 0; i < 80; i++)
        { arguments.add( new BigInteger( 2000, rnd ) ); }

        long t1 = System.nanoTime();

     /* Uncomment as appropriate */
//      sequential(arguments);
        parallel(arguments);

        long t2 = System.nanoTime();
        System.out.printf( "Computation took %3.1f seconds%n", (t2 - t1) / 1e9 );
    }
}

package Lab1.Exercise2.Q2;

import java.util.function.Function;

public class IntListProcessor
{
    public static int [] process( int [] list, Function<Integer,Integer> processor )
    {
        int [] newlist = new int [list.length];
        for (int i = 0; i < list.length; i++)
        {
            newlist[i] = processor.apply( list[i] );
        }

        return newlist;
    }
}

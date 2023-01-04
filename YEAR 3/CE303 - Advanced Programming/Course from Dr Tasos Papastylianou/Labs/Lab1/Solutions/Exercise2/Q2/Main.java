package Lab1.Exercise2.Q2;

import Lab1.Exercise2.Q2.IntListProcessor;

public class Main
{
    public static void main( String [] args )
    {
        int [] mylist = {1, 2, 3, 4, 5};
        int [] newlist = IntListProcessor.process( mylist, x -> x+2 );

        for (int i = 0; i < newlist.length - 1; i++) System.out.print( newlist[i] + ", " );
        System.out.println( newlist[ newlist.length - 1 ] );
    }
}

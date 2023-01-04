package Lab2.Exercise2.Q1;

public class InterferenceChecker implements Runnable
{   public static int shared;
    final  static int REPETITIONS = 1000 * 1000;

    public int id;


    InterferenceChecker( int id ) { this.id = id; }


    public void run() throws RuntimeException
    {   int i = 0;

        while (i < REPETITIONS)
        {   shared = id;
            if (shared != id) { break; }
            i++;
        }

        System.out.printf( "Thread %d: i = %d%n", id, i );
    }


    public static void main( String [] args ) throws InterruptedException {

        Thread t1 = new Thread( new InterferenceChecker( 1 ) );
        Thread t2 = new Thread( new InterferenceChecker( 2 ) );

        t1.start();
        t2.start();
    }
}

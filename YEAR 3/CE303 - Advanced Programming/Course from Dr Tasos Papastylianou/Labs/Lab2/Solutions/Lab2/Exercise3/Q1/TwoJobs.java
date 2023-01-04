package Lab2.Exercise3.Q1;

import java.util.concurrent.CyclicBarrier;

public class TwoJobs implements Runnable {

    private static final int N = 10;
    private static CyclicBarrier barrier = new CyclicBarrier(N);

    private int id;

    public TwoJobs( int id ) { this.id = id; }

    @Override
    public void run()
    {   firstJob();
        waitForOthers();
        secondJob();
    }

    public static void main( String[] args )
    {   for (int i = 0; i < N; i++)
        { new Thread( new TwoJobs( i ) ).start(); }
    }

    public void firstJob()
    { System.out.println( "Thread " + id + ", first job done" ); }

    public void secondJob()
    { System.out.println( "Thread " + id + ", second job done" ); }

    public void waitForOthers()
    {   try { barrier.await(); }
        catch (Exception e) { }
    }
}

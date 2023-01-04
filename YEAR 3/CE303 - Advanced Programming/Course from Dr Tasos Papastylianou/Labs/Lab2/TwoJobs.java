package Lab2.Exercise3.Q1;

// TODO
// Add program code so that the threads wait for each other after completing
// first job. No thread should starts second job until all threads have
// completed first job

public class TwoJobs implements Runnable {

    private static final int N = 10;

    private int id;

    public TwoJobs( int id ) { this.id = id; }

    @Override
    public void run()
    {   firstJob();
        waitForOthers();
        secondJob();
    }

    public static void main( String [] args )
    {   for (int i = 0; i < N; i++)
        { new Thread( new TwoJobs( i ) ).start(); }
    }

    public void firstJob()
    { System.out.println( "Thread " + id + ", first job done" ); }

    public void secondJob()
    { System.out.println( "Thread " + id + ", second job done" ); }

    public void waitForOthers() { /* Implement this */ }

}

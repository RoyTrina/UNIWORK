package Lab2.Exercise1.Q2;

public class Greeter implements Runnable {

    private String greeting;
    private boolean interruptionFlag = false;

    private static final int REPETITIONS = 10;
    private static final int DELAY       = 500;

    public Greeter(String aGreeting) { greeting = aGreeting; }

    public void run() {
        try {
            for (int i = 1; i <= REPETITIONS; i++) {
                System.out.println( i + ": " + greeting );
                Thread.sleep( DELAY );
            }
        } catch (InterruptedException e) {
            System.out.println( "Greeter \"" + greeting + "\" was interrupted!" );
            this.interruptionFlag = true;
        }
    }

    public boolean wasInterrupted() { return this.interruptionFlag; }

    public static void main( String [] args ) {

        Greeter r1 = new Greeter( "Hello!"   );
        Greeter r2 = new Greeter( "Goodbye!" );

        Thread t1 = new Thread( r1 );
        Thread t2 = new Thread( r2 );

        t1.start();
        t2.start();

        try {
            t1.join(2100);
            t1.interrupt();
            t2.join();
            System.out.println( "Both Greeters have ended after both Greeter threads have terminated" );
        } catch (Exception e) { }

        System.out.println( "t1 was" + (r1.wasInterrupted() ? " " : " not ") + "interrupted" );
        System.out.println( "t2 was" + (r2.wasInterrupted() ? " " : " not ") + "interrupted" );
    }
}

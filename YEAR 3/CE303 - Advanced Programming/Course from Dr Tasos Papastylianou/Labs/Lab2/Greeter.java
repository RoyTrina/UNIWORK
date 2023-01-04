// ... package declarations should go here as appropriate


public class Greeter implements Runnable {

    private String greeting;

    private static final int REPETITIONS = 10;
    private static final int DELAY       = 500;

    public Greeter(String aGreeting) { greeting = aGreeting; }

    public void run() {
        try {
            for (int i = 1; i <= REPETITIONS; i++) {
                System.out.println( i + ": " + greeting );
                Thread.sleep( DELAY );
            }
        } catch (InterruptedException exception) {
            System.out.println( "Greeter \"" + greeting + "\" was interrupted!" );
        }
    }

    public static void main( String [] args ) {

        Runnable r1 = new Greeter( "Hello!"   );
        Runnable r2 = new Greeter( "Goodbye!" );

        Thread t1 = new Thread( r1 );
        Thread t2 = new Thread( r2 );

        t1.start();
        t2.start();
    }
}

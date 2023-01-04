import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
    public static void main( String [] args )
    {   if (args.length == 0) { System.err.println( "Please provide input" ); System.exit(1); }
        else if (args.length == 1 && args[0].equals("up") || args[0].equals("down")) { }
        else { System.err.println( "Please use one of 'up' or 'down'" ); System.exit(1); }

        BufferedReader b = new BufferedReader( new InputStreamReader( System.in ) );
        String s;

        try
        {   while (true)
            {   s = b.readLine();   if (s == null) { break; }
                if (args[0].equals("up")) { System.out.println( s.toUpperCase() ); }
                else { System.out.println( s.toLowerCase() ); }
            }
        }
        catch (IOException e) { s = null; e.printStackTrace(); System.exit(1); }
    }
}

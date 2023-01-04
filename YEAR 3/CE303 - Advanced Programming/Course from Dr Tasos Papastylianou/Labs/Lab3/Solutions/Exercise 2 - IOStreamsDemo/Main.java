import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.IOException;

public class Main
{
    public static void main( String [] args )
    {   PrintWriter    out;
        PrintWriter    err;
        BufferedReader in;

        try
        {   out = new PrintWriter( new BufferedWriter( new FileWriter( "Out.txt" ) ) );
            err = new PrintWriter( new BufferedWriter( new FileWriter( "Err.txt" ) ) );
            in  = new BufferedReader( new FileReader( "In.txt"  ) );
        } catch (IOException e) { e.printStackTrace(); out = null; err = null; in = null; System.exit(1); }

        if (args.length == 0) { err.println( "Please provide input" ); err.close(); System.exit(1); }
        else if (args.length == 1 && args[0].equals("up") || args[0].equals("down")) { }
        else { err.println( "Please use one of 'up' or 'down'" ); err.close(); System.exit(1); }

        String s;

        try
        {   while (true)
            {   s = in.readLine();   if (s == null) { break; }
                if (args[0].equals("up")) { out.println( s.toUpperCase() ); }
                else { out.println( s.toLowerCase() ); }
            }
        }
        catch (IOException e) { s = null; e.printStackTrace(); System.exit(1); }

        out.close();
        err.close();
        try { in.close(); } catch (IOException e) { e.printStackTrace(); }
    }
}

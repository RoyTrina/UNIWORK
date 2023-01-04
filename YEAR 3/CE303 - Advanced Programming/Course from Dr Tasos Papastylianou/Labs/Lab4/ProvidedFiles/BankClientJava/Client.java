import java.io.*;   import java.net.Socket;   import java.util.Scanner;

public class Client implements AutoCloseable  // i.e. can use in a try-with-resources block
{   final int port = 8888; private final Scanner reader; private final PrintWriter writer;

    public Client( int customerId ) throws Exception {
        Socket socket = new Socket( "localhost", port );            // Connecting to the server,
        reader = new Scanner( socket.getInputStream() );            //   and create objects for communications;
        writer = new PrintWriter( socket.getOutputStream(), true ); // Provides nice 'println' functions (which flush automatically!)
        writer.println(customerId);        // Send customer ID
        String line = reader.nextLine();   // Parse the response
        if (line.trim().compareToIgnoreCase( "success" ) != 0) throw new Exception( line );
    }

    public int[] getAccountNumbers()
    {   writer.println("ACCOUNTS");                      // Send "command"
        String line = reader.nextLine();                 // Read response (expecting: number of accounts)
        int numberOfAccounts = Integer.parseInt( line ); // Parse response
        int [] accounts = new int[ numberOfAccounts ];   // Create array to hold accounts
        for (int i = 0; i < numberOfAccounts; i++) { line = reader.nextLine();  accounts[ i ] = Integer.parseInt( line ); } // Populate accounts
        return accounts;   // Return accounts array (or, to be exact, a reference to the array)
    }

    public int getBalance( int accountNumber )
    {   writer.println("BALANCE " + accountNumber);   // Send "command"
        String line = reader.nextLine();              // Read response (expecting: balance)
        return Integer.parseInt(line);                // Parse Response
    }

    public void transfer( int fromAccount, int toAccount, int amount ) throws Exception
    {   writer.println( "TRANSFER " +fromAccount+ " " +toAccount+ " " +amount);   // Send command
        String line = reader.nextLine();                                          // Read response (expecting: 'success')
        if (line.trim().compareToIgnoreCase( "success" ) != 0) throw new Exception( line );
    }

    @Override
    public void close() throws Exception {  // Implement AutoCloseable interface!
        reader.close();
        writer.close();
    }
}

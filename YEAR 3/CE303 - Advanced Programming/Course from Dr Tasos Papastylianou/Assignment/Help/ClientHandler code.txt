// ClientHandler.java
import java.io.PrintWriter;   import java.net.Socket;   import java.util.List;   import java.util.Scanner;

public class ClientHandler implements Runnable
{   private final Socket socket;
    private Bank bank;

    public ClientHandler( Socket socket, Bank bank ) { this.socket = socket; this.bank = bank; }

    @Override
    public void run()
    {   int customerId = 0;
        try (Scanner scanner  = new Scanner( socket.getInputStream() );
             PrintWriter writer = new PrintWriter( socket.getOutputStream(), true ) )
        {   try
            {   customerId = Integer.parseInt( scanner.nextLine() );
                System.out.println( "New connection; customer ID " + customerId );
                if (bank.getListOfAccounts( customerId ).size() == 0)
                {   throw new Exception( "Unknown customer: " + customerId + "." );
                }
                writer.println( "SUCCESS" );

                while (true)
                {   String line = scanner.nextLine();
                    String[] substrings = line.split(" ");
                    switch (substrings[0].toLowerCase())
                    {   case "accounts":
                            List<Integer> listOfAccounts = bank.getListOfAccounts( customerId );
                            writer.println( listOfAccounts.size() );
                            for (Integer accountNumber : listOfAccounts) { writer.println(accountNumber); }
                            break;

                        case "balance":
                            int account = Integer.parseInt( substrings[ 1 ] );
                            writer.println( bank.getAccountBalance( customerId, account ) );
                            break;

                        case "transfer":
                            int fromAccount = Integer.parseInt( substrings[ 1 ] );
                            int toAccount = Integer.parseInt( substrings[ 2 ] );
                            int amount = Integer.parseInt( substrings[ 3 ] );
                            bank.transfer( customerId, fromAccount, toAccount, amount );
                            writer.println( "SUCCESS" );
                            break;

                        default:   throw new Exception( "Unknown command: " + substrings[ 0 ] );
                    }
                }
            }
            catch (Exception e) { writer.println( "ERROR " + e.getMessage()); socket.close(); }
        }
        catch (Exception e) { }
        finally { System.out.println( "Customer " + customerId + " disconnected." ); }
    } // end of 'run' method
}

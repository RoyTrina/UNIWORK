package labs.Lab7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab7 {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb", "root", null);
            // experience has shown that using the one-argument version of getConnection doesn't work for some students
        } catch (ClassNotFoundException e) {
            System.out.println("driver not found");
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("failed to connect to database");
            System.exit(1);
        }

        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("failed to access database");
            System.exit(1);
        }

        queryDatabase();

        try {
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("problems closing connection");
            System.exit(1);
        }
    }

    private static void queryDatabase() {


    }


    //https://alvinalexander.com/java/java-mysql-select-query-example/

}
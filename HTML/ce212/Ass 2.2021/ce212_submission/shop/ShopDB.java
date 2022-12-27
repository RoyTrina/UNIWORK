package shop;

import java.sql.*;
import java.util.*;


public class ShopDB {
    Connection con;
    static int nOrders = 0;
    static ShopDB singleton;

    public ShopDB() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println("loaded class");
            con = DriverManager.getConnection("jdbc:hsqldb:file:\\tomcat\\webapps\\ass2\\shopdb", "sa", "");
            System.out.println("created con");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static ShopDB getSingleton() {
        if (singleton == null) {
            singleton = new ShopDB();
        }
        return singleton;
    }


    /*public ResultSet getProducts() {
        try {
            Statement s = con.createStatement();
            System.out.println("Created statement");
            ResultSet rs = s.executeQuery("SELECT * FROM PRODUCT");
        } catch (SQLException e) {
            System.out.println("Exception in getProducts(): " + e);
        }
        return null;
    }*/


    public Collection<Product> getAllProducts() {
        return getProductCollection("Select * from Product");
    }

    public Product getProduct(String PID) {
        try {
            // re-use the getProductCollection method
            // even though we only expect to get a single Product Object
            String query = "Select * from Product where PID = '" + PID + "'";
            Collection<Product> c = getProductCollection(query);
            Iterator<Product> i = c.iterator();
            return i.next();

        } catch (Exception e) {
            return null;
        }
    }


    public Collection<Product> getProductCollection(String query) {
        LinkedList<Product> list = new LinkedList<>();
        try {
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Product product = new Product(rs.getString("PID"), rs.getString("Artist"), rs.getString("Title"), rs.getString("Description"), rs.getInt("price"), rs.getString("thumbnail"), rs.getString("full_image"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Exception in getProductCollection(): " + e);
            return null;
        }
    }

    public String ID_generator() {
        Random newRandom = new Random();
        String orderID;
        String letters = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";

        int[] numbers = new int[10];

        String a = String.valueOf(letters.indexOf(newRandom.nextInt(letters.length())));
        String b = String.valueOf(letters.indexOf(newRandom.nextInt(letters.length())));

        for (int i = 0; i <= numbers.length; i++) {
            numbers[i] += i;
        }

        int n1 = Arrays.stream(numbers).iterator().nextInt();
        int n2 = Arrays.stream(numbers).iterator().nextInt();
        int n3 = Arrays.stream(numbers).iterator().nextInt();
        int n4 = Arrays.stream(numbers).iterator().nextInt();
        int n5 = Arrays.stream(numbers).iterator().nextInt();
        int n6 = Arrays.stream(numbers).iterator().nextInt();

        orderID = a + b + n1 + n2 + n3 + n4 + n5 + n6 + nOrders;

        return orderID;
    }

    public void order(Basket basket, String customerName) {
        try {
            // create a unique order id
            String orderId = ID_generator();

            // iterate over the basket of contents ...

            for(int i = 0; i <= basket.getItems(); i++){
                // and place the order for each one
                order(con, product, orderId, customerName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void order(Connection con, Product p, String orderId, String customerName) throws Exception {
        try {
            PreparedStatement preparedStatement =
                    con.prepareStatement("UPDATE ORDERS SET customerName=?, p= ?, orderId = ? where current_user = customerName");

            preparedStatement.setString(1,p.PID);
            preparedStatement.setString(2, orderId);
            preparedStatement.setString(3, customerName);


        } catch (Exception e) {
            System.out.println("Issues in the code");
        }


        // you must write this method
    }
}
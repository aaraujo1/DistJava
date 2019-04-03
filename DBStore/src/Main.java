import models.Cart;
import models.Category;
import models.Inventory;
import models.Product;

import java.sql.*;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        DBCreate dessertDB = new DBCreate();
//        outputDB();
        Inventory inventory = Inventory.getInstance();
        for (Product p: inventory.getProducts()
             ) {
            System.out.println(p);
        }
        //addContent();
        System.out.println("==========================");
        Cart cart = Cart.getInstance();
        for (Map.Entry<Product, Integer> entry: cart.getCart().entrySet()){
            System.out.println("Product: " + entry.getKey() + " Quantity: " + entry.getValue());
        }
        //outputDB();
    }

    public static void addContent() {
        final String DB_URL = "jdbc:derby:DBCreate";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO Dessert " +
                    "VALUES (5, 'Classic Mint Chocolate Brownies' , 'dessert with...',  8.50, 'DESSERT', true)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Dessert " +
                    "VALUES (6, 'Chocolate Whiskey Cupcakes', 'dessert with...', 15.45, 'CAKE', false)";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
            //Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }



}


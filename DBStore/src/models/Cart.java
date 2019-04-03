package models;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    /*----------------------------------------------------------------*/
    /*-------------------------- ATTRIBUTES --------------------------*/
    /*----------------------------------------------------------------*/

    private Map<Product, Integer> cart = new HashMap<Product, Integer>();

    private  Inventory inventory = Inventory.getInstance();

    /*-----------------------------------------------------------------------*/
    /*-------------------------- SINGLETON PATTERN --------------------------*/
    /*-----------------------------------------------------------------------*/

    //null instance of class
    private static Cart instance = null;

    /**
     * private constructor of class
     */
    private Cart(){
        readDB();
    }

    /**
     * check instance of class
     * @return instance
     */
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }


    /*-------------------------------------------------------------*/
    /*-------------------------- METHODS --------------------------*/
    /*-------------------------------------------------------------*/


    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void addToCart(Product p, Integer integer){
        cart.put(p, integer);
    }

    public void readDB() {
        final String DB_URL = "jdbc:derby:DBCreate";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to cart database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Cart";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("ID");
                int cartId  = rs.getInt("CartID");
                String name = rs.getString("DessertName");
                int quantity = rs.getInt("Quantity");


                Product product = inventory.getProductByName(name.trim());

                this.addToCart(product, quantity);

            }
            //STEP 6: Clean-up environment
            rs.close();
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

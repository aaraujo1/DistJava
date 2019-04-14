import models.Cart;
import models.Category;
import models.Inventory;
import models.Product;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //Scanner to talk to user
    private static Scanner k = new Scanner(System.in);
    private static int option = 0;

    public static void main(String[] args) {









//        outputDB();
        System.out.println("==========================");
        System.out.println("Loading Inventory");
        System.out.println("==========================");
        Inventory inventory = Inventory.getInstance();


        System.out.println("==========================");
        System.out.println("Loading Cart");
        System.out.println("==========================");
        Cart cart = Cart.getInstance();



        do {
            menu();

            switch (option){
                case 1:
                    //list inventory
                    inventory.listAllProducts();
                    break;
                case 2:
                    //add item to cart
                    cart.addItemToCart();
                    break;
                case 3:
                    //list cart
                    for (Map.Entry<Product, Integer> entry: cart.getCart().entrySet()){
                        System.out.println("Product: " + entry.getKey() + " Quantity: " + entry.getValue());
                    }
                    break;
                default:
            }

        } while(option!=4);


    }

    public static int menu(){
        do {
            System.out.println("\n==========================");
            System.out.println("MENU");
            System.out.println("==========================");

            /**The program should use a menu to allow the user to list the items,
             * add an item to the cart,
             * and list the contents of the cart.
             */
            System.out.println("Please choose an option\n");
            System.out.println("1. View inventory");
            System.out.println("2. Add item to cart");
            System.out.println("3. View cart");
            System.out.println("4. End Program");

            try {
                option = k.nextInt();

                //if user DID enter an integer, but not a valid one
                if (option < 1 || option > 4) {
                    System.out.println("Please enter 1, 2, 3 or 4.");
                }
            } catch (Exception e) {
                //warn user if they did not enter an integer
                System.out.println("You did not enter a number.");
                //clear Scanner
                k.nextLine();
            }

        }while (option == 0);


        return option;
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


package us.aaraujo1.second.models;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    /*----------------------------------------------------------------*/
    /*-------------------------- ATTRIBUTES --------------------------*/
    /*----------------------------------------------------------------*/

    /**
     * list attribute of product objects
     */
    private List<Product> productsList = new ArrayList<Product>();


    /*-----------------------------------------------------------------------*/
    /*-------------------------- SINGLETON PATTERN --------------------------*/
    /*-----------------------------------------------------------------------*/

    //null instance of class
    private static Inventory instance = null;


    /**
     * private constructor of class
     */
    private Inventory() {
        /*
        productsList.add(Product.getInstance("Peanut Butter Chocolate Dessert"));
        productsList.add(Product.getInstance("Peanut Butter Chocolate Layer Cake"));
        productsList.add(Product.getInstance("Peanut Butter Stuffed Chocolate Cookies"));

*/

        /*productsList.add(Product.getInstance());
        productsList.get(0).setName("Peanut Butter Chocolate Dessert");

        productsList.add(Product.getInstance());
        productsList.get(1).setName("Peanut Butter Chocolate Layer Cake");

        productsList.add(Product.getInstance());
        productsList.get(2).setName("Peanut Butter Stuffed Chocolate Cookies");*/

        /*
        productsList.add(new Product(1,"Peanut Butter Chocolate Dessert", "dessert with...", 15.00, Category.DESSERT, false));
        productsList.add(new Product(2,"Peanut Butter Chocolate Layer Cake", "dessert with...", 25.00, Category.CAKE, true));
        productsList.add(new Product(3,"Peanut Butter Stuffed Chocolate Cookies", "dessert with...", 10.00, Category.COOKIE, true));
        productsList.add(new Product(4,"Chocolate Chip Cookie Dough Cupcakes", "cookie dough", 5.00, Category.CAKE,false));
        */

        //productsList.add(new Product("Peanut Butter Chocolate Dessert)"));

        readDB();
    }

    /**
     * check instance of class
     * @return instance
     */
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    /*-------------------------------------------------------------*/
    /*-------------------------- METHODS --------------------------*/
    /*-------------------------------------------------------------*/

    /**
     * method to get list of products
     * @return list of products as List
     */
    public List<Product> getProducts() {
        return productsList;
    }


    public void listAllProducts(){

        for (Product p: this.getProducts()
        ) {
            System.out.println(p);
        }
    }

    public Product getProductById(int id) {
        for (Product p : productsList) {
            if (p.getId() == (id)) {
                return p;
            }
        }
        return null;
    }

    public Product getProductByName(String name) {
        for (Product p : productsList) {
            if (p.getName().contains(name)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> findProducts(String name) {

        List<Product> productList = new ArrayList<Product>();

        for (Product p : productsList) {
            if (p.getName().contains(name)) {
                productList.add(p);
            }
        }
        return productList;
    }

    public List<Product> getProductsOnSale(){
        List<Product> saleList = new ArrayList<Product>();

        for(Product p: productsList) {
            if (p.isSale()) {
                saleList.add(p);
            }
        }
        return saleList;
    }

    public void addProduct(Product p){
        productsList.add(p);
    }

    public void readDB() {
        final String DB_URL = "jdbc:derby:DBCreate";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to inventory database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Dessert";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("ID");
                String name = rs.getString("DessertName");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                Category category = Category.valueOf(rs.getString("Category").toUpperCase().trim());
                Boolean sale = rs.getBoolean("Sale");



                //Display values
                /*System.out.print("ID: " + id);
                System.out.print(", Dessert Name: " + name);
                System.out.print(", Price: " + price);
                System.out.print("\n");*/

                this.addProduct(new Product(id, name, description, price, category, sale));

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


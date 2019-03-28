import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DessertDB {

    public DessertDB()
    {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:DessertDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Dessert table.
            buildInventoryTable(conn);

            // Build the Cart table.
            buildCartTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the Dessert Table");
            System.out.println(e.getMessage());
        }

    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("Cart table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE Dessert");
                System.out.println("Dessert table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildCoffeeTable method creates the
     * Coffee table and adds some rows to it.
     */
    public static void buildInventoryTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Dessert (" +
                    "ID INTEGER NOT NULL PRIMARY KEY, " +
                    "DessertName VARCHAR(100)," +
                    "Description VARCHAR(250), " +
                    "Price DOUBLE, " +
                    "Category CHAR(25), " +
                    "Sale BOOLEAN" +
                    ")");

            // Insert row #1.
            stmt.execute("INSERT INTO Dessert VALUES ( " +
                    "1,"+
                    "'Peanut Butter Chocolate Dessert',"+
                    "'dessert with...'," +
                    "15.00,"+
                    "'DESSERT'," +
                    "true )");


            // Insert row #2.
            stmt.execute("INSERT INTO Dessert VALUES ( " +
                    "2,"+
                    "'Peanut Butter Chocolate Layer Cake',"+
                    "'dessert with...'," +
                    "25.00,"+
                    "'CAKE'," +
                    "false )");

            // Insert row #3.
            stmt.execute("INSERT INTO Dessert VALUES ( " +
                    "3,"+
                    "'Peanut Butter Stuffed Chocolate Cookies',"+
                    "'dessert with...'," +
                    "10.00,"+
                    "'COOKIE'," +
                    "false )");

            // Insert row #4.
            stmt.execute("INSERT INTO Dessert VALUES ( " +
                    "4,"+
                    "'Chocolate Chip Cookie Dough Cupcakes',"+
                    "'dessert with...'," +
                    "5.00,"+
                    "'CAKE'," +
                    "true )");


            System.out.println("Dessert table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCartTable method creates the
     * Cart table and adds some rows to it.
     */
    public static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Cart( " +
                    " ID INT NOT NULL PRIMARY KEY,"+
                    " CartID INT" +
                    "  DessertName CHAR(100)," +
                    "  Quantity INTEGER)" );


            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO Cart VALUES" +
                    "(1, 1,'Peanut Butter Stuffed Chocolate Cookies', 2)");

            stmt.executeUpdate("INSERT INTO Cart VALUES" +
                    "(2, 1,'Chocolate Chip Cookie Dough Cupcakes', 3)");

            System.out.println("Cart table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}

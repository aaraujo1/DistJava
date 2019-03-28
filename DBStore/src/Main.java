import java.sql.*;

public class Main {

    public static void main(String[] args) {

        DessertDB dessertDB = new DessertDB();
        outputDB();
        addContent();
        System.out.println("==========================");
        outputDB();
    }

    public static void addContent() {
        final String DB_URL = "jdbc:derby:DessertDB";
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


    public static void outputDB() {
        final String DB_URL = "jdbc:derby:DessertDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ID, DessertName, Price FROM Dessert";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("ID");
                String name = rs.getString("DessertName");
                double price = rs.getDouble("Price");


                //Display values
                System.out.print("ID: " + id);
                System.out.println(", Dessert Name: " + name);
                System.out.print(", Price: " + price);

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


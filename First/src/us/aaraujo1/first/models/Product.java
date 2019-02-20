package us.aaraujo1.first.models;

public class Product {
    /*-----------------------------------------------------------------------*/
    /*-------------------------- SINGLETON PATTERN --------------------------*/
    /*-----------------------------------------------------------------------*/
    //null instance of class
    private static Product instance = null;

    /**
     * private constructor of class
     */

    private Product() {
        //setName(name);
    }

    /**
     * check instance of class
     * @return instance
     */

    public static Product getInstance() {
        if (instance == null) {
            instance = new Product();
        }
        return instance;
    }


    /*----------------------------------------------------------------*/
    /*-------------------------- ATTRIBUTES --------------------------*/
    /*----------------------------------------------------------------*/

    /**
     * string attribute of name of product
     */
    private String name;

    /*-------------------------------------------------------------*/
    /*-------------------------- METHODS --------------------------*/
    /*-------------------------------------------------------------*/

    /**
     * method to get name of product
     * @return name of product as string
     */
    public String getName() {
        return name;
    }

    /**
     * method to set name of product
     * @param name name of product as string
     */
    public void setName(String name) {
        this.name = name;
    }
}


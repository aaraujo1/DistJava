package us.aaraujo1.models;



public class Product {
    /*-----------------------------------------------------------------------*/
    /*-------------------------- SINGLETON PATTERN --------------------------*/
    /*-----------------------------------------------------------------------*/
    //null instance of class
    private static Product instance = null;

    /**
     * private constructor of class
     */
    private Product(String name) {
        setName(name);
    }

    /**
     * check instance of class
     *
     * @return instance
     */
    public static Product getInstance(String name) {
        if (instance == null) {
            instance = new Product(name);
        }
        return instance;
    }

    /*----------------------------------------------------------------*/
    /*-------------------------- ATTRIBUTES --------------------------*/
    /*----------------------------------------------------------------*/

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


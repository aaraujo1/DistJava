package us.aaraujo1.second.models;

import java.text.NumberFormat;

public class Product {
    /*-----------------------------------------------------------------------*/
    /*-------------------------- SINGLETON PATTERN --------------------------*/
    /*-----------------------------------------------------------------------*/
    //null instance of class
    //private static Product instance = null;

    /**
     * private constructor of class
     */

    /*private Product() {
        //setName(name);
    }*/

    /**
     * check instance of class
     * @return instance
     */

    /*public static Product getInstance() {
        if (instance == null) {
            instance = new Product();
        }
        return instance;
    }*/

    public Product(int Id, String name, String description, double price, Category category, boolean sale){
        setId(Id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory(category);
        setSale(sale);
    };


    /*----------------------------------------------------------------*/
    /*-------------------------- ATTRIBUTES --------------------------*/
    /*----------------------------------------------------------------*/

    private int id;
    private String name;
    private String description;
    private double price;
    private Category category;
    private boolean sale;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice(){return price;}

    public String getPriceInDollars() {


        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String priceInDollars = (formatter.format(price));


        return priceInDollars;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    /**
     * string attribute of name of product
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


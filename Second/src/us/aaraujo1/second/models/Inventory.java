package us.aaraujo1.second.models;

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

    /*-----------------------------------------------------------------*/
    /*-------------------------- CONSTRUCTOR --------------------------*/
    /*-----------------------------------------------------------------*/

    /**
     * constructor of inventory
     */
    public Inventory() {
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

        productsList.add(new Product(1,"Peanut Butter Chocolate Dessert", "dessert with...", 15.00, Category.DESSERT, false));
        productsList.add(new Product(2,"Peanut Butter Chocolate Layer Cake", "dessert with...", 25.00, Category.DESSERT, false));
        productsList.add(new Product(3,"Peanut Butter Stuffed Chocolate Cookies", "dessert with...", 10.00, Category.DESSERT, false));

        //productsList.add(new Product("Peanut Butter Chocolate Dessert)"));
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


    public Product getProductById(int id) {
        for (Product p : productsList) {
            if (p.getId() == (id)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> findProducts(String name) {

        List<Product> productList = new ArrayList<Product>();

        for (Product p : productsList) {
            if (p.getName().equals(name)) {
                productList.add(p);
            }
        }
        return productList;
    }
}


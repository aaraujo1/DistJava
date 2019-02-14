package us.aaraujo1.models;


import java.util.List;

public class Inventory {

    private List<Product> productsList;

    public Inventory(){

//        productsList.add(Product.getInstance().setName("a"));
        productsList.add(Product.getInstance("Peanut Butter Chocolate Dessert"));
        productsList.add(Product.getInstance("Peanut Butter Chocolate Layer Cake"));
        productsList.add(Product.getInstance("Peanut Butter Stuffed Chocolate Cookies"));
    }

    public List<Product> getProducts(){
        return productsList;
    }


}

package us.aaraujo1.storespring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @RequestMapping("/products")
    public List<Product> getAllSongs() {

        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1,"Peanut Butter Chocolate Dessert", "dessert with...", 15.00, Category.DESSERT, false));
        productsList.add(new Product(2,"Peanut Butter Chocolate Layer Cake", "dessert with...", 25.00, Category.CAKE, true));
        productsList.add(new Product(3,"Peanut Butter Stuffed Chocolate Cookies", "dessert with...", 10.00, Category.COOKIE, true));
        productsList.add(new Product(4,"Chocolate Chip Cookie Dough Cupcakes", "cookie dough", 5.00, Category.CAKE,false));

        return productsList;
    }


}

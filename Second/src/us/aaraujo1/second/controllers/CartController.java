package us.aaraujo1.second.controllers;

import us.aaraujo1.second.models.Category;
import us.aaraujo1.second.models.Inventory;
import us.aaraujo1.second.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet")
public class CartController extends HttpServlet {
    private String RESULT_PAGE = "cart.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with the this domain
        cookies = request.getCookies();
        PrintWriter out = response.getWriter();
        List<Product> productList = new ArrayList();
        productList.add(new Product(0," ","",0.0, Category.DESSERT, false));
        if( cookies != null ) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                out.print(cookie.getValue());
                if (cookie.getName().equals("cartItem")) {
                    productList = orderedItems( cookie.getValue( ));
                }
            }
        }
        request.setAttribute("catalog", productList);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected List<Product> orderedItems(String itemsNumbers) {
        List<Product> productList = new ArrayList<>();
        Inventory inventory = new Inventory();
        String[] nums = itemsNumbers.split(",");
        for (int i=0;i<nums.length;i++) {
            productList.add(inventory.getProductById(Integer.parseInt(nums[i])));
        }
        return productList;
    }
}
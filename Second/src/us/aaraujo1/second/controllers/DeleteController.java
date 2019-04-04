package us.aaraujo1.second.controllers;

import us.aaraujo1.second.models.Category;
import us.aaraujo1.second.models.Inventory;
import us.aaraujo1.second.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class DeleteController extends HttpServlet {
    private String RESULT_PAGE = "cart.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String paramVal = request.getParameter("product");


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
                    /*if(cookie.getValue( ).equals(paramVal)) {
                        productList = orderedItems(cookie.getValue());
                    }*/

                    //if it's a cartItem cookie
                    //change cookie value

                    String cookieValue = deleteItem(cookie.getValue(), paramVal);

                    Cookie newCookie = new Cookie("cartItem", cookieValue);

                    //cookie.setValue(cookieValue);
                    newCookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(newCookie);


                    productList = orderedItems(newCookie.getValue());
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
        Inventory inventory = Inventory.getInstance();
        String[] nums = itemsNumbers.split(",");
        for (int i=0;i<nums.length;i++) {
            productList.add(inventory.getProductById(Integer.parseInt(nums[i])));
        }
        return productList;
    }

    protected String deleteItem(String itemsNumbers, String itemToRemove) {
        //List<Product> productList = new ArrayList<>();
        //Inventory inventory = new Inventory();
        String cookieValue = "";
        String[] nums = itemsNumbers.split(",");
        for (int i = 0; i < nums.length; i++) {
            //check if array item equal item to remove
            if (!nums[i].equals(itemToRemove)) {
                //if it doesn't match, add to list
                cookieValue += nums[i] + ",";
            }
        }
        try{
            cookieValue = cookieValue.substring(0, cookieValue.length() - 1);
        }catch (Exception e){
            //out of bounds
            //java.lang.StringIndexOutOfBoundsException: String index out of range: -1
        }


        return cookieValue;

    }




}

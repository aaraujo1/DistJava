package us.aaraujo1.second.controllers;

import us.aaraujo1.second.models.Cart;
import us.aaraujo1.second.models.DBCreate;
import us.aaraujo1.second.models.Inventory;
import us.aaraujo1.second.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeController extends HttpServlet {

    private String RESULT_PAGE = "home.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    } // </editor-fold>

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


        //creat DB
        DBCreate dessertDB = new DBCreate();


        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        Inventory inventory = Inventory.getInstance();

        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        Cart cart = Cart.getInstance();

        // Always a good idea to trim and/or validate input data
        List<Product> productsOnSale = inventory.getProductsOnSale();

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("productsOnSale", productsOnSale);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Main Controller";
    }// </editor-fold>

}

package us.aaraujo1.second.controllers;

import us.aaraujo1.second.models.Inventory;
import us.aaraujo1.second.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

public class SearchController extends HttpServlet {
    private String RESULT_PAGE = "products.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        /*Enumeration paramNames = request.getParameterNames();
        String paramName = paramNames.nextElement().toString();*/

        String paramVal = request.getParameter("SearchString");


        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        Inventory inventory = new Inventory();


        // Always a good idea to trim and/or validate input data
        List<Product> searchedProductList = inventory.findProducts(paramVal);

        request.setAttribute("productList", searchedProductList);

        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);


    }

    @Override
    public String getServletInfo() {
        return "Main Controller";
    }// </editor-fold>
}

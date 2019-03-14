package us.aaraujo1.second.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class CartPlaceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String theOrder = "";
        String theAmmount = "";

        Cookie[] cookies = null;
        cookies = request.getCookies();

        if( cookies != null ) {
            //a cookie exists
            //for (int i = 0; i < cookies.length; i++) {
            for (Cookie cookie : cookies)

                if (cookie.getName().equals("cartItem")) {

                        theOrder += cookie.getValue() + ",";
                }
        }

        while(paramNames.hasMoreElements()) {
            paramName = (String)paramNames.nextElement();
            if(paramName.equals("cartItem")) {
                String[] paramValues = request.getParameterValues(paramName);
                // Read single valued data
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() == 0)
                        theOrder += "Empty Cart";
                    else
                        theOrder += paramValue;
                } else {
                    for (int i = 0; i < paramValues.length; i++) {
                        theOrder += paramValues[i] + ",";
                    }
                    theOrder = theOrder.substring(0, theOrder.length() - 1);

                    //cookie as an array
                    /*for (int i = 0; i < paramValues.length; i+=2) {
                        theOrder += "[" + paramValues[i] + "," + paramValues[i+1] + "],";
                    }
                    theOrder = theOrder.substring(0, theOrder.length() - 1);*/
                }
            }
        }



            //remake cookie
            Cookie items = new Cookie("cartItem", theOrder);
            // Set expiry date after 24 Hrs for both the cookies.
            items.setMaxAge(60 * 60 * 24);
            response.addCookie(items);



        String site = new String("index.jsp");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}

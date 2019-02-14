package us.aaraujo1;


import us.aaraujo1.models.Inventory;
import us.aaraujo1.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Student Data";
        String docType =
                "<!DOCTYPE html>\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1>" + title + "</h1>\n" +
                "<table>\n" +
                "<tr>\n" +
                "<th>Param Name</th>" +
                "<th>Param Value(s)</th>\n"+
                "</tr>\n"
        );

        out.println("<ul>");

        Inventory inventory = new Inventory();
        for (Product p : inventory.getProducts()
        ) {
            out.println("<li>" + p.getName() + "<li>");
        }

        out.println("</body></html>");



        Enumeration paramNames = request.getParameterNames();



        while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n<td>");
            String[] paramValues = request.getParameterValues(paramName);
            // Read single valued data
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.println("<i>No Value</i>");
                else
                    out.println(paramValue);
            } else {
                // Read multiple valued data
                out.println("<ul>");

                for(int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i]);
                }
                out.println("</ul>");
            }
        }
        out.println("</tr>\n</table>\n");
        String fullName = request.getParameter("full_name");
        String[] comicType = request.getParameterValues("comic_type");
        String company = request.getParameter("company");

        out.println("<hr><h3>Using Parameter Names</h3><ul>\n" +
                "  <li><b>full_name</b>: "
                + fullName + "</li>\n" + "  <li><b>comic_type</b>: ");
        for(int i = 0; i < comicType.length; i++){
            out.println(comicType[i] + ",");
        }
        out.println("</li>\n" + "  <li><b>company</b>: "
                + company + "</li>\n" + "</ul>\n");
        out.println("</body></html>");
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }*/
    protected void doPost(HttpServletResponse response) throws ServletException, IOException {
        //String html = "<html><body>Hi. I received param1=" + request.getParameter("param1") +" via POST</body><html>";

        PrintWriter out = response.getWriter();

        out.println("<html><body>");



        Inventory inventory = new Inventory();
        for (Product p : inventory.getProducts()
        ) {
            out.println("<li>" + p.getName() + "<li>");
        }

        out.println("</body></html>");


        //response.getOutputStream().println(html);
    }
    protected void doGet(HttpServletResponse response) throws ServletException, IOException {
        /*String html = "<html><body>Hi. I received param1=" + request.getParameter("param1") +
                " via GET</body><html>";
        response.getOutputStream().println(html);*/
        PrintWriter out = response.getWriter();

        out.println("<html><body>");



        Inventory inventory = new Inventory();
        for (Product p : inventory.getProducts()
        ) {
            out.println("<li>" + p.getName() + "<li>");
        }

        out.println("</body></html>");


        //response.getOutputStream().println(html)
    }


}
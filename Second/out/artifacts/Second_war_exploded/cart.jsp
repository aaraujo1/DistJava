<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.aaraujo1.second.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: andregaraujo
  Date: 2019-02-27
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/header.html" %>
<!--BODY-->
<div class="container">
    <h1>Cart</h1>
    <form action="bill.go">
        <table>
            <%
                List recs = (List) request.getAttribute("catalog");
                Iterator it = recs.iterator();
                double total = 0;
                while (it.hasNext()) {
                    Product product = (Product) it.next();
                    out.print("<tr class='purch'><td> " + product.getName() + " </td><td>" +
                            String.format("$%3.2f",product.getPrice()) + "</td></tr>");
                    total+=product.getPrice();
                }
                out.print("<tr class='total' ><td>Total:</td><td>" +
                        String.format("$%3.2f",total) + "</td></tr>");
            %>
        </table>
        <input type="submit" value="Complete Order">
    </form>

</div>
<%@ include file="/templates/footer.html" %>
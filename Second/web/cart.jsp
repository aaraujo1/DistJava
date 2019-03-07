<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.aaraujo1.second.models.Product" %>
<%@ page import="java.net.URLEncoder" %><%--
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
            <thead>
            <tr>
                <th scope="col">Product</th>
                <th scope="col"></th>
                <th scope="col">Cost</th>
                <th scope="col"></th>

            </tr>
            <tbody>
            <%
                List recs = (List) request.getAttribute("catalog");
                Iterator it = recs.iterator();
                double total = 0;
                while (it.hasNext()) {
                    Product product = (Product) it.next();
                    out.print("<tr class='purch'><td><img src='./images/" + product.getImage() + "' height='100'></td><td>" +
                            product.getName() + " </td><td>" +
                            product.getPriceInDollars() + "</td>" +
                            /*"<td><button type=\"submit\" class=\"btn btn-danger mb-2\" value=" + product.getId() + " formaction='delete.go' name='delete' >Delete</button> </td>" +*/
                            "<td><a href='delete.go?product=" + product.getId() + "'><button type='button' class='btn btn-danger mb-2' >Delete</button></a> </td>" +
                            "</tr>");
                    total+=product.getPrice();
                }
                out.print("<tr class='total' ><td>Total:</td><td></td><td>" +
                        String.format("$%3.2f",total) + "</td></tr>");
            %>
        </tbody>
        </table>

        <%--<input type="submit" value="Complete Order">--%>
        <button type="submit" class="btn btn-primary mb-2" value="Purchase">Purchase</button>

    </form>

</div>
<%@ include file="/templates/footer.html" %>
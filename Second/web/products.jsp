<%@ page import="us.aaraujo1.second.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="us.aaraujo1.second.models.Inventory" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: andregaraujo
  Date: 2019-02-27
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/header.html" %>
<!--BODY-->
<div class="container">
    <h1>Products</h1>
    <form action="cartplace.go">
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
                List recs = (List) request.getAttribute("productList");
                Iterator it = recs.iterator();
                while (it.hasNext()) {
                    // Notice we're outputting some HTML. Is that a good idea?
                    // Also, notice we do not cast the object returned by the
                    // iterator to a String. Why?
                    Product product = (Product) it.next();
                    out.print("<tr><td><img src='./images/" + product.getImage() + "' height='100'></td><td>" +
                            product.getName() + "</td><td>" + product.getPriceInDollars() +
                            "</td><td><label class='form-check-label' for='product" + product.getId() + "'> Add to Cart </label><input class='form-check-input' type='checkbox' name='cartItem' value=" + product.getId() +
                            " id='product" + product.getId() + "'> </td>");

                    /*out.print("<tr><td>" + product.getName() + "</td><td>" + product.getPrice() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + product.getId()+ "></td></tr>");
                     */
                }
            %>
            </tbody>
        </table>
        <%--<input type="submit" value="Purchase">--%>

        <button type="submit" class="btn btn-primary mb-2" value="Purchase">Purchase</button>

    </form>

</div>

<%@ include file="/templates/footer.html" %>
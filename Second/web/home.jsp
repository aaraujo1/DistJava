<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.aaraujo1.second.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: andregaraujo
  Date: 2/6/19
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/templates/header.html" %>

<!--BODY-->
<div class="container">
  <h1>Products On Sale</h1>
  <form action="cartplace.go">
<table>
  <thead>
  <tr>
    <th scope="col">Product</th>
    <th scope="col"></th>
    <th scope="col">Cost</th>
    <th scope="col">Quantity</th>
  </tr>
  <tbody>
  <%
    List recs = (List) request.getAttribute("productsOnSale");
    Iterator it = recs.iterator();
    while (it.hasNext()) {
      // Notice we're outputting some HTML. Is that a good idea?
      // Also, notice we do not cast the object returned by the
      // iterator to a String. Why?
      Product product = (Product) it.next();

      //cookie as id
      out.print("<tr><td><img src='./images/" + product.getImage() +
              "' height='100'></td><td>" + product.getName() +
              "</td><td>" + product.getPriceInDollars() +
              "</td><td><label class='form-check-label' for='product" + product.getId() +
              "'> Add to Cart </label><input class='form-check-input' type='checkbox' name='cartItem' value=" + product.getId() +
              " id='product" + product.getId() +
              "'> </td>");




      /*out.print("<tr><td>" + product.getName() + "</td><td>" + product.getPrice() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + product.getId()+ "></td></tr>");
*/

      //cookie as an array
      /*out.print("<tr><td><img src='./images/" + product.getImage() + "' height='100'></td><td>" +
              product.getName() + "</td><td>" + product.getPriceInDollars() +
              "</td><td>"+
              "<input class='form-control' type=hidden name='cartItem' value=" + product.getId() + ">" +
              "<input class='form-control' type='number' min=0 placeholder=0 name='cartItem' value='0'"+
              "'> </td>");*/
    }
  %>
</tbody>
</table>
    <%--<input type="submit" value="Purchase">--%>

    <button type="submit" class="btn btn-primary mb-2" value="Purchase">Purchase</button>

  </form>

</div>

<%@ include file="/templates/footer.html" %>
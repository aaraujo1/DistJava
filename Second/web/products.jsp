<%@ page import="us.aaraujo1.second.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="us.aaraujo1.second.models.Inventory" %><%--
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

    <ul>
    <%
        /*List<Product> inventory =
                (List<Product>) request.getAttribute("nameList");*/
        Inventory inventory = new Inventory();
        for (Product p : inventory.getProducts()){
    %>
    <li><a href="?id=<%= p.getId() %>"><%= p.getName() %></a>- $<%= p.getPrice() %></li>

    <%
        }
    %>
    </ul>

    </div>

</div>

<%@ include file="/templates/footer.html" %>
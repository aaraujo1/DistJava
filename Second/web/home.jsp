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
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Shop</title>
  <!--Putting scripts in head before stylesheets-->
  <!--SOURCE: https://stackoverflow.com/questions/9271276/is-the-recommendation-to-include-css-before-javascript-invalid-->
  <!--SOURCE: https://stackoverflow.com/questions/436411/where-should-i-put-script-tags-in-html-markup-->

  <!--SCRIPTS-->
  <!--jQuery-->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
          integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
          crossorigin="anonymous"></script>
  <!--Bootstrap-->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
          integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
          crossorigin="anonymous"></script>

  <!--STYLESHEETS-->
  <!--Bootstrap-->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <!--Google Fonts-->
  <!--Arvo-->
  <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
  <!--Font Awesome-->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
        integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  <!--Site CSS-->
  <link href="site.css?v=1.4" rel="stylesheet">

</head>
<body>
<!--HEADER-->
<nav class="navbar navbar-expand-lg navbar-light">
  <a class="navbar-brand" href="home.jsp">
    <img src="AA-logo.svg" width="50" height="50" alt="André" class="logo">
    André Araujo
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">

      <li class="nav-item">
        <a class="nav-link" href="inventory.go">Products <span class="sr-only">Products</span></a>
      </li>

      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="cart.go"><i class="fas fa-shopping-cart"></i> Cart</a>
      </li>

    </ul>
  </div>
</nav>

<!--BODY-->
<div class="container">
  <form action="cartplace.go">
<ul>
  <%
    List recs = (List) request.getAttribute("productsOnSale");
    Iterator it = recs.iterator();
    while (it.hasNext()) {
      // Notice we're outputting some HTML. Is that a good idea?
      // Also, notice we do not cast the object returned by the
      // iterator to a String. Why?
      Product product = (Product) it.next();
      out.print("<li>" + product.getName() + "- $" + product.getPrice() + " Add to Cart<input type='checkbox' name='cartItem' value=" + product.getId()+ "></li>");

    }
  %>
</ul>
    <input type="submit" value="Purchase">
  </form>

</div>
<!--FOOTER-->
<footer class="footer">
  <div class="container">
    <span class="text-muted">Place sticky footer content here.</span>
  </div>
</footer>


</body>
</html>
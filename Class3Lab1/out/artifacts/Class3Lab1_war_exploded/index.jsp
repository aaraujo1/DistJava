<%--
  Created by IntelliJ IDEA.
  User: andregaraujo
  Date: 2019-02-13
  Time: 19:15
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
  <a class="navbar-brand" href="index.html">
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
        <a class="nav-link" href="#">About <span class="sr-only">About</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
          Shop
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="products.html">Products</a>
          <a class="dropdown-item" href="#">Drawing</a>
        </div>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="fas fa-shopping-cart"></i> Cart</a>
      </li>

    </ul>
  </div>
</nav>
<!--BODY-->
Home

<form action = "sample" method = "Get" target = "_blank">
  Your Name:<input type = "text" name = "full_name"><br>

  <fieldset>
    <legend>Please Select the types of Comics you enjoy.</legend>
    <input type = "checkbox" name = "comic_type" value="Superhero"/>Superhero<br>
    <input type = "checkbox" name = "comic_type"  value="Manga"/>Manga<br>
    <input type = "checkbox" name = "comic_type" value="SciFi"/>Science fiction<br>
    <input type = "checkbox" name = "comic_type" value="Fantasy"/>Fantasy<br>
    <input type = "checkbox" name = "comic_type" value="Horror"/>Horror<br>
    <input type = "checkbox" name = "comic_type" value="Children"/>Children<br>
  </fieldset>

  <fieldset>
    <legend>Please Select your favorite Comic Book .</legend>
    <input type = "radio" name = "company" value="Marvel"/>Marvel Comics<br>
    <input type = "radio" name = "company" value="DC"/>DC Comics<br>
    <input type = "radio" name = "company" value="Dark"/>Dark<br>
    <input type = "radio" name = "company" value="Image Comics"/>Image<br>
    <input type = "radio" name = "company" value="IDW Publishing"/>IDW<br>
    <input type = "radio" name = "company" value="Valiant Comics"/>Valiant<br>
    <input type = "radio" name = "company" value="Shueisha"/>Shueisha<br>
    <input type = "radio" name = "company" value="Shogakukan"/>Shogakukan<br>
    <input type = "radio" name = "company" value="Kobunsha"/>Kobunsha<br>
  </fieldset>

  <input type = "submit" value = "Submit Answers" />
</form>


<footer class="footer">
  <div class="container">
    <span class="text-muted">Place sticky footer content here.</span>
  </div>
</footer>


</body>
</html>
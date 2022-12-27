<%@ page import="shop.Product" %>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB'/>

<jsp:useBean id='basket' scope='session' class="shop.Basket"/>
<!DOCTYPE html>
<html>
<head>
    <title>My Shop</title>
</head>
<style>
    @import "../1703690.css";
</style>
<script src="../1703690.js"></script>
<body>

<h1>Product Information</h1>

<div id="navigation_Bar">
    <button onclick="location.href='../jsp/basket.jsp'">Basket info</button>
    <button onclick="location.href='../jsp/order.jsp'">Order information</button>
    <button onclick="location.href='../index.jsp'">Homepage</button>
</div>


<%
    String pid = request.getParameter("pid");
    Product product = db.getProduct(pid);
    // out.println("pid = " + pid);
    if (product == null) {
        // do something sensible!!!
        System.out.println("The product is not in the database. Please choose another.");
    } else {
%>
<div style="text-align: center">
    <h2><%= product.title %>  by <%= product.artist %>
    </h2>
    <img src="<%= product.full_image %>" alt="image"/>
    <p><%= product.description %>
    </p>
    <p>The price is: <%=product.price %></p>
    <a href="<%=basket.addItem(product)%>">Add to basket</a>

    <%--    <p> add to basket (make this work!!!)</p>--%>
</div>
<%
    }
%>
</body>
</html>

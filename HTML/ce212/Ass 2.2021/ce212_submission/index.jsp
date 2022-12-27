<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="shop.Product, shop.Basket" %>


<jsp:useBean id="db" scope="session" class="shop.ShopDB"/>

<!DOCTYPE html>
<html>
<head>
    <title>Assignment 2</title>
</head>
<style>
    @import "1703690.css";
</style>
<script src="1703690.js"></script>
<body>
<h1>My Shop</h1>
<div id="navigation_Bar">
    <button onclick="location.href='jsp/basket.jsp'">Basket information</button>
    <button onclick="location.href='jsp/order.jsp'">Order information</button>
    <button onclick="location.href='jsp/viewProduct.jsp';">View product information</button>
</div>

<br>
<br>
<div id="shoppingBasket">
    <img src="images/shoppingBasket.png" alt="shoppingBasket">
</div>
<br>
<br>
<br>
<div id="container" onload="itemCounter()">
    <p id="itemCounter"> </p>
</div>
<br>
<br>
<br>
<table id="itemList">
    <tr>
        <th>Title</th>
        <th>Price</th>
        <th>Picture</th>
        <th>Reviews</th>
    </tr>
    <%
        Basket basket = new Basket();
        for (Product product : db.getAllProducts()) {

    %>
    <tr>
        <td><%= product.title%>
        </td>
        <td>£<%= product.toString(product.price)%>
        </td>
        <td><a href="<%="viewProduct.jsp?pid=" + product.PID%>"> <img
                src="<%=product.thumbnail%>" alt="thumbnail"/>
        </a></td>
        <td><label>
            <select id="review">
                <option>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </label></td>
        <td>
            <a href="<%=basket.addItem(product)%>>">Add to basket</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

<button onclick="clearReviews()">Clear reviews</button>

</body>
</html>
<jsp:useBean id='basket'
             scope='session'
             class='shop.Basket'
/>

<jsp:useBean id='db'
             class='shop.ShopDB'/>

<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<style>
    @import "../1703690.css";
</style>
<script src="../1703690.js"></script>
<body>
<h1>Order page</h1>

<div id="navigation_Bar">
    <button onclick="location.href='../index.jsp'">Homepage</button>
    <button onclick="location.href='../jsp/basket.jsp'">Basket info</button>
    <button onclick="location.href='../jsp/viewProduct.jsp'">View product information</button>
</div>

<form action="order.jsp" id="orderID">
    <label>
        <strong>Name:</strong> <input type="text" name="name" required>
    </label>
    <br>
    <br>
    <label>
        <strong>Surname:</strong> <input type="text">
    </label>
    <br>
    <br>
    <label>
        <strong>Email:</strong> <input type="email">
    </label>
    <br>
    <br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

<% String customerName = request.getParameter("name");
    if (customerName != null) {
        db.order(basket, customerName);
        basket.clearBasket();
%>

<p> Dear <%=customerName%>! Thank you for your order. </p>

<div id="orderInfo" onload="<%db.orderID_generator();%>">
    <p> </p>

    <%
    } else {
        System.out.println("Please go back and supply a name");

    %>
    <%
        }

    %>
</div>
</body>
</html>

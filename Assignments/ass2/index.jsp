<%@ page import="shop.Product" %>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB'/>

<html>
<head>
    <title>My Shop</title>
</head>
<body>
<%--insert pictures for artists with hyperlinks to related products--%>
<table>
    <tr>
        <th> Title</th>
        <th> Price</th>
        <th> Picture</th>
    </tr>
    <%
        for (Product product : db.getAllProducts()) {

    %>
    <tr>
        <td><%= product.title %>
        </td>
        <td><%= product.price %>
        </td>
        <td><a href='<%="viewProduct.jsp?pid="+product.description%>'> <img src="<%= product.thumbnail %>"
                                                                            alt="Picture"/> </a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>

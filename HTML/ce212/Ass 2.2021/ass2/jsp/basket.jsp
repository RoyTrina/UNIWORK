<%@ page import="java.util.Collection,                 java.util.Iterator"%><jsp:useBean id='basket'         scope='session'         class='shop.Basket'          /><%    String empty = request.getParameter("emptyBasket");    if (empty!=null) {        basket.clearBasket();    }    String item = request.getParameter("addItem");    basket.addItem(item);%><html><body><% Collection items = basket.getItems();    for (Object o : items) {        out.println("<p>" + o + "</p>");    }    %><p> Order total = <%= basket.getTotalString() %><%    if ( basket.getTotal() > 0) {        %>        <form action="order.jsp" method="post">        <input type="text" name="name" size="20">        <input type="submit" value="Place Order" />        </form>        <form action="basket.jsp" method="get">        <input type="hidden" name="emptyBasket" value="yes">        <input type="submit" value="Empty Basket" />        </form>        <%    }%></body></html>
<%@ page import="java.util.List" %>
<%@ page import="models.Item" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 15.07.2023
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
    <%
        Item item = (Item) request.getAttribute("zat");
        if (item != null) {
    %>
    <form action="/edit-item" method="post">
        <input type="hidden" value="<%=item.getId()%>" name="item_id">
        <label>Name:</label>
        <input type="text" value="<%=item.getName()%>" name="item_name"><br><br>
        <label>Price:</label>
        <input type="number" value="<%=item.getPrice()%>" name="item_price"><br><br>
        <label>Amount:</label>
        <input type="number" value="<%=item.getAmount()%>" name="item_amount">
        <button>EDIT ITEM</button>
    </form>
    <%
        }
    %>
</body>
</html>

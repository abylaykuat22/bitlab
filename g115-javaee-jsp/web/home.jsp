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
    <form action="/add-item" method="post">
        <input type="text" name="name"><br><br>
        <input type="number" name="price"><br><br>
        <input type="number" name="amount"><br><br>
        <button>ADD ITEM</button>
    </form>
    <table class="table table-striped">
        <thead>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>AMOUNT</th>
            <th>DETAILS</th>
        </thead>
        <tbody>
            <%
                List<Item> items = (List<Item>) request.getAttribute("veshi");
                for (Item item : items) {
            %>
            <tr>
                <td><%=item.getId()%></td>
                <td><%=item.getName()%></td>
                <td><%=item.getPrice()%></td>
                <td><%=item.getAmount()%></td>
                <td><a href="/details?id=<%=item.getId()%>" class="btn btn-dark">DETAILS</a></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>

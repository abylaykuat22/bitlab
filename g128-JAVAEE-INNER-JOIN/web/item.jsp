<%@ page import="bitlab.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="bitlab.entity.Item" %><%--
  Created by IntelliJ IDEA.
  User: halykfinance
  Date: 10.10.2024
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
<form action="/item" method="post">
    <input type="text" name="name" placeholder="Insert name..." class="form-control"><br>
    <input type="text" name="description" placeholder="Insert description..." class="form-control"><br>
    <input type="number" name="price" placeholder="Insert price..." class="form-control"><br>
    <select name="brandId" class="form-control">
        <%
            List<Brand> brands = (List<Brand>) request.getAttribute("brandter");
            for (Brand brand : brands) {
        %>
        <option value="<%=brand.getId()%>"><%=brand.getName()%></option>
        <%
            }
        %>
    </select>
    <button class="btn btn-primary">Add item</button>
</form><br>
<table class="table table-bordered table-primary">
    <thead>
    <tr>
        <td><b>NAME</b></td>
        <td><b>DESCRIPTION</b></td>
        <td><b>PRICE</b></td>
        <td><b>BRAND NAME</b></td>d
        <td><b>BRAND COUNTRY</b></td>d
    </tr>
    </thead>
    <tbody>
        <%
            List<Item> items = (List<Item>) request.getAttribute("zattar");
            for (Item item : items) {
        %>
        <tr>
            <td><%=item.getName()%></td>
            <td><%=item.getDescription()%></td>
            <td><%=item.getPrice()%></td>
            <td><%=item.getBrand().getName()%></td>
            <td><%=item.getBrand().getCountry()%></td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
</body>
</html>

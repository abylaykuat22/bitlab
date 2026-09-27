<%@ page import="java.util.List" %>
<%@ page import="models.Phone" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 14.06.2023
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <h1>Salem alem!</h1>
    <a href="/addPhone">ADD PHONE PAGE</a>
    <table class="table table-striped">
        <thead>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>DETAILS</th>
        </thead>
        <tbody>
            <%
                List<Phone> phones = (List<Phone>) request.getAttribute("telefony");
                for (Phone phone : phones) {
            %>
            <tr>
                <td><%=phone.getId()%></td>
                <td><%=phone.getName()%></td>
                <td><%=phone.getPrice()%></td>
                <td><a class="btn btn-dark" href="/phoneDetails?id=<%=phone.getId()%>">DETAILS</a></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>

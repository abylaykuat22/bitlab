<%@ page import="models.Developer" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 27.09.2023
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DETAILS PAGE</title>
</head>
<body>
    <%
        Developer developer = (Developer) request.getAttribute("razrab");
        if (developer != null) {
    %>
    <h1><%=developer.getId()%></h1>
    <h2><%=developer.getName() + " " + developer.getSurname()%></h2>
    <h3><%=developer.getBirthCity()%></h3>
    <h4><%=developer.getAge()%></h4>
    <%
        }
    %>
</body>
</html>

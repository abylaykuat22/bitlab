<%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 14.06.2023
  Time: 19:59
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
<div class="container col-6 mx-auto">
    <form action="/addPhone" method="post">
        <div class="mb-3">
            <label class="form-label">NAME</label>
            <input type="text" class="form-control" name="name">
            <div class="form-text">Insert name.</div>
        </div>
        <div class="mb-3">
            <label class="form-label">DESCRIPTION</label>
            <input type="text" class="form-control" name="description">
            <div class="form-text">Insert description.</div>
        </div>
        <div class="mb-3">
            <label class="form-label">PRICE</label>
            <input type="number" class="form-control" name="price">
            <div class="form-text">Insert price.</div>
        </div>
        <button type="submit" class="btn btn-primary">ADD PHONE</button>
    </form>
</div>
</body>
</html>

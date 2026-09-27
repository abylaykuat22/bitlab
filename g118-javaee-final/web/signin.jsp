<%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 23.10.2023
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body class="col-6 mx-auto">
<form action="/sign-in" method="post" class="mt-5">
    <!-- Email input -->
    <div class="form-outline mb-4">
        <input name="email" type="email" id="form2Example1" class="form-control" />
        <label class="form-label" for="form2Example1">Email address</label>
    </div>

    <!-- Password input -->
    <div class="form-outline mb-4">
        <input name="password" type="password" id="form2Example2" class="form-control" />
        <label class="form-label" for="form2Example2">Password</label>
    </div>

    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
</form>
</body>
</html>

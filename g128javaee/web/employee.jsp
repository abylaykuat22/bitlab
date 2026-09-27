<%@ page import="bitlab.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
<form action="/home" method="post">
    <input type="text" name="name" placeholder="Insert name..." class="form-control"><br>
    <input type="text" name="surname" placeholder="Insert surname..." class="form-control"><br>
    <input type="text" name="department" placeholder="Insert department..." class="form-control"><br>
    <input type="number" name="salary" placeholder="Insert salary..." class="form-control"><br>
    <button class="btn btn-primary">Add employee</button>
</form><br>

<table class="table table-bordered table-primary">
    <thead>
    <tr>
        <td><b>ID</b></td>
        <td><b>NAME</b></td>
        <td><b>SURNAME</b></td>
        <td><b>DEPARTMENT</b></td>
        <td><b>DETAILS</b></td>
    </tr>
    </thead>
    <tbody>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("rabotniki");
        for (Employee employee : employees) {
    %>
    <tr>
        <td><%=employee.getId()%></td>
        <td><%=employee.getName()%></td>
        <td><%=employee.getSurname()%></td>
        <td><%=employee.getDepartment()%></td>
        <td><a href="/employee?id=<%=employee.getId()%>" class="btn btn-dark">DETAILS</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>

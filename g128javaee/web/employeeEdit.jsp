<%@ page import="bitlab.entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body class="container">
<%
       Employee employee = (Employee) request.getAttribute("rabotnik");
       if (employee != null) {
%>
<form action="/employee" method="post">
    <input value="<%=employee.getId()%>" type="hidden" name="id">
    <input value="<%=employee.getName()%>" type="text" name="name" placeholder="Insert name..." class="form-control"><br>
    <input value="<%=employee.getSurname()%>" type="text" name="surname" placeholder="Insert surname..." class="form-control"><br>
    <input value="<%=employee.getDepartment()%>" type="text" name="department" placeholder="Insert department..." class="form-control"><br>
    <input value="<%=employee.getSalary()%>" type="number" name="salary" placeholder="Insert salary..." class="form-control"><br>
    <button class="btn btn-primary">Save changes</button>
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteEmployeeModal">
        Delete
    </button>
</form><br>

<!-- Modal -->
<form action="/employee-delete" method="post">
<div class="modal fade" id="deleteEmployeeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">ARE YOU SURE?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input value="<%=employee.getId()%>" type="hidden" name="id">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                <button type="submit" class="btn btn-primary">YES</button>
            </div>
        </div>
    </div>
</div>
</form>
<%
    }
%>
</body>
</html>

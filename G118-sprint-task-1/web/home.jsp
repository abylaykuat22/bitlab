<%@ page import="java.util.List" %>
<%@ page import="models.Task" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 29.09.2023
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
<%@include file="navbar.jsp" %>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    ADD TASK
</button>

<!-- Modal -->
<form action="/add-task-servlet" method="post">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="task_name" type="text" class="form-control mt-1"
                           placeholder="Insert name...">
                    <input name="task_description" type="text" class="form-control mt-1"
                           placeholder="Insert description...">
                    <input name="task_deadlineDate" type="date" class="form-control mt-1"
                           placeholder="Insert deadline date...">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                    </button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</form>


<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">NAME</th>
        <th scope="col">DESCRIPTION</th>
        <th scope="col">DETAILS</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Task> tasks = (List<Task>) request.getAttribute("zadaniya");
        for (Task task : tasks) {
    %>
    <tr>
        <th scope="row"><%=task.getId()%></th>
        <td><%=task.getName()%></td>
        <td><%=task.getDescription()%></td>
        <td><a href="/task-details?id=<%=task.getId()%>" class="btn btn-dark">DETAILS</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>

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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
<%@include file="navbar.jsp" %>
<div class="col-6 mx-auto">
    <%
        Task task = (Task) request.getAttribute("zadanye");
        if (task != null) {
    %>
    <form action="/task-edit" method="post">
        <input name="task_id" type="hidden" value="<%=task.getId()%>">
        <label>
            <p>NAME:</p>
            <textarea name="task_name" cols="30" rows="3"
                      class="form-control"><%=task.getName()%></textarea>
        </label><br><br>
        <label>
            <p>DESCRIPTION:</p>
            <textarea name="task_description" cols="30" rows="3"
                      class="form-control"><%=task.getDescription()%></textarea>
        </label><br><br>
        <label>
            <p>DEADLINE DATE:</p>
            <input name="task_deadlineDate" type="date" value="<%=task.getDeadlineDate()%>"
                   class="form-control">
        </label>
        <button class="btn btn-success">SAVE CHANGES</button>
    </form>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
            data-bs-target="#removeTaskModal">
        REMOVE TASK
    </button>

    <!-- Modal -->
    <form action="/task-delete" method="post">
        <div class="modal fade" id="removeTaskModal" tabindex="-1"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">ARE YOU SURE?</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input name="task_id" type="hidden" value="<%=task.getId()%>">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                            NO
                        </button>
                        <button type="submit" class="btn btn-primary">YES</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <%
        }
    %>
</div>
</body>
</html>

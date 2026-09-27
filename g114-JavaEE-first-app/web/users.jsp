<%@ page import="java.util.List" %>
<%@ page import="models.Phone" %>
<%@ page import="models.County" %>
<%@ page import="models.User" %>
<%@ page import="models.City" %><%--
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
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#addUserModal">
        CREATE USER
    </button>

    <!-- Modal -->
    <form action="/addUser" method="post">
        <div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">FULL NAME</label>
                            <input type="text" class="form-control" name="fullName">
                            <div class="form-text">Insert name.</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">AGE</label>
                            <input type="number" class="form-control" name="age">
                            <div class="form-text">Insert age.</div>
                        </div>
                        <select name="city.id" class="form-select">
                            <%
                                List<City> cities = (List<City>) request.getAttribute("goroda");
                                for (City city : cities) {
                            %>
                                <option value="<%=city.getId()%>"><%=city.getName() + "/" + city.getCode()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">CREATE USER</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    </div>
    <div class="container">
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>FULL NAME</th>
            <th>AGE</th>
            <th>CITY/CODE</th>
            <th>STREET/INDEX</th>
            </thead>
            <tbody>
                <%
                    List<User> users = (List<User>) request.getAttribute("users");
                    for (User user : users) {
                %>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getFullName()%></td>
                    <td><%=user.getAge()%></td>
                    <td><%=user.getCity().getName() + "/" + user.getCity().getCode()%></td>
                    <td><%=user.getCity().getStreet().getName() + "/" +
                    user.getCity().getStreet().getIndex()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>

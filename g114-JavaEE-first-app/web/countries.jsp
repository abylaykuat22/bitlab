<%@ page import="java.util.List" %>
<%@ page import="models.Phone" %>
<%@ page import="models.County" %><%--
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
    <div class="container">
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>NAME</th>
            <th>SHORT NAME</th>
            </thead>
            <tbody>
            <%
                List<County> counties = (List<County>) request.getAttribute("strany");
                for (County county : counties) {
            %>
            <tr>
                <td><%=county.getId()%></td>
                <td><%=county.getName()%></td>
                <td><%=county.getShortName()%></td>
                <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editCountryModal<%=county.getId()%>">
                        EDIT COUNTRY
                    </button>

                    <!-- Modal -->
                    <form action="/editCountry" method="post">
                        <div class="modal fade" id="editCountryModal<%=county.getId()%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5">Modal title</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" name="id" value="<%=county.getId()%>">
                                        <div class="mb-3">
                                            <label class="form-label">NAME</label>
                                            <input value="<%=county.getName()%>" type="text" class="form-control" name="name">
                                            <div class="form-text">Insert name.</div>
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">SHORT NAME</label>
                                            <input value="<%=county.getShortName()%>" type="text" class="form-control" name="short_name">
                                            <div class="form-text">Insert short name.</div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">EDIT COUNTRY</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addCountryModal">
            ADD COUNTRY
        </button>

        <!-- Modal -->
        <form action="/addCountry" method="post">
        <div class="modal fade" id="addCountryModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">NAME</label>
                            <input type="text" class="form-control" name="name">
                            <div class="form-text">Insert name.</div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">SHORT NAME</label>
                            <input type="text" class="form-control" name="short_name">
                            <div class="form-text">Insert short name.</div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">ADD COUNTRY</button>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</body>
</html>

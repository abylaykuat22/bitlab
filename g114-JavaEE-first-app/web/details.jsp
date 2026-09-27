<%@ page import="models.Phone" %><%--
  Created by IntelliJ IDEA.
  User: Kuat
  Date: 14.06.2023
  Time: 20:18
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
    <%
        Phone phone = (Phone) request.getAttribute("sotka");
        if (phone != null) {
    %>
    <div class="container">
        ID: <b><%=phone.getId()%></b><br><br>
        NAME: <b><%=phone.getName()%></b><br><br>
        DESCRIPTION: <b><%=phone.getDescription()%></b><br><br>
        PRICE: <b><%=phone.getPrice()%></b><br><br>
        <div style="display: flex">
            <div style="margin-right: 10px">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                    DELETE PHONE
                </button>

                <!-- Modal -->
                <form action="/delete" method="post">
                    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" name="id" value="<%=phone.getId()%>">
                                    <h1>ARE U SURE?</h1>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-danger">YES</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editPhoneModal">
                    EDIT PHONE
                </button>

                <!-- Modal -->
                <form action="/editPhone" method="post">
                <div class="modal fade" id="editPhoneModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5">Modal title</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" name="id" value="<%=phone.getId()%>">
                                <div class="mb-3">
                                    <label class="form-label">NAME</label>
                                    <input value="<%=phone.getName()%>" type="text" class="form-control" name="name">
                                    <div class="form-text">Insert name.</div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">DESCRIPTION</label>
                                    <input value="<%=phone.getDescription()%>" type="text" class="form-control" name="description">
                                    <div class="form-text">Insert description.</div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">PRICE</label>
                                    <input value="<%=phone.getPrice()%>" type="number" class="form-control" name="price">
                                    <div class="form-text">Insert price.</div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">SAVE CHANGES</button>
                            </div>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>

    </div>
    <%
        }
    %>

</body>
</html>

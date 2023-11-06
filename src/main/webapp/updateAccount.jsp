<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.AccountService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.Account" %><%--
  Created by IntelliJ IDEA.
  User: DTS
  Date: 03/11/2023
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Update account</title>
</head>
<body>
<%
    String id = request.getParameter("accountId");
    AccountService accountService = new AccountService();
    Account account = accountService.findById(id);
%>
<div class="container w-50">
    <h2 class="text-center">Cập nhật thông tin user</h2>
<form method="post" action="ControlServlet">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="accountIdGrant" value="<%=account.getAccountId()%>">
    <div class="form-group">
        <label for="fullName">FullName: </label>
        <input id="fullName" name="fullName" class="form-control"  value="<%=account.getFullName()%>">
    </div>
    <div class="form-group">
        <label for="password">Password: </label>
        <input id="password" name="password" class="form-control" value="<%=account.getPassword()%>">
    </div>
    <div class="form-group">
        <label for="phone">Phone: </label>
        <input id="phone" name="phone" type="tel" class="form-control"  value="<%=account.getPhone()%>">
    </div>
    <div class="form-group">
        <label for="email">Email: </label>
        <input id="email" name="email" type="email" class="form-control"  value="<%=account.getEmail()%>">
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary">Save</button>
    </div>
</form>
</div>
</body>
</html>

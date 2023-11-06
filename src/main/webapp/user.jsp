<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.AccountService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.Account" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.GrantAccessService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.GrantAccess" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DTS
  Date: 02/11/2023
  Time: 01:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>User</title>
</head>
<body>
<%
    String accountId = request.getParameter("accountId");
    AccountService accountService = new AccountService();
    Account account = accountService.findById(accountId);
    GrantAccessService grantAccessService = new GrantAccessService();
    List<GrantAccess> grantAccesses = grantAccessService.getGrantAccessByAccountId(accountId);
%>
<div class="container">
<h2 align="center">Thông tin người dùng</h2>
    <div class="form-group">
        <label for="fullName">FullName:</label>
        <input id="fullName" name="fullName" class="form-control" disabled value="<%=account.getFullName()%>">
    </div>

    <div class="form-group">
        <label for="phone">Phone:</label>
        <input id="phone" name="phone" type="tel" class="form-control" disabled value="<%=account.getPhone()%>">
    </div>
    <div class="form-group">
        <label for="email">Email:</label>
        <input id="email" name="email" type="email" class="form-control" disabled value="<%=account.getEmail()%>">
    </div>
    <div class="form-group">
        <label for="roles">Roles</label>
        <input id="roles" name="roles" type="text" class="form-control" disabled
        <% for (GrantAccess grantAccess : grantAccesses) {%>
               value="<%=grantAccess.getRole().getRoleId()%>">
        <%}%>
    </div>
<a class="btn btn-danger" href="ControlServlet?action=logOut&">Log out</a>
<a class="btn btn-success" href="${pageContext.request.contextPath}/logs.jsp?accountId=<%=accountId%>">Lịch sử đăng nhập</a>
</div>
</body>
</html>

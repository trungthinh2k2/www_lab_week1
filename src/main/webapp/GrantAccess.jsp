<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.AccountService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.Account" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.GrantAccessService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.GrantAccess" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DTS
  Date: 03/11/2023
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Grant Access</title>
</head>
<body>
<%
    String id = request.getParameter("accountId");
    AccountService accountService = new AccountService();
    Account account = accountService.findById(id);
    GrantAccessService grantAccessService = new GrantAccessService();
    List<GrantAccess> grantAccesses = grantAccessService.getGrantAccessByAccountId(id);

%>
<div class="container">
<form method="post" action="ControlServlet">
    <input type="hidden" name="action" value="grant-access">
    <input type="hidden" name="accountIdGrant" value="<%=account.getAccountId()%>">
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
        <select id="roles">
            <% for (GrantAccess grantAccess : grantAccesses) {%>
            <option value="<%=grantAccess.getRole().getRoleId()%>"><%=grantAccess.getRole().getRoleId()%></option>
            <%}%>
        </select>
    </div>
    <div class="form-group">
        <label for="grantAccess">Grant Access</label>
        <select id="grantAccess" name="grantAccess">
            <option value="user">user</option>
            <option value="admin">admin</option>
        </select>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Save</button>
    </div>
</form>
</div>
</body>
</html>

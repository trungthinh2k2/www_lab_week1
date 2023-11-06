<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.AccountService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.repositories.AccountRepository" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.GrantAccessService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.GrantAccess" %><%--
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
    <title>Dashboard</title>
    <style>
        th{
            border: 1px solid #dddddd;
            text-align: center;
            padding: 8px;
        }

        td{
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
    </style>
</head>
<body>
<%
    AccountRepository accountRepository = new AccountRepository();
    List<Account> accounts = accountRepository.getAll();
%>
<div class="container">
<h2 class="text-center">List account</h2>
<table width="100%" align="center" border="1px">
    <tr content="center" align="center">
        <th>Account Id</th>
        <th>Full Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
        <th colspan="3">Edit</th>
    </tr>
    <% for (Account account: accounts) { %>
    <tr>
        <td><%=account.getAccountId()%></td>
        <td><%=account.getFullName()%></td>
        <td><%=account.getPassword()%></td>
        <td><%=account.getEmail()%></td>
        <td><%=account.getPhone()%></td>
        <td><%=account.getStatus()%></td>
        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/updateAccount.jsp?accountId=<%= account.getAccountId() %>">Update</a></td>
        <td><a class="btn btn-danger" href="ControlServlet?action=delete-account&accountIdDelete=<%= account.getAccountId() %>">Delete</a></td>
        <td><a class="btn btn-success" href="${pageContext.request.contextPath}/GrantAccess.jsp?accountId=<%= account.getAccountId() %>">Grant Access</a></td>
    </tr>
    <%}%> <br>
</table>
    <div>
        <a class="btn btn-success mt-3" href="insertByAdmin.jsp">Insert Account</a>
        <a class="btn btn-danger" href="ControlServlet?action=logOut&">Log out</a>
    </div>
</div>
</body>
</html>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.services.LogService" %>
<%@ page import="vn.edu.iuh.fit.www_lab_week1.models.Log" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DTS
  Date: 03/11/2023
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Logs</title>
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
<div class="container"></div>
<h2 class="text-center">Lịch sử truy cập</h2>
<%
    String accountId = request.getParameter("accountId");
    LogService logService = new LogService();
    List<Log> logs = logService.getLogsByAccountId(accountId);
%>
    <table width="70%" align="center" border="1px">
        <tr>
            <th>LogId</th>
            <th>AccountID</th>
            <th>Login Time</th>
            <th>Logout Time</th>
            <th>Notes</th>
        </tr>
        <% for (Log log: logs) {

        %>
        <tr>
            <td><%= log.getId() %></td>
            <td><%=log.getAccountId()%></td>
            <td><%= log.getLoginTime() %></td>
            <td><%= log.getLogoutTime() %> </td>
            <td><%= log.getNotes() %></td>
        </tr>
        <%}%>

    </table>
</body>
</html>

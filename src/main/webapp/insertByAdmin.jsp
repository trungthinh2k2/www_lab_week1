<%--
  Created by IntelliJ IDEA.
  User: DTS
  Date: 03/11/2023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Insert By Admin</title>
</head>
<body>
<div class="container justify-content-center">
<h2 class="text-center">Insert by admin</h2>
<form action="ControlServlet" method="post">
    <div class="mb-3">
        <%--@declare id="id"--%>
        <label for="accountId" class="form-label">AccountId: </label>
        <input type="text" class="form-control" id="accountId" name="accountId" required>
    </div>
    <div class="mb-3">
        <label for="fullName" class="form-label">Full Name: </label>
        <input type="text" class="form-control" id="fullName" name="fullName" required>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password: </label>
        <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email: </label>
        <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Phone: </label>
        <input type="tel" class="form-control" id="phone" name="phone" required>
    </div>
    <br>
    <div class="mb-3 col-md-3">
        <button type="submit" class="btn btn-primary btn-block">Insert</button>
        <input type="hidden" name="action" value="insert-by-admin">
    </div>
</form>
</div>
</body>
</html>

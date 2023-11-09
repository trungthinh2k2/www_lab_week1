<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>
<div class="container">
    <h2>Đăng nhập tài khoản</h2>
<form method="post" action="ControlServlet">
    <input type="hidden" name="action" value="login">
    <div>
        <label for="username">Username: </label>
        <input id="username" name="username">
    </div>
    <div>
        <label for="password">Password: </label>
        <input type="password" id="password" name="password">
    </div>
    <div>
        <button type="submit" class="btn btn-success btn-sm">Đăng nhập</button>
        <input type="hidden" name="action" value="login">
    </div>

</form>
</div>
</body>
</html>
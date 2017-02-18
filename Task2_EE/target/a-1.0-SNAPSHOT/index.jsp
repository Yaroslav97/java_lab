<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
HelloUser
<br>

<form action="mainServlet" method="post">
    Login: <input type="text" name="login">
    <br>
    Password: <input type="password" name="password">
    <br>
    <input type="submit" value="Login">

</form>

</body>
</html>

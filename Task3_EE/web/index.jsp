<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<center><h2>Hola!</h2></center>
<br>

<form action="mainServlet" method="post">
    Login:
    <br>
    <input type="text" name="login">
    <br>
    <br>
    Password:
    <br>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>
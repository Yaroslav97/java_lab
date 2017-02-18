<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="../error.jsp" %>

<html>
<head>
    <title>add</title>
</head>
<body>
<form action="/addUserServlet" method="post">
    Name:<br>
    <input name="addName">
    <br>
    <br>
    Login:<br>
    <input name="addLogin">
    <br>
    <br>
    Email:<br>
    <input type="email" name="addEmail">
    <br>
    <br>
    Password:<br>
    <input  type="password" name="addPassword">
    <br>
    <br>
    Group:<br>
    <select name="addGroup">
        <option selected value="user">user</option>
        <option value="admin">admin</option>
    </select>
    <br>
    <br>
    <input type="submit" value="add" name="add">
</form>
</body>
</html>
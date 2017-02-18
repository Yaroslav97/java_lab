<%--
  Created by IntelliJ IDEA.
  User: comteh
  Date: 03.11.2016
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="../error.jsp" %>

<html>
<head>
    <title>add</title>
</head>
<body>
<form action="/addUserServlet">
    Login: <input name="addLogin">
    <br>
    Name: <input name="addName">
    <br>
    Email: <input type="email" name="addEmail">
    <br>
    Password: <input  type="password" name="addPassword">
    <br>
    <input type="submit" value="add" name="add">

</form>
</body>
</html>

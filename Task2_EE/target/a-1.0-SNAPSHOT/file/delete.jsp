<%--
  Created by IntelliJ IDEA.
  User: comteh
  Date: 03.11.2016
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>

<center><h1>${delLogin}</h1></center>
<br>
<form action="/deleteServlet" method="get">
    <input type="submit" value="remove" name="del">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: comteh
  Date: 10.10.2016
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>

<%@ page import="java.util.*" %>
<html>
<head>
    <title>Canculator</title>
</head>
<body>
Hello, Servlet!!!
<br>
<form action="/call" method="get">
    <input name="x"><br>
    <input name="y"><br>


    <select name="operation">
        <option selected value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>

    <br>

    <input type="submit" value="submit">

</form>
</body>
</html>

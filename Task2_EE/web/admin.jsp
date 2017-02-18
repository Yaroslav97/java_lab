<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="ua.nure.poliakov.Task2.user.UserManager" %>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>administrator</title>
</head>
<body>

<h1>SuperAdmin</h1>

<style type="text/css">
    table {
        border-collapse: collapse;
    }

    table th,
    table td {
        padding: 0 3px;
    }

    table.brd th,
    table.brd td {
        border: 1px solid #000;
    }
</style>

<form action="/userServlet" method="get">
    <input type="submit" value="logout" name="logout">
</form>

<h3>Hello, Super ${login} </h3>

<h4>admin table</h4>
<table class="brd">
    <tr>
        <th>login</th>
        <th>name</th>
        <th>email</th>
    </tr>

    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.fullName}</td>
            <td>${user.email}</td>
            <td><a href="/editForward?eLogin=${user.login}&eEmail=${user.email}&eFullName=${user.fullName}&ePassword=${user.password}">edit</a></td>
            <td><a href="/removeServlet?delLogin=${user.login}">delete</a></td>
        </tr>
    </c:forEach>

    <a href="/file/add.jsp?">add user</a>

</table>
</body>
</html>

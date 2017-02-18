<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>user</title>
</head>
<body>


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

<br>

<h3>Hello, ${login} </h3>
<table class="brd">
    <tr>
        <th>login</th>
        <th>name</th>
        <th>email</th>
    </tr>

    <c:forEach items="${usersList}" var="users">
        <tr>
            <td>${users.login}</td>
            <td>${users.fullName}</td>
            <td>${users.email}</td>
            <c:choose>
                <c:when test="${users.login == login}">
                    <td><a href="/editForward?eLogin=${login}">Edit</a></td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>

</body>
</html>

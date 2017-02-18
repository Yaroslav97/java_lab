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

<form action="/userServlet" method="post">
    <input type="submit" value="logout" name="logout">
</form>

<br>

<h3>Hello, ${fullName} </h3>
<table class="brd">
    <tr>
        <th>fullName</th>
        <th>login</th>
        <th>email</th>
    </tr>

    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>${user.fullName}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <c:choose>
                <c:when test="${user.login == login}">
                    <%--<td><a href="/editForward?eLogin=${login}">Edit</a></td>--%>
                    <td><a href="/editForward?eLogin=${user.login}&eEmail=${user.email}&eFullName=${user.fullName}">edit</a></td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>

</body>
</html>
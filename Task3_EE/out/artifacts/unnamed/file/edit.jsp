<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<h1>Edit: ${eLogin}</h1>
<form action="/editServlet" method="post">
    FullName: <br>
    <input name="editName" value="${eFullName}">
    <br>
    <br>
    Email: <br>
    <input type="email" name="editEmail" value="${eEmail}">
    <br>
    <br>
    Password: <br>
    <input type="password" name="editPassword">
    <br>
    <br>
    <input type="submit" value="edit" name="edit">
</form>
</body>
</html>
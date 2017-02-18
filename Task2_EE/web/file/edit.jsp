<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<h1>${eLogin}</h1>
<form action="/editServlet" method="get">
    FullName: <input name="editName">
    <br>
    Email: <input type="email" name="editEmail">
    <br>
    Password: <input type="password" name="editPassword">
    <br>
    <input type="submit" value="edit" name="edit">
</form>
</body>
</html>

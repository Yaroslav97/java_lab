<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>

<h2>Remove: ${delLogin}</h2>
<br>
<form action="/removeServlet" method="post">
    <input type="submit" value="remove" name="del">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Minh Duc
  Date: 12/13/2022
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h3 style="color:red">${message}</h3>
<form action="validate" method="post">
  <input type="text" name="email"><br>
  <input type="submit" value="Validate">
</form>
</body>
</html>

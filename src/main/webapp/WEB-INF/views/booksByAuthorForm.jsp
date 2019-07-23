<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Find book by author</h1>
<form action="books_by_author"method="get">
    Title:<br>
    <input type="text" value="Joshua Bloch" name="author"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

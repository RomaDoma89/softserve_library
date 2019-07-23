<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../menu.jsp"%>
<h1>Find book by title</h1>
<form action="bookTitle"method="get" class="dws-menu">
    Title:<br>
    <input type="text" value="Effective Java" name="title"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

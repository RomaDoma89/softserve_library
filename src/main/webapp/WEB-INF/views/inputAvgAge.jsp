<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 23.07.2019
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <%@include file="/menu.jsp"%>
</head>
<body>
<form action="avgAgeServlet" method="get" style=" text-align: center; padding-top: 50px">
    Введіть назву книги: <br>
    <input type="text" name="title" style="width: 200px">
    <br>
    Введіть ім'я автора: <br>
    <input type="text" name="author" style="width: 200px">
    <br>
    <input type="submit" style="text-align: center" value="Submit">
</form>

</body>
</html>

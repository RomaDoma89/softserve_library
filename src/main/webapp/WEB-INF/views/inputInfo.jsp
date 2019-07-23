<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 23.07.2019
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/menu.jsp"%>
</head>
<body>
<form action="getInfoServlet" method="get" style=" text-align: center; padding-top: 50px">
    Введіть назву книги щоб отримати статистику: <br>
    <input type="text" name="title" style="width: 200px"><br>
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>

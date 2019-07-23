<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 22.07.2019
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/menu.jsp"%>
</head>
<body>
<form action="bookStatistic" method="get" style=" text-align: center; padding-top: 50px">
    Input title of book<br>
    <input type="text" name="title" style="width: 200px">
    <br>
    <br>
    <input type="submit" style="text-align: center" value="Submit">
</form>
</body>
</html>

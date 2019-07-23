<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 23.07.2019
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/menu.jsp"%>
</head>
<body>
<form action="getPopularServlet" method="get" style=" text-align: center; padding-top: 50px">
    Input first date in format(yyyy-MM-dd)<br>
    <input type="text" name="date1" style="width: 200px"><br>
    Input second date in format(yyyy-MM-dd)<br>
    <input type="text" name="date2" style="width: 200px"><br>
    <input type="submit" value="Submit">
</form>


</body>
</html>

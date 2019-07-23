<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 22.07.2019
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/menu.jsp"%>
</head>
<body>
<form action="getByPeriodServlet" method="get" style=" text-align: center; padding-top: 50px">
    Input first date in format(yyyy-MM-dd)<br>
    <input type="text" name="firstInput" style="width: 200px">
    <br>
    Input second date in format(yyyy-MM-dd)
    <br>
    <input type="text" name="secondInput" style="width: 200px"><br>
    <input type="submit" value="Submit">
</form>



</body>
</html>

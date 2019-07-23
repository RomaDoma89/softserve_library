<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 23.07.2019
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../menu.jsp"%>
<h1>Fill in scope of period in  format "yyyy-mm-dd"</h1>
<form action="readerAverageAppeal"method="get">
    from:<br>
    <input type="text" value="2015-01-11" name="fromDate"><br>
    to:<br>
    <input type="text" value="2019-07-11" name="toDate"><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>

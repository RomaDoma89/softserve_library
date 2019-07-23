<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 23.07.2019
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}tableCss.css">
<html>
<head>
    <title>Title</title>
    <%@include file="/menu.jsp"%>
</head>
<body>
<table class="simple-little-table" cellspacing='0' style="text-align: center; margin: auto; margin-top: 50px">
    <thead>
    <tr>
        <th>Найбільший рейтинг має: ${popular} </th>
    </tr>
    <tr>
        <th>Найменший рейтинг: ${notPopular}</th>
    </tr><!-- Table Header -->
    </thead>
</table>
</body>
</html>

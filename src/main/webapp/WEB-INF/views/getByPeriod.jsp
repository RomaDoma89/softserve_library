<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 22.07.2019
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}tableCss.css">
<html>
<head>
    <title>Title</title>
    <%@include file="/menu.jsp"%>
</head>
<body>
<table class="simple-little-table" cellspacing='0' style="text-align:center; margin: auto; margin-top: 50px">
    <thead>
    <tr>
        <th>Кількість книг виданих за вказаний період: ${count}</th>
    </tr><!-- Table Header -->
    </thead>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}tableCss.css">
<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 21.07.2019
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Available book</title>
</head>
<body>
<%@include file="../../menu.jsp"%>
<table class="simple-little-table" cellspacing='0' style="text-align: center; margin: auto; margin-top: 50px">
    <thead>
    <tr>
        <th>Назва книги: ${bookDto.title} </th>
    </tr>
    <tr>
        <th>Кількість доступних екземплярів: ${bookDto.available}</th>
    </tr><!-- Table Header -->
    </thead>
</table>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 22.07.2019
  Time: 19:39
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
<table class="simple-little-table" cellspacing='0' style="text-align: center; margin: auto; margin-top: 50px">
    <thead>
        <tr>
            <th><strong>Кількість читачів які читали книгу: ${using}</strong></th>
            <th><strong>Середній час читання даної книги становить: ${avgReading}</strong> години</th>
        </tr>
        <tr>
            <th>ID копії</th>
            <th>Назва</th>
            <th>К-ть людей які читали</th>
        </tr><!-- Table Header -->
    </thead>
    <tbody>
    <c:forEach var="per" items="${list}">
        <tr>
            <td><c:out value="${per.idCopy}"/></td>
            <td><c:out value="${per.title}"/></td>
            <td><c:out value="${per.count}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

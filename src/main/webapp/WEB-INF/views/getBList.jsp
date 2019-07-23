<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 22.07.2019
  Time: 19:39
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
        <th>ID </th>
        <th>Ім'я</th>
        <th>Дата народження</th>
    </tr><!-- Table Header -->
    </thead>
    <tbody>
    <c:forEach var="per" items="${list}">
        <tr>
            <td><c:out value="${per.user_id}"/></td>
            <td><c:out value="${per.name}"/></td>
            <td><c:out value="${per.dateOfBirthday}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

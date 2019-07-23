<%--
  Created by IntelliJ IDEA.
  User: dovga
  Date: 23.07.2019
  Time: 10:53
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
        <th>Назва</th>
        <th>ID копії</th>
        <th>Чи доступна (1 - доступна, 0 - зайнята)</th>
    </tr><!-- Table Header -->
    </thead>
    <tbody>
    <c:forEach var="per" items="${list}">
        <tr>
            <td><c:out value="${per.title}"/></td>
            <td><c:out value="${per.idCopy}"/></td>
            <td><c:out value="${per.available}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

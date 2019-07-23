<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<link rel="stylesheet" href="${pageContext.request.contextPath}tableCss.css">
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/menu.jsp"%>
<table class="simple-little-table" cellspacing='0' style="text-align: center; margin: auto; margin-top: 50px">
    <thead>
    <tr>
        <th text>Книги які читач не повернув: ${name}</th>
    </tr>
    <tr>
        <th>Книга #</th>
        <th>Назва книги</th>
    </tr><!-- Table Header -->
    </thead>
    <tbody>
    <c:forEach var="reader" varStatus="loop" items="${listOfBook}">
        <tr>
            <td><c:out value="${loop.index+1}"/></td>
            <td><c:out value="${reader.title}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

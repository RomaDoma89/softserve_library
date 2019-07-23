<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 13:34
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
            <th>Назва книги</th>
            <th>Автор</th>
        </tr><!-- Table Header -->
        </thead>
        <tbody>
        <c:forEach var="reader" items="${listBookDto}">
            <tr>
                <td><c:out value="${reader.title}"/></td>
                <td><c:out value="${reader.author}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 18:05
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
<form action="books_by_author"method="get" style="text-align: center; padding-top: 50px">
   <p>Введіть назву:</p>
    <input type="text" value="Joshua Bloch" name="author">
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

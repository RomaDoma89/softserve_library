<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 23.07.2019
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}tableCss.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/menu.jsp" %>
<table class="simple-little-table" cellspacing='0' style="text-align: center; margin: auto; margin-top: 50px">
    <thead>
    <tr>
        <th>Середня кількість звернень з ${fromDate} по ${toDate} дорівнює ${readerDto.averageAppeal} разів</th>
    </tr>
    </thead>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 22:00
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

<h1>${name} have been registered in library since: ${readerDto.localDate} </h1>
<table class="simple-little-table" cellspacing='0' style="text-align: center; margin: auto; margin-top: 50px">
    <thead>
    <tr>
        <th>${name} зареєстрований з такого часу: ${readerDto.localDate}</th>
    </tr><!-- Table Header -->
    </thead>
</table>

</body>
</html>

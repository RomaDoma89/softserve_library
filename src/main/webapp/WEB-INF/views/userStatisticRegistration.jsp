<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../menu.jsp"%>

<h1>${name} have been registered in library since: ${readerDto.localDate} </h1>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<p>Title: ${bookDto.title}</p>
<p>Available: ${bookDto.available}</p>


</body>
</html>

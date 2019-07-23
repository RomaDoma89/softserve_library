<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../menu.jsp"%>
<h1>Books witch have been read  by reader:${name}</h1>

<div>
    <table >
        <tr>
            <th>Book #</th>
            <th>Book title</th>
        </tr>
        <c:forEach items="${listOfBook}" var="reader" varStatus="loop" >
            <tr>
                <td>
                        ${loop.index+1}
                </td>
                <td>
                        ${reader.title}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

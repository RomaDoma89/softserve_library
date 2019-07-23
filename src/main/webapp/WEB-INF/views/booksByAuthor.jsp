<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Author books</title>
</head>
<body>
<%@include file="../../menu.jsp"%>
<div>
    <table >
        <tr>
            <th>Book title</th>
            <th>Author</th>
        </tr>
        <c:forEach items="${listBookDto}" var="reader" >
           <tr>
              <td>
                  ${reader.title}
               </td>
               <td>
                   ${reader.author}
               </td>
           </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

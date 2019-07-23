<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 22.07.2019
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/menu.jsp"%>

<form action="userStatisticName"method="get" style=" text-align: center; padding-top: 50px">
    <p>Введіть ім'я користувача</p>
    <input type="text" value="Susan Goodwin" name="name">
    <br>
    <select name="select">
        <option value="value1"selected>Які книжки брав</option>
        <option value="value2" >Які на руках</option>
        <option value="value3">Дата реєстрації</option>
    </select>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

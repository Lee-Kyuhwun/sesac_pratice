<%--
  Created by IntelliJ IDEA.
  User: dlrbg
  Date: 2023-07-10
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<ul>
  <c:forEach var="dto" items="${dtoList}">
    <li>
      ${dto}
    </li>
  </c:forEach>
</ul>
</body>
</html>


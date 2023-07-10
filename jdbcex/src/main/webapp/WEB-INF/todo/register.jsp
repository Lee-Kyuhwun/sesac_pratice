<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Todo Registration</title>
</head>
<body>
<h1>Todo Registration</h1>

<form action="/todo/register" method="post">
  <div>
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" placeholder="Insert title">
  </div>
  <div>
    <input type="date" id="dueDate" name="dueDate">
  </div>
  <div>
    <button type="reset">Reset</button>
    <button type="submit">Register</button>
  </div>
</form>

</body>
</html>

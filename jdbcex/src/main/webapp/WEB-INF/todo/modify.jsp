<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Todo Modify</title>
</head>
<body>
<h1>Todo Modify</h1>

<form id="form1" action="/todo/modify" method="post">
<div>
  <h2>Tno:</h2>
  <input type="text" name="tno" value="${dto.tno}" readonly/>
</div>

<div>
  <h2>Title:</h2>
  <input type="text" name="title" value="${dto.title}" />
</div>

<div>
  <h2>Due Date:</h2>
  <input type="date" name="dueDate" value="${dto.dueDate}"/>
</div>

<div>
  <h2>Finished:</h2>
  <input type="checkbox" name="finished" ${dto.finished ? 'checked' : ''} />
</div>

<div>
  <button type="submit">Modify</button>
</div>

</form>


<form id="form2" action="${pageContext.request.contextPath}/todo/remove" method="post">
  <input type="hidden" name="tno" value="${dto.tno}" readonly>
  <div>
    <button type="submit">Remove</button>
  </div>

</form>


</body>
</html>
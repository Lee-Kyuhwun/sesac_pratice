<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<h1>Todo Read</h1>


    <div>
        <h2>Tno:</h2>
        <input type="text" name="tno" value="${dto.tno}" readonly/>
    </div>

    <div>
        <h2>Title:</h2>
        <input type="text" name="title" value="${dto.title}" readonly/>
    </div>

    <div>
        <h2>Due Date:</h2>
        <input type="date" name="dueDate" value="${dto.dueDate}"/>
    </div>

    <div>
        <h2>Finished:</h2>
        <input type="checkbox" name="finished" ${dto.finished ? 'checked' : 'readonly'} />
    </div>

    <div>
        <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
        <a href="/todo/list">List</a>
    </div>


</body>
</html>

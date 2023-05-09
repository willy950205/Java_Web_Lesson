<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-03
  Time: 오후 5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo Read Page</title>
</head>
<body>
  <h1>Todo Read Page</h1>
  <div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
  </div>
  <div>
    <input type="text" name="title" value="${dto.title}" readonly>
  </div>
  <div>
    <input type="date" name="dueDate" value="${dto.dueDate}" readonly>
  </div>
  <div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly>
  </div>
  <div>
    <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
    <a href="/todo/list">List</a>
  </div>

</body>
</html>

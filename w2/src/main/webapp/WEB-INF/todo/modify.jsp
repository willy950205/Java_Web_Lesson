<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-03
  Time: 오후 5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Modify Page</title>
</head>
<body>
  <h1>Todo Modify Page</h1>
  <form id="form1" action="/todo/modify" method="post">
    <div>
      <input type="text" name="tno" value="${dto.tno}" readonly>
    </div>
    <div>
      <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
      <input type="date" name="dueDate" value="${dto.dueDate}">
    </div>
    <div>
      <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""}>
    </div>
    <div>
      <button type="submit">Modify</button>
    </div>
  </form>

  <form id="form2" action="/todo/remove" method="post">
    <input type="hidden" value="${dto.tno}" name="tno" readonly>
    <button type="submit">Remove</button>
  </form>

</body>
</html>

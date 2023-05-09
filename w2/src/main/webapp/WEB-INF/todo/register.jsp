<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-03
  Time: 오후 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register Page</title>
</head>
<body>
    <% request.setCharacterEncoding("UTF-8"); %>
    <form action="/todo/register" method="post" accept-charset="UTF-8">
        <div>
            <input type="text" name="title" placeholder="INSERT TITLE">
        </div>
        <div>
            <input type="date" name="dueDate">
        </div>
        <div>
            <button type="reset">RESET</button>
            <button type="submit">REGISTER</button>
        </div>
    </form>
</body>
</html>

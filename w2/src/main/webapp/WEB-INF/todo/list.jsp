<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-05-03
  Time: 오후 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
    <% request.setCharacterEncoding("UTF-8"); %>
    <h1>Todo List</h1>
    <h2>${appName}</h2>
    <h2>${loginInfo}</h2>
    <h2>${loginInfo.mname}</h2>
    <ul>
        <c:forEach items="${dtoList}" var="dto">
            <li>
                <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
                <span>${dto.title}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.finished? "DONE":"NOT YET"}</span>
            </li>
        </c:forEach>
    </ul>

    <form action="/logout" method="post">
        <button>LOGOUT</button>
    </form>

</body>
</html>

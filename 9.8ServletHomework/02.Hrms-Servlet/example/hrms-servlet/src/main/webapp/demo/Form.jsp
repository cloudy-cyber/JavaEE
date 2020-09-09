<%--
  Created by IntelliJ IDEA.
  User: liyi
  Date: 2020/9/8
  Time: 1:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  /contextpath/fromtest --%>
<form action="<%= request.getContextPath()+ "/formtest"%>">
    <input type="text" name="username">
    <input type="submit">
</form>
</body>
</html>

<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>$Title$</title>
    <jsp:useBean id="dao" class="dao.UserDao" scope="request"/>
</head>
<body>
<%
    User user=dao.findByLoginname("tom");
%>
<input type="text" name="userId" value="<%=user.getUserId()%>"/>
<input type="text" name="userName" value="<%=user.getUserName()%>"/>
<input type="text" name="password" value="<%=user.getPassword()%>"/>
$END$
</body>
</html>

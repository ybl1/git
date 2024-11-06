<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%@ page import="dao.UserDao" %>
<html>
<head>
    <title>删除用户</title>
    <jsp:useBean id="dao" class="dao.UserDao" scope="request"/>
</head>
<body>
<%
    Integer userid = Integer.valueOf(request.getParameter("uid"));
    User user = dao.findByUserId(userid); // 获取用户信息
%>
<h3>确认删除用户：<%= user.getUserName() %> (ID: <%= user.getUserId() %>)</h3>
<form method="get" action="/test/DeleteUser">
    <input type="hidden" name="uid" value="<%= userid %>"/>
    <input type="submit" value="确认删除" onclick="return confirm('提示:确定删除此用户？');"/>
</form>
<input type="button" value="取消" onclick="javascript:window.history.back();"/>
</body>
</html>

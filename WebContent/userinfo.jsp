<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>用户管理</title>
    <jsp:useBean id="dao" class="dao.UserDao" scope="request"/>
</head>
<body>
<% List<User> list = dao.listAll();%>
用户名：
<input type="text" id="userName" name="userName" />
<input type="button" id="btnQuery" value="查询" onclick="javascript:window.location.href='queryUser.jsp?userName='+document.getElementById('userName').value;" />
<br>
<table border="1" bgcolor="#e0ffff">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>角色</th>
        <th>状态</th>
        <th>删除</th>
    </tr>
    <%
        for (User user : list) {
    %>
    <tr>
        <td><a href="editUser.jsp?uid=<%= user.getUserId()%>"><%= user.getUserId() %>
        </a></td>
        <td><%= user.getUserName()%>
        </td>
        <td><%= user.getPassword()%>
        </td>
        <td><%= user.getRole()%>
        </td>
        <td><%= user.getStatus()%>
        </td>
        <td><a href="DeleteUser?uid=<%= user.getUserId()%>" onclick="return confirm('提示:确定删除此用户？')">删除</a></td>
    </tr>
    <%}%>
</table>
<br>
<table  bgcolor=lightgrey><tr ><td ><a href="addUser.jsp">添加用户</a></td></tr></table>
</body>
</html>

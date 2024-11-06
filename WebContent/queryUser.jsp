<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<head>
    <title>查询</title>
    <jsp:useBean id="dao" class="dao.UserDao" scope="request"/>
</head>
<body>
<%
    String userName=  request.getParameter("userName"); 
    List<User> list =  dao.findByUserName(userName)  ;
%>
用户名：
<input type="button" id="btnQuery" value="查询" onclick="javascript:window.location.href='queryUser.jsp?userName='+document.getElementById('userName').value;"/>
<br>
<table border="1">
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
        <td><a href="deleteUser?uid=<%= user.getUserId()%>" onclick="return confirm('提示:确定删除此用户？')">删除</a></td>
    </tr>
    <%}%>
</table>

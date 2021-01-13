<%--
  Created by IntelliJ IDEA.
  User: WJX
  Date: 2018/5/24
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>欢迎注册</h3>
<form action="localhost:8080/oauth/userRegister" method="get">
    <input name="account" type="text" placeholder="用户邮箱">
    <input name="passwd" type="text" placeholder="密码">
    <input name="repasswd" type="text" placeholder="确认密码">
    <input name="name" type="text" placeholder="用户名">
    <input name="注册" type="submit" value="注册">
</form>
</body>
</html>

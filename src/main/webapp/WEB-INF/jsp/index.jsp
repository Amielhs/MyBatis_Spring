<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
<h1>hello,Spring MVC！</h1>
<h2>username(key:string) --> ${string}</h2>
<h2>username(key:username) --> ${username}</h2>
<h2>username(key:currentUser) --> ${currentUser.userName}</h2>
<h2>username(key:user) --> ${user.userName}</h2>

<form action="${pageContext.request.contextPath}/test.cs" method="post">
    <div>请输入userCode：<input type="text" name="userCode" value=""/></div>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>

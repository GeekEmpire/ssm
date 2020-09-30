<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/29
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="anno/testRequestParam?name=哈哈">testRequestParam</a>

    <form action="/anno/testRequestBody" method="post">
        username:<input type="text" name="username"><br>
        age:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <a href="anno/testPathVariable/10"></a><br>

    <a href="anno/RequestHeader">RequestHeader</a><br>

    <a href="anno/testCookieValue">testCookieValue</a><br>

    <form action="/anno/testModelAttribute" method="post">
        username:<input type="text" name="username"><br>
        age:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form><br>

    <a href="anno/testSessionAttributes">testSessionAttributes</a><br>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/30
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统文件上传</h3>
    <form action="/file/upload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload1">
        <input type="submit" value="上传">
    </form>

    <h3>springmvc文件上传</h3>
    <form action="/file/upload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload2">
        <input type="submit" value="上传">
    </form>

    <h3>跨服务器文件上传</h3>
    <form action="/file/upload3" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload3">
        <input type="submit" value="上传">
    </form>
</body>
</html>

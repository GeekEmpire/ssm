<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/30
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--静态资源也会被拦截，要在springmvc中进行配置--%>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                // alert("click");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data: '{"username":"小明","password":"123456","id":"3"}',
                    dataType:"json",
                    type: "post",
                    success:function (data) {
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.id);

                    }
                })
            });
        });
    </script>
</head>
<body>

    <a href="user/testString">testString</a><br>
    <a href="user/testVoid">testVoid</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>

    <button id="btn">发送ajax请求</button>
</body>
</html>

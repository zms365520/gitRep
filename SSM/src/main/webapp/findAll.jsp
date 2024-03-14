<%--
  Created by IntelliJ IDEA.
  User: SUSV
  Date: 2024/2/26
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.10.1.js" />
    <script type="text/javascript">



                   $("btn").click(function () {
                       alert(123);
                   });



    </script>
</head>
<body>
    <form action="/findAll.do" method="post">
        <input type="submit" value="全部" />
    </form>
<input type="button" id="btn" value="测试">
</body>
</html>

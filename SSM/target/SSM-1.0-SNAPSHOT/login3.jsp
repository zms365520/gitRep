<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


    <script type="text/javascript" src="js/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#uploadFile").click(function () {
                //alert("123");
                //console.log($("#photo")[0].files[0]);
                var photoFile=$("#photo")[0].files[0];
                if(photoFile==undefined){
                    alert("未选中文件");
                    return;
                }
                //已选中文件
                //将文件装入FormData对象
                var formData=new FormData();
                formData.append("headPhoto",photoFile);
                $.ajax({
                    type:"post",
                    data:formData,
                    url:"fileUpload3.do",
                    processData:false,
                    contentType:false,
                    success:function(result){
                        //接收后台响应的信息
                        console.log(result);
                        alert(result);
                        //图片回显
                    }
                });
            });
        });

    </script>
</head>
<body>
<form action="login2.do" method="post">
    <p>账号：<input type="text" name="cname"/></p><br>
    <p>密码：<input type="password" name="room"/></p><br>
    <p>头像：
        <input type="file" id="photo"/>
        <a id="uploadFile" href="javascript:void(0)">立即上传</a>
    </p>
    <input type="submit" value="注册"/>

</form>

</body>
</html>

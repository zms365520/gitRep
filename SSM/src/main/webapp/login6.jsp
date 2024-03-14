<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .progress{
            width:200px;
            height:10px;
            border:1px solid #cc;
            border-radius:10px;
            margin:10px 0px;
            overflow: hidden;
        }
        .progress>div{
            width:0px;
            height:100%;
            background-color:yellowgreen;
            transition:all .3s ease;
        }
    </style>

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
                    url:"fileUpload6.do",
                    processData:false,
                    contentType:false,
                    success:function(result){
                        //接收后台响应的信息
                        console.log(result);
                        //图片回显
                        $("#headImg").attr("src","http://192.168.1.12:8090/upload/"+result.newFileName);
                        $("#fileType").val(result.fileType);
                        $("#fileName").val(result.newFileName);
                    },
                    xhr:function () {
                        var xhr=new XMLHttpRequest();
                        xhr.upload.addEventListener('progress',function (e) {
                            var progressRate=(e.loaded/e.total)*100+'%';
                            $('.progress>div').css('width',progressRate);
                        })
                        return xhr;
                    }
                });
            });
        });

    </script>
</head>
<body>
<form action="addPlayer.do" method="get">
    <p>账号：<input type="text" name="cname"/></p><br>
    <p>密码：<input type="password" name="pwd"/></p><br>
    <p>头像：
        <input type="file" id="photo"/><br/>
        <img id="headImg" style="width:200px;height: 200px;" alt="还未上传图片" />
        <br>
        <!--进度条-->
        <div class="progress">
            <div></div>
        </div>
        <br/>
        <a id="uploadFile" href="javascript:void(0)">立即上传</a>
    </p>
    <input type="hidden" id="fileName" name="photoName"/>
    <input type="hidden" id="fileType" name="photoType"/>
    <input type="submit" value="注册"/>

</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: SUSV
  Date: 2024/2/27
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #playerTable {
            width: 50%;
            border: 3px solid cadetblue;
            margin: 0px auto;
            text-align: center;
        }

        #playerTable th, td {
            border: 1px solid gray;
        }

        #playerTable img {
            width: 100px;
            height: 100px;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                type:"get",
                url:"getAllPlayer.do",
                success:function (player) {
                   //console.log(player);
                   $.each(player,function (i,e) {
                       $("#playerTable").append('<tr>\n'+'<td>'+e.id+'</td>\n'
                       +' <td>'+e.cname+'</td>\n'
                       +'<td>'+e.pwd+'</td>\n'
                       +' <td>\n' +'<img src="http://192.168.1.12:8090/upload/'+e.photoName+'" alt="" src>\n'
                       +'</td>\n' +' <td>\n' +'<a href="photoDownload.do?photoName='+e.photoName+'&photoType='+e.photoType+'">下载</a>\n' +'</td>\n'+'</tr>');
                   });
                }
            });
            //alert("123");
        });
    </script>
</head>
<body>
<table id="playerTable" cellspacing="0xp" cellpadding="0px">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>头像</th>
        <th>操作</th>
    </tr>
</table>
</body>
</html>

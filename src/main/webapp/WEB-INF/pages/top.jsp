<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="import.jsp" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>自动化测试管理系统</title>
    <link rel="stylesheet" type="text/css" href="/css/fanganchuangjian.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/menu.css"/>
    <script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript">
        function ShowTagDetail(obj) {
            var lis = document.getElementsByName("aa");
            for (var i = 0; i < lis.length; i++) lis[i].className = "";//全部清空
            obj.className = 'on';
        }
    </script>
</head>

<body>
<!--顶部开始-->
<div class="top">
    <img src="/images/gdlogo.png" style="float: left;">
    <div class="top_left">
        <div class="top_left01">
            <img src="/images/top_inn.png"/>
        </div>
    </div>
    <div class="main_tright">
        <div id="menu">
            <%-- <ul class="menu" >
                 <li><a href="/Login/loginOut.action"><img src="/images/top01.png" class="imgpng"/><p>系统退出</p></a></li>
                 <li><a href="/Login/password.action" onclick="ShowTagDetail(this)" target="left" name="aa"><img src="/images/xgpw.png" class="imgpng"/><p>密码修改</p></a></li>
             </ul>--%>
        </div>
        <div class="clear"></div>
    </div>
</div>

</body>
</html>
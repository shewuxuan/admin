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
<style>
    .out:hover {color:#ffffff;}  /* 鼠标移动到链接上 */
</style>
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
            <a href="#" onclick="logOut()" style="font-size:14px;top:45px;float:right;color: rgb(0,0,179);"><u class="out">退出用户</u></a>
                <%-- <li><a href="/Login/password.action" onclick="ShowTagDetail(this)" target="left" name="aa"><img src="/images/xgpw.png" class="imgpng"/><p>密码修改</p></a></li>--%>
        </div>
        <div class="clear"></div>
    </div>
    <b style="text-align: right; font-size: 20px; float: right;  margin-top: 30px; margin-right: 30px;">
        ${loginName},欢迎您！
    </b>
</div>
<script>
    /* 退出登陆 */
    function logOut() {
        if (confirm('确定已保存当前工作并退出吗？') == true) {
            // window.location.href = '/logoutJson.action';
            if (top != window) {
                top.location.href = '/logoutJson.action';
            }
        }
        return false;
    }
</script>
</body>
</html>
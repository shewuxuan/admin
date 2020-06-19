<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/13
  Time: 10:58 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../import.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="${basePath}/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${basePath}/static/js/jquery.min.js"></script>
    <script src="${basePath}/static/layui/layui.js" charset="utf-8"></script>
    <title>柱上断路器馈线终端现场调试传动记录</title>
</head>
<body>

<div class="layui-layout layui-layout-admin">

    <%--  头  --%>
    <div class="layui-header">
        <div style="text-align: center; padding: 17px; color: white;">
            <h2>柱上断路器馈线终端现场调试传动记录</h2>
        </div>
    </div>
    <%--  头end  --%>

    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div id="nav" class="layui-side-scroll" style="background-color: #009688">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed" style="background-color: #009688;">
                    <a class="" href="#mao1">1.设备基础信息</a>
                </li>
                <li id="li_kgdz" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao2">2.开关定值</a>
                </li>
                <li id="li_hbdy" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao3">3.后备电源</a>
                </li>
                <li id="li_lpjy" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao4">4.电流、电压零漂校验</a>
                </li>
                <li id="li_cyjd" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao5">5.采样精度测试(二次值)</a>
                </li>
                <li id="li_gncs" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao6">6.功能调试</a>
                </li>
                <li id="li_gjts" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao7">7.跳闸/告警功能调试</a>
                </li>
                <li id="li_ykcd" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao8">8.遥控传动(带模拟开关)</a>
                </li>
                <li id="li_cyjdcs" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao9">9.采样精度测试(一次值)</a>
                </li>
                <li id="li_ykkg" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao10">10.带开关遥控</a>
                </li>
                <li id="li_tyjc" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao11">11.投运前的检查</a>
                </li>
            </ul>
        </div>
    </div><!-- 左侧导航end -->

    <%--  体  --%>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <%-- 1、设备基本信息 --%>
            <%@include file="page/jbxx.jsp" %>
            <%-- 2、开关定值 --%>
            <%@include file="page/kgdz.jsp" %>
            <%-- 3、后备电源 --%>
            <%@include file="page/hbdy.jsp" %>
            <%-- 4、电流/电压零漂校验 --%>
            <%@include file="page/lpjy.jsp" %>
            <%-- 5、采样精度测试（二次值） --%>
            <%@include file="page/cyjd.jsp" %>
            <%-- 6、功能调试 --%>
            <%@include file="page/gncs.jsp" %>
            <%-- 7、跳闸、告警功能调试（通入二次值）--%>
            <%@include file="page/gjts.jsp" %>
            <%-- 8、遥控传动（带模拟开关）--%>
            <%@include file="page/ykcd.jsp" %>
            <%-- 9、采样精度测试（一次值）--%>
            <%@include file="page/cyjdcs.jsp" %>
            <%--10、带开关遥控--%>
            <%@include file="page/ykkg.jsp" %>
            <%--11、投运前的检查--%>
            <%@include file="page/tyjc.jsp" %>
        </div>
    </div><!-- 体end -->

    <%--    <div class="layui-footer">--%>
    <%--        <!-- 底部固定区域 -->--%>
    <%--        <span>测试完毕后，注意要退出保护装置跳闸功能。</span>--%>
    <%--    </div>--%>

</div>

<script>
    let tsid = '${requestScope.tsid}';
    let ssqy = null;
</script>
</body>
</html>
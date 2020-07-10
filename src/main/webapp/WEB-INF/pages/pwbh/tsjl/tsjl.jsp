<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/15
  Time: 2:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../import.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="${basePath}/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${basePath}/static/js/jquery.min.js"></script>
    <script src="${basePath}/static/layui/layui.js" charset="utf-8"></script>
    <title>配网保护调试记录</title>
</head>
<body>

<div class="layui-layout layui-layout-admin">

    <%--  头  --%>
    <div class="layui-header">
        <%--        <div class="layui-logo">layui 后台布局</div>--%>
        <div style="text-align: center; padding: 17px; color: white;">
            <h2>配网保护调试记录</h2>
        </div>
    </div>
    <%--  头end  --%>

    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div id="nav" class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li id="li_yqyb" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao1">1.所需仪器仪表</a>
                </li>
                <li id="li_wgjc" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao2">2.外观检查</a>
                </li>
                <li id="li_jxdx" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao3">3.紧线及对线</a>
                </li>
                <li id="li_jdsz" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao4">4.校对时钟</a>
                </li>
                <li id="li_jycs" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao5">5.绝缘测试</a>
                </li>
                <li id="li_dzdjc" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao6">6.定值单检查</a>
                </li>
                <li id="li_lpjy" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao7">7.电流、电压零漂校验</a>
                </li>
                <li id="li_jdjy" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao8">8.电流、电压精度检验</a>
                </li>
                <li id="li_ctgy" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao9">9.保护CT参数、变比试验</a>
                    <dl class="layui-nav-child">
                        <dd id="dd_bhctjx"><a href="#mao10_1">9.1 保护CT极性</a></dd>
                        <dd id="dd_bhctbh"><a href="#mao10_2">9.2 保护CT变比</a></dd>
                    </dl>
                </li>
                <li id="li_dzjc" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao10">10.定值检查</a>
                </li>
                <li id="li_zzsy" class="layui-nav-item layui-nav-itemed">
                    <a i class="" href="#mao11">11.整组试验及断路器传动</a>
                </li>
                <li id="li_bhcthl" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao12">12.保护CT回路接触电阻</a>
                </li>

                <li id="li_sgjc" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao13">13.收工前需检查的项目</a>
                </li>
            </ul>
        </div>
    </div><!-- 左侧导航end -->

    <%--  体  --%>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <%-- 1、基本信息 --%>
            <%@include file="page/jbxx.jsp" %>
            <%@include file="page/yqyb.jsp" %>
            <%@include file="page/wgjc.jsp" %>
            <%@include file="page/jxdx.jsp" %>
            <%@include file="page/jdsz.jsp" %>
            <%@include file="page/jycs.jsp" %>
            <%@include file="page/dzdjc.jsp" %>
            <%@include file="page/lpjy.jsp" %>
            <%@include file="page/jdjy.jsp" %>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend id="mao9">9、保护CT参数、变比试验</legend>
            </fieldset>
            <%@include file="page/bhctjx.jsp" %>
            <%@include file="page/bhctbh.jsp" %>
            <%@include file="page/dzjc.jsp" %>
            <%@include file="page/zzsy.jsp" %>
            <%@include file="page/bhcthl.jsp" %>
            <%@include file="page/sgjc.jsp" %>
            <br>
            <%--            <span>测试完毕后，注意要退出保护装置跳闸功能。</span>--%>
        </div>
    </div><!-- 体end -->

    <div class="layui-footer">
        <!-- 底部固定区域 -->
<%--        <span>测试完毕后，注意要退出保护装置跳闸功能。</span>--%>
    </div>

</div>

<script>
    let tsid = '${requestScope.tsid}';
    let ssqy = null;
    var quanxian = '${requestScope.userType}';
</script>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="ADD">添加</button>
    </div>
</script>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/13
  Time: 10:58 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../import.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="${basePath}/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${basePath}/static/js/jquery.min.js"></script>
    <script src="${basePath}/static/layui/layui.js" charset="utf-8"></script>
    <title>DTU传动调试记录</title>
</head>
<body>

<div class="layui-layout layui-layout-admin">

    <%--  头  --%>
    <div class="layui-header">
        <%--        <div class="layui-logo">layui 后台布局</div>--%>
        <div style="text-align: center; padding: 17px; color: white;">
            <h2>DTU传动调试记录</h2>
        </div>
    </div>
    <%--  头end  --%>

    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div id="nav" class="layui-side-scroll" style="">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed" style="">
                    <a class="" href="#mao1">1.基本信息</a>
                </li>
                <li id="li_wgpz" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao2">2.DTU外观结构及配置</a>
                </li>
                <li id="li_hlcs" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao3">3.回路测试</a>
                    <dl class="layui-nav-child">
                        <dd id="dd_jydz"><a href="#mao3_1">3.1绝缘电阻测试</a></dd>
                        <dd id="dd_hldz"><a href="#mao3_2">3.2 CT回路电阻测试</a></dd>
                    </dl>
                </li>
                <li id="li_dyxn" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao4">4.电源性能测试</a>
                </li>
                <li id="li_lpjy" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao5">5.电流、电压零漂校验</a>
                </li>
                <li id="li_cyjd" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao6">6.采样精度测试</a>
                </li>
                <li id="li_dlhl" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao7">7.模拟CT一次电流验证回路</a>
                </li>
                <li id="li_gncs" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao8">8.功能调试</a>
                </li>
                <li id="li_ctgy" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao9">9.CT安装工艺检查</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a id="li_yxts" class="" href="#mao10">10.遥信功能调试</a>
                    <dl class="layui-nav-child">
                        <dd id="dd_kgg"><a href="#mao10_1">10.1 开关柜</a></dd>
                        <dd id="dd_dtu"><a href="#mao10_2">10.2 DTU</a></dd>
                        <dd id="dd_ysbj"><a href="#mao10_3">10.3 溢水报警装置</a></dd>
                        <dd id="dd_xb"><a href="#mao10_4">10.4 箱变</a></dd>
                    </dl>
                </li>
                <li id="li_ykts" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao11">11.遥控功能调试</a>
                </li>
                <li id="li_ycts" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao12">12.遥测功能调试</a>
                </li>

                <li id="li_gjcs" class="layui-nav-item layui-nav-itemed">
                    <a class="" href="#mao13">13.告警功能调试</a>
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
            <%-- 2、DTU外观结构及配置 --%>
            <%@include file="page/wgpz.jsp" %>
            <%-- 3、回路测试 --%>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend id="mao3">3、回路测试</legend>
            </fieldset>
            <%-- 3.1 绝缘电阻测试 --%>
            <%@include file="page/jydz.jsp" %>
            <%-- 3.2 CT回路电阻测试（测量值应不大于0.2Ω） --%>
            <%@include file="page/hldz.jsp" %>
            <%-- 4、电源性能测试 --%>
            <%@include file="page/dyxn.jsp" %>
            <%-- 5、电流、电压零漂校验（测量值在0.1%以内） --%>
            <%@include file="page/lpjy.jsp" %>
            <%-- 6、采样精度测试（测量值在0.5%以内） --%>
            <%@include file="page/cyjd.jsp" %>
            <%-- 7、模拟CT一次电流验证回路 --%>
            <%@include file="page/dlhl.jsp" %>
            <%-- 8、功能调试 --%>
            <%@include file="page/gncs.jsp" %>
            <%-- 9、CT安装工艺检查 --%>
            <%@include file="page/ctgy.jsp" %>
            <%-- 10、遥信功能调试 --%>
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend id="mao10">10、遥信功能调试</legend>
            </fieldset>
            <%-- 10.1 开关柜 --%>
            <%@include file="page/kgg.jsp" %>
            <%-- 10.2 DTU --%>
            <%@include file="page/dtu.jsp" %>
            <%-- 10.3 溢水报警装置 --%>
            <%@include file="page/ysbj.jsp" %>
            <%-- 10.4 箱变 --%>
            <%@include file="page/xb.jsp" %>
            <%-- 11、遥控功能调试 --%>
            <%@include file="page/ykts.jsp" %>
            <%-- 12、遥测功能调试 --%>
            <%@include file="page/ycts.jsp" %>
            <%-- 13、告警功能调试 --%>
            <%@include file="page/gjcs.jsp" %>


            <br>
            <%--            <span>测试完毕后，注意要退出保护装置跳闸功能。</span>--%>
        </div>
    </div><!-- 体end -->

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <span>测试完毕后，注意要退出保护装置跳闸功能。</span>
    </div>

</div>

<script>
    let tsid = '${requestScope.tsid}';
</script>

</body>
</html>
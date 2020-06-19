<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:59 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao12">12、遥测功能调试</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>测量步骤： DTU一般监测母线电压Uac，测试时在电压接线端子A、 C 两相同时加57.735V，此时Uac线电压为100V，主站系数为0.1，母线电压为10KV。</h4>
        <table id="ycts" lay-filter="ycts"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="yctsbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 12、遥测功能调试 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#ycts'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlycts/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                , {
                    field: 'csxm',
                    title: '测试项目',
                    width: '55%',
                    rowspan: 2,
                    align: 'center',
                    sort: true,
                    templet: function (d) {
                        return '<div style="text-align: left">' + d.csxm + '</div>';
                    }
                }
                , {title: '电压遥测', align: 'center', colspan: 2}
                ]

                , [{field: 'ddyc1', title: '100V', width: '20%', align: 'center'}
                    , {field: 'ddyc2', title: '220V', width: '20%', align: 'center'}
                ]]
            , done: function (res) {}
        });
    });
</script>
</body>
</html>

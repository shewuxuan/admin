<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:54 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao1">1、仪器仪表</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="yqyb" lay-filter="yqyb"></table>
    </blockquote>
</div>

<script>
    layui.use('table', function () {
        let table = layui.table
            , form = layui.form;
        let tableReload = table.render({
            elem: '#yqyb'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_yqyb/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {
                    field: 'yqmc', title: '试验仪器名称', width: '29%', align: 'center', sort: true
                    // , templet: function (d) {
                    //     return '<div style="text-align: left">' + d.yqmc + '</div>';
                    // }
                }
                , {field: 'sbxh', title: '设备型号', width: '22%', align: 'center'}
                , {field: 'bh', title: '编号', width: '22%', align: 'center'}
                , {field: 'hgqx', title: '合格期限', width: '22%', align: 'center'}
            ]]
            , done: function (res, curr, count) {
            }
        });
    });
</script>
</body>
</html>

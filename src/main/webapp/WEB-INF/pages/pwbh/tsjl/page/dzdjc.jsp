<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/17
  Time: 10:51 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao6">6、定值单检查</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="dzdjc" lay-filter="dzdjc"></table>
<%--        <form class="layui-form layui-form-pane" action="">--%>
<%--            <div class="layui-form-item layui-form-text">--%>
<%--                <label class="layui-form-label">备注</label>--%>
<%--                <div class="layui-input-block">--%>
<%--                    <textarea id="dzdjcbeizhu" placeholder="" class="layui-textarea"></textarea>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
    </blockquote>
</div>

<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#dzdjc'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_dzdjc/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'cdrq', title: '出单日期', width: '24%', align: 'center', sort: true}
                , {field: 'dzdh', title: '定值单号', width: '20%', align: 'center', sort: true}
                , {field: 'bb', title: '版本', width: '13%', align: 'center', sort: true}
                , {field: 'jym', title: '校验码', width: '14%', align: 'center', sort: true}
                , {field: 'cxsj', title: '程序形成时间', width: '24%', align: 'center', sort: true}
            ]]
            , done: function (res) {
            }
        });
    });
</script>
</body>
</html>

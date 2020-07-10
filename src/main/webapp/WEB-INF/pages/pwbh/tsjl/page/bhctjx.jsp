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
    <legend id="mao10_1">9.1 保护CT极性</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="bhctjx" lay-filter="bhctjx"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="bhctjxbeizhu" placeholder="" class="layui-textarea"  readonly></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#bhctjx'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_bhctjx/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'xb', title: '相别', width: '20%', align: 'center', sort: true}
                , {field: 'mx1', title: '一次以母线为正', width: '24%', align: 'center'}
                , {field: 'mx2', title: '二次以S1为正', width: '24%', align: 'center'}
                , {field: 'bjzs', title: '表计指示', width: '27%', align: 'center'}
            ]]
            , done: function (res) {
            }
        });
    });
</script>
</body>
</html>

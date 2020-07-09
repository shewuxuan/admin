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
    <legend id="mao10_2">9.2 保护CT变比</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="bhctbh" lay-filter="bhctbh"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="bhctbhbeizhu" placeholder="" class="layui-textarea" readonly></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 5、电流、电压零漂校验（测量值在0.1%以内） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let autosave = null;
        let tableReload = table.render({
            elem: '#bhctbh'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_bhctbh/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'xb', title: '相别', width: '12%', align: 'center', sort: true}
                , {field: 'xh', title: '型号', width: '15%', align: 'center'}
                , {field: 'xqh', title: '线圈号', width: '15%', align: 'center'}
                , {field: 'cs', title: '参数', width: '15%', align: 'center'}
                , {field: 'mybh', title: '名义变比', width: '15%', align: 'center'}
                , {field: 'sybh', title: '实验变比', width: '23%', align: 'center'}
            ]]
            , done: function (res) {
                let resdata = res.data;
                record = resdata;
                $.each(resdata, function (i, value) {
                    if (value.xh == null || value.xh === ""
                    || value.xqh == null || value.xqh === ""
                    || value.cs == null || value.cs === ""
                    || value.mybh == null || value.mybh === ""
                    || value.sybh == null || value.sybh === "") {
                        $("#dd_bhctbh").css({"background-color": ""});
                        return false;
                    }
                    $("#dd_bhctbh").css({"background-color": "#009688"});
                })
            }
        });
    });
</script>
</body>
</html>

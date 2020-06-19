<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:55 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend id="mao2">2. 开关定值</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="kgdz" lay-filter="kgdz"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="kgdzbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 2. 开关定值 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#kgdz'                           // 改
            , page: false
            , url: '${basePath}/ftu_jl_kgdz/selectByAll?tsid=' + tsid //数据接口      改
            , skin: 'line,row' //行边框风格
            , even: false //开启隔行背景
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [
                [{title: '柱 上 断 路 器', align: 'center', colspan: 9}],
                [ //表头
                {field: 'dzdh', title: '定值单号', width: '20%', align: 'center'}
                , {field: 'g11', title: '过流Ｉ段', width: '10%', align: 'center'}
                , {field: 'g12', title: '过流Ｉ段', width: '10%', align: 'center'}
                , {field: 'g21', title: '过流II段', width: '10%', align: 'center'}
                , {field: 'g22', title: '过流II段', width: '10%', align: 'center'}
                , {field: 'lx11', title: '零序Ｉ段', width: '10%', align: 'center'}
                , {field: 'lx12', title: '零序Ｉ段', width: '10%', align: 'center'}
                , {field: 'lx21', title: '零序II段', width: '10%', align: 'center'}
                , {field: 'lx22', title: '零序II段', width: '10%', align: 'center'}
            ]]
            , done: function (res) {
                let resdata = res.data;
                record = resdata;

                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (
                        resdata[i].dzdh == null || resdata[i].dzdh === ""
                        || resdata[i].g11 == null || resdata[i].g11 === ""
                        || resdata[i].g12 == null || resdata[i].g12 === ""
                        || resdata[i].g21 == null || resdata[i].g21 === ""
                        || resdata[i].g22 == null || resdata[i].g22 === ""
                        || resdata[i].lx11 == null || resdata[i].lx11 === ""
                        || resdata[i].lx12 == null || resdata[i].lx12 === ""
                        || resdata[i].lx21 == null || resdata[i].lx21 === ""
                        || resdata[i].lx22 == null || resdata[i].lx22 === ""
                    ) {
                        $("#li_kgdz").css({"background-color": ""});
                        return;
                    }
                    $("#li_kgdz").css({"background-color": "#009688"});
                }
            }
        });

        // 编辑
        table.on('edit(kgdz)', function (obj) {         // 改
        });

//监听事件
        table.on('toolbar(kgdz)', function (obj) {      // 改
        });
    });
</script>
</body>
</html>

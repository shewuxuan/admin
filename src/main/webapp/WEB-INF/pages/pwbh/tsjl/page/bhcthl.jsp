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
    <legend id="mao12">12、保护CT回路接触电阻：（误差不得超过10％）</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="bhcthl" lay-filter="bhcthl"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="bhcthlbeizhu" placeholder="" class="layui-textarea" readonly></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let autosave = null;
        let tableReload = table.render({
            elem: '#bhcthl'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_bhcthl/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'xb', title: '相别', width: '28%', align: 'center', sort: true}
                , {field: 'bhc', title: '保护侧', width: '33%', align: 'center'}
                , {field: 'ctc', title: 'CT侧', width: '34%', align: 'center'}
            ]]
            , done: function (res) {
                let resdata = res.data;
                record = resdata;
                $.each(resdata, function (i, value) {
                    if (value.bhc == null || value.bhc === ""
                    || value.ctc == null || value.ctc === "") {
                        $("#li_bhcthl").css({"background-color": ""});
                        return false;
                    }
                    $("#li_bhcthl").css({"background-color": "#009688"});
                })
            }
        });
    });
</script>
</body>
</html>

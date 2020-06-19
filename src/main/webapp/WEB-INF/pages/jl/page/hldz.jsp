<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:49 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend id="mao3_2">3.2 CT回路电阻测试（测量值应不大于0.2Ω）</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>测量步骤：</h4>
        <h4>（1）测试前，断开开关柜二次柜内的CT连接片，分别在端子排上口（一般为装置侧）和下口（一般为CT侧）进行测试。</h4>
        <h4>（2）测试后，及时恢复CT连接片，防止开路。</h4>
        <table id="hldz" lay-filter="hldz" style="width: 70%; margin: auto;"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="hldzbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 3.2 CT回路电阻测试（测量值应不大于0.2Ω） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#hldz'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlhldz/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'jg', title: '间隔', width: '14%', align: 'center', sort: true}
                , {field: 'hl', title: '回路', width: '31%', align: 'center', sort: true}
                , {field: 'zzc', title: '装置侧', width: '25%', align: 'center'}
                , {field: 'ctc', title: 'CT侧', width: '25%', align: 'center'}
            ]]
            , done: function (res) {}
        });
    });
</script>
</body>
</html>

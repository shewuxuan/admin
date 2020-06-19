<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:57 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend id="mao10_4">10.4 箱变</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="xb" lay-filter="xb"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="xbbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 10.4 箱变 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#xb'                           // 改
            , page: false
            , url: '${basePath}/jlxb/selectByAll?tsid=' + tsid //数据接口      改
            , skin: 'line,row' //行边框风格
            , even: false //开启隔行背景
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'byqgwgj', title: '变压器高温告警', width: '50%', align: 'center', templet: '#byqgwgjjg'}
                , {field: 'byqcwgj', title: '变压器超温告警', width: '50%', align: 'center', templet: '#byqcwgjjg'}
            ]]
            , done: function (res, curr, count) {}
        });
    });
</script>
<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="byqgwgjjg">
    {{# if (d.byqgwgj == 1) { }}
    <span>正确</span>
    {{# } else if (d.byqgwgj == 0) { }}
    <span>错误</span>
    {{# } else if (d.byqgwgj == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="byqcwgjjg">
    {{# if (d.byqcwgj == 1) { }}
    <span>正确</span>
    {{# } else if (d.byqcwgj == 0) { }}
    <span>错误</span>
    {{# } else if (d.byqcwgj == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

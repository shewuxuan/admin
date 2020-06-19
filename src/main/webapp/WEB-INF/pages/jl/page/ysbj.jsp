<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:56 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend id="mao10_3">10.3 溢水报警装置</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="ysbj" lay-filter="ysbj"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="ysbjbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 10.3 溢水报警装置 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#ysbj'                           // 改
            , page: false
            , url: '${basePath}/jlysbj/selectByAll?tsid=' + tsid //数据接口      改
            , skin: 'line,row' //行边框风格
            , even: false //开启隔行背景
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'gswgj', title: '高水位告警', width: '25%', align: 'center', templet: '#gswgjjg'}
                , {field: 'dswgj', title: '低水位告警', width: '25%', align: 'center', templet: '#dswgjjg'}
                , {field: 'sbqdgj', title: '水泵启动告警', width: '25%', align: 'center', templet: '#sbqdgjjg'}
                , {field: 'yszzyc', title: '溢水装置异常', width: '25%', align: 'center', templet: '#yszzycjg'}
            ]]
            , done: function (res, curr, count) {}
        });
    });
</script>
<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="gswgjjg">
    {{# if (d.gswgj == 1) { }}
    <span>正确</span>
    {{# } else if (d.gswgj == 0) { }}
    <span>错误</span>
    {{# } else if (d.gswgj == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="dswgjjg">
    {{# if (d.dswgj == 1) { }}
    <span>正确</span>
    {{# } else if (d.dswgj == 0) { }}
    <span>错误</span>
    {{# } else if (d.dswgj == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="sbqdgjjg">
    {{# if (d.sbqdgj == 1) { }}
    <span>正确</span>
    {{# } else if (d.sbqdgj == 0) { }}
    <span>错误</span>
    {{# } else if (d.sbqdgj == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="yszzycjg">
    {{# if (d.yszzyc == 1) { }}
    <span>正确</span>
    {{# } else if (d.yszzyc == 0) { }}
    <span>错误</span>
    {{# } else if (d.yszzyc == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

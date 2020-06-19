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
    <legend id="mao10_2">10.2 DTU</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="dtu" lay-filter="dtu"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="dtubeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 10.2 DTU --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#dtu'                           // 改
            , page: false
            , url: '${basePath}/jldtu/selectByAll?tsid=' + tsid //数据接口      改
            , skin: 'line,row' //行边框风格
            , even: false //开启隔行背景
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'yf', title: '远方', width: '20%', align: 'center', templet: '#yfjg'}
                , {field: 'jd', title: '就地', width: '20%', align: 'center', templet: '#jdjg'}
                , {field: 'dcqy', title: '电池欠压', width: '20%', align: 'center', templet: '#dcqyjg'}
                , {field: 'dchh', title: '电池活化', width: '20%', align: 'center', templet: '#dchhjg'}
                , {field: 'jlsd', title: '交流失电', width: '20%', align: 'center', templet: '#jlsdjg'}
            ]]
            , done: function (res) {}
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="yfjg">
{{# if (d.yf == 1) { }}
<span>正确</span>
{{# } else if (d.yf == 0) { }}
<span>错误</span>
{{# } else { }}
<span></span>
{{# } }}
</script>
<script type="text/html" id="jdjg">
    {{# if (d.jd == 1) { }}
    <span>正确</span>
    {{# } else if (d.jd == 0) { }}
    <span>错误</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="dcqyjg">
    {{# if (d.dcqy == 1) { }}
    <span>正确</span>
    {{# } else if (d.dcqy == 0) { }}
    <span>错误</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="dchhjg">
    {{# if (d.dchh == 1) { }}
    <span>正确</span>
    {{# } else if (d.dchh == 0) { }}
    <span>错误</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="jlsdjg">
    {{# if (d.jlsd == 1) { }}
    <span>正确</span>
    {{# } else if (d.jlsd == 0) { }}
    <span>错误</span>
    {{# } else if (d.jlsd == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

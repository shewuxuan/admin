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
    <legend id="mao10">10、带开关遥控</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>开关与控制器航空线已连接。</h4>
        <table id="ykkg" lay-filter="ykkg"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="ykkgbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 10、带开关遥控 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#ykkg'                           // 改
            , page: false
            , url: '${basePath}/ftu_jl_ykkg/selectByAll?tsid=' + tsid //数据接口      改
            , skin: 'line,row' //行边框风格
            , even: false //开启隔行背景
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'ykf', title: '遥控分', width: '50%', align: 'center', templet: '#ykfjg'}
                , {field: 'ykh', title: '遥控合', width: '50%', align: 'center', templet: '#ykhjg'}
            ]]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (
                        resdata[i].ykf == null || resdata[i].ykf === "" || resdata[i].ykf == -1
                        || resdata[i].ykh == null || resdata[i].ykh === "" || resdata[i].ykh == -1
                    ) {
                        $("#li_ykkg").css({"background-color": ""});
                        return;
                    }
                    $("#li_ykkg").css({"background-color": "#009688"});
                }
            }
        });
    });
</script>
<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="ykfjg">
    {{# if (d.ykf == 1) { }}
    <span>正确</span>
    {{# } else if (d.ykf == 0) { }}
    <span>错误</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="ykhjg">
    {{# if (d.ykh == 1) { }}
    <span>正确</span>
    {{# } else if (d.ykh == 0) { }}
    <span>错误</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
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
    <legend id="mao4">4、电流、电压零漂校验</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="lpjy" lay-filter="lpjy"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="lpjybeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#lpjy'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/ftu_jl_lpjy/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                    , {field: 'hl', title: '回路', width: '40%', align: 'center', sort: true}
                    , {field: 'zzds', title: '装置读数', width: '45%', align: 'center'}
                    , {field: 'jcjg', title: '检查结果', width: '10%', align: 'center', templet: '#lpjyjg'}
                ]
            ]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (
                        resdata[i].zzds == null || resdata[i].zzds === ""
                        || resdata[i].jcjg == null || resdata[i].jcjg === "" || resdata[i].jcjg == -1
                    ) {
                        $("#li_lpjy").css({"background-color": ""});
                        return;
                    }
                    $("#li_lpjy").css({"background-color": "#009688"});
                }
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="lpjyjg">
    {{# if (d.jcjg == 1) { }}
    <span>正常</span>
    {{# } else if (d.jcjg == 0) { }}
    <span>超标</span>
    {{# } else if (d.jcjg == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

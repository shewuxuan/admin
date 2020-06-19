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
    <legend id="mao11">11、投运前的检查</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="tyjc" lay-filter="tyjc"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="tyjcbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
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
            elem: '#tyjc'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/ftu_jl_tyjc/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                    , {field: 'jcxm', title: '检查项目', width: '85%', align: 'center', sort: true}
                    , {field: 'jcjg', title: '检查结果', width: '10%', align: 'center', templet: '#tyjcjg'}
                ]
            ]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (resdata[i].jcjg == null || resdata[i].jcjg === "" || resdata[i].jcjg == -1
                    ) {
                        $("#li_tyjc").css({"background-color": ""});
                        return;
                    }
                    $("#li_tyjc").css({"background-color": "#009688"});
                }
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="tyjcjg">
    {{# if (d.jcjg == 1) { }}
    <span>是</span>
    {{# } else if (d.jcjg == 0) { }}
    <span>否</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

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
    <legend id="mao9">9、采样精度测试（一次值）</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>开关与控制器航空线已连接，在开关一次侧通入电流。</h4>
        <table id="cyjdcs" lay-filter="cyjdcs"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="cyjdcsbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 9、采样精度测试（一次值） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#cyjdcs'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/ftu_jl_cyjdcs/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[
                    {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                    , {field: 'clx', title: '测量项', width: '50%', rowspan: 2, align: 'center', sort: true}
                    , {title: '读值', align: 'center', colspan: 3}
                    , {field: 'csjg', title: '检查结果', width: '10%', rowspan: 2, align: 'center', templet: '#cyjdcsjg'}
                ], [
                    {field: 'ia', title: 'IA', width: '12%', align: 'center'}
                    , {field: 'ic', title: 'IC', width: '12%', align: 'center'}
                    , {field: 'io', title: 'I0', width: '12%', align: 'center'}]
            ]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (
                        resdata[i].ia == null || resdata[i].ia === ""
                        || resdata[i].ic == null || resdata[i].ic === ""
                        || resdata[i].io == null || resdata[i].io === ""
                        || resdata[i].csjg == null || resdata[i].csjg === "" || resdata[i].csjg == -1
                    ) {
                        $("#li_cyjdcs").css({"background-color": ""});
                        return;
                    }
                    $("#li_cyjdcs").css({"background-color": "#009688"});
                }
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="cyjdcsjg">
    {{# if (d.csjg == 1) { }}
    <span>正常</span>
    {{# } else if (d.csjg == 0) { }}
    <span>超标</span>
    {{# } else if (d.csjg == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

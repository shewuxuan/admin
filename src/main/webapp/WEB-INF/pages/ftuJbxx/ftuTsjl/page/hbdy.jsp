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
    <legend id="mao3">3、后备电源</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="hbdy" lay-filter="hbdy"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="hbdybeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 6、采样精度测试（二次值） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#hbdy'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/ftu_jl_hbdy/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                    , {field: 'jcnr', title: '检查内容', width: '85%', align: 'center', sort: true}
                    , {field: 'jcjg', title: '检查结果', width: '10%', align: 'center', templet: '#hbdyjg'}
                ]
            ]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (resdata[i].jcjg == null || resdata[i].jcjg === "" || resdata[i].jcjg == -1
                    ) {
                        $("#li_hbdy").css({"background-color": ""});
                        return;
                    }
                    $("#li_hbdy").css({"background-color": "#009688"});
                }
            }
        });

        // 编辑
        table.on('edit(hbdy)', function (obj) {         // 改
        });
//监听事件
        table.on('toolbar(hbdy)', function (obj) {      // 改
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="hbdyjg">
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

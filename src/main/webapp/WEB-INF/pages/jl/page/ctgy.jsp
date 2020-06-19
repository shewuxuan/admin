<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:54 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao9">9、CT安装工艺检查</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="ctgy" lay-filter="ctgy"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="ctgybeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 9、CT安装工艺检查 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#ctgy'
            , title: 'CT工艺检查'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlctgy/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: []
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {
                    field: 'azyq', title: '安装要求', width: '80%', align: 'center', sort: true, templet: function (d) {
                        return '<div style="text-align: left">' + d.azyq + '</div>';
                    }
                }
                , {field: 'jg', title: '检查结果', width: '15%', align: 'center', templet: '#ctgyjg'}
            ]]
            , done: function (res, curr, count) {
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="ctgyjg">
{{# if (d.jg == 1) { }}
<span>是</span>
{{# } else if (d.jg == 0) { }}
<span>否</span>
{{# } else if (d.jg == 2) { }}
<span>N/A</span>
{{# } else { }}
<span></span>
{{# } }}
</script>
</body>
</html>

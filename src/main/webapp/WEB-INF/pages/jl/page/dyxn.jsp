<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:50 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="width: 100%; margin-top: 20px;">
    <legend id="mao4">4、电源性能测试</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="dyxn" lay-filter="dyxn"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="dyxnbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 4、电源性能测试 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#dyxn'                           // 改
            , title: ''
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jldyxn/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', fixed: 'left', width: '5%', sort: true}
                , {
                    field: 'csxm', title: '测试项目', align: 'center', width: '29%', sort: true, templet: function (d) {
                        return '<div style="text-align: left">' + d.csxm + '</div>';
                    }
                }
                , {
                    field: 'jsbz', title: '技术标准', align: 'left', width: '56%', sort: true, templet: function (d) {
                        return '<div style="text-align: left">' + d.jsbz + '</div>';
                    }
                }
                , {field: 'jcjg', title: '检查结果', align: 'center', width: '10%', templet: '#dyxnjg'}
            ]]
            , done: function (res) {}
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="dyxnjg">
    {{# if (d.jcjg == 1) { }}
    <span>是</span>
    {{# } else if (d.jcjg == 0) { }}
    <span>否</span>
    {{# } else if (d.jcjg == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

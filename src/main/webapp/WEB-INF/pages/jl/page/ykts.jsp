<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:58 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao11">11、遥控功能调试</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="ykts" lay-filter="ykts"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="yktsbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 11、遥控功能调试 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#ykts'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'line,row' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlykts/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', rowspan: 2, sort: true}
                , {field: 'jg', title: '间隔', width: '21%', align: 'center', rowspan: 2, sort: true}
                , {align: 'center', title: '遥控', colspan: 2}
                ]

                , [{field: 'ykf', title: '分', width: '37%', align: 'center', templet: '#ykfjg'}
                    , {field: 'ykh', title: '合', width: '37%', align: 'center', templet: '#ykhjg'}
                ]]
            , done: function (res) {}
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="ykfjg">
    {{# if (d.ykf == 1) { }}
    <span>正确</span>
    {{# } else if (d.ykf == 0) { }}
    <span>错误</span>
    {{# } else if (d.ykf == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="ykhjg">
    {{# if (d.ykh == 1) { }}
    <span>正确</span>
    {{# } else if (d.ykh == 0) { }}
    <span>错误</span>
    {{# } else if (d.ykh == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

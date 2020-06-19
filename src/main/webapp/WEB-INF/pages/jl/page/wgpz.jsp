<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/29
  Time: 10:43 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend id="mao2">2、DTU外观结构及配置</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="wgpz" lay-filter="wgpz"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="wgpzbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 2、DTU外观结构及配置 --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#wgpz'
            , title: '用户数据表'
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jlwgpz/selectByAll?tsid=' + tsid //数据接口
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {
                    field: 'csxm', title: '测试项目', width: '27%', align: 'center', sort: true, templet: function (d) {
                        return '<div style="text-align: left">' + d.csxm + '</div>';
                    }
                }
                , {
                    field: 'csyq',
                    title: '技术标准或测试要求',
                    width: '56%',
                    align: 'center',
                    sort: true,
                    templet: function (d) {
                        return '<div style="text-align: left">' + d.csyq + '</div>';
                    }
                }
                , {
                    field: 'csjg',
                    title: '检查结果',
                    width: '12%',
                    align: 'center',
                    templet: '#status'
                }
            ]]
            , done: function (res) {}
        });
    });
</script>

<%-- 结果状态列--%>
<script type="text/html" id="status">
    {{# if (d.csjg == 1) { }}
    <span>是</span>
    {{# } else if (d.csjg == 0) { }}
    <span>否</span>
    {{# } else if (d.csjg == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

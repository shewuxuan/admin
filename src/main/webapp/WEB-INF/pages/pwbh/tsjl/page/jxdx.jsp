<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/17
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
    <legend id="mao3">3、紧线及对线</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="jxdx" lay-filter="jxdx"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="jxdxbeizhu" placeholder="" class="layui-textarea" readonly></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<%-- 5、电流、电压零漂校验（测量值在0.1%以内） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#jxdx'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_jxdx/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'nr', title: '内容', width: '85%', align: 'center', sort: true
                    , templet: function (d) {
                        return '<div style="text-align: left">' + d.nr + '</div>';
                    }
                }
                , {field: 'jcjg', title: '检查结果', width: '10%', align: 'center', templet: '#jxdxjg'}
            ]]
            , done: function (res) {
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="jxdxjg">
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

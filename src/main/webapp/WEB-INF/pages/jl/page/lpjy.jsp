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
    <legend id="mao5">5、电流、电压零漂校验（测量值在0.1%以内）</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <h4>测量步骤：</h4>
        <h4>在未加电流和电压的时候，观察并记录DTU管理软件显示的实时数据。</h4>
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

<%-- 5、电流、电压零漂校验（测量值在0.1%以内） --%>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#lpjy'                           // 改
            , title: '绝缘电阻测试'
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jllpjy/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'jg', title: '间隔', width: '18%', align: 'center', sort: true}
                , {field: 'hl', title: '回路', width: '27%', align: 'center', sort: true}
                , {field: 'zzds', title: '装置读数', width: '30%', align: 'center'}
                , {field: 'jcjg', title: '检查结果', width: '20%', align: 'center', templet: '#lpjyjg'}
            ]]
            , done: function (res) {}
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

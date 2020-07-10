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
    <legend id="mao11">11、整组试验及实际断路器传动</legend>
</fieldset>
<div class="layui-field-box">
    <blockquote class="layui-elem-quote" style="width: 90%; margin: auto;">
        <table id="zzsy" lay-filter="zzsy"></table>
        <form class="layui-form layui-form-pane" action="">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea id="zzsybeizhu" placeholder="" class="layui-textarea" readonly></textarea>
                </div>
            </div>
        </form>
    </blockquote>
</div>

<script>
    layui.use('table', function () {
        let table = layui.table;
        let tableReload = table.render({
            elem: '#zzsy'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/pwbh_jl_zzsy/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true}
                , {field: 'jyxm', title: '检验项目', width: '24%', align: 'center', sort: true}
                , {field: 'gzmn', title: '故障模拟', width: '31%', align: 'center'}
                , {field: 'dlq', title: '断路器', width: '10%', align: 'center', templet: '#zzsydlq'}
                , {field: 'zzxh', title: '主站信号', width: '10%', align: 'center', templet: '#zzsyzzxh'}
                , {field: 'zzxs', title: '装置显示', width: '10%', align: 'center', templet: '#zzsyzzxs'}
                , {field: 'jcjg', title: '检查结果', width: '10%', align: 'center', templet: '#zzsyjg'}
            ]]
            , done: function (res) {
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="zzsyjg">
    {{# if (d.jcjg == 1) { }}
    <span>正确</span>
    {{# } else if (d.jcjg == 0) { }}
    <span>错误</span>
    {{# } else if (d.jcjg == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="zzsydlq">
    {{# if (d.dlq == 1) { }}
    <span>正确</span>
    {{# } else if (d.dlq == 0) { }}
    <span>错误</span>
    {{# } else if (d.dlq == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="zzsyzzxh">
    {{# if (d.zzxh == 1) { }}
    <span>正确</span>
    {{# } else if (d.zzxh == 0) { }}
    <span>错误</span>
    {{# } else if (d.zzxh == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
<script type="text/html" id="zzsyzzxs">
    {{# if (d.zzxs == 1) { }}
    <span>正确</span>
    {{# } else if (d.zzxs == 0) { }}
    <span>错误</span>
    {{# } else if (d.zzxs == 2) { }}
    <span>N/A</span>
    {{# } else { }}
    <span></span>
    {{# } }}
</script>
</body>
</html>

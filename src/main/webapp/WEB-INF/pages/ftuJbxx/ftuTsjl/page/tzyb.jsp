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
<h4>此项试验前应上好出口跳闸压板</h4>
<table id="tzyb" lay-filter="tzyb"></table>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea id="tzybbeizhu" readonly placeholder="" class="layui-textarea"></textarea>
        </div>
    </div>
</form>
<script>
    layui.use('table', function () {
        let table = layui.table;
        let record = [];
        let tableReload = table.render({
            elem: '#tzyb'                           // 改
            , page: false
            , skin: 'row,line' //行边框风格
            , size: 'sm'
            , even: false //开启隔行背景
            , url: '${basePath}/ftu_jl_tzyb/selectByAll?tsid=' + tsid //数据接口      改
            , toolbar: true
            , defaultToolbar: [
            ]
            , cols: [[
                {field: 'id', title: 'ID', type: 'numbers', width: '5%', fixed: 'left', sort: true, rowspan: 2}
                , {field: 'jyxm', title: '检验项目', width: '20%', align: 'center', sort: true, rowspan: 2}
                , {field: 'gzmn', title: '故障模拟', width: '23%', align: 'center', sort: true, rowspan: 2}
                , {field: 'mndl', title: '模拟断路器<br>(或启动信号)', width: '20%', align: 'center', rowspan: 2}
                , {title: '模拟断路器动作情况<br>(或信号动作情况)', align: 'center', colspan: 2}
                , {field: 'jcjg', title: '检查结果', width: '10%', align: 'center', templet: '#tzybjg', rowspan: 2}
            ], [
                {field: 'zzxh', title: '主站信号', width: '11%', align: 'center'}
                , {field: 'zzxs', title: '装置显示', width: '11%', align: 'center'}
            ]
            ]
            , done: function (res, curr, count) {
                let resdata = res.data;
                record = resdata;
                // 背景
                for (let i = 0, length = resdata.length; i < length; i++) {
                    if (
                        resdata[i].mndl == null || resdata[i].mndl === ""
                        || resdata[i].zzxh == null || resdata[i].zzxh === ""
                        || resdata[i].zzxs == null || resdata[i].zzxs === ""
                        || resdata[i].jcjg == null || resdata[i].jcjg === "" || resdata[i].jcjg == -1
                    ) {
                        tzyb = false;
                        gjtsflag(gjts, tzyb);
                        return;
                    }
                    tzyb = true;
                    gjtsflag(gjts, tzyb);
                }
            }
        });
    });
</script>

<%-- 结果状态列(正常/异常)--%>
<script type="text/html" id="tzybjg">
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

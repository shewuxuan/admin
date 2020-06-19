<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/3/12
  Time: 9:44 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../import.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="${basePath}/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${basePath}/static/js/jquery.min.js"></script>
    <script src="${basePath}/static/layui/layui.js" charset="utf-8"></script>
    <title>调试记录列表</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend>调试信息</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">所属区域</label>
        <div class="layui-input-inline" style="width: 100px;">
            <select id="ssqy" name="ssqy"></select>
        </div>
        <label class="layui-form-label">装置类型</label>
        <div class="layui-input-inline" style="width: 100px;">
            <select id="zzlx" name="zzlx"></select>
        </div>
        <label class="layui-form-label">调试时间</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="startTssj" placeholder="开始时间">
        </div>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="endTssj" placeholder="结束时间">
        </div>
        <label class="layui-form-label" style="width: 144px;">安装地点及调度号</label>
        <div class="layui-input-inline" style="width: 200px;">
            <input id="azddDdh" type="text" name="azddDdh" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
        <%--            <button class="layui-btn" data-type="reload">搜索</button>--%>
        <button type="submit" class="layui-btn" lay-submit="" lay-filter="reload">提交</button>
    </div>

</form>

<table id="jlList" lay-filter="jlList"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="exports">导出</a>
    <%--        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
    <%--        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
</script>

<script type="text/javascript">
    $(function () {
        <%-- 所属区域 --%>
        $("#ssqy").append("<option value=''>全部</option>");
        $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            for (let i = 0, length = ssqy.length; i < length; i++) {
                $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });

        <%-- 装置类型 --%>
        $("#zzlx").append("<option value=''>全部</option>");
        $.get("${basePath}/zzlx/selectZzlxByAll", function (data) {
            let zzlx = JSON.parse(data);
            for (let i = 0, length = zzlx.length; i < length; i++) {
                $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
            }
        });
    });
</script>

<script>
    layui.use(['laydate', 'form', 'table'], function () {
        let laydate = layui.laydate;
        var form = layui.form;
        let table = layui.table;

        //日期时间选择器
        laydate.render({
            elem: '#startTssj'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#endTssj'
            , type: 'datetime'
        });

        let tableReload = table.render({
            elem: '#jlList'
            , page: true
            , skin: 'row,line' //行边框风格
            , even: false //开启隔行背景
            , url: '${basePath}/jbxx/selectByPage' //数据接口      改
            , toolbar: true
            , height: 'full-135'
            , cellMinWidth: 120 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , defaultToolbar: ['filter', 'print', 'exports'
                , {
                    title: '刷新' //标题
                    , layEvent: 'REFRESH' //事件名，用于 toolbar 事件中使用
                    , icon: 'layui-icon-refresh'
                }
            ]
            , cols: [[ //表头
                {field: 'id', title: 'ID', type: 'numbers', fixed: 'left', sort: true}
                , {field: 'ssqyName', title: '所属区域', align: 'center', sort: true}
                , {
                    field: 'tssj',
                    title: '调试时间',
                    minWidth: '165',
                    align: 'center',
                    sort: true,
                    templet: "<div>{{layui.util.toDateString(d.tssj, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                }
                , {field: 'azddDdh', title: '安装地点及调度号', align: 'center', minWidth: '165', sort: true}
                , {field: 'ipdz', title: 'IP地址', align: 'center', minWidth: '140', sort: true}
                , {field: 'wlwkh', title: '物联网卡号', align: 'center', sort: true}
                , {field: 'rtudz', title: 'RTU地址', align: 'center', minWidth: '140', sort: true}
                , {field: 'dkh', title: '端口号', align: 'center', sort: true}
                , {field: 'sccs', title: '生产厂商', align: 'center', sort: true}
                , {
                    field: 'scrq',
                    title: '生产日期',
                    minWidth: '165',
                    align: 'center',
                    sort: true,
                    templet: "<div>{{layui.util.toDateString(d.scrq, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                }
                , {field: 'zzxh', title: '装置型号', align: 'center', sort: true}
                , {field: 'zzbh', title: '装置编号', align: 'center', sort: true}
                , {field: 'zzlxName', title: '装置类型', align: 'center', sort: true}
                , {field: 'rjbbJym', title: '软件版本及校验码', align: 'center', minWidth: '165', sort: true}
                , {field: 'yjbb', title: '硬件版本', align: 'center', sort: true}
                , {field: 'tsryxm', title: '调试人员姓名', align: 'center', minWidth: '165', sort: true}
                , {field: 'czr', title: '操作人', align: 'center', sort: true}
                , {
                    field: 'czsj',
                    title: '操作时间',
                    minWidth: '165',
                    align: 'center',
                    sort: true,
                    templet: "<div>{{layui.util.toDateString(d.czsj, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                }
                , {title: '操作', align: 'center', fixed: 'right', toolbar: '#barDemo'}
            ]]
            , done: function (res, curr, count) {
            }
        });

        //监听事件
        table.on('toolbar(jlList)', function (obj) {
            switch (obj.event) {
                // 刷新
                case 'REFRESH':
                    tableReload.reload();
                    layer.msg('刷新完成', {time: 1000, icon: 6});
                    break;
            }
        });

        //监听行操作
        table.on('tool(jlList)', function (obj) {
            let data = obj.data;
            switch (obj.event) {
                // 查看
                case 'detail':
                    window.open("${basePath}/jl/tsjl/" + data.tsid, "", "fullscreen=1");
                    break;
                // 导出
                case 'export':
                    break;
            }
        });

        //监听提交
        form.on('submit(reload)', function (data) {
            let obj = data.field;
            obj.startTssj = $("#startTssj").val();
            obj.endTssj = $("#endTssj").val();
            console.log(obj);
            //执行重载
            table.reload('jlList', {
                url: "${basePath}/jbxx/selectByPage",
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    ssqy: obj.ssqy
                    , zzlx: obj.zzlx
                    , startTssj: obj.startTssj
                    , endTssj: obj.endTssj
                    , azddDdh: obj.azddDdh
                }
            });
            return false;
        });
    });
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/14
  Time: 9:29 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../import.jsp" %>
<html>
<head>
    <title>绝缘测试标准</title>                             <!-- 改 -->

    <link rel="stylesheet" type="text/css" href="/static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/css/demo.css">
    <script type="text/javascript" src="/static/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="/static/style/wholemain.css">
    <script type="text/javascript" src="/static/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<h2>绝缘测试标准</h2>                                           <!-- 改 -->
所属区域：<select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;"></select>
检查内容：<input type="text" name="jcnr" id="jcnr" style="height:25px;width: 300px; border:1px solid #CCC;"/>        <!-- 改 -->
标准：<input type="text" name="" id="bz" style="height:25px;width: 300px; border:1px solid #CCC;"/>        <!-- 改 -->
<input type="button" name="button" value="查询" class="iput_m" onclick="selRecord()">
<input type="button" name="button" value="添加" class="iput_m" onclick="addRecord()">

<div style="margin:20px 0;"></div>

<table id="dg" class="easyui-datagrid" title="绝缘测试标准" style="width:100%;height:auto"></table>     <!-- 改 -->

<%-- 所属区域 --%>
<script type="text/javascript">
    $(function () {
        $("#ssqy").append("<option value=''>全部</option>");
        $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
            data = JSON.parse(data);
            $.each(data, function (i, value) {$("#ssqy").append("<option value='" + value.keyvalue + "'>" + value.keymemo + "</option>");})
        });
    });
</script>

<%-- 表格 --%>
<script type="text/javascript">
    $(function () {
        $('#dg').datagrid({
            singleSelect: true,	// 设置为 true，则只允许选中一行。
            url: '${basePath}/pwbh_bz_jycs/selectByPage',             // 改
            method: 'get',
            iconCls: 'icon-ok',
            nowrap: false,
            striped: true,		// 设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
            collapsible: false,
            fitColumns: true,	// 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
            pagination: true,
            autoRowHeight: true,	// 定义是否设置基于该行内容的行高度。设置为 false，则可以提高加载性能。
            rownumbers: true,
            scrollbarSize: 0,
            remoteSort: true,
            pageList: [10, 15, 30, 50],
            pageSize: 15,//每页显示的记录条数，默认为10 
            idField: 'ssqy',
            columns: [[
                {field: 'ssqyname', halign: 'center', align: "center", title: '所属区域', width: '10%'},
                {field: 'jcnr', halign: 'center', align: "center", title: '检查内容', width: '43%'},        // 改
                {field: 'bz', halign: 'center', align: "center", title: '标准', width: '33%'},        // 改
                {
                    field: 'trans',
                    halign: 'center',
                    align: "left",
                    title: '操作',
                    width: '12%',
                    formatter: function (value, row, index) {
                        var txt1 = '&nbsp;&nbsp;<button href="javascript:void(0);" onclick="updRecord(\'' + row.id + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '修改' + '</button>';
                        var txt3 = '&nbsp;&nbsp;<button href="javascript:void(0);" onclick="delRecord(\'' + row.id + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                        return txt1 + txt3;
                    }
                },
            ]],
        })
    })
</script>

<%-- 操作 --%>
<script type="text/javascript">
    <%-- 添加 --%>
    function addRecord() {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${basePath}/bz/pwbh/jycs/addJycs", "_blank", " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 修改 --%>
    function updRecord(id) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${basePath}/bz/pwbh/jycs/updJycs/" + id, "_blank", " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 删除 --%>
    function delRecord(id) {
        if (!confirm("确认删除吗？")) {
            return;
        }
        $.get('${basePath}/pwbh_bz_jycs/deleteByPrimaryKey/' + id, {"id": id}, function (data) {
            data = JSON.parse(data);
            if (data.code === 0) {
                alert("删除成功！");
                $('#dg').datagrid("load");
            } else {
                alert("删除失败, 请重试！");
            }
        });
    }

    <%-- 查询 --%>
    function selRecord() {
        let queryParams = new Object();
        queryParams.ssqy = $("#ssqy").val();
        queryParams.jcnr = $("#jcnr").val();        // 改
        queryParams.bz = $("#bz").val();        // 改

        $('#dg').datagrid('options').url = '${basePath}/pwbh_bz_jycs/selectByPage';       // 改
        $('#dg').datagrid('options').queryParams = queryParams;
        $('#dg').datagrid("load");
    }
</script>
</body>
</html>

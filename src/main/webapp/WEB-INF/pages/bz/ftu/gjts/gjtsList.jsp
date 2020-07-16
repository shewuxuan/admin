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
    <title>告警调试标准</title>                             <!-- 改 -->

    <link rel="stylesheet" type="text/css" href="/static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/css/demo.css">
    <script type="text/javascript" src="/static/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="/static/style/wholemain.css">
    <script type="text/javascript" src="/static/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<h2>告警调试标准</h2>                                           <!-- 改 -->
所属区域：<select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;"></select>
测试项：<input type="text" name="csx" id="csx" style="height:25px;width: 200px; border:1px solid #CCC;"/>        <!-- 改 -->
<input type="button" name="button" value="查询" class="iput_m" onclick="selRecord()">
<input type="button" name="button" value="添加" class="iput_m" onclick="addRecord()">

<div style="margin:20px 0;"></div>

<table id="dg" class="easyui-datagrid" title="告警调试标准" style="width:100%;height:auto"
       data-options=""></table>     <!-- 改 -->

<%-- 所属区域 --%>
<script type="text/javascript">
    $(function () {
        $("#ssqy").append("<option value='0'>全部</option>");
        $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            for (let i = 0, length = ssqy.length; i < length; i++) {
                $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });
    });
</script>

<%-- 表格 --%>
<script type="text/javascript">
    $(function () {
        $('#dg').datagrid({
            singleSelect: true,	// 设置为 true，则只允许选中一行。
            url: '${basePath}/ftu_bz_gjts/selectByPage',             // 改
            method: 'get',
            iconCls: 'icon-ok',
            nowrap: true,
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
                // {field:'id',halign: 'center',align:"center",title:'ID',width:'10%'},
                {field: 'ssqyname', halign: 'center', align: "center", title: '所属区域', width: '10%'},
                {field: 'csx', halign: 'center', align: "center", title: '测试项', width: '77%'},     // 改
                {
                    field: 'trans',
                    halign: 'center',
                    align: "left",
                    title: '操作',
                    width: '10%',
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
        window.open("${basePath}/bz/ftu/gjts/addGjts", "_blank", " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 修改 --%>

    function updRecord(id) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${basePath}/bz/ftu/gjts/updGjts/" + id, "_blank", " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 删除 --%>

    function delRecord(id) {
        if (!confirm("确认删除吗？")) {
            return;
        }
        $.ajax({
            url: '${basePath}/ftu_bz_gjts/deleteByPrimaryKey/' + id,      // 改
            type: 'POST',
            async: false,
            data: {"id": id},         // 告诉jQuery不要去处理发送的数据
            processData: false,    // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            success: function (data) {
                alert(JSON.parse(data).msg);
                $('#dg').datagrid("load");
            }
        });
    }

    <%-- 查询 --%>

    function selRecord() {
        let queryParams = new Object();
        queryParams.ssqy = $("#ssqy").val();
        queryParams.csx = $("#csx").val();        // 改

        $('#dg').datagrid('options').url = '${basePath}/ftu_bz_gjts/selectByPage';       // 改
        $('#dg').datagrid('options').queryParams = queryParams;
        $('#dg').datagrid("load");
    }
</script>

</body>
</html>

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
    <title>电流电压零漂校验</title>                             <!-- 改 -->

    <link rel="stylesheet" type="text/css" href="/static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/static/css/demo.css">
    <script type="text/javascript" src="/static/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="/static/style/wholemain.css">
    <script type="text/javascript" src="/static/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<h2>电流电压零漂校验</h2>                                           <!-- 改 -->
所属区域：<select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;"></select>
间隔：<input type="text" name="jg" id="jg" style="height:25px;width: 300px; border:1px solid #CCC;"/>        <!-- 改 -->
回路：<input type="text" name="hl" id="hl" style="height:25px;width: 400px; border:1px solid #CCC;"/>        <!-- 改 -->
<input type="button" name="button" value="查询" class="iput_m" onclick="selRecord()">
<c:if test="${funcMap.bzgl ==2 }">
<input type="button" name="button" value="添加" class="iput_m" onclick="addRecord()">
</c:if>

<div style="margin:20px 0;"></div>

<table id="dg" class="easyui-datagrid" title="电流电压零漂校验" style="width:100%;height:auto"
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
    var bzglFun = '${funcMap.bzgl}';
    $(function () {
        $('#dg').datagrid({
            singleSelect: true,	// 设置为 true，则只允许选中一行。
            url: '${basePath}/bzlpjy/selectByPage',             // 改
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
            // onLoadSuccess: function (data) {
            //     if (data.total == 0) {
            //         //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数
            //         $(this).datagrid('appendRow', { fileName: '<div style="text-align:center;color:red">没有相关记录！</div>' }).datagrid('mergeCells', { index: 0, field: 'fileName', colspan: 5 })
            //         //隐藏分页导航条，这个需要熟悉datagrid的html结构，直接用jquery操作DOM对象，easyui datagrid没有提供相关方法隐藏导航条
            //         $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();
            //     }
            // },
            columns: [[
                // {field:'id',halign: 'center',align:"center",title:'ID',width:'10%'},
                {field: 'ssqyname', halign: 'center', align: "center", title: '所属区域', width: '10%'},
                {field: 'zzlxname', halign: 'center', align: "center", title: '装置类型', width: '30%'},
                {field: 'jg', halign: 'center', align: "center", title: '间隔', width: '13%'},        // 改
                {field: 'hl', halign: 'center', align: "center", title: '回路', width: '25%'},     // 改
                {
                    field: 'trans',
                    halign: 'center',
                    align: "left",
                    title: '操作',
                    width: '12%',
                    formatter: function (value, row, index) {
                        var txt1 = '&nbsp;&nbsp;<button href="javascript:void(0);" onclick="updRecord(\'' + row.id + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '修改' + '</button>';
                        var txt3 = '&nbsp;&nbsp;<button href="javascript:void(0);" onclick="delRecord(\'' + row.id + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                        if(bzglFun != 2) return '';
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
        window.open("${basePath}/bz/dtu/lpjy/addLpjy", "_blank", " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 修改 --%>

    function updRecord(id) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${basePath}/bz/dtu/lpjy/updLpjy/" + id, "_blank", " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 删除 --%>

    function delRecord(id) {
        if (!confirm("确认删除吗？")) {
            return;
        }
        $.ajax({
            url: '${basePath}/bzlpjy/deleteByPrimaryKey/' + id,      // 改
            type: 'POST',
            async: false,
            data: {"id": id},         // 告诉jQuery不要去处理发送的数据
            processData: false,    // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            success: function (data) {
                if (data == 1) {
                    alert("删除成功！");
                    $('#dg').datagrid("load");
                } else {
                    alert("删除失败！")
                }
            }
        });
    }

    <%-- 查询 --%>

    function selRecord() {
        let queryParams = new Object();
        queryParams.ssqy = $("#ssqy").val();
        queryParams.jg = $("#jg").val();        // 改
        queryParams.hl = $("#hl").val();        // 改

        $('#dg').datagrid('options').url = '${basePath}/bzlpjy/selectByPage';       // 改
        $('#dg').datagrid('options').queryParams = queryParams;
        $('#dg').datagrid("load");
    }
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/6/3
  Time: 3:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/default/easyui.css"/>
</head>
<body>
<div class="right_main">
    <div>
        <div style="width: 100%; padding-left:10px;padding-right:10px;">
            <div class="tj">
                <!-- 条件start -->
                <form method="post">
                   <%-- <table style="width: 100%;">
                        <tr>
                            <td colspan="1">处缺日期</td>
                            <td colspan=""><input id="tj_startCqrq" type="date">-<input id="tj_endCqrq" type="date"></td>
                            <td colspan="1">所属区域</td>
                            <td colspan=""><select name="ssqy" id="tj_ssqy" class="right_ipu2"></select></td>
                            <td>设备线路</td>
                            <td><select id="tj_bdz"></select>-<select id="tj_xlmc"></select></td>
                        </tr>
                        <tr>
                            <td>设备调度号</td>
                            <td><input id="tj_azddDdh" type="text" style="width: 100%"></td>
                        </tr>
                        <tr>
                            <td colspan="10">
                                <input type="button" name="button" value="查询" class="iput_m" onclick="selRecord2()">
                               &lt;%&ndash; <input type="button" name="button" value="添加" class="iput_m" onclick="addRecord2()">&ndash;%&gt;
                            </td>
                        </tr>
                    </table>--%>
                       <span>日期</span>
                       <input class="easyui-datebox" name="tj_startTssj" id="tj_startTssj" data-options="required:true" style="width:120px"/>
                       &nbsp;至&nbsp;
                       <input class="easyui-datebox" name="tj_endTssj" id="tj_endTssj" data-options="required:true" style="width:120px"/>
                       &nbsp;&nbsp;&nbsp;<span>设备调度号</span><input id="tj_azddDdh" type="text" class="right_ipu2"/>
                       &nbsp;&nbsp;&nbsp;<span>所属区域</span><select name="ssqy" id="tj_ssqy" class="right_ipu2"></select>
                       &nbsp;&nbsp;&nbsp;<span>设备线路</span><select id="tj_bdz"></select>&nbsp;<select id="tj_xlmc"></select>
                       &nbsp;&nbsp;<input type="button" name="button"  value="查 询" class="iput_m" onclick="selRecord2()"/>
                </form>
            </div><!-- 条件end -->
            <br/>
            <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
                <table id="cqtj"></table>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    $(function () {
        // 所属区域
        $("#tj_ssqy").append("<option value=''>全部</option>");
        $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            for (let i = 0, length = ssqy.length; i < length; i++) {
                $("#tj_ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });
        // 变电站
        $("#tj_bdz").append("<option value=''>全部</option>");
        $.get("${basePath}/ssxl/selectByGroup/bdz", function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#tj_bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
            })
        });
        // 设备线路 - 线路名称
        $("#tj_xlmc").append("<option value=''>全部</option>");
    });

    // 设备线路 - 变电站更改时，线路名称随之更改
    $("#tj_bdz").change(function () {
        if ($("#tj_bdz").val() === '') {
            $("#tj_xlmc").empty();
            $("#tj_xlmc").append("<option value=''>全部</option>");
            return;
        }
        $("#tj_xlmc").empty();
        $("#tj_xlmc").append("<option value=''>全部</option>");
        $.get("${basePath}/ssxl/selectByGroup/xlmc",{"bdz": $("#tj_bdz").val()}, function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#tj_xlmc").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
            })
        });
    })
</script>
<%-- 表格 --%>
<script type="text/javascript">
    function getQueryParams() {
        var queryParams = new Object();
        queryParams.startCqrq = $('#tj_startCqrq').val();
        queryParams.endCqrq = $('#tj_endCqrq').val();
        queryParams.ssqy = $('#tj_ssqy').val();
        queryParams.bdz = $('#tj_bdz').val();
        queryParams.xlmc = $('#xlmc').val();
        queryParams.azddDdh = $('#azddDdh').val();
        return queryParams;
    }

    function toCqRecords(ids){
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("/cqrecord/toCqRecords?ids="+ids,"_blank"," height=500,width=1000,top="+t+",left="+w+",toolbar=no,menubar=no,localtion=no,scrollbars=no");
    }

    $(function () {
        $('#cqtj').datagrid({
            singleSelect: true,	// 设置为 true，则只允许选中一行。
            url: '${basePath}/cqrecord/selectPageCqCount',             // 改
            queryParams: getQueryParams(),
            method: 'get',
            iconCls: 'icon-ok',
            nowrap: true,
            striped: true,		// 设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
            collapsible: false,
            fitColumns: true,	// 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
            autoRowHeight: false,	// 定义是否设置基于该行内容的行高度。设置为 false，则可以提高加载性能。
            rownumbers: true,
            // scrollbarSize: 0,
            showFooter: true,
            // remoteSort: true,
            pagination: true,
            pageList: [10, 15, 30, 50],
            pageSize: 10,//每页显示的记录条数，默认为15
            idField: 'azddDdh',
            columns: [[
                {field: 'azdd_ddh', halign: 'center', align: "center", title: '设备调度号', width: '10%', rowspan:2, formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'ssqy', halign: 'center', align: "center", title: '所属区域', width: '10%', rowspan:2, formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'ssxl', halign: 'center', align: "center", title: '设备线路', width: '10%', rowspan:2, formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {halign: 'center', align: "center", title: '缺陷分类', colspan: 5},
                {field: 'sum', halign: 'center', align: "center", title: '合计', width: '10%', rowspan:2, formatter:function (value, row, index) {
                        var idss = row.ids1+','+row.ids2+','+row.ids3+','+row.ids4+','+row.ids5;
                        if(value == 0){return '0';}else{return '<a style=\'text-decoration:none;cursor: pointer;\' onclick="toCqRecords(\''+idss+'\')">'+value+'</a>';}
                    }}],
                [
                    {field: 'qx1', halign: 'center', align: "center", title: '离线', width: '10%', formatter:function (value, row, index) {
                            if(value == 0){return '0';}else{return '<a style=\'text-decoration:none;cursor: pointer;\' onclick="toCqRecords(\''+row.ids1+'\')">'+value+'</a>';}
                        }},
                    {field: 'qx2', halign: 'center', align: "center", title: '频繁掉线', width: '10%', formatter:function (value, row, index) {
                            if(value == 0){return '0';}else{return '<a style=\'text-decoration:none;cursor: pointer;\' onclick="toCqRecords(\''+row.ids2+'\')">'+value+'</a>';}
                        }},
                    {field: 'qx3', halign: 'center', align: "center", title: '遥测数据异常', width: '10%', formatter:function (value, row, index) {
                            if(value == 0){return '0';}else{return '<a style=\'text-decoration:none;cursor: pointer;\' onclick="toCqRecords(\''+row.ids3+'\')">'+value+'</a>';}
                        }},
                    {field: 'qx4', halign: 'center', align: "center", title: '遥信数据异常', width: '10%', formatter:function (value, row, index) {
                            if(value == 0){return '0';}else{return '<a style=\'text-decoration:none;cursor: pointer;\' onclick="toCqRecords(\''+row.ids4+'\')">'+value+'</a>';}
                        }},
                    {field: 'qx5', halign: 'center', align: "center", title: '遥控失败', width: '10%', formatter:function (value, row, index) {
                            if(value == 0){return '0';}else{return '<a style=\'text-decoration:none;cursor: pointer;\' onclick="toCqRecords(\''+row.ids5+'\')">'+value+'</a>';}
                        }},
                ]],
        });
    });

    <%-- 查询 --%>
    function selRecord2() {
        $('#cqtj').datagrid('reload', {
            "startCqrq": $('#tj_startTssj').datebox('getValue'),
            "endCqrq": $('#tj_endTssj').datebox('getValue'),
            "ssqy": $("#tj_ssqy").val(),
            "azddDdh": $("#tj_azddDdh").val(),
            "xlmc": $("#tj_xlmc").val()
        });
    }
</script>
</html>

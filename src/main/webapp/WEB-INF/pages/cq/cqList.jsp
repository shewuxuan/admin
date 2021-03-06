<%--
  Created by IntelliJ IDEA.
  User: 2uli
  Date: 2020/2/14
  Time: 9:29 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处缺记录</title>                             <!-- 改 -->

    <%--<link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">--%>
    <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/css/demo.css">
    <script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="/style/wholemain.css">
    <script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
</head>
<body>

<div class="right_main">
<%--    <div class="right_nav">--%>
<%--        当前位置：处缺记录--%>
<%--    </div>--%>

    <div>
        <div class="tj">
            <form method="post">
                <table width="100%">
                    <tr>
                        <td style="width: 500px;text-align:left;">
                            <span>所属区域</span><select name="ssqy" id="ssqy" onchange="changeSsqy()" class="right_ipu2"></select>
                            <span id="yxdw_span">单位<select id="yxdw" onchange="changeYxdw()"></select></span>
                            <span>变电站</span><select id="bdz" onchange="changeBdz()"></select>
                            <span>线路</span><select id="xlmc"></select>
                        </td>
                        <td style="text-align:left;">
                            <span>装置类型</span>&nbsp;<select  name="zzlx" id="zzlx"  style="height:25px; border:1px solid #CCC;"></select>
                        </td>
                        <td style="text-align:left;">
                            <span>缺陷分类</span><select id="qxfl"></select>
                        </td>
                        <td>
                            <span style="text-align:left;">调度号</span><input id="azddDdh" type="text" style="width: 150px;border: 1px solid #CCC;">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align:left;">
                            <span>处缺日期</span><input class="easyui-datebox"  id="startCqrq" style="width:120px"/> 至
                            <input class="easyui-datebox"  id="endCqrq" style="width:120px"/>
                        </td>
                        <td style="text-align:left;">
                            <span>检索内容</span><input type="text" name="searchParam" id="searchParam" style="width: 200px;border: 1px solid #CCC;"/>
                        </td>
                        <td colspan="2">
                            <input type="button" name="button" value="查询" class="iput_m" onclick="selRecord()">
                            <c:if test="${funcMap.cqgl == 2}">
                            <input type="button" name="button" value="添加" class="iput_m" onclick="addRecord()">
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <br/>
        <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
            <table id="dg"></table>
        </div>
    </div>
</div>

<script type="text/javascript">
    // 缺陷分类
    $("#qxfl").append("<option value=''>全部</option>");
    $.get("${basePath}/qxfl/selectQxTypeByAll", function (data) {
        data = JSON.parse(data);
        $.each(data, function (i) {
            $("#qxfl").append("<option value='" + data[i].keyvalue + "'>" + data[i].keymemo + "</option>");
        })
    });
    //装置类型
    $.post("/zzlx/selectZzlxByAll", function (data) {
        let zzlx = JSON.parse(data);
        $("#zzlx").append("<option value=''>全部</option>");
        for (let i = 0, length = zzlx.length; i < length; i++) {
            $("#zzlx").append("<option name='"+ zzlx[i].keytype+"' value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
        }
    });
    /*$(function () {
        // 所属区域
        $("#ssqy").append("<option value=''>全部</option>");
        $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            for (let i = 0, length = ssqy.length; i < length; i++) {
                $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });
        // 装置类型
        $("#zzlx").append("<option value=''>全部</option>");
        $.get("${basePath}/zzlx/selectZzlxByAll", function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#zzlx").append("<option value='" + data[i].keyvalue + "'>" + data[i].keymemo + "</option>");
            })
        });
        // 缺陷分类
        $("#qxfl").append("<option value=''>全部</option>");
        $.get("${basePath}/qxfl/selectQxTypeByAll", function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#qxfl").append("<option value='" + data[i].keyvalue + "'>" + data[i].keymemo + "</option>");
            })
        });
        // 变电站
        $("#bdz").append("<option value=''>全部</option>");
        $.get("${basePath}/ssxl/selectByGroup/bdz", function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
            })
        });
        // 设备线路 - 线路名称
        $("#xlmc").append("<option value=''>全部</option>");
    });*/

    // 设备线路 - 变电站更改时，线路名称随之更改
    /*$("#bdz").change(function () {
        if ($("#bdz").val() === '') {
            $("#xlmc").empty();
            $("#xlmc").append("<option value=''>全部</option>");
            return;
        }
        $("#xlmc").empty();
        $("#xlmc").append("<option value=''>全部</option>");
        $.get("${basePath}/ssxl/selectByGroup/xlmc",{"bdz": $("#bdz").val()}, function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#xlmc").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
            })
        });
    })*/

    $(function () {
        $.post("/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            $("#ssqy").append("<option value='' selected>全部</option>");
            for (let i = 0, length = ssqy.length; i < length; i++) {
                $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });
    });

    //改变所属区域
    function changeSsqy(){
        var ssqy = $("#ssqy").val();
        $("#yxdw").empty();
        $("#bdz").empty();
        $("#xlmc").empty();
        $("#yxdw").append("<option value=''>全部</option>");
        if(ssqy != null && ssqy != '') {
            //若选择石景山
            if(ssqy ==1){
                $("#yxdw_span").hide();
                $("#bdz").empty();
                $("#xlmc").empty();
                $("#bdz").append("<option value=''>全部</option>");
                $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy").val(),'yxdw':'石景山'},function (data) {
                    data = JSON.parse(data);
                    $.each(data, function (i) {
                        $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
                    })
                });
            }else{
                $("#yxdw_span").show();
                $.get("/ssxl/selectByGroup/yxdw", {'ssqy':ssqy},function (data) {
                    data = JSON.parse(data);
                    $.each(data, function (i) {
                        $("#yxdw").append("<option value='" + data[i].yxdw + "'>" + data[i].yxdw + "</option>");
                    })
                });
            }
        }else{
            $("#yxdw").empty();
        }
    }
    //秀昂贵运行单位
    function changeYxdw(){
        var yxdw = $("#yxdw").val();
        $("#bdz").empty();
        $("#xlmc").empty();
        if(yxdw == '') return;
        $("#bdz").append("<option value=''>全部</option>");
        $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy").val(),'yxdw':$("#yxdw").val()},function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
            })
        });
    }
    //修改变电站
    function changeBdz(){
        $("#xlmc").empty();
        $("#xlmc").append("<option value=''>全部</option>");
        $.get("/ssxl/selectByGroup/xlmc", {'ssqy':$("#ssqy").val(),'yxdw':$("#yxdw").val(),'bdz': $("#bdz").val()}, function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#xlmc").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
            })
        });
    }
</script>

<%-- 表格 --%>
<script type="text/javascript">
    var cqglFun = '${funcMap.cqgl}';
    $(function () {
        $('#dg').datagrid({
            singleSelect: true,	// 设置为 true，则只允许选中一行。
            url: '${basePath}/cqrecord/selectByPage',             // 改
            method: 'get',
            iconCls: 'icon-ok',
            nowrap: true,
            striped: true,		// 设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
            collapsible: false,
            fitColumns: true,	// 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
            pagination: true,
            autoRowHeight: false,	// 定义是否设置基于该行内容的行高度。设置为 false，则可以提高加载性能。
            rownumbers: true,
            scrollbarSize: 0,
            remoteSort: true,
            pageList: [10, 15, 30, 50],
            pageSize: 10,//每页显示的记录条数，默认为15
            idField: 'cqrq',
            columns: [[
                {field: 'cqrq', halign: 'center', align: "center", title: '处缺日期', width: '8%', formatter: function (value,) {
                        return timeStamp2DateString(value);
                    }},
                {field: 'ssqyname', halign: 'center', align: "center", title: '所属区域', width: '5%'},
                {field: 'azddDdh', halign: 'center', align: "center", title: '设备调度号', width: '9%', formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},

                {field: 'xlmc', halign: 'center', align: "center", title: '设备线路', width: '9%', formatter:function (value, row, index) {
                    if(value == null | value==''){
                        return '';
                    }else {
                        var xlmc='';
                        var temp = '';
                        if(row.ssqy == 2){temp="门头沟-";}
                        if(row.ssqy == 3){temp="朝阳-";}
                        xlmc = temp+row.yxdw+"-"+row.bdz+"-"+row.xlmc;
                        if(row.ssqy == 1){
                            temp="";
                            xlmc = row.bdz+"-"+row.xlmc;
                        }
                        return xlmc;
                    }
                 }},
                {field: 'zzlxname', halign: 'center', align: "center", title: '装置类型', width: '6%', formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'qxflname', halign: 'center', align: "center", title: '缺陷分类', width: '10%', formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'qx', halign: 'center', align: "center", title: '缺陷', width: '7%', formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'cqjl', halign: 'center', align: "center", title: '处缺记录', width: '10%', formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'cqjg', halign: 'center', align: "center", title: '处缺结果', width: '10%', formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'sgdw', halign: 'center', align: "center", title: '处缺人员', width: '10%', formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},        // 改
                {field: 'trans', halign: 'center', align: "left", title: '操作', width: '13%', formatter: function (value, row, index) {
                        var txt1 = '&nbsp;&nbsp;<button href="javascript:void(0);" onclick="viewRecord(\'' + row.cqid + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '查看' + '</button>';
                        var txt2 = '&nbsp;&nbsp;<button href="javascript:void(0);" onclick="updRecord(\'' + row.cqid + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '修改' + '</button>';
                        var txt3 = '&nbsp;&nbsp;<button href="javascript:void(0);" onclick="delRecord(\'' + row.cqid + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                        if(cqglFun !=2 ){
                            return txt1;
                        }
                        return txt1 + txt2 + txt3;
                    }
                },
            ]],
        });
        selRecord();
    });
</script>

<%-- 操作 --%>
<script type="text/javascript">
    <%-- 查看 --%>
    function viewRecord(id) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${basePath}/cq/viewCq/" + id, "_blank", " height=600,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 添加 --%>
    function addRecord() {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${basePath}/cq/addCq", "_blank", " height=600,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 修改 --%>
    function updRecord(id) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${basePath}/cq/updCq/" + id, "_blank", " height=600,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");     // 改
    }

    <%-- 删除 --%>
    function delRecord(id) {
        if (!confirm("确认删除吗？")) {
            return;
        }
        $.get("${basePath}/cqrecord/deleteByPrimaryKey/" + id, function (data) {
            data = JSON.parse(data);
            alert(data.msg);
            $('#dg').datagrid("load");
        });
    }

    <%-- 查询 --%>
    function selRecord() {
        $('#dg').datagrid('load', {
            "startCqrq": $("#startCqrq").datebox('getValue'),
            "endCqrq": $("#endCqrq").datebox('getValue'),
            "ssqy": $("#ssqy").val(),
            "azddDdh": $("#azddDdh").val(),
            "yxdw": $("#yxdw").val(),
            "bdz": $("#bdz").val(),
            "xlmc": $("#xlmc").val(),
            "zzlx": $("#zzlx").val(),
            "qxfl": $("#qxfl").val(),
            "searchParam": $("#searchParam").val()
        });
    }
</script>
</body>
</html>

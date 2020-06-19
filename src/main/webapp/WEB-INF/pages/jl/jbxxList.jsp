<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../import.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/icon.css"/>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/easyui-custom.js"></script>
    <script type="text/javascript" src="/js/easyui-datagrid.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div class="right_main">
    <div class="right_nav">
        当前位置：调试信息
    </div>

    <div>
        <div class="tj">
            <form  method="post">
                <span>日期</span>
                <input class="easyui-datebox" name="startTssj" id="startTssj"
                       data-options="required:true" style="width:120px"/>
                &nbsp;至&nbsp;
                <input class="easyui-datebox" name="endTssj" id="endTssj"
                       data-options="required:true" style="width:120px"/>
                &nbsp;<span>设备调度号</span><input id="azddDdh" type="text" class="right_ipu2"/>
                &nbsp;&nbsp;<span>装置类型</span><select  name="zzlx" id="zzlx"  style="height:25px; border:1px solid #CCC;">
            </select>
                &nbsp;<span>所属区域</span>
                <select  name="ssqy" id="ssqy"  style="height:25px; border:1px solid #CCC;">
                </select>
                <input type="button" name="button"  value="查 询" class="iput_m" onclick="searchList()"/>
            </form>
        </div>

        <br/>
        <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
            <table id="tableList"></table>
        </div>
    </div>
</div>
<script>
    $(function () {
        <%-- 所属区域 --%>
        $("#ssqy").append("<option value=''>全部</option>");
        $.get("/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            for (let i = 0, length = ssqy.length; i < length; i++) {
                $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });

        <%-- 装置类型 --%>
        $("#zzlx").append("<option value=''>全部</option>");
        $.get("/zzlx/selectZzlxByAll", function (data) {
            let zzlx = JSON.parse(data);
            for (let i = 0, length = zzlx.length; i < length; i++) {
                $("#zzlx").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
            }
        });
    });
    function getQueryParams() {
        var queryParams = new Object();
        queryParams.startTssj = $('#startTssj').datebox('getValue');
        queryParams.endTssj = $('#endTssj').datebox('getValue');
        queryParams.azddDdh = $('#azddDdh').val();
        queryParams.zzlx = $('#zzlx').val();
        queryParams.ssqy = $('#ssqy').val();
        return queryParams;
    }
    function searchList(){
        $('#tableList').datagrid('options').url = '/jbxx/selectListJbxx.action';
        $('#tableList').datagrid('options').queryParams = getQueryParams();
        $('#tableList').datagrid("load");
    }

    <!-- 调试记录详情 -->
    function detailJbxx(tsid){
        window.open("${basePath}/jl/tsjl/" + tsid, "", "fullscreen=1");
    }

    function exportJbxx(tsid){
        location.href='${ctx}/jbxx/exportToWordByJbxx.action?tsid='+tsid;
    }

    function deleteJbxx(tsid){
        var formdata = new FormData();
        formdata.append("tsid",tsid);
        if(!confirm("确认删除吗？")){
            return;
        }
        $.ajax({
            url : '${ctx}/jbxx/deleteJbxxAndRecord.action',
            type : 'POST',
            async : false,
            data:formdata,
            processData : false,
            contentType : false,
            beforeSend:function(){
                console.log("正在加载，请稍候");
            },
            success : function(data) {
                alert(data.message);
                if(data.code == 0)
                    $('#tableList').datagrid("load");
            },
            error : function() {
                alert("页面加载错误！");
            }
        });
    }

    $(function(){
        $('#tableList').datagrid({
            iconCls:'icon-ok',
            //queryParams: getQueryParams(),
            nowrap: false,
            striped: true,
            collapsible:false,
            fitColumns: true,
            pagination:true,
            singleSelect:true,
            rownumbers:true,
            remoteSort:true,
            pageList:[10,15,30,50],
            pageSize: 10,//每页显示的记录条数，默认为10 
            idField:'ID',
            columns:[[
                {field:'TSID',align:"center",title:'调试ID',width:0,hidden:'true'},
                {field:'SSQY',align:"center",title:'所属区域',width:0},
                {field:'TSSJ',align:"center",title:'调试时间',width:30,  formatter : function(value){
                        var date = new Date(value);
                        var y = date.getFullYear();
                        var m = date.getMonth() + 1;
                        var d = date.getDate();
                        return y + '-' +m + '-' + d;
                    }},
                {field:'AZDD_DDH',align:"center",title:'设备调度号',width:30},
                {field:'SSXL',align:"center",title:'所属线路',width:30,formatter:function(value,row,index){
                        var xlmc = "";
                        $.ajax({
                            url: '/ssxl/selectByPrimaryKey/'+value,
                            type: 'GET',
                            async: false,
                            processData: false,
                            contentType: false,
                            beforeSend: function () {
                                console.log("正在加载，请稍候");
                            },
                            success: function (data) {
                                let data2 = JSON.parse(data);
                                xlmc = data2.bdz+"-"+data2.xlmc;
                            },
                            error: function () {
                                //alert("页面加载错误！");
                            }
                        });
                        return xlmc;
                    }},
                {field:'ZZXH',align:"left",title:'装置型号',width:30},
                {field:'SCCS',align:"left",title:'生产厂商',width:30},
                {field:'ZZLX',align:"left",title:'装置类型',width:30},
                {field:'TSRYXM',align:"left",title:'调试人员',width:30},
                {field:'trans',align:"left",title:'操作',width:90,formatter:function(value,row,index){
                        var txt1 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="detailJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '查看' + '</button>';
                        var txt2 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="exportJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '导出' + '</button>';
                        var txt3 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="deleteJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                        return txt1+txt2+txt3;
                    }},
            ]],
        });
        searchList();
    });
</script>
</body>
</html>
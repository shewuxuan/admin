<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处缺记录</title>
    <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/css/demo.css">
    <script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="/style/wholemain.css">
    <script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
</head>
<style>
    /* 文本超长class */
    .textEllipsis{
        /*color:red;!*颜色*!*/
        overflow: hidden;/*不允许滚动条*/
        white-space: nowrap;/*不允许文本换行*/
        text-overflow: ellipsis;/*文本超长显示省略号*/
    }

    /* 鼠标移上,显示全文class */
    .textEllipsis:hover {
        height: auto;
        word-break:break-all;
        white-space: pre-wrap;
        text-decoration: none;
    }
</style>
<body>
<div class="right_nav">
    当前位置：处缺信息
</div>
<div class="right_main">
    <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
        <table id="dg"></table>
    </div>
</div>
<script>
    var ids = '${ids}';
    function searchList3(){
        var queryParams = new Object();
        queryParams.ids=ids;
        $('#dg').datagrid('options').url = '${ctx}/cqrecord/getCqRecords';
        $('#dg').datagrid('options').queryParams=queryParams ;
        $('#dg').datagrid("load");
    }

    // 鼠标悬浮显示
    function contentFormat(value){
        if(value !== undefined && value !== '' && value != null){
            return "<div title='"+value+"' class='textEllipsis'>"+value+"</div>";
        }else{
            return '';
        }
    }

    $(function () {
        $('#dg').datagrid({
            iconCls:'icon-ok',
            //url:'/cqrecord/getCqRecords?ids='+ids,
            //queryParams: new Object().ids=ids,
            nowrap: false,
            striped: true,
            collapsible:false,
            fitColumns: true,
            pagination:false,
            singleSelect:true,
            rownumbers:true,
            remoteSort:true,
            //pageList:[10,15,30,50],
            //pageSize: 10,//每页显示的记录条数，默认为10 
            idField:'ID',
            columns: [[
                {field: 'cqrq', halign: 'center', align: "center", title: '处缺日期', width: 60,  formatter : function(value){
                        var date = new Date(value);
                        var y = date.getFullYear();
                        var m = date.getMonth() + 1;
                        var d = date.getDate();
                        return y + '-' +m + '-' + d;
                    }},
                {field: 'ssqy', halign: 'center', align: "center", title: '所属区域', width: 60},
                {field: 'azdd_ddh', halign: 'center', align: "center", title: '设备调度号', width: 60},
                {field: 'ssxl', halign: 'center', align: "center", title: '设备线路', width: 60},
                {field: 'zzlx', halign: 'center', align: "center", title: '装置类型', width: 60},
                {field: 'qxfl', halign: 'center', align: "center", title: '缺陷分类', width: 60},
                {field: 'qx', halign: 'center', align: "center", title: '缺陷', width: 60},
                {field: 'cqjl', halign: 'center', align: "center", title: '处缺记录', width: 60, formatter:function (value, row, index) {
                        return contentFormat(value);
                    }},
                {field: 'cqjg', halign: 'center', align: "center", title: '处缺结果', width: 60},
                {field: 'sgdw', halign: 'center', align: "center", title: '处缺人员', width: 60},        // 改
            ]],
        });
        searchList3();
    });
</script>
</body>
</html>

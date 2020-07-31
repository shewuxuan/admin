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
    <script type="text/javascript" src="/js/ssqy_yxdw_bdz_xlmc.js"></script>
</head>
<body>
<div class="right_nav">
    当前位置：调试信息
</div>
<div class="qh">
    <div class="tab" style="">
        <a href="javascript:;" class="on" style="border-left:1px solid white;">DTU调试</a>
        <%--<a href="javascript:;">FTU调试</a>--%>
        <a href="javascript:;">配网保护</a>
    </div>
    <br/>
    <div class="content">
        <ul>
            <!--  1 begin-->
            <li style="display:block;">
                <div>
                    <div class="tj">
                        <form  method="post">
                            <span>所属区域</span><select name="ssqy" id="ssqy" onchange="changeSsqy()" class="right_ipu2"></select>
                            <span id="yxdw_span">单位<select id="yxdw" onchange="changeYxdw()"></select></span>
                            <span>变电站</span><select id="bdz" onchange="changeBdz()"></select>
                            <span>线路</span><select id="xlmc"></select>
                            &nbsp;&nbsp;&nbsp;<span>装置类型</span><select  name="zzlx" id="zzlx" ></select>
                            &nbsp;&nbsp;<span>日期</span>
                            <input class="easyui-datebox" name="startTssj" id="startTssj"
                                   data-options="required:true" style="width:120px"/>
                            &nbsp;至&nbsp;
                            <input class="easyui-datebox" name="endTssj" id="endTssj"
                                   data-options="required:true" style="width:120px"/>
                            &nbsp;&nbsp;<span>设备调度号</span><input id="azddDdh" type="text" class="right_ipu2"/>

                        </select>
                            <input type="button" name="button"  value="查 询" class="iput_m" onclick="searchList1()"/>
                        </form>
                    </div>

                    <br/>
                    <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
                        <table id="tableList1"></table>
                    </div>
                </div>
            </li>

            <!--  1 end-->
            <!--  2 begin-->
           <%-- <li style="display:block;" id="li2">
                <div>
                    <div class="tj">
                        <form  method="post">
                            &nbsp;<span>终端名称</span>&nbsp;<input id="zdmc2" type="text" class="right_ipu2"/>
                            &nbsp;<span>设备调度号</span>&nbsp;<input id="azddDdh2" type="text" class="right_ipu2"/>
                            &nbsp;&nbsp;<span>装置类型</span>&nbsp;<select  name="zzlx" id="zzlx2"  style="height:25px; border:1px solid #CCC;"></select>
                            &nbsp;<span>所属区域</span>&nbsp;<select  name="ssqy" id="ssqy2"  style="height:25px; border:1px solid #CCC;"></select>
                            <input type="button" name="button"  value="查 询" class="iput_m" onclick="searchList2()"/>
                            <input type="button" name="button"  value="创 建" class="iput_m" onclick="g1_equip()">
                            <input type="button" name="button"  value="设备地图" class="iput_m" onclick="g2_equip()">
                        </form>
                    </div>

                    <br/>
                    <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
                        <table id="tableList2"></table>
                    </div>
                </div>
            </li>--%>
            <!-- 3 begin-->
            <li style="display:block;" id="li3">
                <div>
                    <div class="tj">
                        <form  method="post">
                            <span>所属区域</span><select id="ssqy3" onchange="changeSsqy3()" class="right_ipu2"></select>
                            <span id="yxdw_span3">单位<select id="yxdw3" onchange="changeYxdw3()"></select></span>
                            <span>变电站</span><select id="bdz3" onchange="changeBdz3()"></select>
                            <span>线路</span><select id="xlmc3"></select>
                            &nbsp;&nbsp;<span>调度号</span>&nbsp;<input id="azddDdh3" type="text" class="right_ipu2"/>
                            &nbsp;&nbsp;<span>日期</span>
                            <input class="easyui-datebox" name="startTssj" id="startTssj3"
                                   data-options="required:true" style="width:120px"/>
                            &nbsp;至&nbsp;
                            <input class="easyui-datebox" name="endTssj" id="endTssj3"
                                   data-options="required:true" style="width:120px"/>
                            <input type="button" name="button"  value="查 询" class="iput_m" onclick="searchList3()"/>
                            <%--<input type="button" name="button"  value="创 建" class="iput_m" onclick="g1()">--%>
                        </form>
                    </div>

                    <br/>
                    <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
                        <table id="tableList3"></table>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>
<script>
    $(function () {
        $('#tableList1').datagrid({
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
                {field:'TSID',align:"left",title:'调试ID',width:0,hidden:'true'},
                {field:'SSQY',align:"center",title:'所属区域',width:20},
                {field:'TSSJ',align:"center",title:'调试时间',width:25,  formatter : function(value){
                        var date = new Date(value);
                        var y = date.getFullYear();
                        var m = date.getMonth() + 1;
                        var d = date.getDate();
                        return y + '-' +m + '-' + d;
                    }},
                {field:'AZDD_DDH',align:"center",title:'设备调度号',width:50},
                {field:'SSXL',align:"center",title:'所属线路',width:50,formatter:function(value,row,index){
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
                {field:'ZZXH',align:"center",title:'装置型号',width:30},
                {field:'SCCS',align:"center",title:'生产厂商',width:40},
                {field:'ZZLX',align:"center",title:'装置类型',width:30},
                {field:'TSRYXM',align:"center",title:'调试人员',width:40},
                {field:'trans',align:"left",title:'操作',width:45,formatter:function(value,row,index){
                        var txt1 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="detailJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '查看' + '</button>';
                        var txt2 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="exportJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '导出' + '</button>';
                        var txt3 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="deleteJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                        return txt1+txt2+txt3;
                    }},
            ]],
        });
        searchList1();
        $("#li2").hide();
        $("#li3").hide();

        $(".qh .tab a").click(function () {
            $(this).addClass('on').siblings().removeClass('on');
            var index = $(this).index();
            $('.qh .content li').hide();
            $('.qh .content li:eq(' + (index) + ')').show();
            if (index == 0) {
                $("#li2").hide();
                $("#li3").hide();
            }
            /*if (index == 1) {
                $("#ssqy2").append("<option value=''>全部</option>");
                $.post("/ssqy/selectSsqyByAll", function (data) {
                    let ssqy = JSON.parse(data);
                    for (let i = 0, length = ssqy.length; i < length; i++) {
                        $("#ssqy2").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
                    }
                });

                <%-- 装置类型 --%>
                $("#zzlx2").append("<option value=''>全部</option>");
                $.post("/sbZzlx/selectSbZzlxByAll", function (data) {
                    let zzlx = JSON.parse(data);
                    for (let i = 0, length = zzlx.length; i < length; i++) {
                        $("#zzlx2").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
                    }
                });

                    $('#tableList2').datagrid({
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
                            {field:'SBID',align:"center",title:'设备ID',width:0,hidden:'true'},
                            {field:'SSQY',align:"left",title:'所属区域',width:30},
                            {field:'AZDD_DDH',align:"center",title:'设备调度号',width:30},
                            /!*{field:'ZDMC',align:"center",title:'终端名称',width:30},*!/
                            {field:'SSXL',align:"center",title:'所属线路',width:60,formatter:function(value,row,index){
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
                            {field:'ZBXH',align:"center",title:'装置型号',width:30},
                            {field:'ZBBH',align:"center",title:'装置编号',width:50},
                            {field:'ZZLX',align:"center",title:'装置类型',width:30},
                            {field:'XXWZ',align:"center",title:'详细位置',width:90},
                            {field:'trans',align:"left",title:'操作',width:50,formatter:function(value,row,index){
                                    var txt0 = '<button href="javascript:void(0);" onclick="seeEquipInfo(\'' + row.SBID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '查看' + '</button>';
                                    var txt1 = '&nbsp;<button href="javascript:void(0);" onclick="editEquipInfo(\'' + row.SBID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '编辑' + '</button>';
                                    var txt2 = '&nbsp;<button href="javascript:void(0);" onclick="delEquipInfo(\'' + row.SBID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                                    return txt0+txt1+txt2;
                                }},
                        ]],
                    });
                    searchList2();
            }*/
            if(index == 1){
                $('#tableList3').datagrid({
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
                        {field:'TSID',align:"left",title:'调试ID',width:0,hidden:'true'},
                        {field:'TSSJ',align:"left",title:'调试时间',width:60,  formatter : function(value){
                                var date = new Date(value);
                                var y = date.getFullYear();
                                var m = date.getMonth() + 1;
                                var d = date.getDate();
                                return y + '-' +m + '-' + d;
                            }},
                        {field:'AZDD_DDH',align:"left",title:'设备调度号',width:60},
                        {field:'SSXL',align:"left",title:'所属线路',width:60,formatter:function(value,row,index){
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
                        {field:'LM',align:"left",title:'路名',width:60},
                        {field:'trans',align:"left",title:'操作',width:60,formatter:function(value,row,index){
                                var txt3 = '&nbsp;<button href="javascript:void(0);" onclick="seePwbhJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '查看' + '</button>';
                                var txt4 = '&nbsp;<button href="javascript:void(0);" onclick="delPwbhJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                                var txt5 = '&nbsp;<button href="javascript:void(0);" onclick="exportPwbhJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '导出' + '</button>';
                                return  txt3+txt4+txt5;
                            }},
                    ]],
                });
                searchList3();
            }
        });
    });
    function getQueryParams1() {
        var queryParams = new Object();
        queryParams.startTssj = $('#startTssj').datebox('getValue');
        queryParams.endTssj = $('#endTssj').datebox('getValue');
        queryParams.azddDdh = $('#azddDdh').val();
        queryParams.zzlx = $('#zzlx').val();
        queryParams.ssqy = $('#ssqy').val();
        queryParams.yxdw = $('#yxdw').val();
        queryParams.bdz = $('#bdz').val();
        queryParams.xlmc = $('#xlmc').val();
        return queryParams;
    }
    function searchList1(){
        $('#tableList1').datagrid('options').url = '/jbxx/selectListJbxx.action';
        $('#tableList1').datagrid('options').queryParams = getQueryParams1();
        $('#tableList1').datagrid("load");
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
                    $('#tableList1').datagrid("load");
            },
            error : function() {
                alert("页面加载错误！");
            }
        });
    }
</script>
<%--设备信息--%>
<script>
    function getQueryParams2() {
        var queryParams = new Object();
        queryParams.zdmc = $('#zdmc2').val();
        queryParams.azddDdh = $('#azddDdh2').val();
        queryParams.zzlx = $('#zzlx2').val();
        queryParams.ssqy = $('#ssqy2').val();
        return queryParams;
    }
    function searchList2(){
        $('#tableList2').datagrid('options').url = '${ctx}/equip/selectListEquipInfo.action';
        $('#tableList2').datagrid('options').queryParams = getQueryParams2();
        $('#tableList2').datagrid("load");
    }


    function editEquipInfo(sbid){
        var w=window.screen.width/2-950/2;
        var t=window.screen.height/2-600/2-35;
        window.open("${ctx}/equip/toEditEquipInfoView.action?sbid="+sbid,"_blank");
    }
    function seeEquipInfo(sbid){
        var w=0;
        var t=0;
        window.open("${ctx}/equip/toSeeEquipInfoView.action?sbid="+sbid,"_blank");
    }

    function delEquipInfo(sbid){
        var formdata = new FormData();
        formdata.append("sbid",sbid);
        if(!confirm("确认删除吗？")){
            return;
        }
        $.ajax({
            url : '${ctx}/equip/deleteEquipInfo.action',
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
                    $('#tableList2').datagrid("load");
            },
            error : function() {
                alert("页面加载错误！");
            }
        });
    }


    function g1_equip(){
        var w=window.screen.width/2-950/2;
        var t=window.screen.height/2-600/2-35;
        window.open("/equip/toAddEquipInfoView.action","_blank");
    }
    function g2_equip(){
        window.open("/equip/toSeeAllEquipInfoView.action","_blank");
    }
</script>
<%--配网保护--%>
<script>
    $(function () {
        $.post("/ssqy/selectSsqyByAll", function (data) {
            let ssqy = JSON.parse(data);
            $("#ssqy3").append("<option value='' selected>全部</option>");
            for (let i = 0, length = ssqy.length; i < length; i++) {
                $("#ssqy3").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });
    });

    //改变所属区域
    function changeSsqy3(){
        var ssqy = $("#ssqy3").val();
        $("#yxdw3").empty();
        $("#bdz3").empty();
        $("#xlmc3").empty();
        $("#yxdw3").append("<option value=''>全部</option>");
        if(ssqy != null && ssqy != '') {
            //若选择石景山
            if(ssqy ==1){
                $("#yxdw_span3").hide();
                $("#bdz3").empty();
                $("#xlmc3").empty();
                $("#bdz3").append("<option value=''>全部</option>");
                $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy3").val(),'yxdw':'石景山'},function (data) {
                    data = JSON.parse(data);
                    $.each(data, function (i) {
                        $("#bdz3").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
                    })
                });
            }else{
                $("#yxdw_span3").show();
                $.get("/ssxl/selectByGroup/yxdw", {'ssqy':ssqy},function (data) {
                    data = JSON.parse(data);
                    $.each(data, function (i) {
                        $("#yxdw3").append("<option value='" + data[i].yxdw + "'>" + data[i].yxdw + "</option>");
                    })
                });
            }
        }else{
            $("#yxdw3").empty();
        }
    }
    //秀昂贵运行单位
    function changeYxdw3(){
        var yxdw = $("#yxdw3").val();
        $("#bdz3").empty();
        $("#xlmc3").empty();
        if(yxdw == '') return;
        $("#bdz3").append("<option value=''>全部</option>");
        $.get("/ssxl/selectByGroup/bdz", {'ssqy':$("#ssqy3").val(),'yxdw':$("#yxdw3").val()},function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#bdz3").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
            })
        });
    }
    //修改变电站
    function changeBdz3(){
        $("#xlmc3").empty();
        $("#xlmc3").append("<option value=''>全部</option>");
        $.get("/ssxl/selectByGroup/xlmc", {'ssqy':$("#ssqy3").val(),'yxdw':$("#yxdw3").val(),'bdz': $("#bdz3").val()}, function (data) {
            data = JSON.parse(data);
            $.each(data, function (i) {
                $("#xlmc3").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
            })
        });
    }

    function getQueryParams3() {
        var queryParams = new Object();
        queryParams.startTssj = $('#startTssj3').datebox('getValue');
        queryParams.endTssj = $('#endTssj3').datebox('getValue');
        queryParams.azddDdh = $('#azddDdh3').val();
        queryParams.ssqy = $('#ssqy3').val();
        queryParams.yxdw = $('#yxdw3').val();
        queryParams.bdz = $('#bdz3').val();
        queryParams.xlmc = $('#xlmc3').val();
        return queryParams;
    }
    function searchList3(){
        $('#tableList3').datagrid('options').url = '${ctx}/pwbhJbxx/selectListPwbhJbxx.action';
        $('#tableList3').datagrid('options').queryParams = getQueryParams3();
        $('#tableList3').datagrid("load");
    }

    function seePwbhJbxx(tsid){
        var w=window.screen.width/2-950/2;
        var t=window.screen.height/2-600/2-35;
        <%--window.open("${ctx}/pwbhJbxx/toSeePwbhJbxxView.action?tsid="+tsid,"_blank");--%>
        window.open("${ctx}/pwbh/tsjl/tsjl/" + tsid,"_blank");
    }
    function delPwbhJbxx(tsid){
        var formdata = new FormData();
        formdata.append("tsid",tsid);
        if(!confirm("确认删除吗？")){
            return;
        }
        $.ajax({
            url : '${ctx}/pwbhJbxx/delPwbhJbxx.action',
            type : 'POST',
            async : false,
            data:formdata,
            // 告诉jQuery不要去处理发送的数据
            processData : false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType : false,
            beforeSend:function(){
                console.log("正在加载，请稍候");
            },
            success : function(data) {
                alert(data.message);
                if(data.code == 0)
                    $('#tableList3').datagrid("load");
            },
            error : function() {
                alert("页面加载错误！");
            }
        });
    }

    function exportPwbhJbxx(tsid){
        location.href='${ctx}/pwbhJbxx/exportToWordByPwbhJbxx.action?tsid='+tsid;
    }
    function g1_pwbh(){
        var w=window.screen.width/2-950/2;
        var t=window.screen.height/2-600/2-35;
        window.open("/pwbhJbxx/toAddPwbhJbxxView.action","_blank"," height=500,width=1000,top="+t+",left="+w+",toolbar=no,menubar=no,localtion=no,scrollbars=no");
    }
</script>
</body>
</html>
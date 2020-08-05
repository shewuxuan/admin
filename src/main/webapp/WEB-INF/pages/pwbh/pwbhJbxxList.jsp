<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../import.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" type="text/css" href="/static/style/wholemain.css"/>
	<link rel="stylesheet" type="text/css" href="/static/style/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="/static/style/easyui/themes/icon.css"/>
	<script type="text/javascript" src="/static/js/common.js"></script>
	<script type="text/javascript" src="/static/js/easyui-custom.js"></script>
	<script type="text/javascript" src="/static/js/easyui-datagrid.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/static/js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div class="right_main">
	<div class="right_nav">
		当前位置：基本信息
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

					&nbsp;<span>调度号</span>&nbsp;<input id="azddDdh" type="text" class="right_ipu2"/>

					&nbsp;<span>所属线路</span>
					<select id="bdz" style="height:25px;width: 100px; border:1px solid #CCC;"></select>
					<select id="xlmc" style="height:25px;width: 100px; border:1px solid #CCC;"></select>

					<input type="button" name="button"  value="查 询" class="iput_m" onclick="searchList()"/>
					<%--<input type="button" name="button"  value="创 建" class="iput_m" onclick="g1()">--%>
				</form>
				</div>

				 <br/>
					<div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
								<table id="tableList"></table>
						</div>
		</div>
</div>
<script>
	// 变电站
	$("#bdz").append("<option value=''>全部</option>");
	$.get("/ssxl/selectByGroup/bdz", function (data) {
		data = JSON.parse(data);
		$.each(data, function (i) {
			$("#bdz").append("<option value='" + data[i].bdz + "'>" + data[i].bdz + "</option>");
		})
	});
	// 线路名称
	$("#xlmc").append("<option value=''>全部</option>");

	// 变电站更改时，线路名称随之更改
	$("#bdz").change(function () {
		if ($("#bdz").val() === '') {
			$("#xlmc").empty();
			$("#xlmc").append("<option value=''>全部</option>");
			return;
		}
		$("#xlmc").empty();
		$("#xlmc").append("<option value=''>全部</option>");
		$.get("/ssxl/selectByGroup/xlmc",{"bdz": $("#bdz").val()}, function (data) {
			data = JSON.parse(data);
			$.each(data, function (i) {
				$("#xlmc").append("<option value='" + data[i].id + "'>" + data[i].xlmc + "</option>");
			})
		});
	});

function getQueryParams() {
	var queryParams = new Object();
    queryParams.startTssj = $('#startTssj').datebox('getValue');
    queryParams.endTssj = $('#endTssj').datebox('getValue');
    queryParams.azddDdh = $('#azddDdh').val();
    queryParams.bdz = $('#bdz').val();
    queryParams.xlmc = $('#xlmc').val();
    return queryParams;
}
function searchList(){
	$('#tableList').datagrid('options').url = '${ctx}/pwbhJbxx/selectListPwbhJbxx.action';
	$('#tableList').datagrid('options').queryParams = getQueryParams();
    $('#tableList').datagrid("load");
}

function seeJbxx(tsid){
	var w=window.screen.width/2-950/2;
	var t=window.screen.height/2-600/2-35;
	window.open("${ctx}/pwbhJbxx/toSeePwbhJbxxView.action?tsid="+tsid,"_blank");
}
function delJbxx(tsid){
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
					$('#tableList').datagrid("load");
		},
		error : function() {
			alert("页面加载错误！");
		}
	}); 
}

function exportJbxx(tsid){
	location.href='${ctx}/pwbhJbxx/exportToWordByPwbhJbxx.action?tsid='+tsid;
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
				{field:'TSID',align:"left",title:'调试ID',width:0,hidden:'true'},
				{field:'TSSJ',align:"left",title:'调试时间',width:30,  formatter : function(value){
                        var date = new Date(value);
                        var y = date.getFullYear();
                        var m = date.getMonth() + 1;
                        var d = date.getDate();
                        return y + '-' +m + '-' + d;
                    }},
				{field:'AZDD_DDH',align:"left",title:'设备调度号',width:30},
				{field:'SSXL',align:"left",title:'所属线路',width:30,formatter:function(value,row,index){
					if(value == null | value=='') return '';
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
				{field:'LM',align:"left",title:'路名',width:30},
				{field:'trans',align:"left",title:'操作',width:90,formatter:function(value,row,index){
						var txt3 = '&nbsp;<button href="javascript:void(0);" onclick="seeJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '查看' + '</button>';
						var txt4 = '&nbsp;<button href="javascript:void(0);" onclick="delJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
						var txt5 = '&nbsp;<button href="javascript:void(0);" onclick="exportJbxx(\'' + row.TSID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '导出' + '</button>';
						return  txt3+txt4+txt5;
					}},
		]],
	});
	searchList();
});
function g1(){
	var w=window.screen.width/2-950/2;
	var t=window.screen.height/2-600/2-35;
	window.open("/pwbhJbxx/toAddPwbhJbxxView.action","_blank"," height=500,width=1000,top="+t+",left="+w+",toolbar=no,menubar=no,localtion=no,scrollbars=no");
}
</script>
</body>
</html>
</html>
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
		当前位置：设备信息
	</div>

		<div>
				<div class="tj">
				<form  method="post">
                     &nbsp;<span>终端名称</span>&nbsp;<input id="zdmc" type="text" class="right_ipu2"/>
                     &nbsp;<span>安装地点及调度号</span>&nbsp;<input id="azddDdh" type="text" class="right_ipu2"/>
					&nbsp;&nbsp;<span>装置类型</span>&nbsp;<select  name="zzlx" id="zzlx"  style="height:25px; border:1px solid #CCC;"></select>
					&nbsp;<span>所属区域</span>&nbsp;<select  name="ssqy" id="ssqy"  style="height:25px; border:1px solid #CCC;"></select>
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
		$.post("/ssqy/selectSsqyByAll", function (data) {
			let ssqy = JSON.parse(data);
			for (let i = 0, length = ssqy.length; i < length; i++) {
				$("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
			}
		});

		<%-- 装置类型 --%>
		$("#zzlx").append("<option value=''>全部</option>");
		$.post("/sbZzlx/selectSbZzlxByAll", function (data) {
			let zzlx = JSON.parse(data);
			for (let i = 0, length = zzlx.length; i < length; i++) {
				$("#zzlx").append("<option value='" + zzlx[i].keyvalue + "'>" + zzlx[i].keymemo + "</option>");
			}
		});
	});
function getQueryParams() {
	var queryParams = new Object();
    queryParams.zdmc = $('#zdmc').val();
    queryParams.azddDdh = $('#azddDdh').val();
    queryParams.zzlx = $('#zzlx').val();
    queryParams.ssqy = $('#ssqy').val();
    return queryParams;
}
function searchList(){
	$('#tableList').datagrid('options').url = '${ctx}/equip/selectListEquipInfo.action';
	$('#tableList').datagrid('options').queryParams = getQueryParams();
    $('#tableList').datagrid("load");
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
				{field:'SBID',align:"center",title:'设备ID',width:0,hidden:'true'},
				{field:'SSQY',align:"left",title:'所属区域',width:30},
				{field:'AZDD_DDH',align:"center",title:'安装地点及调度号',width:30},
				{field:'ZDMC',align:"center",title:'终端名称',width:30},
				{field:'SSXL',align:"center",title:'所属线路',width:30},
				{field:'ZBXH',align:"center",title:'装置型号',width:30},
				{field:'ZBBH',align:"center",title:'装置编号',width:30},
				{field:'ZZLX',align:"center",title:'装置类型',width:30},
				{field:'XXWZ',align:"center",title:'详细位置',width:90},
				{field:'trans',align:"left",title:'操作',width:60,formatter:function(value,row,index){
						var txt0 = '<button href="javascript:void(0);" onclick="pick(\'' + row.SBID + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '选定' + '</button>';
						return txt0;
					}},
			]],
		});
		searchList();
	});

	function pick(sbid) {
		window.opener.document.getElementById("sbxx_sbid").value = sbid;
		window.opener.selectBySbid(sbid);
		window.close();
	}
</script>
</body>
</html>
</html>
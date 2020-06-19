<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据管理</title>

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
<script>
	function addTab(myobj,url) {
		var title = myobj.innerHTML;
		addTabBase(title,url);
	}

	function addTabBase(title,url) {
		if ($('#main').tabs('exists', title)) {
			$('#main').tabs('close', title);
		}
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:99%;"></iframe>';
		$('#main').tabs('add', {
			title : title,
			iconCls : '',
			content : content,
			closable : true
		});
		//禁止windows自带的右键点击事件
		document.oncontextmenu = function(){return false;};
		//右键点击事件
		$(".tabs-inner").bind('contextmenu',function(e){
			$('#mm').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
			var subtitle =$(this).children("span").text();
			$('#main').data("currtab",subtitle);
			return false;
		});
	}


	$(document).ready(function() {
		//addTab('项目管理','./pro-list.html','icon-user');		//初始化第一个面板
		//$('#main').load("pro-list.html");//初始化中央区域
		/*if (self != top) {
			top.location = self.location;
		}*/
		$("#left h3").click(function(){
			$(this).addClass("menu-selected").siblings().removeClass("menu-selected");
		})
		$("h3").attr("style","cursor:hand");
		tabCloseEven();
		$('#subnav li').click(function(){
			$(this).addClass("ll").siblings().removeClass("ll");
		});

	});

	function tabCloseEven() {

		var defaultTitle = "公告&消息";
		//关闭当前
		$('#mm-tabclose').click(function() {
			var tt = $('#main').data("currtab");
			$('#main').tabs('select', tt);
			if (tt == defaultTitle) {
				$.messager.alert('信息提示', "不能关闭默认tab页", 'info', function() {
					return false;
				});
			} else {
				$('#main').tabs('close', tt);
			}
		})
		//全部关闭
		$('#mm-tabcloseall').click(function() {
			var tt = $('#main').data("currtab");
			$('#main').tabs('select', tt);

			$('.tabs-inner span').each(function(i, n) {
				var t = $(n).text();
				if (t != defaultTitle) {
					$('#main').tabs('close', t);
				}
			});
		});
		//关闭除当前之外的TAB
		$('#mm-tabcloseother').click(function() {
			var tt = $('#main').data("currtab");
			$('#main').tabs('select', tt);

			$('.tabs-inner span').each(function(i, n) {
				var t = $(n).text();
				if (t != tt && t != defaultTitle) {
					$('#main').tabs('close', t);
				}
			});
		});
		//关闭当前右侧的TAB
		$('#mm-tabcloseright').click(function() {
			var tt = $('#main').data("currtab");
			$('#main').tabs('select', tt);

			var nextall = $('.tabs-selected').nextAll();
			if (nextall.length == 0) {
				$.messager.alert('信息提示', "右侧没有可以关闭的tab页", 'info', function() {
					return false;
				});
			}
			nextall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				if (t != defaultTitle) {
					$('#main').tabs('close', t);
				}
			});
			return false;
		});
		//关闭当前左侧的TAB
		$('#mm-tabcloseleft').click(function() {
			var tt = $('#main').data("currtab");
			$('#main').tabs('select', tt);

			var prevall = $('.tabs-selected').prevAll();
			if (prevall.length <= 0) {
				$.messager.alert('信息提示', "左侧没有可以关闭的tab页", 'info', function() {
					return false;
				});
			}
			prevall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				if (t != defaultTitle) {
					$('#main').tabs('close', t);
				}
			});
			return false;
		});
	}
</script>
</head>
<style>
	html,body { margin:0px;height:100%; }
	.accordion-body h3 {
		border: 1px solid #eee;
		font-size: 12px;
		font-weight: normal;
		height: 20px;
		line-height: 20px;
		margin: 2px;
		text-indent: 5px;
		width: 96%;

		cursor: pointer;
	}
	.menu-selected {background:#fbec88;}
</style>
<body class="easyui-layout">
<div region="west" split="true" style="width: 160px; overflow: auto;">
	<div class="easyui-accordion" id="left" fit="true" border="true">
		<div title="DTU标准管理" style="overflow: auto;" iconCls="icon-system">
			<h3 onClick="addTab(this,'/bz/wgpz/wgpzList');">DTU外观结构与配置</h3>
			<h3 onClick="addTab(this,'/bz/jydz/jydzList');">绝缘电阻</h3>
			<h3 onClick="addTab(this,'/bz/hldz/hldzList');">CT回路电阻</h3>
			<h3 onClick="addTab(this,'/bz/dyxn/dyxnList');">电源性能</h3>
			<h3 onClick="addTab(this,'/bz/lpjy/lpjyList');">电流电压零漂校验</h3>
			<h3 onClick="addTab(this,'/bz/cyjd/cyjdList');">采样精度</h3>
			<h3 onClick="addTab(this,'/bz/dlhl/dlhlList');">模拟CT一次电流验证回路</h3>
			<h3 onClick="addTab(this,'/bz/gncs/gncsList');">功能调试标准</h3>
			<h3 onClick="addTab(this,'/bz/ctgy/ctgyList');">CT安装工艺检查标准</h3>
			<h3 onClick="addTab(this,'/bz/kgg/kggList');">开关柜</h3>
			<h3 onClick="addTab(this,'/bz/ykts/yktsList');">遥控功能调试</h3>
			<h3 onClick="addTab(this,'/bz/ycts/yctsList');">遥测功能调试</h3>
			<h3 onClick="addTab(this,'/bz/gjcs/gjcsList');">告警功能调试</h3>
		</div>

		<div title="FTU标准管理" style="overflow: auto;" iconCls="icon-system">
			<h3 onClick="addTab(this,'/bz/ftu/cyjdcs/cyjdcsList');">采样精度测试(一次值)</h3>
			<h3 onClick="addTab(this,'/bz/ftu/cyjd/cyjdList');">采样精度测试(二次值)</h3>
			<h3 onClick="addTab(this,'/bz/ftu/gjts/gjtsList');">告警调试</h3>
			<h3 onClick="addTab(this,'/bz/ftu/gncs/gncsList');">功能测试</h3>
			<h3 onClick="addTab(this,'/bz/ftu/hbdy/hbdyList');">后备电源</h3>
			<h3 onClick="addTab(this,'/bz/ftu/lpjy/lpjyList');">电流电压零漂校验</h3>
			<h3 onClick="addTab(this,'/bz/ftu/tyjc/tyjcList');">投运前检查</h3>
			<h3 onClick="addTab(this,'/bz/ftu/tzyb/tzybList');">跳闸压板</h3>
		</div>

		<div title="配网保护标准管理" style="overflow: auto;" iconCls="icon-system">
			<h3 onClick="addTab(this,'/bz/pwbh/bhct/bhctList');">保护CT标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/dzjc/dzjcList');">定值检查标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/jdjy/jdjyList');">电流电压精度检验标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/jxdx/jxdxList');">紧线及对线标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/jycs/jycsList');">绝缘测试标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/lpjy/lpjyList');">电流电压零漂校验标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/sgjc/sgjcList');">收工前检查标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/wgjc/wgjcList');">外观检查标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/yqyb/yqybList');">仪器仪表标准</h3>
			<h3 onClick="addTab(this,'/bz/pwbh/zzsy/zzsyList');">整组试验标准</h3>
		</div>
	</div>

</div>


<div region="center" title="" style="overflow: hidden;">

	<div id="main" class="easyui-tabs" data-options="tools:'#tab-tools'" fit="true" border="true"
		 style="background: #fff;">
		<%--<div class="main" title="公告&消息"
			 style="position: relative; background: #fff;">
			<iframe src="${ctx}/auth/noticeList.action" width="100%" height="100%"></iframe>
		</div>--%>
	</div>
</div>

<div region="south" border="false" class="bottom"
	 style="background: #EEE;"></div>

<div id="ccc" region="center" title="">
	<div id="main"></div>
</div>

<div id="mm" class="easyui-menu" style="width: 150px;">
	<div id="mm-tabclose">关闭</div>
	<div id="mm-tabcloseall">全部关闭</div>
	<div id="mm-tabcloseother">除此之外全部关闭</div>
	<div class="menu-sep"></div>
	<div id="mm-tabcloseright">当前页右侧全部关闭</div>
	<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
</div>
</body>
<script>
</script>
</html>

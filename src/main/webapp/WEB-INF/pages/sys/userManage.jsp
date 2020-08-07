<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="../import.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>系统管理</title>

    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <link rel="Stylesheet" type="text/css" href="/style/main.css"/>
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/style/easyui/themes/icon.css"/>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/easyui-custom.js"></script>
    <script type="text/javascript" src="/js/easyui-datagrid.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
    <script>
        function g4() {
            var w = window.screen.width / 2 - 950 / 2;
            var t = window.screen.height / 2 - 600 / 2 - 35;
            window.open("/user/toAddUserInfoView.action", null, " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");
        }

        function g9() {
            var w = window.screen.width / 2 - 950 / 2;
            var t = window.screen.height / 2 - 600 / 2 - 35;
            window.open("/role/toAddRoleInfoView.action", null, " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");
        }
    </script>
    <script>
        function importItems(){
            var fileDir = $("#file").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
            } else if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
            } else{
                var formdata = new FormData($("#myForm")[0]);
                $.ajax({
                    url : "${ctx}/ssxl/importExcel",
                    type : 'POST',
                    async : false,
                    data : formdata,
                    processData : false,
                    contentType : false,
                    beforeSend:function(){
                        console.log("正在进行，请稍候");
                    },
                    success : function(data) {
                        alert(data.message);
                    },
                    error : function() {
                        alert("导入出错！");
                    }
                });
            }
        }
    </script>
</head>
<body>
<div class="right_nav">
    当前位置：系统管理
</div>
<div class="qh">
    <div class="tab" style="">
        <c:if test="${funcMap.yhgl != 0 }">
        <a href="javascript:;" id="a1" class="on" style="border-left:1px solid white;" onclick="onLi1(this)">用户管理</a>
        </c:if>
        <c:if test="${funcMap.qxgl != 0 }">
        <a href="javascript:;" id="a2" onclick="onLi2(this)">权限管理</a>
        </c:if>
        <a href="javascript:;" id="a3" onclick="onLi3(this)">修改密码</a>
        <a href="javascript:;" id="a4" onclick="onLi4(this)">线路管理</a>
    </div>
    <br/>
    <div class="content">
        <ul>
            <!--  1 begin-->
            <c:if test="${funcMap.yhgl == 0 }">
            <li style="display:none;" id="li1">
                </c:if>
                <c:if test="${funcMap.yhgl != 0 }">
            <li style="display:block;" id="li1">
                </c:if>
                <div>
                    <div class="right_table" style="padding-left:10px;padding-right:10px;">
                        <div class="tj">
                            <span>账户</span><input id="loginName" type="text" class="right_ipu2"/>
                            <span>姓名</span><input id="userName" type="text" class="right_ipu2"/>
                            <span>状态</span><select id="zt" type="text" class="right_ipu2"/>
                            <option value="0">启用</option>
                            <option value="1">注销</option>
                            </select>
                            <c:if test="${funcMap.yhgl != 0 }">
                                <input type="button" name="button" value="查 询" class="iput_m" onclick="searchList()"/>
                            </c:if>
                            <c:if test="${funcMap.yhgl == 2 }">
                                <input type="button" name="button" value="创建" class="iput_m" onclick="g4()"/>
                            </c:if>
                        </div>
                    </div>
                    <br/>
                    <div title="" class="easyui-panel" iconCls="icon-redo" collapsible="true">
                        <table id="tableList"></table>
                    </div>
                </div>
            </li>

            <!--  1 end-->
            <!--  2 begin-->
            <li style="display:none;" id="li2">
                <div>
                    <div style="padding-left:10px;padding-right:10px;">
                        <div class="tj">
                            <span>权限名称</span><input id="roleName" type="text" class="right_ipu2">
                            <c:if test="${funcMap.qxgl != 0 }">
                                <input type="button" name="button" value="查 询" class="iput_m" onclick="searchList2()"/>
                            </c:if>
                            <c:if test="${funcMap.qxgl == 2 }">
                                <input type="button" name="button" value="创建" class="iput_m" onclick="g9()"/>
                            </c:if>
                        </div>
                        <br>
                        <div>
                            <table id="tableList2"></table>
                        </div>
                    </div>
                </div>
            </li>
            <!-- 修改密码 6 begin-->
            <li style="display:none;" id="li3">
                <div style=" height:483px;overflow-y:auto; overflow-x:auto;">
                    <div class="right_table">
                        <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                            <tbody>
                            <tr>
                                <th colspan="2" align="center" bgcolor="#f5f2ea">修改密码</th>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF">原密码</th>
                                <td bgcolor="#FFFFFF " style="text-align:left; ">
                                    &nbsp;<input type="password" id="oldPassword"
                                                 style="height:25px; border:1px solid #CCC;"/>
                                    <span style="color:red;">*</span>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF">新密码</th>
                                <td bgcolor="#FFFFFF " style="text-align:left; ">
                                    &nbsp;<input type="password" id="newPassword"
                                                 style="height:25px; border:1px solid #CCC;"/>
                                    <span style="color:red;">*</span>
                                </td>
                            </tr>
                            <tr>
                                <th bgcolor="#FFFFFF">确认密码</th>
                                <td bgcolor="#FFFFFF" style="text-align:left; "> &nbsp;<input type="password"
                                                                                              id="comPassword"
                                                                                              style="height:25px; border:1px solid #CCC;"/>
                                    <span style="color:red;">*</span>
                                </td>
                            </tr>
                            <tr>
                                <td height="33" colspan="2" bgcolor="#f5f2ea">
                                    <input type="button" onclick="changePwd()" name="button" value="确认" class="iput_m"
                                           style="height:25px;"/>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </li>

            <%--线路管理--%>
            <form id="myForm">
            <li style="display:none;" id="li4">
                &nbsp;&nbsp;<input style='float: left;border:0px;' id='file' name='file' type='file'/>
                <input type="button" name="button"  value="导入" class="iput_m" style="" onclick="importItems()"/>
                &nbsp;&nbsp;<a href="/static/template/所属线路导入模板.xls">下载模板</a>
            </li>
            </form>
        </ul>
    </div>
</div>
<script>
    /* 用户管理 */
    function seeUser(userId) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${ctx}/user/toSeeUserInfoView.action?userId=" + userId, null, " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");
    }

    function editUser(userId) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${ctx}/user/toAddUserInfoView.action?userId=" + userId, null, " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");
    }

    function delUser(userId) {
        var formdata = new FormData();
        formdata.append("userId", userId);
        if (!confirm("确认删除吗？")) {
            return;
        }
        $.ajax({
            url: '${ctx}/user/delUserInfo.action',
            type: 'POST',
            async: false,
            data: formdata,
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 0)
                    $('#tableList').datagrid("load");
            },
            error: function () {
                alert("页面加载错误！");
            }
        });
    }

    function getQueryParams() {
        var queryParams = new Object();
        queryParams.loginName = $('#loginName').val();
        queryParams.userName = $('#userName').val();
        queryParams.zt = $('#zt').val();
        return queryParams;
    }

    function searchList() {
        $('#tableList').datagrid('options').url = '/user/selectListUserInfo.action';
        $('#tableList').datagrid('options').queryParams = getQueryParams();
        $('#tableList').datagrid("load");
    }
    var yhglFunc = '${funcMap.yhgl}';
    var qxglFunc = '${funcMap.qxgl}';
    $(function () {
        $('#tableList').datagrid({
            //title:'用户管理',
            iconCls: 'icon-ok',
            /* url:listUrl, */
            queryParams: getQueryParams(),
            nowrap: false,
            striped: true,
            collapsible: false,
            fitColumns: true,
            pagination: true,
            singleSelect: true,
            rowsNumbers: true,
            remoteSort: true,
            pageList: [10, 15, 30, 50],
            pageSize: 10,//每页显示的记录条数，默认为10 
            idField: 'ID',
            columns: [[
                {field: 'user_id', align: "center", title: '员工号', width: 30, hidden: 'true'},
                {field: 'user_name', align: "center", title: '姓名', width: 30},
                {field: 'login_name', align: "center", title: '账号', width: 30},
                {field: 'user_type', align: "center", title: '账号类型', width: 30, formatter: function (value, row, index) {
                        var txt = '';
                        if (value == 0) {
                            txt = '管理员';
                        } else {
                            txt = '普通';
                        }
                        return txt;
                    }
                },
                {field: 'role_name', align: "center", title: '权限', width: 30},
                {field: 'phone', align: "center", title: '电话', width: 30},
                {field: 'email', align: "center", title: '邮箱', width: 30},
                {field: 'zw', align: "center", title: '管理区域', width: 60, formatter: function (value, row, index) {
                        var txt = '';
                        var arr = value.split(",");
                        for (let i = 0, length = arr.length; i < length; i++) {
                            var name = '';
                            if(arr[i]==1){ name = '石景山'; }
                            if(arr[i]==2){ name = '门头沟'; }
                            if(arr[i]==3){ name = '朝阳'; }
                            txt+=name+"  ";
                        }
                        return txt;
                    }
                },
                {field: 'zt', align: "center", title: '状态', width: 30, formatter: function (value, row, index) {
                        var txt = '';
                        if (value == 0) {
                            txt = '启用';
                        } else {
                            txt = '注销';
                        }
                        return txt;
                    }
                },
                {
                    field: 'trans', align: "left", title: '操作', width: 60, formatter: function (value, row, index) {
                        var txt0 = '<button href="javascript:void(0);" onclick="seeUser(\'' + row.user_id + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '查看' + '</button>';
                        var txt1 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="editUser(\'' + row.user_id + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '修改' + '</button>';
                        var txt2 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="delUser(\'' + row.user_id + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                        if (yhglFunc != 2){
                            return txt0;
                        } else {
                            return txt0+txt1 + txt2;
                        }
                    }
                },
            ]],
        });
        searchList();
    });
    /*用户管理结束*/
    /*权限管理 */
    function getQueryParams2() {
        var queryParams = new Object();
        queryParams.roleName = $('#roleName').val();
        return queryParams;
    }

    function searchList2() {
        $('#tableList2').datagrid('options').url = '${ctx}/role/selectListRoleInfo.action';
        $('#tableList2').datagrid('options').queryParams = getQueryParams2();
        $('#tableList2').datagrid("load");
    }

    function editRole(roleId) {
        var w = window.screen.width / 2 - 950 / 2;
        var t = window.screen.height / 2 - 600 / 2 - 35;
        window.open("${ctx}/role/toAddRoleInfoView.action?roleId=" + roleId, null, " height=500,width=1000,top=" + t + ",left=" + w + ",toolbar=no,menubar=no,localtion=no,scrollbars=no");
    }

    function delRole(roleId) {
        var formdata = new FormData();
        formdata.append("roleId", roleId);
        if (!confirm("确认删除吗？")) {
            return;
        }
        $.ajax({
            url: '${ctx}/role/delRoleInfo.action',
            type: 'POST',
            async: false,
            data: formdata,
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 0)
                    $('#tableList2').datagrid("load");
            },
            error: function (data) {
                alert(data.msg);
                alert("页面加载错误！");
            }
        });
    }

    function onLi1(){
        $("#a1").addClass('on').siblings().removeClass('on');
        $("#li1").show();
        $("#li2").hide();
        $("#li3").hide();
        $("#li4").hide();
    }
    function onLi2(){
        $("#a2").addClass('on').siblings().removeClass('on');
        $("#li1").hide();
        $("#li2").show();
        $("#li3").hide();
        $("#li4").hide();
        $('#tableList2').datagrid({
            iconCls: 'icon-ok',
            //queryParams: getQueryParams(),
            nowrap: false,
            striped: true,
            collapsible: false,
            fitColumns: true,
            pagination: true,
            singleSelect: true,
            rownumbers: true,
            remoteSort: true,
            pageList: [10, 15, 30, 50],
            pageSize: 10,//每页显示的记录条数，默认为10 
            idField: 'ID',
            columns: [[
                {field: 'roleId', align: "center", title: '角色Id', width: 30, hidden: true},
                {field: 'roleName', align: "center", title: '权限名称', width: 20},
                {field: 'beizhu', align: "center", title: '备注', width: 30},
                {
                    field: 'trans', align: "left", title: '操作', width: 30, formatter: function (value, row) {
                        var txt = '<button href="javascript:void(0);" onclick="editRole(\'' + row.roleId + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '修改' + '</button>';
                        var txt2 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="delRole(\'' + row.roleId + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                        if (qxglFunc != 2) return '';
                        return txt + txt2;
                    }
                },
            ]],
        });
        searchList2();
    }
    function onLi3(){
        $("#a3").addClass('on').siblings().removeClass('on');
        $("#li1").hide();
        $("#li2").hide();
        $("#li3").show();
        $("#li4").hide();
    }
    function onLi4(){
        $("#a4").addClass('on').siblings().removeClass('on');
        $("#li1").hide();
        $("#li2").hide();
        $("#li3").hide();
        $("#li4").show();
    }
    /*$(function () {
        $(".qh .tab a").click(function () {
            $(this).addClass('on').siblings().removeClass('on');
            var index = $(this).index();
            alert(index);
            $('.qh .content li').hide();
            $('.qh .content li:eq(' + index + ')').show();
            if (index == 1) {
                $('#tableList2').datagrid({
                    iconCls: 'icon-ok',
                    //queryParams: getQueryParams(),
                    nowrap: false,
                    striped: true,
                    collapsible: false,
                    fitColumns: true,
                    pagination: true,
                    singleSelect: true,
                    rownumbers: true,
                    remoteSort: true,
                    pageList: [10, 15, 30, 50],
                    pageSize: 10,//每页显示的记录条数，默认为10 
                    idField: 'ID',
                    columns: [[
                        {field: 'roleId', align: "center", title: '角色Id', width: 30, hidden: true},
                        {field: 'roleName', align: "center", title: '权限名称', width: 20},
                        {field: 'beizhu', align: "center", title: '备注', width: 30},
                        {
                            field: 'trans', align: "left", title: '操作', width: 30, formatter: function (value, row) {
                                var txt = '<button href="javascript:void(0);" onclick="editRole(\'' + row.roleId + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '修改' + '</button>';
                                var txt2 = '&nbsp;&nbsp;&nbsp;<button href="javascript:void(0);" onclick="delRole(\'' + row.roleId + '\')" class="iput_m" style="width: 40px; height: 20px;">' + '删除' + '</button>';
                                return txt + txt2;
                            }
                        },
                    ]],
                });
                searchList2();
            }
        });

        /!*权限管理结束  *!/
    });*/

    /* 修改密码 */
    function changePwd() {
        var formdata = new FormData(); // 模拟表单对象
        formdata.append("oldPassword", $("#oldPassword").val());
        formdata.append("newPassword", $("#newPassword").val());
        formdata.append("comPassword", $("#comPassword").val());
        $.ajax({
            url: '${ctx}/user/changePassword.action',
            type: 'POST',
            async: false,
            data: formdata,
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                alert(data.message);
            },
            error: function () {
                alert("页面加载错误！");
            }
        });
    }
</script>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>系统管理—用户管理——添加</title>
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <script src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
</head>
<script>
    $(function () {
        $.post("/sbZzlx/selectSingleSbZzlx",{keycode:'region'},function (data) {
            let ssqy = JSON.parse(data);
            var oldZw = "${userInfo.zw}";
            for (let i = 0, length = ssqy.length; i < length; i++) {
                if(oldZw.indexOf(ssqy[i].keyvalue) != -1){
                    $("#zw_ssqy").append("<input type='checkbox' name='zw_ssqy' checked value='" + ssqy[i].keyvalue + "'/>" + ssqy[i].keymemo);
                }else{
                    $("#zw_ssqy").append("<input type='checkbox' name='zw_ssqy' value='" + ssqy[i].keyvalue + "'/>" + ssqy[i].keymemo);
                }
            }
        });
    });

    function changeZwSsqy() {
        var type = $("#userType").val();
        if(type == 0){
            $("#lastRow").show();
            $("#qxRow").show();
        }else {
            $("[name='zw_ssqy']").removeAttr("checked");
            $("#lastRow").hide();
            $("#qxRow").hide();
        }
    }
</script>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm" action="/user/addUserInfo.action" method="post">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                <tbody>
                <c:if test="${userInfo == null }">
                    <tr>
                        <th colspan="2" align="center" bgcolor="#f5f2ea">添加</th>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF">姓名</th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="userName" id="userName"
                                   style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>账号</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="loginName" id="loginName"
                                   style="height:25px; border:1px solid #CCC;"/>
                            <span style="color:red;">*</span>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>账号类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="userType" id="userType" onchange="changeZwSsqy()" style="height:25px; border:1px solid #CCC;">
                                <option value="0">管理员</option>
                                <option value="1">普通</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="qxRow">
                        <th bgcolor="#FFFFFF"><p>权限</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="roleId" id="roleId" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="phone" id="phone" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>邮箱</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="email" id="email" style="height:25px; border:1px solid #CCC;"/>
                        </td>
                    </tr>
                    <tr id="lastRow">
                        <th bgcolor="#FFFFFF"><p>管理区域</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <span id="zw_ssqy"></span>
                        </td>
                    </tr>
                    <tr>
                        <td height="33" colspan="2" bgcolor="#f5f2ea">
                            <input type="button" name="button" value="确定" onclick="commit()" class="iput_m"
                                   style="height:25px;"/>
                            <input type="button" onclick="javascript:window.close();" name="button" value="关闭"
                                   class="iput_m" style="height:25px;"/>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${userInfo != null }">
                    <tr>
                        <th colspan="2" align="center" bgcolor="#f5f2ea">修改</th>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF">姓名</th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="hidden" name="userId" id="userId" value="${userInfo.userId}"/>
                            <input type="hidden" name="loginName" id="loginName" value="${userInfo.loginName}"/>
                            <input type="text" name="userName" id="userName" style="height:25px; border:1px solid #CCC;"
                                   value="${userInfo.userName}"/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>账号类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="userType" id="userType" onchange="changeZwSsqy()" style="height:25px; border:1px solid #CCC;">
                                <option value="0" <c:if test="${userInfo.userType == 0}">selected</c:if>>管理员</option>
                                <option value="1" <c:if test="${userInfo.userType == 1}">selected</c:if>>普通</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="qxRow">
                        <th bgcolor="#FFFFFF"><p>权限</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <select name="roleId" id="roleId" style="height:25px; border:1px solid #CCC;">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>密码</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="password" name="password" id="password" value="888888"
                                   style="height:25px; border:1px solid #CCC;"/>
                            <span style="color:red;">*</span>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="phone" id="phone" style="height:25px; border:1px solid #CCC;"
                                   value="${userInfo.phone}"/></td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>邮箱</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <input type="text" name="email" id="email" style="height:25px; border:1px solid #CCC;"
                                   value="${userInfo.email}"/></td>
                    </tr>
                    <tr id="lastRow">
                        <th bgcolor="#FFFFFF"><p>管理区域</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; ">
                            <span id="zw_ssqy"></span>
                            <%--<input type="text" name="zw" id="zw" style="height:25px; border:1px solid #CCC;"
                                   value="${userInfo.zw}"/></td>--%>
                    </tr>
                    <tr>
                        <td height="33" colspan="2" bgcolor="#f5f2ea">
                            <input type="button" name="button" id="button" value="确定" onclick="change()" class="iput_m"
                                   style="height:25px;"/>
                            <input type="button" onclick="javascript:window.close();" name="button" value="关闭"
                                   class="iput_m" style="height:25px;"/>
                        </td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </form>
    </div>
</div>
<script>
    $(function(){
            $.ajax({
                type:"post",
                dataType:"json",
                contentType:"application/json;charset=utf-8",
                url:"/role/queryAllRoleInfo.action",
                success:function(result){
                    $.each(result,function(index,value){
                        var roleId = '${userInfo.roleId}';
	            	if(roleId == value.role_id ){
	                	$("#roleId").append("<option value='"+value.role_id+"' selected>"+value.role_name+"</option>");
	            	}else{
	            		$("#roleId").append("<option value='"+value.role_id+"' >"+value.role_name+"</option>");
	            	}
	            })
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(errorThrown);
	    	},
	        async:false             //false表示同步
	     });
});

    function checkParameter() {
        var phoneFormat = /^1[3456789]\d{9}$/;
        var phone = $("#phone").val();
        if (phone != '') {
            if (!phoneFormat.test(phone)) {
                alert("请输入有效的手机号！");
                return false;
            }
        }

        //对电子邮件的验证
        var emailFormat = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        var email = $("#email").val();
        if (email != '') {
            if (!emailFormat.test(email)) {
                alert("请输入有效的邮箱地址！");
                return false;
            }
        }

        var loginName = $("#loginName").val();
        if (loginName == "") {
            alert("请输入账号！");
            return false;
        }

        var password = $("#password").val();
        if (password == "") {
            alert("请输入密码！");
            return false;
        }
        return true;
    }

    function getParam() {
        var formdata = new FormData(); // 模拟表单对象
        formdata.append("userName", $("#userName").val());
        formdata.append("loginName", $("#loginName").val());
        formdata.append("userType", $("#userType").val());
        formdata.append("roleId", $("#roleId").val());
        formdata.append("phone", $("#phone").val());
        formdata.append("email", $("#email").val());
        var zw_ssqy_array = [];
        $("input[name='zw_ssqy']:checked").each(function(i){
            zw_ssqy_array.push($(this).val())
        });
        formdata.append("zw", zw_ssqy_array);
        return formdata;
    }

    function commit() {
        if (!checkParameter()) return;
        $.ajax({
            url: '/user/addUserInfo.action',
            type: 'POST',
            async: false,
            data: getParam(),
            processData: false,
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 0) {
                    window.opener.location.reload();
                    window.close();
                }
            },
            error: function () {
                alert("页面加载错误！");
            }
        });
    }

    function change() {
        if (!checkParameter()) return;
        var formdata = getParam();
        formdata.append("userId", $("#userId").val());
        formdata.append("password", $("#password").val());
        $.ajax({
            url: '/user/updateUserInfo.action',
            type: 'POST',
            async: false,
            data: formdata,
            processData: false,
            contentType: false,
            beforeSend: function () {
                console.log("正在加载，请稍候");
            },
            success: function (data) {
                alert(data.message);
                if (data.code == 0) {
                    window.opener.location.reload();
                    window.close();
                }
            },
            error: function () {
                alert("页面加载错误！");
            }
        });
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>系统管理—用户管理——查看</title>
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
                    <tr>
                        <th colspan="4" align="center" bgcolor="#f5f2ea">查看</th>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF">姓名</th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <input type="text" name="userName" id="userName" style="height:25px; border:1px solid #CCC;"
                                   value="${userInfo.userName}" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>账号类型</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <select name="userType" id="userType" onchange="changeZwSsqy()" style="height:25px; border:1px solid #CCC;" disabled>
                                <option value="0" <c:if test="${userInfo.userType == 0}">selected</c:if>>管理员</option>
                                <option value="1" <c:if test="${userInfo.userType == 1}">selected</c:if>>普通</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="qxRow">
                        <th bgcolor="#FFFFFF"><p>权限</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <select name="roleId" id="roleId" style="height:25px; border:1px solid #CCC;" disabled>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#FFFFFF">标准管理</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="0" <c:if test="${funcMap.bzgl == 0 }">checked</c:if> disabled/>无权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="1" <c:if test="${funcMap.bzgl == 1 }">checked</c:if> disabled/>查看权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="2" <c:if test="${funcMap.bzgl == 2 }">checked</c:if> disabled/>编辑权限</td>
                    </tr>
                    <tr>
                        <td bgcolor="#FFFFFF">调试管理</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="0" <c:if test="${funcMap.tsgl == 0 }">checked</c:if> disabled/>无权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="1" <c:if test="${funcMap.tsgl == 1 }">checked</c:if> disabled/>查看权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="2" <c:if test="${funcMap.tsgl == 2 }">checked</c:if> disabled/>编辑权限</td>
                    </tr>
                    <tr>
                        <td bgcolor="#FFFFFF">设备管理</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="0" <c:if test="${funcMap.sbgl == 0 }">checked</c:if> disabled/>无权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="1" <c:if test="${funcMap.sbgl == 1 }">checked</c:if> disabled/>查看权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="2" <c:if test="${funcMap.sbgl == 2 }">checked</c:if> disabled/>编辑权限</td>
                    </tr>
                    <tr>
                        <td bgcolor="#FFFFFF">处缺管理</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="0" <c:if test="${funcMap.cqgl == 0 }">checked</c:if> disabled/>无权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="1" <c:if test="${funcMap.cqgl == 1 }">checked</c:if> disabled/>查看权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="2" <c:if test="${funcMap.cqgl == 2 }">checked</c:if> disabled/>编辑权限</td>
                    </tr>
                    <tr>
                        <td bgcolor="#FFFFFF">用户管理</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="0" <c:if test="${funcMap.yhgl == 0 }">checked</c:if> disabled/>无权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="1" <c:if test="${funcMap.yhgl == 1 }">checked</c:if> disabled/>查看权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="2" <c:if test="${funcMap.yhgl == 2 }">checked</c:if> disabled/>编辑权限</td>
                    </tr>
                    <tr>
                        <td bgcolor="#FFFFFF">权限管理</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="0" <c:if test="${funcMap.qxgl == 0 }">checked</c:if> disabled/>无权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="1" <c:if test="${funcMap.qxgl == 1 }">checked</c:if> disabled/>查看权限</td>
                        <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="2" <c:if test="${funcMap.qxgl == 2 }">checked</c:if> disabled/>编辑权限</td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>密码</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <input type="password" name="password" id="password" value="888888"
                                   style="height:25px; border:1px solid #CCC;" readonly/>
                        </td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>电话</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <input type="text" name="phone" id="phone" style="height:25px; border:1px solid #CCC;"
                                   value="${userInfo.phone}" readonly/></td>
                    </tr>
                    <tr>
                        <th bgcolor="#FFFFFF"><p>邮箱</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <input type="text" name="email" id="email" style="height:25px; border:1px solid #CCC;"
                                   value="${userInfo.email}" readonly/></td>
                    </tr>
                    <tr id="lastRow">
                        <th bgcolor="#FFFFFF"><p>管理区域</p></th>
                        <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                            <span id="zw_ssqy"></span>
                    </tr>
                    <tr>
                        <td height="33" bgcolor="#f5f2ea" colspan="4">
                            <input type="button" onclick="javascript:window.close();" name="button" value="关闭"
                                   class="iput_m" style="height:25px;"/>
                        </td>
                    </tr>
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
	                	$("#roleId").append("<option value='"+value.role_id+"' selected disabled>"+value.role_name+"</option>");
	            	}else{
	            		$("#roleId").append("<option value='"+value.role_id+"' disabled>"+value.role_name+"</option>");
	            	}
	            })
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(errorThrown);
	    	},
	        async:false             //false表示同步
	     });
});
</script>
</body>
</html>

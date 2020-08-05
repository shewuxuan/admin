<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="../import.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>系统管理—-权限管理--添加</title>
    <link rel="stylesheet" type="text/css" href="/style/wholemain.css"/>
    <script src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
            <tbody>
            <c:if test="${roleInfo == null }">
                <tr>
                    <th colspan="4" align="center" bgcolor="#f5f2ea">添加</th>
                </tr>
                <tr>
                    <th bgcolor="#FFFFFF" width="15%">权限名称</th>
                    <td bgcolor="#FFFFFF " style="text-align:left; " colspan="3">
                        <input type="text" name="roleName" id="roleName" style="height:25px; border:1px solid #CCC;"/>
                        <span style="color:red;">*</span>
                    </td>
                </tr>
                s
                <tr>
                    <th bgcolor="#FFFFFF">备注</th>
                    <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                        <textarea name="remark" id="remark" style="border:1px solid #CCC;" rows="5"
                                  cols="100"></textarea>
                    </td>
                </tr>
               <tr>
                    <td bgcolor="#FFFFFF">标准管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="0"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="2"  checked="checked"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">调试管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="0"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="2" checked="checked"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">设备管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="0"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="2" checked="checked"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">处缺管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="0"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="2" checked="checked"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">用户管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="0"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="2" checked="checked"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">权限管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="0"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="2" checked="checked"/> 编辑权限</td>
                </tr>
                <tr>
                    <td height="33" colspan="4" bgcolor="#f5f2ea">
                        <input type="button" onclick="commit();" name="button" id="button" value="确定" class="iput_m"
                               style="height:25px;"/>
                        <input type="submit" onclick="javascript:window.close();" name="button" value="返回"
                               class="iput_m" style="height:25px;"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${roleInfo != null }">
                <tr>
                    <th colspan="4" align="center" bgcolor="#f5f2ea">修改</th>
                </tr>
                <tr>
                    <th bgcolor="#FFFFFF width="15%"">权限名称</th>
                    <td bgcolor="#FFFFFF " style="text-align:left; " colspan="3">
                        <input type="hidden" name="roleId" id="roleId" value="${roleInfo.roleId}"/>
                        <input type="text" name="roleName" id="roleName" value="${roleInfo.roleName}"
                               style="height:25px; border:1px solid #CCC;"/>
                    </td>
                </tr>
                <tr>
                    <th bgcolor="#FFFFFF">备注</th>
                    <td bgcolor="#FFFFFF" style="text-align:left; " colspan="3">
                        <textarea name="remark" id="remark" style="border:1px solid #CCC;" rows="5"
                                  cols="100">${roleInfo.beizhu}</textarea>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">标准管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="0" <c:if test="${roleFuncList.bzgl == 0 }">checked</c:if>/>无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="1" <c:if test="${roleFuncList.bzgl == 1 }">checked</c:if>/>查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="bzgl" value="2" <c:if test="${roleFuncList.bzgl == 2 }">checked</c:if>/>编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">调试管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="0" <c:if test="${roleFuncList.tsgl == 0 }">checked</c:if>/>无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="1" <c:if test="${roleFuncList.tsgl == 1 }">checked</c:if>/>查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tsgl" value="2" <c:if test="${roleFuncList.tsgl == 2 }">checked</c:if>/>编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">设备管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="0" <c:if test="${roleFuncList.sbgl == 0 }">checked</c:if>/>无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="1" <c:if test="${roleFuncList.sbgl == 1 }">checked</c:if>/>查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="sbgl" value="2" <c:if test="${roleFuncList.sbgl == 2 }">checked</c:if>/>编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">处缺管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="0" <c:if test="${roleFuncList.cqgl == 0 }">checked</c:if>/>无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="1" <c:if test="${roleFuncList.cqgl == 1 }">checked</c:if>/>查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cqgl" value="2" <c:if test="${roleFuncList.cqgl == 2 }">checked</c:if>/>编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">用户管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="0" <c:if test="${roleFuncList.yhgl == 0 }">checked</c:if>/>无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="1" <c:if test="${roleFuncList.yhgl == 1 }">checked</c:if>/>查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="2" <c:if test="${roleFuncList.yhgl == 2 }">checked</c:if>/>编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">权限管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="0" <c:if test="${roleFuncList.qxgl == 0 }">checked</c:if>/>无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="1" <c:if test="${roleFuncList.qxgl == 1 }">checked</c:if>/>查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="qxgl" value="2" <c:if test="${roleFuncList.qxgl == 2 }">checked</c:if>/>编辑权限</td>
                </tr>
                <tr>
                    <td height="33" colspan="4" bgcolor="#f5f2ea">
                        <input type="button" onclick="change();" name="button" id="button" value="修改" class="iput_m"
                               style="height:25px;"/>
                        <input type="submit" onclick="javascript:window.close();" name="button" value="返回"
                               class="iput_m" style="height:25px;"/>
                    </td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
<script>
    function getParam() {
        var formdata = new FormData(); // 模拟表单对象
        formdata.append("roleName", $("#roleName").val());
        formdata.append("remark", $("#remark").val());
        formdata.append("bzgl", $("input[name='bzgl']:checked").val());
        formdata.append("tsgl", $("input[name='tsgl']:checked").val());
        formdata.append("sbgl", $("input[name='sbgl']:checked").val());
        formdata.append("cqgl", $("input[name='cqgl']:checked").val());
        formdata.append("yhgl", $("input[name='yhgl']:checked").val());
        formdata.append("qxgl", $("input[name='qxgl']:checked").val());
        return formdata;
    }

    function commit() {
        $.ajax({
            url: '${ctx}/role/addRoleInfo.action',
            type: 'POST',
            async: false,
            data: getParam(),
            // 告诉jQuery不要去处理发送的数据
            processData: false,
            // 告诉jQuery不要去设置Content-Type请求头
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
        var formdata = getParam();
        formdata.append("roleId", $("#roleId").val());
        $.ajax({
            url: '${ctx}/role/updeatRoleInfo.action',
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

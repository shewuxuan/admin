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
                    <th bgcolor="#FFFFFF">角色名称</th>
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
               <%-- <tr>
                    <td bgcolor="#FFFFFF">项目信息</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmxx" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmxx" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmxx" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">采购计划</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cgjh" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cgjh" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cgjh" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目招标</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmzb" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmzb" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmzb" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目预算</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目合同</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmht" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmht" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmht" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目验收</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys2" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys2" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys2" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">登记资产</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="djzc" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="djzc" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="djzc" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目付款</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmfk" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmfk" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmfk" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">批复管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="pfgl" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="pfgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="pfgl" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">统计汇总</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tjhz" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tjhz" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tjhz" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">用户管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">角色管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="jsgl" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="jsgl" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="jsgl" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目日志</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmrz" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmrz" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmrz" value="2"/> 编辑权限</td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">操作日志</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="czrz" value="0" checked="checked"/> 无权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="czrz" value="1"/> 查看权限</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="czrz" value="2"/> 编辑权限</td>
                </tr>--%>
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
                    <th bgcolor="#FFFFFF">角色名称</th>
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
                <%--<tr>
                    <td bgcolor="#FFFFFF">项目信息</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmxx" value="0"
                                                 <c:if test="${roleFuncList.xmxx == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmxx" value="1"
                                                 <c:if test="${roleFuncList.xmxx == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmxx" value="2"
                                                 <c:if test="${roleFuncList.xmxx == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">采购计划</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cgjh" value="0"
                                                 <c:if test="${roleFuncList.cgjh == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cgjh" value="1"
                                                 <c:if test="${roleFuncList.cgjh == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="cgjh" value="2"
                                                 <c:if test="${roleFuncList.cgjh == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目招标</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmzb" value="0"
                                                 <c:if test="${roleFuncList.xmzb == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmzb" value="1"
                                                 <c:if test="${roleFuncList.xmzb == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmzb" value="2"
                                                 <c:if test="${roleFuncList.xmzb == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目预算</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys" value="0"
                                                 <c:if test="${roleFuncList.xmys == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys" value="1"
                                                 <c:if test="${roleFuncList.xmys == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys" value="2"
                                                 <c:if test="${roleFuncList.xmys == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目合同</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmht" value="0"
                                                 <c:if test="${roleFuncList.xmht == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmht" value="1"
                                                 <c:if test="${roleFuncList.xmht == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmht" value="2"
                                                 <c:if test="${roleFuncList.xmht == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目验收</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys2" value="0"
                                                 <c:if test="${roleFuncList.xmys2 == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys2" value="1"
                                                 <c:if test="${roleFuncList.xmys2 == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmys2" value="2"
                                                 <c:if test="${roleFuncList.xmys2 == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">登记资产</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="djzc" value="0"
                                                 <c:if test="${roleFuncList.djzc == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="djzc" value="1"
                                                 <c:if test="${roleFuncList.djzc == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="djzc" value="2"
                                                 <c:if test="${roleFuncList.djzc == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目付款</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmfk" value="0"
                                                 <c:if test="${roleFuncList.xmfk == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmfk" value="1"
                                                 <c:if test="${roleFuncList.xmfk == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmfk" value="2"
                                                 <c:if test="${roleFuncList.xmfk == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">批复管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="pfgl" value="0"
                                                 <c:if test="${roleFuncList.pfgl == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="pfgl" value="1"
                                                 <c:if test="${roleFuncList.pfgl == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="pfgl" value="2"
                                                 <c:if test="${roleFuncList.pfgl == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">统计汇总</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tjhz" value="0"
                                                 <c:if test="${roleFuncList.tjhz == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tjhz" value="1"
                                                 <c:if test="${roleFuncList.tjhz == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="tjhz" value="2"
                                                 <c:if test="${roleFuncList.tjhz == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">用户管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="0"
                                                 <c:if test="${roleFuncList.yhgl == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="1"
                                                 <c:if test="${roleFuncList.yhgl == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="yhgl" value="2"
                                                 <c:if test="${roleFuncList.yhgl == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">角色管理</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="jsgl" value="0"
                                                 <c:if test="${roleFuncList.jsgl == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="jsgl" value="1"
                                                 <c:if test="${roleFuncList.jsgl == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="jsgl" value="2"
                                                 <c:if test="${roleFuncList.jsgl == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">项目日志</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmrz" value="0"
                                                 <c:if test="${roleFuncList.xmrz == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmrz" value="1"
                                                 <c:if test="${roleFuncList.xmrz == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="xmrz" value="2"
                                                 <c:if test="${roleFuncList.xmrz == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>
                <tr>
                    <td bgcolor="#FFFFFF">操作日志</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="czrz" value="0"
                                                 <c:if test="${roleFuncList.czrz == 0 }">checked</c:if>/> 无权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="czrz" value="1"
                                                 <c:if test="${roleFuncList.czrz == 1 }">checked</c:if>/> 查看权限
                    </td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="czrz" value="2"
                                                 <c:if test="${roleFuncList.czrz == 2 }">checked</c:if>/> 编辑权限
                    </td>
                </tr>--%>
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
        formdata.append("xmxx", $("input[name='xmxx']:checked").val());
        formdata.append("cgjh", $("input[name='cgjh']:checked").val());
        formdata.append("xmzb", $("input[name='xmzb']:checked").val());
        formdata.append("xmys", $("input[name='xmys']:checked").val());

        formdata.append("xmht", $("input[name='xmht']:checked").val());
        formdata.append("xmys2", $("input[name='xmys2']:checked").val());
        formdata.append("djzc", $("input[name='djzc']:checked").val());
        formdata.append("xmfk", $("input[name='xmfk']:checked").val());

        formdata.append("pfgl", $("input[name='pfgl']:checked").val());
        formdata.append("tjhz", $("input[name='tjhz']:checked").val());
        formdata.append("yhgl", $("input[name='yhgl']:checked").val());
        formdata.append("jsgl", $("input[name='jsgl']:checked").val());

        formdata.append("xmrz", $("input[name='xmrz']:checked").val());
        formdata.append("czrz", $("input[name='czrz']:checked").val());
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

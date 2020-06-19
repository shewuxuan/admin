<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改标准——定值检查</title>                    <!-- 改-->
    <link rel="stylesheet" type="text/css" href="${basePath}/static/style/wholemain.css"/>
    <script type="text/javascript" src="${basePath}/static/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="${basePath}/static/js/bignumber.min.js"></script>
</head>
</head>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                <tbody>

                <tr>
                    <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;"></select>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>间隔</p></th>        <!-- 改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="jg" id="jg" style="height:25px; width: 99%; border:1px solid #CCC;"/>
                        <!-- 改-->
                    </td>
                </tr>

                <tr>
                    <td height="33" colspan="2" bgcolor="#f5f2ea">
                        <input type="button" name="button" value="确定" onclick="commit()" class="iput_m"
                               style="height:25px;"/>
                        <input type="button" onclick="window.close();" name="button" value="关闭"
                               class="iput_m" style="height:25px;"/>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        // 获取当前id的标准信息
        let id = "${requestScope.id}";
        $.get("${basePath}/pwbh_bz_dzjc/selectByPrimaryKey/" + id, function (data) {		// 改
            let bz = JSON.parse(data).data;
            $("#jg").val(bz.jg);		// 改

            // 给所属区域赋值，并选中
            $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
                data = JSON.parse(data);
                $.each(data, function (i) {
                    if (bz.ssqy === data[i].keyvalue) {
                        $("#ssqy").append("<option value='" + data[i].keyvalue + "' selected>" + data[i].keymemo + "</option>");
                    } else {
                        $("#ssqy").append("<option value='" + data[i].keyvalue + "'>" + data[i].keymemo + "</option>");
                    }
                })
            });
        });
    });
</script>

<script type="text/javascript">
    <%-- 提交表单 --%>
    function commit() {
        let ssqy = $("#ssqy").val();
        let jg = $("#jg").val();
        if (jg === "" || jg == null || jg.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("间隔不能为空！");
            $("#jg").focus();
            return false;
        } else {
            let data = {"id": "${requestScope.id}", "ssqy": ssqy, "jg": jg}
            $.ajax({
                type: 'POST',
                processData: false, // 告诉jquery不要处理数据
                data: JSON.stringify(data),//必须
                contentType: "application/json;charsetset=UTF-8",//必须
                dataType: "json",//必须
                url: '${basePath}/pwbh_bz_dzjc/updateByPrimaryKey',		// 改
                success: function (data) {
                    if (data.code === 0) {
                        alert("修改成功！");
                        window.opener.location.reload();
                        window.close();
                    } else {
                        alert("修改失败, 请重试！");
                        // window.opener.location.reload();
                        // window.close();
                    }
                }
            })
        }
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>创建标准——绝缘电阻</title>
    <link rel="stylesheet" type="text/css" href="/static/style/wholemain.css"/>
    <script type="text/javascript" src="/static/js/jquery-1.12.3.min.js"></script>
</head>
</head>
<body>
<div class="right_main">
    <div class="right_table" style="width:96%;">
        <form name="myForm" id="myForm" action="${basePath}/ssqy/selectSsqyByAll" method="post">
            <table width="100%" cellpadding="0" cellspacing="1" bgcolor="#c6c6c6">
                <tbody>

                <tr>
                    <th bgcolor="#FFFFFF"><p>所属区域</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <select name="ssqy" id="ssqy" style="height:25px; border:1px solid #CCC;">
                        </select>
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>被测回路</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="bchl" id="bchl"
                               style="height:25px;width: 99%; border:1px solid #CCC;"/></td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>试验电压（伏）</p></th>
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="sydy" id="sydy"
                               style="height:25px;width: 99%; border:1px solid #CCC;"/></td>
                </tr>

                <tr>
                    <td height="33" colspan="2" bgcolor="#f5f2ea">
                        <input type="button" name="button" value="确定" onclick="commit()" class="iput_m"
                               style="height:25px;"/>
                        <input type="button" onclick="javascript:window.close();" name="button" value="关闭"
                               class="iput_m" style="height:25px;"/>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>
    </div>
</div>

<script type="text/javascript">
    <%--所属区域	--%>
    $(function () {
        $.get("${basePath}/ssqy/selectSsqyByAll", function (data) {
            var ssqy = JSON.parse(data);
            for (var i = 0, length = ssqy.length; i < length; i++) {
                $("#ssqy").append("<option value='" + ssqy[i].keyvalue + "'>" + ssqy[i].keymemo + "</option>");
            }
        });
    });
</script>

<script type="text/javascript">
    <%-- 提交表单 --%>

    function commit() {
        let bchl = $("#bchl").val();
        let sydy = $("#sydy").val();
        if (bchl === "" || bchl == null || bchl.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("被测回路不能为空！");
            $("#bchl").focus();
            return false;
        } else if (sydy === "" || sydy == null || sydy.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("试验电压不能为空！");
            $("#sydy").focus();
            return false;
        } else {
            let data = new FormData($(".myForm")[0]);
            data.append("ssqy", $("#ssqy").val());
            data.append("bchl", bchl);
            data.append("sydy", sydy);

            $.ajax({
                type: 'POST',
                processData: false, // 告诉jquery不要处理数据
                contentType: false, // 告诉jquery不要设置contentType
                data: data,
                url: '${basePath}/bzjydz/insert',
                success: function (data) {
                    if (data == 1) {
                        alert("添加成功！");
                        window.opener.location.reload();
                        window.close();
                    } else {
                        alert("添加失败！");
                        window.opener.location.reload();
                        window.close();
                    }
                }
            })
        }
    }
</script>
</body>
</html>

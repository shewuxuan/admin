<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../../import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>创建标准——功能测试标准</title>             <!-- 改-->
    <link rel="stylesheet" type="text/css" href="/static/style/wholemain.css"/>
    <script type="text/javascript" src="/static/js/jquery-1.12.3.min.js"></script>
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
                    <th bgcolor="#FFFFFF"><p>测试功能</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="csgn" id="csgn" style="height:25px;width: 99%; border:1px solid #CCC;"/>
                        <!--改-->
                    </td>
                </tr>

                <tr>
                    <th bgcolor="#FFFFFF"><p>技术标准或测试要求</p></th>                <!--改-->
                    <td bgcolor="#FFFFFF" style="text-align:left; ">
                        <input type="text" name="jsbz" id="jsbz" style="height:25px;width: 99%; border:1px solid #CCC;"/>
                        <!--改-->
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
        let csgn = $("#csgn").val();
        let jsbz = $("#jsbz").val();
        if (csgn === "" || csgn == null || csgn.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("测试功能不能为空！");
            $("#csgn").focus();
            return false;
        } else if (jsbz === "" || jsbz == null || jsbz.replace(/(^\s*)|(\s*$)/g, "") === "") {
            alert("技术标准或测试要求不能为空！");
            $("#jsbz").focus();
            return false;
        } else {
            let data = {                                        // 改
                "ssqy": $("#ssqy").val(),
                "csgn": csgn,
                "jsbz": jsbz
            };

            $.ajax({
                type: 'POST',
                processData: false, // 告诉jquery不要处理数据
                data: JSON.stringify(data),//必须
                contentType: "application/json;charsetset=UTF-8",//必须
                dataType: "json",//必须
                url: '${basePath}/ftu_bz_gncs/insert',			// 改
                success: function (data) {
                    alert(data.msg);
                    window.opener.location.reload();
                    window.close();
                }
            })
        }
    }
</script>
</body>
</html>
